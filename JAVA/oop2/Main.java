package oop2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao dao = new DaoImplOracle();
		dao.insert();
		dao.select();
		dao.update();
		dao.delete();

		Dao dao2 = new DaoImplMysql();
		dao2.insert();
		dao2.select();
		dao2.update();
		dao2.delete();
	}

}
