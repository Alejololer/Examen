package BusinessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAcess.CoordDAC;
import Framework.AppException;
import BusinessLogic.Entities.Coord;

public class CoordBL {
    /**
     * Este metodo nos permite enlistar todos las coordenadas de la tabla correspondiente al usuario.
     * @return Retorna la lista de los usuarios que hay en la abse de datos
     * @throws AppException
     */
    public List<Coord> caGetAllCoords(String caUser) throws AppException{
        try{
            CoordDAC caCoordDAC = new CoordDAC();
            List<Coord> caCoord = new ArrayList<Coord>();
            ResultSet rs = caCoordDAC.caGetAllCoords(caUser);
            if(caUser.equals("1751424324")){
                while(rs.next()){
                    Coord caP = new Coord(rs.getInt("CA_CAP"),rs.getString("CA_GEO"),rs.getString("CA_ARS"));
                    caCoord.add(caP);
                }
            }
            if(caUser.equals("1754944336")){
                while(rs.next()){
                    Coord caP = new Coord(rs.getInt("JA_CAP"),rs.getString("JA_GEO"),rs.getString("JA_ARS"));
                    caCoord.add(caP);
                }
            }
            if(caUser.equals("1234")){
                while(rs.next()){
                    Coord caP = new Coord(rs.getInt("PF_CAP"),rs.getString("PF_GEO"),rs.getString("PF_ARS"));
                    caCoord.add(caP);
                }
            }
            return caCoord;
        }
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    }
}
