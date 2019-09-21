package eoto.xm;
import java.sql.*;

public class Connect {    //连接数据库做基本处理
	public static void Connection(String acc,String pas,int cho) {
		Connection con;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testxx?"
	          		     +"characterEncoding=utf8&useSSL=true";
		PreparedStatement psql;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, "root", "12345678");
			if(!con.isClosed()) {
				System.out.println("正在处理");
			}
			if(cho==1) {
				psql=con.prepareStatement("insert into info(account,password,points)"
			    +"value(?,?,?)");
			 	psql.setString(1,acc);
				psql.setString(2,pas);
				psql.setInt(3,1000);
				psql.executeUpdate();
	            con.close(); 
			}
			if(cho==2) {
				String mod="update info set password=?where account=?";
				psql = con.prepareStatement(mod);
				psql.setString(1,pas);
				psql.setString(2,acc); 
				psql.executeUpdate();
				con.close();
			}
			if(cho==3) {
				String mod="delete from pet where host=?";
				psql = con.prepareStatement(mod);
				psql.setString(1,acc);
				psql.executeUpdate();
				con.close();
			}
			if(cho==4) {
				String mod="delete from info where account=?";
				psql = con.prepareStatement(mod);
				psql.setString(1,acc);
				psql.executeUpdate();
				con.close();
			}
		}catch(ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
		}finally{
            System.out.println("处理成功!!!");
        }
	}
}
