import java.awt.*;
import javax.swing.*;

public class G_5GridLayout extends JFrame
{
	JButton[] E={null,null,null,null,null,null,null,null,null};
	
	public static void main(String[] args)
	{
		new G_5GridLayout();
	}
	
	G_5GridLayout()
	{
		E[0]=new JButton("��÷");
		E[1]=new JButton("����");
		E[2]=new JButton("��Ƭ");
		E[3]=new JButton("����");
		E[4]=new JButton("�ɿ���");
		E[5]=new JButton("����");
		E[6]=new JButton("����");
		E[7]=new JButton("���Ĺ�");
		E[8]=new JButton("����");
		
		this.setLayout(new GridLayout(3,3,20,30));
		//this.setLayout(new GridLayout(3,3))				//�����дΪ0
		for(int i=0;i<E.length;i++)
		{
			this.add(E[i]);
		}
		
		this.setTitle("GridLayout");
		this.setSize(430,450);
		this.setLocation(360,150);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
