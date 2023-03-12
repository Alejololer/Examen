
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BusinessLogic.*;
import BusinessLogic.Entities.*;
import Framework.AppConfiguration;

public class main {
    //Declaracion de variables globales y del patron de expresion regular correspondiente
    static final String CANOMBRE_COMPLETO= "Carlos Alejandro Aleman Osorio";
    static final int CACEDULA_ALEMAN= 1751424324;
    static final String JANOMBRE_COMPLETO= "Joel Nicolas Altamirano Quel";
    static final int JACEDULA_ALTAMIRANO= 1754944336;
    static final String CAREGEX= "ab*c+";

    /**
     * Procedimiento principal bajo el cual corre el programa
     * @param args
     */
    public static void main(String[] args) {
        //Empezamos comprobando la inicializacion de la base de datos
        AppConfiguration.load("src/config.properties"); 
        System.out.println(AppConfiguration.getDBName());
        System.out.println(AppConfiguration.getDBPathConnection());
        //Declaramos un escaner para el log in
        Scanner caScanner = new Scanner(System.in);
        //Booleano, strings y numero de intentos para el log in
        boolean caLoggedIn = false;
        int attempts=0;
        String caEnteredUsername;
        String caEnteredPassword;
        try{
            //Inicializamos los usuarios
            UserBL caUser =  new UserBL();
            System.out.println("[Usuarios]" );
            do{
                //Procedemos a pedir el input del usuario
                System.out.print("Ingrese usuario: ");
                caEnteredUsername = caScanner.nextLine();
                System.out.print("Ingrese clave: ");
                caEnteredPassword = caScanner.nextLine();
                //Comprobamos con la lista de usuarios lo ingresado
                for (User p : caUser.caGetAllUsers()) {
                    if(caEnteredUsername.equals(p.caGetID()) && caEnteredPassword.equals(p.caGetPSWRD())){
                        //Mostramos el login correcto
                        System.out.println("Login correcto!");
                        caLoggedIn = true;
                    }
                }
                //Mostramos el error en login
                if(!caLoggedIn){
                    attempts++;
                    System.out.println("Clave o usuario incorrectos. Intentos restantes: " + (3 - attempts));
                }
            } while (!caLoggedIn && attempts < 3);
            //Cerramos el programa tras los 3 intentos fallidos
            if(attempts==3){
                System.out.println("Demasiados intentos incorrectos, cerrando el programa!");
                System.exit(0);
            }
            //Inicializamos las coordenadas
            CoordBL caCoord = new CoordBL();
            System.out.println();
            System.out.println("[Coordenadas]");
            //Obtenemos la lista de coordenadas, dependiendo del usuario
            List<Coord> caCoords = caCoord.caGetAllCoords(caEnteredPassword);
            List<Coord> caFixed = new ArrayList<Coord>();
            int caCont=1;
            int caCapBel=0;
            int caCoordTotal=0;
            //Agregamos siempre la primer coordenada, luego chequeamos si la zona se repite y aumentamos si no
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
            //Tras la depuracion de zonas repetidas, podemos mostrar las zonas
            System.out.println("        CAP     GEO     TIPO ARSENAL");
            for(Coord caP : caFixed){
                //Animacion de 0 a 100 % con movimiento
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
            System.out.println();
            //Dependiendo del usuario que haya ingresado mostramos los datos
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
            //Mostramos las coordenadas cargadas en orden
            for (Coord caP : caFixed) {
                System.out.print(caP.caGetCaCap()+" ");
            }
            System.out.println();
            //Procedemos con la identificacion de sectores para aplicar la expresion regular que nos ha tocado
            System.out.println("[Bombas]");
            Pattern pattern = Pattern.compile(CAREGEX);
            //Comprobamos con cada zona si aplica o no, denotando con un mensaje si lo hacen.
            for (Coord caP : caFixed) {
                Matcher matcher = pattern.matcher(caP.caGetCaArs());
                if(matcher.find()){
                    caP.caSetCaArs(caP.caGetCaArs()+"dt");
                    System.out.println("La zona: "+caP.caGetCaGeo()+" sera bombeardada por el misil BOMB-IP, su arsenal es: "+caP.caGetCaArs());
                }
            }
            System.out.println();
            System.out.println("[+] Arbol binario de coordenadas y bomba");
            
            
            
            

        } catch (Exception e) { }
        
        
    }
}
