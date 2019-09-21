package eoto.xm;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Cat extends Pet {
	static int origin;
	static int change;
	@SuppressWarnings("resource")
	public Cat(boolean x,boolean y,boolean z) throws IOException {
		if(!x) {
			System.out.println(""
					+"请给宠物取个名字吧:\n");
			String name=new Scanner(System.in).nextLine();
			while(name.equals("esc")||name.equals("ESC")) {
				System.out.println("不能以此命名!请重新命名:");
				name=new Scanner(System.in).nextLine();
			}
			while(!Duplicate.checkName(name)) {
				System.out.println("你的宠物中有重复的存在，请重新命名:");
				name=new Scanner(System.in).nextLine();
			}
			initialName(name);
			System.out.println("请选择Neko的品种：\n"
					+"1.美短\t2.狸花\t3.布偶");
			String cho=new Scanner(System.in).nextLine();
			while((cho.equals("1")||cho.equals("2")||cho.equals("3"))==false) {
				System.out.println("请输入正确的选项哦:");
				cho=new Scanner(System.in).nextLine();
			}
			int te=Integer.parseInt(cho);
			setType(te,3);
			System.out.println("请输入Neko的健康值：\n");
			int hv=new Scanner(System.in).nextInt();
			while(hv<60||hv>100) {
				System.out.println("Neko的初始健康值应在60-100之间！"
						+ "请重新输入：");
				hv=new Scanner(System.in).nextInt();
			}
			initialHealth(hv);
			System.out.println("成功领养！！！");
			confession(true);
		}
		else {               
			Connection con;
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/testxx?"
		          		     +"characterEncoding=utf8&useSSL=true";
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(url, "root", "12345678");
				Statement statement=con.createStatement();
				String sql = "select * from pet where name='"
				+Attributes.getName()+"'";
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next()) {
					initialName(rs.getString("name"));
					initialType(rs.getString("type"));
					initialHealth(rs.getInt("health_value"));
					initialIntimacy(rs.getInt("intimacy"));
					initialPhysical(rs.getInt("physical_strength"));
				}
	            rs.close();
	            con.close();
			}catch(ClassNotFoundException e) {
				System.out.println("Sorry,can`t find the Driver!");   
	            e.printStackTrace();
			}catch (SQLException e) {
	            e.printStackTrace();
			}catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
		    }  
			System.out.println("读取成功！！！");
			origin=getHealth();
			setHealth(false);
			change=getHealth();
			System.out.println("因为你很久没照顾它，"
					+ "Neko的健康值从"
					+origin+"变为"+change+"了！！！\n");
		}
		menu(y,z);
	}
	public void confession(boolean k) {
		System.out.println("我的名字叫"+getName()
		+".\n我的健康值是"+getHealth()
		+".\n我和主人的亲密度为"+getIntimacy()
		+".\n我的类型是"+getType()
		+".\n我现在有"+getPS()+"的体力.");
		if(k) {
			System.out.println("快与你的Neko互动吧！");
		}
	}
	@SuppressWarnings("resource")
	public void menu(boolean y,boolean z) throws IOException {
		while(true) {
			System.out.println("1.喂食\t2.撸猫\t3.看病\t4.信息显示\t5.退出");
			String x=new Scanner(System.in).nextLine();
			while((x.equals("1")||x.equals("2")||x.equals("3")
					||x.equals("4")||x.equals("5"))==false) {
				System.out.println("请输入正确的选项哦:");
				x=new Scanner(System.in).nextLine();
			}
			if(x.equals("1")) {
				int a=feed();
				if(a==2) {
					System.out.println("Neko生病了，吃不下饭~~");
				}
				if(a==1) {
					System.out.println("体力很充沛了，快撑了~~");
				}
				if(a==0) {
					System.out.println("喂食成功！！！");
					System.out.println("Neko与你的亲密度为："+getIntimacy());
					System.out.println("健康值为："+getHealth());
					System.out.println("体力为"+getPS());
				}
			}
			if(x.equals("2")) {
				int b=game();
				if(b==2) {
					System.out.println("Neko生病了，没办法和你玩了~~");
				}
				if(b==1) {
					System.out.println("Neko已经精疲力劲了~~快让他休息吧");
				}
				if(b==0) {
					System.out.println("Neko玩的很愉快！！");
					System.out.println("Neko与你的亲密度为："+getIntimacy());
					System.out.println("健康值为："+getHealth());
					System.out.println("体力为"+getPS());
				}
			}
			if(x.equals("3")) {
				boolean cor=treat();
				if(cor) {
					System.out.println("Neko身体又好起来了！！！"
							+ "体力充沛饱满,但亲密度下滑了，"
							+ "所以赶紧带它去玩吧！！！");
				}
				else {
					System.out.println("Neko身体无大碍哟！");
				}
			}
			if(x.equals("4")) {
				boolean k=true;
				if(getPS()<=70||getHealth()<=70) {
					k=false;
				}
				confession(k);
			}
			if(x.equals("5")) {
				extracted(y,z);
			}
			if(getPS()>=60&&getPS()<=70||getHealth()>=60&&getHealth()<=70) {
				System.out.println("PS:Neko的状态有些低迷，"
						+ "注意不要让它生病哦~~");
			}
		}
	}
	@SuppressWarnings("resource")
	private void extracted(boolean sek,boolean z) throws IOException {
		if(sek) {
			System.out.println("是否要保存数据呢（y/n）?");
		    String x=new Scanner(System.in).nextLine();
		    while((x.equals("y")||x.equals("n"))==false) {
				System.out.println("请输入正确的选项哦:");
				x=new Scanner(System.in).nextLine();
			}
		    if(x.equals("y")) {
		    	if(z) {
		    		PetRIW.write(getType(), getName(), getHealth(), getIntimacy(), getPS());
		    	}
		    	else {
		    		PetRIW.update(getType(), getName(), getHealth(), getIntimacy(), getPS());
		    	}
		    	System.out.println("Thanks for the experience!!!");
		    	Menu.menu();
		    }
		    if(x.equals("n")) {
		    	System.out.println("感谢使用!!!");
		    	Menu.menu();
		    }
		}
		if(!sek) {
			System.out.println("作为游客是不能保留数据的，"
					+ "是否要创建账户以支持我们呢(y/n)?");
			String x=new Scanner(System.in).nextLine();
		    while((x.equals("y")||x.equals("n"))==false) {
				System.out.println("请输入正确的选项哦:");
				x=new Scanner(System.in).nextLine();
			}
		    if(x.equals("y")) {
		    	Registration.registration();
		    	PetRIW.write(getType(), getName(), getHealth(), getIntimacy(), getPS());
		    	System.out.println("非常感谢!!!");
		    	Menu.menu();
		    }
		    if(x.equals("n")) {
		    	System.out.println("感谢使用!!!");
		    	Menu.menu();
		    }
		}
	}
}
