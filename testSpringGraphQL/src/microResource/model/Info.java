package microResource.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "info")
public class Info {

	private int id;
	private String truename;
	private String address;
	private User user;

	public Info(int id, String truename, String address, User user) {
		super();
		this.id = id;
		this.truename = truename;
		this.address = address;
		this.user = user;
	}

	public Info() {
	}

	@Override
	public String toString() {
		return "Info [id=" + id + ", truename=" + truename + ", address=" + address + ", user=" + user + "]";
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToOne
	@JoinColumn(name = "user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
