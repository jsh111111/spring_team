package com.model;

import lombok.*;

/*@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder*/
public class TeamDTO {
	private int teamno;
	private String tname;
	private String skills;
	private String phone;
	private String address;
	private int zipcode;
	private String gender;
	private String rdate;

	public TeamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamDTO(int teamno, String tname, String skills, String phone, String address, int zipcode, String gender,
			String rdate) {
		super();
		this.teamno = teamno;
		this.tname = tname;
		this.skills = skills;
		this.phone = phone;
		this.address = address;
		this.zipcode = zipcode;
		this.gender = gender;
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "TeamDTO [teamno=" + teamno + ", tname=" + tname + ", skills=" + skills + ", phone=" + phone
				+ ", address=" + address + ", zipcode=" + zipcode + ", gender=" + gender + ", rdate=" + rdate + "]";
	}

	public int getTeamno() {
		return teamno;
	}

	public void setTeamno(int teamno) {
		this.teamno = teamno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

}
