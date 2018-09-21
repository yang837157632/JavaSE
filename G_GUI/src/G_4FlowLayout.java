import java.awt.*;
import javax.swing.*;

public class G_4FlowLayout extends JFrame
{
	JButton[] D={null,null,null,null,null,null,null,null};
	
	public static void main(String[] args)
	{
		new G_4FlowLayout();
	}
	
	G_4FlowLayout()
	{
		D[0]=new JButton("话梅");
		D[1]=new JButton("果脯");
		D[2]=new JButton("薯片");
		D[3]=new JButton("饼干");
		D[4]=new JButton("巧克力");
		D[5]=new JButton("腰果");
		D[6]=new JButton("锅巴");
		D[7]=new JButton("开心果");
		
//		java默认的是边界布局管理器，使用其它布局管理器时，需要添加以免出现错误
//		this.setLayout(new FlowLayout());						//居中对齐
//		this.setLayout(new FlowLayout(FlowLayout.LEFT));		//左对齐
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));		//右对齐
		for(int i=0;i<D.length;i++)
		{
			this.add(D[i]);
		}
		
		this.setTitle("FlowLayout");
		this.setSize(380,120);
		this.setLocation(200,200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
