package MODEL;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Ketqua", schema = "dbo", catalog = "TTN")
public class KetquaEntity {
    private Long id;
    private String maKq;
    private Timestamp ngaythi;
    private Double diem;
    private Boolean xeploai;
    private String maKt;
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

    @Basic
    @Column(name = "ma_KT")
    public String getMaKt() {
        return maKt;
    }

    public void setMaKt(String maKt) {
        this.maKt = maKt;
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
        KetquaEntity that = (KetquaEntity) o;
        return Objects.equals(maKq, that.maKq) && Objects.equals(ngaythi, that.ngaythi) && Objects.equals(diem, that.diem) && Objects.equals(xeploai, that.xeploai) && Objects.equals(maKt, that.maKt) && Objects.equals(maHs, that.maHs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKq, ngaythi, diem, xeploai, maKt, maHs);
    }
}
