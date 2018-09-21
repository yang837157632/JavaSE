package StudentAdmin;
import java.sql.*;

public class Delete 
{
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	
	public Delete(String s)
	{
		try
		{
//			sql Server java2.bak
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Java","sa","yang9264");
			ps=ct.prepareStatement("delete from Student where No=?");
			ps.setString(1,s);
			ps.executeUpdate();
		}catch(Exception e){}
		
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			}catch(Exception ee){}
		}
	}
}
