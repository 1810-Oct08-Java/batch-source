package com.revature.model;

import javax.persistence.*;

@Entity
@Table
public class Beehive {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="beehiveSequence")
	@SequenceGenerator(name="beehiveSequnce", allocationSize=1, sequenceName="SQ_BEEHIVE_PK")
	@Column(name="BEEHIVE_ID")
	private int id;
	
	@Column
	private int weight;
	
	public Beehive() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Beehive(int id, int weight) {
		super();
		this.id = id;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Beehive [id=" + id + ", weight=" + weight + "]";
	}
	
	
	
	
	
}
