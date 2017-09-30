package sort.quickSort;

import java.util.Arrays;

/**
 * 优化选取枢轴
 * 
 * 三数取中，即取三个关键字先进行排序，将中间数作为枢轴， 一般是取左端、右端和中间三个数， 也可以随机选取。
 * 对于非常大的待排序的序列来说还是不足以保证能够选择出一个好的pivo tkey，
 * 因此还有个办法是所谓的九数取中，先从数组中分三次取样，每次取三个数，三个样品各取出中数，然后从这三个中数当中再取出一个中数作为枢轴 。
 * 
 * @author Jin
 * 
 */
public class QuickSort2 {
	public static void QuickSort(int[] arr) {
		Sort(arr, 0, arr.length - 1);
	}

	// 对顺序表子序列作快速排序 待排序序列的最小下标值low和最大下标值high
	public static void Sort(int[] arr, int low, int high) {
		int pivot;
		if (low < high) {
			pivot = Partition(arr, low, high);// 将数组子序列一分为二

			Sort(arr, low, pivot - 1);// 对低子表递归排序
			Sort(arr, pivot + 1, high);// 对高子表递归排序
		}
		
	}

	// 选择一个关键字，想尽办法将它放到一个位置，使得它左边的值都比它小，
	// 右边的值都比它大，我们称这个关键字叫枢轴。
	public static int Partition(int[] arr, int low, int high) {

		if (arr == null || low < 0 || high >= arr.length) {
			new Exception();
		}
		int pivotkey;
		ChoosePivotkey(arr, low, high);// 选取枢轴值
		pivotkey = arr[low];
		while (low < high) {// 从表的两端向中间扫描
			while (low < high && arr[high] >= pivotkey) {// 如果大于枢轴值，则下标减一，否则，跳出循环。
				high--;
			}
			Swap(arr, low, high);// 交换
			while (low < high && arr[low] < pivotkey) {// 如果小于枢轴值，则下标加一，否则，跳出循环。
				low++;
			}
			Swap(arr, low, high);// 交换
		}
		return low;
	}

	public static void Swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}

	// 三数取中 选择枢轴 将枢轴值调至第一个位置
	public static void ChoosePivotkey(int[] arr, int low, int high) {
		int mid = low + (int) (high - low) / 2;
		System.out.println("mid=" + mid + ": " + Arrays.toString(arr));
		if (arr[low] > arr[high]) {// 保证左端较小
			Swap(arr, low, high);
		}
		if (arr[mid] > arr[high]) {// 保证中间较小
			Swap(arr, mid, high);
		}
		// 此时最大值在最右边
		if (arr[mid] < arr[low]) {// 保证左端较小
			Swap(arr, mid, low);
		}
		System.out.println("low=" + mid + ": " + Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 4, 6, 5, 7, 3, 2, 1, 8, 0 };
		// sort(ints, 0, ints.length - 1);
		QuickSort(arr);
		for (int array : arr) {
			System.out.print(array + " ");
		}
		System.out.println();
	}
}
