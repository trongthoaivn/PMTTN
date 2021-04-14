package MODEL;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Admin", schema = "dbo", catalog = "TTN")
public class AdminEntity implements Serializable {
//    private Long id;
    private String maAd;
    private String tenAd;
    private Timestamp ngaysinh;
    private String imgAd;
    private TaikhoanEntity taikhoanByUsername;

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
    @Column(name = "ma_Ad")
    public String getMaAd() {
        return maAd;
    }

    public void setMaAd(String maAd) {
        this.maAd = maAd;
    }

    @Basic
    @Column(name = "ten_Ad")
    public String getTenAd() {
        return tenAd;
    }

    public void setTenAd(String tenAd) {
        this.tenAd = tenAd;
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
    @Column(name = "img_Ad")
    public String getImgAd() {
        return imgAd;
    }

    public void setImgAd(String imgAd) {
        this.imgAd = imgAd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminEntity that = (AdminEntity) o;
        return Objects.equals(maAd, that.maAd) && Objects.equals(tenAd, that.tenAd) && Objects.equals(ngaysinh, that.ngaysinh) && Objects.equals(imgAd, that.imgAd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maAd, tenAd, ngaysinh, imgAd);
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    public TaikhoanEntity getTaikhoanByUsername() {
        return taikhoanByUsername;
    }

    public void setTaikhoanByUsername(TaikhoanEntity taikhoanByUsername) {
        this.taikhoanByUsername = taikhoanByUsername;
    }
}
