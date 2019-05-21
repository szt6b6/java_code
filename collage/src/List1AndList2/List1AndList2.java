package List1AndList2;

public class List1AndList2 {

	// And操作方法
	public static <AnyType> void funcAnd(MyList<AnyType> list1, MyList<AnyType> list2) {

		MyList<AnyType> newList = new MyList<>();
		for (int i = 0; i < list1.length(); i++)
			for (int j = 0; j < list2.length(); j++) {
				if (list1.get(i) == list2.get(j))
					newList.add(list1.get(i));
			}

		print(newList);
	}

	// 打印数组的方法
	public static <AnyType> void print(MyList<AnyType> list) {
		for (int i = 0; i < list.length(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println("\r");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Integer 类型测试
		System.out.println("And 操作测试 1.Integer 类型测试");
		MyList<Integer> a = new MyList<Integer>();
		for (int i = 4; i < 11; i++)
			a.add(i);
		print(a);
		MyList<Integer> b = new MyList<Integer>();
		for (int i = 7; i < 15; i++)
			b.add(i);
		print(b);

		funcAnd(a, b);

		// String 类型测试
		System.out.println("And 操作测试 1.String 类型测试");
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
		funcAnd(c, d);
	}

}
