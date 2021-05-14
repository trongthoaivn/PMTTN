package DAO;

import MODEL.BodeEntity;
import MODEL.CauhoiEntity;
import MODEL.MadeJson;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

    public int getEndindex(){
        Session s = hibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(CauhoiEntity.class);
        query.from(CauhoiEntity.class);
        List<CauhoiEntity>  list=  s.createQuery(query).getResultList();
        s.close();
        return list.size();
    }

    public int DeleteQuestiobymaDe(BodeEntity bodeEntity){
        try {
            Session session =hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
            Query query = session.createQuery("delete from CauhoiEntity a where a.bodeByMaBode.maBode= :id");
            query.setParameter("id",bodeEntity.getMaBode());
            query.executeUpdate();
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception) {
            System.out.println(exception);
            return 0;
        }
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

    public List<CauhoiEntity> getQuestionbyCodeasList(String code){
        Session session = hibernateUtil.getSession();
        Query query = session.createQuery("select a from CauhoiEntity a where a.bodeByMaBode.maBode=:c");
        query.setParameter("c",code);
        List<CauhoiEntity> list = (List<CauhoiEntity>) query.getResultList();
        session.close();
        return list;
    }

    public ObservableList<CauhoiEntity> getQuestionbyCode(BodeEntity bode) {
        Session session = hibernateUtil.getSession();
        String query ="select a from CauhoiEntity a where a.bodeByMaBode.maBode='"+bode.getMaBode()+"'";
        List list = session.createQuery(query).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
