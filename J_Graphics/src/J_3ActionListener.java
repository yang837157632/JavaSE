import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class J_3ActionListener extends JFrame implements ActionListener
{
	MyPanel3 MP=null;
	JButton B1,B2;
	
	public static void main(String[] args)
	{
		new J_3ActionListener();
	}
	
	public J_3ActionListener()
	{
		MP=new MyPanel3();
		B1=new JButton("Red");
		B2=new JButton("Blue");
		Listener L=new Listener();
		
		this.add(B1,BorderLayout.NORTH);
		this.add(B2,BorderLayout.SOUTH);
		MP.setBackground(Color.yellow);
		this.add(MP);
		B1.addActionListener(this);
		B1.addActionListener(L);
		B1.setActionCommand("111");			//区别按钮
		B2.addActionListener(this);
		B2.addActionListener(L);
		B2.setActionCommand("222");
		
		this.setSize(300,260);
		this.setLocation(300, 280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("按钮起作用了");
		if(e.getActionCommand().equals("111"))
		{
			System.out.println("Red\tRed\n");
			MP.setBackground(Color.red);
		}else if(e.getActionCommand().equals("222"))
		{
			System.out.println("Blue\tBlue\n");
			MP.setBackground(Color.blue);
		}
		
	}

}

class MyPanel3 extends JPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);
	}
}

class Listener implements ActionListener
{
	public void actionPerformed(ActionEvent E)
	{
		if(E.getActionCommand().equals("111"))
		{
			System.out.println("监听者正在监听，你按下的是红色按钮");
		}else if(E.getActionCommand().equals("222"))
		{
			System.out.println("监听者正在监听，你按下的是蓝色按钮");
		}
	}
}
