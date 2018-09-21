package TankWar;
import java.util.*;
import java.io.*;
import javax.sound.sampled.*;

/**********  **********  ***********  **********  ***********  **********/

class Bullet implements Runnable{
	int x,y,direction;
	int speed=10;
	boolean life=true;

	public Bullet(int x,int y,int direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public void run(){
		while(true){
			try{
				Thread.sleep(50);
			}catch(Exception e){}
			switch(this.direction){
			case 0:
				y-=speed;
				break;
			case 1:
				x-=speed;
				break;
			case 2:
				y+=speed;
				break;
			case 3:
				x+=speed;
				break;
			}
			if(x<0||x>400||y<0||y>300){
				this.life=false;
				break;
			}
		}
	}
}

/**********  **********  ***********  **********  ***********  **********/

class Tank{
	int x,y,direction,speed,color;
	boolean life=true;

	public Tank(int x,int y){
		this.x=x;
		this.y=y;
	}
}

/**********  **********  ***********  **********  ***********  **********/

class EnemyTank extends Tank implements Runnable{
	int speed=3;
	int time=0;
	int color=1;
	Vector<EnemyTank> enemytanks=new Vector<EnemyTank>();
	Vector<Bullet> bullets=new Vector<Bullet>();

	public EnemyTank(int x,int y){
		super(x,y);
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public boolean collision(){
		boolean result=false;
		switch(this.direction){
		case 0:
			for(int i=0;i<enemytanks.size();i++){
				EnemyTank enemytank=enemytanks.get(i);
				if(enemytank!=this){
					if(enemytank.direction==0||enemytank.direction==2){
						if(this.x>=enemytank.x&&this.x<=enemytank.x+20&&this.y>=enemytank.y&&this.y<=enemytank.y+30){
							return true;
						}
						if(this.x+20>=enemytank.x&&this.x+20<=enemytank.x &&this.y>=enemytank.y&&this.y<=enemytank.y+30){
							return true;
						}
					}
					if(enemytank.direction==1||enemytank.direction==3){
						if(this.x>=enemytank.x&&this.x<=enemytank.x+30&&this.y>=enemytank.y&&this.y<=enemytank.y+20){
							return true;
						}
						if(this.x+20>enemytank.x&&this.x+20<=enemytank.x+30&&this.y>=enemytank.y&&this.y<=enemytank.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 1:
			for(int i=0;i<enemytanks.size();i++){
				EnemyTank enemytank=enemytanks.get(i);
				if(enemytank!=this){
					if(enemytank.direction==0||enemytank.direction==2){
						if(this.x>=enemytank.x&&this.x<=enemytank.x+20&&this.y>=enemytank.y&&this.y<=enemytank.y+30){
							return true;
						}
						if(this.x>=enemytank.x&&this.x<=enemytank.x+20 &&this.y+20>=enemytank.y&&this.y+20<=enemytank.y+30){
							return true;
						}
					}
					if(enemytank.direction==1||enemytank.direction==3){
						if(this.x>=enemytank.x&&this.x<=enemytank.x+30&&this.y>=enemytank.y&&this.y<=enemytank.y+20){
							return true;
						}
						if(this.x>enemytank.x&&this.x<=enemytank.x+30&&this.y+20>=enemytank.y&&this.y+20<=enemytank.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 2:
			for(int i=0;i<enemytanks.size();i++){
				EnemyTank enemytank=enemytanks.get(i);
				if(enemytank!=this){
					if(enemytank.direction==0||enemytank.direction==2){
						if(this.x>=enemytank.x&&this.x<=enemytank.x+20&&this.y+30>=enemytank.y&&this.y+30<=enemytank.y+30){
							return true;
						}
						if(this.x+20>=enemytank.x&&this.x+20<=enemytank.x+20 &&this.y+30>=enemytank.y&&this.y+30<=enemytank.y+30){
							return true;
						}
					}
					if(enemytank.direction==1||enemytank.direction==3){
						if(this.x>=enemytank.x&&this.x<=enemytank.x+30&&this.y+30>=enemytank.y&&this.y+30<=enemytank.y+20){
							return true;
						}
						if(this.x+20>enemytank.x&&this.x+20<=enemytank.x+30&&this.y+30>=enemytank.y&&this.y+30<=enemytank.y+20){
							return true;
						}
					}
				}
			}
			break;
		case 3:
			for(int i=0;i<enemytanks.size();i++){
				EnemyTank enemytank=enemytanks.get(i);
				if(enemytank!=this){
					if(enemytank.direction==0||enemytank.direction==2){
						if(this.x+30>=enemytank.x&&this.x+30<=enemytank.x+20&&this.y>=enemytank.y&&this.y<=enemytank.y+30){
							return true;
						}
						if(this.x+30>=enemytank.x&&this.x+30<=enemytank.x+20&&this.y+20>=enemytank.y&&this.y+20<=enemytank.y+30){
							return true;
						}
					}
					if(enemytank.direction==1||enemytank.direction==3){
						if(this.x+30>=enemytank.x&&this.x+30<=enemytank.x+30&&this.y>=enemytank.y&&this.y<=enemytank.y+20){
							return true;
						}
						if(this.x+30>enemytank.x&&this.x+30<=enemytank.x+30&&this.y+20>=enemytank.y&&this.y+20<=enemytank.y+20){
							return true;
						}
					}
				}
			}
			break;
		}
		return result;
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public void run(){
		while(true){
			switch(this.direction){
			case 0:
				for(int i=0;i<30;i++){
					if(y>0&&!this.collision()){
						y-=speed;
					}
					try{
						Thread.sleep(50);
					}catch(Exception e){}
				}
				break;
			case 1:
				for(int i=0;i<30;i++){
					if(x>0&&!this.collision()){
						x-=speed;
					}
					try{
						Thread.sleep(50);
					}catch(Exception e){}
				}
				break;
			case 2:
				for(int i=0;i<30;i++){
					if(y<250&&!this.collision()){
						y+=speed;
					}
					try{
						Thread.sleep(50);
					}catch(Exception e){}
				}
				break;
			case 3:
				for(int i=0;i<30;i++){
					if(x<360&&!this.collision()){
						x+=speed;
					}
					try{
						Thread.sleep(50);
					}catch(Exception e){}
				}
				break;
			}
			this.direction=(int)(Math.random()*4);
			if(!this.life){
				break;
			}
			this.time++;
			if(time%2==0){
				if(bullets.size()<5){
					Bullet bullet=null;
					switch(this.direction){
					case 0:
						bullet=new Bullet(x+10,y,0);
						bullets.add(bullet);
						break;
					case 1:
						bullet=new Bullet(x,y+10,1);
						bullets.add(bullet);
						break;
					case 2:
						bullet=new Bullet(x+10,y+30,2);
						bullets.add(bullet);
						break;
					case 3:
						bullet=new Bullet(x+30,y+10,3);
						bullets.add(bullet);
						break;
					}
					Thread t_bullet=new Thread(bullet);
					t_bullet.start();
				}
			}
		}
	}	
}

/**********  **********  ***********  **********  ***********  **********/

class MyTank extends Tank{
	int speed=5;
	int color=0;
	Vector<Bullet> bullets=new Vector<Bullet>();
	public MyTank(int x,int y){
		super(x,y);
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public void fire(){
		Bullet bullet=null;
		switch(this.direction){
		case 0:
			bullet=new Bullet(x+10,y,0);
			bullets.add(bullet);
			break;
		case 1:
			bullet=new Bullet(x,y+10,1);
			bullets.add(bullet);	
			break;
		case 2:
			bullet=new Bullet(x+10,y+30,2);
			bullets.add(bullet);
			break;
		case 3:
			bullet=new Bullet(x+30,y+10,3);
			bullets.add(bullet);
			break;
		}
		Thread t_bullet=new Thread(bullet);
		t_bullet.start();
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public void up(){
		if(y>0){
			y-=speed;
		}
	}
	public void left(){
		if(x>0){
			x-=speed;
		}
	}
	public void down(){
		if(y<250){
			y+=speed;
		}
	}
	public void right(){
		if(x<360){
			x+=speed;
		}
	}
}

/**********  **********  ***********  **********  ***********  **********/

class Blow{
	int x,y;
	int lifetime=9;
	boolean life=true;
	public Blow(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void live(){
		if(this.lifetime>0){
			this.lifetime--;
		}else{
			this.life=false;
		}
	}
}

/**********  **********  ***********  **********  ***********  **********/

class Position{
	int x,y,direction;
	public Position(int x,int y,int direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
}

/**********  **********  ***********  **********  ***********  **********/

class Record{
	private static int EnemyTankNum=5;
	private static int MyTankNum=2;
	private static int Num=0;
	private static FileReader filereader=null;
	private static BufferedReader bufferedreader=null;
	private static FileWriter filewriter=null;
	private static BufferedWriter bufferedwriter=null;
	private static Vector<EnemyTank> enemytanks=new Vector<EnemyTank>();
	static Vector<Position> positions=new Vector<Position>();
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public static int getEnemyTankNum() {
		return EnemyTankNum;
	}
	public static void setEnemyTankNum(int enemyTankNum) {
		EnemyTankNum = enemyTankNum;
	}
	public static int getMyTankNum() {
		return MyTankNum;
	}
	public static void setMyTankNum(int myTankNum) {
		MyTankNum = myTankNum;
	}
	public static int getNum() {
		return Num;
	}
	public static void setNum(int num) {
		Num = num;
	}
	public static void enemyTankDecrease(){
		EnemyTankNum--;
	}
	public static void myTankDecrease(){
		MyTankNum--;
	}
	public static void enemyTankTotal(){
		Num++;
	}
	public Vector<EnemyTank> getEnemyTanks(){
		return enemytanks;
	}
	public void setEnemyTanks(Vector<EnemyTank> enemyTanks){
		enemytanks=enemyTanks;
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public static void saveDisk(){
		try{
			filewriter=new FileWriter("E:/Java/Work/K_Example/TankWar.txt");
			bufferedwriter=new BufferedWriter(filewriter);
			bufferedwriter.write(EnemyTankNum+"\r\n");
			bufferedwriter.write(MyTankNum+"\r\n");
			bufferedwriter.write(Num+"\r\n");
			for(int i=0;i<enemytanks.size();i++){
				EnemyTank enemytank=enemytanks.get(i);
				if(enemytank.life){
					String s=enemytank.x+" "+enemytank.y+" "+enemytank.direction;
					bufferedwriter.write(s+"\r\n");
				}
			}
		}catch(Exception e){}
		finally{
			try{
				bufferedwriter.close();
				filewriter.close();
			}catch(Exception e){}
		}
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public static Vector<Position> readDisk(){
		try{
			filereader=new FileReader("E:/Java/Work/K_Example/TankWar.txt");
			bufferedreader=new BufferedReader(filereader);
			String s="";
			s=bufferedreader.readLine();
			EnemyTankNum=Integer.parseInt(s);
			s=bufferedreader.readLine();
			MyTankNum=Integer.parseInt(s);
			s=bufferedreader.readLine();
			Num=Integer.parseInt(s);
			while((s=bufferedreader.readLine())!=null){
				String[] array=s.split(" ");
				Position position=new Position(Integer.parseInt(array[0]),Integer.parseInt(array[1]),Integer.parseInt(array[2]));
				positions.add(position);
			}
		}catch(Exception e){}
		finally{
			try{
				bufferedreader.close();
				filereader.close();
			}catch(Exception e){}
		}
		return positions;
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public static void saveRecord(){
		try{
			filewriter=new FileWriter("E:/Java/Work/K_Example/TankWar.txt");
			bufferedwriter=new BufferedWriter(filewriter);
			bufferedwriter.write(Num+"\r\n");
		}catch(Exception e){}
		finally{
			try{
				bufferedwriter.close();
				filewriter.close();
			}catch(Exception e){}
		}
	}
	/********** &&&&&&&&&& &&&&&&&&&& &&&&&&&&& **********/
	public static void readRecord(){
		try{
			filereader=new FileReader("E:/Java/Work/K_Example/TankWar.txt");
			bufferedreader=new BufferedReader(filereader);
			String s=bufferedreader.readLine();
			Num=Integer.parseInt(s);
		}catch(Exception e){}
		finally{
			try{
				bufferedreader.close();
				filereader.close();
			}catch(Exception e){}
		}
	}
}

/**********  **********  ***********  **********  ***********  **********/
//仅可播放WAV形式的音乐
class Sound implements Runnable{
	private String name;
	public Sound(String name){
		this.name=name;
	}
	public void run(){
		File file=new File(name);
		AudioInputStream AIS=null;
		try{
			AIS=AudioSystem.getAudioInputStream(file);
		}catch(Exception e){}	
		AudioFormat format=AIS.getFormat();
		SourceDataLine SDL=null;
		DataLine.Info info=new DataLine.Info(SourceDataLine.class,format);
		try{
			SDL=(SourceDataLine)AudioSystem.getLine(info);
			SDL.open(format);
		}catch(Exception e){}
		SDL.start();

		int a=0;
		byte[] buffer=new byte[1024];
		try{
			while(a!=-1){
				a=AIS.read(buffer,0,buffer.length);
				if(a>=0){
					SDL.write(buffer,0,a);
				}
			}
		}catch(Exception e){}
		finally{
			SDL.drain();			//将残留部分处理干净
			SDL.close();
		}		
	}
}