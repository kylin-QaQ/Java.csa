import java.util.Scanner;

class ScoreOutOfRangeException extends Exception {
    public ScoreOutOfRangeException(String message) {
        super(message);
    }
}
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("<-------第一题------->");
        int a, b;
        System.out.println("请输入第一个数：");
        a = in.nextInt();
        System.out.println("请输入第二个数：");
        b = in.nextInt();
        UseCompute useCompute = new UseCompute();

        // 测试加法
        Compute add = new Add();
        System.out.print("加法");
        useCompute.useCom(add, a, b);

        // 测试减法
        Compute subtract = new Subtract();
        System.out.print("减法");
        useCompute.useCom(subtract, a, b);

        // 测试乘法
        Compute multiply = new Multiply();
        System.out.print("乘法");
        useCompute.useCom(multiply, a, b);

        // 测试除法
        Compute divide = new Divide();
        System.out.print("除法");
        useCompute.useCom(divide, a, b);
        System.out.println("<-------第二题------->");
        System.out.println("请输入分数：");
        int score = in.nextInt();

        try {
            // 检查分数范围
            checkScore(score);
            // 如果分数在合法范围内，则输出成绩
            System.out.println("成绩为：" + score);
        } catch (ScoreOutOfRangeException e) {
            // 捕获异常并输出异常信息
            System.out.println(e.getMessage());
        }
        System.out.println("<-------第三题------->");
        int N;

        // 循环直到输入合法的 N
            while (true) {
            try {
                System.out.println("请输入整数个数 N：");
                N = in.nextInt();
                // 检查输入的 N 是否为负数
                if (N < 0) {
                    throw new NegativeNumberException("N 必须是正数或者 0");
                }
                break; // 如果输入的 N 合法，退出循环
            } catch (NegativeNumberException e) {
                // 捕获异常并输出异常信息
                System.out.println(e.getMessage());
                in.nextLine(); // 清空输入缓冲区
            }
        }

        int sum = 0;
            System.out.println("请输入 " + N + " 个整数：");
            for (int i = 0; i < N; i++) {
            int num = in.nextInt();
            sum += num;
        }
        // 计算平均值
        double average = (double) sum / N;System.out.println("平均值为：" + average);
        System.out.println("<-------第四题------->");
        int year,month,day;
        String number,name;
        System.out.println("请输入你的名字:");
        name = in.nextLine();
        System.out.println("请输入你的工号:");
        number = in.nextLine();
        System.out.println("请输入你的出生年份:");
        year = in.nextInt();
        System.out.println("请输入你的出生月份:");
        month = in.nextInt();
        System.out.println("请输入你的出生日:");
        day = in.nextInt();


        MyDate birthday = new MyDate(year, month, day);
        Employee employee = new ConcreteEmployee(name, number, birthday);
        System.out.println(employee);
        System.out.println("<-------第五题------->");
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        SubsequenceCount sc = new SubsequenceCount();
        System.out.println(sc.countSubsequences(S, words));
    }
    public static void checkScore(int score) throws ScoreOutOfRangeException {
        if (score < 0 || score > 100) {
            throw new ScoreOutOfRangeException("分数必须在 0—100 之间！");
        }
    }
    //TODO:在此编写作业所需的方法
//第三题格式要求,在 TODO 部分实现代码
}
interface Compute {
    int compute(int n, int m);
}

// 2. 实现加法类
class Add implements Compute {
    @Override
    public int compute(int n, int m) {
        return n + m;
    }
}

// 3. 实现减法类
class Subtract implements Compute {
    @Override
    public int compute(int n, int m) {
        return n - m;
    }
}

// 4. 实现乘法类
class Multiply implements Compute {
    @Override
    public int compute(int n, int m) {
        return n * m;
    }
}

// 5. 实现除法类
class Divide implements Compute {
    @Override
    public int compute(int n, int m) {
        if (m != 0) {
            return n / m;
        } else {
            System.out.println("除数不能为0！");
            return 0;
        }
    }
}

// 6. 设计类 UseCompute
class UseCompute {
    public void useCom(Compute com, int one, int two) {
        int result = com.compute(one, two);
        System.out.println("运算结果为：" + result);
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    // 构造函数
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // toString 方法
    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}

// 定义 Employee 抽象类
abstract class Employee {
    private String name;
    private String number;
    private MyDate birthday;

    // 构造函数
    public Employee(String name, String number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    // 抽象方法 earnings()
    public abstract double earnings();

    // toString 方法
    @Override
    public String toString() {
        return "Name: " + name + ", Number: " + number + ", Birthday: " + birthday;
    }
}

// 定义具体的 Employee 子类
class ConcreteEmployee extends Employee {
    // 构造函数
    public ConcreteEmployee(String name, String number, MyDate birthday) {
        super(name, number, birthday);
    }

    // 实现 earnings() 方法
    @Override
    public double earnings() {
        // 在具体的子类中实现该方法
        return 0.0; // 这里只是一个示例，具体的实现根据具体情况而定
    }
}

class SubsequenceCount {
    public int countSubsequences(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSubsequence(word, S)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSubsequence(String word, String S) {
        int i = 0, j = 0;
        while (i < word.length() && j < S.length()) {
            if (word.charAt(i) == S.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }
}