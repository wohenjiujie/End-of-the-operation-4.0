package eoto.xm;

import java.io.IOException;

public class Attributes {        //用于实现各类数据的封装
	static String VariousType;
	static String Host;
	static String Name;
	static String Type;
	static int Points;
	static int Health_Value;
	static int Intimacy;
	static int Physical_Strength;
	
	protected static void setHost(String host) {
		Host=host;
	}
	protected static String getHost() {
		return Host;
	}
	protected static void setPoints(int points) {
		Points=points;
	}
	protected static int getPoints() {
		return Points;
	}
	protected static void setName(String name) {
		Name=name;
	}
	protected static String getName() {
		return Name;
	}
	protected static void setType(String type) {
		Type=type;
	}
	protected static String getType() {
		return Type;
	}
	protected static void setHealth(int health) {
		Health_Value=health;
	}
	protected static int getHealth() {
		return Health_Value;
	}
	protected static void setInti(int inti) {
		Intimacy=inti;
	}
	protected static int getInti() {
		return Intimacy;
	}
	protected static void setPs(int ps) {
		Physical_Strength=ps;
	}
	protected static int getPs() {
		return Physical_Strength;
	}
	
	protected static void Temporarypreservation(String type) throws IOException {
		if(type.equals("可爱の萨摩")||type.equals("逗逗の二哈")||type.equals("酷酷の金毛")) {
			new Dog(true,true,false);
		}
		if(type.equals("安格鲁")||type.equals("玛雪儿")) {
			new Dog(true,true,false);
		}
		if(type.equals("美短")||type.equals("狸花")||type.equals("布偶")) {
			new Dog(true,true,false);
		}
	}
	
	static String dogType(int te) {
		if(te==1) {
			VariousType=new String("可爱の萨摩");
		}
		if(te==2) {
			VariousType=new String("逗逗の二哈");
		}
		if(te==3) {
			VariousType=new String("酷酷の金毛");
		}
		return VariousType;
	}
	static String penguinType(int te) {
		if(te==1) {
			VariousType=new String("安格鲁");
		}
		if(te==2) {
			VariousType=new String("玛雪儿");
		}
		return VariousType;
	}
	static String catType(int te) {
		if(te==1) {
			VariousType=new String("美短");
		}
		if(te==2) {
			VariousType=new String("狸花");
		}
		if(te==3) {
			VariousType=new String("布偶");
		}
		return VariousType;
	}
}
