package Sort.BinaryInsertSort;

/**
 * @Author: Soldier49Zed
 * @Date: 2019/8/3 14:35
 * @Description: 折半插入排序
 */
public class Demo {

    public static void binaryInsertSort(int[] data) {
        int n = data.length;
        int i, j;
        for (i = 1; i < n; i++) {
            /**
             * temp为本次循环待插入有序列表中的数
             */
            int temp = data[i];
            int low = 0;
            int high = i - 1;
            /**
             * 寻找temp插入有序列表的正确位置，使用二分查找法
             */
            while (low <= high) {
                /**
                 * 有序数组的中间坐标，此时用于二分查找，减少查找次数
                 */
                int mid = (low + high) / 2;
                /**
                 * 若有序数组的中间元素大于待排序元素，则有序序列向中间元素之前搜索，否则向后搜索
                 */
                if (data[mid] > temp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            for (j = i - 1; j >= low; j--) {
                /**
                 * 元素后移，为插入temp做准备
                 */
                data[j + 1] = data[j];
            }
            /**
             * 插入temp
             */
            data[low] = temp;
        }
    }
}
