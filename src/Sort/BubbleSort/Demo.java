package Sort.BubbleSort;

import java.util.Arrays;

/**
 * @Author: Soldier49Zed
 * @Date: 2019/8/3 14:27
 * @Description: 冒泡排序
 */
public class Demo {

    public static int[] BubbleSort(int[] data) {
        if (data.length <= 1)
            return data;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        return data;
    }

    public static void main(String[] args) {
        int[] data = {9,8,7,6,5,4,3,2,1,0};
        System.out.println("-----------排序前-----------");
        System.out.println(Arrays.toString(data));
        System.out.println("-----------排序后-----------");
        System.out.println(Arrays.toString(BubbleSort(data)));
    }

}