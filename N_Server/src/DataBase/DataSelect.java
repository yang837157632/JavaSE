package DataBase;
import java.sql.*;
public class DataSelect {
	public static void main(String[] args){
		System.out.println(new DataSelect().getpasswd("bobo"));
	}
	public String getpasswd(String UserId){
		DataBase database=null;
		String passwd="";
		try{
			String sql="select UserPwd from UserInfo where UserId = ? ";
			database=new DataBase();
			ResultSet rs=database.query(sql, UserId);
			if(rs.next()){
				passwd=rs.getString(1);
			}
		}catch(Exception e){}
		finally{
			database.close();
		}
		return passwd;
	}
}
