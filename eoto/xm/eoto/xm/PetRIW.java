package eoto.xm;

import java.sql.*;

public class PetRIW {       //对数据库做初始提出及最终处理
	@SuppressWarnings("unused")
	public static void read(boolean choice) {
		int count=1;
		Connection con;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testxx?"
	          		     +"characterEncoding=utf8&useSSL=true";
		PreparedStatement psql;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, "root", "12345678");
			if(!con.isClosed()) {
				System.out.println("正在读取...");
			}
			Statement statement=con.createStatement();
			String sql = "select * from pet where host='"
			+Attributes.getHost()+"'";
			if(!choice) {
				sql="select * from pet where host='"+Attributes.getHost()+"'"
						+"and name='"+Attributes.getName()+"'";
			}
			ResultSet rs = statement.executeQuery(sql);
			String host=null;
            String type=null;
            String name=null;
            int health=0;
            int intimacy=0;
            int physical=0;
            while(rs.next()){
                 host=rs.getString("host");
                 type=rs.getString("type");
                 name=rs.getString("name");
                 health=rs.getInt("health_value");
                 intimacy=rs.getInt("intimacy");
                 physical=rs.getInt("physical_strength");
                 System.out.println(count+"\t"+name+ "\t"+type+ "\t"+health
                		 + "\t"+intimacy+ "\t"+physical);
                 count++;
            }
            if(!choice) {
            	Attributes.setHealth(health);
            	Attributes.setInti(intimacy);
            	Attributes.setPs(physical);
            	Attributes.setType(type);
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
	}
	public static void write(String type,String name,
			int Health_Value,int Intimacy,int Physical_Strength ) {
		Connection con;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testxx?"
	          		     +"characterEncoding=utf8&useSSL=true";
		PreparedStatement psql;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, "root", "12345678");
			if(!con.isClosed()) {
				System.out.println("正在写入...");
			}
			psql=con.prepareStatement("insert into pet(host,type,name,health_value,intimacy,physical_strength)"
			+"value(?,?,?,?,?,?)");
			psql.setString(1,Attributes.getHost());
			psql.setString(2,type);
			psql.setString(3,name);
			psql.setInt(4,Health_Value);
			psql.setInt(5,Intimacy);
			psql.setInt(6, Physical_Strength);
			psql.executeUpdate();
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
	}
	public static void update(String type,String name,
			int Health_Value,int Intimacy,int Physical_Strength ) {
		Connection con;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testxx?"
	          		     +"characterEncoding=utf8&useSSL=true";
		PreparedStatement psql;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, "root", "12345678");
			if(!con.isClosed()) {
				System.out.println("正在更新...");
			}
			String chek="update pet set health_value='"
					+Health_Value+"',intimacy='"+Intimacy+"',physical_strength='"
					+Physical_Strength+"'where name='"+name
					+"'and host='"+Attributes.getHost()+"'";
			psql=con.prepareStatement(chek);
			psql.executeUpdate();
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
	}
}
