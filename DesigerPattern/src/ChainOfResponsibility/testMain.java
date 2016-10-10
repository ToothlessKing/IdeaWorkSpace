package ChainOfResponsibility;

/**
 * Created by Administrator on 2016-09-23.
 */
public class testMain {
    public static void main(String[] args) {
        String string = "dsdsds";
        MsgProcessor msgProcessor =new MsgProcessor();
        msgProcessor.setMsg(string);


        Response response = new Response();
        response.setResponseStr("response");
        Request request = new Request();
        request.setRequestStr("request");

        FilterChain filterChain =new FilterChain();
        filterChain.addFilter(new HtmlFilter());

        filterChain.doFilter(request,response,filterChain);
        msgProcessor.setFilterChain(filterChain);
        String msg =msgProcessor.processor();
        System.out.println(msg);
    }

}
