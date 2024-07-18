package com.hao.library.mvc.web.interceptor;

import com.hao.base.common.login.ClientTokenUtil;
import com.hao.base.common.login.LoginInterceptorAdapter;
import com.hao.base.common.login.ServerTokenType;

public class LoginInterceptor extends LoginInterceptorAdapter<UserId> {

    public static final ServerTokenType ADMIN_TOKEN = new ServerTokenType("ADMIN:");

    @Override
    public UserId tokenToId(String token) {

        if (ClientTokenUtil.validate(token)) {
            // 是 reader
            long readerId = Long.parseLong(ClientTokenUtil.getSub(token));
            return new UserId(readerId, false);
        }

        Long adminId = ADMIN_TOKEN.userId(token);

        if (adminId != null) {
            return new UserId(adminId, true);
        }

        return null;
    }

    @Override
    public void onSuccess(UserId userId) {
        UserIdThreadLocal.set(userId);
    }

    @Override
    public void onExit() {
        UserIdThreadLocal.remove();
    }
}
