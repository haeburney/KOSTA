package menu;

public class MenuVo {
	private int num;
	private String category;
	private String menuName;
	private int price;
	private String expl;
	private String hc;

	public MenuVo() {
	}

	public MenuVo(int num, String category, String menuName, int price, String expl, String hc) {
		super();
		this.num = num;
		this.category = category;
		this.menuName = menuName;
		this.price = price;
		this.expl = expl;
		this.hc = hc;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getExpl() {
		return expl;
	}

	public void setExpl(String expl) {
		this.expl = expl;
	}

	public String getHc() {
		return hc;
	}

	public void setHc(String hc) {
		this.hc = hc;
	}

	@Override
	public String toString() {
		return "MenuVo [num=" + num + ", category=" + category + ", menuName=" + menuName + ", price=" + price
				+ ", expl=" + expl + ", hc=" + hc + "]";
	}

}
