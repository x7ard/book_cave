package com.youcode.ecommerce.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderDetail extends AuditEntities {

	private static final long serialVersionUID = -6865310756480165908L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "city")
	@Size(min = 3, max = 100)
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@NotBlank
	private String city;

	@Column(name = "state")
	@Size(min = 3, max = 40)
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	private String state;

	@Column(name = "zip")
	@Size(min = 5, max = 6)
	@Pattern(regexp = "^[0-9]*$")
	@NotBlank
	private String zip;

	@Column(name = "country")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 40)
	@NotBlank
	private String country;

	@Column(name = "phone")
	@Pattern(regexp = "[0-9]+")
	@Size(min = 11, max = 12)
	@NotBlank
	private String phone;

	@Column(name = "total_price")
	private Float totalPrice;

	@Column(name = "total_cargo_price")
	private Float totalCargoPrice;

	@Column(name = "shipped")
	private Integer shipped;

	@Column(name = "tracking_number")
	private String trackingNumber;

	@OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
	private List<Shipping> shipping;

	@OneToOne
	@JoinColumn(name = "discount_id")
	private Discount orderDiscount;

	@ManyToOne
	@JoinColumn(name = "client_id")
	@JsonIgnore
	private Client client;

	@OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
	private List<Order> orders;

	public OrderDetail() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Float getTotalCargoPrice() {
		return totalCargoPrice;
	}

	public void setTotalCargoPrice(Float totalCargoPrice) {
		this.totalCargoPrice = totalCargoPrice;
	}

	public Integer getShipped() {
		return shipped;
	}

	public void setShipped(Integer shipped) {
		this.shipped = shipped;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public List<Shipping> getShipping() {
		return shipping;
	}

	public void setShipping(List<Shipping> shipping) {
		this.shipping = shipping;
	}

	public Discount getOrderDiscount() {
		return orderDiscount;
	}

	public void setOrderDiscount(Discount orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country
				+ ", phone=" + phone + ", totalPrice=" + totalPrice + ", totalCargoPrice=" + totalCargoPrice
				+ ", shipped=" + shipped + ", trackingNumber=" + trackingNumber + ", shipping=" + shipping
				+ ", orderDiscount=" + orderDiscount + ", client=" + client + ", orders=" + orders + "]";
	}

}
