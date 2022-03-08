package com.dx.kotlinlib.design;

/**
 * Created By dx on 2022/1/31 11 34
 */
class SInstance {
    private static volatile SInstance singleTon = null;

    static SInstance getInstance() {
        if (singleTon == null) {
            synchronized (SInstance.class) { //避免排着队去创建
                if (singleTon != null) {
                    singleTon = new SInstance();
                }
            }
        }
        return singleTon;
    }
}
