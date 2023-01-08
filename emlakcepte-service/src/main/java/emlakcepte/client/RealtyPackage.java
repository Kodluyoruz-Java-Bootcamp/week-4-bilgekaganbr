package emlakcepte.client;

import java.time.LocalDateTime;

public class RealtyPackage {
	
	private Integer id;
	final private String title = "10'lu İlan Paketi";
	final private Integer number = 10;
	private Integer userId;
	private LocalDateTime startDate;
	private LocalDateTime expiredDate;
	final private Integer price = 100;


	public RealtyPackage() {
		super();
	}


	public RealtyPackage(Integer userId, LocalDateTime startDate, LocalDateTime expiredDate) {
		super();
		this.userId = userId;
		this.startDate = startDate;
		this.expiredDate = expiredDate;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public LocalDateTime getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}


	public LocalDateTime getExpiredDate() {
		return expiredDate;
	}


	public void setExpiredDate(LocalDateTime expiredDate) {
		this.expiredDate = expiredDate;
	}


	public String getTitle() {
		return title;
	}


	public Integer getNumber() {
		return number;
	}


	public Integer getPrice() {
		return price;
	}
	
	
	
	
	
	

}
