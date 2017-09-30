package sort.quickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * 
 * @author Jin
 * 
 */
public class QuickSort {
	public static void main(String[] args) {
		/*int[] cocktail = new int[1000];
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			cocktail[i] = r.nextInt();
		}*/
		int[] ints = { 4, 6, 5, 7, 3, 2, 1, 8, 0 };
		sort(ints);
	}
	public static void sort(int[] a){
		sort(a, 0, a.length - 1);
	}
	
	public static void sort(int[] a, int low, int high) {
		int start = low;
		int end = high;
		int key = a[low];

		while (end > start) {
	//		System.out.println(Arrays.toString(a));
			// 从后往前比较
			while (end > start && a[end] >= key)
				// 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
				end--;
			if (a[end] <= key) {
				Swap(a, start, end);
			}
	//		System.out.println("第一个while: " + Arrays.toString(a));
			// 从前往后比较
			while (end > start && a[start] <= key)
				// 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
				start++;
			if (a[start] >= key) {
				Swap(a, end, start);
			}
	//		System.out.println("第二个while: " + Arrays.toString(a));
			// 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
			// System.out.println("第"+i+"次排序结果："+Arrays.toString(a));

		}
		// 递归
		if (start > low)
			sort(a, low, start - 1);// 左边序列。第一个索引位置到关键值索引-1
		if (end < high)
			sort(a, end + 1, high);// 右边序列。从关键值索引+1到最后一个
	}
	private static void Swap(int[] a, int start, int end) {
		int temp = a[end];
		a[end] = a[start];
		a[start] = temp;
	}

}
