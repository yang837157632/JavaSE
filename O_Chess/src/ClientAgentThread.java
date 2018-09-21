import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class ClientAgentThread extends Thread
{
	Chess father;
	boolean flag=true;
	DataInputStream DIS;
	DataOutputStream DOS;
	String challenger;
	
	public ClientAgentThread(Chess father)
	{
		this.father=father;
		try
		{
			DIS=new DataInputStream(father.s.getInputStream());
			DOS=new DataOutputStream(father.s.getOutputStream());
			String name=father.nickname.getText().trim();
			DOS.writeUTF("<#NICK_NAME#>"+name);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		while(flag)
		{
			try
			{
				String msg=DIS.readUTF().trim();
				if(msg.startsWith("<#RENAME#>"))
				{
					this.rename();
				}
				if(msg.startsWith("<#CONNECTED#>"))
				{
					this.connected();
				}
				if(msg.startsWith("<#ONLINE#>"))
				{
					this.online(msg);
				}
				if(msg.startsWith("<#OFFLINE#>"))
				{
					this.offline(msg);
				}
				if(msg.startsWith("<#NICK_LIST#>"))
				{
					this.nick_list(msg);
				}
				if(msg.startsWith("<#SERVER_DOWN#>"))
				{
					this.server_down();
				}
				if(msg.startsWith("<#CHALLENGE#>"))
				{
					this.challenge(msg);
				}
				if(msg.startsWith("<#ACCEPT#>"))
				{
					this.accpet();
				}
				if(msg.startsWith("<#REFUSE#>"))
				{
					this.refuse();
				}
				if(msg.startsWith("<#BUSY#>"))
				{
					this.busy();
				}
				if(msg.startsWith("<#MOVE#>"))
				{
					this.move(msg);
				}
				if(msg.startsWith("<#SURRENDER#>"))
				{
					this.surrender();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void online(String msg)
	{
		String text=msg.substring(10);
		this.father.prompt.setText(text);
		this.father.prompt.setVisible(true);
	}
	
	public void offline(String msg)
	{
		String text=msg.substring(11);
		this.father.prompt.setText(text);
		this.father.prompt.setVisible(true);
	}
	
	public void rename()
	{
		try
		{
			JOptionPane.showMessageDialog(this.father,"该玩家名称已经被占用，请重新填写！","错误",JOptionPane.ERROR_MESSAGE);
			DIS.close();
			DOS.close();
			this.father.host.setEnabled(true);
			this.father.port.setEnabled(true);
			this.father.nickname.setEnabled(true);
			this.father.ConnectB.setEnabled(true);
			this.father.DisconnectB.setEnabled(false);
			this.father.ChallengeB.setEnabled(false);
			this.father.AcceptB.setEnabled(false);
			this.father.RefuseB.setEnabled(false);
			this.father.SurrenderB.setEnabled(false);
			father.s.close();
			father.s=null;
			father.cat=null;
			flag=false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void connected()
	{
		JOptionPane.showMessageDialog(this.father,"服务器连接成功","提示",JOptionPane.INFORMATION_MESSAGE);
		this.father.host.setEnabled(false);
		this.father.port.setEnabled(false);
		this.father.nickname.setEnabled(false);
		this.father.ConnectB.setEnabled(false);
		this.father.DisconnectB.setEnabled(true);
		this.father.ChallengeB.setEnabled(true);
		this.father.AcceptB.setEnabled(false);
		this.father.RefuseB.setEnabled(false);
		this.father.SurrenderB.setEnabled(false);
	}
	
	public void nick_list(String msg)
	{
		String s=msg.substring(13);
		String[] na=s.split("\\|");
		Vector v=new Vector();
		for(int i=0;i<na.length;i++)
		{
			if((na[i].trim().length()!=0)&&(!na[i].trim().equals(father.nickname.getText().trim())))
			{
			v.add(na[i]);	
			}
		}
		father.NickList.setModel(new DefaultComboBoxModel(v));
	}
	
	public void server_down()
	{
		try{
			this.father.host.setEnabled(true);
			this.father.port.setEnabled(true);
			this.father.nickname.setEnabled(true);
			this.father.ConnectB.setEnabled(true);
			this.father.DisconnectB.setEnabled(false);
			this.father.ChallengeB.setEnabled(false);
			this.father.AcceptB.setEnabled(false);
			this.father.RefuseB.setEnabled(false);
			this.father.SurrenderB.setEnabled(false);
			this.DIS.close();
			this.DOS.close();
			this.flag=false;
			father.cat=null;
			father.s.close();
			father.s=null;
			JOptionPane.showMessageDialog(this.father,"服务器停止！！！","提示",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void challenge(String msg)
	{
		try
		{
			String name=msg.substring(13);
			if(this.challenger==null)
			{
				this.challenger=name;
				this.father.host.setEnabled(false);
				this.father.port.setEnabled(false);
				this.father.nickname.setEnabled(false);
				this.father.ConnectB.setEnabled(false);
				this.father.DisconnectB.setEnabled(false);
				this.father.ChallengeB.setEnabled(false);
				this.father.AcceptB.setEnabled(true);
				this.father.RefuseB.setEnabled(true);
				this.father.SurrenderB.setEnabled(false);
				JOptionPane.showMessageDialog(this.father,this.challenger+"向你挑战！！！","提示",JOptionPane.INFORMATION_MESSAGE);
			}else
			{
				this.DOS.writeUTF("<#BUSY#>"+name);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void accpet()
	{
		this.father.host.setEnabled(false);
		this.father.port.setEnabled(false);
		this.father.nickname.setEnabled(false);
		this.father.ConnectB.setEnabled(false);
		this.father.DisconnectB.setEnabled(false);
		this.father.ChallengeB.setEnabled(false);
		this.father.AcceptB.setEnabled(false);
		this.father.RefuseB.setEnabled(false);
		this.father.SurrenderB.setEnabled(true);
		JOptionPane.showMessageDialog(this.father,"对方接受你的挑战！你先走棋（红旗）","提示",JOptionPane.INFORMATION_MESSAGE);
		this.father.kaiPan=true;
		this.father.tip.setText("己方移动中");
	}
	
	public void refuse()
	{
		this.father.host.setEnabled(false);
		this.father.port.setEnabled(false);
		this.father.nickname.setEnabled(false);
		this.father.ConnectB.setEnabled(false);
		this.father.DisconnectB.setEnabled(true);
		this.father.ChallengeB.setEnabled(true);
		this.father.AcceptB.setEnabled(false);
		this.father.RefuseB.setEnabled(false);
		this.father.SurrenderB.setEnabled(false);
		JOptionPane.showMessageDialog(this.father,"对方拒绝你的挑战！","提示",JOptionPane.INFORMATION_MESSAGE);
		this.challenger=null;
	}
	
	public void busy()
	{
		this.father.host.setEnabled(false);
		this.father .port.setEnabled(false);
		this.father.nickname.setEnabled(false);
		this.father.ConnectB.setEnabled(false);
		this.father.DisconnectB.setEnabled(true);
		this.father.ChallengeB.setEnabled(true);
		this.father.AcceptB.setEnabled(false);
		this.father.RefuseB.setEnabled(false);
		this.father.SurrenderB.setEnabled(false);
		JOptionPane.showMessageDialog(this.father,"对方忙碌中!!!","提示",JOptionPane.INFORMATION_MESSAGE);
		this.challenger=null;
	}
	
	public void move(String msg)
	{
		int length=msg.length();
		int startI=Integer.parseInt(msg.substring(length-4,length-3));
		int startJ=Integer.parseInt(msg.substring(length-3,length-2));
		int endI=Integer.parseInt(msg.substring(length-2,length-1));
		int endJ=Integer.parseInt(msg.substring(length-1));
		this.father.panel1.move(startI, startJ,endI,endJ);
		if(this.challenger!=null){
			this.father.kaiPan=true;
			this.father.tip.setText("己方移动中");
		}
	}
	
	public void surrender()
	{
		JOptionPane.showMessageDialog(this.father,"恭喜你，你获胜，对方"+this.challenger+"认输","提示",JOptionPane.INFORMATION_MESSAGE);
		this.father.next();
		this.father.host.setEnabled(false);
		this.father.port.setEnabled(false);
		this.father.nickname.setEnabled(false);
		this.father.ConnectB.setEnabled(false);
		this.father.DisconnectB.setEnabled(true);
		this.father.ChallengeB.setEnabled(true);
		this.father.AcceptB.setEnabled(false);
		this.father.RefuseB.setEnabled(false);
		this.father.SurrenderB.setEnabled(false);
	}
}
