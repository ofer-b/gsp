package org.hp.com;

/**
 * Created by borshtei on 31-Jul-14.
 */
public final class GspApi {

    private GspApi() {
    }


    public static <T> T getBean(Class<T> tClass) {

        return SpringApplicationContext.getBean(tClass);
    }
}
