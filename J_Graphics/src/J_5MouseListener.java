import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class J_5MouseListener extends JFrame
{
	MyPanel5 MP=null;
	
	public static void main(String[] args)
	{
		new J_5MouseListener();
	}
	
	public J_5MouseListener()
	{
		MP=new MyPanel5();
		this.add(MP);
		this.addMouseListener(MP);
		this.addKeyListener(MP);
		this.addMouseMotionListener(MP);
		this.setSize(400,300);
		this.setLocation(300,280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

 class MyPanel5 extends JPanel implements MouseListener,KeyListener,MouseMotionListener
 {
	 //Jpanel
	 public void paint(Graphics g)
	 {
		 super.paint(g);
	 }
	 
	 //MouseListener
	 public void mouseClicked(MouseEvent e)
	 {
		 System.out.println("�������λ���ǣ� ");
		 System.out.println("�����꣺\t"+e.getX());
		 System.out.println("�����꣺\t"+e.getY());
	 }
	 
	 public void mousePressed(MouseEvent e)
	 {
//		 System.out.println("��걻����");
	 }
	 
	 public void mouseReleased(MouseEvent e)
	 {
//		 System.out.println("��걻�ɿ�");
	 }
	 
	 public void mouseEntered(MouseEvent e)
	 {
//		 System.out.println("����ƶ���������");
	 }
	 
	 public void mouseExited(MouseEvent e)
	 {
//		 System.out.println("����뿪����");
	 }
	 
	 //KeyListener
	 public void keyTyped(KeyEvent e){}
	 
	 public void keyPressed(KeyEvent e)
	 {
		 System.out.println(e.getKeyChar()+"������");
	 }
	 
	 public void keyReleased(KeyEvent e){}
	 
	 //MouseMotionListener
	 public void mouseDragged(MouseEvent e)
	 {
//		 System.out.println("��굱ǰλ���ǣ�");
//		 System.out.println("�����꣺\t"+e.getX());
//		 System.out.println("�����꣺\t"+e.getY());
	 }
	 
	 public void mouseMoved(MouseEvent e)
	 {
//		 System.out.println("��굱ǰλ���ǣ�");
//		 System.out.println("�����꣺\t"+e.getX());
//		 System.out.println("�����꣺\t"+e.getY());
	 }
 }