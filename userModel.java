package myprojectdemo.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="web_user_reg")
public class userModel implements Serializable
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 25)
	private String name;
	
	@Column(length = 12)
	private long number;
	
	private String gender;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cid")
	private countryModel c; 
	
	private String address;
	
	@ElementCollection(targetClass=String.class)
	private List<String> hob;
	
	private double price;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date bdate;
	
	@Column(nullable=false)
	private String filename;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m")
	List<childModel> ch = new ArrayList<childModel>(0);
	
	

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
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

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public countryModel getC() {
		return c;
	}

	public void setC(countryModel c) {
		this.c = c;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getHob() {
		return hob;
	}

	public void setHob(List<String> hob) {
		this.hob = hob;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<childModel> getCh() {
		return ch;
	}

	public void setCh(List<childModel> ch) {
		this.ch = ch;
	}

	public userModel() {
		super();
	}

	public userModel(int id) {
		super();
		this.id = id;
	}
	
	
	
	
	

}
