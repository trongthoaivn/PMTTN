package REF;


import DAO.cauhoiDao;
import DAO.madeDao;
import MODEL.BodeEntity;
import MODEL.CauhoiEntity;
import MODEL.MadeEntity;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Excel {


    private void writeCauhoi(CauhoiEntity aCauhoi, Row row) {
        HashCode DES = new HashCode();
        String key ="012ab3456cd789ef";
        Cell cell = row.createCell(1);
        cell.setCellValue(DES.encrypt(String.valueOf(aCauhoi.getMaCh()) ,key));

        cell = row.createCell(2);
        cell.setCellValue(DES.encrypt(String.valueOf(aCauhoi.getLoai()),key));

        cell = row.createCell(3);
        cell.setCellValue(DES.encrypt(aCauhoi.getNdCh(),key));

        cell = row.createCell(4);
        cell.setCellValue(DES.encrypt(aCauhoi.getImgCh(),key));

        cell = row.createCell(5);
        cell.setCellValue(DES.encrypt(aCauhoi.getAudCh(),key));

        cell = row.createCell(6);
        cell.setCellValue(DES.encrypt(aCauhoi.getTl1(),key));

        cell = row.createCell(7);
        cell.setCellValue(DES.encrypt(aCauhoi.getTl2(),key));

        cell = row.createCell(8);
        cell.setCellValue(DES.encrypt(aCauhoi.getTl3(),key));

        cell = row.createCell(9);
        cell.setCellValue(DES.encrypt(aCauhoi.getTl4(),key));

        cell = row.createCell(10);
        cell.setCellValue(DES.encrypt(aCauhoi.getDa(),key));

        cell = row.createCell(11);
        cell.setCellValue(DES.encrypt(String.valueOf(aCauhoi.getDokho()),key));

    }

    public void writeMade(MadeEntity made, Row row){
        Cell cell = row.createCell(1);
        cell.setCellValue(made.getMaDe());

        cell = row.createCell(2);
        cell.setCellValue(made.getTenMade());

        cell = row.createCell(3);
        cell.setCellValue(made.getBodeByMaBode().getMaBode());

    }
    public void writeExcel(List<CauhoiEntity> list,MadeEntity made, String excelFilePath) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Cauhoi");
        Sheet sheet2 =workbook.createSheet("Made");

        int rowCount = 0;

        Row row2 =sheet2.createRow(rowCount);
        writeMade(made,row2);

        for (CauhoiEntity aCauhoi : list) {
            Row row = sheet.createRow(++rowCount);
            writeCauhoi(aCauhoi, row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }

    }

    public List<CauhoiEntity> readExcel(String excelFilePath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        String key ="012ab3456cd789ef";
        HashCode Des = new HashCode();
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFSheet sheet2 = wb.getSheetAt(1);
        BodeEntity bode = new BodeEntity(sheet2.getRow(0).getCell(3).getStringCellValue());
        List<CauhoiEntity> list = new ArrayList<>();
        for (Row row : sheet) {
            if (row!=null){
                Integer maCh = Integer.valueOf(Des.decrypt(row.getCell(1).getStringCellValue(),key));
                Boolean loai=Boolean.valueOf(Des.decrypt(row.getCell(2).getStringCellValue(),key));
                String ndCh=String.valueOf(Des.decrypt(row.getCell(3).getStringCellValue(),key));
                String imgCh=String.valueOf(Des.decrypt(row.getCell(4).getStringCellValue(),key));
                String audCh=String.valueOf(Des.decrypt(row.getCell(5).getStringCellValue(),key));
                String tl1=String.valueOf(Des.decrypt(row.getCell(6).getStringCellValue(),key));
                String tl2=String.valueOf(Des.decrypt(row.getCell(7).getStringCellValue(),key));
                String tl3=String.valueOf(Des.decrypt(row.getCell(8).getStringCellValue(),key));
                String tl4=String.valueOf(Des.decrypt(row.getCell(9).getStringCellValue(),key));
                String da=String.valueOf(Des.decrypt(row.getCell(10).getStringCellValue(),key));
                Integer dokho=Integer.valueOf(Des.decrypt(row.getCell(11).getStringCellValue(),key));
                CauhoiEntity acauhoi = new CauhoiEntity(maCh,loai,ndCh,imgCh,audCh,tl1,tl2,tl3,tl4,da,dokho,bode);
                list.add(acauhoi);
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
            Excel excel = new Excel();
//        cauhoiDao dao = new cauhoiDao();
//        madeDao dao1 = new madeDao();
//        MadeEntity madeEntity= dao1.getMadebyMadeid("BIO2020123");
//        List<CauhoiEntity> list = dao.getQuestionbyCodeasList(madeEntity.getBodeByMaBode().getMaBode());
//        excel.writeExcel(list,madeEntity,"src/XLS/test.xls");
        System.out.println(excel.readExcel("src/XLS/test.xls").get(0).toDetail())   ;
    }
}
