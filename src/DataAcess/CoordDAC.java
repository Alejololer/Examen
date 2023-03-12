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
     * Metodo usado para obtener todas las coordenadas de las tablas dependiendo del usuario
     * @return Retorna todos los datos que la tabla nos envia
     * @throws AppException
     */
    public ResultSet caGetAllCoords(String caUser) throws AppException{
        String sql="";
        try{
            if(caUser.equals("1751424324")){
                sql="SELECT *"
                    +"FROM CA_COORDS";
            }
            if(caUser.equals("1754944336")){
                sql="SELECT *"
                        +"FROM JA_COORDS";
                }
            if(caUser.equals("1234")){
                sql="SELECT *"
                    +"FROM PF_COORDS";
            }
            return getResultSet(sql);
        }
        catch (SQLException e){
            throw new AppException(e, getClass(), "getAllCoords()");
        }
    }
}
