import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // try (Scanner input = new Scanner(System.in)) {

        //     System.out.print("Enter Rows : ");
        //     int rows = input.nextInt();

        //     System.out.print("Enter Cols : ");
        //     int cols = input.nextInt();

        //     int ppb = 3;

        //     // for (int col = 0; col <= (ppb * cols) - ppb; col += ppb) {
        //     //     for (int row = 0; row < rows; row++) {
        //     //         System.out.println(row + "" + col);
        //     //     }
        //     //     System.out.println("------------------");
        //     // }
        // }
        List<Integer> li = new ArrayList<>();
        li.add(1);   
        li.add(2);   
        li.add(3);
        System.out.println(li);  

        change(li); 
        System.out.println(li);  
    }

    private static void change(List<Integer> li) {
        // TODO Auto-generated method stub
        li.set(0, 456);
    }
}
