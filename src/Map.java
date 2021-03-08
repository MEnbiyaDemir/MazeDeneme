import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Map {

	private Scanner m;
	private String Map[]=new String[14];
	
	private Image grass,wall,finish;
	
	public Map(){
		
		ImageIcon img=new ImageIcon("C://test//grass.jpg");
		grass=img.getImage();
		
		img=new ImageIcon("C://test//wall.jpg");
		wall=img.getImage();
		
		img=new ImageIcon("C://test//finish.jpg");
		finish= img.getImage();
		
		openFile();
		readFile();
		closeFile();
	}
	
	public String getMap(int x,int y){
		String index=Map[y].substring(x,x+1);
		return index;
	}
	
	public Image getGrass(){return grass;}
	public Image getWall(){return wall;}
    public Image getFinish(){return finish;}
	
	
	
	public void openFile(){
	 try {
		m=new Scanner(new File("C://test//Map.txt"));
	} catch (FileNotFoundException e) {
System.out.println("error loading map");	}

	}
	
public void readFile(){
		while(m.hasNext()){
			for(int i =0; i<14;i++){
				Map[i]= m.next();
			}
		}
	}

public void closeFile(){
	m.close();
    }
	
}
