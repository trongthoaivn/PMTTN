package JSON;

import java.sql.Timestamp;

public class HocsinhJson {
    private String maHs;
    private String tenHs;
    private Timestamp ngaysinh;
    private String lopByMaLop;

    public HocsinhJson(String maHs, String tenHs, Timestamp ngaysinh, String lopByMaLop) {
        this.maHs = maHs;
        this.tenHs = tenHs;
        this.ngaysinh = ngaysinh;
        this.lopByMaLop = lopByMaLop;
    }

    public HocsinhJson() {
    }

    public String getMaHs() {
        return maHs;
    }

    public void setMaHs(String maHs) {
        this.maHs = maHs;
    }

    public String getTenHs() {
        return tenHs;
    }

    public void setTenHs(String tenHs) {
        this.tenHs = tenHs;
    }

    public Timestamp getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Timestamp ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getLopByMaLop() {
        return lopByMaLop;
    }

    public void setLopByMaLop(String lopByMaLop) {
        this.lopByMaLop = lopByMaLop;
    }
}
