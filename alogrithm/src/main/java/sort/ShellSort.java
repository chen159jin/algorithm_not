package sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] a = {7,6,5,4,3,2,1};
		shellSort(a);
		// 输出排序后的数组
		System.out.println(Arrays.toString(a));

	}

	private static void shellSort(int[] a) {
		// 将数组分组
		System.out.println(Arrays.toString(a));
		for (int r = a.length / 2; r >= 1; r /= 2) {//3,1
			// 这里的思路和插入排序的思路相同，通过找到前一个的数大于或者小于来进行插入
			for (int i = r; i < a.length; i += r) {
				int temp = a[i];
				int j = i - r;
				while (j >= 0 && temp < a[j]) {
					System.out.println("r = "+r+"处理第"+i+"个 与第"+j+"个:"+Arrays.toString(a));
					a[j + r] = a[j];
					j -= r;
				}
				a[j + r] = temp;
			}
			System.out.println(Arrays.toString(a));
		}
	}
	/*			
[7, 6, 5, 4, 3, 2, 1]
r = 3处理第3个 与第0个:[7, 6, 5, 4, 3, 2, 1]
r = 3处理第6个 与第3个:[4, 6, 5, 7, 3, 2, 1]
r = 3处理第6个 与第0个:[4, 6, 5, 7, 3, 2, 7]
[1, 6, 5, 4, 3, 2, 7]
r = 1处理第2个 与第1个:[1, 6, 5, 4, 3, 2, 7]
r = 1处理第3个 与第2个:[1, 5, 6, 4, 3, 2, 7]
r = 1处理第3个 与第1个:[1, 5, 6, 6, 3, 2, 7]
r = 1处理第4个 与第3个:[1, 4, 5, 6, 3, 2, 7]
r = 1处理第4个 与第2个:[1, 4, 5, 6, 6, 2, 7]
r = 1处理第4个 与第1个:[1, 4, 5, 5, 6, 2, 7]
r = 1处理第5个 与第4个:[1, 3, 4, 5, 6, 2, 7]
r = 1处理第5个 与第3个:[1, 3, 4, 5, 6, 6, 7]
r = 1处理第5个 与第2个:[1, 3, 4, 5, 5, 6, 7]
r = 1处理第5个 与第1个:[1, 3, 4, 4, 5, 6, 7]
[1, 2, 3, 4, 5, 6, 7]
[1, 2, 3, 4, 5, 6, 7]*/
}
