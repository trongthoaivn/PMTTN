package DAO;

import MODEL.QuyenEntity;
import MODEL.TaikhoanEntity;

public class tests {
    public static void main(String[] args) {
        taikhoanDao taikhoanDao =  new taikhoanDao();
        QuyenEntity quyenEntity= new QuyenEntity(1,"Giáo viên");
        TaikhoanEntity taikhoanEntity = new TaikhoanEntity("gv1","abc@123",Boolean.TRUE,quyenEntity);
        taikhoanDao.addData(taikhoanEntity);
    }
}
