import java.util.HashSet;
import java.util.Set;
import java.util.Random;

class Week7 {
    static Random random = new Random();

    public static void test() {
        System.out.println(task1("abbc", "dog cat cat fish"));
        System.out.println(task2(new int[]{1, 2, 2, 3, 0}));
        for (int i = 0; i < 5; i++) {
            int target = random.nextInt(15) - 3;
            System.out.println("target:" + target + "\tresult" + task3(new int[]{0, 4, 5, 6, 8}, target));
        }
    }

    public static void main(String[] args) {
        test(); // 运行测试方法
    }

    // 第一题代码
    public static boolean task1(String pattern, String str) {
        String[] words = str.split(" ");

        if (pattern.length() != words.length)
            return false;

        Set<Character> patternSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (!patternSet.contains(ch)) {
                if (wordSet.contains(word))
                    return false;
                patternSet.add(ch);
                wordSet.add(word);
            } else {
                if (!word.equals(words[i]))
                    return false;
            }
        }

        return true;
    }

    // 第二题代码
    public static int task2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    // 第三题代码
    public static int task3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 如果找不到目标数字，则返回应该存放的位置的相反值-1
        return -left - 1;
    }
}
