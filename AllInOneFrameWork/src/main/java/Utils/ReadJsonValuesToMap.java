package Utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.jayway.jsonpath.JsonPath;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

public class ReadJsonValuesToMap {

	public static Map<String, Object> objectRepoToMap(String JsonFileName) {
		try {
			Path path = Paths.get(System.getProperty("user.dir") + "/src/main/resources/" + JsonFileName);

			// Reading the Json File
			String json = new String(Files.readAllBytes(path));

			// Need to have a map of the JSON Values
			ObjectMapper objectMapper = new ObjectMapper();

			// Final map with all Key value pair
			Map<String, Object> map = new HashMap<>();

			// Parser to parse the Json file
			JSONParser jsonParser = new JSONParser();

			Object object = jsonParser.parse(json);

			JsonObject jsonObject = (JsonObject) object;

			// Set to store all the page names from the OR JSON file
			Set<String> mySet = jsonObject.keySet();

			for (String key : mySet) {
				map.putAll(objectMapper.readValue(JsonPath.read(json, "$." + key).toString(),
						new TypeReference<Map<String, Object>>() {
						}));
			}

			Log.message("The Object Repositories are " + map);
			return map;

		} catch (Exception e) {
			Log.message("The error message is " + e.getMessage());
		}
		return null;
	}

	public static Map<String, Object> getDesiredCapabilities(String JsonFileName) {
		try {

			Path path = Paths.get(System.getProperty("user.dir") + "/src/main/resources/" + JsonFileName);

			String json = new String(Files.readAllBytes(path));

			ObjectMapper objectMapper = new ObjectMapper();

			Map<String, Object> map = new HashMap<>();

			JSONParser jsonParser = new JSONParser();

			Object object = jsonParser.parse(json);

			JsonObject jsonObject = (JsonObject) object;

			// Reading the Common
			String commonValues = jsonObject.get("").toString();

			map.putAll(objectMapper.readValue(JsonPath.read(json, "$." + commonValues).toString(),
					new TypeReference<Map<String, Object>>() {
					}));

			// Reading the Device Details
			String currentExecutionDevice = jsonObject.get("ExecutionDevice").toString();

			map.putAll(objectMapper.readValue(JsonPath.read(json, "$." + currentExecutionDevice).toString(),
					new TypeReference<Map<String, String>>() {
					}));

			Log.message("The Desired Capabilites are " + map);

			return map;

		} catch (Exception e) {
			Log.message("The error message is " + e.getMessage());
		}

		return null;
	}

	public static void isJsonValid(String json) {
		try {
			new JSONObject(json);
		} catch (Exception e) {
			Log.message("The error message is " + e.getMessage());
		}
	}

}
