import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class J_6WindowListener extends JFrame
{
	MyPanel6 MP=null;
	
	public static void main(String[] args)
	{
		J_6WindowListener F=new J_6WindowListener();
	}
	
	public J_6WindowListener()
	{
		MP=new MyPanel6();
		this.add(MP);
		this.addWindowListener(MP);
		this.setSize(400, 300);
		this.setLocation(300,280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

class MyPanel6 extends JPanel implements WindowListener
{
	public void paint(Graphics g)
	{
		super.paint(g);
	}
	
	//WindowListener
	public void windowOpened(WindowEvent e)
	{
		System.out.println("���ڴ�");
	}
	
	public void windowClosing(WindowEvent e)
	{
		System.out.println("���ڹر�");
	}
	
	public void windowClosed(WindowEvent e)
	{
		System.out.println("����dispose�ر�");
	}
	
	public void windowIconified(WindowEvent e)
	{
		System.out.println("��С��");
	}
	
	public void windowDeiconified(WindowEvent e)
	{
		System.out.println("����С���������");
	}
	
	public void windowActivated(WindowEvent e)
	{
		System.out.println("���ڱ�����");
	}
	
	public void windowDeactivated(WindowEvent e)
	{
		System.out.println("���ڱ�ͣ��");
	}
}