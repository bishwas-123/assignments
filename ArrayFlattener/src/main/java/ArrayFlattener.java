import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFlattener {

    public Integer[] flatterArray(int[][] a_in) {
        if(a_in==null)
            return null;
        List<Integer> output=new ArrayList<Integer>();
        for(int[] arr:a_in){
            for(int a:arr){
             output.add(a);

            }
        }
        return output.toArray(new Integer[output.size()]);
    }

    public static void main(String[] args) {
        ArrayFlattener af=new ArrayFlattener();
        System.out.println("Enter any array and flatten that array");
int [][]a_in={{1,3},{0},{4,5,9}};

       Integer [] output=af.flatterArray(a_in);
        System.out.println(Arrays.asList(output).toString());


    }
}
