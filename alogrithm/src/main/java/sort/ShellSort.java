package sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] a = {49,38,65,97,76,13,27,49,55,04};
		shellSort(a);
		// 输出排序后的数组
		System.out.println(Arrays.toString(a));

	}

	public static void shellSort(int[] a) {
		// 将数组分组
		int count =0;
	//	System.out.println(Arrays.toString(a));
		for (int r = a.length / 2; r >= 1; r /= 2) {
			// 这里的思路和插入排序的思路相同，通过找到前一个的数大于或者小于来进行插入
			boolean flag = false;
			for (int i = r; i < a.length; i += r) {
				int temp = a[i];
				int j = i - r;
				while (j >= 0 && temp < a[j]) {
					a[j + r] = a[j];
					flag = true;
//					System.out.print("r = "+r+"处理第"+i+"个 与第"+j+"个:");
					j -= r;
				}
				a[j + r] = temp;
				if(flag){
		//			System.out.println(Arrays.toString(a));
				}
			}
		//	System.out.println("第"+(count++)+"趟:"+Arrays.toString(a));
		}
	}
}
