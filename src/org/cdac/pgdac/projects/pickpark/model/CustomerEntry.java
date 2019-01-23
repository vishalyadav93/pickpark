package org.cdac.pgdac.projects.pickpark.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the customer_entry database table.
 * 
 */
@Entity
@Table(name="customer_entry")
@NamedQuery(name="CustomerEntry.findAll", query="SELECT c FROM CustomerEntry c")
public class CustomerEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;

	private int cost;

	@Column(name="customer_id")
	private int customerId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="exact_entry_time")
	private Date exactEntryTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="exact_exit_time")
	private Date exactExitTime;

	@Column(name="is_paid")
	private byte isPaid;

	private BigInteger penalty;

	public CustomerEntry() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getExactEntryTime() {
		return this.exactEntryTime;
	}

	public void setExactEntryTime(Date exactEntryTime) {
		this.exactEntryTime = exactEntryTime;
	}

	public Date getExactExitTime() {
		return this.exactExitTime;
	}

	public void setExactExitTime(Date exactExitTime) {
		this.exactExitTime = exactExitTime;
	}

	public byte getIsPaid() {
		return this.isPaid;
	}

	public void setIsPaid(byte isPaid) {
		this.isPaid = isPaid;
	}

	public BigInteger getPenalty() {
		return this.penalty;
	}

	public void setPenalty(BigInteger penalty) {
		this.penalty = penalty;
	}

}