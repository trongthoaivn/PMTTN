package MODEL;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LogEntityPK implements Serializable {
    private String maKt;
    private String maHs;

    @Column(name = "ma_KT")
    @Id
    public String getMaKt() {
        return maKt;
    }

    public void setMaKt(String maKt) {
        this.maKt = maKt;
    }

    @Column(name = "ma_HS")
    @Id
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
        LogEntityPK that = (LogEntityPK) o;
        return Objects.equals(maKt, that.maKt) && Objects.equals(maHs, that.maHs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKt, maHs);
    }
}
