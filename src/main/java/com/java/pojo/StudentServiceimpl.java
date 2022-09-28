package com.java.pojo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
public class StudentServiceimpl implements StudentService {

	static SessionFactory sfactory = null;

	public StudentServiceimpl() {
		this.sfactory=Hibernateutil.getSessionFactory();
	}

	@Override
	public String addNewStudent(Student std) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			session.save(std);
			System.out.println("student succesfuly saved");
			return STUDENT_SUCCES;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Student add method problrm");
			return STUDENT_ERROR;
		} finally {

			CleanResource.clenUpResource(session, tr);
		}

		
	}

	@Override
	public List<Student> listOfStudent() {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			Criteria cr=session.createCriteria(Student.class);
			return cr.list();
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {

			CleanResource.clenUpResource(session, tr);
		}
		return null;
	}

	
	@Override
	public List<Student> searchByCategoryType(CategoryType type, String val) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			Criteria cr=session.createCriteria(Student.class);
			switch (type) {
			case Id:
				cr.add(Restrictions.eq("stdId", Integer.parseInt(val)));
				
				break;
			case Name:
				cr.add(Restrictions.eq("stdName", val));
				break;
			case Skill:
				cr.add(Restrictions.eq("stdSkill", val));
				break;
			case Fees:
				cr.add(Restrictions.eq("stdFees", Double.parseDouble(val)));
				break;
			case Address:
				cr.add(Restrictions.eq("stdAddress", val));
				break;

			default:
				break;
			}
			return cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			CleanResource.clenUpResource(session, tr);
		}
		return null;
	}

	@Override
	public boolean deleteStudentById(int stdId) {
	Session session = null;
	Transaction tr = null;
	try {
		session = sfactory.openSession();
		tr = session.beginTransaction();
		 Student stdDb=session.get(Student.class,stdId);
		
		if(stdDb!=null) {
			session.delete(stdDb);
			System.out.println("student delete succesfuly");
			return true;
			}

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("no found given student Id..so not delete student");
		
	} finally {

		CleanResource.clenUpResource(session, tr);
	}
		return false;
	}

	@Override
	public Student upadteStudentById(int stdid,Student std) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
            Student stdDb=session.get(Student.class, stdid);
            if(stdDb!=null) {
            	stdDb.setStdAddress(std.getStdAddress());
            	stdDb.setStdAge(std.getStdAge());
            	//stdDb.setStdId(std.getStdId());
            	stdDb.setStdFees(std.getStdFees());
            	stdDb.setStdName(std.getStdName());
            	stdDb.setStdSkill(std.getStdSkill());
            	stdDb.setStdGendor(std.getStdGendor());
            	System.out.println("student updated succesfuly...");
            	return stdDb;
            	
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			CleanResource.clenUpResource(session, tr);
		}
		return null;
	}

	@Override
	public List<Student> cheackRangeStudentFess(double startRange, double endEnd) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			Criteria cr=session.createCriteria(Student.class);
			cr.add(Restrictions.between("stdFees",startRange, endEnd));
			return cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			CleanResource.clenUpResource(session, tr);
		}
		return null;
	}

	
	

	
}
