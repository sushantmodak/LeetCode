package wordsearch79;

/*
 * https://leetcode.com/problems/word-search/discuss/226914/java-backtracking-no-additional-space
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
    	for(int r=0;r<board.length;r++){
    		for(int c=0;c<board[0].length;c++)
    			if(word.contains(String.valueOf(board[r][c])))
    				if(backtrack(board, word, r, c, 0))
    					return true;
    	}
    	return false;
    }

	private boolean backtrack(char[][] board, String word, int r, int c, int index) {
		if(index>=word.length()) return true;
		if(r<0 || r>=board.length
				|| c<0 || c>=board[0].length
				|| word.charAt(index) != board[r][c]
						|| board[r][c]=='.')
			return false;
		board[r][c]='.';
		if(backtrack(board, word, r-1, c, index+1)
				|| backtrack(board, word, r, c-1, index+1)
				|| backtrack(board, word, r+1, c, index+1)
				|| backtrack(board, word, r, c+1, index+1)){
			return true;
		}
		board[r][c]=word.charAt(index);
		return false;
	}

	public static void main(String[] args) {
		char[][] board = /*{
				  {'A','B','C','E'},
				  {'S','F','C','S'},
				  {'A','D','E','E'}
				};*/
			{{'a','a'}};
		/*System.out.println(new Solution2().exist(board, "ABCCED"));*/
		System.out.println(new Solution().exist(board, "aaa"));
	}
}
