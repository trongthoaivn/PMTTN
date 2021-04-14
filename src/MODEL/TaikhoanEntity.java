package MODEL;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Taikhoan", schema = "dbo", catalog = "TTN")
public class TaikhoanEntity implements Serializable {
//    private Long id;
    private String username;
    private String passwords;
    private Boolean trangthai;
    private Collection<AdminEntity> adminsByUsername;
    private Collection<GiaovienEntity> giaoviensByUsername;
    private Collection<HocsinhEntity> hocsinhsByUsername;
    private QuyenEntity quyenByMaQuyen;

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
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "passwords")
    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    @Basic
    @Column(name = "trangthai")
    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaikhoanEntity that = (TaikhoanEntity) o;
        return Objects.equals(username, that.username) && Objects.equals(passwords, that.passwords) && Objects.equals(trangthai, that.trangthai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, passwords, trangthai);
    }

    @OneToMany(mappedBy = "taikhoanByUsername")
    public Collection<AdminEntity> getAdminsByUsername() {
        return adminsByUsername;
    }

    public void setAdminsByUsername(Collection<AdminEntity> adminsByUsername) {
        this.adminsByUsername = adminsByUsername;
    }

    @OneToMany(mappedBy = "taikhoanByUsername")
    public Collection<GiaovienEntity> getGiaoviensByUsername() {
        return giaoviensByUsername;
    }

    public void setGiaoviensByUsername(Collection<GiaovienEntity> giaoviensByUsername) {
        this.giaoviensByUsername = giaoviensByUsername;
    }

    @OneToMany(mappedBy = "taikhoanByUsername")
    public Collection<HocsinhEntity> getHocsinhsByUsername() {
        return hocsinhsByUsername;
    }

    public void setHocsinhsByUsername(Collection<HocsinhEntity> hocsinhsByUsername) {
        this.hocsinhsByUsername = hocsinhsByUsername;
    }

    @ManyToOne
    @JoinColumn(name = "ma_Quyen", referencedColumnName = "ma_Quyen", nullable = false)
    public QuyenEntity getQuyenByMaQuyen() {
        return quyenByMaQuyen;
    }

    public void setQuyenByMaQuyen(QuyenEntity quyenByMaQuyen) {
        this.quyenByMaQuyen = quyenByMaQuyen;
    }
}
