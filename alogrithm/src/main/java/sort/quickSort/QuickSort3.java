package sort.quickSort;

/**
 * 优化不必要的交换
 * 
 * @author Jin
 * 
 */
public class QuickSort3 {
	public static void QuickSort(int[] arr) {
		QSort(arr, 0, arr.length - 1);
	}

	// 对顺序表子序列作快速排序 待排序序列的最小下标值low和最大下标值high
	public static void QSort(int[] arr, int low, int high) {
		int pivot;
		if (low < high) {
			pivot = Partition(arr, low, high);// 将数组子序列一分为二
			QSort(arr, low, pivot - 1);// 对低子表递归排序
			QSort(arr, pivot + 1, high);// 对高子表递归排序
		}
	}

	// 选择一个关键字，想尽办法将它放到一个位置，使得它左边的值都比它小，
	// 右边的值都比它大，我们称这个关键字叫枢轴。
	public static int Partition(int[] arr, int low, int high) {
		if (arr == null || low < 0 || high >= arr.length) {
			new Exception();
		}
		int pivotkey;
		pivotkey = arr[low];// 选取第一个记录作枢轴记录

		int tempCopy = pivotkey;// 将枢轴值备份到tempCopy中

		while (low < high) {// 从表的两端向中间扫描
			while (low < high && arr[high] >= pivotkey) {// 如果大于枢轴值，则下标减一，否则，跳出循环。
				high--;
			}
			// Swap(arr, low, high);//交换
			arr[low] = arr[high];// 采用替换而不是交换的方式进行操作
			while (low < high && arr[low] < pivotkey) {// 如果小于枢轴值，则下标加一，否则，跳出循环。
				low++;
			}
			// Swap(arr, low, high);//交换
			arr[high] = arr[low];// 采用替换而不是交换的方式进行操作
		}
		arr[low] = tempCopy;// 将枢轴值替换回arr[low]
		return low;// 返回枢轴值所在位置
	}

	public static void Swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
		QuickSort(arr);
		for (int array : arr) {
			System.out.print(array + " ");
		}
		System.out.println();
	}
}
