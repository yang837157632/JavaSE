import java.util.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Server extends JFrame implements ActionListener
{
	JLabel label=new JLabel("端口号");
	JTextField textfield=new JTextField("9999");
	JButton start=new JButton("启动");
	JButton stop=new JButton("关闭");
	JPanel panel=new JPanel();
	JList List=new JList();
	JScrollPane scroll=new JScrollPane(List);
	JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,panel);
	Vector onLineUsers=new Vector();
	ServerSocket ss;
	ServerThread st;

	public static void main(String[] args)
	{
		new Server();
	}

	public Server()
	{
		this.initialComponent();
		this.addListener();
		this.initialFrame();
	}

	public void initialComponent()
	{
		panel.setLayout(null);
		label.setBounds(20,20,50,20);
		panel.add(label);
		textfield.setBounds(85,20,60,20);
		panel.add(textfield);
		start.setBounds(18,50,60,20);;
		panel.add(start);
		stop.setBounds(85,50,60,20);
		panel.add(stop);
		stop.setEnabled(false);		
	}

	public void addListener()
	{
		start.addActionListener(this);
		stop.addActionListener(this);
	}

	public void initialFrame()
	{
		this.setTitle("象棋——服务器端");
		Image image=new ImageIcon("Image/Server.jpg").getImage();
		this.setIconImage(image);
		this.add(split);
		split.setDividerLocation(250);
		split.setDividerSize(4);
		this.setBounds(20,20,420,320);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				if(st==null)
				{
					System.exit(0);
					return;
				}
				try
				{
					Vector v=onLineUsers;
					int size=v.size();
					for(int i=0;i<size;i++)
					{
						ServerAgentThread sat=(ServerAgentThread)v.get(i);
						sat.DOS.writeUTF("<#SERVER_DOWN#>");
						sat.DIS.close();
						sat.DOS.close();
						sat.s.close();
						sat.s=null;
						sat.flag=false;
						sat=null;
					}
					st.flag=false;
					st=null;
					ss.close();
					ss=null;
					v.clear();
					refreshList();
				}catch(Exception ee)
				{
					ee.printStackTrace();
				}
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==start)
		{
			System.out.println("服务器启动");
			this.start_event();
		}
		if(e.getSource()==stop)
		{
			System.out.println("服务器关闭");
			this.stop_event();
		}
	}

	public void start_event()
	{
		int port=-1;
		try
		{
			port=Integer.parseInt(this.textfield.getText().trim());
		}catch(Exception ee)
		{
			JOptionPane.showMessageDialog(this,"端口号只能是整数","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(port<0||port>65535)
		{
			JOptionPane.showMessageDialog(this,"端口号只能在0-65535之间的整数","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		try
		{
			ss=new ServerSocket(port);
			st=new ServerThread(this);
			st.start();
			JOptionPane.showMessageDialog(this,"服务器启动成功","提示",JOptionPane.INFORMATION_MESSAGE);
			this.start.setEnabled(false);
			this.textfield.setEnabled(false);
			this.stop.setEnabled(true);
		}catch(Exception ee)
		{
			JOptionPane.showMessageDialog(this,"服务器启动失败","错误",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void stop_event()
	{
		try
		{
			Vector v=onLineUsers;
			int size=v.size();
			for(int i=0;i<size;i++)
			{
				ServerAgentThread sat=(ServerAgentThread)v.get(i);
				sat.DOS.writeUTF("<#SERVER_DOWN#>");
				sat.DIS.close();
				sat.DOS.close();
				sat.s.close();
				sat.s=null;
				sat.flag=false;
				sat=null;
			}
			st.flag=false;
			st=null;
			ss.close();
			ss=null;
			v.clear();
			this.refreshList();
			this.textfield.setEnabled(true);
			this.start.setEnabled(true);
			this.stop.setEnabled(false);
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

	public void refreshList()
	{
		Vector v=new Vector();
		int size=this.onLineUsers.size();
		for(int i=0;i<size;i++)
		{
			ServerAgentThread sat=(ServerAgentThread)this.onLineUsers.get(i);
			String temp=sat.s.getInetAddress().toString();
			temp=temp+"|"+sat.getName();
			v.add(temp);
		}
		this.List.setListData(v);
	}
}
