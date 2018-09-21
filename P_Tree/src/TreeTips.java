import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

public class TreeTips 
{
	public static void main(String[] args)
	{
		Runnable runner=new Runnable()
		{
			public void run()
			{
				JFrame frame=new JFrame("Tree Tips");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Properties props=System.getProperties();
				JTree tree=new JTree(props);
				ToolTipManager.sharedInstance().registerComponent(tree);
				TreeCellRenderer renderer=new ToolTipTreeCellRenderer(props);
				tree.setCellRenderer(renderer);
				tree.setRootVisible(true);
				JScrollPane scroll=new JScrollPane(tree);
				frame.add(scroll);
				frame.setSize(300,300);
				frame.setVisible(true);
			}
		};
		
		EventQueue.invokeLater(runner);
	}

}
