package REF;

public class Matrix {
    private int hieu;
    private int biet;
    private int vdthap;
    private int vdcao;
    private int socau;

    public Matrix() {
    }

    public Matrix(int hieu, int biet, int vdthap, int vdcao, int socau) {
        this.hieu = hieu;
        this.biet = biet;
        this.vdthap = vdthap;
        this.vdcao = vdcao;
        this.socau =socau;
    }

    public int getHieu() {
        return hieu;
    }

    public void setHieu(int hieu) {
        this.hieu = hieu;
    }

    public int getBiet() {
        return biet;
    }

    public void setBiet(int biet) {
        this.biet = biet;
    }

    public int getVdthap() {
        return vdthap;
    }

    public void setVdthap(int vdthap) {
        this.vdthap = vdthap;
    }

    public int getVdcao() {
        return vdcao;
    }

    public void setVdcao(int vdcao) {
        this.vdcao = vdcao;
    }

    public int getSocau() {
        return socau;
    }

    public void setSocau(int socau) {
        this.socau = socau;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "hieu=" + hieu +
                ", biet=" + biet +
                ", vdthap=" + vdthap +
                ", vdcao=" + vdcao +
                ", socau=" + socau +
                '}';
    }
}
