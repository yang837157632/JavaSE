/*
 * һ������
 * 	1�����
 * 		��ͼ�λ��ķ�ʽ��ʾ����Ļ�ϣ����û����н����Ķ��󣬽��������
 * 		����������˵�����ǩ���ı�������򣩡�����������ѡ����ѡ����ť�ȵȡ�
 * 	2������
 * 		������ܶ�������ʾ������ֻ�ܽ�������������������������ʾ��
 * 		�����������������кͷֲ��������У������������λ�ã���С����Ϊ���֡�
 * �������ֹ�����
 * 	ÿ�����������Լ��Ĳ��ֹ���������ĳ�������ڵ������Ҫ�ı�������ʱ������Ҫ������������������Ĳ��ֹ�������
 * 	awt�г����Ĳ��ֹ������У�BorderLayout���߽粼�ֹ���������FLowLayout����ʽ���ֹ���������GridLayout�����񲼾ֹ���������
 */

import java.awt.*;
import javax.swing.*;

public class G_1JFrame 
{
	public static void main(String[] args)
	{
		JFrame A=new JFrame();
		A.setTitle("GUI");
		A.setSize(350,200);
		A.setLocation(200,200);
		JButton a=new JButton("��ť");
		A.add(a);
		A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��仰һ��Ҫд�ԣ���Ϊ���д�ĶԲ�������ʱ��������
		A.setVisible(true);
	}

}
