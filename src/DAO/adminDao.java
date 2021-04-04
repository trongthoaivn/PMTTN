package DAO;

import MODEL.AdminEntity;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Observable;

public class adminDao  implements  DaoInterface<AdminEntity>{


    @Override
    public int addData(AdminEntity Data) {
        return 0;
    }

    @Override
    public int delData(AdminEntity Data) {
        return 0;
    }

    @Override
    public int updateData(AdminEntity Data) {
        return 0;
    }

    @Override
    public ObservableList<AdminEntity> getAll() {

        Session s = hibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(AdminEntity.class);
        query.from(AdminEntity.class);
        List<AdminEntity>  list=  s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(list);
    }

}
