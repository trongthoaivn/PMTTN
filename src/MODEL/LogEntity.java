package MODEL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Log", schema = "dbo", catalog = "TTN")
@IdClass(LogEntityPK.class)
public class LogEntity {
    private String maKt;
    private String maHs;
    private String maDe;


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

    @Basic
    @Column(name = "ma_De")
    public String getMaDe() {
        return maDe;
    }

    public void setMaDe(String maDe) {
        this.maDe = maDe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntity logEntity = (LogEntity) o;
        return Objects.equals(maKt, logEntity.maKt) && Objects.equals(maHs, logEntity.maHs) && Objects.equals(maDe, logEntity.maDe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKt, maHs, maDe);
    }
}
