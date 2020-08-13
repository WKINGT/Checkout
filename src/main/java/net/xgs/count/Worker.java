package net.xgs.count;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Worker extends Thread{
    private int workNo;
    private CountDownLatch startLauch;//启动器-闭锁
    private CountDownLatch workLauch;//工作进程-计数器

    public Worker(int workNo,CountDownLatch startLauch,CountDownLatch workLauch) {
       this.workNo = workNo;
       this.startLauch = startLauch;
       this.workLauch = workLauch;
    }

    @Override
    public void run() {
       try {
           System.out.println(new Date()+" - YHJ"+workNo+" 准备就绪！准备开工！");
           startLauch.await();//等待老板发指令
           System.out.println(new Date()+" - YHJ"+workNo+" 正在干活...");
           Thread.sleep(100);//每人花100ms干活
       } catch (InterruptedException e) {
           e.printStackTrace();
       }finally{
           System.out.println(new Date()+" - YHJ"+workNo+" 工作完成!");
           workLauch.countDown();
       }
    }
}
