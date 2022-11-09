package namoo.springbasic.guestbook.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import namoo.springbasic.guestbook.dto.Guestbook;
/*
 * 저장소 클래스
 * DB연결은 안함 
 */
@Repository
@Slf4j
public class MemoryGuestbookRepository implements GuestbookRepository {
	
	//메모리에 저장하는 DB
	private Map<Integer, Guestbook> repository = new HashMap<Integer, Guestbook>();
	//값 1씩 증가시키면서 시퀸스 값처럼 사용
	private static Integer sequence = 0;
	
	
	//서블릿의 init같은 느낌
	@PostConstruct
	public void init() {
		repository.put(++sequence, new Guestbook());
		repository.put(++sequence, new Guestbook());
	}

	@Override
	public void create(Guestbook guestbook) {
		repository.put(++sequence, guestbook);
		log.info("신규 방명록 작성 {}",guestbook);

	}

	@Override
	public List<Guestbook> findAll() {
		Collection<Guestbook> collections = repository.values();
		List<Guestbook> list = new ArrayList<Guestbook>();
		Iterator<Guestbook> it = collections.iterator();
		while (it.hasNext()) {
			Guestbook guestbook =  it.next();
			list.add(guestbook);
		}
		return list;
		
	}

}
