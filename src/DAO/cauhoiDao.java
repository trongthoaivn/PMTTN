package DAO;

import MODEL.BodeEntity;
import MODEL.CauhoiEntity;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class cauhoiDao implements DaoInterface{
    @Override
    public int addData(Object Data) {
        return 0;
    }

    @Override
    public int delData(Object Data) {
        try {
            Session session  = hibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(Data);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception){
            System.out.println(exception);
            return 0;
        }
    }

    @Override
    public int updateData(Object Data) {
        return 0;
    }

    @Override
    public List getAll() {
        return null;
    }

    public int InsertorUpdate(List<CauhoiEntity> list){
        try {
            Session session =hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
            list.forEach(e ->{
                session.saveOrUpdate(e);
            });
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception) {
            System.out.println(exception);
            return 0;
        }
    }

    public ObservableList<CauhoiEntity> getQuestionbyCode(BodeEntity bode) {
        Session session = hibernateUtil.getSession();
        String query ="select a from CauhoiEntity a where a.bodeByMaBode.maBode='"+bode.getMaBode()+"'";
        List list = session.createQuery(query).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
