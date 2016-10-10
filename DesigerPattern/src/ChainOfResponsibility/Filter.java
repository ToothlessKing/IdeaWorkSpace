package ChainOfResponsibility;

/**
 * Created by Administrator on 2016-09-23.
 */
public interface Filter {
    public abstract void doFilter(Request request, Response response, FilterChain filterChain);
    public abstract String doFilter (String msg);
}
