import java.awt.*;
import java.awt.event.*;
public class GUIFrame extends Frame implements WindowListener{
	public  GUIFrame(String title){
		super(title);
		setBackground(SystemColor.control);
		addWindowListener(this);
	}
	public void setVisible(boolean visible){
		if(visible){
			Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
			setLocation((d.width-getWidth())/2,(d.height-getHeight())/2);
		}
		super.setVisible(visible);
	}
	
	public void windowClosing(WindowEvent p1){
		dispose();
		System.exit(0);
	}
	
	public void windowDecactivated(WindowEvent p1){}
	public void windowOpened(WindowEvent e) {		}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
}
