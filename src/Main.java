import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;


public class Main {

	public static void main(String[] args) {
		try {
			URLConnection connection = new URL("https://randomapi.com/api/?key=0KSK-8MWB-ZRXM-4C20&id=27h7jyd&results=4").openConnection();
			
			InputStreamReader in = new InputStreamReader(connection.getInputStream());
			
			BufferedReader br = new BufferedReader(in);
			
			String odgovor = br.readLine();

			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("data/fajl.out")));

			JSONObject jsonObject = new JSONObject(odgovor);
			System.out.println(jsonObject.toString());
			JSONArray jsonArray = jsonObject.getJSONArray("data");

			if(jsonArray != null) {

				String[] imena = new String[jsonArray.length()];
				String[] prezimena = new String[jsonArray.length()];
				int[] godine = new int[jsonArray.length()];
				String[] polovi = new String[jsonArray.length()];

				for (int i = 0; i < jsonArray.length(); i++) {

					JSONObject json = jsonArray.getJSONObject(i);

					imena[i] = json.getString("ime");
					prezimena[i] = json.getString("prezime");
					godine[i] = json.getInt("godina");
					polovi[i] = json.getString("pol");

					Osoba osoba = new Osoba(imena[i], prezimena[i], godine[i], polovi[i]);

					out.println(osoba);
				}
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
