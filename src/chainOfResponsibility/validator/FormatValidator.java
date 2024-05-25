package chainOfResponsibility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatValidator extends Validator {

    public boolean check(String data) {

        boolean isValid = true;

        String characters = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?!.*\\s).{8,20}$";
        Pattern pattern = Pattern.compile(characters);
        Matcher matcher = pattern.matcher(data);

        if (!matcher.matches()) {

            System.out.println("\u2716 La donnée doit comporter au moins (un chiffre, une minuscule, une majuscule et un caractère spécial).");
            isValid = false;
        } else {

            System.out.println("\u2714 Le format de la donnée est valide.");
        }

        if (nextValidator != null) {
            return nextValidator.check(data) && isValid;
        }
        return isValid;
    }

}
