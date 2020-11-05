package Sort.InsertSort;

/**
 * @Author: Soldier49Zed
 * @Date: 2019/8/3
 * @Description: 插入排序及其优化
 */
public class Demo {
    public static void InsertSort(int[] data) {
        if (data.length <= 1) {
            return;
        } else {
            //待排序
            //第一个默认已排序，从第二个开始走 所以i = 1
            /**
             * 第一个for循环
             * 把数组分成两部分，右边为未排序，左边为已排序
             * 记录排序与未排序分割点temp（temp为下一个排序对象）
             */
            for (int i = 1; i < data.length; i++) {
                //待排序集合的第一个元素
                int temp = data[i];
                int j = i - 1;
                //找到要插入的位置
                /**
                 * 第二个for循环
                 * 将排序对象temp与已排序数组比较
                 * 当temp比最近左边的数大时（按从小到大循序排列时）
                 * 直接结束本次循环，进行下一个数排序
                 * 否则比左边这个数小时将这个数后移，腾出这个数的位置
                 */
                for (; j >= 0; j--) {
                    if (data[j] > temp) {
                        //此时待插入元素应该放在已排序数组前
                        data[j + 1] = data[j];
                    } else {
                        break;
                    }
                }
                //找到要插入的位置
                data[j + 1] = temp;
            }
        }
    }

    public static int[] InsertSortS(int[] data) {
        for (int i = 0; i < data.length; i++) {
            //保存每次需要插入的数
            int temp = data[i];
            int j = i;
            for (; j > 0 && data[j - 1] > temp; j--) {
                //把大于需要插入的数往后移动。最后不大于temp的数就空出来j
                data[j] = data[j - 1];
            }
            data[j] = temp;//将需要插入的数放入此位置
        }
        return data;
    }
}