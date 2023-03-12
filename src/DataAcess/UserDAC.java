package DataAcess;
import java.sql.ResultSet;
import java.sql.SQLException;

import Framework.AppConfiguration;
import Framework.AppException;

public class UserDAC extends SQLiteDataHelper {

    public UserDAC() {
        super(AppConfiguration.getDBPathConnection());
    }
    /**
     * Metodo usado para obtener todos los usuarios de la tabla
     * @return Retorna todos los datos que la tabla nos envia
     * @throws AppException
     */
    public ResultSet caGetAllUsers() throws AppException{
        try{
            String sql="SELECT *"
                        +"FROM CA_USERS";
            return getResultSet(sql);
        }
        catch (SQLException e){
            throw new AppException(e, getClass(), "getAllUsers()");
        }
    }

}
