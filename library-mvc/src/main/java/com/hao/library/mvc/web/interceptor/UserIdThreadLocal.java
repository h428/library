package com.hao.library.mvc.web.interceptor;

public class UserIdThreadLocal {

    private static final ThreadLocal<UserId> LOCAL = new ThreadLocal<>();

    private UserIdThreadLocal() {

    }

    public static void set(UserId userId) {
        LOCAL.set(userId);
    }

    public static UserId get() {
        return LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }

}
