package eoto.xm;

import java.io.*;
import java.util.*;
@SuppressWarnings("resource")
public class Summit {
	public static void type(boolean ii) throws IOException {
		System.out.println("********************");
		System.out.println("*  欢迎来到宠物商店   *");
		System.out.println("*      1.狗子             *");
		System.out.println("*      2.雪貂             *");
		System.out.println("*      3.Neko      *");
		System.out.println("*      4.退出             *");
		System.out.println("********************");
		System.out.println("请选择一种宠物吧!");
		String cho=new Scanner(System.in).nextLine();
		while((cho.equals("1")||cho.equals("2")||
				cho.equals("3")||cho.equals("4"))==false) {
			System.out.println("请输入正确的选项哦:");
			cho=new Scanner(System.in).nextLine();
		}
		if(cho.equals("1")) {
			new Dog(false,ii,true);
			/*
			 * 1.是否为新的宠物false为新的
			 *  2.是否为游客false为游客
			 *  3.新旧宠物存取数据方式true为新
			 */
		}
		if(cho.equals("2")) {
			new Martes(false,ii,true);
		}
		if(cho.equals("3")) {
			new Cat(false,ii,true);
		}
		if(cho.equals("4")) {
			Menu.menu();
		}
	}
}
