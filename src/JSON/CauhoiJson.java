package JSON;

import java.io.Serializable;

public class CauhoiJson implements Serializable {
    private int maCh;
    private Boolean loai;
    private String ndCh;
    private String imgCh;
    private String audCh;
    private String tl1;
    private String tl2;
    private String tl3;
    private String tl4;
    private String da;
    private Integer dokho;


    public CauhoiJson(int maCh, Boolean loai, String ndCh, String imgCh, String audCh, String tl1, String tl2, String tl3, String tl4, String da, Integer dokho) {
        this.maCh = maCh;
        this.loai = loai;
        this.ndCh = ndCh;
        this.imgCh = imgCh;
        this.audCh = audCh;
        this.tl1 = tl1;
        this.tl2 = tl2;
        this.tl3 = tl3;
        this.tl4 = tl4;
        this.da = da;
        this.dokho = dokho;
    }

    public CauhoiJson() {
    }

    public int getMaCh() {
        return maCh;
    }

    public void setMaCh(int maCh) {
        this.maCh = maCh;
    }

    public Boolean getLoai() {
        return loai;
    }

    public void setLoai(Boolean loai) {
        this.loai = loai;
    }

    public String getNdCh() {
        return ndCh;
    }

    public void setNdCh(String ndCh) {
        this.ndCh = ndCh;
    }

    public String getImgCh() {
        return imgCh;
    }

    public void setImgCh(String imgCh) {
        this.imgCh = imgCh;
    }

    public String getAudCh() {
        return audCh;
    }

    public void setAudCh(String audCh) {
        this.audCh = audCh;
    }

    public String getTl1() {
        return tl1;
    }

    public void setTl1(String tl1) {
        this.tl1 = tl1;
    }

    public String getTl2() {
        return tl2;
    }

    public void setTl2(String tl2) {
        this.tl2 = tl2;
    }

    public String getTl3() {
        return tl3;
    }

    public void setTl3(String tl3) {
        this.tl3 = tl3;
    }

    public String getTl4() {
        return tl4;
    }

    public void setTl4(String tl4) {
        this.tl4 = tl4;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public Integer getDokho() {
        return dokho;
    }

    public void setDokho(Integer dokho) {
        this.dokho = dokho;
    }
}
