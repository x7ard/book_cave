package com.youcode.ecommerce.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
public class Order extends AuditEntities {

	private static final long serialVersionUID = 8649738082751827827L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int amount;

	@ManyToOne
	@JoinColumn(name = "order_detail_id")
	@JsonIgnoreProperties("orders")
	@JsonIgnore
	private OrderDetail orderDetail;

	@ManyToOne
	@JoinColumn(name = "ebook_id")
	private Ebook ebook;

	public Order() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Ebook getEbook() {
		return ebook;
	}

	public void setEbook(Ebook ebook) {
		this.ebook = ebook;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", amount=" + amount + ", orderDetail=" + orderDetail + ", ebook=" + ebook + "]";
	}

}
