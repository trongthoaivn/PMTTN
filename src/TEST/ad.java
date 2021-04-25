package TEST;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ad {
    public static void main(String[] args) throws ParseException {
        Timestamp ts = new Timestamp(new Date().getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = format.parse(ts.toString());
        format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(format.format(date));
    }
}
