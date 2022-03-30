package com.cg.creditcardpayment.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="Payment_info")
public class Payment implements Serializable {

	@Id
	@SequenceGenerator(name = "cardIdGen", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cardIdGen")
	private long paymentId;
	private String type;
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cardId")
	private CreditCard card;
	
	
	public long getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CreditCard getCard() {
		return card;
	}
	public void setCard(CreditCard card) {
		this.card = card;
	}

}
