
public class validPalindrome {

	static int valid_Palindrome(String word, int k, int i, int j){
		if( k < 0 || i > j) return 0;

		else if(isPalindrome(word, i, j)) return 1;
		
		return max( 		valid_Palindrome(word, k-1,  i+1, j),
							valid_Palindrome(word, k-1,  i, j-1),
							valid_Palindrome(word, k-2,  i+1, j-1)
		);
	}

	static int max(int a, int b, int c) {
		if(a >= b && a >= c) return a;
		else if(b >= a && b >= c) return b;
		else return c;
	}

	static boolean isPalindrome(String word, int i, int j){
		// to handle palindromes of odd/even length
		int z = (j - i)/2;
		for(int m = 0; m <= z; m++){
			if(word.charAt(i+m) != word.charAt(j-m)) return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		String word = "harhalolbazinga";
		int k = 12;
		System.out.println("Test!");
		int results = valid_Palindrome(word, k, 0, word.length()-1);
		if( results == 1 ) 
			System.out.println( word + " is a potential palindrome!");
		else 
			System.out.println( word + " is  NOT potential palindrome!");
	}
}
