package File_Net;

public class fileNet{

	//左右上下遍历,判断此节点是否可放
	private static boolean RowisPutable(int i, int j, char[][] map) {
		boolean flag = true;
		
		if (map[i][j] == 'X') {
			return false;//如果当前位置为墙,就不能放,返回false
		}
		//左边遍历
		int x = i -1;
		int y = j;
		while(x >= 0) {
			if (map[x][y] == '1') {//1表示碉堡
				flag = false;
				return flag;//跳出行遍历
			}
			if (map[x][y] == 'X') {
				flag = true;
				x = -1;//跳出左边遍历
			}
			x--;
		}
		flag = true;//左边遍历完了
		
		//右边遍历
		x = i + 1;
		y = j;
		while(x <= map.length - 1) {
			if (map[x][y] == '1') {
				flag = false;
				return flag;
			}
			if (map[x][y] == 'X') {
				flag = true;
				x = map.length;
			}
			x++;
		}
		flag = true;
		
		return flag;
	}
	
	
	private static boolean ColisPutable(int i, int j, char[][] map) {
		boolean flag = true;
		
		if (map[i][j] == 'X') {
			return false;//如果当前位置为墙,就不能放,返回false
		}
		//上边遍历
		int x = i;
		int y = j -1;
		while(y >= 0) {
			if (map[x][y] == '1') {
				flag = false;
				return flag;
			}
			if (map[x][y] == 'X') {
				flag = true;
				y = -1;
			}
			y--;
		}
		flag = true;
		
		//下边遍历
		x = i;
		y = j + 1;
		while(y <= map.length -1) {
			if (map[x][y] == '1') {
				flag = false;
				return flag;
			}
			if (map[x][y] == 'X') {
				flag = true;
				y = map.length;
			}
			y++;
		}
		flag = true;
		
		return flag;
	}
	public static void main(String[] args) {
		//先直接用4个大小的做测试
//		int size = 4;
//		char[][] map = {{'.','X','.','.'},
//						{'.','.','.','.'},
//						{'X','X','.','.'},
//						{'.','.','.','.'}};
//		int size = 4;
//		char[][] map = {{'.','.','.','.'},
//						{'.','.','.','.'},
//						{'.','.','.','.'},
//						{'.','.','.','.'}};
		//2个大小
//		int size = 2;
//		char[][] map = {{'X','X'},
//						{'.','X'}};
		
		//3个大小
//		int size = 3;
//		char[][] map = {{'.','X','.'},
//						{'X','.','X'},
//						{'.','X','.'}};
	
		char[][] map = {{'.','.','.'},
						{'.','X','X'},
						{'.','X','X'}};//算法有问题,答案为2
		
		//存放从尾部遍历的数组,不同用同一个数组
		char[][] newmap= new char[map.length][map.length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
					newmap[i][j] = map[i][j];
			}
		}
		
		int result[] = new int[2];//存放从头开始遍历的结果和从尾遍历的结果
		
		//从头遍历每个节点,若可用则放'1'
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (RowisPutable(i, j,map) && ColisPutable(i, j,map)) {
					map[i][j] = '1';
					result[0]++;
				}
			}
		}
		
		//从尾遍历
		for (int i = newmap.length -1; i >= 0; i--) {
			for (int j = newmap.length -1; j >= 0; j--) {
				if (RowisPutable(i, j,newmap) && ColisPutable(i, j,newmap)) {
					newmap[i][j] = '1';
					result[1]++;
				}
			}
		}
		
		//结果去result中大的那一个
		if (result[0] > result[1]) {
			System.out.println("结果为:" + result[0]);
		}else {
			System.out.println("结果为:" + result[1]);
		}
	}
}