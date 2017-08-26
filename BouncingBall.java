import java.applet.*;
import java.awt.*;

public class BouncingBall extends Applet implements Runnable {
	Thread t,t1;
	int x;
	int y;
	int incx;
	int incy;
	public void init(){
		 x=50;
		 y=50;
		 incx=1;
		 incy=1;
		
	}
	public void start(){
		t=new Thread(this);
		t.start();
	}
	public void run(){
		t1=Thread.currentThread();
		while(true){
			repaint();
			try{
				t.sleep(10);
			}catch(InterruptedException e){}
			if(y>250){
				incy=-1;
			}
			if(y<50){
				incy=+1;
			}
			if(x>1200){
				incx=-1;		
			}
			if(x==50){
				incx=+1;
			}
			x=x+incx*1;
			y=y+incy*1;
		
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.green);
		g.drawLine(50,50,1250,50);
		g.drawLine(50,300,1250,300);
		g.drawLine(50,50,50,300);
		g.drawLine(1250,50,1250,300);
		g.setColor(Color.blue);
		g.fillOval(x,y,40,40);
		
	}

}
