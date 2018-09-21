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
	
	//���������
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

	//��ر���
	int start;							//���ҿ�ʼλ��
	int end;							//���ҽ���λ��
	String filename;					//�򿪵��ļ���
	int a=0;							//�Զ�����
	int b=0;							//״̬��
	JLabel statuslabel=new JLabel();
	boolean flagDocument=false;			//�ĵ��仯
	
	//���崰�����
	JLabel lbfont,lbsize,lbshape;
	JPanel jpfont1,jpfont2,jpfont3,jpfont4,jpfont5;
	JDialog fontdlg;
	JButton okbutton,cancelbutton1,colorbutton;
	List fontlist,shapelist,sizelist;
	String fontname;
	int style;
	int size;
	boolean flagColor=false;			//��ɫ
	Color color;
	
	//���Һ��滻�������
	JDialog searchdlg;
	JPanel panel1,panel2;
	JLabel label1,label2;
	JTextField textfield1,textfield2;
	JButton searchbutton,replacebutton,replaceallbutton,cancelbutton2;
	String s;
	
	//���ڴ������
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

		//�����˵�
		mypopmenu=new JPopupMenu();
		selectall_pop=new JMenuItem("ȫѡ");
		copy_pop=new JMenuItem("����");
		cut_pop=new JMenuItem("����");
		paste_pop=new JMenuItem("ճ��");
		delete_pop=new JMenuItem("ɾ��");
		exit_pop=new JMenuItem("�˳�");

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
		
		//���ı�������ӹ�����
		myarea=new JTextArea();
		myarea.add(mypopmenu);
		scrollpane=new JScrollPane(myarea);
		
		//������
		toolbar=new JToolBar();
		newbutton=new JButton(new ImageIcon("Image/New.gif"));
		newbutton.setToolTipText("�½�");
		newbutton.setActionCommand("�½�");
		newbutton.addActionListener(this);

		openbutton=new JButton(new ImageIcon("Image/Open.gif"));
		openbutton.setToolTipText("��");
		openbutton.setActionCommand("��");
		openbutton.addActionListener(this);

		savebutton=new JButton(new ImageIcon("Image/Save.gif"));
		savebutton.setToolTipText("����");
		savebutton.setActionCommand("����");
		savebutton.addActionListener(this);

		toolbar.add(newbutton);
		toolbar.add(openbutton);
		toolbar.add(savebutton);
		this.add(toolbar,BorderLayout.NORTH);

		//�ļ��˵�
		file=new JMenu("�ļ�");

		new_file=new JMenuItem("�½�");
		new_file.setMnemonic('N');
		open=new JMenuItem("��");
		open.setMnemonic('O');
		save=new JMenuItem("����");
		save.setMnemonic('S');
		save_as=new JMenuItem("���Ϊ");
		exit=new JMenuItem("�˳�");
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

		//�༭�˵�
		edit=new JMenu("�༭");

		search=new JMenuItem("���Һ��滻");
		copy=new JMenuItem("����");
		copy.setMnemonic('C');
		cut=new JMenuItem("����");
		cut.setMnemonic('X');
		paste=new JMenuItem("ճ��");
		paste.setMnemonic('V');
		delete=new JMenuItem("ɾ��");
		delete.setMnemonic('D');
		selectall=new JMenuItem("ȫѡ");
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

		//��ʽ�˵�
		format=new JMenu("��ʽ");

		auto=new JMenuItem("�Զ�����");
		auto.addActionListener(this);
		font=new JMenuItem("����");
		font.addActionListener(this);

		format.add(auto);
		format.add(font);

		//�鿴�˵�
		view=new JMenu("�鿴");		
		status=new JMenuItem("״̬��");
		status.addActionListener(this);
		view.add(status);

		//�����˵�
		help=new JMenu("����");
		about=new JMenuItem("���ڼ��±�");
		about.addActionListener(this);
		help.add(about);

		//�˵���
		mb.add(file);
		mb.add(edit);
		mb.add(format);
		mb.add(view);
		mb.add(help);
		this.setJMenuBar(mb);

		//������
		this.add(scrollpane);
		this.setTitle("���±�");
		this.setIconImage(new ImageIcon("Image/NoteBook.jpg").getImage());
		this.setSize(600,400);
		this.setLocationRelativeTo(null);			//ʹ������ʾ����Ļ�м�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
		//���崰��
		lbfont=new JLabel("����");
		lbsize=new JLabel("��С");
		lbshape=new JLabel("����");
		jpfont1=new JPanel();
		jpfont2=new JPanel();
		jpfont3=new JPanel();
		jpfont4=new JPanel();
		jpfont5=new JPanel();
		fontdlg=new JDialog(this,"���壬��ɫ����ɫ��",true);
		okbutton=new JButton("ȷ��");
		okbutton.setActionCommand("����ȷ��");
		cancelbutton1=new JButton("ȡ��");
		cancelbutton1.setActionCommand("����ȡ��");
		colorbutton=new JButton("��ɫ");
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

		shapelist.add("����");
		shapelist.add("����");
		shapelist.add("б��");
		shapelist.add("��б��");

		String[] sizes={"1","2","3","4","5","6","7","8","9","10"};
		for(int i=0;i<sizes.length;i++){
			sizelist.add(sizes[i]);
		}
		
		fontlist.select(0);
		sizelist.select(4);
		shapelist.select(0);

		//��������Ի���
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
		//����һ���µ������ֹ�������������ָ���Ķ��뷽ʽ�Լ�ָ����ˮƽ�ʹ�ֱ��϶��
		jpfont5.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		jpfont5.add(okbutton);
		jpfont5.add(cancelbutton1);
		jpfont5.add(colorbutton);

		fontdlg.add(jpfont4);
		fontdlg.add(jpfont5,BorderLayout.SOUTH);
		fontdlg.setSize(900,300);
		fontdlg.setLocationRelativeTo(null);
		fontdlg.setVisible(false);
		
		
		
		//���Һ��滻����
		searchdlg=new JDialog(this,"���Һ��滻",true);
		label1=new JLabel("		���ҵ�����	");
		label2=new JLabel("		�滻������	");
		textfield1=new JTextField(15);
		textfield2=new JTextField(15);
		searchbutton=new JButton("����");
		searchbutton.setActionCommand("����");
		searchbutton.addActionListener(this);
		replacebutton=new JButton("�滻");
		replacebutton.addActionListener(this);
		replaceallbutton=new JButton("ȫ���滻");
		replaceallbutton.addActionListener(this);
		cancelbutton2=new JButton("ȡ��");
		cancelbutton2.addActionListener(this);
		cancelbutton2.setActionCommand("����ȡ��");
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
		
		
		
		//���ڴ���
		aboutdlg=new JDialog(this,"���ڼ��±�",true);
		aboutlabel=new JLabel("Star 2016",JLabel.CENTER);
		aboutbutton=new JButton("ȷ��");
		aboutbutton.setActionCommand("����ȷ��");
		aboutbutton.addActionListener(this);
		aboutdlg.setLayout(new GridLayout(2,1,0,10));
		aboutdlg.add(aboutlabel);
		aboutdlg.add(aboutbutton);
		aboutdlg.setLocationRelativeTo(null);
		aboutdlg.setSize(100,200);
		aboutdlg.setVisible(false);
		
		

		//�ļ��ı��¼�
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


		//���ڼ���
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				if(flagDocument==true)
				{
					int result=JOptionPane.showConfirmDialog(null,"�ļ������Ѹı䣬ȷ�ϱ�����","����",JOptionPane.YES_NO_CANCEL_OPTION );
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

		//������
		myarea.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				int mods=e.getModifiers();		//����Ҽ�
				if((mods&InputEvent.BUTTON3_MASK)!=0)
				{
					mypopmenu.show(e.getComponent(),e.getX(),e.getY());		//�����˵�
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("�½�"))
		{
			if(flagDocument==true)
			{
				int result=JOptionPane.showConfirmDialog(null,"�ļ������Ѹı䣬ȷ�ϱ�����","����",JOptionPane.YES_NO_CANCEL_OPTION );
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

		if(e.getActionCommand().equals("��"))
		{
			if(flagDocument==true)
			{
				int result=JOptionPane.showConfirmDialog(null,"�ļ������Ѹı䣬ȷ�ϱ�����","����",JOptionPane.YES_NO_CANCEL_OPTION );
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

		if(e.getActionCommand().equals("����"))
		{
			this.save();
			flagDocument=false;
		}

		if(e.getActionCommand().equals("���Ϊ"))
		{
			this.save_as();
			flagDocument=false;
		}

		if(e.getActionCommand().equals("�˳�"))
		{
			if(flagDocument==true)
			{
				int result=JOptionPane.showConfirmDialog(null,"�ļ������Ѹı䣬ȷ�ϱ�����","����",JOptionPane.YES_NO_CANCEL_OPTION );
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

		if(e.getActionCommand().equals("���Һ��滻"))
		{
			searchdlg.setVisible(true);
			s=textfield1.getText();
			start=0;
			end=0;
		}
		if((e.getActionCommand().equals("����"))||(e.getActionCommand().equals("������һ��")))
		{
			String findtext=textfield1.getText();
			if(s!=findtext)
			{
				searchbutton.setText("����");
				s=textfield1.getText();
			}
			String textarea=myarea.getText();
			start=textarea.indexOf(findtext,end);
			end=start+findtext.length();
			if(start==-1)
			{
				JOptionPane.showConfirmDialog(null,"û�ҵ�"+findtext,"���±�",JOptionPane.WARNING_MESSAGE);
			}else
			{
				myarea.select(start,end);
				searchbutton.setText("������һ��");
			}
		}
		if(e.getActionCommand().equals("�滻"))
		{
			String changetext=textfield2.getText();
			myarea.select(start,end);
			myarea.replaceSelection(changetext);
			end=start+changetext.length();
			myarea.select(start,end);
		}
		if(e.getActionCommand().equals("ȫ���滻"))
		{
			String temp=myarea.getText();
			temp=temp.replaceAll(textfield1.getText(),textfield2.getText());
			myarea.setText(temp);
		}
		if(e.getActionCommand().equals("����ȡ��"))
		{
			searchdlg.setVisible(false);
			searchbutton.setText("����");
		}

		if(e.getActionCommand().equals("ȫѡ"))
		{
			myarea.selectAll();
		}

		if(e.getActionCommand().equals("����"))
		{
			myarea.copy();
		}

		if(e.getActionCommand().equals("ճ��"))
		{
			myarea.paste();
		}

		if(e.getActionCommand().equals("����"))
		{
			myarea.cut();
		}

		if(e.getActionCommand().equals("ɾ��"))
		{
			myarea.replaceSelection("");
		}

		if(e.getActionCommand().equals("�Զ�����"))
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

		if(e.getActionCommand().equals("����"))
		{
			fontdlg.setVisible(true);
		}
		if(e.getActionCommand().equals("����ȷ��"))
		{
			if(flagColor==true)
			{
				myarea.setForeground(color);
				flagColor=false;
			}			
			if(shapelist.getSelectedItem().equals("����")==true)
			{
				style=Font.PLAIN ;
			}
			if(shapelist.getSelectedItem().equals("б��")==true)
			{
				style=Font.ITALIC;
			}
			if(shapelist.getSelectedItem().equals("����")==true)
			{
				style=Font.BOLD;
			}
			if(shapelist.getSelectedItem().equals("��б��")==true){
				style=Font.BOLD+Font.ITALIC ;
			}
			fontname=fontlist.getSelectedItem();
			size=(10-(sizelist.getSelectedIndex()))*10;
			myarea.setFont(new Font(fontname,style,size));
			fontdlg.setVisible(false);
		}
		if(e.getActionCommand().equals("����ȡ��"))
		{
			fontdlg.setVisible(false);
		}
		if(e.getActionCommand().equals("��ɫ"))
		{
			JColorChooser jcolor=new JColorChooser();
			Color fcolor=myarea.getForeground();
			color=jcolor.showDialog(myarea,"ѡ���������ɫ",fcolor);
			flagColor=true;
		}

		if(e.getActionCommand().equals("״̬��"))
		{
			if(b==0)
			{
				statuslabel.setText("��ǰ������"+myarea.getText().trim().length()+"\t"+"��ǰ������"+myarea.getLineCount());
				statuslabel.setVisible(true);
				this.add(statuslabel,BorderLayout.SOUTH);
				b=1;
			}else
			{
				statuslabel.setVisible(false);
				b=0;
			}
		}

		if(e.getActionCommand().equals("���ڼ��±�"))
		{
			aboutdlg.setVisible(true);
		}
		
		if(e.getActionCommand().equals("����ȷ��"))
		{
			aboutdlg.setVisible(false);
		}
	}


//	��������
	public void open()
	{
		try{
			FileDialog filedialog=new FileDialog(NoteBook.this,"���ļ�",FileDialog.LOAD);
			filedialog.setFile("*.txt");
			filedialog.setVisible(true);
			if(filedialog.getFile()!=null)
			{
				filename=filedialog.getDirectory()+filedialog.getFile();	//��ȡ�ļ���
				FileReader filereader=new FileReader(filename);		//�˴�����Ҫ�����쳣
				BufferedReader bufferedreader=new BufferedReader(filereader);
				String S="";
				while(bufferedreader.ready())
				{		//�жϻ������Ƿ�Ϊ�գ��ǿ�ʱ����true
					int s=bufferedreader.read();
					S+=(char)s;
				}
				myarea.setText(S);
				filereader.close();
				this.setTitle("���±�����"+filename);
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
				this.setTitle("���±�����"+filename);
			}
		}catch(Exception ee)
		{
			ee.printStackTrace();
//			e.printStackTrace()�Ǵ�ӡ����Exception�켣ջ����System.out.print(e)ֻ�Ǵ�ӡ��e.toString()�������صĽ���� 
		}
	}

	public void save_as()
	{
		try
		{
			FileDialog filedialog=new FileDialog(NoteBook.this,"���Ϊ",FileDialog.SAVE);
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
				this.setTitle("���±�����"+filename);
			}
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
}
