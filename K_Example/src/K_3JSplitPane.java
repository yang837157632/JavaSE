import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class K_3JSplitPane extends JFrame implements ActionListener
{
	JSplitPane JSP;
	JPanel leftpanel,rightpanel;
	JLabel label,label1,label2,label3;
	CardLayout card;
	JButton button1,button2,button3;
	JToolBar toolbar;
	JButton button,button0;
	
	public static void main(String[] args)
	{
		new K_3JSplitPane();
	}
	
	public K_3JSplitPane()
	{
		toolbar=new JToolBar();
		button=new JButton("收缩");
		button0=new JButton("还原");
		toolbar.add(button);
		toolbar.add(button0);
		button.addActionListener(this);
		button0.addActionListener(this);

		leftpanel=new JPanel(new GridLayout(3,1));
		button1=new JButton("1");
		leftpanel.add(button1);
		button1.addActionListener(this);
		
		button2=new JButton("2");
		leftpanel.add(button2);
		button2.addActionListener(this);
		
		button3=new JButton("3");
		leftpanel.add(button3);
		button3.addActionListener(this);

		card=new CardLayout();
		rightpanel=new JPanel(card);
		label=new JLabel(new ImageIcon("Image/jp3_bg.jpg"));
		label1=new JLabel(new ImageIcon("Image/jp3_1.jpg"));
		label2=new JLabel(new ImageIcon("Image/jp3_2.jpg"));
		label3=new JLabel(new ImageIcon("Image/jp3_3.jpg"));
		
		rightpanel.add(label,"0");
		rightpanel.add(label1,"1");
		rightpanel.add(label2,"2");
		rightpanel.add(label3,"3");

		JSP=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftpanel,rightpanel);
//		JSP=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,leftpanel,rightpanel);
//		JSP=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,leftpanel,rightpanel);
		JSP.setDividerLocation(50);
		JSP.setDividerSize(0);
		this.add(toolbar,BorderLayout.NORTH);
		this.add(JSP);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width-50,height-100);
		this.setLocationRelativeTo(null);
		this.setTitle("JSplitPane");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if((e.getActionCommand())=="收缩")
		{
			this.JSP.setDividerLocation(0);
			button.setText("伸展");
		}
		
		if((e.getActionCommand())=="伸展")
		{
			this.JSP.setDividerLocation(50);
			button.setText("收缩");
		}
		
		if((e.getSource())==button0)
		{
			this.card.show(rightpanel,"0");
		}
		
		if((e.getSource())==button1)
		{
			this.card.show(rightpanel,"1");
		}
		
		if((e.getSource())==button2)
		{
			this.card.show(rightpanel,"2");
		}
		
		if((e.getSource())==button3)
		{
			this.card.show(rightpanel,"3");
		}
	}
}