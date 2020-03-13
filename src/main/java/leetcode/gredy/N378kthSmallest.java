package leetcode.gredy;

public class N378kthSmallest {

    /*
    给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
    请注意，它是排序后的第k小元素，而不是第k个元素。

示例:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。

说明:
你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || k < 1) {
            return 0;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int small = matrix[0][0];
        int big = matrix[row][col];
        int mid = 0;

        while (small <= big){
            mid = small + (big - small) / 2;
            int cntLess = findLessCount(matrix, row, col, mid);
            if (cntLess == k) {
                return mid;
            }
            if (cntLess < k) {
                small = mid + 1;
            } else {
                big = mid;
            }
        }


        return mid;


    }

    private int findLessCount(int[][] matrix, int row, int col, int mid) {
        int newRow = row;
        int newCol = 0;
        int cnt = 0;
        while (newRow >= 0 && newCol < col) {
            if (matrix[newRow][newCol] <= mid) {
                cnt += (newRow + 1);
                newCol++;
            } else {
                newRow--;
            }
        }
        return cnt;
    }
}
