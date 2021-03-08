import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Board extends JPanel implements ActionListener {

	private Timer timer;
	private Map m;
	private Player p;
	private String Message=" ";
	private Font font=new Font("Serif",Font.BOLD,48);
	private boolean win=false;
	
	
	public Board (){
		m=new Map();
		p=new Player();
		
		addKeyListener(new Al());
		setFocusable(true);
		
		timer=new Timer(25,this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(m.getMap(p.getTileX(), p.getTileY()).equals("2")){Message="KAZANDINNn"; win=true;}
		repaint();
	}
	
	
	
	public void paint (Graphics g){
		super.paint(g);
		
		if(!win) {
		for(int y=0;y<14;y++){
			for(int x=0;x<14;x++){
				if(m.getMap(x, y).equals("2")){g.drawImage(m.getFinish(),x*32,y*32,null);}
				if(m.getMap(x, y).equals("1")){g.drawImage(m.getGrass(),x*32,y*32,null);}
				if(m.getMap(x, y).equals("0")){g.drawImage(m.getWall(),x*32,y*32,null);}	
		}
				}
		}
		
		if(win) {
		g.setColor(Color.ORANGE);
		g.setFont(font);
		g.drawString(Message, 200,200);
		}
		
		g.drawImage(p.getPlayer(),p.getTileX()*32,p.getTileY()*32,null);
		}

	public class Al extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int keycode=e.getKeyCode();
			if(keycode==KeyEvent.VK_W){
				if(!m.getMap(p.getTileX(), p.getTileY()-1).equals("0")) {
				p.move(0,-1);}}
			
			if(keycode==KeyEvent.VK_A){
				if(!m.getMap(p.getTileX()-1, p.getTileY()).equals("0")) {
				p.move(-1,0);}}
			
			if(keycode==KeyEvent.VK_S){
				if(!m.getMap(p.getTileX(), p.getTileY()+1).equals("0")){
				p.move(0,1);}}
			
			if(keycode==KeyEvent.VK_D){
				if(!m.getMap(p.getTileX()+1, p.getTileY()).equals("0")) {
				p.move(1,0);}}
			}
		
		public void keyReleased(KeyEvent e){}
		public void keyTyped(KeyEvent e){}

		}
	
}
