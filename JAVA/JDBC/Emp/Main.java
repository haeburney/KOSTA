package emp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
		// dao.insert(new EmpVo(2, "whang", 2000, null, 10));
		// dao.update(new EmpVo(1,"",4000, null, 80));
		dao.delete(new EmpVo(1, "", 0, null, 0));
		// 1번 빼고 나머지 값은 그냥 냅둬도 되나?
	}
}
