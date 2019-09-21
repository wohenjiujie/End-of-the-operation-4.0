package eoto.xm;

import java.io.*;
import java.util.*;

public class Lottery {           //用户抽奖活动
	@SuppressWarnings("resource")
	protected static void ld() throws IOException{
		int max=100;
	    byte min=0;
	    int i;
	    boolean d=true;
	    byte x=0;
	    Random random = new Random();
	    System.out.println("这是你今日的幸运数字:");
	    int y = random.nextInt(max)%(max-min+1) + min;
	    if (y < 10) 
	  	      System.out.println("0" + y);
	    else  System.out.println(y);
	    System.out.println("我们将会抽取10个随机数字并消耗您100积分");
	    System.out.println("是否继续(y/n)?");
	    String cho=new Scanner(System.in).nextLine();
		while((cho.equals("y")||cho.equals("Y")||
				cho.equals("n")||cho.equals("N"))==false) {
			System.out.println("请输入正确的选项哦:");
			cho=new Scanner(System.in).nextLine();
		}
	    if(cho.equals("y")||cho.equals("Y")){
	    Attributes.Points=Attributes.getPoints()-100;	
	    System.out.println("今天的幸运号为：");
	    for(i=1;i<=10;i++) {
	    int s=random.nextInt(max)%(max-min+1) + min;  
	    if (s<10) 
	  	    System.out.print("0"+s+"  ");
	    else  
	    	System.out.print(s+"  ");
	    x=s==y?++x:x;                  
	    }
	    d=x>0?true:false;
	        if (d==true) {
	    	System.out.println("恭喜您成为今天的幸运儿，您将获得1000积分!!!");
	    	Attributes.Points=Attributes.getPoints()+1000;
	    	PRU.update(Attributes.getHost(), Attributes.getPoints());
	    	Menu.menu();
	    }
	    	else {
	    		System.out.println("很遗憾您与奖品擦肩而过~~~");
	    		Menu.menu();
	    	}
		}
	    if(cho.equals("n")||cho.equals("N")) {
	    	Menu.menu();
	    }
	}

}
