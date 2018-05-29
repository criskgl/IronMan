package agc.io;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.JsonObject;

import agc.data.ExperimentChunk;
import agc.exceptions.AGCException;

public class ExperimentChunkValidator {
	public ExperimentChunk Validate (JsonObject element) throws AGCException {

		double gyrox, gyroy, gyroz, accelx, accely, accelz;
		Date parsedDate;
		// Check if keys for the given chunk are valid
		if (hasValidKeys(element)) {
			parsedDate = validateTime(element);
			gyrox = validateGyroValue(element, "GYRO_X");
			gyroy = validateGyroValue(element, "GYRO_Y");
			gyroz = validateGyroValue(element, "GYRO_Z");
			accelx = validateAccelValue(element, "ACCEL_X");
			accely = validateAccelValue(element, "ACCEL_Y");
			accelz = validateAccelValue(element, "ACCEL_Z");
		} else {
			throw new AGCException("Error: Invalid key value in input JSON.");
		}
		ExperimentChunk experimentChunk = new ExperimentChunk(parsedDate, gyrox, gyroy, gyroz, accelx, accely,
				accelz);
		return experimentChunk;
	}

	// Effort spent: 37 minutos
	// This method checks a JSON Object checking if all the keys that contains are valid
	private static boolean hasValidKeys(JsonObject element) {
		boolean result = true;
		for (String key : element.keySet()) {
			if (key.equals("Time") || key.equals("GYRO_X") || key.equals("GYRO_Y") || key.equals("GYRO_Z")
					|| key.equals("ACCEL_X") || key.equals("ACCEL_Y") || key.equals("ACCEL_Z")) {
				// result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
	
	// Effort spent: 31 minutos
	private Date validateTime(JsonObject element) throws AGCException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		Date parsedDate;
		try {
			if (element.getString("Time").length() > 23) {
				throw new AGCException("Error: invalid input for Time in JSON.");	
			}
			parsedDate = formatter.parse(element.getString("Time"));
		} catch (Exception e) {
			throw new AGCException("Error: invalid input for Time in JSON.");
		}
		return parsedDate;
	}

	// Effort spent: 14 minutos
	private double validateGyroValue(JsonObject element, String label) throws AGCException {
		double gyrox = 0.0d;
		try {
			gyrox = processNumberForLabel(label, element);
			if ((gyrox < 0) || (gyrox > 359.999d)) {
				throw new AGCException("Error: gyroscope value for" + label + " cannot be less than zero or greater than 359.999.");
			}
		} catch (AGCException e) {
			throw e;
		}
		return gyrox;
	}
	
	// Effort spent: 21 minutos
	private double validateAccelValue(JsonObject element, String label) throws AGCException {
		double accelx = 0.0d;
		try {
			accelx = processNumberForLabel(label, element);
		} catch (AGCException e) {
			throw e;
		}
		return accelx;
	}
	
	// This method does all the error processing for a number based on the corresponding label
	// Effort spent: 26 minutos
	private  double processNumberForLabel(String label, JsonObject element) throws AGCException {
		double value;
		try {
			if (hasAtLeastThreeDecimals(element.getJsonNumber(label).toString())) {
				value = element.getJsonNumber(label).doubleValue();
			} else {
				throw new AGCException("Error: less than 3 decimals for " + label + " in JSON input data.");
			}
		} catch (Exception e) {
			if (e.getClass() == AGCException.class) {
				throw e;
			} else {
				throw new AGCException("Error: " + label + " in JSON input data is not a number.");	
			}
		}
		return value;
	}
	
	// Effort spent: 17 minutos
	// This method checks if a number has at least 3 decimals
	private boolean hasAtLeastThreeDecimals(String input) throws AGCException {
		int pos = input.lastIndexOf('.');

		// If not dots found, error, no separator
		if (pos < 0) {
			throw new AGCException("Error: Invalid separator for decimal number.");
		}
		
		// pos = Three decimals plus plus one for total length (index) -> less than four instead of less than three
		if ((input.length() - pos) < 4) {
			return false;
		}
		return true;
	}
}
