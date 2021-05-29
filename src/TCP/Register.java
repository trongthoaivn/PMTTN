package TCP;

import JSON.*;
import MODEL.*;
import com.esotericsoftware.kryo.Kryo;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;


public class Register {
    public static void register(Kryo k){
        k.register(TaikhoanJson.class);
        k.register(java.util.ArrayList.class);
        k.register(HocsinhJson.class);
        k.register(LocalDate.class, new LocalTimeSerializer());
        k.register(KythiJson.class);
        k.register(CauhoiJson.class);
        k.register(KetquaJson.class);
        k.register(org.hibernate.collection.internal.PersistentBag.class);
    }
}
