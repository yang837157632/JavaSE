package TankWar;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**********  **********  ***********  **********  ***********  **********/

public class TankWar extends JFrame implements ActionListener{
	StartPanel startpanel=null;
	GamePanel gamepanel=null;
	JMenuBar menubar=null;
	JMenu game=null;
	JMenuItem newgame=null;
	JMenuItem exitgame=null;
	JMenuItem saveexit=null;
	JMenuItem goongame=null;
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public static void main(String[] args){
		new TankWar();
	}
	public TankWar(){
		menubar=new JMenuBar();
		game=new JMenu("Game(G)");
		game.setMnemonic('G');

		newgame=new JMenuItem("NewGame(N)");
		newgame.setMnemonic('N');
		newgame.setActionCommand("newgame");
		newgame.addActionListener(this);

		exitgame=new JMenuItem("ExitGame(E)");
		exitgame.setMnemonic('E');
		exitgame.setActionCommand("exitgame");
		exitgame.addActionListener(this);

		saveexit=new JMenuItem("SaveExit(S)");
		saveexit.setMnemonic('S');
		saveexit.setActionCommand("saveexit");
		saveexit.addActionListener(this);

		goongame=new JMenuItem("GoonGame(C)");
		goongame.setMnemonic('C');
		goongame.setActionCommand("goongame");
		goongame.addActionListener(this);

		game.add(newgame);
		game.add(exitgame);
		game.add(saveexit);
		game.add(goongame);
		menubar.add(game);
		this.setJMenuBar(menubar);

		startpanel=new StartPanel();
		Thread t=new Thread(startpanel);
		t.start();
		this.add(startpanel);

		this.setTitle("TankWar");
		this.setIconImage(new ImageIcon("tank.jpg").getImage());
		this.setSize(600,500);
		this.setLocation(270,170);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("newgame")){
			gamepanel=new GamePanel("newgame");
			this.remove(startpanel);
			this.add(gamepanel);
			this.addKeyListener(gamepanel);
			Thread t=new Thread(gamepanel);
			t.start();
			this.setVisible(true);
		}else if(e.getActionCommand().equals("exitgame")){
			Record.saveRecord();
			System.exit(0);
		}else if(e.getActionCommand().equals("saveexit")){
			Record record=new Record();
			record.setEnemyTanks(gamepanel.enemytanks);
			record.saveDisk();
			System.exit(0);
		}else if(e.getActionCommand().equals("goongame")){
			gamepanel=new GamePanel("goongame");
			Thread t=new Thread(gamepanel);
			t.start();
			this.remove(startpanel);
			this.add(gamepanel);
			this.addKeyListener(gamepanel);
			this.setVisible(true);
		}
	}
}

/**********  **********  ***********  **********  ***********  **********/

class StartPanel extends JPanel implements Runnable{
	int time=0;
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0,0,400,300);
		if(time%2==0){
			g.setColor(Color.YELLOW);
			g.setFont(new Font("华文行楷",Font.BOLD,58));
			g.drawString("第一关", 100, 140);
		}
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(500);
			}catch(Exception e){}
			time++;
			this.repaint();
		}
	}
}

/**********  **********  ***********  **********  ***********  **********/

class GamePanel extends JPanel implements KeyListener,Runnable{
	MyTank mytank=null;
	Vector<EnemyTank> enemytanks=new Vector<EnemyTank>();
	Vector<Position> positions=new Vector<Position>();
	Vector<Blow> blows=new Vector<Blow>();
	Image image1=null;
	Image image2=null;
	Image image3=null;
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public GamePanel(String s){
		Record.readRecord();
		mytank=new MyTank(140,232);
		if(s.equals("newgame")){
			for(int i=0;i<3;i++){
				EnemyTank enemytank=new EnemyTank(5+180*i,0);
				enemytank.direction=2;
				enemytank.enemytanks=enemytanks;
				Thread t2=new Thread(enemytank);
				t2.start();
				enemytanks.add(enemytank);
			}
		}else if(s.equals("goongame")){
			positions=Record.readDisk();
			for(int i=0;i<positions.size();i++){
				Position position=positions.get(i);
				EnemyTank enemytank=new EnemyTank(position.x,position.y);
				enemytank.direction=position.direction;
				enemytank.enemytanks=enemytanks;
				Thread t2=new Thread(enemytank);
				t2.start();
				enemytanks.add(enemytank);
			}
		}
		try{
			image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bzxg1.gif"));
			image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bzxg2.gif"));
			image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bzxg3.gif"));
		}catch(Exception e){}
		Thread t_sound=new Thread(new Sound("./tank.wav"));
		t_sound.start();
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public void addRecord(Graphics g){
		this.drawTank(80,330,g,0,0);
		g.setColor(Color.BLACK);
		g.drawString(Record.getMyTankNum()+"",116,350);
		this.drawTank(150,330,g,0,1);
		g.setColor(Color.BLACK);
		g.drawString(Record.getEnemyTankNum()+"",186,350);
		this.drawTank(450,86,g,0,1);
		g.setColor(Color.BLACK);
		g.drawString(Record.getNum()+"",486,107);
		g.setFont(new Font("华文彩云",Font.BOLD,20));
		g.drawString("你消灭的坦克总数",410,40);
	}
	public void drawTank(int x,int y,Graphics g,int direction,int color){
		switch(color){
		case 0:
			g.setColor(Color.YELLOW);
			break;
		case 1:
			g.setColor(Color.GREEN);
			break;
		}
		switch(direction){
		case 0:
			g.fill3DRect(x,y,5,30,false);
			g.fill3DRect(x+15,y,5,30,false);
			g.fill3DRect(x+5,y+5,10,20,false);
			g.fillOval(x+5,y+10,10,10);
			g.drawLine(x+10,y+15,x+10,y-3);
			break;
		case 1:
			g.fill3DRect(x,y,30,5,false);
			g.fill3DRect(x,y+15,30,5,false);
			g.fill3DRect(x+5,y+5,20,10,false);
			g.fillOval(x+10,y+5,10,10);
			g.drawLine(x+15,y+10,x-3,y+10);
			break;
		case 2:
			g.fill3DRect(x,y,5,30,false);
			g.fill3DRect(x+15,y,5,30,false);
			g.fill3DRect(x+5,y+5,10,20,false);
			g.fillOval(x+5,y+10,10,10);
			g.drawLine(x+10,y+15,x+10,y+33);
			break;
		case 3:
			g.fill3DRect(x,y,30,5,false);
			g.fill3DRect(x,y+15,30,5,false);
			g.fill3DRect(x+5,y+5,20,10,false);
			g.fillOval(x+10,y+5,10,10);
			g.drawLine(x+15,y+10,x+33,y+10);
			break;
		}
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_UP){
			this.mytank.direction=0;
			this.mytank.up();
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			this.mytank.direction=1;
			this.mytank.left();
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			this.mytank.direction=2;
			this.mytank.down();
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			this.mytank.direction=3;
			this.mytank.right();
		}
		if(e.getKeyCode()==KeyEvent.VK_J){
			if(this.mytank.bullets.size()<8){
				this.mytank.fire();
			}
		}
		this.repaint();
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public void bulletMy(){
		for(int i=0;i<this.enemytanks.size();i++){
			EnemyTank enemytank=enemytanks.get(i);
			for(int j=0;j<enemytank.bullets.size();j++){
				Bullet bullet=enemytank.bullets.get(j);
				if(mytank.life){
					if(this.bulletTank(bullet,mytank)){
						Record.myTankDecrease();
					}
				}
			}
		}
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public void bulletEnemy(){
		for(int i=0;i<mytank.bullets.size();i++){
			Bullet bullet=mytank.bullets.get(i);
			for(int j=0;j<enemytanks.size();j++){
				EnemyTank enemytank=enemytanks.get(j);
				if(enemytank.life){
					if(this.bulletTank(bullet,enemytank)){
						Record.enemyTankDecrease();
						Record.enemyTankTotal();
					}
				}
			}
		}
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public boolean bulletTank(Bullet bullet,Tank tank){
		boolean result=false;
		switch(tank.direction){
		case 0:
		case 2:
			if(bullet.x>tank.x&&bullet.x<tank.x+20&&bullet.y>tank.y&&bullet.y<tank.y+30){
				bullet.life=false;
				tank.life=false;
				result=true;
				Blow blow=new Blow(tank.x,tank.y);
				blows.add(blow);
			}
			break;
		case 1:
		case 3:
			if(bullet.x>tank.x&&bullet.x<tank.x+30&&bullet.y>tank.x&&bullet.y<tank.y+20){
				bullet.life=false;
				tank.life=false;
				result=true;
				Blow blow=new Blow(tank.x,tank.y);
				blows.add(blow);
			}
			break;
		}
		return result;
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public void run(){
		while(true){
			try{
				Thread.sleep(100);
			}catch(Exception e){}
			this.bulletEnemy();
			this.bulletMy();
			this.repaint();
		}
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public void paint(Graphics g){
		super.paint(g);
		g.fillRect(0,0,400,300);
		this.addRecord(g);
		if(Record.getMyTankNum()>0){
			if(mytank.life){
				this.drawTank(mytank.x,mytank.y,g,mytank.direction,mytank.color);
			}else{
				mytank.x=140;
				mytank.y=232;
				mytank.direction =0;
				mytank.life=true;
				this.drawTank(mytank.x,mytank.y,g,mytank.direction,mytank.color);
			}
		}
		for(int i=0;i<enemytanks.size();i++){
			EnemyTank enemytank=enemytanks.get(i);
			if(enemytank.life){
				this.drawTank(enemytank.x,enemytank.y,g,enemytank.direction,enemytank.color);
				for(int j=0;j<enemytank.bullets.size();j++){
					Bullet bullet=enemytank.bullets.get(j);
					if(bullet.life){
						g.setColor(Color.RED);
						g.fill3DRect(bullet.x,bullet.y,3,3,false);						
					}else{
						enemytank.bullets.remove(j);
					}
				}
			}else{
				if(Record.getEnemyTankNum()>=3){
					enemytank.x=5+180*i;
					enemytank.y=0;
					enemytank.direction=2;
					enemytank.life=true;
					this.drawTank(enemytank.x,enemytank.y,g,enemytank.direction,enemytank.color);
					for(int j=0;j<enemytank.bullets.size();j++){
						Bullet bullet=enemytank.bullets.get(j);
						if(bullet.life){
							g.setColor(Color.RED);
							g.fill3DRect(bullet.x,bullet.y,3,3,false);						
						}else{
							enemytank.bullets.remove(j);
						}
					}
				}
			}
		}
		if(mytank.life){
			for(int i=0;i<mytank.bullets.size();i++){
				Bullet bullet=mytank.bullets.get(i);
				if(bullet!=null&&bullet.life==true){
					g.setColor(Color.RED);
					g.fill3DRect(bullet.x,bullet.y,3,3,false);
				}
				if(bullet.life==false){
					mytank.bullets.remove(i);
				}
			}
		}
		for(int i=0;i<blows.size();i++){
			Blow blow=blows.get(i);
			if(blow.lifetime>6){
				g.drawImage(image1,blow.x,blow.y,30,30,this);
			}else if(blow.lifetime>3){
				g.drawImage(image2,blow.x,blow.y,30,30,this);
			}else{
				g.drawImage(image3,blow.x,blow.y,30,30,this);
			}
			blow.live();
			if(blow.lifetime==0){
				blows.remove(i);
			}
		}
	}
}