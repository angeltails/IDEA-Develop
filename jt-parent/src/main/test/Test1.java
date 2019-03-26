import java.lang.reflect.Array;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] k ={1,2,3,4,5};
        for (int i = 0; i <k.length ; i++) {
            int y=0;
            y = k[i];
            System.out.println("y1 = " + y);
        }

        for ( int y : k) {
            System.out.println("y2 = " + y);
        }


    }
}
