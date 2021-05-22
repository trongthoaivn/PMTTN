package MODEL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Monhoc", schema = "dbo", catalog = "TTN")
public class MonhocEntity {
    private Long id;
    private String maMh;
    private String tenMh;
    private Collection<BodeEntity> bodesByMaMh;
    private Collection<KythiEntity> kythisByMaMh;

    public MonhocEntity() {
    }


    public MonhocEntity(String maMh, String tenMh) {
        this.maMh = maMh;
        this.tenMh = tenMh;
    }

    @Id
    @Column(name = "ma_MH")
    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    @Basic
    @Column(name = "ten_MH")
    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonhocEntity that = (MonhocEntity) o;
        return Objects.equals(maMh, that.maMh) && Objects.equals(tenMh, that.tenMh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maMh, tenMh);
    }

    @OneToMany(mappedBy = "monhocByMaMh")
    public Collection<BodeEntity> getBodesByMaMh() {
        return bodesByMaMh;
    }

    public void setBodesByMaMh(Collection<BodeEntity> bodesByMaMh) {
        this.bodesByMaMh = bodesByMaMh;
    }

    @OneToMany(mappedBy = "monhocByMaMh")
    public Collection<KythiEntity> getKythisByMaMh() {
        return kythisByMaMh;
    }

    public void setKythisByMaMh(Collection<KythiEntity> kythisByMaMh) {
        this.kythisByMaMh = kythisByMaMh;
    }
}
