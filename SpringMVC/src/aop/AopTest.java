package aop;

/**
 * Created by Administrator on 2016-09-18.
 */
public class AopTest {
    public void before1(){
        System.out.println("执行service.first前。。。");
    }
    public void before2(){
        System.out.println("还是执行service.first前。。。");
    }
    public void after(){
        System.out.println("这是执行service.first后。。。");
    }
    public void trowing(){
        System.out.println("异常了。。。。");
    }
}
