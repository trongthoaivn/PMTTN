package DAO;

import MODEL.TaikhoanEntity;
import UTILITY.hibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class taikhoanDao implements DaoInterface<TaikhoanEntity>{


    @Override
    public int addData(TaikhoanEntity Data) {
        try {
            Session session =hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
            session.save(Data);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception){
            System.out.println(exception);
            return 0;
        }

    }

    @Override
    public int delData(TaikhoanEntity Data) {

        try {
            Session session =hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
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
    public int updateData(TaikhoanEntity Data) {
        try {
            Session session =hibernateUtil.getSession();
            Transaction transaction =session.beginTransaction();
            session.update(Data);
            transaction.commit();
            session.close();
            return 1;
        }catch (Exception exception){
            System.out.println(exception);
            return 0;
        }
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


    public List<TaikhoanEntity> getlist(){
        Session s = hibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(TaikhoanEntity.class);
        query.from(TaikhoanEntity.class);
        List<TaikhoanEntity>  list=  s.createQuery(query).getResultList();
        s.close();
        return list;
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
    public List<TaikhoanEntity> getTkbytoDay(){
        Session s = hibernateUtil.getSession();
        Query query = s.createQuery("select tk from TaikhoanEntity tk, HocsinhEntity hs,ThisinhEntity ts,KythiEntity kt where tk.username=hs.taikhoanByUsername.username and hs.maHs=ts.maHs and ts.maKt=kt.maKt and day(kt.ngaythi)= day(current_timestamp ()) and month(kt.ngaythi) = month(current_timestamp ())");
        List<TaikhoanEntity> list = query.getResultList();
        s.close();
        return list;
    }
    public String getAc_id_last(int i){
        Session s = hibernateUtil.getSession();
        Query query = s.createQuery("select a from TaikhoanEntity a where a.quyenByMaQuyen.maQuyen=:i");
        List<TaikhoanEntity>  list=  query.setParameter("i",i).getResultList();
        s.close();
        return list.get(list.size()-1).getUsername();
    }

}
