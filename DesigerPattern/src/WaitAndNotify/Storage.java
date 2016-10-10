package WaitAndNotify;

import java.util.LinkedList;

/**
 * Created by LichKing on 2016/10/9.
 */
public class Storage {

    private final int MAX_SIZE = 100;

    private LinkedList list = new LinkedList();

    public synchronized void produce(int num){


            while (list.size()+num>MAX_SIZE){
                System.out.println("[要生产的产品数量]："+num+" [库存量]："+list.size()+"  暂时不能生产");
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        for(int i=1;i<=num;i++){
            list.add(new Object());
        }
        System.out.println("[已经生产的产品数]："+num +"  [现储量为]："+list.size());
       notifyAll();
    }
    public synchronized void consume(int num ){

            while (list.size()<num){
                System.out.println("[要消费产品数量]"+ num +" [库存量]："+list.size()+" 暂时不能执行生产任务！ ");
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        for(int i=1;i<=num;i++){
            list.remove();
        }
        System.out.println("[已消费产品数]:"+num+ " [现仓储量]："+list.size());
        notifyAll();
    }
    public LinkedList getList(){
        return list;
    }
    public void setList(LinkedList list){
        this.list=list;
    }
    public int getMAX_SIZE(){
        return MAX_SIZE;
    }
}
