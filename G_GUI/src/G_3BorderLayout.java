/*
 * BorderLayout
 * 1.�̳�JFrame��
 * 2.�����Ϸ��������
 * 3.�ڹ��췽���д������
 * 4.�ڹ��췽����������
 * 5.���ô�������
 * 6.��ʾ����
 * 7.���������д�������
 * 8.���в��ֹ���������������������
 */

import java.awt.*;
import javax.swing.*;

public class G_3BorderLayout extends JFrame
{
	JButton c1,c2,c3,c4,c5;
	
	public static void main(String[] args)
	{
		new G_3BorderLayout();
	}
	
	G_3BorderLayout()
	{
		c1=new JButton("����");
		c2=new JButton("����");
		c3=new JButton("�Ϸ�");
		c4=new JButton("����");
		c5=new JButton("�в�");
		
		this.add(c1,BorderLayout.EAST);		//�����еĲ������ǹ̶���˳���ܸı�
		this.add(c2,BorderLayout.WEST);
		this.add(c3,BorderLayout.SOUTH);
		this.add(c4,BorderLayout.NORTH);
		this.add(c5,BorderLayout.CENTER);	//�߽粼�ֱ�������м���������ʡ�Եڶ�������
		//������������ťȫ����ӣ�����������в�Ϊ��������䣬���в����ᱻ�����ĸ����
		
		this.setTitle("BorderLayout");
		this.setSize(450,521);
		this.setLocation(364,154);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
