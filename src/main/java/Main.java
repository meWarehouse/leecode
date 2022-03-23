public class Main {

    public static void main(String[] args) {


    }

    public void setZeroes(int[][] matrix) {

        boolean row0 = false, col0 = false;

        int i = 0, j = 0;

        for (i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                row0 = true;
                break;
            }
        }

        for (j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                col0 = true;
                break;
            }
        }


        for (i = 1; i < matrix.length; i++) {
            for (j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (i = 1; i < matrix.length; i++) {
            for (j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }


        if (row0) {
            for (i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        }

        if (col0) {
            for (j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
        }

    }

}

