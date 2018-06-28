package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import bean.user;
import connect.Connect;
import dao.addUserDao;
import dao.deleteUserDao;
import dao.h_timeDao;
import dao.loginDao;
import view.user_m_menu.MyWindowListener;

public class changeUser {
	private String name;
	public void changeUser(user rs) throws SQLException{
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
		 Frame f=new Frame("修改用户信息");
		 //制作从数据库拉取的下拉列表框
		    JComboBox a;
			JPanel b=new JPanel();
			a =new JComboBox();
			//下拉框二
			JComboBox a1;
			JPanel b1=new JPanel();
			a1 =new JComboBox();
			//拉取数据
		    Connection conn=Connect.getConnection();
		 	String sql1="select * from role where identity is not null ";
		 	String sql2="select * from user where identity is not null ";
		    PreparedStatement p=null;
		    ResultSet rs1=null;
		    p=conn.prepareStatement(sql1);
		    rs1=p.executeQuery();
		    while(rs1.next())
		    {
		    	a.addItem(""+rs1.getString("identity"));
		    }
		    p=conn.prepareStatement(sql2);
		    rs1=p.executeQuery();
		    while(rs1.next())
		    {
		    	a1.addItem(""+rs1.getString("username"));
		    }
		    
		    
		    
		    
			
			
			
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//为窗口组件注册监听器
		//增加一个用户、删除一个用户、修改用户信息、查询用户登录情况、更新个人情况。
			TextField tf1=new TextField();
			TextField tf2=new TextField();
			TextField tf3=new TextField();
			TextField tf4=new TextField();
			TextField tf5=new TextField();
			Label la1=new Label("选择修改的账号:");
			Label la2=new Label("新密码:");
			Label la3=new Label("新身份:");
			Label la4=new Label("新昵称:");
			Label la5=new Label("新简介:");
			Button btn6=new Button("确定");
			Button btn7=new Button("返回");
			
			la1.setBounds(50, 30, 100, 30);
			la2.setBounds(100, 70, 100, 30);//初始坐标，以及宽跟高
			la3.setBounds(100, 110, 100, 30);
			la4.setBounds(100, 150, 100, 30);
			la5.setBounds(100, 190, 100, 30);
			a1.setBounds(150, 30, 100, 30);
			tf2.setBounds(150, 70, 100, 30);//初始坐标，以及宽跟高
			a.setBounds(150, 110, 100, 30);
			tf4.setBounds(150, 150, 100, 30);
			tf5.setBounds(150, 190, 100, 30);
			btn6.setBounds(100, 230, 100, 30);
			btn7.setBounds(200, 230, 100, 30);
			
			f.add(a1);//将按钮加载到界面上
			f.add(tf2);
			f.add(a);
			f.add(tf4);
			f.add(tf5);
			f.add(btn6);
			f.add(btn7);
			f.add(la1);
			f.add(la2);
			f.add(la3);
			f.add(la4);
			f.add(la5);
			
			
			btn6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					//本窗口设置为隐藏
					String username=(String) a1.getSelectedItem();
					String password=tf2.getText();
					String identity=(String) a.getSelectedItem();
					String nickname=tf4.getText();
					String description=tf5.getText();
					String c_time=rs.getC_time();
					user a=new user(username,password,nickname,identity,description,c_time);
					deleteUserDao delete=new deleteUserDao();
					try {
						delete.deleteUserDao(username);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					addUserDao b=new addUserDao();
					
					try {
						
						user s=b.addUserDao(a);
						if(s!=null){
						JOptionPane.showMessageDialog(null,"修改成功");
						user_m_menu m=new user_m_menu();
						m.user_m_menu(rs);
						f.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null,"修改失败！");
							//清空文本框
							tf2.setText(null);
							tf4.setText(null);
							tf5.setText(null);
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			btn7.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//本窗口设置为隐藏
					user_m_menu m=new user_m_menu();
					try {
						m.user_m_menu(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			

}
	 class MyWindowListener extends WindowAdapter//重写
		{
			public void windowClosing(WindowEvent e){
				h_timeDao a=new h_timeDao();
			    try {
					a.h_time(name);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Window window=(Window) e.getComponent();
				window.dispose();
				System.exit(0);
			}
			}
	
	 }

