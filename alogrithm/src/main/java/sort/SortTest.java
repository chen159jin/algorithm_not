package sort;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sort.bubbleSort.BubbleSort;
import sort.bubbleSort.CocktailSort;
import sort.quickSort.ArraysSort;
import sort.quickSort.QuickSort;

public class SortTest {

	int[] a = new int[1000];
	@Before
	public void data() {
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			a[i] = (int)Math.abs(r.nextInt()%10000);
		}
	}
	
	@Test
	public void testRadixSort() {//需要设置条件 速度最快
		RadixSort.radixSort(a, 10000);
	}
	
	@Test
	public void testSort() {
		Arrays.sort(a);//小于7 选择排序 否则 快速排序
	}
	@Test
	public void testArraysSort() {
		ArraysSort.sort(a);//小于7 选择排序 否则 快速排序
	}
	@Test
	public void testQuickSort() {
		QuickSort.sort(a);
	}
	@Test
	public void testHeapSort() {
		HeapSort.heapSort(a);
	}

	@Test
	public void testMergeSort() {
		MergeSort.mergeSort(a);
	}

	@Test
	public void testInsertSort() {
		InsertSort.InsertSort(a);
	}
	@Test
	public void testShellSort() {
		ShellSort.shellSort(a);
	}
	@Test
	public void testSelectionSort() {
		SelectionSort.selectionSort(a);
	}
	@Test
	public void testBubbleSort() {
		//BubbleSort.bubbleSort(a);
		CocktailSort.bubbleSort2(a);
	}
	
}
