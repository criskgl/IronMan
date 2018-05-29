package agc.data;

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


	// Effort spent: 5 minutes
	public VelByAxes ()
	{
		this.x_Axis = new VelDesvValues ();
		this.y_Axis = new VelDesvValues ();
		this.z_Axis = new VelDesvValues ();
	}

	// Effort spent: 5 minutes
	public VelByAxes (double xSpeedValue, double xDesvValue, double ySpeedValue, double yDesvValue, double zSpeedValue, double zDesvValue)
	{
		this.x_Axis = new VelDesvValues (xSpeedValue, xDesvValue);
		this.y_Axis = new VelDesvValues (ySpeedValue, yDesvValue);
		this.z_Axis = new VelDesvValues (zSpeedValue, zDesvValue);
	}
	
	@Override
	// Effort spent: 9 minutes
	public String toString() {
		return "{\n"
				+ "\t\"X_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Minimum Acceleration\": "+ x_Axis.speedValue + ",\n"
				+ "\t\t\"Maximum Acceleration\": "+ x_Axis.DesvValue + "\n"
				+ "\t},\n"
				+ "\t\"Y_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Minimum Acceleration\": "+ y_Axis.speedValue + ",\n"
				+ "\t\t\"Maximum Acceleration\": "+ y_Axis.DesvValue + "\n"
				+ "\t},\n"
				+ "\t\"Z_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Minimum Acceleration\": "+ z_Axis.speedValue + ",\n"
				+ "\t\t\"Maximum Acceleration\": "+ z_Axis.DesvValue + "\n"
				+ "\t}\n"
				+ "}";
	}
}
