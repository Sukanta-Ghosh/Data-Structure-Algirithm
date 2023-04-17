package Arrays;

public class FindDistinctFactors {

    /* T.C - O(sqrt(n)) */
    public static int findFactors(Integer a) {

        int count = 0;
        for (int i = 1; i <= (int) Math.sqrt(a); i++) {
            if (a % i == 0) {
                count = count + 2;
                if (i * i == a) {
                    count--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findFactors(35));
    }
}
