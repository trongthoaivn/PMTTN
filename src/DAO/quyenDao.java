package DAO;

import MODEL.QuyenEntity;
import MODEL.TaikhoanEntity;
import UTILITY.hibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import java.util.List;

public class quyenDao implements DaoInterface<QuyenEntity> {
    @Override
    public int addData(QuyenEntity Data) {
        return 0;
    }

    @Override
    public int delData(QuyenEntity Data) {
        return 0;
    }

    @Override
    public int updateData(QuyenEntity Data) {
        return 0;
    }

    @Override
    public List<QuyenEntity> getAll() {
        return null;
    }


    public QuyenEntity quyenUser(String username){
        Session session = hibernateUtil.getSession();
        QuyenEntity quyenEntity= null;

//        try{
//            quyenEntity = session.load(QuyenEntity.class,username);
//
//
//        }catch (){
//
//        }

        return quyenEntity;
    }
}
