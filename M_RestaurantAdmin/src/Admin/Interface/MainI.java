package Admin.Interface;

import java.awt.*;
import javax.swing.*;

public class MainI extends JWindow implements Runnable
{
	JProgressBar JPB;
	JLabel label;
	int width,height;
	
	public static void main(String[] args)
	{
		MainI M=new MainI();
		Thread t=new Thread(M);
		t.start();
	}
	
	public MainI()
	{
		label=new JLabel(new ImageIcon("Image/index.gif"));
		JPB=new JProgressBar();
		JPB.setStringPainted(true);		//���� stringPainted ���Ե�ֵ��������ȷ���������Ƿ�Ӧ�ó��ֽ����ַ�����
		JPB.setIndeterminate(false);	//���ý������� indeterminate ���ԣ�������ȷ������������ȷ��ģʽ�л��Ǵ��ڲ�ȷ��ģʽ�С�
		JPB.setBorderPainted(false);	//���� borderPainted ���ԣ����������Ӧ�û�����߿��������Ϊ true��
		JPB.setBackground(Color.DARK_GRAY);
		this.add(label,BorderLayout.NORTH);
		this.add(JPB,BorderLayout.SOUTH );
		this.setSize(400,263);
		width=Toolkit.getDefaultToolkit().getScreenSize().width;
		height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200,height/2-150);
		this.setVisible(true);
	}
	
	public void run()
	{
		int[] progressValue={0,1,5,8,14,17,26,35,38,43,49,56,65,71,75,78,86,94,98,99,100};
		for(int i=0;i<progressValue.length;i++)
		{
			try
			{
				Thread.sleep(1000);
			}catch(Exception e){}
			JPB.setValue(progressValue[i]);
		}
		new Login();
		this.dispose();
	}
}
