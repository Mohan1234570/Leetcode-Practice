class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int rows =0;
        int columns = n-1;

        while(rows<m && columns>=0){
            int value = matrix[rows][columns];

            if(value==target){
               return true;
            }else if(value>target){
                columns--;
            }else{
                rows++;
            }
        }

        return false;
    }
}