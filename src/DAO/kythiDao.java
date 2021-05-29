package DAO;

import MODEL.AdminEntity;
import MODEL.KythiEntity;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class kythiDao implements DaoInterface{
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
            Session session =hibernateUtil.getSession();
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
            Session session =hibernateUtil.getSession();
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
    public List<KythiEntity> getAll() {
        Session s = hibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(KythiEntity.class);
        query.from(KythiEntity.class);
        List<KythiEntity>  list=  s.createQuery(query).getResultList();
        s.close();
        return list;
    }

    public List<KythiEntity> getKythibyMH(String maMH){
        Session s = hibernateUtil.getSession();
        Query query = s.createQuery("select a from KythiEntity a where a.monhocByMaMh.maMh=:id");
        query.setParameter("id",maMH);
        List<KythiEntity> list =query.getResultList();
        return list;
    }
    public KythiEntity getTkbyTS(String maTS){
        Session s = hibernateUtil.getSession();
        Query query= s.createQuery("select kt from KythiEntity kt ,ThisinhEntity ts where ts.maKt=kt.maKt and ts.maHs =:id and day(kt.ngaythi)=day(current_timestamp ())and month(kt.ngaythi)=month(current_timestamp ())");
        query.setParameter("id",maTS);
        KythiEntity kt = (KythiEntity) query.getResultList().get(0);
        return kt;
    }
}
