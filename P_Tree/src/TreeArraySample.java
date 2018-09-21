import java.util.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.tree.*;

public class TreeArraySample 
{
	public static void main(final String[] args)
	{
		Runnable runner=new Runnable()
		{
			public void run()
			{
				JFrame frame=new JFrame("JTreeSample");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Vector<String> oneVector=new NamedVector<String>("One",args);
				Vector<String> twoVector=new NamedVector<String>("Two",new String[] {"Mercury","Venus","Mars"});
				Vector<Object> threeVector=new NamedVector<Object>("Three");
				threeVector.add(System.getProperties());
				threeVector.add(twoVector);
				Object rootNodes[]={oneVector,twoVector,threeVector};
				Vector<Object> rootVector=new NamedVector<Object>("Root",rootNodes);
				JTree tree=new JTree(rootVector);
				JScrollPane scroll=new JScrollPane(tree);
				frame.add(scroll,BorderLayout.CENTER);
				frame.setSize(300,300);
				frame.setVisible(true);

				DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)tree.getCellRenderer();
 
//				Swap background colors
//				Color backgroundSelection = renderer.getBackgroundSelectionColor();
//				renderer.setBackgroundSelectionColor(renderer.getBackgroundNonSelectionColor());
//				renderer.setBackgroundNonSelectionColor(backgroundSelection);
//				Swap text colors
//				Color textSelection = renderer.getTextSelectionColor();
//				renderer.setTextSelectionColor(renderer.getTextNonSelectionColor());
//				renderer.setTextNonSelectionColor(textSelection);
				
				renderer.setFont(new Font("Dialog",Font.BOLD|Font.ITALIC,32));
				ToolTipManager.sharedInstance().registerComponent(tree);
				renderer.setToolTipText("Constant Tool Tip Text");
				int rowHeight=tree.getRowHeight();
				if(rowHeight<=0)
				{
					tree.setRowHeight(rowHeight-1);
//					这个值减少1具有使得缓存的渲染器尺寸信息无效的副作用
				}
				
//				UIManager.put("Tree.openIcon",new DiamondIcon(Color.RED,false));
//				openIcon	collapsedIcon	expandedIcon	leafIcon	closedIcon
//				UIManager暂时不知道怎么用
//				UIManager.put("Tree.line", Color.RED);

//				tree.putClientProperty("JTree.lineStyle","None");
//				tree.putClientProperty("JTree.lineStyle","Angled");		默认
//				tree.putClientProperty("JTree.lineStyle","Horizontal");
		
			}
		};
		
		EventQueue.invokeLater(runner);
		
	}
}
