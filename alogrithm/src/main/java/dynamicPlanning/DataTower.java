package dynamicPlanning;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 数塔
 *  从数塔的顶层出发，在每一个结点可以选择向左走或者向右走，一直走到最底层，要求找出一条路径，使得路径上的数值和最大。
 *  
 *   先求解初始子问题：底层的每个数字可以看作1层数塔，则最大数值和就是其自身。
 *   再求解下一个阶段的子问题：
 *   	往上一层的决策是在底层决策的基础上进行求解，对每个数塔进行求解。 以此往上推。
 * @author Jin
 *
8
2 5
3 9 6
8 10 5 12 
16 4 18 10 9
 */
public class DataTower {
	public static void main(String[] args) {
		System.out.print("输入数组的层数: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();// 定义数塔层数n;
		int d[][] = new int[n][n];
		System.out.print("输入数组元素：");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= j)
					d[i][j] = scan.nextInt();
			}
		}
		int result = dataTower(d);
	}

	public static int dataTower(int tower[][]) {
		int heigh = tower.length;// 数塔高度
		int len = tower[heigh - 1].length;// 数塔底部宽度
		int[][] resultTower = new int[heigh][len];// 结果数塔，存放路径数值和
		int[][] path = new int[heigh][len];// 计算结果数塔生成路径

		// 初始化结果数塔
		for (int i = 0; i < len; i++) {
			resultTower[heigh - 1][i] = tower[heigh - 1][i];
		}
		for (int i = heigh - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (resultTower[i + 1][j] > resultTower[i + 1][j + 1]) {
					resultTower[i][j] = tower[i][j] + resultTower[i + 1][j];
					path[i][j] = j;
				} else {
					resultTower[i][j] = tower[i][j] + resultTower[i + 1][j + 1];
					path[i][j] = j + 1;
				}
			}
			
			System.out.println("第"+i+"排加上其下排的最大值:"+Arrays.toString(resultTower[i]));
			System.out.print("第 "+i+"排与 "+(i+1)+"排的路径关系的值:"+tower[i+1][0]);
			for (int j = 1; j < heigh - 1; j++) {
				System.out.print(";" + tower[i+1][path[i][j]]);
			}
			System.out.println();
			System.out.println("第 "+i+"排与 "+(i+1)+"排的路径关系的值:"+Arrays.toString(path[i]));
		}

		// 打印路径
		System.out.println("最大数值和为" + resultTower[0][0] + "\n");
		System.out.print("路径为：" + tower[0][0]);
		int j = path[0][0];
		for (int i = 1; i <= heigh - 1; i++) {
			System.out.print("->" + tower[i][j]);
			j = path[i][j];
		}
		System.out.println();

		return resultTower[0][0];
	}

}
