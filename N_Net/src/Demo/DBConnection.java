package Demo;
import java.sql.*;

public class DBConnection 
{
	public static void main(String[] args)
	{
		DBConnection a=new DBConnection();
		a.close();
	}
	
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL ="jdbc:sqlserver://localhost:1433;databaseName=Java";
	private static final String USER = "sa";
	private static final String PWD = "yang9264";
	private Connection con = null;
	
	public DBConnection()
	{
		try 
		{
			Class.forName(DRIVER);								//�������ݿ�����
			con = DriverManager.getConnection(URL,USER,PWD);	//�������ݿ�
			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e) 
		{
			System.out.println("��������ʧ��");					// TODO Auto-generated catch blo-QWAwaaAck
			e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			System.out.println("���ݿ�����ʧ��");				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public void close()
	{
		try 
		{
			this.con.close();
			System.out.println("���ݿ�ɹ��ر�");
		} catch (SQLException e) 
		{
			System.out.println("���ݿ�ر�ʧ��");		      // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
