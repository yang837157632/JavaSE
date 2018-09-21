package Admin.Interface;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import Customize.*;
import Admin.Model.*;

public class Login extends JDialog implements ActionListener
{
	JLabel label1,label2,label3;
	JTextField textfield;
	JPasswordField passwordfield;
	JButton ok,cancel;
	
	public static void main(String[] args)
	{
		new Login();
	}
	
	public Login(){
		label1=new JLabel("用户名:");
		label1.setBounds(60,190,150,30);
		label1.setFont(MyFont.f1);
		this.add(label1);
		
		label2=new JLabel("或员工号");
		label2.setForeground(Color.red);
		label2.setFont(MyFont.f2);
		label2.setBounds(100,210,100,30);
		this.add(label2);
		
		label3=new JLabel("密码");
		label3.setBounds(60,240,150,30);
		label3.setFont(MyFont.f2);
		this.add(label3);
		
		textfield=new JTextField(20);
		textfield.setBounds(180,190,120,30);
		textfield.setFocusable(true);
		textfield.setFont(MyFont.f1);
		this.add(textfield);
		textfield.setBorder(BorderFactory.createLoweredBevelBorder());
		
		passwordfield=new JPasswordField();
		passwordfield.setBounds(180,240,120,30);
		passwordfield.setFocusable(true);
		this.add(passwordfield);
		passwordfield.setBorder(BorderFactory.createLoweredBevelBorder());
		
		ok=new JButton("确定");
		ok.addActionListener(this);
		ok.setBounds(105,300,75,30);
		ok.setFont(MyFont.f1);
		ok.setForeground(Color.blue);
		this.add(ok);
		
		cancel=new JButton("取消");
		cancel.addActionListener(this);
		cancel.setBounds(215,300,75,30);
		cancel.setFont(MyFont.f1);
		cancel.setForeground(Color.blue);
		this.add(cancel);
		
		this.setLayout(null);
		BackImage image=new BackImage();
		image.setBounds(0,0,360,360);
		this.add(image);
		this.setUndecorated(true);
		this.setSize(360,360);
		int width=getToolkit().getDefaultToolkit().getScreenSize().width;
		int height=getToolkit().getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200,height/2-200);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==ok)
		{
			String Id=this.textfield.getText().trim();
			String password=new String(this.passwordfield.getPassword());
			Model model=new Model();
			String Position=model.checkUser(Id, password);
			if((Position.equals("经理"))||(Position.equals("管理员"))||(Position.equals("主管")))
			{
				new Operate();
				this.dispose();
			}else
			{
				JOptionPane.showMessageDialog(this,"用户名或密码错误");
			}
		}
		if(e.getSource()==cancel)
		{
			this.dispose();
		}
	}
}

class BackImage extends JPanel
{
	Image image;
	
	public BackImage()
	{
		try
		{
			image=ImageIO.read(new File("Image/login.gif"));
		}catch(Exception e){}
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(image,0,0,360,360,this);
	}
}
