/*
 * 一、布局
 * 	1、组件
 * 		以图形化的方式显示在屏幕上，和用户进行交互的对象，叫做组件。
 * 		组件包括：菜单、标签、文本框（密码框）、滚动条、单选、复选、按钮等等。
 * 	2、容器
 * 		组件不能独立的显示出来，只能将组件放在容器里，才能正常的显示。
 * 		将组件合理有序的排列和分布在容器中，（包括组件的位置，大小）称为布局。
 * 二、布局管理器
 * 	每个容器都有自己的布局管理器，当某个容器内的组件需要改变其属性时，就需要调用其组件所在容器的布局管理器。
 * 	awt中常见的布局管理器有：BorderLayout（边界布局管理器），FLowLayout（流式布局管理器），GridLayout（网格布局管理器）。
 */

import java.awt.*;
import javax.swing.*;

public class G_1JFrame 
{
	public static void main(String[] args)
	{
		JFrame A=new JFrame();
		A.setTitle("GUI");
		A.setSize(350,200);
		A.setLocation(200,200);
		JButton a=new JButton("按钮");
		A.add(a);
		A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//这句话一定要写对，因为这句写的对不对运行时看不出来
		A.setVisible(true);
	}

}
