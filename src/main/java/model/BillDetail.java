package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "bill_details")
public class BillDetail implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(name = "denomination")
	private String denomination;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "subtotal")
	private int subtotal;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_bill")
	private Bill bill;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_article")
	private Article article;

	public BillDetail() {
	}

	public BillDetail(String denomination, int quantity, int subtotal, Bill bill) {
		this.denomination = denomination;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.bill = bill;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int price) {
		this.subtotal = price;
	}
}
