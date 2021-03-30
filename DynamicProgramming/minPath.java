package DynamicProgramming;

public class minPath {

	// Memoization Array: cuts down on runtime
	public static int[][] M;
	 
	// Setup function, 1 call
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        M = new int[row][col];
        row--; col--;
        for(int i=0; i<=row; i++){
            for(int j=0; j<=col; j++){
                M[i][j] = Integer.MAX_VALUE;
            }
        }
        M[row][col] = grid[row][col];
        return opt(0,0, row, col, grid);
    }
    
    // Primary, recursive function
    public static int opt(int i, int j, int row, int col, int[][] grid){
    	
    	
    	// Prevents Array-out-of-bounds exceptions
    	// A max value will never be chosen in minimization problem
        if(i>row)
            return Integer.MAX_VALUE;
        else if(j>col)
            return Integer.MAX_VALUE;
        
        // References Memoization Array for solution if pre-computed
        else if(M[i][j] < Integer.MAX_VALUE)
            return M[i][j];
        
        // Visual of Memo-grid
        print_Memo(M);
        
        // Two subcases: I can step right or down; either case, I have add current square.
        // Then, I take the minimum return of each subcase.
        M[i][j] = grid[i][j] +  Math.min(opt(i,j+1, row, col, grid), 
                               		opt(i+1,j, row, col, grid));
        // 
        return M[i][j];
    }
	    // Helper visual
	    static void print_Memo(int[][] arr) {
	    	for(int i=0; i<arr.length; i++) {
	    		System.out.print("| ");
	    		for(int j=0; j<arr.length; j++) {
	    			if(arr[i][j] == Integer.MAX_VALUE)
	    				System.out.print("∞ ");
	    			else
	    			System.out.print(arr[i][j] + " ");
	    		}
	    		System.out.print("|\n");
	    	}
	    	System.out.println();
	    }

	    // Note that this is a bottom-up recursive approach.
	    // Can also be done top-down iteratively, using nested for-loops; see below!
	public static void main(String[] args) {
		int[][] grid = new int[4][4];
		grid[0][0] = 1; grid[0][1] = 3; grid[0][2] = 1; grid[0][3] = 2;
		grid[1][0] = 1; grid[1][1] = 5; grid[1][2] = 1; grid[1][3] = 3;
		grid[2][0] = 3; grid[2][1] = 2; grid[2][2] = 1; grid[2][3] = 1;
		grid[3][0] = 1; grid[3][1] = 3; grid[3][2] = 1; grid[3][3] = 1;
		print_Memo(grid);
		int result = minPathSum(grid);
//		int result = opt(1,1, grid.length, grid[0].length,  grid);
		print_Memo(M);
		System.out.println(result);

	}
}

/*
 *	static int opt(int m, int n, int row, int col, int[][] grid) {
		if( m == 0 ) return 0;
		else if( n == 0 ) return 0;
		
		for(; m<row; m++){
			for(;n<col; n++){
				if(m == 0 || n == 0)
	 				M[m][n] = 0;
				else if(M[m][n] > 0)
					return M[m][n];
 				else
 					M[m][n] = grid[m-1][n-1] + Math.min(opt(m-1,n, row, col, grid), 
 									   opt(m,n-1, row, col, grid));
		 	}
		 }
		print_Memo();
		return M[row-1][col-1];
	}
 * 
*/ 
