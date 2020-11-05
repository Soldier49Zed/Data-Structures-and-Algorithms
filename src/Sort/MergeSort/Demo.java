package Sort.MergeSort;

import java.util.Arrays;

/**
 * @Author: Soldier49Zed
 * @Date: 2019/8/3 14:38
 * @Description:
 */
public class Demo {
    public static int[] sort(int[] data) {
        if (data.length <= 1)
            return data;
        int mid = data.length / 2;
        int[] left = Arrays.copyOfRange(data, 0, mid);
        System.out.println("left: "+Arrays.toString(left));
        int[] right = Arrays.copyOfRange(data, mid, data.length);
        System.out.println("right: "+Arrays.toString(right));

        return merge(sort(left), sort(right));
    }

    public static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];

            else if (j >= right.length)
                result[index] = left[i++];

            else if (left[i] > right[j])
                result[index] = right[j++];
            else

                result[index] = left[i++];
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println("-----------排序前-----------");
        System.out.println(Arrays.toString(data));
        System.out.println("-----------排序后-----------");
        System.out.println(Arrays.toString(sort(data)));
    }
}
