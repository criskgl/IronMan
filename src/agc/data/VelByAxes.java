package agc.data;

import java.io.FileWriter;
import java.io.IOException;

public class VelByAxes {
	private VelDesvValues x_Axis;
	private VelDesvValues y_Axis;
	private VelDesvValues z_Axis;
	
	public VelDesvValues getX_Axis() {
		return x_Axis;
	}
	public VelDesvValues getY_Axis() {
		return y_Axis;
	}
	public VelDesvValues getZ_Axis() {
		return z_Axis;
	}


	// Effort spent: 4 minutes
	public VelByAxes ()
	{
		this.x_Axis = new VelDesvValues ();
		this.y_Axis = new VelDesvValues ();
		this.z_Axis = new VelDesvValues ();
	}

	// Effort spent: 10 minutes
	public VelByAxes (double xSpeedValue, double xDesvValue, double ySpeedValue, double yDesvValue, double zSpeedValue, double zDesvValue)
	{
		this.x_Axis = new VelDesvValues (xSpeedValue, xDesvValue);
		this.y_Axis = new VelDesvValues (ySpeedValue, yDesvValue);
		this.z_Axis = new VelDesvValues (zSpeedValue, zDesvValue);
	}
	
	@Override
	// Effort spent: 8 minutes
	public String toString() {
		return "{\n"
				+ "\t\"X_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"SPEED X\": "+ x_Axis.speedValue + ",\n"
				+ "\t\t\"VAR X\": "+ x_Axis.DesvValue + "\n"
				+ "\t},\n"
				+ "\t\"Y_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"SPEED Y\": "+ y_Axis.speedValue + ",\n"
				+ "\t\t\"VAR Y\": "+ y_Axis.DesvValue + "\n"
				+ "\t},\n"
				+ "\t\"Z_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"SPEED Z\": "+ z_Axis.speedValue + ",\n"
				+ "\t\t\"VAR Z\": "+ z_Axis.DesvValue + "\n"
				+ "\t}\n"
				+ "}";
	}
	// Effort spent: 1 minutes
	public void PrintToJsonFile(String result) throws IOException{
		
		try (FileWriter file = new FileWriter("SPEED.json")) {
			file.write(result.toString());
			System.out.println("Successfully Copied JSON Object to File...");
		}
		
	}
}
