package 常用算法;

import java.util.Random;

public class 排序 {
    // 快排
    static Random random = new Random();

    public static void quickSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);

        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, lt, left);

        quickSort(nums, left, lt - 1);
        quickSort(nums, lt + 1, right);

        return;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        return;
    }


    // 归并

    private static void mergeSort(int[] nums, int left, int right) {  // 需要左右边界确定排序范围
        if (left >= right) return;
        int mid = left + ((right - left) >>> 1);

        mergeSort(nums, left, mid);                           // 先对左右子数组进行排序
        mergeSort(nums, mid + 1, right);

        int[] temp = new int[right - left + 1];                   // 临时数组存放合并结果
        int i = left, j = mid + 1;
        int cur = 0;
        while (i <= mid && j <= right) {                            // 开始合并数组
            if (nums[i] <= nums[j]) temp[cur] = nums[i++];
            else temp[cur] = nums[j++];
            cur++;
        }
        while (i <= mid) temp[cur++] = nums[i++];
        while (j <= right) temp[cur++] = nums[j++];

        for (int k = 0; k < temp.length; k++) {             // 合并数组完成，拷贝到原来的数组中
            nums[left + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 6, 3, 8, 34, 8, 2, 8, 5, 1, 1, 2, 0, 0};
        quickSort(nums, 0, nums.length - 1);
        System.out.println("快排：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
        System.out.println();
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("归并：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }
}
