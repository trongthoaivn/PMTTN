package TCP;

import JSON.TaikhoanJson;
import MODEL.*;
import com.esotericsoftware.kryo.Kryo;


public class Register {
    public static void register(Kryo k){
        k.register(TaikhoanJson.class);
        k.register(java.util.ArrayList.class);
        k.register(org.hibernate.collection.internal.PersistentBag.class);
    }
}
