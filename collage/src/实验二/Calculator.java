package 实验二;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {

	public static int order(char c) {

		switch (c) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		case '(':
			return 0;
		default:
			break;
		}
		return 0;

	}

	/*
	 * 将中缀表达式转化成后缀表达式，规则： 1.初始化一个运算符栈。 2.从算数表达式输入的字符串中依次从左向右每次读取一个字符。
	 * 3.如果当前字符是操作数，则直接填写到后缀表达式。 4.如果当前字符是（左括号，将其压入运算符栈（第一步定义）。 5.如果当前字符为运算符，则
	 * 5.1.当运算符栈为空，则将其压入运算符栈。
	 * 5.2.当此运算符的优先级高于栈顶元素的时候，则将此运算符压入运算符栈；否则，弹出栈顶运算符到后缀表达式，并且将当前运算符压栈。回到步骤2.
	 * 6.如果当前字符是）右括号，反复将栈顶元素弹出到后缀表达式，直到栈顶元素是左括号（为止，并将左括号从栈中弹出丢弃。 7.如果读取还未完成，回到步骤2.
	 * 8.如果读取完成，则将栈中剩余的运算符依次弹出到后缀表达式。
	 */
	public static String transform(String string) {

		Stack<Character> operators = new Stack<>();// 初始化运算符栈
		String newString = "";

		for (int i = 0; i < string.length(); i++) {// 依次读取字符
			char c = string.charAt(i);
			// 3
			if (Character.isDigit(c)) {
				newString += c;
			}
			// 4
			else if (c == '(') {
				operators.push(c);
			}
			// 6
			else if (c == ')') {
				char temp;
				while ((temp = operators.peek()) != '(') {
					newString += temp;
					operators.pop();
				}
				operators.pop();
			}
			// 5
			// 5.1
			else {
				if (operators.isEmpty()) {
					operators.push(c);
				}
				// 5.2
				else {
					if (order(c) > order(operators.peek())) {
						operators.push(c);
					} else {

						newString += operators.pop();
						operators.push(c);
					}
				}
			}
		}
		// 8
		while (!operators.isEmpty())
			newString += operators.pop();
		return newString;
	}

	/*
	 * 利用转化后的后缀表达式，根据栈规律进行计算 1.当前字符为操作符，从栈中取出两个树，根据操作符来运算，将运算结果放入到栈中
	 * 2.重复，直到将字符操作完，此时栈中只剩下一个元素，即要运算的结果
	 */
	public static int calc(String string) {

		Stack<Integer> result = new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			// 1,2
			Character c = string.charAt(i);

			// Integer.parseInt(String.valueOf( char ) --> 这句话的功能是将char 转化为int
			if (Character.isDigit(c)) {
				Integer num = Integer.parseInt(String.valueOf(c));
				result.push(num);
			} else {
				Integer a = Integer.parseInt(String.valueOf(result.pop()));
				Integer b = Integer.parseInt(String.valueOf(result.pop()));
				// a先取出来，b后取出来。所以是b操作a
				switch (c) {
				case '+':
					result.push(b + a);
					break;
				case '-':
					result.push(b - a);
					break;
				case '*':
					result.push(b * a);
					break;
				case '/':
					if (a == 0) {
						System.out.println("除数不能为0");
						return 0;
					}
					result.push(b / a);
					break;
				default:
					break;
				}
			}
		}
		return result.pop();
	}

	// 树的基本结构
	public static class myTree {
		myTree leftChildTree;
		myTree righChildTree;
		char data;

		public myTree() {
			// TODO Auto-generated constructor stub
			this(null, null, 'x');
		}

		public myTree(myTree lefTree, myTree righTree, char data) {
			this.data = data;
			this.leftChildTree = lefTree;
			this.righChildTree = righTree;
		}
	}

	// 利用得到的后缀表达式,构建表达式树
	private static void buildExpTree(String posterExp) {
		// TODO Auto-generated method stub
		Stack<myTree> tempStack = new Stack<Calculator.myTree>();
		for (int i = 0; i < posterExp.length(); i++) {
			// 如果是数字,压入栈
			char achar = posterExp.charAt(i);
			myTree temptTree = new myTree(null, null, achar);
			if (Character.isDigit(achar)) {
				tempStack.push(temptTree);
			}
			// 如果是操作符,此操作符作为树节点,前面两个数字pop出来作为此节点的左右孩子
			else {
				temptTree.righChildTree = tempStack.pop();
				temptTree.leftChildTree = tempStack.pop();
				tempStack.push(temptTree);
			}
		}
		myTree rootTree = tempStack.pop();
		System.out.print("root");
		printData(rootTree);
	}
	//递归遍历,打印出树的数据
	public static void printData(myTree rootTree) {
		if (rootTree.leftChildTree != null && rootTree.righChildTree != null) {
			System.out.println("节点: " + rootTree.data);
			System.out.println("此节点左孩子: " + rootTree.leftChildTree.data);
			System.out.println("此节点右孩子: " + rootTree.righChildTree.data);
		}
		if (rootTree.leftChildTree == null && rootTree.righChildTree != null) {
			System.out.println("节点: " + rootTree.data);
			System.out.println("此节点左孩子: " + "null");
			System.out.println("此节点右孩子: " + rootTree.righChildTree.data);
		}
		if (rootTree.leftChildTree != null && rootTree.righChildTree == null) {
			System.out.println("节点: " + rootTree.data);
			System.out.println("此节点左孩子: " + rootTree.leftChildTree.data);
			System.out.println("此节点右孩子: " + "null");
		}
		if(rootTree.leftChildTree != null ) printData(rootTree.leftChildTree);
		if(rootTree.righChildTree != null) printData(rootTree.righChildTree);
	}
	// 主程序，测试
	// 限制为：计算结果若除运算为小数或者多位数，不能处理
	public static void main(String args[]) {

		// 计算测试
		Scanner in = new Scanner(System.in);
		System.out.println("请输入要计算的算式: ");
		String string = in.nextLine();
		String newstring = transform(string);
		System.out.println("转换后的后缀表达式为：" + newstring);
		int result = calc(newstring);
		System.out.println("计算后的结果为：" + string + "=" + result + "\r");
		in.close();

		// 表达式树测试
		System.out.println("构建的表达式树测试");
		buildExpTree(newstring);
	}

}
