package eoto.xm;
import java.io.*;
import java.util.*;

public class Login {                 //登陆
	@SuppressWarnings("resource")
	static void log() throws IOException{
	    System.out.println("请输入用户名(PS:按0即可退出当前界面):");
	    String anc=new Scanner(System.in).nextLine();
	    while(anc.equals("0")) {
	    	Start.main(null);
	    }
	    System.out.println("请输入密码");
	    String pas=new Scanner(System.in).nextLine();
	    int x=0;
	    while(Duplicate.check(anc,pas,true)==0) {
	    	x++;
	    	if(x==3) {
	    		System.out.println("输入错误3次，系统将为您退出程序！！！");
	    		System.exit(0);
	    	}
	    	System.out.println("用户名或密码错误！！！");
	    	System.out.println("请输入账户：");
	    	anc=new Scanner(System.in).nextLine();
	    	System.out.println("请输入密码：");
	    	pas=new Scanner(System.in).nextLine();
	    }
	    if(Duplicate.check(anc,pas,true)==2) {
	    	System.out.println("登录成功！！！");
	    	Attributes.setHost(anc);          //读取用户名并封装
	    	Attributes.setPoints(PRU.read(anc));//读取积分信息并封装
		    Menu.menu();
	    }
	}
}
