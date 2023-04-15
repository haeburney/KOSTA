package imgboard;

import java.sql.Date;
import java.util.ArrayList;

import imgreps.ImgRepVo;

public class ImgBoardVo {
	private int num;
	private String write;
	private Date w_date;
	private String title;
	private String content;
	private String path;
	private ArrayList<ImgRepVo> reps;
	// 
	
	public ImgBoardVo() {
		
	}

	public ImgBoardVo(int num, String write, Date w_date, String title, String content, String path) {
		super();
		this.num = num;
		this.write = write;
		this.w_date = w_date;
		this.title = title;
		this.content = content;
		this.path = path;
	}
	
	

	public ArrayList<ImgRepVo> getReps() {
		return reps;
	}

	public void setReps(ArrayList<ImgRepVo> reps) {
		this.reps = reps;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ImgBoardVo [num=" + num + ", write=" + write + ", w_date=" + w_date + ", title=" + title + ", content="
				+ content + ", path=" + path + "]";
	}
	
	
}
