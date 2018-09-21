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
			Class.forName(DRIVER);								//加载数据库驱动
			con = DriverManager.getConnection(URL,USER,PWD);	//连接数据库
			System.out.println("数据库连接成功");
		} catch (SQLException e) 
		{
			System.out.println("驱动加载失败");					// TODO Auto-generated catch blo-QWAwaaAck
			e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			System.out.println("数据库连接失败");				// TODO Auto-generated catch block
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
			System.out.println("数据库成功关闭");
		} catch (SQLException e) 
		{
			System.out.println("数据库关闭失败");		      // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
