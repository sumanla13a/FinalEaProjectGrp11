package com.grp11.Order;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class OrderDao implements IOrderDao {
	@Autowired
	private IOrder Order;
	@Override
	public void createOrder(OrderDomain o) {
		System.out.println(Order.save(o).getClass().getName());
		Order.save(o);
	}
	@Override
	public OrderDomain updateOrder(OrderDomain o) {
		System.out.println(Order.save(o).getClass().getName());
		return Order.save(o);
	}
	@Override
	public OrderDomain getOrder(Long ordNum) {
		return Order.findOne(ordNum);
	}
	@Override
	public List<OrderDomain> getAllOrder() {
		return StreamSupport.stream(Order.findAll().spliterator(), false).collect(Collectors.toList());
	}
	@Override
	public void deleteOrder(Long ordNum) {
		Order.delete(ordNum);
	}
	@Override 
	public List<OrderDomain> getAllOrderForUser(long consumerId) {
		return Order.getAllOrderForUser(consumerId);
	}
	@Override 
	public List<OrderDomain> getAllUndeliveredOrder() {
		return Order.getAllUndeliveredOrder();
	}
	
}
