import java.awt.*;
import javax.swing.*;

public class G_12Login extends JFrame
{
	JLabel L1,L2,L3,L4,L5;
	JPanel P1,P2,P3,P4;
	JButton B1,B2,B3,B4;
	JTextField TF;
	JPasswordField PF;
	JCheckBox CB1,CB2;
	JTabbedPane TP;
	
	public static void main(String[] args)
	{
		new G_12Login();
	}
	
	G_12Login()
	{
		TP=new JTabbedPane();
		P1=new JPanel();
		L1=new JLabel("qq����",JLabel.CENTER);
		L2=new JLabel("qq����",JLabel.CENTER);
		L3=new JLabel("��������",JLabel.CENTER);
		L3.setFont(new Font("����",Font.PLAIN,16));
		L3.setForeground(Color.BLUE);
		L4=new JLabel("<html><a href='www.qq.com'>�������뱣��</a>");
		L4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TF=new JTextField();
		PF=new JPasswordField();
		B1=new JButton("�������");
		CB1=new JCheckBox("�����¼");
		CB2=new JCheckBox("��ס����");
		P1.setLayout(new GridLayout(3,3));
		P1.add(L1);			P1.add(TF);			P1.add(B1);
		P1.add(L2);			P1.add(PF);			P1.add(L3);
		P1.add(CB1);		P1.add(CB2);		P1.add(L4);
		P2=new JPanel();		P2.setBackground(Color.BLUE);
		P3=new JPanel();		P3.setBackground(Color.CYAN);
		TP.add("��ͨ��Ա",P1);		TP.add("QQ��Ա",P2);		TP.add("����Ա",P3);
		this.add(TP);
		
		P4=new JPanel();
		B2=new JButton("��¼");		P4.add(B2);
		B3=new JButton("ȡ��");		P4.add(B3);
		B4=new JButton("��");		P4.add(B4);
		this.add(P4,BorderLayout.SOUTH);
		
		L1=new JLabel(new ImageIcon("Image/qq2.jpg"));
		this.add(L1,BorderLayout.NORTH);
		
		this.setTitle("User Login");
		this.setIconImage((new ImageIcon("Image/qq.jpg")).getImage());
		this.setSize(340,270);
		this.setLocation(300,280);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
