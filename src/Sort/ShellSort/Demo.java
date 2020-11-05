package Sort.ShellSort;

/**
 * @Author: Soldier49Zed
 * @Date: 2019/8/3 14:37
 * @Description: 希尔排序
 */
public class Demo {
    public static void ShellSort(int[] data) {
        int j = 0;
        int temp = 0;
        for (int n = data.length / 2; n > 0; n /= 2) {
            for (int i = n; i < data.length; i++) {
                temp = data[i];
                for (j = i - n; j >= 0; j -= n) {
                    if (temp < data[j])
                        data[j + n] = data[j];
                    else
                        break;
                }
                data[j + n] = temp;
            }
        }
    }
}
