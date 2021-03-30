package MODEL;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Taikhoan", schema = "dbo", catalog = "TTN")
public class TaikhoanEntity {
    private Long id;
    private String username;
    private String passwords;
    private Boolean trangthai;
    private int maQuyen;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Basic
    @Column(name = "ma_Quyen")
    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(int maQuyen) {
        this.maQuyen = maQuyen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaikhoanEntity that = (TaikhoanEntity) o;
        return maQuyen == that.maQuyen && Objects.equals(username, that.username) && Objects.equals(passwords, that.passwords) && Objects.equals(trangthai, that.trangthai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, passwords, trangthai, maQuyen);
    }
}
