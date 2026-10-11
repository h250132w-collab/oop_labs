import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Input the dividend: ");
            int num1 = sc.nextInt();
            System.out.print("Input the divisor: ");
            int num2 = sc.nextInt();
            System.out.println(num1/num2);
        } catch (ArithmeticException e){
            System.out.println("Error: Cannot divide by zero.");
        } catch (InputMismatchException i){
            System.out.println("Error: Please enter valid integers only.");
        } finally {
            sc.close();
        }

        Scanner scanner = new Scanner(System.in);
        try{
            int[] nums = new int[3];
            for(int i=0;i!=5;i++){
                nums[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException a){
            System.out.println("\nAttempted an array index access that is out of bounds");
        } finally {
            System.out.println("Closing scanner now");
            scanner.close();
        }
    }
}
