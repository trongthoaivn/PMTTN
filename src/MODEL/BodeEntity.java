package MODEL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Bode", schema = "dbo", catalog = "TTN")
public class BodeEntity  implements Serializable {
    private Long id;
    private String maBode;
    private String tenBode;
    private Integer maCh;
    private String maMh;
    private String maKt;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ma_Bode")
    public String getMaBode() {
        return maBode;
    }

    public void setMaBode(String maBode) {
        this.maBode = maBode;
    }

    @Basic
    @Column(name = "ten_Bode")
    public String getTenBode() {
        return tenBode;
    }

    public void setTenBode(String tenBode) {
        this.tenBode = tenBode;
    }

    @Basic
    @Column(name = "ma_CH")
    public Integer getMaCh() {
        return maCh;
    }

    public void setMaCh(Integer maCh) {
        this.maCh = maCh;
    }

    @Basic
    @Column(name = "ma_MH")
    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    @Basic
    @Column(name = "ma_KT")
    public String getMaKt() {
        return maKt;
    }

    public void setMaKt(String maKt) {
        this.maKt = maKt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodeEntity that = (BodeEntity) o;
        return Objects.equals(maBode, that.maBode) && Objects.equals(tenBode, that.tenBode) && Objects.equals(maCh, that.maCh) && Objects.equals(maMh, that.maMh) && Objects.equals(maKt, that.maKt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBode, tenBode, maCh, maMh, maKt);
    }
}
