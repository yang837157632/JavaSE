import java.awt.*;
import javax.swing.*;

public class G_8Radio_Check extends JFrame
{
	JPanel P1,P2,P3;
	JButton B1,B2;
	JLabel L1,L2;
	JRadioButton RB1,RB2;
	JCheckBox CB1,CB2,CB3;
	ButtonGroup BG;			//�ѵ�ѡ��ť�Ž�һ������
	
	public static void main(String[] args)
	{
		new G_8Radio_Check();
	}
	
	G_8Radio_Check()
	{
		P1=new JPanel();				P2=new JPanel();				P3=new JPanel();
		CB1=new JCheckBox("����");		CB2=new JCheckBox("����");		CB3=new JCheckBox("����");
		B1=new JButton("ע��");			B2=new JButton("ȡ��");
		L1=new JLabel("�س�");			L2=new JLabel("�Ա�");
		RB1=new JRadioButton("��");		RB2=new JRadioButton("Ů");
		BG=new ButtonGroup();
		BG.add(RB1);					BG.add(RB2);			//��ӽ��飬ʹ��ֻ��ѡһ��
		
		this.setLayout(new GridLayout(3,1));
		P1.add(L1);		P1.add(CB1);		P1.add(CB2);		P1.add(CB3);
		P2.add(L2);		P2.add(RB1);		P2.add(RB2);		//ֻ��һ��һ����ӣ����ܰ�����ӽ���
		P3.add(B1);		P3.add(B2);
		this.add(P1);	this.add(P2);		this.add(P3);
		
		this.setTitle("RadioButton_CheckBox");
		this.setSize(340,150);
		this.setLocation(300,280);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
