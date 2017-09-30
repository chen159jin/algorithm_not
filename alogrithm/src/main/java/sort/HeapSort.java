package sort;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] array = { 5, 4, 2, 8, 6, 9 };
		System.out.print("Before heap:     ");
		System.out.println(Arrays.toString(array));
		heapSort(array);
		System.out.print("After heap sort: ");
		System.out.println(Arrays.toString(array));
	}

	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		buildMaxHeap(array);
	//	System.out.println("After buildMaxHeap: "+Arrays.toString(array));
		for (int i = array.length - 1; i >= 1; i--) {
			exchangeElements(array, 0, i);
			maxHeap(array, i, 0);
		}
	}

	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}

	private static void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		int largest = index;
		if (left < heapSize && array[left] > array[index]) {//找到最大值
			largest = left;
		}
		if (right < heapSize && array[right] > array[largest]) {//找到最大值
			largest = right;
		}
		if (index != largest) {
			exchangeElements(array, index, largest);
			maxHeap(array, heapSize, largest);
		}
	//	System.out.println("maxHeap:处理"+index+" left="+left+"  right="+left+" 结果: "+Arrays.toString(array));
	}

	public static void exchangeElements(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
