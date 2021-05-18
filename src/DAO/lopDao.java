package DAO;

import MODEL.HocsinhEntity;
import MODEL.LopEntity;
import UTILITY.hibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class lopDao implements DaoInterface{
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
    public List<LopEntity> getAll() {
        Session s = hibernateUtil.getSession();
        Query query = s.createQuery("select a from LopEntity a ");
        List<LopEntity>  list=  query.getResultList();
        s.close();
        return list;
    }

}
