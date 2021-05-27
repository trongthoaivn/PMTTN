package TCP;

import DAO.taikhoanDao;
import JSON.TaikhoanJson;
import MODEL.TaikhoanEntity;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import CONTROLLER.ct_Network;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;;

public class Server extends Listener {
    static com.esotericsoftware.kryonet.Server server;
    static int tcpPort = 54777;
    public static void start(){
        try {
            server = new com.esotericsoftware.kryonet.Server();
            Register.register(server.getKryo());
            server.bind(tcpPort);
            server.start();
            server.addListener(new Server());
            ct_Network.txt_status.appendText("Connect as Host\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void send(Object o){
        if(o instanceof TaikhoanEntity){
            server.sendToAllTCP(o);
        }

    }
    public void received(Connection c, Object o){
        if ( o instanceof String){
            if(String.valueOf(o).equals("Login")){
                taikhoanDao dao = new taikhoanDao();
                List<TaikhoanEntity> list =  dao.getlist();
                List<TaikhoanJson> list1 = new ArrayList<>();
                for (TaikhoanEntity atk : list){
                    list1.add(new TaikhoanJson(atk.getUsername(), atk.getPasswords(),1));
                }
                server.sendToTCP(c.getID(),list1);
            }
            ct_Network.txt_status.appendText(String.valueOf(o));
        }
    }
    public void connected(Connection c){
       ct_Network.txt_status.appendText("["+c.getRemoteAddressTCP().getHostString()+ " Connected]\n");
    }


    public void disconnected(Connection c){
        ct_Network.txt_status.appendText("[Connection "+c.getID() + " Disconnected]\n");
    }

    public static void close(){
        ct_Network.txt_status.appendText("[Disconnected]\n");
        server.close();
    }

    public String returnstr(){
        return String.valueOf(tcpPort);
    }
}
