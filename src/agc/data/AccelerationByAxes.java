package agc.data;

public class AccelerationByAxes {
	private MinMaxAcceleration x_Axis;
	private MinMaxAcceleration y_Axis;
	private MinMaxAcceleration z_Axis;
	
	public MinMaxAcceleration getX_Axis() {
		return x_Axis;
	}
	public MinMaxAcceleration getY_Axis() {
		return y_Axis;
	}
	public MinMaxAcceleration getZ_Axis() {
		return z_Axis;
	}


	// Effort spent: 5 minutes
	public AccelerationByAxes ()
	{
		this.x_Axis = new MinMaxAcceleration ();
		this.y_Axis = new MinMaxAcceleration ();
		this.z_Axis = new MinMaxAcceleration ();
	}

	// Effort spent: 5 minutes
	public AccelerationByAxes (double xMinValue, double xMaxValue, double yMinValue, double yMaxValue, double zMinValue, double zMaxValue)
	{
		this.x_Axis = new MinMaxAcceleration (xMinValue, xMaxValue);
		this.y_Axis = new MinMaxAcceleration (yMinValue, yMaxValue);
		this.z_Axis = new MinMaxAcceleration (zMinValue, zMaxValue);
	}
	
	@Override
	// Effort spent: 9 minutes
	public String toString() {
		return "{\n"
				+ "\t\"X_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Minimum Acceleration\": "+ x_Axis.getMinAcceleration() + ",\n"
				+ "\t\t\"Maximum Acceleration\": "+ x_Axis.getMaxAcceleration() + "\n"
				+ "\t},\n"
				+ "\t\"Y_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Minimum Acceleration\": "+ y_Axis.getMinAcceleration() + ",\n"
				+ "\t\t\"Maximum Acceleration\": "+ y_Axis.getMaxAcceleration() + "\n"
				+ "\t},\n"
				+ "\t\"Z_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Minimum Acceleration\": "+ z_Axis.getMinAcceleration() + ",\n"
				+ "\t\t\"Maximum Acceleration\": "+ z_Axis.getMaxAcceleration() + "\n"
				+ "\t}\n"
				+ "}";
	}
}
