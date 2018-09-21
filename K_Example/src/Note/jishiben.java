package Note;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class jishiben extends JFrame 
{

    private static final long serialVersionUID = 1L;
    private JTextArea ja = new JTextArea();
    String str;
    private String filePath;
    private String fileName;

    // 自动换行和状态栏
    int a = 0;
    boolean flag = false;

    public jishiben() 
    {

        super("记事本");
		this.setIconImage(new ImageIcon("Image/NoteBook.jpg").getImage());
        this.setSize(768, 384);
        this.setLocationRelativeTo(null);

        // 菜单栏
        JMenu wj = new JMenu();
        wj.setText("文件");
        JMenu bj = new JMenu("编辑");
        JMenu gs = new JMenu("格式");
        JMenu ck = new JMenu("查看");
        JMenu bz = new JMenu("帮助");

        // 工具栏
        JMenuBar gjl = new JMenuBar();

        // 菜单项定义
        final JMenuItem open = new JMenuItem();
        open.setText("打开");
        JMenuItem New = new JMenuItem();
        New.setText("新建");
        JMenuItem save = new JMenuItem();
        save.setText("保存");
        final JMenuItem saveas = new JMenuItem();
        saveas.setText("另存为…");
        JMenuItem exit = new JMenuItem();
        exit.setText("退出");
        final JMenuItem copy = new JMenuItem();
        copy.setText("复制");
        final JMenuItem cut = new JMenuItem();
        cut.setText("剪切");
        JMenuItem paste = new JMenuItem();
        paste.setText("粘贴");
        final JMenuItem selectall = new JMenuItem();
        selectall.setText("全选");
        JMenuItem auto = new JMenuItem();
        auto.setText("自动换行");
        final JMenuItem font = new JMenuItem();
        font.setText("字体");
        JMenuItem about = new JMenuItem();
        about.setText("关于记事本…");
        JMenuItem ztl = new JMenuItem();
        ztl.setText("状态栏");

        // 菜单项添加(文件菜单)
        wj.add(open);
        wj.add(New);
        wj.add(save);
        wj.add(saveas);
        wj.addSeparator();
        wj.add(exit);

        // 菜单项添加(编辑菜单)
        bj.add(cut);
        bj.add(copy);
        bj.add(paste);
        bj.addSeparator();
        bj.add(selectall);

        // 菜单项添加(格式菜单)
        gs.add(auto);
        gs.add(font);

        // 菜单项添加(查看菜单)
        ck.add(ztl);

        // 菜单项添加(帮助菜单)
        bz.add(about);

        // 把各个菜单添加到菜单栏
        gjl.add(wj);
        gjl.add(bj);
        gjl.add(gs);
        gjl.add(ck);
        gjl.add(bz);
        this.setJMenuBar(gjl);
        this.add(ja);

        // 字体
        JLabel lbfont = new JLabel("字体");
        JLabel lbsize = new JLabel("大小");
        JLabel lbshape = new JLabel("字形");
        JPanel jpfont1 = new JPanel();
        JPanel jpfont2 = new JPanel();
        JPanel jpfont3 = new JPanel();
        JPanel jpfont4 = new JPanel();
        final JFrame fontMain = new JFrame();
        final JDialog fontJd = new JDialog(fontMain, "字体,颜色,调色板", true);
        JButton ok = new JButton("确定");
        final JButton canel = new JButton("取消");
        JButton color = new JButton("颜色");
        final List fontList = new List(10, false);
        final List fontShape = new List(10, false);
        final List sizeList = new List(10, false);

        // 加系统字体
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fontNames.length; i++) 
        {
            fontList.add(fontNames[i]);
        }

        // 字体形状
        fontShape.add("常规");
        fontShape.add("粗体");
        fontShape.add("斜体");
        fontShape.add("粗斜体");

        // 设置字体对话框
        fontJd.setSize(450, 300);
        jpfont1.add(lbfont,BorderLayout.NORTH);
        jpfont1.add(fontList);
        jpfont2.add(lbsize,BorderLayout.NORTH);
        jpfont2.add(sizeList);
        jpfont3.add(lbshape,BorderLayout.NORTH);
        jpfont3.add(fontShape);
        jpfont4.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        jpfont4.add(ok);
        jpfont4.add(canel);
        jpfont4.add(color);

        fontJd.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        fontJd.add(jpfont1);
        fontJd.add(jpfont2);
        fontJd.add(jpfont3);
        fontJd.add(jpfont4);

        fontList.select(a);
        sizeList.select(4);
        fontShape.select(0);

        // 字体大小
        final String[] size = { "1", "2", "3", "4", "5", "6", "7", "8", "9","10" };
        for (int i = 0; i < size.length; i++) 
        {
            sizeList.add(size[i]);
        }

        // 设置颜色按钮监听器
        color.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                JColorChooser jcolor = new JColorChooser();
                Color fcolor = ja.getForeground();
                ja.setForeground(jcolor.showDialog(ja, "选择字体颜色", fcolor));
            }

        });

        // 取消按钮监听器
        canel.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                fontMain.setVisible(false);
            }

        });

        // 确定按钮监听器
        ok.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                fontMain.setVisible(false);
            }

        });

        // 字体监听器
        font.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) {
                fontJd.setLocationRelativeTo(jishiben.this);
                fontJd.setVisible(true);

                int style = 0;
                if (fontShape.getSelectedItem().equals("常规") == true) 
                {
                    style = Font.PLAIN;
                }
                if (fontShape.getSelectedItem().equals("斜体") == true) 
                {
                    style = Font.ITALIC;
                }
                if (fontShape.getSelectedItem().equals("粗体") == true) 
                {
                    style = Font.BOLD;
                }
                if (fontShape.getSelectedItem().equals("粗斜体") == true) 
                {
                    style = Font.BOLD + Font.ITALIC;
                }

                // 设置字体大小
                String[] size = { "1", "2", "3", "4", "5", "6", "7", "8", "9","10" };
                for (int i = 0; i < size.length; i++) 
                {
                    if (sizeList.getSelectedItem().equals(size[i]) == true) 
                    {
                        ja.setFont(new Font(String.valueOf(fontList.getSelectedItem()), style, (10 - i) * 10));
                        fontJd.dispose();
                    }
                }

            }
        });

        // 文件改变事件
        ja.getDocument().addDocumentListener(new DocumentListener() 
        {

            public void changedUpdate(DocumentEvent e) 
            {
                flag = true;
            }

            public void insertUpdate(DocumentEvent e) 
            {
                flag = true;
            }

            public void removeUpdate(DocumentEvent e) 
            {
                flag = true;
            }

        });

        // 窗口监听器
        this.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent w) 
            {
                fileName = jishiben.this.getTitle();
                if (flag == true) 
                {
                    int returnValue = JOptionPane.showConfirmDialog(null,jishiben.this.getTitle() + "文件还没有保存！需要保存？", "记事本",
                            JOptionPane.YES_NO_CANCEL_OPTION);
                    if (returnValue == JOptionPane.YES_OPTION) 
                    {
                        save_asMethod();

                    } else if (returnValue == JOptionPane.NO_OPTION) 
                    {
                        System.exit(0);

                    } else
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                }
            }

            // 退出时用到的保存文件函数
            public void save_asMethod() 
            {
                FileDialog fd = new FileDialog(jishiben.this, "另存为…",FileDialog.SAVE);
                fd.setFile("*.txt");
                fd.setVisible(true);

                filePath = fd.getDirectory();
                fileName = fd.getFile();

                try 
                {
                    FileWriter fw = new FileWriter(filePath + fileName);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    pw.println(ja.getText());
                    pw.flush();
                    pw.close();
                } catch (Exception ex) 
                {
                    ex.printStackTrace();
                }
            }
        });

        // 右键快捷方式
        final JPopupMenu jp = new JPopupMenu();
        final JMenuItem jcopy = new JMenuItem("复制");
        final JMenuItem jpaste = new JMenuItem("粘贴");
        final JMenuItem jcut = new JMenuItem("剪切");
        final JMenuItem jselectall = new JMenuItem("全选");

        jp.add(jcopy);
        jp.add(jpaste);
        jp.add(jcut);
        jp.addSeparator();
        jp.add(jselectall);
        jp.addSeparator();
        
        // 右键菜单之复制的事件
        jcopy.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                ja.copy();
            }

        });

        // 右键菜单之粘贴的事件
        jpaste.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                ja.paste();
            }

        });

        // 右键菜单之剪切的事件
        jcut.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                ja.cut();
            }

        });

        // 右键菜单之全选的事件
        jselectall.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                ja.selectAll();
            }

        });

        // 右键菜单之增加鼠标事件
        ja.addMouseListener(new MouseAdapter() 
        {

            public void mouseReleased(MouseEvent e) 
            {
                if (e.isPopupTrigger()) 
                {
                    jp.show((Component) (e.getSource()), e.getX(), e.getY());

                    String temp = ja.getSelectedText();
                    if (temp != null) 
                    {
                        copy.setEnabled(true);
                        cut.setEnabled(true);
                        jcopy.setEnabled(true);
                        jcut.setEnabled(true);
                    } else if (temp == null) 
                    {
                        copy.setEnabled(false);
                        cut.setEnabled(false);
                        jcopy.setEnabled(false);
                        jcut.setEnabled(false);
                    }
                    String temp1 = ja.getText();
                    if (temp1 == null) 
                    {
                        selectall.setEnabled(false);
                        jselectall.setEnabled(false);
                    } else if (temp1 != null) 
                    {
                        selectall.setEnabled(true);
                        jselectall.setEnabled(true);
                    }
                }
            }
        });

        // 复制菜单项
        copy.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                ja.copy();
            }

        });

        // 粘贴菜单项
        paste.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {

                try 
                {
                    ja.paste();
                } catch (Exception ex) 
                {
                    ex.printStackTrace();
                }
            }

        });

        // 剪切菜单项
        cut.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    ja.cut();
                } catch (Exception ex) 
                {
                    ex.printStackTrace();
                }
            }

        });

        // 全选菜单项
        selectall.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                ja.selectAll();
            }

        });

        // 换行菜单项
        auto.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                if (a == 0) 
                {
                    ja.setLineWrap(true);
                    a = 1;
                } else if (a == 1) 
                {
                    ja.setLineWrap(false);
                    a = 0;
                }
            }

        });

        // 新建菜单项
        New.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                jishiben.this.setTitle("无标题——记事本.txt");
                ja.setText(" ");
            }

        });

        // 退出菜单项
        exit.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                fileName = jishiben.this.getTitle();
                if (flag == true) 
                {
                    int returnValue = JOptionPane.showConfirmDialog(null,
                            jishiben.this.getTitle() + "文件还没有保存！需要保存？", "记事本",
                            JOptionPane.YES_NO_CANCEL_OPTION);
                    if (returnValue == JOptionPane.YES_OPTION) 
                    {
                        save_asMethod();

                    } else if (returnValue == JOptionPane.NO_OPTION) 
                    {
                        System.exit(0);

                    } else
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                }
            }

            public void save_asMethod() 
            {
                FileDialog fd = new FileDialog(jishiben.this, "另存为…",FileDialog.SAVE);
                fd.setFile("*.txt");
                fd.setVisible(true);

                filePath = fd.getDirectory();
                fileName = fd.getFile();

                try 
                {
                    FileWriter fw = new FileWriter(filePath + fileName);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    pw.println(ja.getText());
                    pw.flush();
                    pw.close();
                } catch (Exception ex) 
                {
                    ex.printStackTrace();
                }
            }

        });

        // 保存菜单项
        save.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                fileName = jishiben.this.getTitle();
                try {
                    FileWriter fw = new FileWriter(fileName + ".txt");
                    String save = ja.getText();
                    fw.write(save);
                    fw.close();
                } catch (Exception ex) 
                {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "文件已经成功保存了！", "文件保存",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        });

        // 另存菜单项
        saveas.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) {
                FileDialog fd = new FileDialog(jishiben.this, "另存为…",FileDialog.SAVE);
                fd.setFile("*.txt");
                fd.setVisible(true);

                filePath = fd.getDirectory();
                fileName = fd.getFile();

                try {
                    FileWriter fw = new FileWriter(filePath + fileName);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    pw.println(ja.getText());
                    pw.flush();
                    pw.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        // 打开菜单项
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileDialog fd1 = new FileDialog(jishiben.this, "打开",FileDialog.LOAD);
                fd1.setFile("*.txt");
                fd1.setVisible(true);

                fileName = fd1.getFile();
                filePath = fd1.getDirectory();
                jishiben.this.setTitle(fileName);
                try {
                    FileReader fr = new FileReader(filePath + fileName);
                    BufferedReader br = new BufferedReader(fr);
                    String sinput = "";
                    ja.setText("");
                    int lineNum = 0;
                    while ((sinput = br.readLine()) != null) {
                        // System.out.println(sinput);
                        ja.append(sinput + "\r\n");
                        lineNum++;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        // 关于菜单项
        final JFrame jfm = new JFrame();
        JLabel lb1 = new JLabel("本记事本有zyw制作\n");
        JLabel lb2 = new JLabel("版权所有，盗版必究！\n");
        JLabel lb3 = new JLabel("谢谢使用！\n");

        jfm.setSize(200, 170);
        jfm.setTitle("关于本软件");
        jfm.add(lb1);
        jfm.add(lb2);
        jfm.add(lb3);
        final JButton qd = new JButton("确定");
        qd.setSize(20, 17);
        jfm.add(qd);

        // 关于菜单项
        about.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jfm.setLocationRelativeTo(jishiben.this);
                jfm.setVisible(true);
                jfm.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

                qd.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        jfm.setVisible(false);
                    }

                });
            }

        });

        // 状态栏菜单项
        final JLabel lb = new JLabel();
        ztl.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (a == 1) {
                    lb.setVisible(false);
                    a = 0;
                } else if (a == 0) {
                    jishiben.this.add(lb, BorderLayout.SOUTH);
                    lb.setVisible(true);
                    lb.setText("当前字数: "
                            + String.valueOf(ja.getText().trim().length())
                            + " " + "当前行数: "
                            + String.valueOf(ja.getLineCount()));
                    a = 1;
                }
            }

        });

        // 快捷键
        open.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK));
        New.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke('Q', InputEvent.CTRL_MASK));

        copy.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke('A',InputEvent.CTRL_MASK));

        auto.setAccelerator(KeyStroke.getKeyStroke('H', InputEvent.CTRL_MASK));
        font.setAccelerator(KeyStroke.getKeyStroke('F', InputEvent.ALT_MASK));

        // 添加滚动条
        JScrollPane jsp = new JScrollPane(ja);
        Container c = this.getContentPane();
        c.add(jsp);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 需要的时候出现
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // 总是存在

        this.setVisible(true);
    }
    
    public static void main(String[] args) {
    	new jishiben();
    }

}