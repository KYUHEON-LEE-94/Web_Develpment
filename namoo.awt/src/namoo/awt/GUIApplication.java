package namoo.awt;

import java.awt.Frame;

public class GUIApplication {

	public static void main(String[] args) {
		Frame frame = new Frame("연습용 프레임");
//		SomePanel panel =new SomePanel();
//		SomePanel2 panel =new SomePanel2();
		GridBackLaoyoutPanel panel = new GridBackLaoyoutPanel();
		panel.init();
		panel.eventRegist();
		frame.add(panel);
		frame.setSize(600,500);
		frame.setVisible(true);
		frame.addWindowListener(new UserEventListner());
		
	}

}

