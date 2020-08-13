package net.xgs.count;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLauthTestCase {
    public static void main(String[] args) throws InterruptedException {
       int workerCount = 10;//工人数目
       CountDownLatch startLauch = new CountDownLatch(1);//闭锁 相当于开关
       CountDownLatch workLauch = new CountDownLatch(workerCount);//计数器
       System.out.println(new Date()+" - Boss：集合准备开工了！");
       for(int i=0;i<workerCount;++i){
           new Worker(i, startLauch, workLauch).start();
       }
       System.out.println(new Date()+" - Boss：休息2s后开工!");
       Thread.sleep(2000);
       System.out.println(new Date()+" - Boss：开工!");
       startLauch.countDown();//打开开关
        workLauch.await();//任务完成后通知Boss
//       workLauch.await(30, TimeUnit.SECONDS);
       System.out.println(new Date()+" - Boss：不错!任务都完成了！收工回家！");
    }
}