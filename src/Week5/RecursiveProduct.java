import java.util.Scanner;

public class RecursiveProduct {

    public static int productOfNumbers(int[] numbers, int index) {
        if (index == numbers.length - 1) {
            return numbers[index];
        }
        return numbers[index] * productOfNumbers(numbers, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter five numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int result = productOfNumbers(numbers, 0);

        System.out.println("The product of the entered numbers is: " + result);

        scanner.close();
    }
}
