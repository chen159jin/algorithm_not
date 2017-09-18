package dynamicPlanning;

import java.util.HashMap;
import java.util.Map;
/**
 * 动态规划 硬币找零 
 * @author Jin
 *
 */
public class CoinProblem {
	public static void main(String[] args) {
		changeCoins(new int[] { 1, 3, 5,10,100 }, 123);
	}

	/**
	 * @param coins
	 *            保存每一种硬币的币值的数组
	 * @param money
	 *            需要找零的面值
	 */
	public static void changeCoins(int[] coins, int money) {
		int[] coinsUsed = new int[money + 1]; // 保存面值为i的纸币找零所需的最小硬币数
		coinsUsed[0] = 0; // 0元的最优解
		Map<Integer, Map<Integer, Integer>> coinChangeMap = new HashMap<Integer, Map<Integer, Integer>>();

		for (int cents = 1; cents <= money; cents++) {
			// 当用最小币值的硬币找零时，所需硬币数量最多
			int minCoins = cents;
			Map<Integer, Integer> minCoinMap = new HashMap<Integer, Integer>();// 保存各个面值的具体找零方案
			minCoinMap.put(1, cents);
			coinChangeMap.put(cents, minCoinMap);
			
			for (int i = 0; i < coins.length; i++) {// 遍历每一种面值的硬币，看是否可作为找零的其中之一
				int coinVal = coins[i];
				int oppCoinVal = cents - coinVal;//当前面值-本轮遍历的面值= 以前某面值的最小硬币数的面值  从而得到以前的最小硬币数
				if (coins[i] <= cents) { // 若当前面值的硬币小于当前的cents则分解问题并查表
					int tmpCount = coinsUsed[oppCoinVal] + 1;//硬币数量
					if (tmpCount <= minCoins) {
						HashMap<Integer, Integer> subMap = (HashMap<Integer, Integer>) coinChangeMap
								.get(Integer.valueOf(oppCoinVal));// 子问题的最优解
						HashMap<Integer, Integer> tmpMap = new HashMap<Integer, Integer>();
						if (subMap != null) {// 要copy一份数据
							tmpMap.putAll(subMap);
						}
						if (tmpMap.containsKey(coins[i])) {// 如果已经包含当前面值，则加一
							tmpMap.put(coins[i], subMap.get(coins[i]) + 1);
						} else {
							tmpMap.put(coins[i], 1);
						}
						minCoins = tmpCount;
						minCoinMap = tmpMap;
					}
				}
			}
			// 保存最小硬币数
			coinsUsed[cents] = minCoins;
			coinChangeMap.put(cents, minCoinMap);

			System.out.println("面值为 " + (cents) + " 的最小硬币数 : "
					+ coinsUsed[cents] + ",货币为" + coinChangeMap.get(cents));
		}
	}
}
