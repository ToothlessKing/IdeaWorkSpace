package WaitAndNotify;

/**
 * Created by LichKing on 2016/10/9.
 */
public class Test {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Producer p3 = new Producer(storage);



        Consumer c1 = new Consumer(storage);
        Consumer c2 = new Consumer(storage);



        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);



        c1.setNum(50);
        c2.setNum(20);
        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();






    }
}
