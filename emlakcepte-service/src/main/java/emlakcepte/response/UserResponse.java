package emlakcepte.response;

import java.util.List;

import emlakcepte.client.RealtyPackage;
import emlakcepte.model.enums.UserStatus;
import emlakcepte.model.enums.UserType;


public class UserResponse {
	
	private Integer id;
	private String name;
	private String email;
	private UserType type;
	private UserStatus status;
	private List<RealtyPackage> realtyPackageList;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	public List<RealtyPackage> getRealtyPackageList() {
		return realtyPackageList;
	}
	public void setRealtyPackageList(List<RealtyPackage> realtyPackageList) {
		this.realtyPackageList = realtyPackageList;
	}
	@Override
	public String toString() {
		return "UserResponse [id=" + id + ", name=" + name + ", email=" + email + ", type=" + type + "]";
	}
	
	

}
