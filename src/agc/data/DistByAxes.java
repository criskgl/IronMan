package agc.data;

import java.io.FileWriter;
import java.io.IOException;

import agc.exceptions.AGCException;

public class DistByAxes {
	private double Dist_X;
	private double Dist_Y;
	private double Dist_Z;
	
	public double getDist_X() {
		return Dist_X;
	}

	public double getDist_Y() {
		return Dist_Y;
	}

	public double getDist_Z() {
		return Dist_Z;
	}
	
	// Effort spent: 4 minutes
	public DistByAxes ()
	{
		this.Dist_X = 0.0d;
		this.Dist_Y = 0.0d;
		this.Dist_Z = 0.0d;
	}
	
	// Effort spent: 5 minutes
	public DistByAxes (double xValue, double yValue, double zValue)
	{
		this.Dist_X = xValue;
		this.Dist_Y = yValue;
		this.Dist_Z = zValue;
	}
	
	@Override
	// Effort spent: 4 minutes
	public String toString() {
		return "{\n"
				+ "\t\"X_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Dist\": "+ Dist_X + "\n"
				+ "\t},\n"
				+ "\t\"Y_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Dist\": "+ Dist_Y + "\n"
				+ "\t},\n"
				+ "\t\"Z_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Dist\": "+ Dist_Z + "\n"
				+ "\t}\n"
				+ "}";
	}
	// Effort spent: 10 minutes
	public void PrintToJsonFile(String result) throws IOException{
		
		try (FileWriter file = new FileWriter("RESULT_DISTANCE.json")) {
			file.write(result.toString());
			System.out.println("Successfully Copied JSON Object to File...");
		}
		
	}
}
