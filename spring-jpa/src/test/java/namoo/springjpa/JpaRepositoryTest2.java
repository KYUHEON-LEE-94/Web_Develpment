package namoo.springjpa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.domain.member.entity.Member;
import namoo.springjpa.domain.member.repository.SpringDataJpaMemberRepositoryV2;
import namoo.springjpa.domain.team.entity.Team;
import namoo.springjpa.domain.team.repository.SpringDataJpaTeamRepositoryV2;

@SpringBootTest
@Slf4j
public class JpaRepositoryTest2 {
	@Autowired
	private SpringDataJpaMemberRepositoryV2 memberRepository;
	@Autowired
	private SpringDataJpaTeamRepositoryV2 teamRepository;

	@Test
	public void saveTest() {
// Team 생성 및 저장
		Team team = new Team();
		team.setName("KIA");
		teamRepository.save(team);
// Member 생성 및 저장
		Member member1 = new Member();
		
		member1.setId("monday");
		member1.setPassword("1111");
		member1.setName("월요일");
		member1.setAge(10);
		member1.setTeam(team);
// Member 생성 및 저장
		Member member2 = new Member();
		member2.setId("tuesday");
		member2.setPassword("1111");
		member2.setName("화요일");
		member2.setAge(10);
		member2.setTeam(team);
		memberRepository.save(member1);
		memberRepository.save(member2);
		log.info("팀 및 회원 등록 완료");
	}

	@Test
	@Transactional
	@Disabled
	public void findMembersTest() {
// Team을 통해서 Team 목록 조회
		Optional<Team> teamOptional = teamRepository.findById(1L);  //Long타입임을 알려주는 접미사
		if (teamOptional.isPresent()) {
			Team findTeam = teamOptional.get();
			log.info("팀명 : {}", findTeam.getName());
			List<Member> members = findTeam.getMembers();
			for (Member member : members) {
				log.info("회원명 : {}", member.getName());
			}
		}
	}
}