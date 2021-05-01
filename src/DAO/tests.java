package DAO;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class tests {
    public static void main(String[] args) {
//        taikhoanDao taikhoanDao =  new taikhoanDao();
//        QuyenEntity quyenEntity= new QuyenEntity(1,"Giáo viên");
//        TaikhoanEntity taikhoanEntity = new TaikhoanEntity("gv1","abc@123",Boolean.TRUE,quyenEntity);
//        taikhoanDao.addData(taikhoanEntity);
        Desktop desktop = Desktop.getDesktop();
        File file = new File("src/VIEW/Image/backgroud_login.jpg");
        try {
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
