package emlakcepte.request;

public class PaymentRequest {
	
	private String email;
	final private Integer price = 100;
	private Integer amount;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	

}
