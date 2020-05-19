package com.youcode.ecommerce.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Client extends User {

	private static final long serialVersionUID = -5500533206342276021L;

	@Column(name = "first_name")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 26)
	private String firstName;

	@Column(name = "last_name")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 26)
	private String lastName;

	@Column(name = "city")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 100)
	private String city;

	@Column(name = "state")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 40)
	private String state;

	@Column(name = "zip")
	@Pattern(regexp = "^[0-9]*$")
	@Size(min = 5, max = 6)
	private String zip;

	@Column(name = "email_verified")
	private Integer emailVerified;

	@Column(name = "phone")
	@Pattern(regexp = "[0-9]+")
	@Size(min = 11, max = 12)
	private String phone;

	@Column(name = "country")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 40)
	private String country;

	@Column(name = "address")
	@Pattern(regexp = "[0-9a-zA-Z #,-]+")
	@Size(min = 3, max = 240)
	private String address;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@NotNull
	private List<Review> reviews;

	@OneToMany
	@JoinColumn(name = "order_detail_id")
	private List<OrderDetail> orderDetails;

	public Client() {
		super();

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Integer getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Integer emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Client [ firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", emailVerified=" + emailVerified + ", phone=" + phone + ", country=" + country
				+ ", address=" + address + ", reviews=" + reviews + ", orderDetails=" + orderDetails + "]";
	}

}
