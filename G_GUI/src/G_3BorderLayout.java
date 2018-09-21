/*
 * BorderLayout
 * 1.继承JFrame类
 * 2.在最上方定义组件
 * 3.在构造方法中创建组件
 * 4.在构造方法中添加组件
 * 5.设置窗体属性
 * 6.显示窗体
 * 7.在主函数中创建对象
 * 8.所有布局管理器都可以添加任意组件
 */

import java.awt.*;
import javax.swing.*;

public class G_3BorderLayout extends JFrame
{
	JButton c1,c2,c3,c4,c5;
	
	public static void main(String[] args)
	{
		new G_3BorderLayout();
	}
	
	G_3BorderLayout()
	{
		c1=new JButton("东方");
		c2=new JButton("西方");
		c3=new JButton("南方");
		c4=new JButton("北方");
		c5=new JButton("中部");
		
		this.add(c1,BorderLayout.EAST);		//括号中的参数都是固定，顺序不能改变
		this.add(c2,BorderLayout.WEST);
		this.add(c3,BorderLayout.SOUTH);
		this.add(c4,BorderLayout.NORTH);
		this.add(c5,BorderLayout.CENTER);	//边界布局被添加在中间的组件可以省略第二个参数
		//如果不是五个按钮全部添加，则会以扩充中部为主进行填充，但中部不会被其它四个填充
		
		this.setTitle("BorderLayout");
		this.setSize(450,521);
		this.setLocation(364,154);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
