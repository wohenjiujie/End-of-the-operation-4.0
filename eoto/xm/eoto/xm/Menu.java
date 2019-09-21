package eoto.xm;

import java.io.*;
import java.util.*;

public class Menu {
	@SuppressWarnings("resource")
	protected static void menu() throws IOException {
		while(true) {
			System.out.println("*******************");
			System.out.println("*    1.宠物商店        *");
			System.out.println("*    2.照看宠物        *");
			System.out.println("*    3.修改信息        *");
			System.out.println("*    4.客户活动        *");
			System.out.println("*    5.退出系统        *");
			System.out.println("*******************");
			String cho=new Scanner(System.in).nextLine();
			while((cho.equals("1")||cho.equals("2")||
					cho.equals("3")||cho.equals("4")||cho.equals("5"))==false) {
				System.out.println("请输入正确的选项哦:");
				cho=new Scanner(System.in).nextLine();
			}
			if(cho.equals("1")) {
				Summit.type(true);
			}
			if(cho.equals("2")) {
				int result=Duplicate.check(Attributes.getHost());
				if(result==0) {
					System.out.println("您还未领养任何宠物!oo\n\n");
				}
				if(result>0) {
					System.out.println("正在读取你的宠物信息...");
					HostInfo.sweetie();
				}
			}
			if(cho.equals("3")) {
				Modify.choice();
			}
			if(cho.equals("4")) {
				Lottery.ld();
			}
			if(cho.equals("5")) {
				extracted();
			}
		}
	}
	private static void extracted() throws IOException {
		System.out.println("感谢使用！！！");
		Start.main(null);
	}
}
