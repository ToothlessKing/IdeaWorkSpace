package thread;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2016-09-23.
 */
public class CallableTest {
    public static class MyCallable implements Callable{
        private  int flag = 0 ;
        public MyCallable(int flag){
            this.flag = flag;
        }
        @Override
        public Object call() throws Exception {
            if(this.flag==0){
                return "flag=0";
            }
            return null;
        }
    }
}
