package BusinessLogic.Entities;

public class Coord {
    int caCap;
    String caGeo;
    String caArs;
    
    public Coord(int caCap, String caGeo, String caArs) {
        this.caCap = caCap;
        this.caGeo = caGeo;
        this.caArs = caArs;
    }

    public int getCaCap() {
        return caCap;
    }

    public void setCaCap(int caCap) {
        this.caCap = caCap;
    }

    public String getCaGeo() {
        return caGeo;
    }

    public void setCaGeo(String caGeo) {
        this.caGeo = caGeo;
    }

    public String getCaArs() {
        return caArs;
    }

    public void setCaArs(String caArs) {
        this.caArs = caArs;
    }
    
}
