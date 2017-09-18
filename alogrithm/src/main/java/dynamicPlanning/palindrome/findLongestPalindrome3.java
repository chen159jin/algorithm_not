package dynamicPlanning.palindrome;

/**
 * 
 * 3、中心扩展 
 * 
 * 中心扩展就是把给定的字符串的每一个字母当做中心，向两边扩展，这样来找最长的子回文串。算法复杂度为O(N^2)。 但是要考虑两种情况：
 * 1、像aba，这样长度为奇数。 2、想abba，这样长度为偶数。
 * 
 * @author
 * 
 */
public class findLongestPalindrome3 {

	public static String longestPalindrome(String s) {
		if (s.isEmpty()) {
			return null;
		}
		if (s.length() == 1) {
			return s;
		}
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}

	// Given a center, either one letter or two letter,
	// Find longest palindrome
	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1
				&& s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		String subS = s.substring(begin + 1, end);
		return subS;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("ABCCBA"));// babcbabcbaccba
	}
}
