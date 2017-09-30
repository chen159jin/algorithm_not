package sort.bubbleSort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 
 * @author Jin
 * 
 */
public class BubbleSort {
	public static void main(String[] args) {

		int[] ints = { 7, 6, 5, 4, 3, 2, 1 };
		bubbleSort(ints);
	}

	public static void bubbleSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) { // 交换两数位置
					sweap(numbers, j);
				}
			}
			// System.out.println("第"+i+"次排序结果："+Arrays.toString(numbers));
		}
		// System.out.println(Arrays.toString(numbers));
	}

	private static void sweap(int[] numbers, int j) {
		int temp;
		temp = numbers[j];
		numbers[j] = numbers[j + 1];
		numbers[j + 1] = temp;
	}
}
