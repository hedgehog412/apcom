import java.awt.*;
import java.awt.event.*;
public class CanvasMouseTest extends GUIFrame implements MouseListener{
	
	public CanvasMouseTest(){
		super("Canvas and MouseListener Test");
		Canvas canv=new Canvas();
		canv.setSize(200,200);
		canv.addMouseListener(this);
		canv.setBackground(Color.yellow);
		add(canv);
		pack();
		setVisible(true);
	}
	
	public void mousePressed(MouseEvent event){
		Point p=event.getPoint();
		System.out.println("Mouse pressed at : "+p);
		Graphics g=((Canvas)event.getSource()).getGraphics();
		g.fillOval(p.x, p.y, 10, 10);
	}
	
	public static void main(String[] args){
		new CanvasMouseTest();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
