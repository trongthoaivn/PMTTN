package MODEL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Bode", schema = "dbo", catalog = "TTN")
public class BodeEntity {
//    private Long id;
    private String maBode;
    private String tenBode;
    private CauhoiEntity cauhoiByMaCh;
    private MonhocEntity monhocByMaMh;
    private KythiEntity kythiByMaKt;
    private Collection<MadeEntity> madesByMaBode;

//    @Id
//    @GeneratedValue
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodeEntity that = (BodeEntity) o;
        return Objects.equals(maBode, that.maBode) && Objects.equals(tenBode, that.tenBode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBode, tenBode);
    }

    @ManyToOne
    @JoinColumn(name = "ma_CH", referencedColumnName = "ma_CH")
    public CauhoiEntity getCauhoiByMaCh() {
        return cauhoiByMaCh;
    }

    public void setCauhoiByMaCh(CauhoiEntity cauhoiByMaCh) {
        this.cauhoiByMaCh = cauhoiByMaCh;
    }

    @ManyToOne
    @JoinColumn(name = "ma_MH", referencedColumnName = "ma_MH")
    public MonhocEntity getMonhocByMaMh() {
        return monhocByMaMh;
    }

    public void setMonhocByMaMh(MonhocEntity monhocByMaMh) {
        this.monhocByMaMh = monhocByMaMh;
    }

    @ManyToOne
    @JoinColumn(name = "ma_KT", referencedColumnName = "ma_KT")
    public KythiEntity getKythiByMaKt() {
        return kythiByMaKt;
    }

    public void setKythiByMaKt(KythiEntity kythiByMaKt) {
        this.kythiByMaKt = kythiByMaKt;
    }

    @OneToMany(mappedBy = "bodeByMaBode")
    public Collection<MadeEntity> getMadesByMaBode() {
        return madesByMaBode;
    }

    public void setMadesByMaBode(Collection<MadeEntity> madesByMaBode) {
        this.madesByMaBode = madesByMaBode;
    }
}
