package Admin.DataBase;
import java.sql.*;

public class DataBase {
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	

	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost:1433;databaseName=Java";	
	String user="sa";
	String password="yang9264";
	
	public DataBase()
	{
		try
		{
			Class.forName(driver);
			ct=DriverManager.getConnection(url,user,password);
		}catch(Exception e){}
	}
	
	public ResultSet query(String sql,String[] paras)
	{
		try
		{
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1,paras[i]);
			}
			rs=ps.executeQuery();
		}catch(Exception e){}
		return rs;
	}
	
	public void close()
	{
		try
		{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		}catch(Exception e){}
	}
}