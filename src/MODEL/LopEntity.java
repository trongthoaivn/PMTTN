package MODEL;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Lop", schema = "dbo", catalog = "TTN")
public class LopEntity {
    private Long id;
    private String maLop;
    private String tenLop;
    private Collection<HocsinhEntity> hocsinhsByMaLop;
    private KhoiEntity khoiByMaKhoi;

//    @Id
//    @GeneratedValue
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }


    public LopEntity(String maLop, String tenLop, Collection<HocsinhEntity> hocsinhsByMaLop, KhoiEntity khoiByMaKhoi) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.hocsinhsByMaLop = hocsinhsByMaLop;
        this.khoiByMaKhoi = khoiByMaKhoi;
    }

    public LopEntity() {
    }

    public LopEntity(String maLop) {
        this.maLop = maLop;
    }

    @Id
    @Column(name = "ma_Lop")
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    @Basic
    @Column(name = "ten_Lop")
    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LopEntity lopEntity = (LopEntity) o;
        return Objects.equals(maLop, lopEntity.maLop) && Objects.equals(tenLop, lopEntity.tenLop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLop, tenLop);
    }

    @OneToMany(mappedBy = "lopByMaLop")
    public Collection<HocsinhEntity> getHocsinhsByMaLop() {
        return hocsinhsByMaLop;
    }

    public void setHocsinhsByMaLop(Collection<HocsinhEntity> hocsinhsByMaLop) {
        this.hocsinhsByMaLop = hocsinhsByMaLop;
    }

    @ManyToOne
    @JoinColumn(name = "ma_Khoi", referencedColumnName = "ma_Khoi")
    public KhoiEntity getKhoiByMaKhoi() {
        return khoiByMaKhoi;
    }

    public void setKhoiByMaKhoi(KhoiEntity khoiByMaKhoi) {
        this.khoiByMaKhoi = khoiByMaKhoi;
    }
}
