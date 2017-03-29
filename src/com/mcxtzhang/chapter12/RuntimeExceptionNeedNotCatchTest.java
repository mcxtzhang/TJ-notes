package com.mcxtzhang.chapter12;

/**
 * Intro: RuntimeException是一个例外， 这种异常，不需要catch or throws
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/28.
 * History:
 */
public class RuntimeExceptionNeedNotCatchTest {
    public static void main(String[] args) throws CstException {
        //throw new RuntimeException("RuntimeException是一个例外，这种异常，不需要catch");
        throw new CstException("别的异常需要catch  or throws");
    }

    static class CstException extends Exception {
        public CstException(String s) {
            super(s);
        }
    }


}
