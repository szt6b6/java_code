package 图形化sql;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Simple {
    public static void main(String[] args) {
  
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            JFrame sqlFrame = new JFrame("sql查询");
            Container container = sqlFrame.getContentPane();
            container.setLayout(new GridLayout(2,1));
            JButton button = new JButton("执行");
            JTextField sqlField = new JTextField();
            container.add(button);
            container.add(sqlField);
            button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String sql = sqlField.getText();
					try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&useSSL=true","root", "0000");
            Statement s = c.createStatement();){
						ResultSet resultSet = s.executeQuery(sql);
						while(resultSet.next()) {
			            System.out.println("name: "+resultSet.getString("name") + " age: "+resultSet.getInt("age"));
			           }
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("查询出错");
					}
				}
			});
            sqlFrame.setSize(200, 200);
            sqlFrame.show();
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
           		System.out.println("构造界面出错");
        } 
    }
}
