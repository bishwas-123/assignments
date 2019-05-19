import service.IArrayFlattener;

import java.time.LocalDate;
import java.time.Period;

public class ArrayReversor {
private IArrayFlattener arrayFlattener;
public ArrayReversor(IArrayFlattener arrayFlattener){
    this.arrayFlattener=arrayFlattener;
}
    public static void main(String[] args) {
    LocalDate currentDate=LocalDate.now();
    int diff= Period.between(LocalDate.of(1995,05,17),currentDate).getYears();
        System.out.println("my age: "+diff);
//         ArrayReversor arrayReversor=new ArrayReversor();
//         int[][] a_in={{1,3}, {0}, {4,5,9}};
//         int[] out=arrayReversor.reverseArray(a_in);
//
//        System.out.println(Arrays.toString(out));
    }



    public int[] reverseArray(int[][] a_in){
       int[]a_out=arrayFlattener.flattenArray(a_in);
       // int[]a_out={1,3,0,4,5,9};
        if(a_out==null) return null;
        int[]result=new int[a_out.length];
        int c=0;
        for(int i=a_out.length-1;i>=0;i--){
            result[c]=a_out[i];
            c++;
        }
        return result;
    }
}
