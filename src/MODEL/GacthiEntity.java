package MODEL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Gacthi", schema = "dbo", catalog = "TTN")
@IdClass(GacthiEntityPK.class)
public class GacthiEntity {
    private Long id;
    private String maKt;
    private String maGv;
    private KythiEntity kythiByMaKt;
    private GiaovienEntity giaovienByMaGv;

    public GacthiEntity() {
    }

    public GacthiEntity(String maKt, String maGv) {
        this.maKt = maKt;
        this.maGv = maGv;
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
    @Column(name = "ma_GV")
    public String getMaGv() {
        return maGv;
    }

    public void setMaGv(String maGv) {
        this.maGv = maGv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GacthiEntity that = (GacthiEntity) o;
        return Objects.equals(maKt, that.maKt) && Objects.equals(maGv, that.maGv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKt, maGv);
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
    @JoinColumn(name = "ma_GV", referencedColumnName = "ma_GV", nullable = false, insertable = false, updatable = false)
    public GiaovienEntity getGiaovienByMaGv() {
        return giaovienByMaGv;
    }

    public void setGiaovienByMaGv(GiaovienEntity giaovienByMaGv) {
        this.giaovienByMaGv = giaovienByMaGv;
    }
}
