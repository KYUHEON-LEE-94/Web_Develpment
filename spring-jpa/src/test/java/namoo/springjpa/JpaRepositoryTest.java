package namoo.springjpa;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.domain.member.entity.Member;
import namoo.springjpa.domain.member.repository.SpringDataJpaMemberRepositoryV2;
import namoo.springjpa.domain.team.entity.Team;
import namoo.springjpa.domain.team.repository.SpringDataJpaTeamRepositoryV2;

@SpringBootTest
@Slf4j
class JpaRepositoryTest {
	@Autowired
	private SpringDataJpaMemberRepositoryV2 memberRepositoryV2;
	
	@Autowired
	private SpringDataJpaTeamRepositoryV2 teamrepo;

	@Test
	public void saveTest() {
		// Team 생성 및 저장
		Team team = new Team();
		team.setName("TeamC");
		teamrepo.save(team);
		
		// Member 생성 및 저장
		Member member = new Member();
		member.setId("monday");
		member.setPassword("1111");
		member.setName("월요일");
		member.setAge(10);
		
		// 단방향 연관관계 매핑(객체 참조)
		member.setTeam(team); //위에 생성된 team정보를 넣어줌 
		memberRepositoryV2.save(member);
		log.info("팀 및 회원 등록 완료 : {}, {}", team, member);
	}


	@Test
	@Disabled
	public void findByIdTest() {
		// monday id를 조회해온다.
		Optional<Member> memberOptional = memberRepositoryV2.findById("monday");
		if (memberOptional.isPresent()) {
			Member findMember = memberOptional.get();
			
			// 참조를 통해 팀정보 조회
			Team findTeam = findMember.getTeam();
			log.info("회원 : {}, 팀 : {}", findMember, findTeam);
		}
	}

	@Test
	@Disabled
	public void updateTest() {
		// 새로운 팀 생성 및 회원 팀정보 변경
		Team newTeam = new Team();
		newTeam.setName("TeamB");
		teamrepo.save(newTeam);
		Optional<Member> memberOptional = memberRepositoryV2.findById("monday");
		if (memberOptional.isPresent()) {
			Member findMember = memberOptional.get();
			findMember.setTeam(newTeam);
			memberRepositoryV2.save(findMember);
			log.info("회원 팀 정보 변경 : {}", findMember);
		}
	}

}
