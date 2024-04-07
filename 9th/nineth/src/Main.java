import java.util.Arrays;
import java.util.Random;

class Week9 {
    static Random random = new Random();

    public static void printArr(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void test() {
        int[] nums1 = new int[random.nextInt(20) + 1];
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = random.nextInt(30) - 10;
        printArr(nums1);
        printArr(task1(nums1));
        System.out.println("======================");
        int[] nums2 = new int[random.nextInt(20) + 1];
        for (int i = 0; i < nums2.length; i++)
            nums2[i] = random.nextInt(3);
        printArr(nums2);
        task2(nums2);
        printArr(nums2);
    }

    public static void main(String[] args) {
        test(); // 运行测试方法
    }

    // 第一题代码
    public static int[] task1(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i])
                    count++;
            }
            res[i] = count;
        }
        return res;
    }

    // 第二题代码
    public static void task2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i <= right;) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
