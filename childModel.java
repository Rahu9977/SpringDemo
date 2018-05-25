package myprojectdemo.web.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="web_child")
public class childModel implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="chid")
	private int ch_id;
	@Column(length=25)
	private String fname;
	@Column(length=255)
	private String addr;
	@Column(length=6)
	private String gender;
	
	@ManyToOne(fetch = FetchType.LAZY)
	
	@JoinColumn(name="mas_id")
	private userModel m;

	public childModel(String fname, String addr, String gender, userModel m) {
		super();
		this.fname = fname;
		this.addr = addr;
		this.gender = gender;
		this.m = m;
	}

	public int getCh_id() {
		return ch_id;
	}

	public String getFname() {
		return fname;
	}

	public String getAddr() {
		return addr;
	}

	public String getGender() {
		return gender;
	}

	public userModel getM() {
		return m;
	}

	public childModel() {
		super();
	}
	
	
	
	
	
	
	
}
