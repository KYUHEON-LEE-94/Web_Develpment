package namoo.awt;

import java.awt.Frame;

public class GUIApplication {

	public static void main(String[] args) {
		Frame frame = new Frame("연습용 프레임");
		SomePanel2 panel =new SomePanel2();
		panel.init();
		frame.add(panel);
		frame.setSize(600,500);
		frame.setVisible(true);
		
		
	}

}
