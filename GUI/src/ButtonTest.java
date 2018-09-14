import java.awt.Button;
import java.awt.event.*;
public class ButtonTest extends GUIFrame implements ActionListener{
	public ButtonTest(){
		super("Button Test");
		Button button=new Button("CLick Me");
		button.addActionListener(this);
		add(button);
		setSize(300,400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		System.out.println("clicked");
		if (event.getSource() instanceof Button){
			System.out.println("Button was Clicked");
		}
	}
	public static void main(String[] args){
		new ButtonTest();
	}
}
