package com.company;
import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.*;
public class Main  {
    /*public static void  select(ResultSet rs){
            try {
                while(rs.next()) {
                    System.out.println("Student:" + rs.getString("STUDENT") + "\n" + "Course::" + rs.getString("COURSE") + "\n" +
                            "SC:" + rs.getString("SC") + "\n");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        */
    public static void main(String[] args) {
	// write your code here
            Connection conn=null;
            Statement st=null;
            ResultSet rs=null;
            PreparedStatement ps=null;
                try {
                    String URL = "jdbc:mysql://127.0.0.1:3306/st?serverTimezone=GMT%2B8";
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入用户名：");
                    String USER = scanner.next();
                    System.out.println("请输入密码：");
                    String PASSWORD = scanner.next();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(URL, USER, PASSWORD);
                    System.out.println(conn);
                    while(true) {
                        System.out.println("请输入功能：" + "\n" + "1.输入数据\n2.删除信息\n3.修改信息\n4.查询信息\n5.退出系统"
                        );
                        int sel = scanner.nextInt();
                        st = conn.createStatement();


                        if (sel == 1) {
                            System.out.println("1.输入学生档案信息\n2.输入课程信息\n3.输入学生修课信息\n");
                            int temp = scanner.nextInt();
                            if (temp == 1) {
                                System.out.println("请输入学生学号：");
                                String Sno = scanner.next();
                                System.out.println("请输入学生姓名：");
                                String Sname = scanner.next();
                                System.out.println("请输入学生性别：");
                                String Ssex = scanner.next();
                                System.out.println("请输入学生年龄：");
                                String Sage = scanner.next();
                                System.out.println("请输入学生专业：");
                                String Sdept = scanner.next();
                                ps = conn.prepareStatement("insert into student values(?,?,?,?,?)");
                                ps.setString(1, Sno);
                                ps.setString(2, Sname);
                                ps.setString(3, Ssex);
                                ps.setString(4, Sage);
                                ps.setString(5, Sdept);
                                int success=ps.executeUpdate();
                                if(success!=0)
                                System.out.println("学生添加成功");
                            }//1.输入学生档案信息
                            if (temp == 2) {
                                System.out.println("请输入课程号：");
                                String Cno = scanner.next();
                                System.out.println("请输入课程名字：");
                                String Cname = scanner.next();
                                System.out.println("请输入课程先行课号：");
                                String Cpno = scanner.next();
                                System.out.println("请输入课程学分：");
                                String Ccredit = scanner.next();

                                ps = conn.prepareStatement("insert into course values(?,?,?,?)");
                                ps.setString(1, Cno);
                                ps.setString(2, Cname);
                                ps.setString(3, Cpno);
                                ps.setString(4, Ccredit);
                                int success=ps.executeUpdate();
                                if(success!=0)
                                System.out.println("课程添加成功");
                            }//2.输入课程信息
                            if (temp == 3) {
                                System.out.println("请输入学生学号：");
                                String Sno = scanner.next();
                                System.out.println("请输入课程号：");
                                String Cno = scanner.next();
                                System.out.println("请输入课程成绩");
                                String Grade = scanner.next();
                                ps = conn.prepareStatement("insert into sc values(?,?,?)");
                                ps.setString(1, Sno);
                                ps.setString(2, Cno);
                                ps.setString(3, Grade);
                                int success = ps.executeUpdate();
                                if (success != 0)
                                    System.out.println("课程添加成功");
                            }//3.输入学生修课信息
                        }//输入数据


                        if (sel == 2) {
                            System.out.println("1.删除学生档案信息\n2.删除课程信息\n3.删除学生修课信息；\n");
                            int temp = scanner.nextInt();
                            if (temp == 1) {
                                System.out.println("请输入要删除的学生学号：\n");
                                String Sno = scanner.next();
                                ps = conn.prepareStatement("delete from student where Sno=?");
                                ps.setString(1, Sno);
                                int success = ps.executeUpdate();
                                if (success != 0)
                                    System.out.println("删除成功");
                            }//1.删除学生档案信息
                            if (temp == 2) {
                                System.out.println("请输入要删除的课程号：\n");
                                String Cno = scanner.next();
                                ps = conn.prepareStatement("delete from course where Cno=?");
                                ps.setString(1, Cno);
                                int success = ps.executeUpdate();
                                if (success != 0)
                                    System.out.println("删除成功");
                            }//2.删除课程信息
                            if (temp == 3) {
                                System.out.println("请输入要删除课程的学生号：\n");
                                String Sno = scanner.next();
                                System.out.println("请输入要删除的课程号：\n");
                                String Cno = scanner.next();
                                ps = conn.prepareStatement("delete from sc where Sno=? and Cno=?");
                                ps.setString(1, Sno);
                                ps.setString(1, Cno);
                                int success = ps.executeUpdate();
                                if (success != 0)
                                    System.out.println("删除成功");
                            }//3.删除学生修课信息
                        }//删除信息


                        if (sel == 3) {
                            System.out.println("1.修改学生档案信息\n2.修改课程信息\n3.修改学生修课信息\n");
                            int temp = scanner.nextInt();
                            if (temp == 1) {
                                System.out.println("请输入要修改的学生学号:");
                                String Sno = scanner.next();
                                System.out.println("请输入要修改的值:");
                                System.out.println("1.姓名:");
                                String Sname = scanner.next();
                                System.out.println("2.性别:");
                                String Ssex = scanner.next();
                                System.out.println("3.年龄:");
                                String Sage = scanner.next();
                                System.out.println("4.专业:");
                                String Sdept = scanner.next();
                                ps = conn.prepareStatement("update student set Sname=?,Ssex=?,Sage=?,Sdept=? where Sno=?");
                                ps.setString(1, Sname);
                                ps.setString(2, Ssex);
                                ps.setString(3, Sage);
                                ps.setString(4, Sdept);
                                ps.setString(5, Sno);
                                int success = ps.executeUpdate();
                                if (success != 0)
                                    System.out.println("更新成功");
                            }//1.修改学生档案信息
                            if (temp == 2) {
                                System.out.println("请输入要修改的课程号:");
                                String Cno = scanner.next();
                                System.out.println("请输入要修改的值:");
                                System.out.println("1.课程名:");
                                String Cname = scanner.next();
                                System.out.println("2.先行课:");
                                String Cpno = scanner.next();
                                System.out.println("3.学分:");
                                String Ccredit = scanner.next();
                                ps = conn.prepareStatement("update course set Cname=?, Cpno=?, Ccredit=? where Cno=?");
                                ps.setString(1, Cname);
                                ps.setString(2, Cpno);
                                ps.setString(3, Ccredit);
                                ps.setString(4, Cno);
                                int success = ps.executeUpdate();
                                if (success != 0)
                                    System.out.println("更新成功");
                            }//2.修改课程信息
                            if (temp == 3) {
                                System.out.println("请输入要修改课程学生学号:");
                                String Sno = scanner.next();
                                System.out.println("请输入要修改的学生课程号：");
                                String Cno = scanner.next();
                                System.out.println("请输入要修改的值:");
                                String Grade = scanner.next();
                                ps = conn.prepareStatement("update sc set Grade=?, where Sno=?, and Cno=?");
                                ps.setString(1, Grade);
                                ps.setString(2, Sno);
                                ps.setString(3, Cno);
                                int success = ps.executeUpdate();
                                if (success != 0)
                                    System.out.println("更新成功");
                            }//3.修改学生修课信息
                        }//修改信息


                        if (sel == 4) {
                            System.out.println("1.查询学生档案信息\n2.查询课程信息\n3.查询学生修课信息\n");

                            int temp = scanner.nextInt();//用于查询数据
                            if (temp == 1) {
                                System.out.println("请输入学生学号:\n");
                                String s = scanner.next();
                                ps = conn.prepareStatement("select * from student where Sno=?");
                                ps.setString(1, s);
                                rs = ps.executeQuery();
                                while (rs.next()) {
                                    System.out.println("Sno:" + rs.getString("Sno") + "\t" + "Sname" + rs.getString("Sname") + "\t" +
                                            "Ssex:" + rs.getString("Ssex") + "\t" + "Sage:" + rs.getString("Sage") + "\t" + "Sdept:" + rs.getString("Sdept") + "\t");
                                }
                                ps = conn.prepareStatement("select *from sc where Sno=?");
                                ps.setString(1, s);
                                rs = ps.executeQuery();
                                while (rs.next()) {
                                    System.out.println("Sno:" + rs.getString("Sno") + "\t" + "Cno" + rs.getString("Cno") + "\t" +
                                            "Grade:" + rs.getString("Grade") + "\t");
                                }
                            }//1.查询学生档案信息

                            if (temp == 2) {
                                rs = st.executeQuery("select * from course");
                                System.out.println("请输入要查询的课程：");
                                String Cno = scanner.next();
                                ps = conn.prepareStatement("select * from course where Cno=?");
                                ps.setString(1, Cno);
                                rs = ps.executeQuery();
                                while (rs.next()) {
                                    System.out.println("Cno:" + rs.getString("Cno") + "\t" + "Cname" + rs.getString("Cname") + "\t" +
                                            "Cpno:" + rs.getString("Cpno") + "\t" + "Ccredit:" + rs.getString("Ccredit") + "\t");
                                }
                                ps = conn.prepareStatement("select AVG(Grade) from sc where Cno=?");
                                ps.setString(1, Cno);
                                rs = ps.executeQuery();
                                System.out.println("平均成绩：");
                                while (rs.next())
                                    System.out.println(rs.getString(1));
                                ps = conn.prepareStatement("select MAX(Grade) from sc where Cno=?");
                                ps.setString(1, Cno);
                                rs = ps.executeQuery();
                                System.out.println("最高成绩：");
                                while (rs.next())
                                    System.out.println(rs.getString(1));
                                ps = conn.prepareStatement("select MIN(Grade) from sc where Cno=?");
                                ps.setString(1, Cno);
                                rs = ps.executeQuery();
                                System.out.println("最低成绩：");
                                while (rs.next())
                                    System.out.println(rs.getString(1));
                                ps = conn.prepareStatement("select sum(case when Grade>60 then 1 else 0 end)/count(*) from sc where Cno=?");
                                ps.setString(1, Cno);
                                rs = ps.executeQuery();
                                System.out.println("及格率：");
                                while (rs.next())
                                    System.out.println(rs.getString(1));

                            }//2.查询课程信息
                            if (temp == 3) {
                                System.out.println("请输入要查询的学生学号：");
                                String Sno=scanner.next();
                                ps=conn.prepareStatement("select * from sc where Sno=?");
                                ps.setString(1,Sno);
                                rs = ps.executeQuery();
                                while (rs.next()) {
                                    System.out.println("Sno:" + rs.getString("Sno") + "\t" + "Cno" + rs.getString("Cno") + "\t" +
                                            "Grade" + rs.getString("Grade") );
                                }
                            }//3.查询学生修课信息
                            rs.close();
                        }//查询信息
                        if (sel == 5) {
                            break;
                        }
                    }//while大循环结束
                    ps.close();
                    st.close();
                    conn.close();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }



    }


}