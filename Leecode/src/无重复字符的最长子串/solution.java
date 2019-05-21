package 无重复字符的最长子串;

public class solution {

	public static int lengthOfLongestSubstring(String s) {

		if (s.length() == 0 || s.length() == 1) return s.length();
		int result = 1;
		int i = 0, j = 0;

		while (i <= j && j < s.length()) {
			String string = s.substring(i, j+1);
			if ((j + 1- i) > result && noRepeat(string)) result = j + 1- i;
			if (string.length() > 1) {
				// 判断是否有重复
				if (noRepeat(string)) {j++;}
				else {i++;}
			} else {j++;}// string长度为1,j++
		}
		return result;
	}

	// 判断字符串是否有重复字符,s长度要大于1
	public static boolean noRepeat(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "bbbbb";
		System.out.println(lengthOfLongestSubstring(string));
	}

}
