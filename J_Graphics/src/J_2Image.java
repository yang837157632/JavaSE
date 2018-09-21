import java.awt.*;
import javax.swing.*;

public class J_2Image extends JFrame
{
	MyPanel2 MP=null;
	
	public static void main(String[] args)
	{
		new J_2Image();
	}
	
	public J_2Image()
	{
		MP=new MyPanel2();
		this.add(MP);
		this.setSize(600,500);
		this.setLocation(300, 180);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

class MyPanel2 extends JPanel
{
	public void paint(Graphics g)
	{
		Image b=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/桔梗.jpg"));
		g.drawImage(b, 50, 80, 400, 350, this);		//绘图用的图片要拷贝在src目录下
		g.setColor(Color.red);
		g.setFont(new Font("幼圆",Font.BOLD,50));
		g.drawString("Hello",100,50);
		g.setFont(new Font("abc",Font.ITALIC,40));	//无该字体时，默认字体
		g.drawString("桔梗", 300, 50);
	}
}