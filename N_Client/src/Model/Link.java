package Model;
import java.io.*;
import java.net.*;
import java.util.*;
import Common.*;
import Tool.*;

public class Link 
{
	public Socket s;
	public boolean send(Object o)
	{
		boolean flag=false;
		try
		{
			s=new Socket("127.0.0.1",9995);
			ObjectOutputStream OOS=new ObjectOutputStream(s.getOutputStream());
			OOS.writeObject(o);
			ObjectInputStream OIS=new ObjectInputStream(s.getInputStream());
			Message m=(Message)OIS.readObject();
			if(m.getMesType().equals("1"))
			{
				STLink stl=new STLink(s);
				stl.start();
				ThreadM.addSTLink(((User)o).getUserId(),stl);			
				flag=true;
			}
		}catch(Exception e){}
		return flag;
	}

}
