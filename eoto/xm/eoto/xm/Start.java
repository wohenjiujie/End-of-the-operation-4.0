package eoto.xm;
import java.io.*;
import java.util.*;

public class Start {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("********************");
			System.out.println("*欢迎来到宠物商店系统*");
			System.out.println("*      1.注册             *");
			System.out.println("*      2.登录             *");
			System.out.println("*      3.游客             *");
			System.out.println("*      4.退出             *");
			System.out.println("********************");
			System.out.println("请选择：");
			String cho=new Scanner(System.in).nextLine();
			while((cho.equals("1")||cho.equals("2")||cho.equals("3")
					||cho.equals("4"))==false) {
				System.out.println("请输入正确的选项哦:");
				cho=new Scanner(System.in).nextLine();
			}
			if(cho.equals("1")) {
				Registration.registration();
			}
			if(cho.equals("2")) {
				Login.log();
			}
			if(cho.equals("3")) {
				System.out.println("PS：作为游客是不能保留宠物"
						+ "与享受回馈活动的");
				Summit.type(false);
			}
			if(cho.equals("4")) {
				extracted();
			}
		}
	}
	private static void extracted() {
		System.out.println("感谢使用！！！");
		System.exit(0);
	}
}
