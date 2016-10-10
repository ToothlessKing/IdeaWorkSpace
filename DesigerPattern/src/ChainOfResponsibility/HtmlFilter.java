package ChainOfResponsibility;

/**
 * Created by Administrator on 2016-09-23.
 */
public class HtmlFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        String str = request.getRequestStr();
        System.out.println(str);
        filterChain.doFilter(request,response,filterChain);
        String resStr = response.getResponseStr();
        System.out.println(resStr);

    }

    @Override
    public String doFilter(String msg) {
        return msg+" had doFilter";
    }
}
