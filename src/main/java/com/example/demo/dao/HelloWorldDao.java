/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.HelloWorld;

/**
 * 
 * [설명]
 * 
 * @file : HelloWorldDao.java
 * @package : com.example.demo.dao
 * @project : demo
 * @author : leebw 
 * @since : 2018. 1. 16.
 */
@Repository("HelloWorldDao")
public class HelloWorldDao extends HibernateDaoSupport{

	@Autowired
	public HelloWorldDao(
			@Qualifier("hibernateSessionFactoryBean") SessionFactory sessionFactory){
		setSessionFactory(sessionFactory); // HibernateDaoSupport
	}
	
	public boolean add(HelloWorld helloWorld){
        boolean result = false;
        Session session = null;
        Transaction tx;
        try{
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(helloWorld);
            tx.commit();
            result = true;
        }catch (HibernateException e){
        	System.out.println("errror~");
        }finally {
            if(session != null){
                session.close();
            }
        }
        return result;
	}
	
	public HelloWorld get(String helloWorldId){
        int result = 0;
        Session session = null;
        HelloWorld helloWorld = null;
        try{
            session = getSessionFactory().openSession();
            helloWorld = (HelloWorld) session.get(HelloWorld.class, helloWorldId);
        }catch (HibernateException e){
        	System.out.println("errror~");
        }finally {
            if(session != null){
                session.close();
            }
        }
        return helloWorld;
	}
	
	public List<HelloWorld> getList(){
        int result = 0;
        Session session = null;
        Criteria criteria;
        List<HelloWorld> list = null;
        try{
            session = getSessionFactory().openSession();
            criteria = session.createCriteria(HelloWorld.class);
            list = criteria.list();
        }catch (HibernateException e){
        	System.out.println("errror~");
        }finally {
            if(session != null){
                session.close();
            }
        }
        return list;
	}
	
}
