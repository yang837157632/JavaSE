import java.awt.*;
import javax.swing.*;

public class G_11TextArea extends JFrame
{
	JPanel P;
	JTextArea TA;
	JComboBox CB;
	JTextField TF;
	JButton B;
	JScrollPane SP;
	
	public static void main(String[] args)
	{
		new G_11TextArea();
	}
	
	G_11TextArea()
	{
		P=new JPanel();
		TA=new JTextArea();
		B=new JButton("·¢ËÍ");
		TF=new JTextField(10);
		String[] name={"Îò¿Õ","°Ë½ä","É³É®","ÌÆÉ®"};
		CB=new JComboBox(name);
		SP=new JScrollPane(TA);
		
		P.add(CB);		P.add(TF);		P.add(B);
		this.add(SP);		
		this.add(P,BorderLayout.SOUTH);
		
		this.setTitle("TextArea");
		this.setSize(300,200);
		this.setLocation(300,280);
		this.setIconImage((new ImageIcon("Image/qq.jpg")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
