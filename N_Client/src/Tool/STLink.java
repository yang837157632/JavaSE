package Tool;
import java.io.*;
import java.net.*;
import Common.*;
import Interface.*;
public class STLink extends Thread
{
	private Socket s;
	
	public STLink(Socket s)
	{
		this.s=s;
	}
	
	public Socket getS()
	{
		return s;
	}
	
	public void setS(Socket s)
	{
		this.s=s;
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				ObjectInputStream OIS=new ObjectInputStream(s.getInputStream());
				Message m=(Message)OIS.readObject();
				if(m.getMesType().equals(MessageType.message_comm_mes))
				{
					Chat chat=ChatM.getChat(m.getGetter()+" "+m.getSender());
					chat.showMessage(m);
				}else if(m.getMesType().equals(MessageType.message_ret_onLineFriend))
				{
					String getter=m.getGetter();
					ListF list=FriendList.getList(getter);
					if(list!=null)
					{
						list.updateFriend(m);
					}
				}
			}catch(Exception e){}
		}
	}
}
