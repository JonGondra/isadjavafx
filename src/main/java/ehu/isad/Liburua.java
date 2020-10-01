package ehu.isad;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Liburua {
    private String ISBN;
    private int number_of_pages;
    private String[] publishers;
    private String title;
    private String subtitle = "";

    public Liburua() { }

    public String getISBN() {
        return ISBN;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public String[] getPublishers() {
        return publishers;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Liburua URLReader(String lib) {
        String isbn = " ";
        String line = " ";
        URL openLibrary;
        Liburua liburua = new Liburua();

        switch (lib) {
            case "Blockchain: Blueprint for a New Economy":
                isbn = "9781491920497";
                break;
            case "R for Data Science":
                isbn = "1491910399";
                break;
            case "Fluent Python":
                isbn = "1491946008";
                break;
            case "Natural Language Processing with PyTorch":
                isbn = "1491978236";
                break;
            case "Data Algorithms":
                isbn = "9781491906187";
                break;
        }

        try {
            openLibrary = new URL("https://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&jscmd=details&format=json");
            URLConnection con = openLibrary.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            line = in.readLine();
            in.close();
        } catch (MalformedURLException MalformedURLException) {
            MalformedURLException.printStackTrace();
        } catch (IOException IOException) {
            IOException.printStackTrace();
        }

        String[] zatiak = line.split("details\":");
        System.out.println(line);
        line = zatiak[1].substring(0, zatiak[1].length()-1);
        zatiak = line.split(", \"preview\":");
        line = zatiak[0];
        System.out.println(line);

        Gson gson = new Gson();
        liburua = gson.fromJson(line, Liburua.class);
        liburua.ISBN = isbn;

        return liburua;
    }
}
