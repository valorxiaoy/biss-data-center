package com.iyungu.auth.controlle;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.AbstractUser;
import io.vertx.ext.auth.AuthProvider;
import io.vertx.ext.auth.User;

/**
 * @Author: yueyang@iyungu.com
 * @Description:
 * @Date: Created in 14:10 2018/4/26
 * @Modified By:
 */
public class OAuthController implements AuthProvider {

    @Override
    public void authenticate(JsonObject jsonObject, Handler<AsyncResult<User>> handler) {
        AbstractUser abstractUser = new AbstractUser();
    }
}