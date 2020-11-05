package Sort.SelectionSort;

/**
 * @Author: Soldier49Zed
 * @Date: 2019/8/3
 * @Description: 选择排序
 */
public class Demo {
    public static void SelectionSort(int[] array) {
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1) {
            return;
        }else {
            // 从未排序空间中选出最小值
            for (int i = 0;i < n - 1;i++) {
                int minIndex = i;
                for (int j = i + 1;j < n;j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }
                // 此时minIndex对应的元素一定是当前未排序区间的最小值
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("选择排序共耗时:"+(end-start)+"毫秒");
    }
}
