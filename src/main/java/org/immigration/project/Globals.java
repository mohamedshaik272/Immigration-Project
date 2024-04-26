package org.immigration.project;

import java.util.ArrayList;
import java.util.ListIterator ;

public class Globals {

    public static ArrayList<Immigrant> immigrantArrayList = new ArrayList<>();
    public static ListIterator<Immigrant> iterator = immigrantArrayList.listIterator();
    public static ArrayList<Immigrant> approverArrayList = new ArrayList<>();
    enum UserType {
        DATAENTRY("dataentry", "dataentry", "data_entry", "data_entry.fxml"),
        REVIEWER("reviewer", "reviewer", "reviewer", "review.fxml"),
        APPROVAL("approval", "approval", "approval", "second.fxml"),
        INVALID("", "", "", "");

        final String username, password, fx_name, fx_file;

        UserType(String username, String password, String fx_name, String fx_file) {
            this.username = username;
            this.password = password;
            this.fx_name = fx_name;
            this.fx_file = fx_file;
        }
    }
    static UserType user = UserType.INVALID;

    public static String getUser() {
        return user.username;
    }

    public static String getPass() {
        return user.password;
    }
}
