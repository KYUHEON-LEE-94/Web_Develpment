package namoo.springjpa.domain.order.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import namoo.springjpa.domain.order.entity.Order;

public interface JpaOrderRepository extends JpaRepository<Order, Long> {

}
