/*
 * paint������������������±�ϵͳ�Զ�����
 * 1����������
 * 2�����ڴ�С�����仯
 * 3������repaint����ʱ
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
	{												//��������Ǹ��Ǹ���ķ�������˼�ǻ���
		System.out.println("paint����������");
		g.drawOval(50,60,100,140);					//������Բ��Բ(x1,y1,��x,��y)
		g.drawLine(100,300,350,400);				//����ֱ��(x1,y1,x2,y2)
		g.drawRect(200, 200, 160, 60);				//���ƾ���(x1,y1,��x,��y)
		g.draw3DRect(500,50,150,160,false);			//����3D����(x1,y1,��x,��y),true͹,false��
		g.setColor(Color.blue);						//�����������ɫ��Ĭ��Ϊ��ɫ
		g.fillRect(800, 200, 100, 100);				//����������(x1,y1,��x,��y)
		g.setColor(Color.pink);
		g.fillOval(700, 300, 80, 80);				//���������Բ(x1,y1,��x,��y)
		
//		Graphics2D gD=(Graphics2D)g;
//		gD.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	}
}
