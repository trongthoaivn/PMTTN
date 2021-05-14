package REF;

import DAO.cauhoiDao;
import DAO.madeDao;
import MODEL.BodeEntity;
import MODEL.CauhoiEntity;
import MODEL.MadeEntity;
import MODEL.MadeJson;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionJson {

    public void WriteQuestionJsonFile(MadeEntity made, List<CauhoiEntity> list){
        Gson gson = new Gson();
        List<MadeJson.Cauhoimd> cauhoimd = null;
        for (CauhoiEntity ch :list){
//            MadeJson.Cauhoimd element = new MadeJson.Cauhoimd(
//                    ch.getMaCh(), ch.getLoai(), ch.getImgCh(),
//                    ch.getAudCh(),ch.getNdCh(),ch.getTl1(),
//                    ch.getTl2(),ch.getTl3(),ch.getTl4(),
//                    ch.getDa(),ch.getDokho()
//                    );
//            cauhoimd.add(element);
        }
        MadeJson madeJson = new MadeJson(made.getMaDe(), made.getTenMade(), made.getBodeByMaBode().getMaBode(), cauhoimd);
        try (FileWriter writer = new FileWriter("C:/Users/trong/Desktop/test.json")) {
            gson.toJson(madeJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
