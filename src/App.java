
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BusinessLogic.*;
import BusinessLogic.Entities.*;
import Framework.AppConfiguration;

public class App {

    static final String CANOMBRE_COMPLETO= "Carlos Alejandro Aleman Osorio";
    static final int CACEDULA_ALEMAN= 1751424324;
    static final String JANOMBRE_COMPLETO= "Joel Nicolas Altamirano Quel";
    static final int JACEDULA_ALTAMIRANO= 1754944336;

    /**
     * Procedimiento principal bajo el cual corre el programa
     * @param args
     */
    public static void main(String[] args) {
        AppConfiguration.load("src/config.properties"); 
        System.out.println(AppConfiguration.getDBName());
        System.out.println(AppConfiguration.getDBPathConnection());
        Scanner caScanner = new Scanner(System.in);
        boolean caLoggedIn = false;
        int attempts=0;
        String caEnteredUsername;
        String caEnteredPassword;
        try{
            UserBL caUser =  new UserBL();
            System.out.println("[Users]" );
            do{
            
                System.out.print("Ingrese usuario: ");
                caEnteredUsername = caScanner.nextLine();
                System.out.print("Ingrese clave: ");
                caEnteredPassword = caScanner.nextLine();
                for (User p : caUser.caGetAllUsers()) {
                    if(caEnteredUsername.equals(p.caGetID()) && caEnteredPassword.equals(p.caGetPSWRD())){
                        
                        System.out.println("Login correcto!");
                        caLoggedIn = true;
                    }
                }
                if(!caLoggedIn){
                    attempts++;
                    System.out.println("Clave o usuario incorrectos. Intentos restantes: " + (3 - attempts));
                }
            } while (!caLoggedIn && attempts < 3);
            if(attempts==3){
                System.out.println("Demasiados intentos incorrectos, cerrando el programa!");
                System.exit(0);
            }
            CoordBL caCoord = new CoordBL();
            System.out.println("[Coordenadas]");
            List<Coord> caCoords = caCoord.caGetAllCoords();
            List<Coord> caFixed = new ArrayList<Coord>();
            int caCont=1;
            int caCapBel=0;
            int caCoordTotal=0;
            for (Coord coord : caCoords) {
                boolean caFlag=true;
                if(caCont>0){
                    caFixed.add(coord);
                    caCont--;
                }
                for (Coord coord2 : caFixed) {
                    if(coord.caGetCaGeo().equals(coord2.caGetCaGeo()))
                        caFlag=false;
                }
                if(caFlag==true)
                    caFixed.add(coord);
            }
            System.out.println("        CAP     GEO     TIPO ARSENAL");
            for(Coord caP : caFixed){
                String[] caAnimationFrames = {"-", "\\", "|", "/"};
                int caFrameIndex = 0;

                for (int i = 0; i <= 100; i++) {
                    System.out.print("\r" + i + "%" + caAnimationFrames[caFrameIndex]);
                    caFrameIndex = (caFrameIndex + 1) % caAnimationFrames.length;
                    Thread.sleep(10);
                }
                System.out.println("    "+caP.caGetCaCap()+"       "+caP.caGetCaGeo()+"      "+caP.caGetCaArs());
                caCapBel=caP.caGetCaCap()+caCapBel;
                caCoordTotal++;
            }
            if(caEnteredPassword.equals(Integer.toString(CACEDULA_ALEMAN))){
                System.out.println("Developer-Nombre: "+CANOMBRE_COMPLETO);
                System.out.println("Developer-Cedula: "+CACEDULA_ALEMAN);
            }
            if(caEnteredPassword.equals(Integer.toString(JACEDULA_ALTAMIRANO))){
                System.out.println("Developer-Nombre: "+JANOMBRE_COMPLETO);
                System.out.println("Developer-Cedula: "+JACEDULA_ALTAMIRANO);
            }
            if(caEnteredPassword.equals("1234")){
                System.out.println("Developer-Nombre: Profe");
                System.out.println("Developer-Cedula: 1234");
            }
            System.out.println("Capacidad Belica: "+caCapBel);
            System.out.println("Coordenada-Total: "+caCoordTotal);
            System.out.print("Coordenada-SecCarga: ");
            for (Coord caP : caFixed) {
                System.out.print(caP.caGetCaCap()+" ");
            }

            
            
            

        } catch (Exception e) { }
        
        
    }
}
