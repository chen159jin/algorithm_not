package sort;

import java.util.Arrays;
/**
 *  冒泡排序
 * @author Jin
 *
 */
public class BubbleSort {
	public static void main(String[] args) {

		int[] ints = { 7, 6, 5, 4, 3, 2, 1 };
		bubbleSort(ints);
	}

	public static void bubbleSort(int[] numbers) {
		int temp = 0;
		int size = numbers.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) // 交换两数位置
				{
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
			 System.out.println("第"+i+"次排序结果："+Arrays.toString(numbers));
		}
		System.out.println(Arrays.toString(numbers));
	}
}
