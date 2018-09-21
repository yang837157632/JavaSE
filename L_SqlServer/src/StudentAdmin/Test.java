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
		label=new JLabel("����������",JLabel.CENTER);
		textfield=new JTextField(10);
		selectbutton=new JButton("��ѯ");
		selectbutton.addActionListener(this);
		panel1=new JPanel();
		panel1.add(label);
		panel1.add(textfield);
		panel1.add(selectbutton);
				
		displaybutton=new JButton("��ʾȫ��");
		displaybutton.addActionListener(this);
		insertbutton=new JButton("���");
		insertbutton.addActionListener(this);
		updatebutton=new JButton("�޸�");
		updatebutton.addActionListener(this);
		deletebutton=new JButton("ɾ��");
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
		
		this.setTitle("ѧ������ϵͳ");
		this.setSize(600,500);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("��ʾȫ��"))
		{
			select=new Select();
			table.setModel(select);
		}
		
		if(e.getActionCommand().equals("��ѯ"))
		{
			String name=this.textfield.getText().trim();
			String sql="select * from Student where Name='"+name+"'";
			select=new Select(sql);
			table.setModel(select);		//setModel(TableModel dataModel) 
		}
		
		if(e.getActionCommand().equals("���"))
		{
			new Insert(this,"���ѧ����Ϣ",true);
			select=new Select();
			table.setModel(select);
		}
		
		if(e.getActionCommand().equals("�޸�"))
		{
			int i=this.table.getSelectedRow();
			if(i==-1)
			{
				JOptionPane.showMessageDialog(this,"��ѡ��Ҫ�޸ĵ���");
				return;
			}
			new Update(this,"�޸�ѧ����Ϣ",true,select,i);
			select=new Select();
			table.setModel(select);
		}
		
		if(e.getActionCommand().equals("ɾ��"))
		{
			int i=this.table.getSelectedRow();
			if(i==-1)
			{
				JOptionPane.showMessageDialog(this,"��ѡ��Ҫɾ������");
				return;
			}
			String s=(String)select.getValueAt(i,0);
			new Delete(s);
			select=new Select();
			table.setModel(select);
		}
	}

}
