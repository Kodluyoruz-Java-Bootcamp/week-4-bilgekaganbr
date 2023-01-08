package emlakcepte.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import emlakcepte.model.enums.RealtyOption;
import emlakcepte.model.enums.RealtyStatus;
import emlakcepte.model.enums.RealtyType;

@Entity
@Table(name = "realty")
public class Realty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "realty_no", nullable = false)
	private Integer no;
	@Column(name = "title", nullable = false, length = 200)
	private String title;
	@Column(name = "create_date")
	private LocalDateTime createDate;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private RealtyStatus status;
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private RealtyType type;
	@Column(name = "option")
	@Enumerated(EnumType.STRING)
	private RealtyOption option;
	@Column(name = "province")
	private String province;
	@Column(name = "district")
	private String district;
	
	
	public Realty() {
		super();
	}


	public Realty(Integer no, String title, LocalDateTime createDate, RealtyStatus status, RealtyType type,
			RealtyOption option, String province, String district) {
		super();
		this.no = no;
		this.title = title;
		this.createDate = createDate;
		this.status = status;
		this.type = type;
		this.option = option;
		this.province = province;
		this.district = district;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


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


	public LocalDateTime getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}


	public RealtyStatus getStatus() {
		return status;
	}


	public void setStatus(RealtyStatus status) {
		this.status = status;
	}


	public RealtyType getType() {
		return type;
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


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	

}
