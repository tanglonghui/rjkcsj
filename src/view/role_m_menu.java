package view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import bean.user;
import dao.h_timeDao;
import view.user_m_menu.MyWindowListener;

public class role_m_menu {
	private String name;
	public void role_m_menu(user rs){
		String aaaa=rs.getIdentity();
		 this.name=rs.getUsername();
		 Frame f=new Frame("角色管理");
			f.setLayout(null);
			f.setSize(400,300);
			f.setLocation(500, 200);
			f.setVisible(true);
			f.addWindowListener(new MyWindowListener());//为窗口组件注册监听器
		//增加一个角色、删除一个角色、修改角色信息
			Button btn1=new Button("增加一个角色");
			Button btn2=new Button("删除一个角色");
			Button btn3=new Button("修改角色信息");
			Button btn4=new Button("返回");
			
			
			btn1.setBounds(150, 30, 100, 30);
			btn2.setBounds(150, 70, 100, 30);//初始坐标，以及宽跟高
			btn3.setBounds(150, 110, 100, 30);
			btn4.setBounds(150, 150, 100, 30);
		
			f.add(btn1);//将按钮加载到界面上
			f.add(btn2);
			f.add(btn3);
			f.add(btn4);
		
			btn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//前往用户管理
					f.setVisible(false);//本窗口设置为隐藏
					addRole m=new addRole();
					
					try {
						m.addRole(rs);
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
					deleteRole m=new deleteRole();
					
					try {
						m.deleteRole(rs);
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
					changeRole m=new changeRole();
					
					try {
						m.changeRole(rs);
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



