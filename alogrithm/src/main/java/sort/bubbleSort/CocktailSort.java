package sort.bubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 对冒泡排序的两种改进
 * 　鸡尾酒排序   每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者)
 * 
 *没有进行数据交换，则说明数据已经按要求排列好，可立即结束排序，避免不必要的比较过程。
 * 
 * 
 * @author Jin
 * 
 */
public class CocktailSort {

	public static void main(String[] args) {
		int[] a = new int[10000];
		int[] a2 = new int[10000];
		int[] cocktail = new int[10000];
		Random  r = new Random();
		for (int i = 0; i < 10000; i++) {
			a[i] =r.nextInt();
			a2[i] = a[i];
			cocktail[i] = a[i];
		}
		//System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(a2));
		long timeStart = System.currentTimeMillis();
		//int[] cocktail = { 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 11, 99 };
		cocktailSort(cocktail);
		long timeEnd = System.currentTimeMillis();
		bubbleSort(a);
		long timeF= System.currentTimeMillis();
		//int[] a2 = { 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 11, 99 };
		bubbleSort2(a2);
		long time= System.currentTimeMillis();
		System.out.println("cocktail="+(timeEnd-timeStart+";a="+(timeF-timeEnd)+ ";a2="+(time-timeF)));
		//System.out.println(Arrays.toString(cocktail)); 	
		//System.out.println(Arrays.toString(a));			
		//System.out.println(Arrays.toString(a2));
	}

	public static void cocktailSort(int[] cints) {
		int sum = 0;
		// 将最小值排到队尾
		for (int i = 0; i < (cints.length/2)+1; i++) {

			for (int j = i; j < cints.length - i - 1; j++) {
				sum++;
				if (cints[j] > cints[j + 1]) {
					int temp = cints[j];
					cints[j] = cints[j + 1];
					cints[j + 1] = temp;
				}
			//	System.out.println("交换小" + Arrays.toString(cints) + "j=" + j+ " i=" + i);
			}
			// 将最大值排到队头
			for (int j = cints.length - 1 - (i + 1); j > i; j--) {
				sum++;
				if (cints[j] < cints[j - 1]) {
					int temp = cints[j];
					cints[j] = cints[j - 1];
					cints[j - 1] = temp;
				}

			//	System.out.println("交换大" + Arrays.toString(cints) + "j=" + j	+ " i=" + i);
			}

		//	System.out.println("第" + i + "次排序结果：" + Arrays.toString(cints));
		}
//		System.out.println("总次数" + sum);
	}

	public static void bubbleSort2(int[] bints) {
		int sum = 0;
		for (int i = 0; i < bints.length; i++) {
			boolean exchange = false;
			for (int j = 0; j < bints.length - i - 1; j++) {
				sum++;
				if (bints[j] > bints[j + 1]) {
					int temp = bints[j];
					bints[j] = bints[j + 1];
					bints[j + 1] = temp;
					exchange = true;
				}
			}
		//	System.out.println("第" + i + "次排序结果：" + Arrays.toString(bints));

			if (!exchange) {
				break;
			}

		}

		/*for (int i : bints) {
			System.out.print(i + " ");
		}*/

//		System.out.println("总次数" + sum);
	}

	public static void bubbleSort(int[] numbers) {
		int temp = 0;
		int sum = 0;
		int size = numbers.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				sum++;
				if (numbers[j] > numbers[j + 1]) // 交换两数位置
				{
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
	//		 System.out.println("第"+i+"次排序结果："+Arrays.toString(numbers));
		}
	//	System.out.println(Arrays.toString(numbers));
//		System.out.println("总次数" + sum);
	}
}
