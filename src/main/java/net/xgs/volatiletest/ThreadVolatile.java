package net.xgs.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: TianW
 * @Date: 2019/1/1 20:41
 * @Description:
 */
public class ThreadVolatile extends Thread{
    public static volatile int n = 0;
//    public static AtomicInteger n = new AtomicInteger(0);
    public void run(){
        for(int i=0;i<10;i++){
            try {
                n++;
//                add();
//                n.getAndIncrement();
                Thread.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static synchronized void add() {
        n++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threads[] = new ThreadVolatile[100];
        for(int i=0;i<threads.length;i++){
            threads[i]= new ThreadVolatile();
        }
        for(int i=0;i<threads.length;i++){
            threads[i].start();
        }
        for(int i=0;i<threads.length;i++){
            threads[i].join();
        }
        System.out.println("n="+ThreadVolatile.n);
    }
}
