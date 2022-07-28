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
import java.awt.Window;
import java.util.Iterator;
import java.util.concurrent.Flow;

import javax.swing.border.Border;

/*
 * 사용자 정의 윈도우
 */
public class SomePanel extends Panel {
	
	Panel menuPanel;
	Button searchB, deleteB;
	TextArea ta;
	Label status;
	
	public SomePanel() { 
		searchB = new Button("조회");
		deleteB = new Button("삭제");
		menuPanel = new Panel();
		ta = new TextArea();
		status = new Label("This copyright...");
	}
	
	//화면 배치
	public void init() {
		
//		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		setLayout(new BorderLayout());
		menuPanel.add(searchB);
		menuPanel.add(deleteB);
		
//		searchB.setBackground(new Color(255,205,255));
//		searchB.setBackground(Color.white);
		
		
		
		//pannel의 default는 Flowlayout이다.
		//굳이 중앙 정렬이 아니라 왼쪽 정렬을 하고싶다면 아래처럼
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
	
}
