package eoto.xm;
import java.sql.*;

public class PRU {    //只作为对积分的信息处理
	@SuppressWarnings("unused")
	public static int read(String account) {
		int points=0;
		Connection con;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testxx?"
	          		     +"characterEncoding=utf8&useSSL=true";
		PreparedStatement psql;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, "root", "12345678");
			if(!con.isClosed()) {
				Statement statement=con.createStatement();
				String sql = "select * from info where account='"
				+Attributes.getHost()+"'";
				ResultSet rs = statement.executeQuery(sql);
	            while(rs.next()){
	            	points=rs.getInt("points");
	            }
	            rs.close();
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
		}
		return points;
	}
	
	public static void update(String account,int points) {
		Connection con;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/testxx?"
	          		     +"characterEncoding=utf8&useSSL=true";
		PreparedStatement psql;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, "root", "12345678");
			if(!con.isClosed()) {
				String Instruction="update info set points='"+points+"'where account='"
						+account+"'";
						psql=con.prepareStatement(Instruction);
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
		}
	}
}
