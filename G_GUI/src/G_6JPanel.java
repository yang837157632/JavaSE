import java.awt.*;
import javax.swing.*;

public class G_6JPanel extends JFrame
{
	JPanel[] F={null,null};
	JButton[] f={null,null,null,null,null};
	
	public static void main(String[] args)
	{
		new G_6JPanel();
	}
	
	G_6JPanel()
	{
		F[0]=new JPanel();
		F[1]=new JPanel();
		
		f[0]=new JButton("可乐");
		f[1]=new JButton("红茶");
		f[2]=new JButton("绿茶");
		f[3]=new JButton("啤酒");
		f[4]=new JButton("矿泉水");

		//添加组件时先将JPanel上的组件添加完毕，再添加JFrame上的组件
		F[0].add(f[0]);		//JPanel默认是流式布局
		F[0].add(f[1]);
		F[1].add(f[2]);
		F[1].add(f[3]);
		this.add(F[0],BorderLayout.SOUTH);
		this.add(F[1],BorderLayout.NORTH);
		this.add(f[4]);

		this.setTitle("JPanel");
		this.setSize(380,220);
		this.setLocation(200,200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
