package DAO;

import MODEL.AdminEntity;
import MODEL.TaikhoanEntity;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.List;

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

    public ObservableList<AdminEntity> getAdmin(){
        Session session = hibernateUtil.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query =builder.createQuery(AdminEntity.class);
        Root<AdminEntity> Admin = query.from(AdminEntity.class);
        Join<AdminEntity,TaikhoanEntity> join = Admin.join("username",JoinType.INNER);
        query.where(join.isNotNull());
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
        Predicate p = builder.equal(root.get("username"),user);
        AdminEntity admin= (AdminEntity) session.createQuery(query.where(p)).getSingleResult();
        session.close();

        return admin;
    }

}
