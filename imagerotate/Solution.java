package imagerotate;

public class Solution {
	
	public void rotate(int[][] matrix){
		for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
	}
	
	public static void main(String[] args) {
		int[][] nums = {
				  { 5, 1, 9,11},
				  { 2, 4, 8,10},
				  {13, 3, 6, 7},
				  {15,14,12,16}
				};
		new Solution().rotate(nums);
		System.out.println(nums);//[[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]
	}
}
