package com.java.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

enum GendorType{
	   Male,
	   Female
}
@Entity
@Table(name="student_info")
public class Student {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int stdId;
	private String stdName;
	private double stdFees;
	private int stdAge;
	private String stdAddress;
	private SkillType stdSkill;
	private  GendorType stdGendor;
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdFees=" + stdFees + ", stdAge=" + stdAge
				+ ", stdAddress=" + stdAddress + ", stdSkill=" + stdSkill + ", stdGendor=" + stdGendor + "]";
	}
	public Student(int stdId, String stdName, double stdFees, int stdAge, String stdAddress, SkillType stdSkill,
			GendorType stdGendor) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdFees = stdFees;
		this.stdAge = stdAge;
		this.stdAddress = stdAddress;
		this.stdSkill = stdSkill;
		this.stdGendor = stdGendor;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public double getStdFees() {
		return stdFees;
	}
	public void setStdFees(double stdFees) {
		this.stdFees = stdFees;
	}
	public int getStdAge() {
		return stdAge;
	}
	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}
	public String getStdAddress() {
		return stdAddress;
	}
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}
	public SkillType getStdSkill() {
		return stdSkill;
	}
	public void setStdSkill(SkillType stdSkill) {
		this.stdSkill = stdSkill;
	}
	public GendorType getStdGendor() {
		return stdGendor;
	}
	public void setStdGendor(GendorType stdGendor) {
		this.stdGendor = stdGendor;
	}
	
	

}


   