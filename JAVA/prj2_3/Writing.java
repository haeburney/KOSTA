package homework;

import java.util.Calendar;
import java.util.Date;

public class Writing {

	private int num;
	private String writer;
	private Date date;
	private String title;
	private String content;
	private static int cnt;

	public Writing() {

	}

	public Writing(int num, String auhtor, Date date, String title, String content) {
		if (num == 0) {
			num = ++cnt;
		} else {
			this.num = num;
		}

		this.writer = auhtor;

		if (date == null) {
			Calendar c = Calendar.getInstance();
			date = c.getTime();
		} else {
			this.date = date;
		}

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
		return "Writing [num=" + num + ", writer=" + writer + ", date=" + date + ", title=" + title + ", content="
				+ content + "]";
	}

}
