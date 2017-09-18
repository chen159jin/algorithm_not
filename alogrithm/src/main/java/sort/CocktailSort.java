package sort;

import java.util.Arrays;
/**
 * 　鸡尾酒排序
 * @author Jin
 *
 */
public class CocktailSort {

    public static void main(String[] args) {

       int[] ints = {7,6,5,4,3,2,1};
        cocktailSort(ints);
//            bubleSort(ints);
        }

    public static void cocktailSort(int[] cints){

        int sum = 0 ;
        //将最小值排到队尾
      for (int i = 0 ; i < cints.length; i++){

          for (int j = i; j<cints.length-i-1 ; j++) {

              if (cints[j] > cints[j+1]){

                  sum ++;
                  int temp = cints[j];
                  cints[j] = cints[j+1];
                  cints[j+1] = temp;
              }

              System.out.println("交换小"+ Arrays.toString(cints)+"j="+j+" i="+i);
          }

          //将最大值排到队头
          for(int j = cints.length-1-(i+1); j > i ; j--)

          {

              if(cints[j] < cints[j-1])

              {

                  sum++;
                  int temp = cints[j];
                  cints[j] = cints[j-1];
                  cints[j-1] = temp;
              }

              System.out.println("交换大"+Arrays.toString(cints)+"j="+j+" i="+i);
          }

          System.out.println("第"+i+"次排序结果："+Arrays.toString(cints));
      }

        System.out.println(sum);
    }

    public static void bubleSort(int[] bints){

        int sum = 0;
        for (int i = 0; i < bints.length; i++) {

            for (int j = 0; j < bints.length-i-1; j++) {

                if(bints[j]>bints[j+1]){

                    int temp = bints[j];
                    bints[j] = bints[j+1];
                    bints[j+1] = temp;
                    sum++;
                }

            }

        }

        for (int i:

             bints) {

            System.out.print(i+" ");
        }

        System.out.println("总次数"+sum);
    }

}
