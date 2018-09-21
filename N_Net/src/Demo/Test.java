package Demo;
import java.sql.*;

public class Test 
{
	public static void main(String[] args)
	{
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databaseName=Java";
		String user="sa";
		String password="yang9264";
		try
		{
			Class.forName(driver);
			ct=DriverManager.getConnection(url,user,password);
			ps=ct.prepareStatement("select UserId from UserInfo");
			rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
		}catch(Exception e1){}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			}catch(Exception e2){}
		}
		System.out.println("Testing");
	}
}