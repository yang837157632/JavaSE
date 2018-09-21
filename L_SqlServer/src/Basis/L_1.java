package Basis;
import java.sql.*;
public class L_1 {
	public static void main(String[] args){
		Connection ct=null;
		Statement sm=null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Java","sa","yang9264");
			sm=ct.createStatement();
//			插入
			int i=sm.executeUpdate("insert into UserInfo values" +
					"('star','123456789','yangmin','1','837157632@qq.com','安徽省芜湖市','18801731098')");
			if(i==1){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
//			删除
			int j=sm.executeUpdate("delete from UserInfo where UserId='bobo'");
			if(j==1){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
//			修改
			int k=sm.executeUpdate("update UserInfo set Gender=1 where UserId='qiqi'");
			if(k==1){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
//			查询
			ResultSet rs=sm.executeQuery("select * from UserInfo");
//			ResultSet rs=sm.executeQuery("select * from UserInfo where UserId='taotao' and UserPwd='abc' or 1='1'");
//			改方法不具有安全性
			while(rs.next()){
				String UserId=rs.getString(1);
				String UserName=rs.getString(3);
				int Gender=rs.getInt(4);
				String UserAddress=rs.getString(6);
				String Phone=rs.getString(7);
				System.out.println(UserId+"\t"+UserName+"\t"+Gender+"\t"+UserAddress+"\t"+Phone);
			}
		}catch(Exception e1){}
		finally{
			try{
				if(sm!=null){
					sm.close();
				}
				if(ct!=null){
					ct.close();
				}
			}catch(Exception e2){}
		}
	}

}
