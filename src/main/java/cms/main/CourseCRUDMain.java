package cms.main;

import java.io.Serializable;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cms.beans.CourseTitleAndProvider;
import cms.entities.*;
import cms.utils.HiberUtils;

public class CourseCRUDMain {

	public static void main(String[] args) {
		
		//createOneCourse();
		//getOneCourse();
		//updateCourse();
		//deleteCourse();
		//getAllCoursesFromcluase();
		//getAllDetailByusningSelect();
		getCoursetitleAndProvider();
	}
	
	
	public static void createOneCourse() {
		
		Session session = HiberUtils.getSessionFactory().openSession();
		
		
		Transaction transaction = session.beginTransaction();
		
		Course course = new Course(10,"Java",55,"Udemy",600);
		
		session.save(course);
		transaction.commit();
		session.close();
		
	}
	public static void getOneCourse() {
		
		Session session = HiberUtils.getSessionFactory().openSession();
		
		Class<Course> entitytype= Course.class;
		Serializable id= 1;
		
		Course course = session.load(entitytype,id);
		
		System.out.println(course);
		
		session.close();
	
	}
	public static void updateCourse() {
		
		Session session = HiberUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Class<Course> entitytype= Course.class;
		Serializable id= 2;
	    Course course = session.load(entitytype, id); 
	    course.setTitle("SAPnew");
	    course.setFees(1000);
	    transaction.commit();
	    session.close();
	    
		
	}
	public static void deleteCourse() {
		Session session = HiberUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Class<Course> entitytype= Course.class;
		Serializable id= 3;
	    Course course = session.load(entitytype, id);
		
	    session.delete(course);
	    transaction.commit();
	    session.close();
		
	}

	public static void getAllCoursesFromcluase() {
		SessionFactory factory =HiberUtils.getSessionFactory();
		Session session = factory.openSession();
		
		//Building HQl Query
		String hqlQuery = "From Course cr";
		
		//obtaing a reference of Type 'Query'
		Query<Course> hibernateQuery = session.createQuery(hqlQuery);
		
		//Obtaining a List of Course Object
		List<Course> courseList = hibernateQuery.list();
		
		courseList.stream().forEach((crlt)->System.out.println(crlt));
		
		session.close();
		factory.close();
		
	}
	public static void getAllDetailByusningSelect() {
		SessionFactory factory =HiberUtils.getSessionFactory();
		Session session = factory.openSession();
		
		String hqlQuery = "select cr.title,cr.provider from Course cr";
		Query<Object[]> hibernateQuery= session.createQuery(hqlQuery);
		
		List<Object[]> courseList= hibernateQuery.list();
		
		for (Object[] course: courseList) {
			Object title= course[0];
			Object restBrCount = course[1];
			System.out.println(" title :"+title+" restBrCount :"+restBrCount);
		}
	
	}
	public static void getCoursetitleAndProvider() {  // using Counstructor Expression
	     
		SessionFactory factory =HiberUtils.getSessionFactory();
		Session session = factory.openSession();
		String hqlQuery = "select new cms.beans.CourseTitleAndProvider(cr.title , cr.provider) from Course cr";
		Query<CourseTitleAndProvider> hibernateQuery = session.createQuery(hqlQuery);
		
		List<CourseTitleAndProvider> courseList = hibernateQuery.list();
		
		for (CourseTitleAndProvider courseTitleAndProvider : courseList) {
			System.out.println("Title of Course : "+courseTitleAndProvider.getTitle()+"|| Proider of Course : "+courseTitleAndProvider.getProvider());
		}
		
		session.close();
		factory.close();
		
		 
	}
}
