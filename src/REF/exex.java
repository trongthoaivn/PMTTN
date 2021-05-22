package REF;

import MODEL.HocsinhEntity;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class exex {
    public static void main(String[] args) {
        LocalDateTime localDateTime = java.time.LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yy hh:mm::"));
        System.out.println(localDateTime);
        System.out.println(localDateTime.getYear()+""
                +localDateTime.getDayOfMonth()+""
                +localDateTime.getHour()+""
                +localDateTime.getMinute()+""
                +localDateTime.getSecond());
    }


}

