package api.ars;

import java.net.http.HttpResponse;

import org.json.*;
import api.Http;
import api.FileHandle;

public class GetArs {
	private final String url = "https://www.xrepository.de/api/xrepository/urn:de:bund:destatis:bevoelkerungsstatistik:schluessel:rs_2021-07-31/download/Regionalschl_ssel_2021-07-31.json";

	public void getArs() {

		HttpResponse<String> response = Http.get(this.url);
		String body = response.body();
		
		FileHandle fh = new FileHandle("data/ars.json", body);

		JSONObject repo = new JSONObject(body);
		JSONArray data = new JSONArray(repo.getJSONArray("daten"));

		for (int i = 0; i < data.length(); i++) {
			System.out.println(data.get(i));
		}
	}

}
