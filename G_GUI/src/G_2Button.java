import java.awt.*;
import javax.swing.*;

public class G_2Button extends JFrame
{
	JButton b=null;						//����Ҫ�����ȫ�������ﶨ��
	
	public static void main(String[] args)
	{
		new G_2Button();				//������ֻ����ü���
	}
	
	G_2Button()
	{									//�ѳ�ʼ����ȫ�������ŵ����캯����
		this.setTitle("GUI");			//���ô��ڱ���
		this.setSize(400,300);			//���ô��ڴ�С
		this.setLocation(350,250);		//���ô���λ��
		b=new JButton("Button");		//�������
		this.add(b);					//������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
