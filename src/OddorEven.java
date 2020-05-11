import java.util.Arrays;

public class OddorEven {
//    Given a list of numbers, determine whether the sum of its elements is odd or even.
//    Give your answer as a string matching "odd" or "even".
//    If the input array is empty consider it as: [0] (array with a zero).
    public static void main(String... args) {
        String s2 = oddOrEven(new int[] {2, 5, 34, 6});
        System.out.println(s2);
    }

    public static String oddOrEven (int[] array) {
        // your code
        int sum = 0;
        String s = "";
        for (int i=0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println(sum);
        if (sum % 2 == 0) {
            s = "even";
        } else if (sum % 2 != 0) {
            s = "odd";
        }
        return s;
    }
}
