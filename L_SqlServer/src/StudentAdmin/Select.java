package StudentAdmin;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;

public class Select extends AbstractTableModel
{
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	Vector headline,data;
	
	public int getRowCount()
	{
		return this.data.size();
	}
	
	public int getColumnCount()
	{
		return this.headline.size();
	}
	
	public Object getValueAt(int row,int column)
	{
		return ((Vector)this.data.get(row)).get(column);
	}
	
	public String getColumnName(int column)
	{
		return (String)this.headline.get(column);
	}
	
	public Select()
	{
		this.SelectFunction("select * from Student");
	}
	
	public Select(String s)
	{
		this.SelectFunction(s);
	}
	
	public void SelectFunction(String ss)
	{
		headline=new Vector();
		headline.add("学号");
		headline.add("姓名");
		headline.add("性别");
		headline.add("年龄");
		headline.add("籍贯");
		headline.add("所在院系");
		data=new Vector();
		try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			ct=DriverManager.getConnection("jdbc:odbc:Sql Server","sa","yang9264");
			
//			sql Server java2.bak
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Java","sa","yang9264");
			
			ps=ct.prepareStatement(ss);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Vector dataline=new Vector();
				dataline.add(rs.getString(1));
				dataline.add(rs.getString(2));
				dataline.add(rs.getString(3));
				dataline.add(rs.getInt(4));
				dataline.add(rs.getString(5));
				dataline.add(rs.getString(6));
				data.add(dataline);
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
