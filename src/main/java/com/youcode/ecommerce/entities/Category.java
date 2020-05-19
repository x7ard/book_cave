package com.youcode.ecommerce.entities;

import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category extends AuditEntities {

	private static final long serialVersionUID = -2041894579972741705L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "label", nullable = false)
	private String label;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category parentCategory;

	@OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
	private List<Category> subCategories;

	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Ebook> ebooks;

	public void checkCategory() {
		if (this.subCategories == null) {
			List<Category> subCategories = new ArrayList<Category>();
			this.setSubCategories(subCategories);
		}

	}

	public Category() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Ebook> getEbooks() {
		return ebooks;
	}

	public void setEbooks(List<Ebook> ebooks) {
		this.ebooks = ebooks;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", label=" + label + ", category=" + parentCategory + ", subCategories="
				+ subCategories + ", ebooks=" + ebooks + "]";
	}

}
