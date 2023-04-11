package filedown;

import java.util.ArrayList;

public class FileDownService {
	FileDownDao dao;
	
	public FileDownService() {
		dao = new FileDownDao();
	}
	
	public void addFile(FileDownVo vo) {
		dao.insert(vo);
	}
	
	public FileDownVo b(int num) {
		return dao.select(num);
	}
	
	public ArrayList<FileDownVo> c(){
		return dao.selectAll();
	}
}
