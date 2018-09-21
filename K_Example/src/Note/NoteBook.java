package Note;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.*;

public class NoteBook extends JFrame implements ActionListener
{
	private static final long serialVersionUID =1L;
	//The serialVersionUID is a universal version identifier for a Serializable class. 
	//Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized object. 
	//If no match is found, then an InvalidClassException is thrown.
	
	//主窗口组件
	JTextArea myarea;
	JScrollPane scrollpane;

	JPopupMenu mypopmenu;
	JMenuItem selectall_pop,copy_pop,cut_pop,paste_pop,delete_pop,exit_pop;

	JToolBar toolbar;
	JButton newbutton,openbutton,savebutton;

	JMenu file,edit,format,view,help;
	JMenuItem new_file,open,save,save_as,exit;
	JMenuItem search,copy,cut,paste,delete,selectall;
	JMenuItem auto,font;
	JMenuItem status;
	JMenuItem about;

	//相关变量
	int start;							//查找开始位置
	int end;							//查找结束位置
	String filename;					//打开的文件名
	int a=0;							//自动换行
	int b=0;							//状态栏
	JLabel statuslabel=new JLabel();
	boolean flagDocument=false;			//文档变化
	
	//字体窗口组件
	JLabel lbfont,lbsize,lbshape;
	JPanel jpfont1,jpfont2,jpfont3,jpfont4,jpfont5;
	JDialog fontdlg;
	JButton okbutton,cancelbutton1,colorbutton;
	List fontlist,shapelist,sizelist;
	String fontname;
	int style;
	int size;
	boolean flagColor=false;			//颜色
	Color color;
	
	//查找和替换窗口组件
	JDialog searchdlg;
	JPanel panel1,panel2;
	JLabel label1,label2;
	JTextField textfield1,textfield2;
	JButton searchbutton,replacebutton,replaceallbutton,cancelbutton2;
	String s;
	
	//关于窗口组件
	JDialog aboutdlg;
	JLabel aboutlabel;
	JButton aboutbutton;

	public static void main(String[] args)
	{
		new NoteBook();
	}

	public NoteBook()
	{
		JMenuBar mb=new JMenuBar();

		//弹出菜单
		mypopmenu=new JPopupMenu();
		selectall_pop=new JMenuItem("全选");
		copy_pop=new JMenuItem("复制");
		cut_pop=new JMenuItem("剪切");
		paste_pop=new JMenuItem("粘贴");
		delete_pop=new JMenuItem("删除");
		exit_pop=new JMenuItem("退出");

		mypopmenu.add(selectall_pop);
		mypopmenu.add(cut_pop);
		mypopmenu.add(copy_pop);
		mypopmenu.add(paste_pop);
		mypopmenu.add(delete_pop);
		mypopmenu.add(exit_pop);

		selectall_pop.addActionListener(this);
		cut_pop.addActionListener(this);
		copy_pop.addActionListener(this);
		paste_pop.addActionListener(this);
		delete_pop.addActionListener(this);
		exit_pop.addActionListener(this);
		
		//给文本区域添加滚动条
		myarea=new JTextArea();
		myarea.add(mypopmenu);
		scrollpane=new JScrollPane(myarea);
		
		//工具栏
		toolbar=new JToolBar();
		newbutton=new JButton(new ImageIcon("Image/New.gif"));
		newbutton.setToolTipText("新建");
		newbutton.setActionCommand("新建");
		newbutton.addActionListener(this);

		openbutton=new JButton(new ImageIcon("Image/Open.gif"));
		openbutton.setToolTipText("打开");
		openbutton.setActionCommand("打开");
		openbutton.addActionListener(this);

		savebutton=new JButton(new ImageIcon("Image/Save.gif"));
		savebutton.setToolTipText("保存");
		savebutton.setActionCommand("保存");
		savebutton.addActionListener(this);

		toolbar.add(newbutton);
		toolbar.add(openbutton);
		toolbar.add(savebutton);
		this.add(toolbar,BorderLayout.NORTH);

		//文件菜单
		file=new JMenu("文件");

		new_file=new JMenuItem("新建");
		new_file.setMnemonic('N');
		open=new JMenuItem("打开");
		open.setMnemonic('O');
		save=new JMenuItem("保存");
		save.setMnemonic('S');
		save_as=new JMenuItem("另存为");
		exit=new JMenuItem("退出");
		exit.setMnemonic('E');

		new_file.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		save_as.addActionListener(this);
		exit.addActionListener(this);

		file.add(new_file);
		file.add(open);
		file.add(save);
		file.add(save_as);
		file.addSeparator();
		file.add(exit);

		//编辑菜单
		edit=new JMenu("编辑");

		search=new JMenuItem("查找和替换");
		copy=new JMenuItem("复制");
		copy.setMnemonic('C');
		cut=new JMenuItem("剪切");
		cut.setMnemonic('X');
		paste=new JMenuItem("粘贴");
		paste.setMnemonic('V');
		delete=new JMenuItem("删除");
		delete.setMnemonic('D');
		selectall=new JMenuItem("全选");
		selectall.setMnemonic('A');

		search.addActionListener(this);
		copy.addActionListener(this);
		cut.addActionListener(this);
		paste.addActionListener(this);
		delete.addActionListener(this);
		selectall.addActionListener(this);

		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		edit.add(delete);
		edit.add(search);
		edit.add(selectall);

		//格式菜单
		format=new JMenu("格式");

		auto=new JMenuItem("自动换行");
		auto.addActionListener(this);
		font=new JMenuItem("字体");
		font.addActionListener(this);

		format.add(auto);
		format.add(font);

		//查看菜单
		view=new JMenu("查看");		
		status=new JMenuItem("状态栏");
		status.addActionListener(this);
		view.add(status);

		//帮助菜单
		help=new JMenu("帮助");
		about=new JMenuItem("关于记事本");
		about.addActionListener(this);
		help.add(about);

		//菜单栏
		mb.add(file);
		mb.add(edit);
		mb.add(format);
		mb.add(view);
		mb.add(help);
		this.setJMenuBar(mb);

		//主窗口
		this.add(scrollpane);
		this.setTitle("记事本");
		this.setIconImage(new ImageIcon("Image/NoteBook.jpg").getImage());
		this.setSize(600,400);
		this.setLocationRelativeTo(null);			//使窗口显示在屏幕中间
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
		//字体窗口
		lbfont=new JLabel("字体");
		lbsize=new JLabel("大小");
		lbshape=new JLabel("字形");
		jpfont1=new JPanel();
		jpfont2=new JPanel();
		jpfont3=new JPanel();
		jpfont4=new JPanel();
		jpfont5=new JPanel();
		fontdlg=new JDialog(this,"字体，颜色，调色板",true);
		okbutton=new JButton("确定");
		okbutton.setActionCommand("字体确定");
		cancelbutton1=new JButton("取消");
		cancelbutton1.setActionCommand("字体取消");
		colorbutton=new JButton("颜色");
		okbutton.addActionListener(this);
		cancelbutton1.addActionListener(this);
		colorbutton.addActionListener(this);

		fontlist=new List(10,false);
		shapelist=new List(10,false);
		sizelist=new List(10,false);

		String[] fontnames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(int i=0;i<fontnames.length;i++){
			fontlist.add(fontnames[i]);
		}

		shapelist.add("常规");
		shapelist.add("粗体");
		shapelist.add("斜体");
		shapelist.add("粗斜体");

		String[] sizes={"1","2","3","4","5","6","7","8","9","10"};
		for(int i=0;i<sizes.length;i++){
			sizelist.add(sizes[i]);
		}
		
		fontlist.select(0);
		sizelist.select(4);
		shapelist.select(0);

		//设置字体对话框
		jpfont1.add(lbfont);
		jpfont1.add(fontlist);
		jpfont2.add(lbsize);
		jpfont2.add(sizelist);
		jpfont3.add(lbshape);
		jpfont3.add(shapelist);
		jpfont4.setLayout(new GridLayout(1,3));
		jpfont4.add(jpfont1);
		jpfont4.add(jpfont2);
		jpfont4.add(jpfont3);
		//FlowLayout(int align, int hgap, int vgap) 
		//创建一个新的流布局管理器，它具有指定的对齐方式以及指定的水平和垂直间隙。
		jpfont5.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		jpfont5.add(okbutton);
		jpfont5.add(cancelbutton1);
		jpfont5.add(colorbutton);

		fontdlg.add(jpfont4);
		fontdlg.add(jpfont5,BorderLayout.SOUTH);
		fontdlg.setSize(900,300);
		fontdlg.setLocationRelativeTo(null);
		fontdlg.setVisible(false);
		
		
		
		//查找和替换窗口
		searchdlg=new JDialog(this,"查找和替换",true);
		label1=new JLabel("		查找的内容	");
		label2=new JLabel("		替换的内容	");
		textfield1=new JTextField(15);
		textfield2=new JTextField(15);
		searchbutton=new JButton("查找");
		searchbutton.setActionCommand("查找");
		searchbutton.addActionListener(this);
		replacebutton=new JButton("替换");
		replacebutton.addActionListener(this);
		replaceallbutton=new JButton("全部替换");
		replaceallbutton.addActionListener(this);
		cancelbutton2=new JButton("取消");
		cancelbutton2.addActionListener(this);
		cancelbutton2.setActionCommand("查找取消");
		panel1=new JPanel(new GridLayout(2,2,10,10));
		panel2=new JPanel(new GridLayout(1,4,10,0));
		panel1.add(label1);
		panel1.add(textfield1);
		panel1.add(label2);
		panel1.add(textfield2);
		panel2.add(searchbutton);
		panel2.add(replacebutton);
		panel2.add(replaceallbutton);
		panel2.add(cancelbutton2);
		searchdlg.setLayout(new FlowLayout());
		searchdlg.add(panel1);
		searchdlg.add(panel2);
		searchdlg.setSize(500,150);
		searchdlg.setLocationRelativeTo(null);
		searchdlg.setVisible(false);
		
		
		
		//关于窗口
		aboutdlg=new JDialog(this,"关于记事本",true);
		aboutlabel=new JLabel("Star 2016",JLabel.CENTER);
		aboutbutton=new JButton("确定");
		aboutbutton.setActionCommand("关于确定");
		aboutbutton.addActionListener(this);
		aboutdlg.setLayout(new GridLayout(2,1,0,10));
		aboutdlg.add(aboutlabel);
		aboutdlg.add(aboutbutton);
		aboutdlg.setLocationRelativeTo(null);
		aboutdlg.setSize(100,200);
		aboutdlg.setVisible(false);
		
		

		//文件改变事件
		myarea.getDocument().addDocumentListener(new DocumentListener()
		{
			public void changedUpdate(DocumentEvent e)
			{
				flagDocument=true;
			}
			
			public void insertUpdate(DocumentEvent e)
			{
				flagDocument=true;
			}
			
			public void removeUpdate(DocumentEvent e)
			{
				flagDocument=true;
			}
		});


		//窗口监听
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				if(flagDocument==true)
				{
					int result=JOptionPane.showConfirmDialog(null,"文件内容已改变，确认保存吗？","警告",JOptionPane.YES_NO_CANCEL_OPTION );
					if(result==JOptionPane.YES_OPTION)
					{
						save();
					}
					if(result==JOptionPane.NO_OPTION)
					{
						System.exit(0);
					}
				}
			}
		});

		//鼠标监听
		myarea.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				int mods=e.getModifiers();		//鼠标右键
				if((mods&InputEvent.BUTTON3_MASK)!=0)
				{
					mypopmenu.show(e.getComponent(),e.getX(),e.getY());		//弹出菜单
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("新建"))
		{
			if(flagDocument==true)
			{
				int result=JOptionPane.showConfirmDialog(null,"文件内容已改变，确认保存吗？","警告",JOptionPane.YES_NO_CANCEL_OPTION );
				if(result==JOptionPane.OK_OPTION)
				{
					this.save();
					myarea.setText("");
					flagDocument=false;
				}
				if(result==JOptionPane.NO_OPTION)
				{
					myarea.setText("");
					flagDocument=false;
				}
			}else
			{
				myarea.setText("");
				flagDocument=false;
			}
		}

		if(e.getActionCommand().equals("打开"))
		{
			if(flagDocument==true)
			{
				int result=JOptionPane.showConfirmDialog(null,"文件内容已改变，确认保存吗？","警告",JOptionPane.YES_NO_CANCEL_OPTION );
				if(result==JOptionPane.OK_OPTION)
				{
					this.save();
					this.open();
					flagDocument=false;
				}
				if(result==JOptionPane.NO_OPTION)
				{
					this.open();
					flagDocument=false;
				}
			}else
			{
				this.open();
				flagDocument=false;
			}
		}

		if(e.getActionCommand().equals("保存"))
		{
			this.save();
			flagDocument=false;
		}

		if(e.getActionCommand().equals("另存为"))
		{
			this.save_as();
			flagDocument=false;
		}

		if(e.getActionCommand().equals("退出"))
		{
			if(flagDocument==true)
			{
				int result=JOptionPane.showConfirmDialog(null,"文件内容已改变，确认保存吗？","警告",JOptionPane.YES_NO_CANCEL_OPTION );
				if(result==JOptionPane.OK_OPTION)
				{
					this.save();
				}
				if(result==JOptionPane.NO_OPTION)
				{
					System.exit(0);
				}
			}else
			{
				System.exit(0);
			}
		}

		if(e.getActionCommand().equals("查找和替换"))
		{
			searchdlg.setVisible(true);
			s=textfield1.getText();
			start=0;
			end=0;
		}
		if((e.getActionCommand().equals("查找"))||(e.getActionCommand().equals("查找下一个")))
		{
			String findtext=textfield1.getText();
			if(s!=findtext)
			{
				searchbutton.setText("查找");
				s=textfield1.getText();
			}
			String textarea=myarea.getText();
			start=textarea.indexOf(findtext,end);
			end=start+findtext.length();
			if(start==-1)
			{
				JOptionPane.showConfirmDialog(null,"没找到"+findtext,"记事本",JOptionPane.WARNING_MESSAGE);
			}else
			{
				myarea.select(start,end);
				searchbutton.setText("查找下一个");
			}
		}
		if(e.getActionCommand().equals("替换"))
		{
			String changetext=textfield2.getText();
			myarea.select(start,end);
			myarea.replaceSelection(changetext);
			end=start+changetext.length();
			myarea.select(start,end);
		}
		if(e.getActionCommand().equals("全部替换"))
		{
			String temp=myarea.getText();
			temp=temp.replaceAll(textfield1.getText(),textfield2.getText());
			myarea.setText(temp);
		}
		if(e.getActionCommand().equals("查找取消"))
		{
			searchdlg.setVisible(false);
			searchbutton.setText("查找");
		}

		if(e.getActionCommand().equals("全选"))
		{
			myarea.selectAll();
		}

		if(e.getActionCommand().equals("复制"))
		{
			myarea.copy();
		}

		if(e.getActionCommand().equals("粘贴"))
		{
			myarea.paste();
		}

		if(e.getActionCommand().equals("剪切"))
		{
			myarea.cut();
		}

		if(e.getActionCommand().equals("删除"))
		{
			myarea.replaceSelection("");
		}

		if(e.getActionCommand().equals("自动换行"))
		{
			if(a==1)
			{
				myarea.setLineWrap(false);
				a=0;
			}else
			{
				myarea.setLineWrap(true);
				a=1;
			}
		}

		if(e.getActionCommand().equals("字体"))
		{
			fontdlg.setVisible(true);
		}
		if(e.getActionCommand().equals("字体确定"))
		{
			if(flagColor==true)
			{
				myarea.setForeground(color);
				flagColor=false;
			}			
			if(shapelist.getSelectedItem().equals("常规")==true)
			{
				style=Font.PLAIN ;
			}
			if(shapelist.getSelectedItem().equals("斜体")==true)
			{
				style=Font.ITALIC;
			}
			if(shapelist.getSelectedItem().equals("粗体")==true)
			{
				style=Font.BOLD;
			}
			if(shapelist.getSelectedItem().equals("粗斜体")==true){
				style=Font.BOLD+Font.ITALIC ;
			}
			fontname=fontlist.getSelectedItem();
			size=(10-(sizelist.getSelectedIndex()))*10;
			myarea.setFont(new Font(fontname,style,size));
			fontdlg.setVisible(false);
		}
		if(e.getActionCommand().equals("字体取消"))
		{
			fontdlg.setVisible(false);
		}
		if(e.getActionCommand().equals("颜色"))
		{
			JColorChooser jcolor=new JColorChooser();
			Color fcolor=myarea.getForeground();
			color=jcolor.showDialog(myarea,"选择字体的颜色",fcolor);
			flagColor=true;
		}

		if(e.getActionCommand().equals("状态栏"))
		{
			if(b==0)
			{
				statuslabel.setText("当前字数："+myarea.getText().trim().length()+"\t"+"当前列数："+myarea.getLineCount());
				statuslabel.setVisible(true);
				this.add(statuslabel,BorderLayout.SOUTH);
				b=1;
			}else
			{
				statuslabel.setVisible(false);
				b=0;
			}
		}

		if(e.getActionCommand().equals("关于记事本"))
		{
			aboutdlg.setVisible(true);
		}
		
		if(e.getActionCommand().equals("关于确定"))
		{
			aboutdlg.setVisible(false);
		}
	}


//	函数部分
	public void open()
	{
		try{
			FileDialog filedialog=new FileDialog(NoteBook.this,"打开文件",FileDialog.LOAD);
			filedialog.setFile("*.txt");
			filedialog.setVisible(true);
			if(filedialog.getFile()!=null)
			{
				filename=filedialog.getDirectory()+filedialog.getFile();	//获取文件名
				FileReader filereader=new FileReader(filename);		//此处必须要捕获异常
				BufferedReader bufferedreader=new BufferedReader(filereader);
				String S="";
				while(bufferedreader.ready())
				{		//判断缓冲区是否为空，非空时返回true
					int s=bufferedreader.read();
					S+=(char)s;
				}
				myarea.setText(S);
				filereader.close();
				this.setTitle("记事本——"+filename);
			}
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	
	public void save()
	{
		try
		{
			if(filename==null)
			{
				save_as();
			}else
			{
				File file=new File(filename);
				FileWriter filewriter=new FileWriter(file);
				BufferedWriter bufferedwriter=new BufferedWriter(filewriter);
				PrintWriter printwriter=new PrintWriter(bufferedwriter);
				printwriter.print(myarea.getText());
				printwriter.close();
				printwriter.close();
				bufferedwriter.close();
				filewriter.close();
				this.setTitle("记事本——"+filename);
			}
		}catch(Exception ee)
		{
			ee.printStackTrace();
//			e.printStackTrace()是打印整个Exception轨迹栈，而System.out.print(e)只是打印了e.toString()方法返回的结果。 
		}
	}

	public void save_as()
	{
		try
		{
			FileDialog filedialog=new FileDialog(NoteBook.this,"另存为",FileDialog.SAVE);
			filedialog.setFile("*.txt");
			filedialog.setVisible(true);
			if(filedialog.getFile()!=null)
			{
				filename=filedialog.getDirectory()+filedialog.getFile();
				FileWriter filewriter=new FileWriter(filename);
				BufferedWriter bufferedwriter=new BufferedWriter(filewriter);
				PrintWriter printwriter=new PrintWriter(bufferedwriter);
				printwriter.print(myarea.getText());
				printwriter.flush();
				printwriter.close();
				bufferedwriter.close();
				filewriter.close();
				this.setTitle("记事本——"+filename);
			}
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
}
