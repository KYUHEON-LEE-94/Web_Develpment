package namoo.springjpa.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import namoo.springjpa.domain.member.entity.Member;

@Repository
@Transactional
public interface SpringDataJpaMemberRepositoryV2 extends JpaRepository<Member, String> {

}
