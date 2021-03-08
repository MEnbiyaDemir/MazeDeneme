import javax.swing.*;

 class Mainze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           new Mainze();
           }
	
	public Mainze(){
		JFrame f =new JFrame();
		f.setTitle("Maze");
		f.add(new Board());
		f.setSize(500,400);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
