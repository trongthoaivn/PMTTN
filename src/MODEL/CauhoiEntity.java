package MODEL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Cauhoi", schema = "dbo", catalog = "TTN")
public class CauhoiEntity {
    private Long id;
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
    private BodeEntity bodeByMaBode;

    public CauhoiEntity(int maCh,String ndCh, String tl1, String tl2, String tl3, String tl4, String da,BodeEntity bodeByMaBode) {
        this.maCh = maCh;
        this.ndCh = ndCh;
        this.tl1 = tl1;
        this.tl2 = tl2;
        this.tl3 = tl3;
        this.tl4 = tl4;
        this.da = da;
        this.bodeByMaBode = bodeByMaBode;
    }

    public CauhoiEntity(int maCh, Boolean loai, String ndCh, String imgCh, String audCh, String tl1, String tl2, String tl3, String tl4, String da, Integer dokho, BodeEntity bodeByMaBode) {
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
        this.bodeByMaBode = bodeByMaBode;
    }

    public CauhoiEntity() {
    }

    @Override
    public String toString() {
        return
                "Câu hỏi : " + maCh ;

    }

    public String toDetail() {
        return "CauhoiEntity{" +
                " maCh=" + maCh +
                ", loai=" + loai +
                ", ndCh='" + ndCh + '\'' +
                ", imgCh='" + imgCh + '\'' +
                ", audCh='" + audCh + '\'' +
                ", tl1='" + tl1 + '\'' +
                ", tl2='" + tl2 + '\'' +
                ", tl3='" + tl3 + '\'' +
                ", tl4='" + tl4 + '\'' +
                ", da='" + da + '\'' +
                ", dokho=" + dokho +
                ", bodeByMaBode=" + bodeByMaBode +
                '}';
    }


    @Id
    @Column(name = "ma_CH")
    public int getMaCh() {
        return maCh;
    }

    public void setMaCh(int maCh) {
        this.maCh = maCh;
    }

    @Basic
    @Column(name = "loai")
    public Boolean getLoai() {
        return loai;
    }

    public void setLoai(Boolean loai) {
        this.loai = loai;
    }

    @Basic
    @Column(name = "nd_CH")
    public String getNdCh() {
        return ndCh;
    }

    public void setNdCh(String ndCh) {
        this.ndCh = ndCh;
    }

    @Basic
    @Column(name = "img_CH")
    public String getImgCh() {
        return imgCh;
    }

    public void setImgCh(String imgCh) {
        this.imgCh = imgCh;
    }

    @Basic
    @Column(name = "aud_CH")
    public String getAudCh() {
        return audCh;
    }

    public void setAudCh(String audCh) {
        this.audCh = audCh;
    }

    @Basic
    @Column(name = "TL_1")
    public String getTl1() {
        return tl1;
    }

    public void setTl1(String tl1) {
        this.tl1 = tl1;
    }

    @Basic
    @Column(name = "TL_2")
    public String getTl2() {
        return tl2;
    }

    public void setTl2(String tl2) {
        this.tl2 = tl2;
    }

    @Basic
    @Column(name = "TL_3")
    public String getTl3() {
        return tl3;
    }

    public void setTl3(String tl3) {
        this.tl3 = tl3;
    }

    @Basic
    @Column(name = "TL_4")
    public String getTl4() {
        return tl4;
    }

    public void setTl4(String tl4) {
        this.tl4 = tl4;
    }

    @Basic
    @Column(name = "DA")
    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    @Basic
    @Column(name = "dokho")
    public Integer getDokho() {
        return dokho;
    }

    public void setDokho(Integer dokho) {
        this.dokho = dokho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CauhoiEntity that = (CauhoiEntity) o;
        return maCh == that.maCh && Objects.equals(loai, that.loai) && Objects.equals(ndCh, that.ndCh) && Objects.equals(imgCh, that.imgCh) && Objects.equals(audCh, that.audCh) && Objects.equals(tl1, that.tl1) && Objects.equals(tl2, that.tl2) && Objects.equals(tl3, that.tl3) && Objects.equals(tl4, that.tl4) && Objects.equals(da, that.da) && Objects.equals(dokho, that.dokho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maCh, loai, ndCh, imgCh, audCh, tl1, tl2, tl3, tl4, da, dokho);
    }

    @ManyToOne
    @JoinColumn(name = "ma_Bode", referencedColumnName = "ma_Bode")
    public BodeEntity getBodeByMaBode() {
        return bodeByMaBode;
    }

    public void setBodeByMaBode(BodeEntity bodeByMaBode) {
        this.bodeByMaBode = bodeByMaBode;
    }
}
