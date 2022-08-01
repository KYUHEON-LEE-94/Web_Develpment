package namoo.ams;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Flow;

import javax.swing.border.Border;

/*
 * 사용자 정의 윈도우
 */
public class EventPanel extends Panel {
	
	Inventory inventory = new Inventory();
	
	Panel menuPanel;
	Button searchB, deleteB;
	TextArea ta;
	TextField tf;
	Label status;
	
	public EventPanel(Inventory inven) {
		this.inventory = inven;
		searchB = new Button("조회");
		deleteB = new Button("삭제");
		menuPanel = new Panel();
		ta = new TextArea();
		status = new Label("This copyright...");
		tf = new TextField(20);
	}
	

	public void init() {
		

		setLayout(new BorderLayout());
		menuPanel.add(searchB);
		menuPanel.add(deleteB);
		menuPanel.add(tf);
		menuPanel.add(ta);

		menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(menuPanel, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(status, BorderLayout.SOUTH);
		
		Component[] components= menuPanel.getComponents(); //component의 자식인 panel이기떄문에 기본적으로 getcomponents메소드가 있음.
		System.out.println(components);
		for (Component component : components) {
			if(component instanceof Button) {
				component.setBackground(new Color(255,205,255));
				component.setForeground(Color.white);
			}
		}
	}
	
	public void printheader() {
		//포매터 활용
		ta.append("계좌번호 \t 예금주명 \t ");
	}
	
	public void appendText(String message) {
		ta.append(message+"\n");
	}

	public void appendList(Collection<Account> list){
		if(list.isEmpty()) {
			appendText("조회된 목록이 없습니다.");
		} 
		Iterator<Account> it = list.iterator();
		while (it.hasNext()) {
			Account account = (Account) it.next();
			appendText(account.toString());
		}
		
	}
	
		
//		이벤트소스에 이벤트 등록
		public void eventRegist() {	
			
			class actionEventListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					
					Object eventSource= e.getSource();		
					
					if(eventSource == searchB) {
						printheader();
						appendList(inventory.getAccounts());
						
					}
					else {
						appendText(ta.getText()+"\n");
						tf.setText("");
						}
			}	

		}
			actionEventListener actionEL = new actionEventListener();
			searchB.addActionListener(actionEL);
			deleteB.addActionListener(actionEL);
			tf.addActionListener(actionEL);

		} 
		
	
	
}
