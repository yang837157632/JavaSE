package Interface;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Common.*;
import Tool.*;
import DataBase.*;

public class ListF extends JFrame implements ActionListener,MouseListener
{
	JPanel panel1,panel2,panel3,panel4,panel5,panel6;
	JButton button1,button2,button3,button4,button5,button6;
	JScrollPane SP1,SP2;
	JLabel[] label1,label2;
	CardLayout card;
	Vector users;
	String Owner;

	public static void main(String[] args)
	{
		new ListF("bobo");
	}

	public ListF(String Owner)
	{
		this.Owner=Owner;
		users=new Vector();
		users=new DataSelect().getUser();

		button1=new JButton("我的好友");
		button2=new JButton("陌生人");
		button2.addActionListener(this);
		button3=new JButton("黑名单");
		panel1=new JPanel(new BorderLayout());
		panel2=new JPanel(new GridLayout(users.size(),1,4,4));
		label1=new JLabel[users.size()];

		for(int i=0;i<users.size();i++)
		{
			String user=(String)users.get(i);
			label1[i]=new JLabel(user,new ImageIcon("Image/mm.jpg"),JLabel.LEFT);
			label1[i].setEnabled(false);
			label1[i].addMouseListener(this);
			panel2.add(label1[i]);
		}

		panel3=new JPanel(new GridLayout(2,1));
		panel3.add(button2);
		panel3.add(button3);
		SP1=new JScrollPane(panel2);
		panel1.add(button1,"North");
		panel1.add(SP1,"Center");
		panel1.add(panel3,"South");

		button4=new JButton("我的好友");
		button4.addActionListener(this);
		button5=new JButton("陌生人");
		button6=new JButton("黑名单");
		panel4=new JPanel(new BorderLayout());
		panel5=new JPanel(new GridLayout(users.size(),1,4,4));
		label2=new JLabel[users.size()];

		for(int i=0;i<users.size();i++)
		{
			String user=(String)users.get(i);
			label2[i]=new JLabel(user,new ImageIcon("Image/mm.jpg"),JLabel.LEFT);
			label2[i].setEnabled(false);
			label2[i].addMouseListener(this);
			panel5.add(label2[i]);
		}

		panel6=new JPanel(new GridLayout(2,1));
		panel6.add(button4);
		panel6.add(button5);
		SP2=new JScrollPane(panel5);
		panel4.add(panel6,"North");
		panel4.add(SP2,"Center");
		panel4.add(button6,"South");

		card=new CardLayout();
		this.setLayout(card);
		this.add(panel1,"1");
		this.add(panel4,"2");		
		this.setTitle(Owner);
		this.setSize(240,400);
		this.setLocation(318,186);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void updateFriend(Message m)
	{
		String[] onLineFriend=m.getCon().split(" ");
		for(int i=0;i<onLineFriend.length;i++)
		{
			for(int j=0;j<users.size();j++)
			{
				if(label1[j].getText().equals(onLineFriend[i])){
					label1[j].setEnabled(true);
					label2[j].setEnabled(true);
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button2)
		{
			card.show(this.getContentPane(),"2");
		}
		if(e.getSource()==button4)
		{
			card.show(this.getContentPane(),"1");
		}	
	}

	public void mouseClicked(MouseEvent e)
	{
		if(e.getClickCount()==2)
		{
			String friend=((JLabel)e.getSource()).getText();
			Chat chat=new Chat(this.Owner,friend);
			ChatM.addChat(this.Owner+" "+friend,chat);
		}
	}

	public void mouseEntered(MouseEvent e)
	{
		JLabel label=(JLabel)e.getSource();
		label.setForeground(Color.red);
	}

	public void mouseExited(MouseEvent e)
	{
		JLabel label=(JLabel)e.getSource();
		label.setForeground(Color.BLACK);
	}

	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
}
