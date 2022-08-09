package chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NamooTalk {

	public static void main(String[] args) {
		Frame frame = new Frame("⊙⊙ 즐거운 대화 나누세요 ⊙⊙");
		ChatPanel panel = new ChatPanel();
		panel.init();
		panel.eventRegist();
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(400, 500);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
