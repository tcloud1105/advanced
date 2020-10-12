package thread;

public class Thread_In_Action {
    public static void main(String[] args){
        Thread t1 = new Thread(new Thread_Example_14("one"));
        Thread t2 = new Thread(new Thread_Example_14("two"));
        Thread t3 = new Thread(new Thread_Example_14("third"));
        Thread t4 = new Thread(new Thread_Example_14("four"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();




    }
}
