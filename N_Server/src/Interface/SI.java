package Interface;
import javax.swing.*;
import java.awt.event.*;
import Mode.*;
public class SI extends JFrame implements ActionListener
{
	JPanel panel;
	JButton button1,button2;
	public static void main(String[] args)
	{
		new SI();
	}
	public SI()
	{
		panel=new JPanel();
		button1=new JButton("启动服务器");
		button1.addActionListener(this);
		button2=new JButton("关闭服务器");
		button2.addActionListener(this);
		panel.add(button1);
		panel.add(button2);
		
		this.add(panel);
		this.setSize(186,168);
		this.setLocation(318,186);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button1)
		{
			new Service();
		}
		if(e.getSource()==button2)
		{
			System.exit(0);
		}
	}
}
