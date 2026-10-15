public class Main {
    static void validateAge(int age) throws InvalidAgeException{
        if ((age < 0) || (age > 120)){
            throw new InvalidAgeException("Age " + age + " is invalid. Age must be between 0 and 120.");
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args){
        int[] ages = {25, -5, 120, 130};
        for (int age : ages){
            try {
                validateAge(age);
            } catch (InvalidAgeException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
