import java.util.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class Chess extends JFrame implements ActionListener
{
	public static final Color bgColor=new Color(245,250,160);
	public static final Color bgFocus=new Color(242,242,242);
	public static final Color focuschar=new Color(96,95,91);
	public static final Color color1=new Color(255,0,0);
	public static final Color color2=new Color(0,255,0);
	JLabel Host=new JLabel("������");
	JLabel Port=new JLabel("�˿ں�");
	JLabel NickName=new JLabel("��  ��");
	JTextField host=new JTextField("127.0.0.1");
	JTextField port=new JTextField("9999");
	JTextField nickname=new JTextField("Player1");
	JButton ConnectB=new JButton("����");
	JButton DisconnectB=new JButton("�Ͽ�");
	JButton ChallengeB=new JButton("��ս");
	JButton AcceptB=new JButton("������ս");
	JButton RefuseB=new JButton("�ܾ���ս");
	JButton SurrenderB=new JButton("����");
	JLabel tip=new JLabel("�й�����",JLabel.CENTER);
	JLabel prompt=new JLabel("");
	JComboBox NickList=new JComboBox();
	int width=60;
	ChessMan[][] ChessMen=new ChessMan[9][10];
	Board panel1=new Board(ChessMen,width,this);
	JPanel panel2=new JPanel();
	JSplitPane JSP=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel1,panel2);
	boolean kaiPan=false;
	int color=0;
	Socket s;
	ClientAgentThread cat;

	public static void main(String[] args)
	{
		new Chess();
	}

	public Chess()
	{
		this.initialComponent();
		this.addListener();
		this.initialState();
		this.initialChessMen();
		this.initialFrame();
	}

	public void initialComponent()
	{
		panel2.setLayout(null);
		this.Host.setBounds(10,10,50,20);
		panel2.add(Host);
		this.host.setBounds(70,10,80,20);
		panel2.add(host);
		this.Port.setBounds(10,40,50,20);
		panel2.add(Port);
		this.port.setBounds(70,40,80,20);
		panel2.add(port);
		this.NickName.setBounds(10,70,50,20);
		panel2.add(NickName);
		this.nickname.setBounds(70,70,80,20);
		panel2.add(nickname);
		this.tip.setBounds(20,220,130,20);
		panel2.add(tip);
		this.prompt.setBounds(20,250,130,20);
		panel2.add(prompt);

		this.ConnectB.setBounds(10,100,80,20);
		panel2.add(ConnectB);
		this.DisconnectB.setBounds(100,100,80,20);
		panel2.add(DisconnectB);
		this.NickList.setBounds(20,130,130,20);
		panel2.add(NickList);
		this.ChallengeB.setBounds(10,160,80,20);
		panel2.add(ChallengeB);
		this.SurrenderB.setBounds(100,160,80,20);
		panel2.add(SurrenderB);
		this.AcceptB.setBounds(5,190,86,20);
		panel2.add(AcceptB);
		this.RefuseB.setBounds(100,190,86,20);
		panel2.add(RefuseB);

		panel1.setBounds(0,0,700,700);

	}

	public void addListener()
	{
		this.ConnectB.addActionListener(this);
		this.DisconnectB.addActionListener(this);
		this.ChallengeB.addActionListener(this);
		this.AcceptB.addActionListener(this);
		this.RefuseB.addActionListener(this);
		this.SurrenderB.addActionListener(this);
	}

	public void initialState()
	{
		this.DisconnectB.setEnabled(false);
		this.ChallengeB.setEnabled(false);
		this.AcceptB.setEnabled(false);
		this.RefuseB.setEnabled(false);
		this.SurrenderB.setEnabled(false);
		this.prompt.setVisible(false);
	}

	public void initialChessMen()
	{
		this.ChessMen[0][0]=new ChessMan(color1,"܇",0,0);
		this.ChessMen[1][0]=new ChessMan(color1,"�R",1,0);
		this.ChessMen[2][0]=new ChessMan(color1,"��",2,0);
		this.ChessMen[3][0]=new ChessMan(color1,"��",3,0);
		this.ChessMen[4][0]=new ChessMan(color1,"��",4,0);
		this.ChessMen[5][0]=new ChessMan(color1,"��",5,0);
		this.ChessMen[6][0]=new ChessMan(color1,"��",6,0);
		this.ChessMen[7][0]=new ChessMan(color1,"�R",7,0);
		this.ChessMen[8][0]=new ChessMan(color1,"܇",8,0);
		this.ChessMen[1][2]=new ChessMan(color1,"�h",1,2);
		this.ChessMen[7][2]=new ChessMan(color1,"�h",7,2);
		this.ChessMen[0][3]=new ChessMan(color1,"��",0,3);
		this.ChessMen[2][3]=new ChessMan(color1,"��",2,3);
		this.ChessMen[4][3]=new ChessMan(color1,"��",4,3);
		this.ChessMen[6][3]=new ChessMan(color1,"��",6,3);
		this.ChessMen[8][3]=new ChessMan(color1,"��",8,3);

		this.ChessMen[0][9]=new ChessMan(color2,"܇",0,9);
		this.ChessMen[1][9]=new ChessMan(color2,"�R",1,9);
		this.ChessMen[2][9]=new ChessMan(color2,"��",2,9);
		this.ChessMen[3][9]=new ChessMan(color2,"ʿ",3,9);
		this.ChessMen[4][9]=new ChessMan(color2,"��",4,9);
		this.ChessMen[5][9]=new ChessMan(color2,"ʿ",5,9);
		this.ChessMen[6][9]=new ChessMan(color2,"��",6,9);
		this.ChessMen[7][9]=new ChessMan(color2,"�R",7,9);
		this.ChessMen[8][9]=new ChessMan(color2,"܇",8,9);
		this.ChessMen[1][7]=new ChessMan(color2,"��",1,7);
		this.ChessMen[7][7]=new ChessMan(color2,"��",7,7);
		this.ChessMen[0][6]=new ChessMan(color2,"��",0,6);
		this.ChessMen[2][6]=new ChessMan(color2,"��",2,6);
		this.ChessMen[4][6]=new ChessMan(color2,"��",4,6);
		this.ChessMen[6][6]=new ChessMan(color2,"��",6,6);
		this.ChessMen[8][6]=new ChessMan(color2,"��",8,6);
	}

	public void initialFrame()
	{
		this.setIconImage(new ImageIcon("Image/Marshal.jpg").getImage());
		this.setTitle("�й����塪���ͻ���");
		this.add(JSP);
		JSP.setDividerLocation(730);
		JSP.setDividerSize(4);
		this.setBounds(30,30,930,730);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				if(cat==null)
				{
					System.exit(0);
					return;
				}
				try
				{
					if(cat.challenger!=null)
					{
						try
						{
							cat.DOS.writeUTF("<#SURRENDER#>"+cat.challenger);
						}catch(Exception ee)
						{
							ee.printStackTrace();
						}
					}
					cat.DOS.writeUTF("<#CLIENT_LEAVE#>");
					cat.DIS.close();
					cat.DOS.close();
					cat.flag=false;
					cat=null;
					s.close();
					s=null;
				}catch(Exception ee)
				{
					System.exit(0);
				} 
			}
		});
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==this.ConnectB)
		{
			this.Connect();
		}
		if(e.getSource()==this.DisconnectB)
		{
			this.DisConnect();
		}
		if(e.getSource()==this.ChallengeB)
		{
			this.Challenge();
		}
		if(e.getSource()==this.AcceptB)
		{
			this.Accept();
		}
		if(e.getSource()==this.RefuseB)
		{
			this.Refuse();
		}
		if(e.getSource()==this.SurrenderB)
		{
			this.Surrender();
		}
	}

	public void Connect()
	{
		int portnum=0;
		try{
			portnum=Integer.parseInt(this.port.getText().trim());
		}catch(Exception ee)
		{
			JOptionPane.showMessageDialog(this,"�˿ں�ֻ��������","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(portnum>65535||portnum<0)
		{
			JOptionPane.showMessageDialog(this,"�˿ں�ֻ����0-65535֮�������","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		String name=this.nickname.getText().trim();
		if(name.length()==0)
		{
			JOptionPane.showMessageDialog(this,"�ǳƲ���Ϊ��","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		try{
			s=new Socket(this.host.getText().trim(),portnum);
			cat=new ClientAgentThread(this);		
			cat.start();
		}catch(Exception ee)
		{
			JOptionPane.showMessageDialog(this,"����������ʧ��","����",JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	public void DisConnect()
	{
		try{
			this.cat.DOS.writeUTF("<#CLIENT_LEAVE#>");
			this.cat.DIS.close();
			this.cat.DOS.close();
			this.cat.flag=false;
			this.cat=null;		
			this.s.close();
			this.s=null;
			this.host.setEnabled(true);
			this.port.setEnabled(true);
			this.nickname.setEnabled(true);
			this.ConnectB.setEnabled(true);
			this.DisconnectB.setEnabled(false);
			this.ChallengeB.setEnabled(false);
			this.AcceptB.setEnabled(false);
			this.RefuseB.setEnabled(false);
			this.SurrenderB.setEnabled(false);
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

	public void Challenge()
	{
		Object o=this.NickList.getSelectedItem();
		if(o==null||((String)o).equals(""))
		{
			JOptionPane.showMessageDialog(this,"��ѡ��Է�����","����",JOptionPane.ERROR_MESSAGE);
		}else
		{
			String name2=(String)this.NickList.getSelectedItem();
			try
			{
				this.host.setEnabled(false);
				this.port.setEnabled(false);
				this.nickname.setEnabled(false);
				this.ConnectB.setEnabled(false);
				this.DisconnectB.setEnabled(false);
				this.ChallengeB.setEnabled(false);
				this.AcceptB.setEnabled(false);
				this.RefuseB.setEnabled(false);
				this.SurrenderB.setEnabled(false);
				this.cat.challenger=name2;
				this.cat.DOS.writeUTF("<#CHALLENGE#>"+name2);
				JOptionPane.showMessageDialog(this,"�������ս����ȴ��ظ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			}catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
	}

	public void Accept()
	{
		try
		{
			this.cat.DOS.writeUTF("<#ACCEPT#>"+this.cat.challenger);
			this.color=1;
			this.host.setEnabled(false);
			this.port.setEnabled(false);
			this.nickname.setEnabled(false);
			this.ConnectB.setEnabled(false);
			this.DisconnectB.setEnabled(false);
			this.ChallengeB.setEnabled(false);
			this.AcceptB.setEnabled(false);
			this.RefuseB.setEnabled(false);
			this.SurrenderB.setEnabled(true);
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

	public void Refuse()
	{
		try
		{
			this.cat.DOS.writeUTF("<#REFUSE#>"+this.cat.challenger);
			this.cat.challenger=null;
			this.host.setEnabled(false);
			this.port.setEnabled(false);
			this.nickname.setEnabled(false);
			this.ConnectB.setEnabled(false);
			this.DisconnectB.setEnabled(true);
			this.ChallengeB.setEnabled(true);
			this.AcceptB.setEnabled(false);
			this.RefuseB.setEnabled(false);
			this.SurrenderB.setEnabled(false);
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

	public void Surrender()
	{
		try
		{
			this.cat.DOS.writeUTF("<#SURRENDER#>"+this.cat.challenger);
			this.next();
			this.host.setEnabled(false);
			this.port.setEnabled(false);
			this.nickname.setEnabled(false);
			this.ConnectB.setEnabled(false);
			this.DisconnectB.setEnabled(true);
			this.ChallengeB.setEnabled(true);
			this.AcceptB.setEnabled(false);
			this.RefuseB.setEnabled(false);
			this.SurrenderB.setEnabled(false);
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

	public void next()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<10;j++)
			{
				this.ChessMen[i][j]=null;
			}
		}
		this.cat.challenger=null;
		this.color=0;
		this.kaiPan=false;
		tip.setText("�й�����");
		prompt.setVisible(false);
		this.initialChessMen();
		this.repaint();
	}
	
}
