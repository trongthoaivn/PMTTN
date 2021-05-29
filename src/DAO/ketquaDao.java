package DAO;

import UTILITY.hibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public List getAll() {
        return null;
    }
}
