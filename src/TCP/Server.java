package TCP;

import DAO.*;
import JSON.*;
import MODEL.*;
import REF.Excel;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import CONTROLLER.ct_Network;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;;

public class Server extends Listener {
    static com.esotericsoftware.kryonet.Server server;
    static int tcpPort = 54777;
    public static void start(){
        try {
            server = new com.esotericsoftware.kryonet.Server(16384, 8192);
            Register.register(server.getKryo());
            server.bind(tcpPort);
            server.start();
            server.addListener(new Server() );
            ct_Network.txt_status.appendText("Connect as Host\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void send(Object o){
        if(o instanceof TaikhoanEntity){
            server.sendToAllTCP(o);
        }
        if (o instanceof TaikhoanJson){
            server.sendToAllTCP(o);
        }

    }
    public void received(Connection c, Object o){
        System.out.println(o.getClass());
        if ( o instanceof String){
            if(String.valueOf(o).equals("Login")){
                taikhoanDao dao = new taikhoanDao();
                List<TaikhoanEntity> list = dao.getTkbytoDay();
                List<TaikhoanJson> list1 = new ArrayList<>();
                for (TaikhoanEntity atk : list){
                    list1.add(new TaikhoanJson(atk.getUsername(), atk.getPasswords(),1));
                }
                server.sendToTCP(c.getID(),list1);
                ct_Network.txt_status.appendText(String.valueOf(o)+"\n");
            }
            if(String.valueOf(o).startsWith("HS")){
                kythiDao dao = new kythiDao();
                KythiEntity tk = new KythiEntity();
                tk = dao.getTkbyTS(String.valueOf(o));
                KythiJson tkjs = new KythiJson(
                  tk.getMaKt(),
                  tk.getTenKt(),
                  tk.getNgaythi().toString(),
                  tk.getTgLambai(),
                  tk.getTgBatdau().toString(),
                  tk.getTgKetthuc().toString(),
                  tk.getSlCh(),
                  tk.getMonhocByMaMh().getMaMh(),
                  tk.getMonhocByMaMh().getTenMh()
                );
                server.sendToTCP(c.getID(),tkjs);
                ct_Network.txt_status.appendText(tkjs.toString()+"\n");
            }
            if(String.valueOf(o).startsWith("KT")){
                if(true){
                    String str =String.valueOf(o);
                    String maHS =str.substring(str.indexOf("_")+1,str.lastIndexOf("_"));
                    String maKT =str.substring(str.lastIndexOf("_")+1,str.length());
                    madeDao dao = new madeDao();
                    String file =dao.getMadebyClient(maHS,maKT);
                    Excel excel = new Excel();
                    try {
                        List<CauhoiEntity> list =excel.readExcel(file);
                        List<CauhoiJson> jsonList = new ArrayList<>();
                        for (CauhoiEntity ch :list){
                            jsonList.add( new CauhoiJson(ch.getMaCh(),
                                    ch.getLoai(),
                                    ch.getNdCh(),
                                    ch.getAudCh(),
                                    ch.getImgCh(),
                                    ch.getTl1(),
                                    ch.getTl2(),
                                    ch.getTl3(),
                                    ch.getTl4(),
                                    ch.getDa(),
                                    ch.getDokho()));
                        }
                        server.sendToTCP(c.getID(),jsonList);
                        System.out.println(jsonList.size());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
        if(o instanceof HocsinhJson){

            hocsinhDao dao = new hocsinhDao();
            String maHS  =((HocsinhJson) o).getMaHs();
            HocsinhEntity hs = dao.getHSbyTK(maHS);
            HocsinhJson hsjs = new HocsinhJson(hs.getMaHs(),hs.getTenHs(),hs.getNgaysinh().toLocalDateTime().toLocalDate(), hs.getLopByMaLop().getTenLop());
            server.sendToTCP(c.getID(),hsjs);
            ct_Network.txt_status.appendText(hs.toString()+"\n");
        }
        if (o instanceof KetquaJson){
            System.out.println(o.toString());
            KetquaJson kqjs = (KetquaJson) o;
            HocsinhEntity hs = new HocsinhEntity(kqjs.getHocsinhByMaHs());
            KythiEntity kt = new KythiEntity(kqjs.getKythiByMaKt());
            System.out.println(kqjs.toString());
            KetquaEntity kq = new KetquaEntity(
                    kqjs.getMaKq(),
                    Timestamp.valueOf(kqjs.getNgaythi()),
                    kqjs.getDiem(),
                    kqjs.getXeploai(),
                    kt,
                    hs
            );
            ketquaDao dao = new ketquaDao();
            System.out.println(dao.addData(kq));
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
