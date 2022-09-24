package test.com.member.model;

import java.io.Serializable;
import java.util.Objects;

public class MemberVO implements Serializable {

	private int num;
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String img_name;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", img_name="
				+ img_name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, img_name, name, num, pw, tel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(id, other.id) && Objects.equals(img_name, other.img_name)
				&& Objects.equals(name, other.name) && num == other.num && Objects.equals(pw, other.pw)
				&& Objects.equals(tel, other.tel);
	}

}
