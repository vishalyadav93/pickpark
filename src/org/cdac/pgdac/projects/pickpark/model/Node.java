package org.cdac.pgdac.projects.pickpark.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cascade;


/**
 * The persistent class for the node database table.
 * 
 */
@Entity
@NamedQuery(name="Node.findAll", query="SELECT n FROM Node n")
public class Node implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int columns;

	@ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.MERGE})

	@JoinColumn(name="floor_id", nullable=false)
	private Floor floor;

	@Column(name="is_occupied")
	private byte isOccupied;

	private int rows;

	private String type;

	public Node() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getColumns() {
		return this.columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}


	public byte getIsOccupied() {
		return this.isOccupied;
	}

	public void setIsOccupied(byte isOccupied) {
		this.isOccupied = isOccupied;
	}

	public int getRows() {
		return this.rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

}