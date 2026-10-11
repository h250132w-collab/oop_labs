public class MathUtils {
    public int add(int int1, int int2){
        System.out.println("2 integers version");
        return int1 + int2;
    }

    public int add(int int1, int int2, int int3){
        System.out.println("3 integer version");
        return int1 + int2 + int3;
    }

    public double add(double num1, double num2){
        System.out.println("Doubles version");
        return num1 + num2;
    }

    public int add(int[] numbers){
        System.out.println("Array version");
        int sum = 0;
        for (int num : numbers){
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args){
        MathUtils mathObject = new MathUtils();
        int[] arr1 = new int[4];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;
        arr1[3] = 4;
        System.out.println(mathObject.add(arr1));
        System.out.println(mathObject.add(1,5));
        System.out.println(mathObject.add(2,6,7));
        System.out.println(mathObject.add(2.3,9.0));
    }
}
