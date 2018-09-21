package Mode;
import java.util.*;
import java.io.*;
import java.net.*;
import Common.*;
public class ST extends Thread
{
	private Socket s;
	
	public ST(Socket s)
	{
		this.s=s;
	}
	
	public void inform(String iam)
	{
		HashMap hm=STI.hm;
		Iterator it=hm.keySet().iterator();
		while(it.hasNext())
		{
			Message m=new Message();
			m.setCon(iam);
			m.setMesType(MessageType.message_ret_onLineFriend);
			String onLineUserId=it.next().toString();
			try
			{
				ObjectOutputStream OOS=new ObjectOutputStream(
						STI.getThread(onLineUserId).s.getOutputStream());
				m.setGetter(onLineUserId);
				OOS.writeObject(m);
			}catch(Exception e1){}
		}
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
					ST st=STI.getThread(m.getGetter());
					ObjectOutputStream OOS=new ObjectOutputStream(st.s.getOutputStream());
					OOS.writeObject(m);
				}else if(m.getMesType().equals(MessageType.message_get_onLineFriend))
				{
					String res=STI.getOnlineUser();
					Message m2=new Message();
					m2.setMesType(MessageType.message_ret_onLineFriend);
					m2.setCon(res);
					m2.setGetter(m.getSender());
//					ST st=STI.getThread(m.getSender());
//					ObjectOutputStream OOS=new ObjectOutputStream(st.s.getOutputStream());
//					It can be right this way,just complicated.
					ObjectOutputStream OOS=new ObjectOutputStream(s.getOutputStream());
					OOS.writeObject(m2);
				}
			}catch(Exception e2){}
		}
	}
}
