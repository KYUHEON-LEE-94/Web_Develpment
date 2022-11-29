package namoo.springjpa.domain.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import namoo.springjpa.domain.team.entity.Team;

@Repository
@Transactional
public interface SpringDataJpaTeamRepositoryV2 extends JpaRepository<Team, Long> {

}
