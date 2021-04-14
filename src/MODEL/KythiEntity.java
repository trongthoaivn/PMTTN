package MODEL;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Kythi", schema = "dbo", catalog = "TTN")
public class KythiEntity {
//    private Long id;
    private String maKt;
    private String tenKt;
    private Timestamp ngaythi;
    private Integer tgLambai;
    private Time tgBatdau;
    private Time tgKetthuc;
    private Integer slCh;
    private Collection<BodeEntity> bodesByMaKt;
    private Collection<KetquaEntity> ketquasByMaKt;
    private MonhocEntity monhocByMaMh;
    private GiaovienEntity giaovienByMaGv;
    private HocsinhEntity hocsinhByMaHs;

//    @Id
//    @GeneratedValue
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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
    public Time getTgBatdau() {
        return tgBatdau;
    }

    public void setTgBatdau(Time tgBatdau) {
        this.tgBatdau = tgBatdau;
    }

    @Basic
    @Column(name = "tg_Ketthuc")
    public Time getTgKetthuc() {
        return tgKetthuc;
    }

    public void setTgKetthuc(Time tgKetthuc) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KythiEntity that = (KythiEntity) o;
        return Objects.equals(maKt, that.maKt) && Objects.equals(tenKt, that.tenKt) && Objects.equals(ngaythi, that.ngaythi) && Objects.equals(tgLambai, that.tgLambai) && Objects.equals(tgBatdau, that.tgBatdau) && Objects.equals(tgKetthuc, that.tgKetthuc) && Objects.equals(slCh, that.slCh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKt, tenKt, ngaythi, tgLambai, tgBatdau, tgKetthuc, slCh);
    }

    @OneToMany(mappedBy = "kythiByMaKt")
    public Collection<BodeEntity> getBodesByMaKt() {
        return bodesByMaKt;
    }

    public void setBodesByMaKt(Collection<BodeEntity> bodesByMaKt) {
        this.bodesByMaKt = bodesByMaKt;
    }

    @OneToMany(mappedBy = "kythiByMaKt")
    public Collection<KetquaEntity> getKetquasByMaKt() {
        return ketquasByMaKt;
    }

    public void setKetquasByMaKt(Collection<KetquaEntity> ketquasByMaKt) {
        this.ketquasByMaKt = ketquasByMaKt;
    }

    @ManyToOne
    @JoinColumn(name = "ma_MH", referencedColumnName = "ma_MH")
    public MonhocEntity getMonhocByMaMh() {
        return monhocByMaMh;
    }

    public void setMonhocByMaMh(MonhocEntity monhocByMaMh) {
        this.monhocByMaMh = monhocByMaMh;
    }

    @ManyToOne
    @JoinColumn(name = "ma_GV", referencedColumnName = "ma_GV")
    public GiaovienEntity getGiaovienByMaGv() {
        return giaovienByMaGv;
    }

    public void setGiaovienByMaGv(GiaovienEntity giaovienByMaGv) {
        this.giaovienByMaGv = giaovienByMaGv;
    }

    @ManyToOne
    @JoinColumn(name = "ma_HS", referencedColumnName = "ma_HS")
    public HocsinhEntity getHocsinhByMaHs() {
        return hocsinhByMaHs;
    }

    public void setHocsinhByMaHs(HocsinhEntity hocsinhByMaHs) {
        this.hocsinhByMaHs = hocsinhByMaHs;
    }
}
