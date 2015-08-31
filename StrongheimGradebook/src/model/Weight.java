package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the WEIGHTS database table.
 * 
 */
@Entity
@Table(name="WEIGHTS", schema="TESTDB")
@NamedQuery(name="Weight.findAll", query="SELECT w FROM Weight w")
public class Weight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AS_TYPE")
	private String asType;

	private BigDecimal weight;

	public Weight() {
	}

	public String getAsType() {
		return this.asType;
	}

	public void setAsType(String asType) {
		this.asType = asType;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

}