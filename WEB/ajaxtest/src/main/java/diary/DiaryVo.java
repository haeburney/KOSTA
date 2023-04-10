package diary;

import java.sql.Date;

public class DiaryVo {
	private int num;
	private String writer;
	private Date date;
	private String content;
	private String pic1;
	private String pic2;
	private String pic3;
	
	public DiaryVo() {
		
	}

	public DiaryVo(int num, String writer, Date date, String content, String pic1, String pic2, String pic3) {
		super();
		this.num = num;
		this.writer = writer;
		this.date = date;
		this.content = content;
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.pic3 = pic3;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPic3() {
		return pic3;
	}

	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	@Override
	public String toString() {
		return "DiaryVo [num=" + num + ", writer=" + writer + ", date=" + date + ", content=" + content + ", pic1="
				+ pic1 + ", pic2=" + pic2 + ", pic3=" + pic3 + "]";
	}
	
	
}
