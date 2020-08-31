package 常用算法;

import java.util.LinkedList;
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


    // 快排非递归
    public static void quickSortByStack(int[] nums, int left, int right){
        LinkedList<int[]> stack = new LinkedList<>();
        //保存左右边界
        stack.push(new int[]{left, right});
        while(!stack.isEmpty()){
            int[] pair = stack.pop();
            left = pair[0];
            right = pair[1];
            if(left >= right){
                continue;
            }
            //partition过程，注意细节
            int pivot = nums[left];
            int lt = left;
            for (int i = left + 1; i <= right; i++) {
                if(nums[i] < pivot){
                    lt++;
                    swap(nums, i, lt);
                }
            }
            swap(nums, lt, left);
            //先入右边部分，再入左边部分
            if(lt < right - 1){
                stack.push(new int[]{lt + 1, right});
            }
            if(left < lt - 1){
                stack.push(new int[]{left, lt - 1});
            }
        }
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

    // 堆排序
    // 1. 初始化大顶堆 2.将堆顶元素与堆尾元素交换 3.重新构建堆 4 重复
    public static void heapSort(int[] nums){
        //初始化大顶堆
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            rebuildHeap(nums, i, nums.length-1);
        }
//        heapify(nums);
        for (int i = nums.length-1; i >= 1; i--) {
            // 弹出最大堆的堆顶放在最后
            swap(nums, 0, i);
            // 重建最大堆
            rebuildHeap(nums, 0, i-1);
        }
    }

    //初始化大顶堆 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
    public static void heapify(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int par = (i-1) >> 1;
            int child = i;
            while(child > 0 && nums[par] < nums[child]){
                swap(nums, par, child);
                child = par;
                par = (par-1) >> 1;
            }
        }
    }


    // 调整索引为index处的数据，使其符合堆的特性
    public static void rebuildHeap(int[] nums, int par, int last){
        int left = 2 * par + 1;
        int right = left + 1;
        int maxindex = left;
        if(right <= last && nums[right] > nums[left]){  //先判断左右子节点，哪个较大
            maxindex = right;
        }
        if(left <= last && nums[par] < nums[maxindex]){
            swap(nums, par, maxindex);
            rebuildHeap(nums, maxindex, last);
        }

    }





    public static void main(String[] args) {
        int[] nums = {7, 2, 6, 3, 8, 34, 8, 2, 8, 5, 1, 1, 2, 0, 0};
        quickSortByStack(nums, 0, nums.length - 1);
        System.out.println("快排：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
        System.out.println();
        nums = new int[]{7, 2, 6, 3, 8, 34, 8, 2, 8, 5, 1, 1, 2, 0, 0};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("归并：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
        System.out.println();
        nums = new int[]{7, 2, 6, 3, 8, 34, 8, 2, 8, 5, 1, 1, 2, 0, 0};
        heapSort(nums);
        System.out.println("堆排序：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }
}
