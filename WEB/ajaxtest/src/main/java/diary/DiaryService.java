package diary;

import java.util.ArrayList;

public class DiaryService {
	private DiaryDao dao;
	public final static String path = "C:\\Users\\KOSTA\\Desktop\\webworkspace2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\diary";
	// 못 고치게 final로 설정
	
	public DiaryService() {
		dao = new DiaryDao();
	}
	
	public void addDiary(DiaryVo vo){
		dao.insert(vo);
	}
	
	public DiaryVo getDiary(int num){
		return dao.select(num);
	}
	
	public ArrayList<DiaryVo> getAll(String writer){
		return dao.selectAll(writer);
	}
	
	public void editDiary(DiaryVo vo){
		dao.update(vo);
	} 
	
	public void delDiary(int num){
		dao.delDiary(num);
	}
}
