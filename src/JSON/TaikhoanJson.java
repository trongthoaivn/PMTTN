package JSON;


import java.io.Serializable;

public class TaikhoanJson implements Serializable {
    private String username;
    private String passwords;
    private int MaQuyen;

    public TaikhoanJson(String username, String passwords, int maQuyen) {
        this.username = username;
        this.passwords = passwords;
        MaQuyen = maQuyen;
    }

    public TaikhoanJson() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public int getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(int maQuyen) {
        MaQuyen = maQuyen;
    }
}
