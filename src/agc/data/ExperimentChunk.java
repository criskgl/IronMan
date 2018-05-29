package agc.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.JsonObject;

public class ExperimentChunk {

	private Date time;
	private double gyro_x;
	private double gyro_y;
	private double gyro_z;
	private double accel_x;
	private double accel_y;
	private double accel_z;
	private double latitude;
	private double longitude;
	

	// Effort spent: 3 minutos
	public ExperimentChunk(Date time, double gyro_x, double gyro_y, double gyro_z, double accel_x, double accel_y, double accel_z, double longitude, double latitude) {
		this.time = time;
		this.gyro_x = gyro_x;
		this.gyro_y = gyro_y;
		this.gyro_z = gyro_z;
		this.accel_x = accel_x;
		this.accel_y = accel_y;
		this.accel_z = accel_z;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Date getTime() {
		return time;
	}

	public double getGyro_x() {
		return gyro_x;
	}

	public double getGyro_y() {
		return gyro_y;
	}

	public double getGyro_z() {
		return gyro_z;
	}

	public double getAccel_x() {
		return accel_x;
	}

	public double getAccel_y() {
		return accel_y;
	}

	public double getAccel_z() {
		return accel_z;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	
	// Effort spent: 15 minutos
	@Override
	public String toString() {
		String result = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		result += "Time: " + formatter.format(time) + "\n";
		result += "GYRO_X: " + gyro_x + "\n";
		result += "GYRO_Y: " + gyro_y + "\n";
		result += "GYRO_Z: " + gyro_z + "\n";
		result += "ACCEL_X: " + accel_x + "\n";
		result += "ACCEL_Y: " + accel_y + "\n";
		result += "ACCEL_Z: " + accel_z +  "\n";
		result += "LATITUDE: " + latitude + "\n";
		result += "LONGITUDE: " + longitude;
		return result;
	}

}
