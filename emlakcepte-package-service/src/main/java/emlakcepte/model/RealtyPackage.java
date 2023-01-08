package emlakcepte.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "packages")
public class RealtyPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;
	@Column(name = "title")
	final private String title = "10'lu İlan Pakati";
	@Column(name = "number")
	final private Integer number = 10;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "start_date")
	private LocalDateTime startDate;
	@Column(name = "expired_date")
	private LocalDateTime expiredDate;
	@Column(name = "price")
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
