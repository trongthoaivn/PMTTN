package DAO;

import MODEL.TaikhoanEntity;
import REF.USPW;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import javax.persistence.Entity;
import java.util.Observable;

public class taikhoanDao implements DaoInterface<TaikhoanEntity>{


    @Override
    public int addData(TaikhoanEntity Data) {
        return 0;
    }

    @Override
    public int delData(TaikhoanEntity Data) {
        return 0;
    }

    @Override
    public int updateData(TaikhoanEntity Data) {
        return 0;
    }

    @Override
    public ObservableList<TaikhoanEntity> getAll() {


        Session s = hibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(TaikhoanEntity.class);
        query.from(TaikhoanEntity.class);
        List<TaikhoanEntity>  list=  s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(list);
    }

    public TaikhoanEntity getUser_Pass(String username){

        Session session = hibernateUtil.getSession();
        TaikhoanEntity Taikhoan = null;
        try{
            Taikhoan = (TaikhoanEntity) session.load(TaikhoanEntity.class,username);
            Hibernate.initialize(Taikhoan);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return Taikhoan;

    }


}
