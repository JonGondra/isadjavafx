package ehu.isad;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Txanpona {
    int trade_id;
    float price;
    float size;
    String time;
    float bid;
    float ask;
    float volume;

    @Override
    public String toString() {
        return "Txanpona{" +
                "trade_id=" + trade_id +
                ", price=" + price +
                ", size=" + size +
                ", time='" + time + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", volume=" + volume +
                '}';
    }

    public Txanpona URLReader(String mota) {
        String txanponM = " ";
        String line = " ";
        URL coinmarket;
        Txanpona txanpona = new Txanpona();

        switch (mota) {
            case "BTC":
                txanponM = "btc";
                break;

            case "ETH":
                txanponM = "eth";
                break;

            case "LTC":
                txanponM = "ltc";
                break;
        }

        try {
            coinmarket = new URL("https://api.gdax.com/products/" + txanponM + "-eur/ticker");
            URLConnection con = coinmarket.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            line = in.readLine();
            System.out.println(line);
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Txanpona txanpon = gson.fromJson(line, Txanpona.class);

        return txanpon;
    }
}
