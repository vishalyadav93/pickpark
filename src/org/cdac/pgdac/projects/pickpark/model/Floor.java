package org.cdac.pgdac.projects.pickpark.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;


/**
 * The persistent class for the floor database table.
 * 
 */
@Entity
@NamedQuery(name="Floor.findAll", query="SELECT f FROM Floor f")
public class Floor implements Serializable {
	private static final long serialVersionUID = 19898666;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="floor_number")
	private int floorNumber;

	@Column(name="is_full")
	private byte isFull;

		

	@Column(name="total_columns")
	private int totalColumns;

	@Column(name="total_rows")
	private int totalRows;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="floor",fetch = FetchType.EAGER)
	private List<Node> nodes=new ArrayList();
	
	
	@ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.MERGE})

	@JoinColumn(name="parking_loc_id", nullable=false)
	private ParkingLoc parkingLoc;

	public void addNode(Node node)
	{
		nodes.add(node);
		node.setFloor(this);
	}
	
	public Floor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFloorNumber() {
		return this.floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public byte getIsFull() {
		return this.isFull;
	}

	public void setIsFull(byte isFull) {
		this.isFull = isFull;
	}


	public int getTotalColumns() {
		return this.totalColumns;
	}

	public void setTotalColumns(int totalColumns) {
		this.totalColumns = totalColumns;
	}

	public int getTotalRows() {
		return this.totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public ParkingLoc getParkingLoc() {
		return parkingLoc;
	}

	public void setParkingLoc(ParkingLoc parkingLoc) {
		this.parkingLoc = parkingLoc;
	}

	

}