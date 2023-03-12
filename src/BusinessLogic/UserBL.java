package BusinessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAcess.UserDAC;
import Framework.AppException;
import BusinessLogic.Entities.User;

public class UserBL {
    /**
     * Este metodo nos permite enlistar todos los usuarios de la base de datos
     * @return Retorna la lista de los usuarios que hay en la abse de datos
     * @throws AppException
     */
    public List<User> caGetAllUsers()  throws AppException{
        try{
            UserDAC caUserDAC = new UserDAC();
            List<User> caUser = new ArrayList<User>();
            ResultSet rs = caUserDAC.caGetAllUsers();
            while(rs.next()){
                User caP = new User(rs.getString("CA_ID"),rs.getString("CA_PSWRD"));
                caUser.add(caP);
            }
            return caUser;
        }
        catch (SQLException e) {
            throw new AppException(e, getClass());
        }
    }
    
}
