package Basis;
import java.sql.*;
public class L_3 
{
	public static void main(String[] args)
	{
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;
		try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			ct=DriverManager.getConnection("jdbc:odbc:Sql Server","sa","yang9264");
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Java","sa","yang9264");
			
			ps=ct.prepareStatement("create database abcd");
//			ps=ct.prepareStatement("create table aabbcc(aa int,bb nvarchar(2))");
//			ps=ct.prepareStatement("backup database Demo to disk='E:/demo.bak'");
//			ps=ct.prepareStatement("drop  table aabbcc");
//			ps=ct.prepareStatement("drop database Demo");
//			ps=ct.prepareStatement("restore database Demo from disk='E:/demo.bak'");
			ps.execute();
//			ps.executeUpdate();
			
			System.out.println("Execution Complete");
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
