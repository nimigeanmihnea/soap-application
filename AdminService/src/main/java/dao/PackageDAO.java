package dao;

import entity.Package;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PackageDAO {

    private SessionFactory factory;

    public PackageDAO(SessionFactory factory){
        this.factory = factory;
    }

    public void add(Package aPackage){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(aPackage);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null){
                tx.rollback();
            }
        }finally {
            session.close();
        }
    }

    public void remove(Package aPackage){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(aPackage);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null){
                tx.rollback();
            }
        }finally {
            session.close();
        }
    }

    public void update(Package aPackage){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(aPackage);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null){
                tx.rollback();
            }
        }finally {
            session.close();
        }
    }

    public Package findByName(String name){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Package> packages = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Package WHERE name = :name", Package.class);
            query.setParameter("name", name);
            packages = query.list();
            tx.commit();
        }catch (HibernateException e){
            if(tx != null){
                tx.rollback();
            }
        }finally {
            session.close();
        }
        return packages.get(0);
    }
}
