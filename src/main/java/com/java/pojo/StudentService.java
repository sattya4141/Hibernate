package com.java.pojo;

import java.util.List;

public interface StudentService {
	
	public String STUDENT_SUCCES="Student added succesfuly";
	public String STUDENT_ERROR="Problem in student added";
	public String DUPLICATE_STUDENT="Duplicate Student";
	
	public String addNewStudent(Student std);
	public List<Student> listOfStudent();
	
	public List<Student> searchByCategoryType(CategoryType type,String val);
	public boolean deleteStudentById(int stdId);
	public Student upadteStudentById(int stdid,Student std);
	public List<Student> cheackRangeStudentFess(double startRange,double endEnd);
	//public List<Student> listOfPayFeesByStudent(TypesOfFees feesType ,);
	
	

}
 enum CategoryType{
	 Id,
	 Name,
	 Skill,
	 Fees,
	 Address
	 
 }
 
 enum SkillType{
	 java,
	 python,
	 c,
	 cyberSecurity,
	 softwareTesting
 }
 
 enum TypesOfFees{
	 HighestFee(),
	 MediumFees,
	 LowestFees
 }