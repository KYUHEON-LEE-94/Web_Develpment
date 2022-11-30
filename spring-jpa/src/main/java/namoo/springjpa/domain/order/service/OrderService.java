package namoo.springjpa.domain.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.domain.order.entity.Order;
import namoo.springjpa.domain.order.exception.NotEnoughMoneyException;
import namoo.springjpa.domain.order.repository.JpaOrderRepository;

@Service
@Slf4j
public class OrderService {
	@Autowired
	private JpaOrderRepository orderRepository;

	@Transactional
	//@Transactional(rollbackFor = NotEnoughMoneyException.class)
	public void order(Order order) throws NotEnoughMoneyException {
		log.info("===== order() 메소드 호출됨 =====");
		orderRepository.save(order);
		log.info(">> 결제 프로세스 진입");
		
	if (order.getUsername().equals("런타임예외님")) {
		//RuntimeException이 발생시 - 이건 Rollback됨
		log.info("※ 시스템(런타임) 예외 발생 ※");
		throw new RuntimeException("시스템(런타임) 예외발생하였습니다.");
		
	} else if (order.getUsername().equals("잔고부족님")) {
		//Rollback되지 않고 지금까지 입력한 정보들을 DB에 저장해서 기록을 남겨놓고, 고객이 추후에 그 정보 그대로 결제할 수 있도록 예외발생
		log.info("※ 잔고 부족 비즈니스 예외 발생 ※");
		order.setPayStatus("정상승인");
		throw new NotEnoughMoneyException("고객님 잔고가 부족합니다");
		
	} else {
		// 정상 승인
		log.info(">> 정상 승인");
		order.setPayStatus("완료");
	}
		log.info(">> 결제 프로세스 완료");
		log.info("===== order() 메소드 종료 =====");
	}

}
