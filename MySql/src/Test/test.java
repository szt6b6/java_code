package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class test {
    public static void main(String[] args) {
  
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&useSSL=true","root", "0000");
            Statement s = c.createStatement();){
            Class.forName("com.mysql.jdbc.Driver");
            // 准备sql语句
            // 注意： 字符串要用单引号'
            String sql = "select * from hero";
//            s.execute(sql);//执行sql语句
            ResultSet resultSet = s.executeQuery(sql);
            
            while(resultSet.next()) {
            	System.out.println("name: "+resultSet.getString("name") + " age: "+resultSet.getInt("age"));
            }
  
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
}
