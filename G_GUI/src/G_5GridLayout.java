import java.awt.*;
import javax.swing.*;

public class G_5GridLayout extends JFrame
{
	JButton[] E={null,null,null,null,null,null,null,null,null};
	
	public static void main(String[] args)
	{
		new G_5GridLayout();
	}
	
	G_5GridLayout()
	{
		E[0]=new JButton("话梅");
		E[1]=new JButton("果脯");
		E[2]=new JButton("薯片");
		E[3]=new JButton("饼干");
		E[4]=new JButton("巧克力");
		E[5]=new JButton("腰果");
		E[6]=new JButton("锅巴");
		E[7]=new JButton("开心果");
		E[8]=new JButton("杏仁");
		
		this.setLayout(new GridLayout(3,3,20,30));
		//this.setLayout(new GridLayout(3,3))				//间隔不写为0
		for(int i=0;i<E.length;i++)
		{
			this.add(E[i]);
		}
		
		this.setTitle("GridLayout");
		this.setSize(430,450);
		this.setLocation(360,150);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
