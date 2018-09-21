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
		String[] catalog={"软件开发","游戏设计","平面设计","动画设计","室内设计"};
		LS=new JList(catalog);
		L=new JLabel(new ImageIcon("Image/冰岛.jpg"));
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
