public class FindOddint {
    public static int findIt(int[] a) {
        for (int n : a) {
            if (n % 2 != 0) {
                System.out.println(n);
                return n;
            }
        }
        return 0;
    }
    public static void main(String... args) {
        findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5});
    }
}
