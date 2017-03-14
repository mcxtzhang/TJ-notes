package com.mcxtzhang.chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Intro:  Future Callable
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/14.
 * History:
 */
public class example5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            //Callable必须用submit提交，接收的返回值是  Future<String>
            Future<String> submit = executorService.submit(new TestCallable());
            results.add(submit);
        }

        System.out.println("开始寻找结果");
        for (Future<String> result : results) {
            try {

                //通过 get()拿到结果 可能会阻塞
                //也就是说这里是同步的
                System.out.println(result.get() + "," + Thread.currentThread());

            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                //shutdown()后就不接新客了
                executorService.shutdown();
            }
        }

        System.out.println("main 退出了");
    }
}

class TestCallable implements Callable<String> {
    private static int index = 0;
    private final int id = index++;

    public TestCallable() {

    }

    @Override
    public String call() throws Exception {
        System.out.println("执行到了：" + id + "," + Thread.currentThread());
        return "第几个返回:" + id;
    }
}
