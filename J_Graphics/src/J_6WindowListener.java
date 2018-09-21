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
		System.out.println("窗口打开");
	}
	
	public void windowClosing(WindowEvent e)
	{
		System.out.println("窗口关闭");
	}
	
	public void windowClosed(WindowEvent e)
	{
		System.out.println("窗口dispose关闭");
	}
	
	public void windowIconified(WindowEvent e)
	{
		System.out.println("最小化");
	}
	
	public void windowDeiconified(WindowEvent e)
	{
		System.out.println("从最小化变成正常");
	}
	
	public void windowActivated(WindowEvent e)
	{
		System.out.println("窗口被激活");
	}
	
	public void windowDeactivated(WindowEvent e)
	{
		System.out.println("窗口被停用");
	}
}