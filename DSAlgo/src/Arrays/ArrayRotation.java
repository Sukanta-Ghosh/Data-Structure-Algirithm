package Arrays;

import java.util.ArrayList;

public class ArrayRotation {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        B = B % n;

        int p1 = 0;
        int p2 = A.size() - 1;

        // Reverse the whole Array
        reverse(A, p1, p2);

        // Reverse first B elements
        p1 = 0;
        p2 = B - 1;
        reverse(A, p1, p2);

        // Reverse last C elements
        p1 = B;
        p2 = n - 1;
        reverse(A, p1, p2);

        return A;
    }

    public ArrayList<Integer> reverse(ArrayList<Integer> A, int p1, int p2) {
        while (p1 < p2) {
            int temp = A.get(p1);
            A.set(p1, A.get(p2));
            A.set(p2, temp);

            p1++;
            p2--;
        }

        return A;
    }
}
