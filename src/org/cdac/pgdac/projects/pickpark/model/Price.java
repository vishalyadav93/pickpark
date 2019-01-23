package org.cdac.pgdac.projects.pickpark.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

enum VEHICLE_TYPE{
	LMV,HMV,TW
}

/**
 * The persistent class for the price database table.
 * 
 */
@Entity
@Embeddable
@NamedQuery(name="Price.findAll", query="SELECT p FROM Price p")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private BigDecimal baseprice;

	private String type;

	public Price() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getBaseprice() {
		return this.baseprice;
	}

	public void setBaseprice(BigDecimal baseprice) {
		this.baseprice = baseprice;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}