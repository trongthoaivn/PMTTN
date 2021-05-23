package MODEL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Thisinh", schema = "dbo", catalog = "TTN")
@IdClass(ThisinhEntityPK.class)
public class ThisinhEntity {
    private Long id;
    private String maKt;
    private String maHs;
    private KythiEntity kythiByMaKt;
    private HocsinhEntity hocsinhByMaHs;

    public ThisinhEntity() {
    }

    public ThisinhEntity(String maKt, String maHs) {
        this.maKt = maKt;
        this.maHs = maHs;
    }

    @Id
    @Column(name = "ma_KT")
    public String getMaKt() {
        return maKt;
    }

    public void setMaKt(String maKt) {
        this.maKt = maKt;
    }

    @Id
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
        ThisinhEntity that = (ThisinhEntity) o;
        return Objects.equals(maKt, that.maKt) && Objects.equals(maHs, that.maHs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKt, maHs);
    }

    @ManyToOne
    @JoinColumn(name = "ma_KT", referencedColumnName = "ma_KT", nullable = false, insertable = false, updatable = false)
    public KythiEntity getKythiByMaKt() {
        return kythiByMaKt;
    }

    public void setKythiByMaKt(KythiEntity kythiByMaKt) {
        this.kythiByMaKt = kythiByMaKt;
    }

    @ManyToOne
    @JoinColumn(name = "ma_HS", referencedColumnName = "ma_HS", nullable = false,insertable = false, updatable = false)
    public HocsinhEntity getHocsinhByMaHs() {
        return hocsinhByMaHs;
    }

    public void setHocsinhByMaHs(HocsinhEntity hocsinhByMaHs) {
        this.hocsinhByMaHs = hocsinhByMaHs;
    }
}
