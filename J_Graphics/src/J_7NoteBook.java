import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class J_7NoteBook extends JFrame implements ActionListener
{
	JMenuBar M;
	JMenu M1,M2;
	JMenuItem MI11,MI12;
	JTextArea TA;
	JScrollPane SP;
	
	public static void main(String[] args)
	{
		new J_7NoteBook();
	}
	
	public J_7NoteBook()
	{
		M=new JMenuBar();
		M1=new JMenu("文件(F)");	
		M1.setMnemonic('F');
		M2=new JMenu("编辑(E)");
		M2.setMnemonic('E');
		MI11=new JMenuItem("打开(O)",new ImageIcon("Image/Open.gif"));
		MI11.addActionListener(this);
		MI11.setActionCommand("Open");
		MI11.setMnemonic('O');
		MI12=new JMenuItem("保存(S)",new ImageIcon("Image/Save.gif"));
		MI12.addActionListener(this);
		MI12.setActionCommand("Save");
		MI12.setMnemonic('S');
		TA=new JTextArea();
		SP=new JScrollPane(TA);

		M1.add(MI11);
		M1.add(MI12);
		M.add(M1);
		M.add(M2);
		this.setJMenuBar(M);
		this.add(SP);

		this.setIconImage(new ImageIcon("Image/NoteBook.jpg").getImage());
		this.setTitle("记事本");
		this.setSize(400, 300);
		this.setLocation(300, 280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Open"))
		{
			System.out.println("Open");
			JFileChooser file=new JFileChooser();
			file.setDialogTitle("文件打开");
			file.showOpenDialog(null);
			file.setVisible(true);
			String path=file.getSelectedFile().getAbsolutePath();
			System.out.println(path);
			FileReader FR=null;
			BufferedReader BR=null;
			try{
				FR=new FileReader(path);
				BR=new BufferedReader(FR);
				String s="",S="";
				while((s=BR.readLine())!=null){
					S+=(s+"\n");
				}
				TA.setText(S);
			}catch(Exception a){}
			finally{
				try{
					FR.close();
					BR.close();
				}catch(Exception b){}
			}
		}
		
		if(e.getActionCommand().equals("Save")){
			System.out.println("Save");
			JFileChooser file2=new JFileChooser();
			file2.setDialogTitle("另存为");
			file2.showSaveDialog(null);
			file2.setVisible(true);
			String spath=file2.getSelectedFile().getAbsolutePath();
			System.out.println(spath);
			PrintStream PS=null;
			try{
				PS=new PrintStream(spath);
				System.setOut(PS);
				System.out.println(this.TA.getText());
			}catch(Exception c){}
			finally{
				try{
					PS.close();
				}catch(Exception d){}
			}
		}
	}

}
