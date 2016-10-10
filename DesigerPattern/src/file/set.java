package file;

import java.util.*;

/**
 * Created by Administrator on 2016-09-28.
 */
public class set {
    public static void main(String[] args) {
        Set set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        System.out.println(set.size());

        List list = new ArrayList<>();
        list.add("aa");
        list.add("cc");
        list.add("bb");
        set.add(list);
        set.addAll(list);
        System.out.println(set.size());
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println("value:"+ iterator.next().toString());
        }
    }
}
