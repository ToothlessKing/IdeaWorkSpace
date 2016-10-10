package sort;

/**
 * Created by Administrator on 2016-09-28.
 */
public class quickSort {
    public static void  quickSort(int[] array){
        if(array!=null){
            quickSort(array,0,array.length-1);
        }
    }
    public static void quickSort(int[] array,int begin ,int end ){
        for(int i : array)
        {
            System.out.print(i+" ");
        }
        System.out.println();
        if(begin>=end || array == null) return;
        int p = partition2 (array,begin,end);
        quickSort(array,begin,p-1);
        quickSort(array,p+1,end);
    }
    public static int partition(int[] array,int begin ,int end){
        int last = array[end];
        int i = begin-1 ;
        for (int j =begin ;j<=end-1;j++){
            if(array[j]<=last){
                i++;
                if(i!=j){
//快排时间复杂度log2(N)*N
                    array[i] = array[i]^array[j];
                    array[j] = array[i]^array[j];
                    array[i] = array[i]^array[j];
                }
            }
        }
        System.out.println(i+" : "+end);
        if((i+1)!=end) {
            array[i + 1] = array[i + 1] ^ array[end];
            array[end] = array[i + 1] ^ array[end];
            array[i + 1] = array[i + 1] ^ array[end];
        }
        System.out.println(i+1);
        return i+1;
    }

    public static int partition2(int[] array,int begin ,int end){
        int first = array[begin];
        int i=begin,j=end;
        while (i<j){
            while(array[i]<=first && i<end){
                i++;
            }
            while (array[j]>first && j>=begin){
                j--;
            }
            if(i<j){
                array[i] = array[i]^array[j];
                array[j] = array[i]^array[j];
                array[i] = array[i]^array[j];
            }
        }
        return j;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        quickSort(array);

    }
}
