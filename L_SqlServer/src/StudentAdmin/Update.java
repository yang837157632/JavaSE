package StudentAdmin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Update extends JDialog implements ActionListener
{
	JLabel label1,label2,label3,label4,label5,label6;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton insertbutton,cancelbutton;
	JPanel panel1,panel2,panel3,panel4;
	
	public Update(Frame frame,String title,Boolean modal,Select select,int row)
	{
		super(frame,title,modal);
		label1=new JLabel("		学号",JLabel.CENTER);
		label2=new JLabel("		姓名",JLabel.CENTER);
		label3=new JLabel("		性别",JLabel.CENTER);
		label4=new JLabel("		年龄",JLabel.CENTER);
		label5=new JLabel("		籍贯",JLabel.CENTER);
		label6=new JLabel("		院系",JLabel.CENTER);

		tf1=new JTextField(10);
		tf1.setText((String)select.getValueAt(row,0));
		tf1.setEditable(false);
		tf2=new JTextField(10);
		tf2.setText((String)select.getValueAt(row,1));
		tf3=new JTextField(10);
		tf3.setText((String)select.getValueAt(row,2));
		tf4=new JTextField(10);
		tf4.setText((String)select.getValueAt(row,3).toString());
		tf5=new JTextField(10);
		tf5.setText((String)select.getValueAt(row,4));
		tf6=new JTextField(10);
		tf6.setText((String)select.getValueAt(row,5));

		insertbutton=new JButton("修改");
		insertbutton.addActionListener(this);
		cancelbutton=new JButton("取消");
		cancelbutton.addActionListener(this);

		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();

		panel1.setLayout(new GridLayout(6,1));
		panel2.setLayout(new GridLayout(6,1));
		panel1.add(label1);		panel2.add(tf1);
		panel1.add(label2);		panel2.add(tf2);
		panel1.add(label3);		panel2.add(tf3);
		panel1.add(label4);		panel2.add(tf4);
		panel1.add(label5);		panel2.add(tf5);
		panel1.add(label6);		panel2.add(tf6);
		panel3.add(insertbutton);
		panel3.add(cancelbutton);

		this.add(panel1,BorderLayout.WEST);
		this.add(panel2);
		this.add(panel3,BorderLayout.SOUTH);
		this.add(panel4,BorderLayout.EAST);

		this.setLocation(370,270);
		this.setSize(401,281);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("修改"))
		{
			PreparedStatement ps=null;
			Connection ct=null;
			ResultSet rs=null;
			try
			{
//				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//				ct=DriverManager.getConnection("jdbc:odbc:Sql Server","sa","yang9264");
				
//				sql Server java2.bak
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Java","sa","yang9264");
				String ss=("update Student set Name=?,Gender=?,Age=?,Birthplace=?,Major=? where No=?");
				ps=ct.prepareStatement(ss);
				ps.setString(1,tf2.getText());
				ps.setString(2,tf3.getText());
				ps.setString(3,tf4.getText());
				ps.setString(4,tf5.getText());
				ps.setString(5,tf6.getText());
				ps.setString(6,tf1.getText());
				ps.executeUpdate();
				this.dispose();
			}catch(Exception e1){}
			
			finally
			{
				try
				{
					if(rs!=null) rs.close();
					if(ps!=null) ps.close();
					if(ct!=null) ct.close();
				}catch(Exception e2){}
			}
		}
		
		if(e.getActionCommand().equals("取消"))
		{
			this.dispose();
		}
	}

}
