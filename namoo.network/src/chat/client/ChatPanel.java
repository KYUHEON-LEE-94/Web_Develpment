package chat.client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * 대화방 패널
 */
public class ChatPanel extends Panel {
	Panel northPanel, southPanel;
	Label nickNameL;
	TextField nickNameTF, inputTF;
	Button connectB, sendB;
	TextArea messageTA;
	List userList;
	Choice userChoice;
	
	ChatClient chatclient;
	String nickName;

	public ChatPanel() {
		northPanel = new Panel();
		southPanel = new Panel();
		nickNameL = new Label("NickName", Label.CENTER);
		nickNameL.setBackground(Color.white);
		nickNameTF = new TextField();
		inputTF = new TextField();
		connectB = new Button("Connect");
		connectB.setPreferredSize(new Dimension(125, 15)); //버튼의 크기를 조절할 수 있는 메서드
		sendB = new Button("Send");
		sendB.setPreferredSize(new Dimension(125, 15));
		messageTA = new TextArea();
		userList = new List();
//		userList.add("방그리");
//		userList.add("손오공");
//		userList.add("사오정");
//		userList.add("저팔계");
		userChoice = new Choice();
//		userChoice.setPreferredSize(new Dimension(80, 50));
		userChoice.add("전체에게");
//		userChoice.add("방그리");
//		userChoice.add("손오공");
//		userChoice.add("사오정");
//		userChoice.add("저팔계");
	}

	/** 컴포넌트 배치 */
	public void init() {
		setLayout(new BorderLayout());
		northPanel.setLayout(new BorderLayout());
		northPanel.add(nickNameL, BorderLayout.WEST);
		northPanel.add(nickNameTF, BorderLayout.CENTER);
		northPanel.add(connectB, BorderLayout.EAST);
		//--------------------------------//
		southPanel.setLayout(new BorderLayout());
		southPanel.add(userChoice, BorderLayout.WEST);
		southPanel.add(inputTF, BorderLayout.CENTER);
		southPanel.add(sendB, BorderLayout.EAST);
		add(northPanel, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(userList, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	
	/** 텍스트필드 입력여부 검증 */
	private boolean isEmpty(String string) {
		//입력된 값이 없거나, 공백을 제거했을 때 닉네임의 길이가 0인지를 체크
		if (string == null || string.trim().length() == 0) {
			//true값이 나오면 해당 if문안을 들어가면서 닉네임을 입력해달라는 문구를 띄우고,
			return true;
		}
		//false면 해당 if문을 들어가지않고 통과
		return false;
	}

	/** 서버 연결 */
	public void connect() {
		nickName = nickNameTF.getText();
		//isEmpty 메서드를 호출
		if (isEmpty(nickName)) {
			System.out.println("Please write yout nikcname");
			return;
		}
		
		try {
			//ChatClient 클래스와 ChatPanel을 연결
			chatclient = new ChatClient(this);
			chatclient.receiveMessage();//항상 수신받을 수 있는 스레드 실행, 해당 메서드가 지속적으로 TextArea에 메시지를 뿌려주는중
			
			//스레드를 먼저 실행하고 아래의 메시지를 전송 접속한 닉네임 전송
			String connectMessage = "CONNCECT!" + nickName; //"구분자" + nickname
			chatclient.sendMessage(connectMessage);  //서버에서 닉네임과 보내는 메시지의 구분을 위하여 구분자를 설정
		
		}catch (IOException e) {
			appendMessage("채팅 서버에 연결할 수 없습니다.");
		}
		

		//nickNameTF.setText("[" + nickName + "]님 대화 참여중...");
		nickNameTF.setEditable(false); //성공적으로 닉네임을 입력받으면 해당 TF를 변경 불가능하게 false 설정
		nickNameTF.setEnabled(false); //커서도 입력이 안되게 하는 설정
		connectB.setLabel("Exit");
		inputTF.requestFocus(); //닉네임이 정상적으로 설정되면 inputTF에 커서가 바로 옮겨감
	}
	
	
	/** 서버 연결 종료 */
	public void disConnect() {
		String disConnectMessage = "DISCONNECT!"+nickName;
		chatclient.sendMessage(disConnectMessage);
		chatclient.close();
	}
	///---//
	

	/** 메시지 전송 */
	public void sendMessage() {
		String message = inputTF.getText();
		// 유효성 검증
		if (isEmpty(message)) {
			return;
		}
		//서버에 전송
		String chatmessage = "CHAT!"+nickName+"!"+message;
		chatclient.sendMessage(chatmessage);
		inputTF.setText("");
		inputTF.requestFocus();
	}

	/** 닉네임 선택 */
	public void selectUser() {
		messageTA.append(userList.getSelectedItem() + "님을 선택하였습니다..\n");
	}

	/**
	 * 메시지창에 메시지 추가
	 */
	public void appendMessage(String message) {
		messageTA.append(message +"\n");
	}
	
	
	public void appendUserItem(String csv) {
		String[] tokens = csv.split(",");
		for (String nickname : tokens) {
			userList.add(nickname);
			userChoice.add(nickname);
			
		}
	}
	
	
	/**
	 * 이벤트소스에 이벤트 처리
	 */
	public void eventRegist() {
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object eventSource = e.getSource();
				// 	connectB를 누르거나, 	nickNameTF에서 엔터를 치거나
				if(eventSource == connectB || eventSource == nickNameTF) {
					//버튼이 exit일 때는 disConnect();를 호출한다.
					if(e.getActionCommand().equalsIgnoreCase("exit")){
						disConnect();
					}else {
						connect();
					}
				} else if(eventSource == sendB || eventSource == inputTF) {
					sendMessage();
				}
			}
		};
		connectB.addActionListener(actionListener);
		nickNameTF.addActionListener(actionListener);
		sendB.addActionListener(actionListener);
		inputTF.addActionListener(actionListener);
		
		userList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					selectUser();
				}
			}
		});
	}
}
