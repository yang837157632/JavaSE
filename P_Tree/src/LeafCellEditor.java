import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.tree.*;

public class LeafCellEditor extends DefaultTreeCellEditor
{
	public LeafCellEditor(JTree tree, DefaultTreeCellRenderer renderer)
	{
		super(tree,renderer);
	}
	
	public LeafCellEditor(JTree tree, DefaultTreeCellRenderer renderer, TreeCellEditor editor)
	{
		super(tree,renderer,editor);
	}
	
	public boolean isCellEditable(EventObject event)
	{
		boolean returnValue=super.isCellEditable(event);
		if(returnValue)
		{
			Object node=tree.getLastSelectedPathComponent();
			if((node!=null)&&(node instanceof TreeNode))
			{
				TreeNode treeNode=(TreeNode)node;
				returnValue=treeNode.isLeaf();
			}
		}
		return returnValue;
	}
	
}
