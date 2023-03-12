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
     * Este metodo nos permite enlistar todos las coordenadas de la base de datos
     * @return Retorna la lista de los usuarios que hay en la abse de datos
     * @throws AppException
     */
    public List<Coord> caGetAllCoords() throws AppException{
        try{
            CoordDAC caCoordDAC = new CoordDAC();
            List<Coord> caCoord = new ArrayList<Coord>();
            ResultSet rs = caCoordDAC.caGetAllCoords();
            while(rs.next()){
                Coord caP = new Coord(rs.getInt("CA_CAP"),rs.getString("CA_GEO"),rs.getString("CA_ARS"));
                caCoord.add(caP);
            }
            return caCoord;
        }
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    }
}
