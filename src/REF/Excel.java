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
        Cell cell = row.createCell(1);
        cell.setCellValue(aCauhoi.getMaCh());

        cell = row.createCell(2);
        cell.setCellValue(aCauhoi.getLoai());

        cell = row.createCell(3);
        cell.setCellValue(aCauhoi.getNdCh());

        cell = row.createCell(4);
        cell.setCellValue(aCauhoi.getImgCh());

        cell = row.createCell(5);
        cell.setCellValue(aCauhoi.getAudCh());

        cell = row.createCell(6);
        cell.setCellValue(aCauhoi.getTl1());

        cell = row.createCell(7);
        cell.setCellValue(aCauhoi.getTl2());

        cell = row.createCell(8);
        cell.setCellValue(aCauhoi.getTl3());

        cell = row.createCell(9);
        cell.setCellValue(aCauhoi.getTl4());

        cell = row.createCell(10);
        cell.setCellValue(aCauhoi.getDa());

        cell = row.createCell(11);
        cell.setCellValue(aCauhoi.getDokho());

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
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFSheet sheet2 = wb.getSheetAt(1);
        BodeEntity bode = new BodeEntity(sheet2.getRow(0).getCell(3).getStringCellValue());
        List<CauhoiEntity> list = new ArrayList<>();
        for (Row row : sheet) {
            if (row!=null){
                Integer maCh = (int)row.getCell(1).getNumericCellValue();
                Boolean loai=row.getCell(2).getBooleanCellValue();
                String ndCh=row.getCell(3).getStringCellValue();
                String imgCh=row.getCell(4).getStringCellValue();
                String audCh=row.getCell(5).getStringCellValue();
                String tl1=row.getCell(6).getStringCellValue();
                String tl2=row.getCell(7).getStringCellValue();
                String tl3=row.getCell(8).getStringCellValue();
                String tl4=row.getCell(9).getStringCellValue();
                String da=row.getCell(10).getStringCellValue();
                Integer dokho=(int)row.getCell(11).getNumericCellValue();
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
