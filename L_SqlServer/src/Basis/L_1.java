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
//			����
			int i=sm.executeUpdate("insert into UserInfo values" +
					"('star','123456789','yangmin','1','837157632@qq.com','����ʡ�ߺ���','18801731098')");
			if(i==1){
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ��");
			}
//			ɾ��
			int j=sm.executeUpdate("delete from UserInfo where UserId='bobo'");
			if(j==1){
				System.out.println("ɾ���ɹ�");
			}else{
				System.out.println("ɾ��ʧ��");
			}
//			�޸�
			int k=sm.executeUpdate("update UserInfo set Gender=1 where UserId='qiqi'");
			if(k==1){
				System.out.println("�޸ĳɹ�");
			}else{
				System.out.println("�޸�ʧ��");
			}
//			��ѯ
			ResultSet rs=sm.executeQuery("select * from UserInfo");
//			ResultSet rs=sm.executeQuery("select * from UserInfo where UserId='taotao' and UserPwd='abc' or 1='1'");
//			�ķ��������а�ȫ��
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
