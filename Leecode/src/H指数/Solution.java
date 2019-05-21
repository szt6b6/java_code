package H指数;

import java.util.Arrays;

public class Solution {

	/*
	 * 执行用时 : 25 ms, 在H-Index的Java提交中击败了9.54% 的用户
内存消耗 : 34.6 MB, 在H-Index的Java提交中击败了91.45% 的用户*/
//	public static int hIndex(int[] citations) {
//		int n = citations.length;
//		int count = 0;//计数,判断满足条件
//		for (int i = n; i >= 0; i--) {//从h=n开始遍历
//			for(int a : citations) {
//				if(a >= i) count++;
//			}
//			if(count >= i) return i;
//			else count = 0;
//		}
//		return count;
//	}

	/*执行用时 : 2 ms, 在H-Index的Java提交中击败了96.71% 的用户
内存消耗 : 34.2 MB, 在H-Index的Java提交中击败了95.39% 的用户*/
	public static int hIndex(int[] citations) {
		if(citations.length == 0) return 0;
		Arrays.sort(citations);
		int n = citations.length;
		for (int i = n; i > 0; i--) {
			if(citations[n -i] >= i) return i;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0};
		System.out.println(hIndex(a));
	}

}
