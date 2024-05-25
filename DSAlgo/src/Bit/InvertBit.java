package Bit;

/* https://www.geeksforgeeks.org/invert-actual-bits-number/ */
public class InvertBit {
    static void invertBits(int num) {
        // calculating number of
        // bits in the number
        int x = (int) (Math.log(num) /
                Math.log(2)) + 1;

        // Inverting the
        // bits one by one
        for (int i = 0; i < x; i++)
            num = (num ^ (1 << i));

        System.out.println(num);
    }

    // Driver code
    public static void main(String[] args) {
        int num = 11;
        invertBits(num);
    }
}
