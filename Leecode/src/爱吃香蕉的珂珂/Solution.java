package 爱吃香蕉的珂珂;

public class Solution {

	public static int minEatingSpeed(int[] piles, int H) {
		long k = 0;//最小速度k 
		long times = 0;//吃的次数
		for (int i = 0; i < piles.length; i++) {
			k += piles[i];
		}
		if(k / H != 0) k = k/H;
		else k = 1;//初始化k最开始的值
		while (true) {
			for (int i = 0; i < piles.length; i++) {
				// 小于等于,这堆一次吃完
				if (piles[i] <= k)
					times++;
				// 大于,得多次吃完
				else {
					long a = piles[i] / k;
					if (piles[i] > a * k)
						times += a + 1;
					else
						times += a;
				}
			}
			//如果times大了,说明k小了,k++
			if(times > H) {k++; times = 0;}
			else return (int)k;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int H = 823855818;
		int[] piles = {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
		System.out.println(minEatingSpeed(piles, H));
	}

}
