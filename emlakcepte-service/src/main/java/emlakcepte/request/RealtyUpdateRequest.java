package emlakcepte.request;

import emlakcepte.model.enums.RealtyOption;
import emlakcepte.model.enums.RealtyStatus;

public class RealtyUpdateRequest {
	
	private String title;
	private RealtyStatus status;
	private RealtyOption option;
	private Integer userId;
	private Integer no;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public RealtyStatus getStatus() {
		return status;
	}
	public void setStatus(RealtyStatus status) {
		this.status = status;
	}
	public RealtyOption getOption() {
		return option;
	}
	public void setOption(RealtyOption option) {
		this.option = option;
	}
	public Integer getUserId() {
		return userId;
	}
	public Integer getNo() {
		return no;
	}
	
	
	
	
	
	

}
