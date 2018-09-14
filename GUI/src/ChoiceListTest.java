import java.awt.*;
import java.awt.event.*;
public class ChoiceListTest extends GUIFrame implements ItemListener{
	public ChoiceListTest(){
		super("Choice/List Test");
		
		Choice choice=new Choice();
		choice.add("Hi");
		choice.add("Hello");
		choice.add("bye");
		choice.addItemListener(this);
		add(choice,BorderLayout.WEST);
		
		List list=new List(5,false);
		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		list.addItemListener(this);
		add(list,BorderLayout.EAST);
		
		pack();
		setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent event){
		ItemSelectable selectable=event.getItemSelectable();
		Object affectedItem=event.getItem();
		
		String msg="itemStateChanged: \"";
		if(selectable instanceof List){
			int index=((Integer)affectedItem).intValue();
			msg+=((List)selectable).getItem(index);
		}
		else{
			msg += event.getItem();
		}
		
		msg+="\""+(event.getStateChange()==ItemEvent.SELECTED?"selected":"deselected");
		
		System.out.println(msg+" from "+selectable.getClass().getName());
	}
	
	public static void main(String[] args){
		new ChoiceListTest();
	}
}
