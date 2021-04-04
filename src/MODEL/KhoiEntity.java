package MODEL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Khoi", schema = "dbo", catalog = "TTN")
public class KhoiEntity implements Serializable {
    private Long id;
    private String maKhoi;
    private String tenKhoi;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ma_Khoi")
    public String getMaKhoi() {
        return maKhoi;
    }

    public void setMaKhoi(String maKhoi) {
        this.maKhoi = maKhoi;
    }

    @Basic
    @Column(name = "ten_Khoi")
    public String getTenKhoi() {
        return tenKhoi;
    }

    public void setTenKhoi(String tenKhoi) {
        this.tenKhoi = tenKhoi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhoiEntity that = (KhoiEntity) o;
        return Objects.equals(maKhoi, that.maKhoi) && Objects.equals(tenKhoi, that.tenKhoi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKhoi, tenKhoi);
    }
}
