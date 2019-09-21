package eoto.xm;

import java.io.IOException;
import java.util.Scanner;

public class Modify {
	@SuppressWarnings({ "resource", "unused" })
	static void choice() throws IOException {
		while(true) {
			System.out.println("*****************");
			System.out.println("*  1.修改密码        *");
			System.out.println("*  2.弃养宠物        *");
			System.out.println("*  3.删除账户        *");
			System.out.println("*  4. 退出             *");
			System.out.println("*****************");
			String cho=new Scanner(System.in).nextLine();
			while((cho.equals("1")||cho.equals("2")||cho.equals("3")
					||cho.equals("4"))==false) {
				System.out.println("请输入正确的选项哦:");
				cho=new Scanner(System.in).nextLine();
			}
			if(cho.equals("1")) {
				System.out.println("请输入账号原密码(输入esc即可退出):");
				String pas=new Scanner(System.in).nextLine();
				while(pas.equals("esc")||pas.equals("ESC")) {
			    	Modify.choice();
			    }
				int x=0;
				while(Duplicate.check(Attributes.getHost(),pas,true)==0) {
			    	x++;
			    	if(x==3) {
			    		System.out.println("输入错误3次，系统将为您退出程序！！！");
			    		choice();
			    	}
			    	System.out.println("密码错误！！！");
			    	System.out.println("请输入密码：");
			    	pas=new Scanner(System.in).nextLine();
			    }
				if(Duplicate.check(Attributes.getHost(),pas,true)==2) {
					System.out.println("请输入新密码:");
					pas=new Scanner(System.in).nextLine();
					Connect.Connection(Attributes.getHost(), pas, 2);
				}
			}
			if(cho.equals("2")) {
				System.out.println("请输入账号原密码(输入esc即可退出):");
				String pas=new Scanner(System.in).nextLine();
				while(pas.equals("esc")||pas.equals("ESC")) {
			    	Modify.choice();
			    }
				int x=0;
				while(Duplicate.check(Attributes.getHost(),pas,true)==0) {
			    	x++;
			    	if(x==3) {
			    		System.out.println("输入错误3次，系统将为您退出程序！！！");
			    		choice();
			    	}
			    	System.out.println("密码错误！！！");
			    	System.out.println("请输入密码：");
			    	pas=new Scanner(System.in).nextLine();
			    }
				if(Duplicate.check(Attributes.getHost(),pas,true)==2) {
					Connect.Connection(Attributes.getHost(), pas, 3);
				}
			}
			if(cho.equals("3")) {
				System.out.println("请输入账号原密码(输入esc即可退出):");
				String pas=new Scanner(System.in).nextLine();
				while(pas.equals("esc")||pas.equals("ESC")) {
			    	Modify.choice();
			    }
				int x=0;
				while(Duplicate.check(Attributes.getHost(),pas,true)==0) {
			    	x++;
			    	if(x==3) {
			    		System.out.println("输入错误3次，系统将为您退出程序！！！");
			    		choice();
			    	}
			    	System.out.println("密码错误！！！");
			    	System.out.println("请输入密码：");
			    	pas=new Scanner(System.in).nextLine();
			    }
				if(Duplicate.check(Attributes.getHost(),pas,true)==2) {
					Connect.Connection(Attributes.getHost(), pas, 4);
				}
			}
			if(cho.equals("4")) {
				Menu.menu();
			}
		}
	}
}
