package Mode;
import java.net.*;
import java.io.*;
import Common.*;
import DataBase.*;
public class Service 
{
	public Service()
	{
		try
		{
			ServerSocket ss=new ServerSocket(9995);
			while(true)
			{
				Socket s=ss.accept();
				ObjectInputStream OIS=new ObjectInputStream(s.getInputStream());
				User u=(User)OIS.readObject();

				Message m=new Message();
				ObjectOutputStream OOS=new ObjectOutputStream(s.getOutputStream());

				String UserId=u.getUserId();
				String passwd=new DataSelect().getpasswd(UserId);
				if(u.getPasswd().equals(passwd))
				{
					m.setMesType("1");
					OOS.writeObject(m);
					ST t=new ST(s);
					STI.addThread(u.getUserId(),t);
					t.start();
					t.inform(u.getUserId());
				}else
				{
					m.setMesType("2");
					OOS.writeObject(m);
					s.close();
				}
			}
		}catch(Exception e){}
	}
}
