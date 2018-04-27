package com.iyungu.mall.action;

import com.alibaba.druid.support.json.JSONUtils;
import com.iyungu.mall.bean.vo.ResponseBody;
import io.vertx.ext.web.RoutingContext;

/**
 * @Author: yueyang@iyungu.com
 * @Description:
 * @Date: Created in 11:49 2018/4/18
 * @Modified By:
 */
@Deprecated
public abstract class AbstractContoller {

    protected RoutingContext routingContext = null;

    public abstract void setApi();

    public static void succeeded(RoutingContext routingContext, Object result) {
        ResponseBody responseBody = new ResponseBody(result);
        routingContext.response()
                .setStatusCode(200)
                .putHeader("content-type", "application/json")
                .end(JSONUtils.toJSONString(responseBody));
    }

    public static void succeeded(RoutingContext routingContext, Integer statusCode, ResponseBody responseBody) {
        routingContext.response()
                .setStatusCode(statusCode)
                .putHeader("content-type", "application/json")
                .end(JSONUtils.toJSONString(responseBody));
    }
}
