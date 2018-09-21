package StudentAdmin;
import javax.swing.*;
import java.awt.event.*;

public class Test extends JFrame implements ActionListener
{
	JPanel panel1,panel2;
	JLabel label;
	JTextField textfield;
	JButton displaybutton,selectbutton,insertbutton,updatebutton,deletebutton;
	JTable table;
	JScrollPane scrollpane;
	Select select;
	
	public static void main(String[] args)
	{
		new Test();
	}
	
	public Test()
	{
		label=new JLabel("请输入姓名",JLabel.CENTER);
		textfield=new JTextField(10);
		selectbutton=new JButton("查询");
		selectbutton.addActionListener(this);
		panel1=new JPanel();
		panel1.add(label);
		panel1.add(textfield);
		panel1.add(selectbutton);
				
		displaybutton=new JButton("显示全部");
		displaybutton.addActionListener(this);
		insertbutton=new JButton("添加");
		insertbutton.addActionListener(this);
		updatebutton=new JButton("修改");
		updatebutton.addActionListener(this);
		deletebutton=new JButton("删除");
		deletebutton.addActionListener(this);
		panel2=new JPanel();
		panel2.add(displaybutton);
		panel2.add(insertbutton);
		panel2.add(updatebutton);
		panel2.add(deletebutton);
		
		select=new Select();
		table=new JTable(select);
		scrollpane=new JScrollPane(table);
		
		this.add(panel1,"North");
		this.add(panel2,"South");
		this.add(scrollpane);
		
		this.setTitle("学生管理系统");
		this.setSize(600,500);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("显示全部"))
		{
			select=new Select();
			table.setModel(select);
		}
		
		if(e.getActionCommand().equals("查询"))
		{
			String name=this.textfield.getText().trim();
			String sql="select * from Student where Name='"+name+"'";
			select=new Select(sql);
			table.setModel(select);		//setModel(TableModel dataModel) 
		}
		
		if(e.getActionCommand().equals("添加"))
		{
			new Insert(this,"添加学生信息",true);
			select=new Select();
			table.setModel(select);
		}
		
		if(e.getActionCommand().equals("修改"))
		{
			int i=this.table.getSelectedRow();
			if(i==-1)
			{
				JOptionPane.showMessageDialog(this,"请选择要修改的行");
				return;
			}
			new Update(this,"修改学生信息",true,select,i);
			select=new Select();
			table.setModel(select);
		}
		
		if(e.getActionCommand().equals("删除"))
		{
			int i=this.table.getSelectedRow();
			if(i==-1)
			{
				JOptionPane.showMessageDialog(this,"请选择要删除的行");
				return;
			}
			String s=(String)select.getValueAt(i,0);
			new Delete(s);
			select=new Select();
			table.setModel(select);
		}
	}

}
