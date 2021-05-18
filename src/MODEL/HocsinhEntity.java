package MODEL;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Hocsinh", schema = "dbo", catalog = "TTN")
public class HocsinhEntity {
    private Long id;
    private String maHs;
    private String tenHs;
    private Timestamp ngaysinh;
    private String imgHs;
    private LopEntity lopByMaLop;
    private TaikhoanEntity taikhoanByUsername;
    private Collection<KetquaEntity> ketquasByMaHs;
    private Collection<KythiEntity> kythisByMaHs;

    public HocsinhEntity(String maHs, String tenHs, Timestamp ngaysinh, String imgHs, TaikhoanEntity taikhoanByUsername) {
        this.maHs = maHs;
        this.tenHs = tenHs;
        this.ngaysinh = ngaysinh;
        this.imgHs = imgHs;
        this.taikhoanByUsername = taikhoanByUsername;
    }

    public HocsinhEntity(String maHs, String tenHs, Timestamp ngaysinh, String imgHs, LopEntity lopByMaLop, TaikhoanEntity taikhoanByUsername) {
        this.maHs = maHs;
        this.tenHs = tenHs;
        this.ngaysinh = ngaysinh;
        this.imgHs = imgHs;
        this.lopByMaLop = lopByMaLop;
        this.taikhoanByUsername = taikhoanByUsername;
    }

    public HocsinhEntity() {
    }

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
    @Column(name = "ma_HS")
    public String getMaHs() {
        return maHs;
    }

    public void setMaHs(String maHs) {
        this.maHs = maHs;
    }

    @Basic
    @Column(name = "ten_HS")
    public String getTenHs() {
        return tenHs;
    }

    public void setTenHs(String tenHs) {
        this.tenHs = tenHs;
    }

    @Basic
    @Column(name = "ngaysinh")
    public Timestamp getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Timestamp ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    @Basic
    @Column(name = "img_HS")
    public String getImgHs() {
        return imgHs;
    }

    public void setImgHs(String imgHs) {
        this.imgHs = imgHs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HocsinhEntity that = (HocsinhEntity) o;
        return Objects.equals(maHs, that.maHs) && Objects.equals(tenHs, that.tenHs) && Objects.equals(ngaysinh, that.ngaysinh) && Objects.equals(imgHs, that.imgHs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHs, tenHs, ngaysinh, imgHs);
    }

    @ManyToOne
    @JoinColumn(name = "ma_Lop", referencedColumnName = "ma_Lop")
    public LopEntity getLopByMaLop() {
        return lopByMaLop;
    }

    public void setLopByMaLop(LopEntity lopByMaLop) {
        this.lopByMaLop = lopByMaLop;
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    public TaikhoanEntity getTaikhoanByUsername() {
        return taikhoanByUsername;
    }

    public void setTaikhoanByUsername(TaikhoanEntity taikhoanByUsername) {
        this.taikhoanByUsername = taikhoanByUsername;
    }

    @OneToMany(mappedBy = "hocsinhByMaHs")
    public Collection<KetquaEntity> getKetquasByMaHs() {
        return ketquasByMaHs;
    }

    public void setKetquasByMaHs(Collection<KetquaEntity> ketquasByMaHs) {
        this.ketquasByMaHs = ketquasByMaHs;
    }

    @OneToMany(mappedBy = "hocsinhByMaHs")
    public Collection<KythiEntity> getKythisByMaHs() {
        return kythisByMaHs;
    }

    public void setKythisByMaHs(Collection<KythiEntity> kythisByMaHs) {
        this.kythisByMaHs = kythisByMaHs;
    }
}
