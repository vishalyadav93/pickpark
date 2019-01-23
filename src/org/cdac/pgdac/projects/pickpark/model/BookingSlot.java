package org.cdac.pgdac.projects.pickpark.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the booking_slot database table.
 * 
 */
@Entity
@Table(name="booking_slot")
@NamedQuery(name="BookingSlot.findAll", query="SELECT b FROM BookingSlot b")
public class BookingSlot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;
	
	@Column(name="time_slot")
	private int timeSlot;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name="node_id")
	private int nodeId;

	public BookingSlot() {
	}

	public int getTimeslot() {
		return this.timeSlot;
	}

	public void setTimeslot(int timeslot) {
		this.timeSlot = timeslot;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNodeid() {
		return this.nodeId;
	}

	public void setNodeid(int nodeid) {
		this.nodeId = nodeid;
	}

}