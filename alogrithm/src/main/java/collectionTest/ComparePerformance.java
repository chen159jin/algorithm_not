package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class ComparePerformance {

	private static final int SIZE = 100000;

	public static abstract class Test {
		private String operation;

		public Test(String operation) {
			this.operation = operation;
		}

		public abstract void test(List<String> list);

		public String getOperation() {
			return operation;
		}
	}

	// 执行迭代操作的匿名类
	static Test iterateTest = new Test("iterate") {
		public void test(List<String> list) {
			for (int i = 0; i < 10; i++) {
				Iterator<String> it = list.iterator();
				while (it.hasNext()) {
					it.next();
				}
			}
		}
	};
	// 执行随机访问的匿名类
	static Test getTest = new Test("get") {
		public void test(List<String> list) {
			for (int i = 0; i < list.size(); i++) {
				for (int k = 0; k < 10; k++) {
					list.get(k);
				}
			}
		}
	};
	// 执行插入的匿名类
	static Test insertTest = new Test("insert") {
		public void test(List<String> list) {
			ListIterator<String> it = list.listIterator(list.size() / 2);
			for (int i = 0; i < SIZE; i++) {
				it.add("lion");
			}
		}
	};
	// 执行删除的匿名类
	static Test removeTest = new Test("remove") {
		public void test(List<String> list) {
			ListIterator<String> it = list.listIterator();
			while (it.hasNext()) {
				it.next();
				it.remove();
			}
		}
	};

	static public void testArray(List<String> list) {
		Test[] tests = { iterateTest, getTest };
		test(tests, list);
	}

	static public void testList(List<String> list) {
		Test[] tests = { insertTest, iterateTest, getTest, removeTest };
		test(tests, list);
	}

	static public void test(Test[] tests, List<String> list) {
		for (int i = 0; i < tests.length; i++) {
			System.out.print(tests[i].getOperation() + "操作：");
			long t1 = System.currentTimeMillis();
			tests[i].test(list);
			long t2 = System.currentTimeMillis();
			System.out.print(t2 - t1 + "ms");
			System.out.println();
		}
	}

	public static void main(String[] args) {

		List<String> list = null;
		// 测试数组的迭代和随机访问操作
		System.out.println("------测试数组------");
		String[] tstr = new String[SIZE];
		Arrays.fill(tstr, "lion");
		list = Arrays.asList(tstr);
		testArray(list);

		tstr = new String[SIZE / 2];
		Collection<String> coll = Arrays.asList(tstr);

		// 测试Vector
		System.out.println("------测试Vector------");
		list = new Vector<String>();
		list.addAll(coll);
		testList(list);

		// 测试LinkedList
		System.out.println("------测试LinkedList------");
		list = new LinkedList<String>();
		list.addAll(coll);
		testList(list);

		// 测试ArrayList
		System.out.println("------测试Vector------");
		list = new ArrayList<String>();
		list.addAll(coll);
		testList(list);
	}
}
