package view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import bean.role;
import bean.user;
import dao.getInformationDao;
import dao.h_timeDao;


public class user_m_menu {
	private String name;
	public void user_m_menu(user rs) throws SQLException{
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
			String a=rs.getIdentity();
		 role ro=new role();
		 getInformationDao g=new getInformationDao();
		 ro=g.getInfo(a);//拉取登录的角色信息
		 Frame f=new Frame("用户管理");
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//为窗口组件注册监听器
		//增加一个用户、删除一个用户、修改用户信息、查询用户登录情况、更新个人情况。
			Button btn1=new Button("增加一个用户");
			Button btn2=new Button("删除一个用户");
			Button btn3=new Button("修改用户信息");
			Button btn4=new Button("查询用户登录情况");
			Button btn5=new Button("更新个人情况");
			Button btn6=new Button("返回");
			
			
			btn1.setBounds(150, 30, 100, 30);
			btn2.setBounds(150, 70, 100, 30);//初始坐标，以及宽跟高
			btn3.setBounds(150, 110, 100, 30);
			btn4.setBounds(150, 150, 100, 30);
			btn5.setBounds(150, 190, 100, 30);
			btn6.setBounds(150, 230, 100, 30);
			String lev=ro.getLevel();
			//char 换为Stirng
			String s1=String.valueOf(lev.charAt(0));
			if(s1.equals("3"))
			{
			f.add(btn1);//将按钮加载到界面上
			f.add(btn2);
			f.add(btn3);
			f.add(btn4);
			f.add(btn5);
			
			}
			if(s1.equals("2")){
				f.add(btn5);
			}
			if(s1.equals("1")){
				f.add(btn5);
			}
			f.add(btn6);
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//本窗口设置为隐藏
					addUser m=new addUser();
					try {
						m.addUser(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
			});
			btn2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//本窗口设置为隐藏
					deleteUser m=new deleteUser();
					try {
						m.deleteUser(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
			});
			btn3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//本窗口设置为隐藏
					changeUser m=new changeUser();
					try {
						m.changeUser(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
			});
			btn4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//本窗口设置为隐藏
					demandUser m=new demandUser();
					try {
						m.demandUser(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
			});
			btn5.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//本窗口设置为隐藏
					changeMyUser m=new changeMyUser();
					try {
						m.changeMyUser(rs);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
			});
			btn6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//本窗口设置为隐藏
					menu m=new menu();
					try {
						m.menu(rs);
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


