package DAO;

import DAO.DaoInterface;
import MODEL.LogEntity;
import UTILITY.hibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.Query;
import java.util.List;

public class logDao implements DaoInterface {
    @Override
    public int addData(Object Data) {
        try {
            Session session =hibernateUtil.getSession();
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
    public List getAll() {
        return null;
    }
    public LogEntity getLog(String maKT , String maHS){
        Session s = hibernateUtil.getSession();
        Query query = s.createQuery("select tk from LogEntity tk where tk.maKt=:kt and tk.maHs=:hs");
        query.setParameter("kt",maKT);
        query.setParameter("hs",maHS);
        LogEntity logEntity = (LogEntity) query.getResultList().get(0);
        s.close();
        return logEntity;
    }
}
