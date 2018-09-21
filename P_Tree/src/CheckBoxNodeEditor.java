import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class CheckBoxNodeEditor extends AbstractCellEditor implements TreeCellEditor 
{
	CheckBoxNodeRenderer renderer=new CheckBoxNodeRenderer();
	ChangeEvent changeEvent=null;
	JTree tree;
	
	public CheckBoxNodeEditor(JTree tree)
	{
		this.tree=tree;
	}
	
	public Object getCellEditorValue()
	{
		JCheckBox checkbox=renderer.getLeafRenderer();
		CheckBoxNode checkBoxNode=new CheckBoxNode(checkbox.getText(),checkbox.isSelected());
		return checkBoxNode;
	}
	
	public boolean isCellEditable(EventObject event)
	{
		boolean returnValue=false;
		if(event instanceof MouseEvent)
		{
			MouseEvent mouseEvent=(MouseEvent)event;
			TreePath path=tree.getPathForLocation(mouseEvent.getX(),mouseEvent.getY());
			if(path!=null)
			{
				Object node=path.getLastPathComponent();
				if((node!=null)&&(node instanceof DefaultMutableTreeNode))
				{
					DefaultMutableTreeNode treeNode=(DefaultMutableTreeNode)node;
					Object userObject=treeNode.getUserObject();
					returnValue=((treeNode.isLeaf())&&(userObject instanceof CheckBoxNode));
				}
			}
		}
		return returnValue;
	}
	
	public Component getTreeCellEditorComponent(JTree tree,Object value,boolean selected,boolean expanded,boolean leaf,int row)
	{
		Component editor=renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row,true);
		ItemListener itemListener=new ItemListener()
		{
			public void itemStateChanged(ItemEvent event)
			{
				if(stopCellEditing())
				{
					fireEditingStopped();
				}
			}
		};
		if(editor instanceof JCheckBox)
		{
			((JCheckBox)editor).addItemListener(itemListener);
		}
		return editor;
	}	
	
}
