package DAO;

import MODEL.BodeEntity;
import MODEL.CauhoiEntity;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

public class cauhoiDao implements DaoInterface{
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
    public List getAll() {
        return null;
    }

    public ObservableList<CauhoiEntity> getQuestionbyCode(BodeEntity bode) {
        Session session = hibernateUtil.getSession();
        String query ="select a from CauhoiEntity a where a.bodeByMaBode.maBode='"+bode.getMaBode()+"'";
        List list = session.createQuery(query).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
