package payment;

import java.sql.Date;

public class PaymentVo {
	private Date day;
	private String menuName;
	private int price;
	private String id;

	public PaymentVo() {

	}

	public PaymentVo(Date day, String menuName, int price, String id) {
		super();
		this.day = day;
		this.menuName = menuName;
		this.price = price;
		this.id = id;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PaymentVo [day=" + day + ", menuName=" + menuName + ", price=" + price + ", id=" + id + "]";
	}
}
