package DAO;

import MODEL.HocsinhEntity;
import MODEL.KythiEntity;
import MODEL.ThisinhEntity;
import UTILITY.hibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class thisinhDao implements DaoInterface{
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
    public List<HocsinhEntity>  getThisinhbyKT(KythiEntity KT){
        Session session = hibernateUtil.getSession();
        Query query = session.createQuery("select b from ThisinhEntity a,HocsinhEntity b where  a.kythiByMaKt.maKt=:id and a.hocsinhByMaHs.maHs =b.maHs");
        query.setParameter("id",KT.getMaKt());
        List<HocsinhEntity> list =query.getResultList();
        return list;
    }
}
