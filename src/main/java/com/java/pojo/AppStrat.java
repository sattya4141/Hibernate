package com.java.pojo;

import java.util.List;

public class AppStrat {

	public static void main(String[] args) {
		
		StudentServiceimpl ssi=new StudentServiceimpl();
		
	List<Student>list=ssi.searchByCategoryType(CategoryType.Address,"pune");
		
		
		
		ssi.addNewStudent(new Student(12, "Satish", 34560, 24, "Pune", SkillType.java, GendorType.Male));
		ssi.addNewStudent(new Student(13, "Sanket", 34560, 23, "Pune1", SkillType.cyberSecurity, GendorType.Male));
		ssi.addNewStudent(new Student(14, "Sandesh", 345, 25, "Kolhpur", SkillType.java, GendorType.Male));
		ssi.addNewStudent(new Student(15, "Rushi", 34560, 24, "Sangli", SkillType.java, GendorType.Male));
		ssi.addNewStudent(new Student(16, "Tejswi", 34560, 26, "Pune", SkillType.java, GendorType.Female));
		ssi.addNewStudent(new Student(17, "Satish", 34560, 24, "Pune", SkillType.softwareTesting, GendorType.Male));
	    System.out.println(ssi);
	}

}
