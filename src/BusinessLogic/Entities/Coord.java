package BusinessLogic.Entities;

public class Coord {
    Coord caCoordMen;
    Coord caCoordMay;
    int caCap;
    String caGeo;
    String caArs;
    
    /**
     * Constructor de la clase coord
     * @param caCap Capacidad belica
     * @param caGeo Gelocalizacion
     * @param caArs Tipo de arsenal
     */
    public Coord(int caCap, String caGeo, String caArs) {
        this.caCap = caCap;
        this.caGeo = caGeo;
        this.caArs = caArs;
    }

    public int caGetCaCap() {
        return caCap;
    }

    public void caSetCaCap(int caCap) {
        this.caCap = caCap;
    }

    public String caGetCaGeo() {
        return caGeo;
    }

    public void caSetCaGeo(String caGeo) {
        this.caGeo = caGeo;
    }

    public String caGetCaArs() {
        return caArs;
    }

    public void caSetCaArs(String caArs) {
        this.caArs = caArs;
    }
    
}
