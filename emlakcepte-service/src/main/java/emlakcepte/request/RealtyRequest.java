package emlakcepte.request;

import emlakcepte.model.enums.RealtyOption;
import emlakcepte.model.enums.RealtyStatus;
import emlakcepte.model.enums.RealtyType;

public class RealtyRequest {
	
	private Integer no;
	private String title;
	private String province;
	private String district;
	private RealtyStatus status;
	private RealtyType type;
	private RealtyOption option;
	private Integer userId;
	
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public RealtyType getType() {
		return type;
	}
	public RealtyStatus getStatus() {
		return status;
	}
	public void setStatus(RealtyStatus status) {
		this.status = status;
	}
	public void setType(RealtyType type) {
		this.type = type;
	}
	public RealtyOption getOption() {
		return option;
	}
	public void setOption(RealtyOption option) {
		this.option = option;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
	
	
	
	

}
