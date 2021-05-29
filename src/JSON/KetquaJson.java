package JSON;

import java.time.LocalDate;

public class KetquaJson {
    private String maKq;
    private String ngaythi;
    private Double diem;
    private Boolean xeploai;
    private String kythiByMaKt;
    private String hocsinhByMaHs;


    public KetquaJson(String maKq, String ngaythi, Double diem, Boolean xeploai, String kythiByMaKt, String hocsinhByMaHs) {
        this.maKq = maKq;
        this.ngaythi = ngaythi;
        this.diem = diem;
        this.xeploai = xeploai;
        this.kythiByMaKt = kythiByMaKt;
        this.hocsinhByMaHs = hocsinhByMaHs;
    }

    public KetquaJson() {
    }

    @Override
    public String toString() {
        return "KetquaJson{" +
                "maKq='" + maKq + '\'' +
                ", ngaythi='" + ngaythi + '\'' +
                ", diem=" + diem +
                ", xeploai=" + xeploai +
                ", kythiByMaKt='" + kythiByMaKt + '\'' +
                ", hocsinhByMaHs='" + hocsinhByMaHs + '\'' +
                '}';
    }

    public String getMaKq() {
        return maKq;
    }

    public void setMaKq(String maKq) {
        this.maKq = maKq;
    }

    public String getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(String ngaythi) {
        this.ngaythi = ngaythi;
    }

    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double diem) {
        this.diem = diem;
    }

    public Boolean getXeploai() {
        return xeploai;
    }

    public void setXeploai(Boolean xeploai) {
        this.xeploai = xeploai;
    }

    public String getKythiByMaKt() {
        return kythiByMaKt;
    }

    public void setKythiByMaKt(String kythiByMaKt) {
        this.kythiByMaKt = kythiByMaKt;
    }

    public String getHocsinhByMaHs() {
        return hocsinhByMaHs;
    }

    public void setHocsinhByMaHs(String hocsinhByMaHs) {
        this.hocsinhByMaHs = hocsinhByMaHs;
    }
}
