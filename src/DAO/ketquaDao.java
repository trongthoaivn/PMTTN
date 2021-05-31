package DAO;

import MODEL.AdminEntity;
import MODEL.KetquaEntity;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ketquaDao implements DaoInterface{
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
        return 0;
    }

    @Override
    public int updateData(Object Data) {
        return 0;
    }

    @Override
    public List<KetquaEntity> getAll() {
        Session s = hibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(KetquaEntity.class);
        query.from(KetquaEntity.class);
        List<KetquaEntity>  list=  s.createQuery(query).getResultList();
        s.close();

        return list;
    }
}
