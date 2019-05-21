package 数组中的最长山脉;

public class Solution {

	public static int longestMountain(int[] A) {
		
		int[] result = new int[A.length];
		for (int i = 1; i < A.length - 1; i++) {
			int leftcount = 0, rightcount = 0;// 左右计数
			// 左边计数
			for (int j = i - 1; j >= 0; j--) {
				if (A[j] < A[j + 1])
					leftcount++;
				else
					break;
			}
			// 右边计数
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] < A[j -1])
					rightcount++;
				else
					break;
			}
			if(leftcount == 0 || rightcount ==0) result[i] = 0;
			else result[i] = leftcount + rightcount + 1;
		}
		int max = 0;
		for (int i = 0; i < result.length; i++) {
			if(max < result[i]) max = result[i];
		}
		if(max < 3) return 0;
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(longestMountain(a));
	}

}
