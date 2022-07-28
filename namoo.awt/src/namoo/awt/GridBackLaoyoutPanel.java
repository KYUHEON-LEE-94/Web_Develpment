package namoo.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.Flow;

import javax.swing.border.Border;

/*
 * 사용자 정의 윈도우
 */
public class GridBackLaoyoutPanel extends Panel implements ActionListener{
	Button btn1, btn2, btn3, btn4;
	Choice choice;
	TextField tf;
	TextArea ta;
	Checkbox checkbox;
	Checkbox manCB, womanCB;
	GridBagLayout gridbagLayout = new GridBagLayout();
	GridBagConstraints gridBagConstraints = new GridBagConstraints();

	
	public GridBackLaoyoutPanel() { 
		btn1 = new Button("버튼1");
		btn2 = new Button("버튼2");
		btn3 = new Button("버튼3");
		btn4 = new Button("버튼4");
		choice = new Choice();
		
		Accounts[] account = Accounts.values();
		for (Accounts accounts : account) {
			choice.add(accounts.getName());
		}
		
		tf = new TextField("아이디", 10);
//		tf.setEnabled(false);
		checkbox = new Checkbox("입출금 계좌", true);
		CheckboxGroup group = new CheckboxGroup();
		manCB = new Checkbox("남자",false,group);
		womanCB = new Checkbox("여자",true,group);
		
		ta = new TextArea(10,50);
		
		
	}
	
	//화면 배치
	public void init() {
		setLayout(gridbagLayout);
		
		
		add(btn1, 	  0, 0, 2, 1,  0.1,  0.1, 	gridBagConstraints.BOTH);
		add(btn2,	  2, 0, 1, 2,  0.1,  0.1, 	gridBagConstraints.BOTH);
		add(btn3,	  0, 1, 1, 1,  0.1,  0.1, 	gridBagConstraints.BOTH);
		add(btn4, 	  1, 1, 1, 1,  0.1,  0.1, 	gridBagConstraints.BOTH);
		add(choice,   0, 2, 1, 1,  0.1,  0.1, 	gridBagConstraints.BOTH);
		add(tf,		  0, 3, 1, 1,  0.1,  0.1,    gridBagConstraints.HORIZONTAL);
		add(checkbox, 0, 4, 1, 1,  0.1,  0.1,    gridBagConstraints.NONE );
		add(manCB,    0, 5, 1, 1,  0.1,  0.1,    gridBagConstraints.NONE );
		add(womanCB,  1, 5, 1, 1,  0.1,  0.1,    gridBagConstraints.NONE );
		add(ta,  	  0, 6, 3, 2,  0.1,  0.1,    gridBagConstraints.BOTH );
	}
	
	
	
//	이벤트 소스에 이벤트리스너 등록
	public void eventRegist() {
		UserEventListner listner = new  UserEventListner();
		btn1.addMouseListener(listner);
		btn2.addActionListener(listner);
		tf.addActionListener(listner);
		btn3.addActionListener(this);
	}
	
	
	
	
	//gridbaglayout을 이용한 컴포넌트 배치 메서드
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int fill) {
	
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = fill; 
		gridbagLayout.setConstraints(component, gridBagConstraints);
		gridBagConstraints.insets = new Insets(2, 10, 2, 10);

	
		add(component);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		this.setBackground(Color.yellow);
		btn3.setBackground(Color.blue);
		
	}
	
}
