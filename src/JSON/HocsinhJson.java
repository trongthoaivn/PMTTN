package JSON;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class HocsinhJson implements Serializable {
    private String maHs;
    private String tenHs;
    private LocalDate ngaysinh;
    private String lopByMaLop;

    public HocsinhJson(String maHs, String tenHs, LocalDate ngaysinh, String lopByMaLop) {
        this.maHs = maHs;
        this.tenHs = tenHs;
        this.ngaysinh = ngaysinh;
        this.lopByMaLop = lopByMaLop;
    }

    public HocsinhJson(String maHs) {
        this.maHs = maHs;
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

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getLopByMaLop() {
        return lopByMaLop;
    }

    public void setLopByMaLop(String lopByMaLop) {
        this.lopByMaLop = lopByMaLop;
    }
}
