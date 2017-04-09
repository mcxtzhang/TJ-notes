package com.mcxtzhang.ejchap1;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/9.
 * History:
 */
public class FinalizeTest {
    //终结方法守卫者
    private final Object finalizerGuardian = new Object() {
        @Override
        protected void finalize() throws Throwable {
            //在这里调用外围实例的finalize
            FinalizeTest.this.finalize();
        }
    };


    //子类正确姿势
    @Override
    protected void finalize() throws Throwable {
        try {
            //finalize自己
        } finally {
            super.finalize();
        }
    }


}
