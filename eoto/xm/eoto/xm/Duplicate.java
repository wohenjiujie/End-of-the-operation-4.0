package eoto.xm;
import java.sql.*;

public class Duplicate {         //实现众多检测信息的函数
	protected static int check(String acc,String pas,boolean a) {
		int f=0;
		Connection con;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testxx?"
	          		     +"characterEncoding=utf8&useSSL=true";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, "root", "12345678");
			Statement statement=con.createStatement();
			String sql = "select * from info";
			ResultSet rs = statement.executeQuery(sql);
			String ano;
			String code;
			if(a==false) {
	            while(rs.next()){
	                 ano=rs.getString("account");
	                 if(acc.equals(ano)) {
	                	 f=1;
	                 }
			    }
            }
            if(a==true) {
            	while(rs.next()){
                    ano=rs.getString("account");
                    code=rs.getString("password");
                    if(acc.equals(ano)&&pas.equals(code)) {
                    	f=2;
                    }
               }
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
		return f;
    }
	protected static int check(String host) {
		int x=0;
		Connection con;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testxx?"
	          		     +"characterEncoding=utf8&useSSL=true";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, "root", "12345678");
			Statement statement=con.createStatement();
			String sql = "select * from pet where host='"+host+"'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
               	x++;
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
		return x;
	}
	protected static boolean checkName(String name) {
		boolean a=true;
		Connection con;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testxx?"
	          		     +"characterEncoding=utf8&useSSL=true";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, "root", "12345678");
			Statement statement=con.createStatement();
			String sql = "select * from pet where host='"
			+Attributes.getHost()+"'";
			ResultSet rs = statement.executeQuery(sql);
			String ano;
			while(rs.next()){
                ano=rs.getString("name");
                if(name.equals(ano)) {
               	    a=false;
                }
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
		return a;
	}
	
	protected static String checkType(String name) {
		Connection con;
		String ano=null;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testxx?"
	          		     +"characterEncoding=utf8&useSSL=true";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, "root", "12345678");
			Statement statement=con.createStatement();
			String sql = "select * from pet where name='"
			+name+"'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				ano=rs.getString("type");
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
		return ano;
	}
}
