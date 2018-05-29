package agc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import agc.data.Experiment;
import agc.data.ExperimentChunk;
import agc.exceptions.AGCException;

public class AGCJsonHandler {

	// Effort spent: 33 minutos
	public JsonArray readJson(String input) throws AGCException {
		ArrayList<ExperimentChunk> jsonContent = new ArrayList<ExperimentChunk>();

		JsonArray jsonArray;

		try {
			if ((input == null) || input.isEmpty()) {
				throw new AGCException("Error: invalid input file.");
			}
			
			File file = new File(input);
			
			try {
				InputStream fileInputStream = new FileInputStream(file);
				JsonReader jsonReader = Json.createReader(fileInputStream);
				jsonArray = jsonReader.readArray();
				fileInputStream.close();
			} catch (Exception e) {
				throw new AGCException("Error: invalid input data in input file.");
			}
		} catch (Exception e) {
			throw new AGCException("Error: could not read data from input file.");
		}
		
		return jsonArray;
	}	
}
