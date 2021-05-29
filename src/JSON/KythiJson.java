package JSON;


public class KythiJson {
    private String maKt;
    private String tenKt;
    private String ngaythi;
    private Integer tgLambai;
    private String tgBatdau;
    private String tgKetthuc;
    private Integer slCh;
    private String maMh;
    private String tenMh;

    public KythiJson(String maKt, String tenKt, String ngaythi, Integer tgLambai, String tgBatdau, String tgKetthuc, Integer slCh, String maMh, String tenMh) {
        this.maKt = maKt;
        this.tenKt = tenKt;
        this.ngaythi = ngaythi;
        this.tgLambai = tgLambai;
        this.tgBatdau = tgBatdau;
        this.tgKetthuc = tgKetthuc;
        this.slCh = slCh;
        this.maMh = maMh;
        this.tenMh = tenMh;
    }

    public KythiJson() {
    }

    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    public String getMaKt() {
        return maKt;
    }

    public void setMaKt(String maKt) {
        this.maKt = maKt;
    }

    public String getTenKt() {
        return tenKt;
    }

    public void setTenKt(String tenKt) {
        this.tenKt = tenKt;
    }

    public String getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(String ngaythi) {
        this.ngaythi = ngaythi;
    }

    public Integer getTgLambai() {
        return tgLambai;
    }

    public void setTgLambai(Integer tgLambai) {
        this.tgLambai = tgLambai;
    }

    public String getTgBatdau() {
        return tgBatdau;
    }

    public void setTgBatdau(String tgBatdau) {
        this.tgBatdau = tgBatdau;
    }

    public String getTgKetthuc() {
        return tgKetthuc;
    }

    public void setTgKetthuc(String tgKetthuc) {
        this.tgKetthuc = tgKetthuc;
    }

    public Integer getSlCh() {
        return slCh;
    }

    public void setSlCh(Integer slCh) {
        this.slCh = slCh;
    }
}
