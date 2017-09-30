package sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author Jin
 *第一个元素是有序队列，从第二个元素开始向有序队列中插入，插入完成后将第三个元素向有序队列中插入，依次进行，直到将最后一个元素插入完毕。
 */
public class InsertSort {
	public static void main(String[] args) {
		 int[] ints = {49,38,65,97,76,13,27,49};
		 InsertSort(ints);
	}
	
	public static void InsertSort(int[] arr) {
		int i, j;
		int n = arr.length;
		int target;
//		System.out.println(Arrays.toString(arr));	
		// 假定第一个元素被放到了正确的位置上
		// 这样，仅需遍历1 - n-1
		for (i = 1; i < n; i++) {//对第i个进行排序
			j = i;
			target = arr[i];

			while (j > 0 && target < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}

			arr[j] = target;
//			System.out.println("第"+i+"遍: "+Arrays.toString(arr));
		}
//		System.out.println(Arrays.toString(arr));
	}
}
