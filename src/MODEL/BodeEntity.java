package MODEL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Bode", schema = "dbo", catalog = "TTN")
public class BodeEntity {
    private Long id;
    private String maBode;
    private String tenBode;
    private MonhocEntity monhocByMaMh;
    private KythiEntity kythiByMaKt;
    private Collection<CauhoiEntity> cauhoisByMaBode;
    private Collection<MadeEntity> madesByMaBode;

    public BodeEntity(String maBode, String tenBode, MonhocEntity monhocByMaMh) {
        this.maBode = maBode;
        this.tenBode = tenBode;
        this.monhocByMaMh = monhocByMaMh;
    }

    public BodeEntity(String maBode) {
        this.maBode = maBode;
    }

    public BodeEntity() {
    }

    //    @Id
//    @GeneratedValue
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }


    @Override
    public String toString() {
        return "BodeEntity{" +
                ", maBode='" + maBode + '\'' +
                ", tenBode='" + tenBode + '\'' +
                '}';
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
    public Collection<CauhoiEntity> getCauhoisByMaBode() {
        return cauhoisByMaBode;
    }

    public void setCauhoisByMaBode(Collection<CauhoiEntity> cauhoisByMaBode) {
        this.cauhoisByMaBode = cauhoisByMaBode;
    }

    @OneToMany(mappedBy = "bodeByMaBode")
    public Collection<MadeEntity> getMadesByMaBode() {
        return madesByMaBode;
    }

    public void setMadesByMaBode(Collection<MadeEntity> madesByMaBode) {
        this.madesByMaBode = madesByMaBode;
    }
}
