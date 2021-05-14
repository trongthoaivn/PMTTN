package DAO;

import MODEL.AdminEntity;
import MODEL.BodeEntity;
import MODEL.MadeEntity;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class madeDao implements DaoInterface{
    @Override
    public int addData(Object Data) {
        return 0;
    }

    @Override
    public int delData(Object Data) {
        return 0;
    }

    @Override
    public int updateData(Object Data) {
        return 0;
    }

    @Override
    public ObservableList<MadeEntity> getAll() {
        Session s = hibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(MadeEntity.class);
        query.from(MadeEntity.class);
        List<MadeEntity>  list=  s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(list);
    }

    public List<MadeEntity> getMadebyCode(BodeEntity bode){
        Session session = hibernateUtil.getSession();
        Query query =session.createQuery("select a from MadeEntity a where a.bodeByMaBode.maBode=:id");
        query.setParameter("id",bode.getMaBode());
        List<MadeEntity> list = query.getResultList();
        session.close();
        return list;
    }
    public MadeEntity getMadebyMadeid(String made){
        Session session = hibernateUtil.getSession();
        Query query =session.createQuery("select a from MadeEntity a where a.maDe=:id");
        query.setParameter("id",made);
        MadeEntity amade = (MadeEntity) query.getResultList().get(0);
        session.close();
        return amade;
    }
}
