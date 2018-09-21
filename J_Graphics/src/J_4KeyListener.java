import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class J_4KeyListener extends JFrame
{
	MyPanel4 MP=null;
	
	public static void main(String[] args)
	{
		new J_4KeyListener();
	}
	
	public J_4KeyListener()
	{
		MP=new MyPanel4();
		this.add(MP);
		this.addKeyListener(MP);
		this.setSize(400,300);
		this.setLocation(300, 280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

class MyPanel4 extends JPanel implements KeyListener
{
	int x=50,y=60;
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.green);
		g.fillRect(x, y, 30, 30);
	}
	
	public void keyTyped(KeyEvent e){}			//有字符输出的函数
	
	public void keyPressed(KeyEvent e)
	{
		System.out.println("键盘被按下");
		System.out.println((char)e.getKeyCode());
//		System.out.println(e.getKeyChar());
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			System.out.println("Down");
			y+=10;
		}else if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			System.out.println("Up");
			y-=5;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			System.out.println("Left");
			x-=8;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			System.out.println("Right");
			x++;
		}
		this.repaint();
	}
	
	public void keyReleased(KeyEvent e){}		//按键抬起
}