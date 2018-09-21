import java.awt.*;
import javax.swing.*;

public class G_8Radio_Check extends JFrame
{
	JPanel P1,P2,P3;
	JButton B1,B2;
	JLabel L1,L2;
	JRadioButton RB1,RB2;
	JCheckBox CB1,CB2,CB3;
	ButtonGroup BG;			//把单选按钮放进一个组里
	
	public static void main(String[] args)
	{
		new G_8Radio_Check();
	}
	
	G_8Radio_Check()
	{
		P1=new JPanel();				P2=new JPanel();				P3=new JPanel();
		CB1=new JCheckBox("音乐");		CB2=new JCheckBox("体育");		CB3=new JCheckBox("文艺");
		B1=new JButton("注册");			B2=new JButton("取消");
		L1=new JLabel("特长");			L2=new JLabel("性别");
		RB1=new JRadioButton("男");		RB2=new JRadioButton("女");
		BG=new ButtonGroup();
		BG.add(RB1);					BG.add(RB2);			//添加进组，使其只能选一个
		
		this.setLayout(new GridLayout(3,1));
		P1.add(L1);		P1.add(CB1);		P1.add(CB2);		P1.add(CB3);
		P2.add(L2);		P2.add(RB1);		P2.add(RB2);		//只能一个一个添加，不能把组添加进来
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
