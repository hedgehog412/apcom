import java.awt.*;
import java.awt.event.*;
public class MyCanvasMouseTest1 extends GUIFrame implements MouseListener, ActionListener, ItemListener, TextListener{
	Choice shape;
	Choice color;
	Canvas canvas;
	Label label;
	String s;
	String c;
	public MyCanvasMouseTest1(){
		super("My Canvas Mouse Test");
		setBackground(Color.gray);

		shape=new Choice();
		shape.add("Arc");
		shape.add("Circle");
		shape.add("Rectangle");
		shape.add("Star");
		shape.addItemListener(this);
		add(shape,BorderLayout.WEST);
		
		color=new Choice();
		color.add("Red");
		color.add("Green");
		color.add("Blue");
		color.add("Random");
		color.addItemListener(this);
		add(color, BorderLayout.EAST);
		
		
		canvas=new Canvas();
		canvas.addMouseListener(this);
		canvas.setBackground(Color.white);
		add(canvas,BorderLayout.CENTER);
		
		label=new Label("["+shape.getItem(0)+" , "+color.getItem(0)+"]");
		add(label,BorderLayout.NORTH);
		
		s=shape.getItem(0);
		c=color.getItem(0);
		
		
		Button button=new Button("Clear");
		button.addActionListener(this);
		add(button,BorderLayout.SOUTH);
		
		setSize(1080,720);
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent e) {
		ItemSelectable selectable=e.getItemSelectable();
		Object affecteditem=e.getItem();
		
		if(selectable.equals(color)){
			c=(String) affecteditem;
			label.setText("["+s+" , "+c+"]");
			System.out.println("Color changed to "+c);
		}
		else{
			s=(String) affecteditem;
			label.setText("["+s+" , "+c+"]");
			System.out.println("Shape changed to "+s);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof Button){
			canvas.paint(canvas.getGraphics());
			System.out.println("Canvas Cleared");
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		Point p=e.getPoint();
		System.out.println("Mouse pressed at : "+p+", Drawing a "+c+" "+s);
		Graphics g=((Canvas)e.getSource()).getGraphics();
		
		if(c.equals("Red")){
			g.setColor(Color.red);
		}
		else if(c.equals("Green")){
			g.setColor(Color.green);
		}
		else if(c.equals("Blue")){
			g.setColor(Color.blue);
		}
		else{
			g.setColor(Color.getHSBColor((float)Math.random(), (float)Math.random(), (float)Math.random()));
		}
		
		if(s.equals("Circle")){
			drawCircle(p,g);
		}
		else if(s.equals("Arc")){
			drawArc(p,g);
		}
		else if(s.equals("Rectangle")){
			drawRect(p,g);
		}
		else{
			drawStar(p,g);
		}
		
	}
	private void drawCircle(Point p, Graphics g){
		int size=(int)(200*Math.random()+50);
		g.fillOval(p.x-size/2, p.y-size/2, size, size);
	}
	private void drawArc(Point p, Graphics g){
		int size=(int)(200*Math.random()+50);
		int angStart=(int)(360*Math.random());
		int ang=(int)(360*Math.random());
		g.fillArc(p.x-size/2, p.y-size/2,size,size, angStart, ang);
	}
	private void drawRect(Point p, Graphics g){
		int size1=(int)(200*Math.random()+50);
		int size2=(int)(200*Math.random()+50);
		g.fillRect(p.x-size1/2, p.y-size2/2,size1,size2);
	}
	/*
	private void drawStar(Point p, Graphics g){
		int a=(int)(200*Math.random()+50);
		int x=p.x;
		int y=p.y;
		int dim=(int) ((Math.sqrt(5)-1))/2;
		int[] xPoints=new int[]{(int) (x-a*Math.cos(Math.toRadians(54))),
				x,
				(int) (x+a*Math.cos(Math.toRadians(54))),
				(int) (x-a*Math.cos(Math.toRadians(54))+a*Math.cos(Math.toRadians(36))),
								(int) (x+a*Math.cos(Math.toRadians(18))),
								(int) (x+a*Math.cos(Math.toRadians(18))-a*Math.cos(Math.toRadians(36))),
								x, 
								(int) (x-a*Math.cos(Math.toRadians(18))+a*Math.cos(Math.toRadians(36))),
								(int) (x-a*Math.cos(Math.toRadians(18))),
								(int) (x+a*Math.cos(Math.toRadians(54))-a*Math.cos(Math.toRadians(36)))
								};
		int[] yPoints=new int[]{(int) (y+a*Math.sin(Math.toRadians(54))),
				(int) (y+a*Math.sin(Math.toRadians(54))-a*Math.cos(Math.toRadians(54))*Math.tan(Math.toRadians(36))),
				(int) (y+a*Math.sin(Math.toRadians(54))),
				(int) (y+a*Math.sin(Math.toRadians(54))-a*Math.sin(Math.toRadians(36))),
				(int) (y-a*Math.sin(Math.toRadians(18))),
				(int) (y-a*Math.sin(Math.toRadians(18))),
				y-a,
				(int) (y-a*Math.sin(Math.toRadians(18))),
				(int) (y-a*Math.sin(Math.toRadians(18))),
				(int) (y+a*Math.sin(Math.toRadians(54))-a*Math.sin(Math.toRadians(36)))
				};
		g.fillPolygon(xPoints, yPoints, 10);
	}
	//*/
	private void drawStar(Point p, Graphics g){
		int a=50;
		int b=a*(int)((3+Math.sqrt(5))/2);
		int x=p.x;
		int y=p.y;
		int dim=(int) ((Math.sqrt(5)-1))/2;
		int[] xPoints=new int[10];
		int[] yPoints=new int[10];
		
		for(int i=0;i<10;i++){
			if(i%2==0){
				xPoints[i]=(int)(x+a*Math.cos(Math.toRadians(36+72*i)));
				yPoints[i]=(int)(y+a*Math.sin(Math.toRadians(36+72*i)));
			}
			else{
				xPoints[i]=(int)(x+b*Math.cos(Math.toRadians(18+72*i)));
				yPoints[i]=(int)(y+b*Math.sin(Math.toRadians(18+72*i)));
			}
		}
		g.fillPolygon(xPoints, yPoints, 10);
	}
	
	
	public void mousePressed(MouseEvent e) {
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

	
	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		new MyCanvasMouseTest1();
	}
	}

