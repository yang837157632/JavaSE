package Basis;
import java.io.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;
public class N_3Client extends JFrame implements ActionListener{
	JTextArea jta;
	JButton jb;
	JTextField jtf;
	JPanel jp;
	JScrollPane jsp;
	PrintWriter PW;
	public static void main(String[] args){
		new N_3Client();
	}
	public N_3Client(){
		jta=new JTextArea();
		jb=new JButton("发送");
		jb.addActionListener(this);
		jtf=new JTextField(20);
		jsp=new JScrollPane(jta);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		this.add(jsp);
		this.add(jp,"South");
		
		this.setTitle("客户端");
		this.setSize(350,250);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		try{
			Socket s=new Socket("127.0.0.1",9997);
			InputStreamReader ISR=new InputStreamReader(s.getInputStream());
			BufferedReader BR=new BufferedReader(ISR);
			PW=new PrintWriter(s.getOutputStream(),true);
			while(true){
				String receive=BR.readLine();
				jta.append("服务器对我说："+receive+"\r\n");
			}
		}catch(Exception e){}
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jb){
			String send=jtf.getText();
			jta.append("我对服务器说："+send+"\r\n");
			PW.println(send);
			jtf.setText("");
		}
	}
}
