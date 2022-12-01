package namoo.springjpa.domain.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders") // order는 DB 예약어로 테이블 이름으로 사용할 수 없다. (ORDER BY 예약어가 있어서..)
@SequenceGenerator(
	name = "order_seq_gen",
	sequenceName = "order_seq",
	allocationSize = 1)
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
	private Long id;
	private String username;
	private String paystatus; // 대기, 완료

}
