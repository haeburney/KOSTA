package board;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BoardDao dao = new BoardDao();
		
	
		
		// dao.insert(new BoardVo(0, "bbb", null, "titleBBB", "contentBBB"));
		// dao.delete(15);
		// dao.update(new BoardVo(14, "", null, "titleZZZ", "contentZZZ"));

		// 번호로 찾기
//		BoardVo vo = dao.select(14);
//		if(vo==null) {
//			System.out.println("없음요~");
//		} else {
//			System.out.println(vo);
//		}

		// ID로 찾기
//		ArrayList<BoardVo> li = dao.selectId("bbb");
//		for (BoardVo vo : li) {
//			System.out.println(vo);
//		}

		// 전체 출력
		ArrayList<BoardVo> liAll=dao.selectAll();
		for(BoardVo vo:liAll) {
			System.out.println(vo);
		}

		// Title로 찾기
//		ArrayList<BoardVo> liTitle = dao.selectTitle("t");
//		for(BoardVo vo:liTitle) {
//			System.out.println(vo);
//		}

	}
}
