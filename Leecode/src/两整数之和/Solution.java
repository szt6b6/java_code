package 两整数之和;

public class Solution {

	public static int getSum(int a, int b) {

		int sum, increasesignal;
		while (b != 0) {
			sum = a ^ b;
			increasesignal = (a & b) << 1;
			a = sum;
			b = increasesignal;
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSum(2, 3));
	}

}
