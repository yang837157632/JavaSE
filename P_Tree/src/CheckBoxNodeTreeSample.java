import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class CheckBoxNodeTreeSample 
{
	public static void main(String[] args)
	{
		Runnable runner=new Runnable()
		{
			public void run()
			{
				JFrame frame=new JFrame("CheckBox Tree");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				CheckBoxNode accessibilityOptions[]={
						new CheckBoxNode("Move System caret with focus/selection changes",false),
						new CheckBoxNode("Always exand alt text for images",true)
				};
				CheckBoxNode browsingOptions[]={
						new CheckBoxNode("Notify when downloads complete",true),
						new CheckBoxNode("Diasable script debuggging",true),
						new CheckBoxNode("Use AutoVomplete",true),
						new CheckBoxNode("Browse in a new process",false)
				};
				Vector<CheckBoxNode> accessVector=new NamedVector<CheckBoxNode>("Accessibility",accessibilityOptions);
				Vector<CheckBoxNode> browseVector=new NamedVector<CheckBoxNode>("Browsing",browsingOptions);
				Object rootNodes[]={accessVector,browseVector};
				Vector<Object> rootVector=new NamedVector<Object>("Root",rootNodes);
				JTree tree=new JTree(rootVector);
				CheckBoxNodeRenderer renderer=new CheckBoxNodeRenderer();
				tree.setCellRenderer(renderer);
				tree.setCellEditor(new CheckBoxNodeEditor(tree));
				tree.setEditable(true);
				JScrollPane scroll=new JScrollPane(tree);
				frame.add(scroll);
				frame.setSize(300,300);
				frame.setVisible(true);
				
			}
		};
		EventQueue.invokeLater(runner);
	}
}
