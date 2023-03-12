package BusinessLogic.Entities;
/**
 * Clase para representar a los usuarios de la tabla en el programa
 */
public class User {
    String caID;
    String caPSWRD;
    
    /**
     * Constructor de la clase user
     * @param ID Nombre de usuario
     * @param PSWRD Clave del usuario
     */
    public User(String ID, String PSWRD){
        this.caID=ID;
        this.caPSWRD=PSWRD;
    }

    public String caGetID() {
        return caID;
    }

    public void caSetID(String iD) {
        caID = iD;
    }

    public String caGetPSWRD() {
        return caPSWRD;
    }

    public void caSetPSWRD(String pSWRD) {
        caPSWRD = pSWRD;
    }
    
}
