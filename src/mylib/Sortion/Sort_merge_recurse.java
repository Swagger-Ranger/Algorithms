package mylib.Sortion;

import mylib.FileStdIn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

/**********************************************************************
 *
 *
 * 排序算法--并归排序--递归
 *传入数组，使用数组来实现排序
 *思想将大问题递归成为小问题，sort自顶向下的分解问题,底层解决方法是merge方法，也就是最小地问题排序是使用merge方法实现的，然后自底向上的回归解决
 *NlogN
 *
* *********************************************************************/
public class Sort_merge_recurse {

    //静态类，不能初始化对象
    private Sort_merge_recurse(){}

    /**********************************************************************
     * 以下是通用工具方法实现对元素的比较和交换,以及检查排序是否完成
    * *********************************************************************/
    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b) < 0;
    }
    private static boolean less(Comparator comparator, Object a,Object b){
        return comparator.compare(a,b) < 0;
    }

    private static void exch(Object[] o,int i,int j){
        Object tmp = o[i];
        o[i] = o[j];
        o[j] = tmp;
    }

    private static boolean isSorted(Comparable[] comparators){return isSorted(comparators,0,comparators.length);}
    private static boolean isSorted(Comparable[] comparators,int lo,int hi){
        for(int i = lo;i < hi-1;i++)
            if(less(comparators[i+1],comparators[i])) return false;
        return true;
    }
    private static boolean isSorted(Object[] o,Comparator comparator){
        return isSorted(o,comparator,0,o.length);
    }
    private static boolean isSorted(Object[] o,Comparator comparator,int lo,int hi){
        for(int i = lo;i < hi-1;i++)
            if(less(comparator,o[i+1],o[i])) return false;
        return true;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    /**********************************************************************
     * 以上是通用工具方法实现对元素的比较和交换,以及检查排序是否完成
     * *********************************************************************/

    private static Comparable[] aux;//辅助数组

    //排序方法
    //将数组合并，也就是回归解决问题的实际步骤
    private static  void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo,j = mid + 1;
        for (int k = lo ; k <= hi; k++) {  //将元素保存到辅助数组，注意不要在这里初始化数组，这样每次递归到会新开辟数组的空间导致巨大的浪费
            aux[k] = a[k];
        }
        for (int k = lo; k <=hi ; k++) {    //合并数组，右边没有了就合并左边，左边没有了就合并右边，或者是比较左右的大小再合并
            if      (i > mid) a[k] = aux[j++];
            else if (j > hi)  a[k] = aux[i++];
            else if (less(aux[j],aux[i]))  a[k] = aux[j++];
            else    a[k] = aux[i++];
        }
    }
    public static void sort(Comparable[] a ){
        aux = new Comparable[a.length]; //这里一次性分配辅助数组的空间
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if( hi <= lo) return;
        int mid =lo + (hi -lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }


    public static void sort(Object[] a ,Comparator comparator){

    }


    public static void main(String[] args) throws FileNotFoundException {
        String str ="C:\\Swagger-Ranger\\algs4_github_fork\\AlgorithmsSedgewick\\2-Sorting\\2-1-ElementarySorts\\tiny" +
                ".txt";
        FileStdIn.setScanner(str);

        String[] a = FileStdIn.readAllStrings();
        System.out.println(Arrays.toString(a));
        Sort_merge_recurse.sort(a);
        System.out.println(isSorted(a));
        show(a);

    }
}
