package alliswell.leecode;


/**
 * 304. 二维区域和检索 - 矩阵不可变
 * <p>
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * <p>
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * <p>
 * 示例:
 * <p>
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * <p>
 * 说明:
 * <p>
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 */
public class Quesion304 {

    public static void main(String[] args) {

        NumMatrix matrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}

        });
        matrix.printMatrix();

        int a = matrix.sumRegion(2, 1, 4, 3); //  -> 8
        System.out.println(a);
        int b = matrix.sumRegion(1, 1, 2, 2); //  -> 11
        System.out.println(b);
        int c = matrix.sumRegion(1, 2, 2, 4); //  -> 12
        System.out.println(c);


        int d = matrix.sumRegion(0, 0, 0, 0); //  -> 3
        System.out.println(d);
        int e = matrix.sumRegion(0, 4, 0, 4); //  -> 2
        System.out.println(e);
    }

    static class NumMatrix {

        int[][] sums;

        public NumMatrix(int[][] matrix) {

            int[][] newMatrix = getMatrix2D(matrix);

            sums = new int[matrix.length][];
            int result = 0;

            for (int i = 0; i < newMatrix.length; i++) {
                sums[i] = new int[newMatrix[0].length];
                if (matrix[i].length == 0) {
                    continue;
                }
                result = 0;
                for (int j = 0; j < newMatrix[i].length; j++) {

                    if (matrix[i].length - 1 >= j) {
                        result += matrix[i][j];
                    } else {

                    }

                    if (i == 0) {
                        sums[i][j] = result;
                    } else {
                        sums[i][j] = sums[i - 1][j] + result;
                    }
                }
            }
        }

        public void printMatrix() {
            for (int i = 0; i < sums.length; i++) {
                for (int j = 0; j < sums[i].length; j++) {
                    System.out.print(sums[i][j] + ",\t");
                }
                System.out.println();
            }
        }

        public int[][] getMatrix2D(int[][] matrix) {
            if (matrix.length == 0) {
                return null;
            }

            int[][] temp = new int[matrix.length][];
            int maxLen = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (maxLen < matrix[i].length) {
                    maxLen = matrix[i].length;
                }
            }

            for (int i = 0; i < temp.length; i++) {
                temp[i] = new int[maxLen];
            }
            return temp;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sums == null || sums.length == 0) {
                return 0;
            }
            if (row1 == 0 && col1 == 0) {
                return sums[row2][col2];
            }

            if (row1 == 0) {
                return sums[row2][col2] - sums[row2][col1 - 1];
            }

            if (col1 == 0) {
                return sums[row2][col2] - sums[row1 - 1][col2];
            }

            return sums[row2][col2]
                    - sums[row1 - 1][col2]
                    - sums[row2][col1 - 1]
                    + sums[row1 - 1][col1 - 1];
        }
    }

}