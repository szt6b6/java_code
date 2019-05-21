package LeeCode_ReverseInt;

public class ReverseInt {
	
	public static int reverse(int i) {
		try {
			if (i < 0) {
				int result = Math.abs(i);
				StringBuffer item = new StringBuffer(String.valueOf(result)).reverse();
				return 0 - Integer.valueOf(item.substring(0));
			}
			if (i > 0) {
				int result = Math.abs(i);
				StringBuffer item = new StringBuffer(String.valueOf(result)).reverse();
				return Integer.valueOf(item.substring(0));
			}
			
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(0));
	}

}
