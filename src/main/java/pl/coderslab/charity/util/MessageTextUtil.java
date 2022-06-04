package pl.coderslab.charity.util;

public class MessageTextUtil {

    public static final String URL = "http://localhost:8080/";

    public static String passRecoveryMessage(String tokenString){
        return "Link do resetowania Hasła \n "
                + "Aby zresetować hasło kliknij w link: \n "
                + URL + "password-recovery/uuid/" + tokenString;
    }
}
