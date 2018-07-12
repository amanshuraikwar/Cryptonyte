package io.github.amanshuraikwar.cryptonyte.util;

/**
 * Utility class for the app.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 07/03/18.
 */

public class Util {

    public static String getTag(Object object) {
        return object.getClass().getSimpleName();
    }
}
