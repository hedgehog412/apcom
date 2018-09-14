import java.awt.*;
import java.awt.event.*;
public class TextComponentTest extends GUIFrame implements TextListener{
	public TextComponentTest() {
		super("Text Component Test");
		TextField tf=new TextField();
		tf.addTextListener(this);
		add(tf,BorderLayout.NORTH);
		
		TextArea ta=new TextArea(10,50);
		ta.addTextListener(this);
		add(ta,BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	
	public void textValueChanged(TextEvent event){
		TextComponent src=(TextComponent) event.getSource();
		System.out.println(src.getText());
	}
	public static void main(String[] args){
		new TextComponentTest();
	}
}
