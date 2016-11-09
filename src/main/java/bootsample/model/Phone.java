package bootsample.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="phone")
public class Phone implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="phone_id")
	private int phone_id;
	@Column(name="phonenumber",unique=true)
	private long phoneNumber;
	@Column(name="description")
	private String desc;
	@JsonIgnore
	@ManyToMany(targetEntity=User.class)
	private Set users;
	@OneToOne
	private Address address;
	public Phone(){
		
	}
	public Phone(long phoneNumber, String desc,Address address) {
		super();
		this.phoneNumber = phoneNumber;
		this.desc = desc;
		this.address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public String getDesc() {
		return desc;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Set getUsers() {
		return users;
	}
	public void setUsers(Set users) {
		this.users = users;
	}
	@JsonIgnore
	public Address getAddress() {
		return address;
	}
	@JsonProperty
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Phone [phone_id=" + phone_id + ", phoneNumber=" + phoneNumber + ", desc=" + desc + ", users=" + users
				+ "]";
	}
	
	
	

}
