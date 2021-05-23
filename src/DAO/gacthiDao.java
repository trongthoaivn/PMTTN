package DAO;

import MODEL.GacthiEntity;
import MODEL.GiaovienEntity;
import MODEL.HocsinhEntity;
import MODEL.KythiEntity;
import UTILITY.hibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class gacthiDao implements DaoInterface{
    @Override
    public int addData(Object Data) {
        try {
            Session session = hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
            session.saveOrUpdate(Data);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception) {
            System.out.println(exception);
            return 0;
        }
    }

    @Override
    public int delData(Object Data) {
        try {
            Session session = hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
            session.delete(Data);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception) {
            System.out.println(exception);
            return 0;
        }
    }

    @Override
    public int updateData(Object Data) {
        try {
            Session session = hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
            session.update(Data);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception) {
            System.out.println(exception);
            return 0;
        }
    }

    @Override
    public List getAll() {
        return null;
    }
    public List<GiaovienEntity>  getGacthibyKT(KythiEntity KT){
        Session session = hibernateUtil.getSession();
        Query query = session.createQuery("select b from GacthiEntity a,GiaovienEntity b where  a.kythiByMaKt.maKt=:id and a.giaovienByMaGv.maGv=b.maGv");
        query.setParameter("id",KT.getMaKt());
        List<GiaovienEntity> list =query.getResultList();
        return list;
    }

    public int InsertOrUpdateList(List<GacthiEntity> gacthi){
        try {
            Session session = hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
            for (GacthiEntity Data :gacthi)
                session.saveOrUpdate(Data);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception) {
            System.out.println(exception);
            return 0;
        }
    }
    public int DeleteAll(KythiEntity kythi){
        try {
            Session session = hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
            Query query = session.createQuery("delete  from GacthiEntity a where a.maKt=:id");
            query.setParameter("id",kythi.getMaKt());
            query.executeUpdate();
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception) {
            System.out.println(exception);
            return 0;
        }
    }
}
