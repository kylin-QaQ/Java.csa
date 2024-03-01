import java.util.ArrayList;
import java.util.List;
import  java.util.Scanner;

public class Main {

    public int reverse(int x) {
        long reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            reversed = reversed * 10 + digit;
        }

        return (int) reversed;
    }

    public int palouti(int n) {
        if (n <= 2) {
            return n;
        }

        int x1 = 1;
        int x2 = 2;
        int x = 0;

        for (int i = 3; i <= n; i++) {
            x = x1 + x2;
            x1 = x2;
            x2 = x;
        }

        return x;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        // 将当前子集添加到结果集中
        result.add(new ArrayList<>(subset));

        // 从 start 开始，逐个尝试将数字加入当前子集中，生成新的子集
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]); // 加入当前数字

            // 递归生成子集
            backtrack(nums, i + 1, subset, result);

            subset.remove(subset.size() - 1); // 回溯，移除当前数字
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("MySQL语句");
        System.out.println("1.");
        System.out.println("CREATE TABLE cqupt_student (\n" +
                "    studentid VARCHAR(10),\n" +
                "    name VARCHAR(20),\n" +
                "    sex VARCHAR(2),\n" +
                "    age INTEGER,\n" +
                "    Fee DECIMAL(10,2),\n" +
                "    address VARCHAR(50),\n" +
                "    memo VARCHAR(300)\n" +
                ");");
        System.out.println("2.");
        System.out.println("CREATE TABLE CourseAa (\n" +
                "    Aa1 VARCHAR(20),\n" +
                "    Aa2 INTEGER,\n" +
                "    Aa3 DECIMAL(10)\n" +
                ");");
        System.out.println("3.");
        System.out.println("CREATE TABLE CourseBb (\n" +
                "    Bb1 VARCHAR(30),\n" +
                "    Bb2 INTEGER,\n" +
                "    Bb3 DECIMAL(6)\n" +
                ");");
        System.out.println("4.");
        System.out.println("ALTER TABLE ChooseBb\n" +
                "ADD Bb4 VARCHAR(20) NOT NULL DEFAULT '系统测试值';");
        System.out.println("5.");
        System.out.println("ALTER TABLE ChooseBb\n" +
                "ADD Bb5 VARCHAR(10),\n" +
                "ADD CONSTRAINT PK_ChooseBb PRIMARY KEY (Bb5);");
        System.out.println("6.");
        System.out.println("CREATE VIEW View_Choosebb AS\n" +
                "SELECT Bb1 AS View_bb1, Bb4 AS View_bb2, Bb5 AS View_bb3\n" +
                "FROM ChooseBb;\n");
        System.out.println("7.");
        System.out.println("DROP VIEW View_Choosebb;");
        System.out.println("8.");
        System.out.println("CREATE INDEX Index_bb2 ON ChooseBb (Bb2 ASC);\n" +
                "CREATE INDEX Index_bb4 ON ChooseBb (Bb4 DESC);\n");
        System.out.println("9.");
        System.out.println("DROP INDEX Index_bb2 ON ChooseBb;");
        System.out.println("10.");
        System.out.println("CREATE TABLE test (\n" +
                "    Name VARCHAR(20),\n" +
                "    Age INTEGER,\n" +
                "    Score NUMERIC(10,2),\n" +
                "    Address VARCHAR(60)\n" +
                ");");
        System.out.println("11.");
        System.out.println("INSERT INTO test (Name, Age, Score, Address) VALUES\n" +
                "('赵一', 20, 580.00, '重邮宿舍12-3-5'),\n" +
                "('钱二', 19, 540.00, '南福苑5-2-9'),\n" +
                "('孙三', 21, 555.50, '学生新区21-5-15'),\n" +
                "('李四', 22, 505.00, '重邮宿舍8-6-22'),\n" +
                "('周五', 20, 495.50, '学生新区23-4-8'),\n" +
                "('吴六', 19, 435.00, '南福苑2-5-12');\n");
        System.out.println("12.");
        System.out.println("CREATE TABLE test_temp (\n" +
                "    Name VARCHAR(20),\n" +
                "    Age INTEGER,\n" +
                "    Score NUMERIC(10,2),\n" +
                "    Address VARCHAR(60)\n" +
                ");");
        System.out.println("13.");
        System.out.println("INSERT INTO test_temp (Name, Age, Score, Address) VALUES\n" +
                "('郑七', 21, 490.50, '重邮宿舍11-2-1'),\n" +
                "('张八', 20, 560.00, '南福苑3-3-3'),\n" +
                "('王九', 10, 515.00, '学生新区19-7-1');");
        System.out.println("14.");
        System.out.println("INSERT INTO test (Name, Age, Score, Address)\n" +
                "SELECT Name, Age, Score, Address\n" +
                "FROM test_temp;");
        System.out.println("15.");
        System.out.println("UPDATE test\n" +
                "SET Score = Score + 5\n" +
                "WHERE Age <= 20;");
        System.out.println("16.");
        System.out.println("UPDATE test\n" +
                "SET Age = Age - 1\n" +
                "WHERE Address LIKE '%南福苑%';\n");
        System.out.println("17.");
        System.out.println("DELETE FROM test\n" +
                "WHERE Age >= 21 AND Score >= 500;\n");
        System.out.println("18.");
        System.out.println("DELETE FROM test\n" +
                "WHERE Score < 550 AND Address LIKE '%重邮宿舍%';");
        System.out.println("19.");
        System.out.println("CREATE TABLE Student (\n" +
                "    Sno VARCHAR(20),\n" +
                "    Name VARCHAR(10),\n" +
                "    Age INTEGER,\n" +
                "    College VARCHAR(30)\n" +
                ");\n");
        System.out.println("20.");
        System.out.println("CREATE TABLE Course (\n" +
                "    CourseID VARCHAR(15),\n" +
                "    CourseName VARCHAR(30),\n" +
                "    CourseBeforeID VARCHAR(15)\n" +
                ");");
        System.out.println("21.");
        System.out.println("CREATE TABLE Choose (\n" +
                "    Sno VARCHAR(20),\n" +
                "    CourseID VARCHAR(30),\n" +
                "    Score DECIMAL(5,2)\n" +
                ");");
        System.out.println("22.");
        System.out.println("INSERT INTO Student (Sno, Name, Age, College) VALUES\n" +
                "('S00001', '张三', 20, '计算机学院'),\n" +
                "('S00002', '李四', 19, '通信学院'),\n" +
                "('S00003', '王五', 21, '计算机学院');");
        System.out.println("23.");
        System.out.println("INSERT INTO Course (CourseID, CourseName, CourseBeforeID) VALUES\n" +
                "('C1', '计算机引论', NULL),\n" +
                "('C2', 'C语言', 'C1'),\n" +
                "('C3', '数据结构', 'C2');");
        System.out.println("24.");
        System.out.println("INSERT INTO Choose (Sno, CourseID, Score) VALUES\n" +
                "('S00001', 'C1', 95),\n" +
                "('S00001', 'C2', 80),\n" +
                "('S00001', 'C3', 84),\n" +
                "('S00002', 'C1', 80),\n" +
                "('S00002', 'C2', 85),\n" +
                "('S00003', 'C1', 78),\n" +
                "('S00003', 'C3', 70);");
        System.out.println("25.");
        System.out.println("SELECT Sno, Name\n" +
                "FROM Student\n" +
                "WHERE College = '计算机学院';\n");
        System.out.println("26.");
        System.out.println("SELECT *\n" +
                "FROM Student\n" +
                "WHERE Age BETWEEN 20 AND 23;\n");
        System.out.println("27.");
        System.out.println("SELECT COUNT(*) AS TotalStudents\n" +
                "FROM Student;");
        System.out.println("28.");
        System.out.println("SELECT \n" +
                "    MAX(Score) AS Max_Score,\n" +
                "    MIN(Score) AS Min_Score,\n" +
                "    SUM(Score) AS Total_Score,\n" +
                "    AVG(Score) AS Avg_Score\n" +
                "FROM \n" +
                "    Choose\n" +
                "WHERE \n" +
                "    CourseID = 'C1';");
        System.out.println("29.");
        System.out.println("SELECT CourseID, CourseName\n" +
                "FROM Course\n" +
                "WHERE CourseBeforeID IS NULL;");
        System.out.println("30.");
        System.out.println("SELECT s.Sno, s.Name, c.CourseName, ch.Score\n" +
                "FROM Student s\n" +
                "JOIN Choose ch ON s.Sno = ch.Sno\n" +
                "JOIN Course c ON ch.CourseID = c.CourseID;");
        System.out.println("31.");
        System.out.println("SELECT *\n" +
                "FROM Student s\n" +
                "WHERE EXISTS (\n" +
                "    SELECT 1\n" +
                "    FROM Student\n" +
                "    WHERE Name = '张三' AND College = s.College\n" +
                ") AND Name != '张三';");
        System.out.println("32.");
        System.out.println("SELECT Sno, Score\n" +
                "FROM Choose\n" +
                "WHERE CourseID = 'C1'\n" +
                "AND Score < (\n" +
                "    SELECT Score\n" +
                "    FROM Choose\n" +
                "    JOIN Student ON Choose.Sno = Student.Sno\n" +
                "    WHERE Name = '张三' AND CourseID = 'C1'\n" +
                ");\n");
        System.out.println("33.");
        System.out.println("SELECT Sno\n" +
                "FROM Choose\n" +
                "WHERE CourseID = 'C1'\n" +
                "UNION\n" +
                "SELECT Sno\n" +
                "FROM Choose\n" +
                "WHERE CourseID = 'C3';");
        System.out.println("34.");
        System.out.println("SELECT DISTINCT Sno\n" +
                "FROM (\n" +
                "    SELECT Sno\n" +
                "    FROM Choose\n" +
                "    WHERE CourseID = 'C1'\n" +
                "    UNION\n" +
                "    SELECT Sno\n" +
                "    FROM Choose\n" +
                "    WHERE CourseID = 'C3'\n" +
                ") AS StudentIDs;");
        System.out.println("<------第一题------->");
        System.out.println("请输入数字：");
        int x;
        x = in.nextInt();
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            System.out.println("输出：0");
            return;
        }

        Main main = new Main();
        System.out.println("输入：x =  " + x);
        System.out.println("输出： " + main.reverse(x));

        System.out.println("<-------第二题------->");
        Main X = new Main();
        int n ;
        System.out.println("请输入楼层：");
        n = in.nextInt();
        System.out.println("爬到顶端的方法数：" + X.palouti(n));

        System.out.println("<-------第三题------->");
        Main solution = new Main();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
