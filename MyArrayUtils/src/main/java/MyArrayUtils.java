public class MyArrayUtils {
//    public static void main(String[] args) {
//        MyArrayUtils myArrayUtils=new MyArrayUtils();
//        int[] testArr=new  int[]{-6, 2, 5, 6, -6, 5, 6};
//        System.out.println(myArrayUtils.hasMultipleMaximum(testArr));
//
//
//    }
    public boolean hasMultipleMaximum(int[] a_in){
        if(a_in==null || a_in.length==0)
            return false;
        int max=a_in[0];
        int count=0;
        for(int i=0;i<a_in.length;i++){
            if(max==a_in[i]){
                count++;
            }
            if(a_in[i]>max){
                 max=a_in[i];
                 count=0;
            }

        }
        if(count>0){
            return true;
        }
        return false;
    }
}
