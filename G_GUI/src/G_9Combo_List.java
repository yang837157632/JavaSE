import java.awt.*;
import javax.swing.*;

public class G_9Combo_List extends JFrame
{
	JPanel P1,P2;
	JLabel L1,L2;
	JComboBox CM;
	JList LS;
	JScrollPane SP;
	
	public static void main(String[] args)
	{
		new G_9Combo_List();
	}
	
	G_9Combo_List()
	{
		P1=new JPanel();			P2=new JPanel();
		L1=new JLabel("����");		L2=new JLabel("ѧ��");
		String[] birthplace={"����","���","�Ϻ�","����"};
		CM=new JComboBox(birthplace);
		String[] education={"Сѧ","����","����","ר��","����","˶ʿ","��ʿ"};
		LS=new JList(education);
		LS.setVisibleRowCount(3);
		SP=new JScrollPane(LS);
		
		this.setLayout(new GridLayout(2,1));
		P1.add(L1);			P1.add(CM);
		P2.add(L2);			P2.add(SP);		//�͵�ѡ��ť��ͬ��������Ҫ��ӹ������
		this.add(P1);		this.add(P2);
		
		this.setTitle("ComboBox_ScrollList");
		this.setSize(300,250);
		this.setLocation(300,260);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
