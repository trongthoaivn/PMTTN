package MODEL;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GacthiEntityPK implements Serializable {
    private String maKt;
    private String maGv;

    @Column(name = "ma_KT")
    @Id
    public String getMaKt() {
        return maKt;
    }

    public void setMaKt(String maKt) {
        this.maKt = maKt;
    }

    @Column(name = "ma_GV")
    @Id
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
        GacthiEntityPK that = (GacthiEntityPK) o;
        return Objects.equals(maKt, that.maKt) && Objects.equals(maGv, that.maGv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKt, maGv);
    }
}
