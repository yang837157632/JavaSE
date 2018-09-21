package Admin.Model;
import java.sql.*;
import Admin.DataBase.*;

public class Model 
{
	public String checkUser(String Id,String Password)
	{
		String Position="";
		DataBase database=null;
		try
		{
			String sql="select Position from Login L,ClerkInformation C where L.Id=C.Id and L.Id=? and L.PassWord=?";
			String[] paras={Id,Password};
			database=new DataBase();
			ResultSet rs=database.query(sql,paras);
			if(rs.next())
			{
				Position=rs.getString(1);
			}
		}catch(Exception e){}
		finally
		{
			database.close();
		}
		return Position;
	}
}