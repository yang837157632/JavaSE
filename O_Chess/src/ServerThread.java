import java.util.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class ServerThread extends Thread
{
	Server father;
	ServerSocket ss;
	boolean flag=true;
	
	public ServerThread(Server father)
	{
		this.father=father;
		ss=father.ss;
	}
	
	public void run()
	{
		while(flag)
		{
			try
			{
				Socket s=ss.accept();
				ServerAgentThread sat=new ServerAgentThread(father,s);
				sat.start();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
