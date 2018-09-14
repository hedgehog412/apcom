import java.awt.Label;
import java.awt.event.WindowEvent;
public class LabelTest extends GUIFrame{
	public LabelTest(){
		super("Label Test");
		Label label=new Label("This is a Label");
		add(label);
		setSize(400,300);
		setVisible(true);
	}
	
	
	public static void main(String[] args){
		new LabelTest();
	}
}
