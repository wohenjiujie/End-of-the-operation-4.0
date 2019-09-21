package eoto.xm;

import java.io.IOException;
import java.util.*;

public class Registration {    //注册
	@SuppressWarnings("resource")
	static void registration() throws IOException{
	    System.out.println("请填写用户名(用户名长度需大于3...PS:按0即可退出当前界面)：");
	    String anc=new Scanner(System.in).nextLine();
	    while(anc.equals("0")) {
	    	Start.main(null);
	    }
	    while(anc.length()<3){
	    	System.out.println("用户名长度需大于3");
	    	System.out.println("请重新输入：(PS:按0即可退出当前界面)");
	    	anc=new Scanner(System.in).nextLine();
	    	while(anc.equals("0")) {
		    	Start.main(null);
		    }
	    }
	    while(Duplicate.check(anc,null,false)==1) {
	    	System.out.println("用户名已存在！！！");
	    	System.out.println("请重新填写用户名：");
	    	anc=new Scanner(System.in).nextLine();
	    }
	    System.out.println("请填写密码(密码长度需大于6)：");
	    String pa1=new Scanner(System.in).nextLine();
	    while(pa1.length()<6){
	    	System.out.println("密码长度需大于6：");
	    	System.out.println("请重新输入：");
	    	pa1=new Scanner(System.in).nextLine();
	    }
	    System.out.println("请再次确认密码：");
	    String pa2=new Scanner(System.in).nextLine();
	    while(pa1.equals(pa2)==false){ 
   		 System.out.println("两次输入的密码不一致，请重新输入！");
   		 pa1=new Scanner(System.in).nextLine();
   		 while(pa1.length()<6){
	    	 System.out.println("密码长度需大于6：");
	    	 System.out.println("请再次输入：");
	    	 pa1=new Scanner(System.in).nextLine();
	     }
   		 System.out.println("请再次确认：");
   		 pa2=new Scanner(System.in).nextLine();
   	     }
   	     if(pa1.equals(pa2)){
   		 System.out.println("你的账号为:"+anc);
	     System.out.println("你的密码为:"+pa1);
         }
		 Connect.Connection(anc,pa1,1);      //写入信息
		 Attributes.setPoints(1000);         //初始化积分
		 Attributes.setHost(anc);            //将用户名封装
	}
}
