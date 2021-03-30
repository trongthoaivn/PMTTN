package MODEL;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Giaovien", schema = "dbo", catalog = "TTN")
public class GiaovienEntity {
    private Long id;
    private String maGv;
    private String tenGv;
    private Date ngaysinh;
    private String imgGv;
    private String username;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
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

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiaovienEntity that = (GiaovienEntity) o;
        return Objects.equals(maGv, that.maGv) && Objects.equals(tenGv, that.tenGv) && Objects.equals(ngaysinh, that.ngaysinh) && Objects.equals(imgGv, that.imgGv) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGv, tenGv, ngaysinh, imgGv, username);
    }
}
