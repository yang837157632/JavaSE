/*
 * paint方法在以下三种情况下被系统自动调用
 * 1、启动程序
 * 2、窗口大小发生变化
 * 3、运行repaint函数时
 */

import java.awt.*;

import javax.swing.*;

public class J_1Graph extends JFrame
{
	MyPanel MP=null;
	
	public static void main(String[] args)
	{
		new J_1Graph();
	}
	
	public J_1Graph()
	{
		MP=new MyPanel();
		this.add(MP);
		this.setSize(1000,500);
		this.setLocation(100,80);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

class MyPanel extends JPanel
{
	public void paint(Graphics g)
	{												//这个方法是覆盖父类的方法，意思是画笔
		System.out.println("paint函数被调用");
		g.drawOval(50,60,100,140);					//绘制椭圆或圆(x1,y1,Δx,Δy)
		g.drawLine(100,300,350,400);				//绘制直线(x1,y1,x2,y2)
		g.drawRect(200, 200, 160, 60);				//绘制矩形(x1,y1,Δx,Δy)
		g.draw3DRect(500,50,150,160,false);			//绘制3D矩形(x1,y1,Δx,Δy),true凸,false凹
		g.setColor(Color.blue);						//如果不设置颜色，默认为黑色
		g.fillRect(800, 200, 100, 100);				//绘制填充矩形(x1,y1,Δx,Δy)
		g.setColor(Color.pink);
		g.fillOval(700, 300, 80, 80);				//绘制填充椭圆(x1,y1,Δx,Δy)
		
//		Graphics2D gD=(Graphics2D)g;
//		gD.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	}
}
