package DataAcess;
import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.AppConfiguration;
import Framework.AppException;

public class CoordDAC extends SQLiteDataHelper {
    
    public CoordDAC(){
        super(AppConfiguration.getDBPathConnection());
    }
    /**
     * Metodo usado para obtener todas las coordenadas de la tabla
     * @return Retorna todos los datos que la tabla nos envia
     * @throws AppException
     */
    public ResultSet caGetAllCoords() throws AppException{
        try{
            String sql="SELECT *"
                        +"FROM CA_COORDS";
            return getResultSet(sql);
        }
        catch (SQLException e){
            throw new AppException(e, getClass(), "getAllCoords()");
        }
    }
}
