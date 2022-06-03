package pl.coderslab.charity.util;

public class MessageTextUtil {

    public static String passRecoveryMessage(String url, String tokenString){
        return "Link do resetowania Hasła \n "
                + "Aby zresetować hasło kliknij w link: \n "
                + url + "/" + tokenString;
    }
}
