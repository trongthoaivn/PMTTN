package MODEL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Lop", schema = "dbo", catalog = "TTN")
public class LopEntity implements Serializable {
    private Long id;
    private String maLop;
    private String tenLop;
    private String maKhoi;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ma_Lop")
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    @Basic
    @Column(name = "ten_Lop")
    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    @Basic
    @Column(name = "ma_Khoi")
    public String getMaKhoi() {
        return maKhoi;
    }

    public void setMaKhoi(String maKhoi) {
        this.maKhoi = maKhoi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LopEntity lopEntity = (LopEntity) o;
        return Objects.equals(maLop, lopEntity.maLop) && Objects.equals(tenLop, lopEntity.tenLop) && Objects.equals(maKhoi, lopEntity.maKhoi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLop, tenLop, maKhoi);
    }
}
