package MODEL;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Kythi", schema = "dbo", catalog = "TTN")
public class KythiEntity {
    private Long id;
    private String maKt;
    private String tenKt;
    private Timestamp ngaythi;
    private Integer tgLambai;
    private Object tgBatdau;
    private Object tgKetthuc;
    private Integer slCh;
    private String maMh;
    private String maGv;
    private String maHs;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ma_KT")
    public String getMaKt() {
        return maKt;
    }

    public void setMaKt(String maKt) {
        this.maKt = maKt;
    }

    @Basic
    @Column(name = "ten_KT")
    public String getTenKt() {
        return tenKt;
    }

    public void setTenKt(String tenKt) {
        this.tenKt = tenKt;
    }

    @Basic
    @Column(name = "ngaythi")
    public Timestamp getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(Timestamp ngaythi) {
        this.ngaythi = ngaythi;
    }

    @Basic
    @Column(name = "tg_Lambai")
    public Integer getTgLambai() {
        return tgLambai;
    }

    public void setTgLambai(Integer tgLambai) {
        this.tgLambai = tgLambai;
    }

    @Basic
    @Column(name = "tg_Batdau")
    public Object getTgBatdau() {
        return tgBatdau;
    }

    public void setTgBatdau(Object tgBatdau) {
        this.tgBatdau = tgBatdau;
    }

    @Basic
    @Column(name = "tg_Ketthuc")
    public Object getTgKetthuc() {
        return tgKetthuc;
    }

    public void setTgKetthuc(Object tgKetthuc) {
        this.tgKetthuc = tgKetthuc;
    }

    @Basic
    @Column(name = "sl_CH")
    public Integer getSlCh() {
        return slCh;
    }

    public void setSlCh(Integer slCh) {
        this.slCh = slCh;
    }

    @Basic
    @Column(name = "ma_MH")
    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    @Basic
    @Column(name = "ma_GV")
    public String getMaGv() {
        return maGv;
    }

    public void setMaGv(String maGv) {
        this.maGv = maGv;
    }

    @Basic
    @Column(name = "ma_HS")
    public String getMaHs() {
        return maHs;
    }

    public void setMaHs(String maHs) {
        this.maHs = maHs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KythiEntity that = (KythiEntity) o;
        return Objects.equals(maKt, that.maKt) && Objects.equals(tenKt, that.tenKt) && Objects.equals(ngaythi, that.ngaythi) && Objects.equals(tgLambai, that.tgLambai) && Objects.equals(tgBatdau, that.tgBatdau) && Objects.equals(tgKetthuc, that.tgKetthuc) && Objects.equals(slCh, that.slCh) && Objects.equals(maMh, that.maMh) && Objects.equals(maGv, that.maGv) && Objects.equals(maHs, that.maHs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKt, tenKt, ngaythi, tgLambai, tgBatdau, tgKetthuc, slCh, maMh, maGv, maHs);
    }
}
