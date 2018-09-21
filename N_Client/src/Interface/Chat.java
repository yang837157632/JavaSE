package Interface;
import Common.*;
import Tool.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Chat extends JFrame implements ActionListener
{
	JTextArea textarea;
	JTextField textfield;
	JButton button;
	JPanel panel;
	String Owner;
	String friend;
	String info;
	
//	public static void main(String[] args)
//	{
//	new Chat("2","3");
//	}
	
	public Chat(String Owner,String friend)
	{
		this.Owner=Owner;
		this.friend=friend;
		textarea=new JTextArea();
		textfield=new JTextField(15);
		button=new JButton("����");
		button.addActionListener(this);
		panel=new JPanel();
		panel.add(textfield);
		panel.add(button);

		this.add(textarea,"Center");
		this.add(panel,"South");
		this.setTitle(Owner+" ���ں� "+friend+" ����");
		this.setIconImage((new ImageIcon("Image/qq.gif")).getImage());
		this.setSize(300,200);
		this.setLocation(318,186);
		this.setVisible(true);
	}
	
	public void showMessage(Message m)
	{
		String datetime=Calendar.getInstance().getTime().toLocaleString();
		info=m.getSender()+" ����˵��"+m.getCon()+"\t"+datetime+"\r\n";
		textarea.append(info);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button)
		{
			Message m=new Message();
			m.setMesType(MessageType.message_comm_mes);
			m.setSender(this.Owner);
			m.setGetter(this.friend);
			m.setCon(textfield.getText());
			m.setSendTime(new Date().toString());
			try
			{
				ObjectOutputStream OOS=new ObjectOutputStream(ThreadM.getSTLink(Owner).getS().getOutputStream());
				OOS.writeObject(m);
				String datetime=Calendar.getInstance().getTime().toLocaleString();
				String content="�Ҷ� "+m.getGetter()+" ˵�� "+textfield.getText()+"\t"+datetime+"\r\n";
				textarea.append(content);
				textfield.setText("");
			}catch(Exception ee){}
		}		
	}
}
