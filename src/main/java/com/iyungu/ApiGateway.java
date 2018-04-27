package com.iyungu;

import com.iyungu.annotation.AnnoManageUtil;
import com.iyungu.annotation.ExecutorBean;
import com.iyungu.annotation.RequestMapping;
import com.iyungu.mall.bean.vo.ResponseBody;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * @Author: yueyang@iyungu.com
 * @Description:
 * @Date: Created in 12:05 2018/4/17
 * @Modified By:
 */
public class ApiGateway extends AbstractVerticle {

    public static Router router = null;

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        router = Router.router(vertx);
        initRouter(router);
        vertx.createHttpServer().requestHandler(router::accept)
                .listen(
                        config().getInteger("http.port", 8080),
                        result -> {
                            if (result.succeeded()) {
                                startFuture.complete();
                            } else {
                                startFuture.fail(result.cause());
                            }
                        }
                );

    }

    public static Map<String, ExecutorBean> mmap = AnnoManageUtil.getRequestMappingMethod("com.iyungu.mall.action");

    public static void main(String[] args) {
        ApiGateway apiContoller = new ApiGateway();
        apiContoller.initRouter();
    }

    public void initRouter() {
        router = Router.router(vertx);
        initRouter(router);
        Vertx vertx = Vertx.vertx();
        Vertx.vertx().createHttpServer().requestHandler(router::accept).listen(8080);
    }

    /**
     * @Author: yueyang@iyungu.com
     * @Description:
     * @Params:
     *   @param: router
     * @Return: void
     * @Throws:
     * @Date: Created in 10:03 2018/4/23
     */
    private static void initRouter(Router router) {
        router.route("/api/route*").handler(BodyHandler.create());
        router.post("/api/route/:mm/:aa/:bb").handler(ApiGateway::route);
        router.put("/api/route/:mm/:aa/:bb").handler(ApiGateway::route);
        router.delete("/api/route/:mm/:aa/:bb").handler(ApiGateway::route);
        router.get("/api/route/:id").handler(ApiGateway::route);
    }

    /**
     * @Author: yueyang@iyungu.com
     * @Description: 处理请求 - 路由器
     * @Params:
     *   @param: routingContext
     * @Return: void
     * @Throws:
     * @Date: Created in 9:24 2018/4/24
     */
    public static void route(RoutingContext routingContext) {
        // 获取请求对象
        HttpServerRequest httpServerRequest = routingContext.request();
        // 获取请求类型
        String requestType = httpServerRequest.method().name();
        // 获取地址栏参数
        MultiMap multiMap = httpServerRequest.params();
        // 获取指定的请求方法
        String requestMethod = multiMap != null && !multiMap.get("mm").isEmpty() ? multiMap.get("mm") : "";
        // 获取指定调用的对象
        ExecutorBean executorBean = getExecutorBean(requestMethod);
        // 获取Body参数
        Map<String, Object> params = !"GET".equals(requestType) ? routingContext.getBodyAsJson().getMap() : null;
        // 获取方法执行结果
        Object[] results = getResults(executorBean, multiMap, params);
        // 响应处理结果
        responseResult(routingContext,executorBean, results);
    }

    /**
     * @Author: yueyang@iyungu.com
     * @Description:
     * @Params:
     *   @param: executorBean 指定调用的处理方法
     *   @param: multiMap 地址栏参数列表
     *   @param: params 表单参数列表
     * @Return: java.lang.Object[] 处理结果集
     * @Throws:
     * @Date: Created in 9:49 2018/4/23
     */
    private static Object[] getResults(ExecutorBean executorBean, MultiMap multiMap, Map<String, Object> params) {
        // 获取调用对象的方法参数列表
        Parameter[] parameters = executorBean.getMethod().getParameters();
        if (parameters == null || parameters.length <= 0) {
            return null;
        } else {
            // 获取方法的参数列表
            Object[] results = new Object[parameters.length];
            // 获取参数值
            int index = parameters.length;
            for (int i = 0; i < index; i++) {
                Parameter parameter = parameters[i];
                // 获取参数名称
                String parameterName = parameter.getName();
                // 获取参数值
                Object value = !multiMap.isEmpty() ? multiMap.get(parameterName) : params.get(parameterName);
                if (value != null) {
                    results[i] = value;
                }
            }
            return results;
        }
    }

    /**
     * @Author: yueyang@iyungu.com
     * @Description:
     * @Params:
     *   @param: multiMap 地址栏参数列表
     * @Return: com.iyungu.annotation.ExecutorBean 指定调用的处理方法
     * @Throws:
     * @Date: Created in 9:50 2018/4/23
     */
    private static ExecutorBean getExecutorBean(String method) {
        ExecutorBean bean = mmap.get(method);
        try {
            if (bean == null) {
                throw new Exception("调用方法不存在");
            }
        } catch (Exception e) {
            System.out.println("调用方法不存在");
            // TODO 新增异常响应处理
        }
        return bean;
    }

    /**
     * @Author: yueyang@iyungu.com
     * @Description:
     * @Params:
     *   @param: routingContext 路由器上下文
     *   @param: bean 指定调用的处理方法
     *   @param: results 处理结果集
     * @Return: void
     * @Throws:
     * @Date: Created in 9:54 2018/4/23
     */
    public static void responseResult(RoutingContext routingContext, ExecutorBean bean, Object[] results) {
        try {
            Object object = null;
            if (results != null && results.length > 0) {
                object = bean.getMethod().invoke(bean.getObject(), results);
            } else {
                object = bean.getMethod().invoke(bean.getObject());
            }
            RequestMapping annotation = bean.getMethod().getAnnotation(RequestMapping.class);
            System.out.println("注解名称：" + annotation.name() + "\t注解描述：" + annotation.description());

            ResponseBody responseBody = new ResponseBody(object);
            routingContext.response()
                    .setStatusCode(200)
                    .putHeader("content-type", "application/json")
                    .end(Json.encodePrettily(responseBody));

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
