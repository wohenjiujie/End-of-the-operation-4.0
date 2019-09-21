package eoto.xm;

import java.io.IOException;
import java.util.Scanner;

public class HostInfo {     //开始载入宠物信息
	@SuppressWarnings("resource")
	static void sweetie() throws IOException {
		System.out.println("编号\t"+"姓名\t"+"种类\t"+"健康值\t"+"亲密度\t"+"体力值\t");
		PetRIW.read(true);
		System.out.println("请输入宠物的名字以叫唤它(输入ESC以退出当前界面)：");
		String name=new Scanner(System.in).nextLine();
		if(name.equals("esc")||name.equals("ESC")) {
			Menu.menu();
		}
		while(Duplicate.checkName(name)) {
			System.out.println("叫错名字啦！！！");
			name=new Scanner(System.in).nextLine();
		}
		Attributes.setName(name);
		String type=Duplicate.checkType(name);
		Attributes.Temporarypreservation(type);
	}
}
