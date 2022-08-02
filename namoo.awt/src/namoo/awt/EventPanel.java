package namoo.awt;

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
import java.util.Iterator;
import java.util.concurrent.Flow;

import javax.swing.border.Border;

/*
 * 사용자 정의 윈도우
 */
public class EventPanel extends Panel {
	
	Panel menuPanel;
	Button searchB, deleteB;
	TextArea ta;
	TextField tf;
	Label status;
	
	public EventPanel() { 
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
	
	public void appendText(String message) {
		//포매터 활용
		ta.append(message+"\n");
	}
	
	
		
//		이벤트소스에 이벤트 등록
		public void eventRegist() {	
			
			class actionEventListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					Object eventSource= e.getSource();
					
					if(eventSource == searchB) {
						appendText("조회버튼이 클릭되었습니다.");	
					}else if(eventSource == deleteB) {
						appendText("삭제버튼이 클릭되었습니다.");
					}else {
						appendText(ta.getText()+"\n");
						tf.setText("");
						}
				
//					ta.setText("어잌후\n");					
			
			actionEventListener actionEL = new actionEventListener();
			searchB.addActionListener(actionEL);
			deleteB.addActionListener(actionEL);
			tf.addActionListener(actionEL);
		
				
		
			
			
			}
			
			
			

		}

////		멤버 내부클래스를 이영한 이벤트 리스너 구현		
//		class EventListner implements ActionListener {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			ta.append("조회버튼이 클릭되었습니다. \n");
////			ta.setText("어잌후");
//				
//			}
//			
//			
		} 
		
	
	
}
