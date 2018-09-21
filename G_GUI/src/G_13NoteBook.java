import java.awt.*;
import javax.swing.*;

public class G_13NoteBook extends JFrame
{
	JMenuBar Menu;
	JMenu M1,M2,M3,M4,M5;
	JMenuItem MI12,MI13,MI14,MI15,MI16,MI17;
	JMenu M11;
	JMenuItem MI111,MI112;
	JToolBar Tool;
	JButton B1,B2,B3;
	JTextArea TA;
	JScrollPane SP;
	
	public static void main(String[] args)
	{
		new G_13NoteBook();
	}
	
	G_13NoteBook()
	{
		Tool=new JToolBar();
		B1=new JButton(new ImageIcon("Image/New.gif"));
		B1.setToolTipText("�½�");
		B2=new JButton(new ImageIcon("Image/Open.gif"));
		B2.setToolTipText("��");
		B3=new JButton(new ImageIcon("Image/Save.gif"));
		B3.setToolTipText("����");
		Tool.add(B1);		Tool.add(B2);		Tool.add(B3);
		this.add(Tool,BorderLayout.NORTH);
				
		Menu=new JMenuBar();
		M1=new JMenu("�ļ�(F)");		M1.setMnemonic('F');
		M2=new JMenu("�༭(E)");		M2.setMnemonic('E');
		M3=new JMenu("��ʽ(O)");		M3.setMnemonic('O');
		M4=new JMenu("�鿴(V)");		M4.setMnemonic('V');
		M5=new JMenu("����(H)");		M5.setMnemonic('H');	
		M11=new JMenu("�½�");
		MI111=new JMenuItem("�ļ�",new ImageIcon("Image/New.gif"));
		MI112=new JMenuItem("ģ��");
		MI12=new JMenuItem("��",new ImageIcon("Image/Open.gif"));
		MI13=new JMenuItem("����(S)",new ImageIcon("Image/Save.gif"));
		MI13.setMnemonic('S');
		MI14=new JMenuItem("���Ϊ");
		MI15=new JMenuItem("ҳ������");
		MI16=new JMenuItem("��ӡ");
		MI17=new JMenuItem("�˳�");
		M11.add(MI111);		M11.add(MI112);
		M1.add(M11);		M1.add(MI12);		
		M1.add(MI13);		M1.add(MI14);
		M1.addSeparator();
		M1.add(MI15);		M1.add(MI16);
		M1.addSeparator();
		M1.add(MI17);
		Menu.add(M1);		Menu.add(M2);		Menu.add(M3);
		Menu.add(M4);		Menu.add(M5);
		this.setJMenuBar(Menu);
		
		TA=new JTextArea();
		SP=new JScrollPane(TA);
		this.add(SP);
				
		this.setIconImage((new ImageIcon("Image/NoteBook.jpg")).getImage());
		this.setTitle("NoteBook");
		this.setSize(570,370);
		this.setLocation(300,280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
