package Admin.Interface;

import java.awt.*;
import javax.swing.*;

public class MainI extends JWindow implements Runnable
{
	JProgressBar JPB;
	JLabel label;
	int width,height;
	
	public static void main(String[] args)
	{
		MainI M=new MainI();
		Thread t=new Thread(M);
		t.start();
	}
	
	public MainI()
	{
		label=new JLabel(new ImageIcon("Image/index.gif"));
		JPB=new JProgressBar();
		JPB.setStringPainted(true);		//设置 stringPainted 属性的值，该属性确定进度条是否应该呈现进度字符串。
		JPB.setIndeterminate(false);	//设置进度条的 indeterminate 属性，该属性确定进度条处于确定模式中还是处于不确定模式中。
		JPB.setBorderPainted(false);	//设置 borderPainted 属性，如果进度条应该绘制其边框，则此属性为 true。
		JPB.setBackground(Color.DARK_GRAY);
		this.add(label,BorderLayout.NORTH);
		this.add(JPB,BorderLayout.SOUTH );
		this.setSize(400,263);
		width=Toolkit.getDefaultToolkit().getScreenSize().width;
		height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200,height/2-150);
		this.setVisible(true);
	}
	
	public void run()
	{
		int[] progressValue={0,1,5,8,14,17,26,35,38,43,49,56,65,71,75,78,86,94,98,99,100};
		for(int i=0;i<progressValue.length;i++)
		{
			try
			{
				Thread.sleep(1000);
			}catch(Exception e){}
			JPB.setValue(progressValue[i]);
		}
		new Login();
		this.dispose();
	}
}
