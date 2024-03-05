package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // 加载 MySQL 驱动程序类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // 数据库连接参数
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "5201314mjl";

        // 声明数据库连接和结果集
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 建立数据库连接
            connection = DriverManager.getConnection(url, username, password);

            // 创建 Statement 对象
            statement = connection.createStatement();

            // 插入数据
            String insertQuery1 = "INSERT INTO stu1 (SNO, Name, Age, College) VALUES ('s001', '老大', 20, '计算机学院')";
            String insertQuery2 = "INSERT INTO stu1 (SNO, Name, Age, College) VALUES ('s002', '老二', 19, '计算机学院')";
            String insertQuery3 = "INSERT INTO stu1 (SNO, Name, Age, College) VALUES ('s003', '老三', 18, '计算机学院')";
            String insertQuery4 = "INSERT INTO stu1 (SNO, Name, Age, College) VALUES ('s004', '老四', 17, '通信学院')";
            statement.executeUpdate(insertQuery1);
            statement.executeUpdate(insertQuery2);
            statement.executeUpdate(insertQuery3);
            statement.executeUpdate(insertQuery4);

            // 打印分隔线
            System.out.println("-----------------");

            // 执行查询并打印数据
            String query = "SELECT * FROM stu1";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String sno = resultSet.getString("SNO");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                String college = resultSet.getString("College");
                System.out.println("SNO: " + sno + ", Name: " + name + ", Age: " + age + ", College: " + college);
            }

            // 打印分隔线
            System.out.println("-----------------");

            // 删除s004的记录并重新打印数据
            String deleteQuery = "DELETE FROM stu1 WHERE SNO = 's004'";
            statement.executeUpdate(deleteQuery);

            resultSet.close();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String sno = resultSet.getString("SNO");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                String college = resultSet.getString("College");
                System.out.println("SNO: " + sno + ", Name: " + name + ", Age: " + age + ", College: " + college);
            }

            // 关闭resultSet
            resultSet.close();

            // 打印分隔线
            System.out.println("-----------------");

            // 查询并打印s003的记录
            String s003Query = "SELECT * FROM stu WHERE SNO = 's003'";
            resultSet = statement.executeQuery(s003Query);
            if (resultSet.next()) {
                String sno = resultSet.getString("SNO");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                String college = resultSet.getString("College");
                System.out.println("SNO: " + sno + ", Name: " + name + ", Age: " + age + ", College: " + college);
            }

            // 关闭resultSet
            resultSet.close();

            // 打印分隔线
            System.out.println("-----------------");

            // 修改s001的记录并重新打印数据
            String updateQuery = "UPDATE stu1 SET Name = '老大', Age = 20, College = '通信学院' WHERE SNO = 's001'";
            statement.executeUpdate(updateQuery);

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String sno = resultSet.getString("SNO");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                String college = resultSet.getString("College");
                System.out.println("SNO: " + sno + ", Name: " + name + ", Age: " + age + ", College: " + college);
            }

            // 打印分隔线
            System.out.println("-----------------");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接和相关资源
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}