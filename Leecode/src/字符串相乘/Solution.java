package 字符串相乘;


public class Solution {
	
	public static String multiply(String num1, String num2) {
		
		if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
			return "0";
		}
		int[] result = new int[num2.length() + num1.length()];//两个数相乘,最长为这个长度
		//进行乘法操作,该处最好在纸上推演一遍,修改多次
		int num = 0;
		for (int i = num2.length() -1; i >=0; i--) {
			for (int j = num1.length() -1; j >= 0; j--) {
				num = Integer.valueOf(num1.charAt(j) - 48) * Integer.valueOf(num2.charAt(i) - 48) + result[i+j+1];
				if (num >= 10) {
					result[i+j+1] = num%10;
					result[i+j] += num/10;
				}else {
					result[i+j+1] = num;
				}
			}
		}
		
		String a = "";
		for (int i = 0; i < result.length; i++) {
			a += result[i];
		}
		if (a.charAt(0) == '0') {
			a = a.substring(1);
		}
		System.out.println(a);
		return a;   
    }
	
	public static void main(String[] args) {
		String a ="8810954646516803";
		String b = "0";
		multiply(a, b);
	}
}
