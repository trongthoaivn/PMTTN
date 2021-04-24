package DAO;

import MODEL.AdminEntity;
import MODEL.TaikhoanEntity;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.List;

public class adminDao  implements  DaoInterface<AdminEntity>{


    @Override
    public int addData(AdminEntity Data) {
        try {
            Session session =hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
            session.save(Data);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception) {
            System.out.println(exception);
            return 0;
        }
    }

    @Override
    public int delData(AdminEntity Data) {
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
    public int updateData(AdminEntity Data) {

        try {
            Session session  = hibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(Data);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception){
            System.out.println(exception);
            return 0;
        }
    }


    public ObservableList getAdmin(){
        Session session = hibernateUtil.getSession();
        String query ="select A,T from AdminEntity A,TaikhoanEntity T where A.taikhoanByUsername.username= T.username";
        List list = session.createQuery(query).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
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


    public AdminEntity infoAdmin(String user){
        Session session = hibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(AdminEntity.class);
        Root<AdminEntity > root = query.from(AdminEntity.class);
        Join<AdminEntity,TaikhoanEntity> join = root.join("taikhoanByUsername",JoinType.INNER);
        Predicate p = builder.equal(join.get("username"), user);
        List<AdminEntity> admin=  session.createQuery(query.where(p)).getResultList();
        session.close();

        return admin.get(0);
    }

}
