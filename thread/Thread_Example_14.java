package thread;

import java.util.Random;

// Runnable interface contains run() method
public class Thread_Example_14 implements Runnable{
    String name;
    int time;
    Random r = new Random();

    public Thread_Example_14(String x){
        name = x;
        time = r.nextInt(999);

    }
    @Override
    public void run() {
        try{
            System.out.printf("%s is sleeping for %d\n", name, time);
            Thread.sleep(time);
            System.out.printf("%s is done\n", name);

        }catch (Exception e){

        }
    }







}
