import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("1、B");
        System.out.println("2、B");
        System.out.println("3、D");
        System.out.println("4、B");
        System.out.println("5、D");
        System.out.print("输入要查看的任务序号：");
        int n = in.nextInt();
        showTriangle(n);
    }

    public static void showTriangle(int n) {
        Scanner in = new Scanner(System.in);  // 注意这里只需要一个 Scanner 对象

        switch (n) {
            case 1:
                int n1;
                System.out.print("Input n:");
                n1 = in.nextInt();
                for (int i = 0; i < n1; i++) {

                    for (int j = 0; j < n1 - i - 1; j++) {
                        System.out.print(" ");
                    }

                    for (int j = 0; j < 2 * i - 1; j++) {
                        System.out.print("*");
                    }

                    System.out.println();
                }
                break;

            case 2:
                int n2;
                System.out.print("请输入一个正整数：");
                n2 = in.nextInt();
                int weishu = countDigits(n2);
                System.out.println("您输入的正整数的位数是：" + weishu);
                reversePrintDigits(n2);
                break;

            case 3:
                int n3;
                n3 = in.nextInt();
                if (isPalindrome(n3)) {
                    System.out.println("是的");
                } else {
                    System.out.println("不是");
                }
                break;

            case 4:
                int n4;
                int a, b, c;
                System.out.print("水仙花数：");
                for (n4 = 100; n4 < 1000; n4++) {
                    a = n4 % 10;
                    b = n4 / 10 % 10;
                    c = n4 / 100;
                    if (n4 == a * a * a + b * b * b + c * c * c) {
                        System.out.print(n4 + " ");
                    }
                }
                break;

            case 5:
                int[] array = new int[10];
                int n5;
                for (int i = 0; i < 10; i++) {
                    System.out.println("输入第" + (i + 1) + "个数");
                    n5 = in.nextInt();
                    array[i] = n5;
                }
                int sumMinMax = arraysDemo(array);
                System.out.println("数组中最小值和最大值之和为: " + sumMinMax);
                break;

            default:
                // 默认处理
                System.out.println("无法识别的输入");
                break;
        }
    }

    public static int countDigits(int num) {
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    public static void reversePrintDigits(int num) {
        System.out.print("您输入的正整数的逆序是：");
        while (num != 0) {
            int s = num % 10;
            System.out.print(s);
            num = num / 10;
        }
        System.out.println();  // 添加换行，使输出更清晰
    }

    public static boolean isPalindrome(int x) {
        int original = x;
        int reversed = 0;

        // 反转数字
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        // 判断是否相等
        return original == reversed;
    }

    public static int arraysDemo(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        return min + max;
    }
}
