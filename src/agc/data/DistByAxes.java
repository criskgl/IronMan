package agc.data;

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
	
	// Effort spent: 3 minutes
	public DistByAxes ()
	{
		this.Dist_X = 0.0d;
		this.Dist_Y = 0.0d;
		this.Dist_Z = 0.0d;
	}
	
	// Effort spent: 4 minutes
	public DistByAxes (double xValue, double yValue, double zValue)
	{
		this.Dist_X = xValue;
		this.Dist_Y = yValue;
		this.Dist_Z = zValue;
	}
	
	@Override
	// Effort spent: 8 minutes
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
}
