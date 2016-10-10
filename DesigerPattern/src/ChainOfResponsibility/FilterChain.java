package ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-09-23.
 */
public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<Filter>();
    private int index = 0;
    public FilterChain addFilter(Filter filter){
        this.filters.add(filter);
        return this;
    }
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        if (index>= filters.size()) return;
        Filter filter = filters.get(index);
        index ++;
        filter.doFilter(request,response,filterChain);
    }

    @Override
    public String doFilter(String msg) {
        if(msg!=null&&!msg.trim().equalsIgnoreCase("")){
            for(Filter filter:filters){
                msg=filter.doFilter(msg);
            }
        }
        return msg;
    }
}
