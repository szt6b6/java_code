package 除自身以外数组的乘积;


public class Solution {
	public static int[] productExceptSelf(int[] nums) {
		
		int[] leftX = new int[nums.length];//左边乘积
		int[] rightX = new int[nums.length];//右边乘积
		int[] result = new int[nums.length];
		leftX[0] = rightX[nums.length - 1] = 1;//初始化两头的值
		//求左边的乘积
		for (int i = 1; i < rightX.length; i++) {
			leftX[i] = leftX[i - 1] * nums[i - 1];
		}
		//求右边的乘积
		for (int i = nums.length - 2; i >= 0; i--) {
			rightX[i] = rightX[i + 1] * nums[i + 1];
		}
		for (int i = 0; i < rightX.length; i++) {
			result[i] = leftX[i] * rightX[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = productExceptSelf(a);
		System.out.println(b[0]+" " +b[1]);
	}
}
