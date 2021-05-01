package DAO;

import MODEL.MonhocEntity;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class monhocDao implements DaoInterface{
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
    public ObservableList<MonhocEntity> getAll() {
        Session s = hibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(MonhocEntity.class);
        query.from(MonhocEntity.class);
        List<MonhocEntity>  list=  s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(list);
    }
}
