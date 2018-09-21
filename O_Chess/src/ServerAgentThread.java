import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ServerAgentThread extends Thread
{
	Server father;
	Socket s;
	DataInputStream DIS;
	DataOutputStream DOS;
	boolean flag=true;
	
	public ServerAgentThread(Server father,Socket s)
	{
		this.father=father;
		this.s=s;
		try
		{
			DIS=new DataInputStream(s.getInputStream());
			DOS=new DataOutputStream(s.getOutputStream());
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
				if(msg.startsWith("<#NICK_NAME#>"))
				{
					this.nick_name(msg);
				}
				if(msg.startsWith("<#CLIENT_LEAVE#>"))
				{
					this.client_leave();
				}
				if(msg.startsWith("<#CHALLENGE#>"))
				{
					this.challenge(msg);
				}
				if(msg.startsWith("<#ACCEPT#>"))
				{
					this.accept(msg);
				}
				if(msg.startsWith("<#REFUSE#>"))
				{
					this.refuse(msg);
				}
				if(msg.startsWith("<#BUSY#>"))
				{
					this.busy(msg);
				}
				if(msg.startsWith("<#MOVE#>"))
				{
					this.move(msg);
				}
				if(msg.startsWith("<#SURRENDER#>"))
				{
					this.surrender(msg);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void nick_name(String msg)
	{
		try
		{
			String name=msg.substring(13);
			this.setName(name);
			Vector v=father.onLineUsers;
			boolean isRename=false;
			int size=v.size();
			for(int i=0;i<size;i++)
			{
				ServerAgentThread sat=(ServerAgentThread)v.get(i);
				if(sat.getName().equals(name))
				{
					isRename=true;
					break;
				}
			}
			if(isRename)
			{
				DOS.writeUTF("<#RENAME#>");
				DOS.close();
				DIS.close();
				flag=false;
				this.s.close();
				this.s=null;
			}else
			{
				DOS.writeUTF("<#CONNECTED#>");
				v.add(this);
				father.refreshList();
				String nickListMsg="";
				size=v.size();
				for(int i=0;i<size;i++)
				{
					ServerAgentThread sat=(ServerAgentThread)v.get(i);
					nickListMsg=nickListMsg+"|"+sat.getName();
				}
				nickListMsg="<#NICK_LIST#>"+nickListMsg;
				Vector tempv=father.onLineUsers;
				size=tempv.size();
				for(int i=0;i<size;i++)
				{
					ServerAgentThread sat=(ServerAgentThread)tempv.get(i);
					sat.DOS.writeUTF(nickListMsg);
					if(sat!=this)
					{
						sat.DOS.writeUTF("<#ONLINE#>"+this.getName()+"上线了...");
					}
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void client_leave()
	{
		try
		{
			Vector tempv=father.onLineUsers;
			tempv.remove(this);
			int size=tempv.size();
			String n1="<#NICK_LIST#>";
			for(int i=0;i<size;i++)
			{
				ServerAgentThread sat=(ServerAgentThread)tempv.get(i);
				sat.DOS.writeUTF("<#OFFLINE#>"+this.getName()+"离线了...");
				n1=n1+"|"+sat.getName();
			}
			for(int i=0;i<size;i++)
			{
				ServerAgentThread sat=(ServerAgentThread)tempv.get(i);
				sat.DOS.writeUTF(n1);
			}
			this.DIS.close();
			this.DOS.close();
			this.s.close();
			this.s=null;
			this.flag=false;
			father.refreshList();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void challenge(String msg)
	{
		try
		{
			String name1=this.getName();
			String name2=msg.substring(13);
			Vector v=father.onLineUsers;
			int size=v.size();
			for(int i=0;i<size;i++)
			{
				ServerAgentThread sat=(ServerAgentThread)v.get(i);
				if(sat.getName().equals(name2))
				{
					sat.DOS.writeUTF("<#CHALLENGE#>"+name1);
					break;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void accept(String msg)
	{
		try
		{
			String name=msg.substring(10);
			Vector v=father.onLineUsers;
			int size=v.size();
			for(int i=0;i<size;i++)
			{
				ServerAgentThread sat=(ServerAgentThread)v.get(i);
				if(sat.getName().equals(name))
				{
					sat.DOS.writeUTF("<#ACCEPT#>");
					break;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void refuse(String msg)
	{
		try
		{
			String name=msg.substring(10);
			Vector v=father.onLineUsers;
			int size=v.size();
			for(int i=0;i<size;i++)
			{
				ServerAgentThread sat=(ServerAgentThread)v.get(i);
				if(sat.getName().equals(name))
				{
					sat.DOS.writeUTF("<#REFUSE#>");
					break;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void busy(String msg)
	{
		try
		{
			String name=msg.substring(8);
			Vector v=father.onLineUsers;
			int size=v.size();
			for(int i=0;i<size;i++)
			{
				ServerAgentThread sat=(ServerAgentThread)v.get(i);
				if(sat.getName().equals(name))
				{
					sat.DOS.writeUTF("<#BUSY#>");
					break;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void move(String msg)
	{
		try
		{
			String name=msg.substring(8,msg.length()-4);
			Vector v=father.onLineUsers;
			int size=v.size();
			for(int i=0;i<size;i++)
			{
				ServerAgentThread sat=(ServerAgentThread)v.get(i);
				if(sat.getName().equals(name))
				{
					sat.DOS.writeUTF(msg);
					break;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void surrender(String msg)
	{
		try
		{
			String name=msg.substring(13);
			Vector v=father.onLineUsers;
			int size=v.size();
			for(int i=0;i<size;i++)
			{
				ServerAgentThread sat=(ServerAgentThread)v.get(i);
				if(sat.getName().equals(name))
				{
					sat.DOS.writeUTF("<#SURRENDER#>");
					break;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
