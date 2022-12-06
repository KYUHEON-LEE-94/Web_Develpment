package namoo.allinone.domain.member.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import namoo.allinone.domain.member.entity.Member;
import namoo.allinone.domain.member.repository.JpaMemberRepository;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private JpaMemberRepository jpaMemberRepository;
	
	@Override
	public String register(Member member) {
		Member saveMember = jpaMemberRepository.save(member);
		return saveMember.getId();
	}

	@Override
	//@Transactional(readOnly = true)
	public Member isMember(String id, String password) {
		return jpaMemberRepository.findByIdAndPassword(id, password);
	}

	@Override
	public Optional<Member> findMember(String id) {
		return jpaMemberRepository.findById(id);
	}

	@Override
	public List<Member> findMembers() {
		return jpaMemberRepository.findAll();
	}

	@Override
	public Page<Member> findMembers(String searchValue, Pageable pageable) {
		return jpaMemberRepository.findAllByIdOrNameContaining(searchValue, searchValue, pageable);
	}

}
