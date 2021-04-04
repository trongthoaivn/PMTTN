package MODEL;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "Hocsinh", schema = "dbo", catalog = "TTN")
public class HocsinhEntity implements Serializable {
    private Long id;
    private String maHs;
    private String tenHs;
    private Date ngaysinh;
    private byte[] imgHs;
    private String maLop;
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
    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    @Basic
    @Column(name = "img_HS")
    public byte[] getImgHs() {
        return imgHs;
    }

    public void setImgHs(byte[] imgHs) {
        this.imgHs = imgHs;
    }

    @Basic
    @Column(name = "ma_Lop")
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
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
        HocsinhEntity that = (HocsinhEntity) o;
        return Objects.equals(maHs, that.maHs) && Objects.equals(tenHs, that.tenHs) && Objects.equals(ngaysinh, that.ngaysinh) && Arrays.equals(imgHs, that.imgHs) && Objects.equals(maLop, that.maLop) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(maHs, tenHs, ngaysinh, maLop, username);
        result = 31 * result + Arrays.hashCode(imgHs);
        return result;
    }
}
