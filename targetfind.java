public class targetfind{

    public static void main (String[]args){
        targetfind obj=new targetfind();
        int [][] matrix = {
                      {1,  3,  5,  7},
                      {10, 11, 16, 20},
                      {23, 30, 34, 60}};
        int target=3;
        System.out.println("the target found :"+obj.searchMatrix(matrix,target));

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / n;
            int c = mid % n;
            int val = matrix[r][c];
            
            if (val == target) {
                return true;
            }
            else if (val < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }
}
