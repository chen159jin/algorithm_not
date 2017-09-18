package dynamicPlanning.palindrome;
/**
 * 1、暴力法
 * 求每一个子串时间复杂度O(N^2)，判断子串是不是回文O(N)，两者是相乘关系，所以时间复杂度为O(N^3)。
 * @author 
 *
 */
public class findLongestPalindrome1 {

	public static void main(String[] args) {
		System.out.println(longestPalindrome1("babcbabcbaccba"));
	}

	public static String longestPalindrome1(String s) {

		int maxPalinLength = 0;
		String longestPalindrome = null;
		int length = s.length();

		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int len = j - i;
				String curr = s.substring(i, j + 1);
				if (isPalindrome(curr)) {
					if (len > maxPalinLength) {
						longestPalindrome = curr;
						maxPalinLength = len;
					}
				}
			}
		}

		return longestPalindrome;
	}

	public static boolean isPalindrome(String s) {

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}

		return true;
	}
}
