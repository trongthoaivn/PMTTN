package DAO;

import MODEL.AdminEntity;
import MODEL.HocsinhEntity;
import MODEL.TaikhoanEntity;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class hocsinhDao implements DaoInterface{
    @Override
    public int addData(Object Data) {
        try {
            Session session =hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
            session.save(Data);
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
    public ObservableList<HocsinhEntity> getAll() {
        Session s = hibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(HocsinhEntity.class);
        query.from(HocsinhEntity.class);
        List<HocsinhEntity>  list=  s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(list);
    }

    public HocsinhEntity getHSbyTK(String tk) {
        Session s = hibernateUtil.getSession();
        Query query = s.createQuery("select a from HocsinhEntity a where a.taikhoanByUsername.username=:id");
        query.setParameter("id",tk);
        HocsinhEntity hs = (HocsinhEntity) query.getResultList().get(0);
        s.close();
        return hs;
    }
}
