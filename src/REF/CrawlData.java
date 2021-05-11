package REF;

import DAO.cauhoiDao;
import MODEL.BodeEntity;
import MODEL.CauhoiEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CrawlData {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.parse(new File("C:/Users/trong/Downloads/abc.html"), "UTF-8");
        Elements question = doc.select("div.panel-body");
        List<CauhoiEntity> list = new ArrayList<>();
        cauhoiDao dao = new cauhoiDao();
        AtomicInteger i = new AtomicInteger(dao.getEndindex());
        question.forEach(e ->{
            Elements tagP = e.getElementsByTag("p");
            Elements tagF = e.select("div.flex");
            Elements tagL = e.getElementsByClass("istrue");
            String cauhoi = tagP.text();
            String traloi = tagF.text();
            String dapan  = tagL.text();
            if(cauhoi.indexOf(":")!=-1){
                System.out.println(cauhoi);
                System.out.println(traloi);
                System.out.println(dapan.substring(0,1));
                list.add( new CauhoiEntity(
                        i.get() +1,
                        true,
                        cauhoi.substring(cauhoi.indexOf(":")+2,cauhoi.length()),
                        "","",
                        traloi.substring(traloi.indexOf("A.")+2,traloi.indexOf("B.")-1),
                        traloi.substring(traloi.indexOf("B.")+2,traloi.indexOf("C.")-1),
                        traloi.substring(traloi.indexOf("C.")+2,traloi.indexOf("D.")-1),
                        traloi.substring(traloi.indexOf("D.")+2,traloi.length()),
                        dapan.substring(0,1),
                        1,
                        new BodeEntity("BIO2020")
                ));
                i.getAndIncrement();
            }
        });
//        System.out.println(list.get(0).toDetail());
        System.out.println(dao.InsertorUpdate(list));
    }

}
