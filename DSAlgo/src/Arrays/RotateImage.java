package Arrays;

public class RotateImage {
    static void rotate(int[][] matrix) {

        // Step 1: Transpose of the matrix
        // TODO: Why j starts from i in transpose matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        /*
         * //Print Transpose matrix
         * System.out.println("Transpose Matrix:");
         * for (int i = 0; i < matrix.length; i++) {
         * for (int j = 0; j < matrix.length; j++) {
         * System.out.print(matrix[i][j] + " ");
         * }
         * System.out.println();
         * }
         */

        // Step 2: Reverse each row of the matrix.
        // swap b/w j th and [(length - 1) - (j)] th element
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
