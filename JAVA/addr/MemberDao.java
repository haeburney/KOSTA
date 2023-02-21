package addr;

// 데이터베이스나 배열같은 저장소와 연결된 작업 수행
public class MemberDao {
	Member[] members;
	int cnt; // 초기화 되어서 0의 값을 가지고 있다.

	MemberDao() {
		// 배열 생성
		members = new Member[30];
	}

	void insert(Member m) {
		// 배열에 Member 객체 하나 추가

		if (cnt >= members.length) {
			System.out.println("배열이 가득 찼습니다. 종료합니다.");
			return;
		} 
		members[cnt] = m;
		cnt++;
		System.out.println("cnt의 값은 : " + cnt);
	}

	// 검색

	// 삭제
}
