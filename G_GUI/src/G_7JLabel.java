import java.awt.*;
import javax.swing.*;

public class G_7JLabel extends JFrame
{
	JPanel P1,P2,P3;
	JButton B1,B2;
	JLabel L1,L2;
	JTextField TF;
	JPasswordField PF;
	
	public static void main(String[] args)
	{
		new G_7JLabel();
	}
	
	G_7JLabel()
	{
		P1=new JPanel();
		P2=new JPanel();
		P3=new JPanel();
		B1=new JButton("登录");
		B2=new JButton("取消");
		L1=new JLabel("用户名");
		L2=new JLabel("密  码");
		TF=new JTextField(10);
		PF=new JPasswordField(10);
		
		this.setLayout(new GridLayout(3,1));
		P1.add(L1);		P1.add(TF);
		P2.add(L2);		P2.add(PF);
		P3.add(B1);		P3.add(B2);
		this.add(P1);
		this.add(P2);
		this.add(P3);
		
		this.setTitle("JLabel");
		this.setSize(230,150);
		this.setLocation(300,280);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
