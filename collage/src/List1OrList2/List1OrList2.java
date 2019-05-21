package List1OrList2;

public class List1OrList2 {

	//或操作方法
	public static <AnyType> void funcOr(MyList<AnyType> list1, MyList<AnyType> list2) {

		MyList<AnyType> totalList = new MyList<>();
		for (int i = 0; i < list1.length(); i++)
			totalList.add(list1.get(i));

		MyList<AnyType> tempList = new MyList<>();
		for (int i = 0; i < list2.length(); i++)
			tempList.add(list2.get(i));

		for (int i = 0; i < list1.length(); i++)
			for (int j = 0; j < tempList.length(); j++) {
				if (list1.get(i) == tempList.get(j))
					removeElement(tempList, j--);
			}
		for (int i = 0; i < tempList.length(); i++)
			totalList.add(tempList.get(i));

		print(totalList);
	}

	//去除对应位置元素的方法
	public static <AnyType> void removeElement(MyList<AnyType> list, int index) {
		list.remove(index);
	}
	
	//打印数组的方法
	public static <AnyType> void print(MyList<AnyType> list) {
		for (int i = 0; i < list.length(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println("\r");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Integer 类型测试
		System.out.println("Or 操作方法测试 1.Integer 类型测试");
		MyList<Integer> a = new MyList<Integer>();
		for (int i = 4; i < 11; i++)
			a.add(i);
		print(a);
		MyList<Integer> b = new MyList<Integer>();
		for (int i = 7; i < 15; i++)
			b.add(i);
		print(b);

		funcOr(a, b);

		// String 类型测试
		System.out.println("Or 操作方法测试 1.String 类型测试");
		MyList<String> c = new MyList<>();
		c.add("a");
		c.add("f");
		c.add("g");
		c.add("h");
		print(c);
		MyList<String> d = new MyList<>();
		d.add("f");
		d.add("g");
		d.add("b");
		d.add("v");
		print(d);
		funcOr(c, d);

	}

}
