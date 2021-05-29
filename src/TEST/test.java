package TEST;
import DAO.taikhoanDao;
import DAO.logDao;
public class test {
    public static void main(String[] args) {
        logDao dao = new logDao();
        System.out.println(dao.getLog("20211A2255","HS20212118730"));
    }


}
