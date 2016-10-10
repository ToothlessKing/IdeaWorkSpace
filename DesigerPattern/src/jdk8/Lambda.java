package jdk8;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LichKing on 2016/10/8.
 */
public class Lambda {
    public static void main(String[] args) {
        final String i = "+++++++++++";
        List<Integer> list = Arrays.asList(1, 2, 3, 5);
        list.forEach(e -> {
            System.out.println(e);
            System.out.println(i);
        });
        final long count = list.stream().filter(j -> isPrime(j)).count();
        final long c = list.stream().filter(j -> isPrime(j)).reduce(0,Integer::sum);
        System.out.println(count);
        System.out.println(c);
    }

    private static boolean isPrime(Object j) {
        if ((int) j > 2) {
            return true;
        } else {
            return false;

        }
    }

}