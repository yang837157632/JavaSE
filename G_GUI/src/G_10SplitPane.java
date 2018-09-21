import java.awt.*;
import javax.swing.*;

public class G_10SplitPane extends JFrame
{
	JSplitPane SPL;
	JList LS;
	JLabel L;
	
	public static void main(String[] args)
	{
		new G_10SplitPane();
	}
	
	G_10SplitPane()
	{
		String[] catalog={"�������","��Ϸ���","ƽ�����","�������","�������"};
		LS=new JList(catalog);
		L=new JLabel(new ImageIcon("Image/����.jpg"));
		SPL=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,LS,L);
//		SPL=new JSplitPane(JSplitPane.VERTICAL_SPLIT,LS,L);
		SPL.setOneTouchExpandable(true);
		this.add(SPL);
		
		this.setTitle("SplitPane");
		this.setSize(640,480);
		this.setLocation(300,180);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
