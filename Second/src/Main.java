import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("<-------第一题------->");
//TODO:在此编写第一题测试代码
        String title;
        String author;
        int year;
        System.out.println("请输入书名");
        title = in.nextLine();
        System.out.println("请输入作者");
        author = in.nextLine();
        System.out.println("请输入出版年份");
        year = in.nextInt();
        in.nextLine();
        Book book1 = new Book(title,author,year);
        book1.displayInfo();
        System.out.println("<-------第二题------->");
//TODO:在此编写第二题测试代码
        int x;
        System.out.println("汽车为小车请按1，汽车为卡车请按2");
        x = Integer.parseInt(in.nextLine());
        String brand;
        String color;
        int wheels;
        int speed;
        int loader;
        int payload;
        int actualLoader;
        double actualPayload;

        if(x==1) {
            System.out.println("请输入小车品牌");
            brand = in.nextLine();
            System.out.println("请输入小车颜色");
            color = in.nextLine();
            System.out.println("请输入小车车轮个数");
            wheels = Integer.parseInt(in.nextLine());
            System.out.println("请输入小车时速（km/h)");
            speed = Integer.parseInt(in.nextLine());
            System.out.println("请输入小车规定载人数");
            loader = Integer.parseInt(in.nextLine());
            System.out.println("请输入汽车实际载人数");
            actualLoader = Integer.parseInt(in.nextLine());

            Car car = new Car(brand,color,wheels,speed, loader, actualLoader);
            car.start();
            car.speed();
            car.stop();

            System.out.println('\n');
            car.show();
        } else if(x==2) {
            System.out.println("请输入卡车品牌");
            brand = in.nextLine();
            System.out.println("请输入卡车颜色");
            color = in.nextLine();
            System.out.println("请输入卡车车轮个数");
            wheels = Integer.parseInt(in.nextLine());
            System.out.println("请输入卡车时速（km/h)");
            speed = Integer.parseInt(in.nextLine());
            System.out.println("请输入卡车规定载人数");
            loader = Integer.parseInt(in.nextLine());
            System.out.println("请输入卡车规定载重");
            payload = Integer.parseInt(in.nextLine());
            System.out.println("请输入卡车实际载人数");
            actualLoader = Integer.parseInt(in.nextLine());
            System.out.println("请输入卡车实际载重");
            actualPayload = Double.parseDouble(in.nextLine());

            Truck truck = new Truck(brand, color, wheels, speed, loader, payload, actualLoader, actualPayload);
            truck.start();
            truck.speed();
            truck.stop();

            System.out.println('\n');
            truck.show();
        } else {
            System.out.println("无效数字");
        }
        System.out.println("<-------第三题------->");
//TODO:在此编写第三题测试代码
        Calculator calculator = new Calculator();
        // Perform arithmetic operations
        double a , b;
        System.out.println("请输入第一个数");
        a = in.nextDouble();
        System.out.println("请输入第二个数");
        b = in.nextDouble();

        System.out.println("Addition: " + calculator.add(a, b));
        System.out.println("Subtraction: " + calculator.subtract(a, b));
        System.out.println("Multiplication: " + calculator.multiply(a, b));
        System.out.println("Division: " + calculator.divide(a, b));
        System.out.println("<-------第四题------->");
//TODO:在此编写第四题测试代码
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Output for strs1: " + longestCommonPrefix(strs1));

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Output for strs2: " + longestCommonPrefix(strs2));
        System.out.println("<-------第五题------->");
//TODO:在此编写第五题测试代码
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Output: " + trap(height));
    }

    public static String longestCommonPrefix(String[] strs) {
        String ans = "";

        if (strs == null || strs.length == 0) {
            return ans;
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return ans;
                }
            }
        }
        return prefix;
    }
    //第五题格式要求
    public static int trap(int[] height) {
//TODO:在此处编写符合要求的代码，并在主类中编写测试代码
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;

        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }

        return result;
    }

}
//TODO:在此处编写作业所需的类，并在主类中测试这些类
//注意相互间的继承关系
class Book{
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Year: " + year);
    }

}
class Vehicle{
    String brand;
    String color;
    int wheels;
    int speed;

    public Vehicle(String brand, String color, int wheels, int speed) {
        this.brand = brand;
        this.color = color;
        this.wheels = wheels;
        this.speed = speed;
    }

    public void start() {
        System.out.println("Car is started");
    }

    public void speed() {
        System.out.println("Car is  accelerating at speed " + speed +  "km/h");
    }

    public void stop() {
        System.out.println("Car is braking");
    }

    public void show() {
        System.out.println("汽车品牌：" + brand + "\n颜色：" + color + "\n车轮个数：" + wheels);
    }
}
class Car extends Vehicle {
    int loader;
    int actualLoader;

    public Car(String brand, String color, int wheels, int speed, int loader, int actualLoader) {
        super(brand, color, wheels, speed);
        this.loader = loader;
        this.actualLoader = actualLoader;
    }

    @Override
    public void start() {
        super.start();
        System.out.print("这是一辆小车，能够载人" + loader + "人，实际载人" + actualLoader + "人。");
        if (actualLoader > loader) {
            System.out.println("你超员了！！！");
        }
    }
}
class Truck extends Vehicle {
    int loader;
    int payload;
    int actualLoader;
    double actualPayload;

    public Truck(String brand, String color, int wheels, int speed, int loader, int payload, int actualLoader, double actualPayload) {
        super(brand, color, wheels, speed);
        this.loader = loader;
        this.payload = payload;
        this.actualLoader = actualLoader;
        this.actualPayload = actualPayload;
    }

    @Override
    public void start() {
        super.start();
        System.out.print("这是一辆卡车，能够载人" + loader + "人，实际载重" + actualPayload + "kg。");
        if(actualLoader > loader){
            System.out.println("你超员了！！！");
        }
        if (actualPayload > payload) {
            System.out.println("你超载了！！！");
        }
    }
}
class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return Double.NaN; // 返回不是一个数字（Not a Number）
        }
        return a / b;
    }
}