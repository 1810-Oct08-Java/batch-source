package com.revature.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Bear {
	
	@Id
	@Column(name="BEAR_ID")
	private int id;
	
	@Column(name="BEAR_NAME")
	private String name;
	
	private Date birthday;
	
	@ManyToOne
	@JoinColumn(name="CAVE_ID")
	private Cave cave;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="BEAR_BEEHIVE",
			joinColumns= {@JoinColumn(name="BEAR_ID")},
			inverseJoinColumns = {@JoinColumn(name="BEEHIVE_ID")})
	private List<Beehive> beehives = new ArrayList<>();

	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bear(int id, String name, Date birthday, Cave cave, List<Beehive> beehives) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.cave = cave;
		this.beehives = beehives;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	public List<Beehive> getBeehives() {
		return beehives;
	}

	public void setBeehives(List<Beehive> beehives) {
		this.beehives = beehives;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", birthday=" + birthday + ", cave=" + cave + ", beehives="
				+ beehives + "]";
	}
	
	
	

}
