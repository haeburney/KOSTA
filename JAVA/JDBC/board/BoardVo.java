package board;

import java.sql.Date;

public class BoardVo {
	private int num;
	private String writer;
	private Date date;
	private String title;
	private String content;

	public BoardVo() {
	}

	public BoardVo(int num, String writer, Date date, String title, String content) {
		super();
		this.num = num;
		this.writer = writer;
		this.date = date;
		this.title = title;
		this.content = content;
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

	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", writer=" + writer + ", date=" + date + ", title=" + title + ", content="
				+ content + "]";
	}
}
