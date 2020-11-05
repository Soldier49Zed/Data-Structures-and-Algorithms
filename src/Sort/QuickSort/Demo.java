package Sort.QuickSort;

import java.util.Arrays;

/**
 * @Author: Soldier49Zed
 * @Date: 2019/8/3
 * @Description: 快速排序
 */
public class Demo {
    public static void QuickSort(int[] data, int left, int right) {
        if (data.length <= 1)
            return;
        int n = partition(data, left, right);
        QuickSort(data, left, n - 1);
        QuickSort(data, n + 1, right);
    }
    public static void main(String[] args) {
        int[] data = {9,8,7,6,5,4,3,2,1,0};
        System.out.println("-----------排序前-----------");
        System.out.println(Arrays.toString(data));
        System.out.println("-----------排序后-----------");
        QuickSort3(data);
        System.out.println(Arrays.toString(data));
    }

    public static void QuickSort2(int[] array) {
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1)
            return;
        else
            QuickSortInternal2(array, 0, n - 1);

        long end = System.currentTimeMillis();
        System.out.println("二路快速排序共耗时:" + (end - start) + "毫秒");
    }

    public static void QuickSort3(int[] array) {
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            QuickSortInternal3(array, 0, n - 1);
        }
        long end = System.currentTimeMillis();
        System.out.println("三路快速排序共耗时:" + (end - start) + "毫秒");
    }

    /**
     * 基准值
     *
     * @param data  待排序的数组
     * @param left  数组最左元素
     * @param right 数组最右元素
     * @return 返回已经到达最终位置的基准值下标
     */
    private static int partition(int[] data, int left, int right) {
        return 0;
    }

    private static int partition2(int[] array, int l, int r) {
        // 随机选取待排序数组中的任意一个元素
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(array, l, randomIndex);
        int v = array[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && array[i] < v) i++;
            while (j >= l + 1 && array[j] > v) j--;
            if (i > j) {
                break;
            }
            swap(array, i, j);
            i++;
            j--;
        }
        // 循环走完后，j索引下标为分区点位置
        swap(array, l, j);
        return j;
    }

    private static void QuickSortInternal2(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition2(arr, p, r);
        QuickSortInternal2(arr, p, q - 1);
        QuickSortInternal2(arr, q + 1, r);
    }

    private static void QuickSortInternal3(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 随机选取待排序数组中的任意一个元素
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(arr, l, randomIndex);
        int v = arr[l];
        // arr[l+1...lt] < v
        int lt = l;
        // arr[lt+1...i-1] == v
        int i = l + 1;
        // arr[gt...r] > v
        int gt = r + 1;
        while (i < gt) {
            if (arr[i] < v) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i] > v) {
                swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        // 循环走完只需要将l位置的元素与lt交换即为分区点
        swap(arr, l, lt);
        QuickSortInternal3(arr, l, lt - 1);
        QuickSortInternal3(arr, gt, r);
    }

    /**
     * 快速排序-----递归
     *
     * @param array 待排序的数组
     * @param p     数组起始位置
     * @param r     数组终止位置
     */
    private static void SortInternal(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        // 获取分区点
        int q = partition(array, p, r);
        SortInternal(array, p, q - 1);
        SortInternal(array, q + 1, r);
    }

    private static void swap(int[] data, int indexA, int indexB) {
        int temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }


}
