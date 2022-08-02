package namoo.EXample;

import java.util.*;
import java.io.*;

/**
 * FriendDao 테스트를 위한 애플리케이션 클래스
 * @author 김기정
 */
public class  FriendExample{
	public static void main(String[] args) {
		
		FriendStorage friendDao = null;
		
		try{
			friendDao = new FriendStorage();
			
			// 파일에 친구(레코드) 추가 테스트
			friendDao.create(new Friend("김기정", 10, 61.34, "011-1111-8707"));
			friendDao.create(new Friend("김규빈", 20, 62.34, "010-2222-8707"));
			friendDao.create(new Friend("김정화", 30, 63.34, "010-3333-8707"));
			friendDao.create(new Friend("박세훈", 40, 64.34, "010-4444-8707"));
			friendDao.create(new Friend("서희상", 50, 65.34, "010-5555-8707"));
			friendDao.create(new Friend("윤성혁", 60, 66.34, "010-6666-8707"));
			System.out.println("친구 파일 저장 완료!");
			
			// 전체 리스트..
			System.out.println("***** 등록된 모든 친구 리스트(총 "+friendDao.getRecordCount()+"명) *****");
			List<Friend> list = friendDao.list();
			for (Friend friend : list) {
				System.out.println(friend.getName() + "\t" + friend.getAge() + "\t" + friend.getWeight() + "\t" + friend.getTelephone());
			}

			// 스트림 닫기
			friendDao.close();
			
		}catch(IOException e){
			e.printStackTrace();
		} 
	}
}
