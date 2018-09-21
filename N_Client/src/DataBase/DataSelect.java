package DataBase;
import java.sql.*;
import java.util.*;

public class DataSelect 
{
	public static void main(String[] args)
	{
		System.out.println(new DataSelect().getUser());
	}
	
	public Vector getUser()
	{
		DataBase database=null;
		Vector users=new Vector();
		try
		{
			String sql="select UserId from UserInfo";
			database=new DataBase();
			ResultSet rs=database.query(sql);
			while(rs.next())
			{
				String user=rs.getString(1);
				users.add(user);
			}
		}catch(Exception e){}
		finally
		{
			database.close();
		}
		return users;
	}
}
