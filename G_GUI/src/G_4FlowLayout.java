import java.awt.*;
import javax.swing.*;

public class G_4FlowLayout extends JFrame
{
	JButton[] D={null,null,null,null,null,null,null,null};
	
	public static void main(String[] args)
	{
		new G_4FlowLayout();
	}
	
	G_4FlowLayout()
	{
		D[0]=new JButton("��÷");
		D[1]=new JButton("����");
		D[2]=new JButton("��Ƭ");
		D[3]=new JButton("����");
		D[4]=new JButton("�ɿ���");
		D[5]=new JButton("����");
		D[6]=new JButton("����");
		D[7]=new JButton("���Ĺ�");
		
//		javaĬ�ϵ��Ǳ߽粼�ֹ�������ʹ���������ֹ�����ʱ����Ҫ���������ִ���
//		this.setLayout(new FlowLayout());						//���ж���
//		this.setLayout(new FlowLayout(FlowLayout.LEFT));		//�����
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));		//�Ҷ���
		for(int i=0;i<D.length;i++)
		{
			this.add(D[i]);
		}
		
		this.setTitle("FlowLayout");
		this.setSize(380,120);
		this.setLocation(200,200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
