package Interface;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Tool.*;
import Common.*;
import Model.*;

public class Login extends JFrame implements ActionListener
{
	JLabel label;
	JTabbedPane TP;
	JPanel panel1,panel2,panel3,panel4;
	JLabel label21,label22,label23,label24;
	JButton button11,button12,button13,button21;
	JCheckBox check21,check22 ;
	JTextField textfield;
	JPasswordField password;
	
	public static void main(String[] args)
	{
		new Login();
	}
	
	public Login()
	{
		label=new JLabel(new ImageIcon("Image/tou.gif"));
		panel2=new JPanel(new GridLayout(3,3));
		label21=new JLabel("QQ号码",JLabel.CENTER);
		label22=new JLabel("QQ密码",JLabel.CENTER);
		label23=new JLabel("忘记密码",JLabel.CENTER);
		label23.setForeground(Color.BLUE);
		label24=new JLabel("申请密码保护",JLabel.CENTER);
		button21=new JButton(new ImageIcon("Image/clear.gif"));
		textfield=new JTextField();
		password=new JPasswordField();
		check21=new JCheckBox("隐身登录");
		check22=new JCheckBox("记住密码");
		panel2.add(label21);
		panel2.add(textfield);
		panel2.add(button21);
		panel2.add(label22);
		panel2.add(password);
		panel2.add(label23);
		panel2.add(check21);
		panel2.add(check22);
		panel2.add(label24);
		
		panel3=new JPanel();
		panel3.setBackground(Color.RED);
		panel4=new JPanel();
		panel4.setBackground(Color.GREEN);
		TP=new JTabbedPane();
		TP.add("QQ号码",panel2);
		TP.add("手机号码",panel3);
		TP.add("电子邮件",panel4);
		
		panel1=new JPanel();
		button11=new JButton(new ImageIcon("Image/denglu.gif"));
		button11.addActionListener(this);
		button12=new JButton(new ImageIcon("Image/quxiao.gif"));
		button13=new JButton(new ImageIcon("Image/xiangdao.gif"));
		panel1.add(button11);
		panel1.add(button12);
		panel1.add(button13);
		
		this.add(label,"North");
		this.add(TP,"Center");
		this.add(panel1,"South");
		this.setIconImage(new ImageIcon("Image/qq.gif").getImage());
		this.setTitle("用户登录");
		this.setSize(351,240);
		this.setLocation(300,280);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button11)
		{
			Confirm conf=new Confirm();
			User u=new User();
			u.setUserId(textfield.getText().trim());
			u.setPasswd(new String(password.getPassword()));
			if(conf.checkUser(u))
			{
				try
				{
					ListF list=new ListF(u.getUserId());
					FriendList.addList(u.getUserId(),list);
					ObjectOutputStream OOS=new ObjectOutputStream(ThreadM.getSTLink(u.getUserId()).getS().getOutputStream());
					Message m=new Message();
					m.setMesType(MessageType.message_get_onLineFriend);
					m.setSender(u.getUserId());
					OOS.writeObject(m);
				}catch(Exception ee){}
				this.dispose();
			}else
			{
				JOptionPane.showMessageDialog(this,"用户名或密码错误");
			}
		}
	}
}
