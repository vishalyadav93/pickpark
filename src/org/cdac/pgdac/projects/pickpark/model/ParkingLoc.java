package org.cdac.pgdac.projects.pickpark.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * The persistent class for the parking_loc database table.
 * 
 */
@Entity
@Table(name="parking_loc")
@NamedQuery(name="ParkingLoc.findAll", query="SELECT p FROM ParkingLoc p")
public class ParkingLoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	@Column(name="is_slot_avaialble")
	private byte isSlotAvaialble;

	private BigDecimal latitude;

	private BigDecimal longitude;

	@Column(name="no_of_floor")
	private int noOfFloor;

	private int zip;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="parkingLoc",fetch = FetchType.EAGER	)

	private List<Floor> listOfFloors=new ArrayList<>();
	
	public void addFloor(Floor f)
	{
		listOfFloors.add(f);
		f.setParkingLoc(this);
	}

	public ParkingLoc() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte getIsSlotAvaialble() {
		return this.isSlotAvaialble;
	}

	public void setIsSlotAvaialble(byte isSlotAvaialble) {
		this.isSlotAvaialble = isSlotAvaialble;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public int getNoOfFloor() {
		return this.noOfFloor;
	}

	public void setNoOfFloor(int noOfFloor) {
		this.noOfFloor = noOfFloor;
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
	

}