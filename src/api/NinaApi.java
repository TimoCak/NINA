package api;

import org.json.*;

import api.ars.GetArs;

public class NinaApi {

	private final String serverUrl = "https://warnung.bund.de/api31";

	public String getServerUrl() {
		return this.serverUrl;
	}

	public void requestDashboard(String ars) {

		JSONArray jo = new JSONArray(Http.get(this.serverUrl + "/dashboard/" + ars + ".json").body());

		System.out.println(jo);
	}

	public static void main(String[] args) {

		NinaApi nina = new NinaApi();
		nina.requestDashboard("010010000000");

	}
}
