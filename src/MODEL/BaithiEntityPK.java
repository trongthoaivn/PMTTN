package MODEL;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BaithiEntityPK implements Serializable {
    private String maBaithi;
    private String maKq;

    @Column(name = "ma_Baithi")
    @Id
    public String getMaBaithi() {
        return maBaithi;
    }

    public void setMaBaithi(String maBaithi) {
        this.maBaithi = maBaithi;
    }

    @Column(name = "ma_KQ")
    @Id
    public String getMaKq() {
        return maKq;
    }

    public void setMaKq(String maKq) {
        this.maKq = maKq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaithiEntityPK that = (BaithiEntityPK) o;
        return Objects.equals(maBaithi, that.maBaithi) && Objects.equals(maKq, that.maKq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBaithi, maKq);
    }
}
