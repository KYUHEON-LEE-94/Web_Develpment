package namoo.awt;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class UserEventListner implements MouseListener, WindowListener, ActionListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) System.out.println("left");
		System.out.println(e.getButton());
		System.out.println("Event....");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Button pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Do not realese, Hold it!");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Hover");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	
//	===============윈도우 메서드===========	
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0); // 0이 정상 종료
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
//	=======액션 리스너==========================
	
	@Override
	public void actionPerformed(ActionEvent e) { //내부클래스로 하는게 좋음
		String command = e.getActionCommand(); //라벨로 불러옴, 권장 사항 아님
		if(command.equals("버튼2")) {
		 System.out.println("btn2 clicked");
		}else {
			System.out.println("textField Entered...");
		}
		
	}
	
	
	
	

}
