package MODEL;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Ketqua", schema = "dbo", catalog = "TTN")
public class KetquaEntity {
    private Long id;
    private String maKq;
    private Timestamp ngaythi;
    private Double diem;
    private Boolean xeploai;
    private Collection<BaithiEntity> baithisByMaKq;
    private KythiEntity kythiByMaKt;
    private HocsinhEntity hocsinhByMaHs;

    public KetquaEntity(String maKq, Timestamp ngaythi, Double diem, Boolean xeploai, KythiEntity kythiByMaKt, HocsinhEntity hocsinhByMaHs) {
        this.maKq = maKq;
        this.ngaythi = ngaythi;
        this.diem = diem;
        this.xeploai = xeploai;
        this.kythiByMaKt = kythiByMaKt;
        this.hocsinhByMaHs = hocsinhByMaHs;
    }

    @Id
    @Column(name = "ma_KQ")
    public String getMaKq() {
        return maKq;
    }

    public void setMaKq(String maKq) {
        this.maKq = maKq;
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
    @Column(name = "diem")
    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double diem) {
        this.diem = diem;
    }

    @Basic
    @Column(name = "xeploai")
    public Boolean getXeploai() {
        return xeploai;
    }

    public void setXeploai(Boolean xeploai) {
        this.xeploai = xeploai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KetquaEntity that = (KetquaEntity) o;
        return Objects.equals(maKq, that.maKq) && Objects.equals(ngaythi, that.ngaythi) && Objects.equals(diem, that.diem) && Objects.equals(xeploai, that.xeploai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKq, ngaythi, diem, xeploai);
    }

    @OneToMany(mappedBy = "ketquaByMaKq")
    public Collection<BaithiEntity> getBaithisByMaKq() {
        return baithisByMaKq;
    }

    public void setBaithisByMaKq(Collection<BaithiEntity> baithisByMaKq) {
        this.baithisByMaKq = baithisByMaKq;
    }

    @ManyToOne
    @JoinColumn(name = "ma_KT", referencedColumnName = "ma_KT")
    public KythiEntity getKythiByMaKt() {
        return kythiByMaKt;
    }

    public void setKythiByMaKt(KythiEntity kythiByMaKt) {
        this.kythiByMaKt = kythiByMaKt;
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
