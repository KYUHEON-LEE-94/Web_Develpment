package namoo.ams;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AMS {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
				
		//신규계좌 등록
		inventory.open(new Account("1111-2222","이규헌",1234,10000000));
		inventory.open(new MinusAccount("1111-3333","이규헌",134,2321, 12340));
		inventory.open(new Account("2222-5678","이규헌",124,2340000));
		inventory.open(new MinusAccount("1111-234","김규헌",123, 231,345000));
		inventory.open(new MinusAccount("1111-234","이규헌",123, 231,345000));
		inventory.open(new MinusAccount("1111-234","박규헌",123, 231,345000));
	
		Frame frame = new Frame(Account.bankName+"계좌 관리 프로그램 화면");
		EventPanel panel = new EventPanel(inventory);
		panel.init();
		panel.eventRegist();
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(500,600);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
	
		
		
		
	}

}
