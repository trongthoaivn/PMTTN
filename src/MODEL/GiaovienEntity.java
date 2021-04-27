package MODEL;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Giaovien", schema = "dbo", catalog = "TTN")
public class GiaovienEntity {
//    private Long id;
    private String maGv;
    private String tenGv;
    private Timestamp ngaysinh;
    private String imgGv;
    private TaikhoanEntity taikhoanByUsername;
    private Collection<KythiEntity> kythisByMaGv;

//    @Id
//    @GeneratedValue
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }


    public GiaovienEntity() {
    }

    public GiaovienEntity(String maGv, String tenGv, Timestamp ngaysinh, String imgGv, TaikhoanEntity taikhoanByUsername) {
        this.maGv = maGv;
        this.tenGv = tenGv;
        this.ngaysinh = ngaysinh;
        this.imgGv = imgGv;
        this.taikhoanByUsername = taikhoanByUsername;

    }

    @Id
    @Column(name = "ma_GV")
    public String getMaGv() {
        return maGv;
    }

    public void setMaGv(String maGv) {
        this.maGv = maGv;
    }

    @Basic
    @Column(name = "ten_GV")
    public String getTenGv() {
        return tenGv;
    }

    public void setTenGv(String tenGv) {
        this.tenGv = tenGv;
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
    @Column(name = "img_GV")
    public String getImgGv() {
        return imgGv;
    }

    public void setImgGv(String imgGv) {
        this.imgGv = imgGv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiaovienEntity that = (GiaovienEntity) o;
        return Objects.equals(maGv, that.maGv) && Objects.equals(tenGv, that.tenGv) && Objects.equals(ngaysinh, that.ngaysinh) && Objects.equals(imgGv, that.imgGv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGv, tenGv, ngaysinh, imgGv);
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    public TaikhoanEntity getTaikhoanByUsername() {
        return taikhoanByUsername;
    }

    public void setTaikhoanByUsername(TaikhoanEntity taikhoanByUsername) {
        this.taikhoanByUsername = taikhoanByUsername;
    }

    @OneToMany(mappedBy = "giaovienByMaGv")
    public Collection<KythiEntity> getKythisByMaGv() {
        return kythisByMaGv;
    }

    public void setKythisByMaGv(Collection<KythiEntity> kythisByMaGv) {
        this.kythisByMaGv = kythisByMaGv;
    }
}
