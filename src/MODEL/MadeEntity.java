package MODEL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Made", schema = "dbo", catalog = "TTN")
public class MadeEntity {
    private Long id;
    private String maDe;
    private String tenMade;
    private String maCHde;
    private String maBode;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ma_De")
    public String getMaDe() {
        return maDe;
    }

    public void setMaDe(String maDe) {
        this.maDe = maDe;
    }

    @Basic
    @Column(name = "ten_Made")
    public String getTenMade() {
        return tenMade;
    }

    public void setTenMade(String tenMade) {
        this.tenMade = tenMade;
    }

    @Basic
    @Column(name = "ma_CHde")
    public String getMaCHde() {
        return maCHde;
    }

    public void setMaCHde(String maCHde) {
        this.maCHde = maCHde;
    }

    @Basic
    @Column(name = "ma_Bode")
    public String getMaBode() {
        return maBode;
    }

    public void setMaBode(String maBode) {
        this.maBode = maBode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MadeEntity that = (MadeEntity) o;
        return Objects.equals(maDe, that.maDe) && Objects.equals(tenMade, that.tenMade) && Objects.equals(maCHde, that.maCHde) && Objects.equals(maBode, that.maBode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDe, tenMade, maCHde, maBode);
    }
}
