package Basis;
import java.sql.*;
public class L_2 
{
	public static void main(String[] args)
	{
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Java","sa","yang9264");
			
//			sql Server java1.bak
			ps=ct.prepareStatement("insert into UserInfo values(?,?,?,?,?,?,?)");
			ps.setString(1, "Star");
			ps.setString(2, "123456");
			ps.setString(3, "洋洋");
			ps.setInt(4,1);
			ps.setString(5, "45698237@qq.com");
			ps.setString(6, "上海市杨浦区");
			ps.setString(7, "13956458523");
			ps.executeUpdate();
			
			ps=ct.prepareStatement("select * from UserInfo where UserId=? or UserPwd=?");
			ps.setString(1,"yoyo");
			ps.setString(2,"1234585");
			rs=ps.executeQuery();
			while(rs.next())
			{
				String UserId=rs.getString(1);
				String UserName=rs.getString(3);
				int Gender=rs.getInt(4);
				String Phone=rs.getString(7);
				System.out.println(UserId+"\t"+UserName+"\t"+Gender+"\t"+Phone);
			}
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
