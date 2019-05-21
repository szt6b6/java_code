package List1AndList2;

import java.util.Arrays;
import java.util.Iterator;

public class MyList<T> implements Iterable<T> {
	/*
	 * 设计一种容器:可以不初始化长度,长度可以自动拓展
	 */
	private int length = 10;// 定义初始化容量大小的变量
	private Object[] arr = new Object[length];// 建立数组用于存储元素
	private int index = 0;// 建立整数索引,用于记录当前有几个元素

	public MyList(int length) {
		this.length = length;
	}

	public MyList() {
	}

	// 添加元素的方法
	public void add(T obj) {
		// 如果元素超出了当前数组的长度,那么需要扩展长度
		if (index >= arr.length) {
			// 将原本的元素拷贝到新数组,并且数组长度增加10
			Object[] newArr = Arrays.copyOf(arr, arr.length + 10);
			arr = newArr;
		}
		arr[index++] = obj;// 往数组内添加元素,之后索引自增1
	}

	// 获取元素
	@SuppressWarnings("unchecked")
	public T get(int index) {
		checkIndex(index);
		return (T) arr[index];
	}

	// 定义方法,验证下标
	private void checkIndex(int index) {
		if (index >= this.index) {
			throw new IndexOutOfBoundsException("下标越界:" + index);
		}
	}

	// 删除方法
	public void remove(int index) {
		checkIndex(index);
		Object[] newArr = new Object[arr.length];
		// 现将需要删除的元素的前面的所有元素复制
		System.arraycopy(arr, 0, newArr, 0, index);
		// 复制要删除元素的后面的所有的元素
		System.arraycopy(arr, index + 1, newArr, index, this.index - index - 1);
		this.index--;
		arr = newArr;
	}

	// set方法
	public void set(int index, T obj) {
		checkIndex(index);
		arr[index] = obj;
	}

	// toString
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < index; i++) {
			sb.append(arr[i]);
			if (i < index - 1) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	// length
	public int length() {
		return index;
	}

	// addAll
	public void addAll(MyList<T> mm) {
		for (int i = 0; i < mm.length(); i++) {
			this.add(mm.get(i));
		}
	}

	// toArray
	public Object[] toArray() {
		Object[] res = Arrays.copyOf(arr, index);
		return res;
	}

	// remove
	public void remove(T t) {
		for (int i = 0; i < index; i++) {
			if (arr[i].equals(t)) {
				this.remove(i);
			}
		}
	}

	// removeAll
	public void removeAll(MyList<T> mm) {
		for (int i = 0; i < mm.length(); i++) {
			this.remove(mm.get(i));
		}
	}

	// insert
	public void insert(int index, T t) {
		checkIndex(index);
		// 建立新数组
		Object[] newArr = new Object[arr.length + 1];
		// 复制将要添加的元素索引的之前的所有元素
		System.arraycopy(arr, 0, newArr, 0, index);
		newArr[index] = t;// 将要插入的元素放入新数组的指定位置
		System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
		this.index++;
		arr = newArr;
	}

	@Override
	public Iterator<T> iterator() {

		Iterator<T> ite = new Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				if (index < MyList.this.index) {
					return true;
				} else {
					return false;
				}
			}

			@SuppressWarnings("unchecked")
			@Override
			public T next() {
				return (T) arr[index++];
			}
		};
		return ite;
	}
}