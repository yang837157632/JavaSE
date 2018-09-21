import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;

public class ComboBoxSample 
{
	public static void main(String[] args)
	{
		Runnable runner=new Runnable()
		{
			public void run()
			{
				JFrame frame=new JFrame("Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Vector<String> one=new NamedVector<String>("One",new String[]{"Red","Orange","Yellow","Green","Cyan","Blue","Violet"});
				Vector<Object> two=new NamedVector<Object>("two");
				two.add(one);
				two.add(System.getProperties());
				Object roots[]={one,two};
				Vector<Object> root=new NamedVector<Object>("root",roots);
				JTree tree=new JTree(root);
				
				tree.setEditable(true);
				String elements[] = { "Root", "chartreuse", "rugby", "sushi"} ;
				JComboBox comboBox = new JComboBox(elements);
				comboBox.setEditable(true);
				TreeCellEditor editor = new DefaultCellEditor(comboBox);
				tree.setCellEditor(editor);
				
//				Object array[]={Boolean.TRUE, Boolean.FALSE, "Hello"}; // Hello will map to false
//				JTree tree = new JTree(array);
//				tree.setEditable(true);
//				tree.setRootVisible(true);
//				JCheckBox checkBox = new JCheckBox();
//				TreeCellEditor editor = new DefaultCellEditor(checkBox);
//				tree.setCellEditor(editor);

				JScrollPane scroll=new JScrollPane(tree);
				frame.add(scroll);
				frame.setSize(300,300);
				frame.setVisible(true);
			}
		};
		EventQueue.invokeLater(runner);
	}
}
