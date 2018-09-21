package DataBase;
import java.sql.*;;

public class DataBase 
{
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost:1433;databaseName=Java";
//	sql Server java1.bak
	String user="sa";
	String password="yang9264";
	
	public DataBase()
	{
		try
		{
			Class.forName(driver);
			ct=DriverManager.getConnection(url,user,password);
		}catch(Exception e1){}
	}

	public ResultSet query(String sql)
	{
		try
		{
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
		}catch(Exception e2){}
		return rs;
	}

	public void close()
	{
		try
		{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		}catch(Exception e3){}
	}
}
