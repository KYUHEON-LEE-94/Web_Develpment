package namoo.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

public class AWTExample {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setSize(400, 200);
		frame.setVisible(true);
		
		Button btn = new Button("버튼");
		frame.add(btn);
		Color blue = new Color(321);
		Color red = new Color(121);
		
		btn.setBackground(blue);
		btn.setForeground(red);
		
		
		
	}

}
