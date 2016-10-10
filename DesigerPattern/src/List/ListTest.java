package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LichKing on 2016/10/9.
 */
public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a");
        list.add("c");
        list.add(1,"b");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            String i = String.valueOf(iterator.next());
            if(i.equals("b")){
                iterator.remove();
            }
            System.out.println(i);

        }

        System.out.println("=================");
        List list1 = new LinkedList();
        list1.add(1);

        List listAll = new ArrayList();
        listAll.addAll(list);
        listAll.addAll(list1);
        Iterator iterator1 = listAll.iterator();
        while(iterator1.hasNext()){

            System.out.println(iterator1.next());

        }
    }
}
