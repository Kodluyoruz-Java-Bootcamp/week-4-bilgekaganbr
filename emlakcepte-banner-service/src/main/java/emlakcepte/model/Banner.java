package emlakcepte.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banners")
public class Banner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;
	@Column(name = "ilan_no")
	private String ilanNo;
	@Column(name = "adet")
	private int adet;
	@Column(name = "tel_no_1")
	private String telNo1;
	@Column(name = "tel_no_2")
	private String telNo2;
	@Column(name = "adres")
	private String adres;
	// adres bilgilerinin eklenmesi
	
	public Banner() {
		super();
	}

	public Banner(String ilanNo, int adet, String telNo1, String telNo2, String adres) {
		super();
		this.ilanNo = ilanNo;
		this.adet = adet;
		this.telNo1 = telNo1;
		this.telNo2 = telNo2;
		this.adres =  adres;
	}

	public String getIlanNo() {
		return ilanNo;
	}

	public void setIlanNo(String ilanNo) {
		this.ilanNo = ilanNo;
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}

	public String getTelNo1() {
		return telNo1;
	}

	public void setTelNo1(String telNo1) {
		this.telNo1 = telNo1;
	}

	public String getTelNo2() {
		return telNo2;
	}

	public void setTelNo2(String telNo2) {
		this.telNo2 = telNo2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	@Override
	public String toString() {
		return "Banner [ilanNo=" + ilanNo + ", adet=" + adet + ", telNo1=" + telNo1 + ", telNo2=" + telNo2 + "]";
	}

}
