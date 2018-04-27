package com.iyungu.mall.bean.vo;

/**
 * @Author: yueyang@iyungu.com
 * @Description:
 * @Date: Created in 12:53 2018/4/18
 * @Modified By:
 */
public class ResponseBody {

    private String code = "BDC0001";

    private String msg = "success";

    private Object result = null;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getResult() {
        return result;
    }

    public ResponseBody(Object result) {
        this.result = result;
    }

    public ResponseBody(String code, String message, Object result) {
        this.result = result;
        this.code = code;
        this.msg = message;
    }
}
