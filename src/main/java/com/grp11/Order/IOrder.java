package com.grp11.Order;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IOrder extends CrudRepository<OrderDomain, Long> {
	@Query("SELECT o FROM OrderDomain o WHERE o.consumer.id = :consumerId and o.isPaid != true")
	public List<OrderDomain> getAllOrderForUser(@Param("consumerId") long consumerId);
	@Query("SELECT o FROM OrderDomain o WHERE o.isDelivered != true")
	public List<OrderDomain> getAllUndeliveredOrder();
}
