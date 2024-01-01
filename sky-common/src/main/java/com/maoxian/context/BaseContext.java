package com.maoxian.context;

/**
 * @author Lin
 * @date 2024/1/1 9:38
 */
public class BaseContext {
    private static final ThreadLocal<Long> THREAD_LOCAL = new ThreadLocal<>();

    public static void setCurrentId(Long id){
        THREAD_LOCAL.set(id);
    }

    public static Long getCurrentId(){
        return THREAD_LOCAL.get();
    }

    public static void removeCurrentId(){
        THREAD_LOCAL.remove();
    }
}
