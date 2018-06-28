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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import bean.role;
import bean.user;
import dao.getInformationDao;
import dao.h_timeDao;
import ez_view.ez1;
import ez_view.ez2;
import ez_view.ez3;
import ez_view.ez4;

public class menu {
	private String name;
	 public void menu(user rs) throws SQLException{
		 String a=rs.getIdentity();
		 this.name=rs.getUsername();
		 role ro=new role();
		 getInformationDao g=new getInformationDao();
		 ro=g.getInfo(a);//拉取登录的角色信息
		 
		 Frame f=new Frame("菜单");
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//为窗口组件注册监听器
		//用户管理、角色管理、人事管理、财务管理、销售管理、技术管理
			Button btn1=new Button("用户管理");
			Button btn2=new Button("角色管理");
			Button btn3=new Button("人事管理");
			Button btn4=new Button("财务管理");
			Button btn5=new Button("销售管理");
			Button btn6=new Button("技术管理");
			Button btn7=new Button("切换用户");
			Label la=new Label();
			Label la1=new Label();
			Label la2=new Label();
			la.setText("身份:  "+ro.getIdentity());
			la1.setText("昵称:  "+rs.getNickname());
			la2.setText("简介:  "+rs.getDescription());
			la.setBounds(20, 30, 180, 30);
			la1.setBounds(20, 70, 100, 30);
			la2.setBounds(20, 110, 180, 30);
			btn1.setBounds(200, 30, 100, 30);
			btn2.setBounds(200, 70, 100, 30);//初始坐标，以及宽跟高
			btn3.setBounds(200, 110, 100, 30);
			btn4.setBounds(200, 150, 100, 30);
			btn5.setBounds(200, 190, 100, 30);
			btn6.setBounds(200, 230, 100, 30);
			btn7.setBounds(20, 230, 100, 30);
			
			f.add(btn7);
			f.add(la);
			f.add(la1);
			f.add(la2);
			//下面的按钮进行权限控制
			String lev=ro.getLevel();
			//char 换为Stirng
			String s1=String.valueOf(lev.charAt(1));
			String s2=String.valueOf(lev.charAt(2));
			String s3=String.valueOf(lev.charAt(3));
			String s4=String.valueOf(lev.charAt(4));
			String s5=String.valueOf(lev.charAt(5));
			String s6=String.valueOf(lev.charAt(6));
			if(lev.length()==7)
			{
				if(s1.equals("1")){
					f.add(btn1);
				}

				if(s2.equals("1")){
					f.add(btn2);
				}

				if(s3.equals("1")){
					f.add(btn3);
				}

				 if(s4.equals("1")){
					f.add(btn4);
				}

				if(s5.equals("1")){
					f.add(btn5);
				}

				 if(s6.equals("1")){
					f.add(btn6);
				}
				
				
				
			}else{
				JOptionPane.showMessageDialog(null,"权限控制码出错");
				if(ro.getIdentity().equals("管理员")){
					JOptionPane.showMessageDialog(null,"你是管理员，请更正你的权限码");
				}
			}
			
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//menu窗口设置为隐藏
					user_m_menu m=new user_m_menu();
					try {
						m.user_m_menu(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//menu窗口设置为隐藏
					role_m_menu m=new role_m_menu();
					m.role_m_menu(rs);
					
					
				}
			});
			btn3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//menu窗口设置为隐藏
					ez1 m=new ez1();
					try {
						m.ez1(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//menu窗口设置为隐藏
					ez2 m=new ez2();
					try {
						m.ez2(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn5.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//menu窗口设置为隐藏
					ez3 m=new ez3();
					try {
						m.ez3(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//menu窗口设置为隐藏
					ez4 m=new ez4();
					try {
						m.ez4(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			btn7.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					  h_timeDao aa=new h_timeDao();
					    try {
							aa.h_time(name);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					f.setVisible(false);//menu窗口设置为隐藏
					login a=new login();
					a.login();
					
					
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
