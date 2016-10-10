package sort;

/**
 * Created by LichKing on 2016/10/9.
 */
public class maopao {
    public static void main(String[] args) {
        int[] a = {1,4,5,2,3};
        //冒泡排序
//        for(int i=0 ;i<a.length;i++){
//            for(int j=0 ;j<a.length-i-1 ;j++){
//                if(a[j]>a[j+1]){
//                    a[j+1] = a[j+1]^a[j];
//                    a[j] = a[j+1]^a[j];
//                    a[j+1] = a[j+1]^a[j];
//                }
//            }
//        }
        //选择排序
//        for(int i=0 ;i<a.length ;i++){
//            for(int j=0 ;j<a.length ;j++){
//                if(a[i]<a[j]){
//                    a[i] = a[i]^a[j];
//                    a[j] = a[i]^a[j];
//                    a[i] = a[i]^a[j];
//                }
//            }
//        }
        for(int i=0 ;i<a.length ;i++){
            for(int j=i+1 ;j<a.length ;j++){
                if(a[i]>a[j]){
                    a[i] = a[i]^a[j];
                    a[j] = a[i]^a[j];
                    a[i] = a[i]^a[j];

                }
            }
        }
        for (int j : a){
            System.out.print(j);
        }
    }
}
