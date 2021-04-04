package MODEL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Quyen", schema = "dbo", catalog = "TTN")
public class QuyenEntity implements Serializable {
    private Long id;
    private int maQuyen;
    private String tenQuyen;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ma_Quyen")
    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(int maQuyen) {
        this.maQuyen = maQuyen;
    }

    @Basic
    @Column(name = "ten_Quyen")
    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuyenEntity that = (QuyenEntity) o;
        return maQuyen == that.maQuyen && Objects.equals(tenQuyen, that.tenQuyen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maQuyen, tenQuyen);
    }
}
