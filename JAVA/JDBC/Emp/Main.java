package emp;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		// 객체 추가
		//dao.insert(new EmpVo(3, "whan2g", 3000, null, 10));
		// dao.update(new EmpVo(1,"",4000, null, 80));
		//dao.delete(new EmpVo(1, "", 0, null, 0));

		
		// id로 검색
//		EmpVo vo=dao.search(6);
//		if(vo==null) {
//			System.out.println("없는 사번");
//		} else {
//			System.out.println(vo);
//		}

		
		System.out.println("전체검색");
		ArrayList<EmpVo> listAll=dao.selectAll();
		for(EmpVo vo:listAll) {
			System.out.println(vo);
		}
		
		System.out.println("부서 10번 검색");
		ArrayList<EmpVo> listDep1=dao.selectDeptId(10);
		if(listDep1.isEmpty()) {
			System.out.println("검색결과 없음");
		} else {
			System.out.println(listDep1);
		}
		
		System.out.println("부서 100번 검색");
		ArrayList<EmpVo> listDep2=dao.selectDeptId(100);
		if(listDep2.isEmpty()) {
			System.out.println("검색결과 없음");
		} else {
			System.out.println(listDep2);
		}
	}
}
