package agc.data;

public class FullTurnByAxes {
	private double fullTurn_X;
	private double fullTurn_Y;
	private double fullTurn_Z;
	
	public double getFullTurn_X() {
		return fullTurn_X;
	}

	public double getFullTurn_Y() {
		return fullTurn_Y;
	}

	public double getFullTurn_Z() {
		return fullTurn_Z;
	}
	
	// Effort spent: 3 minutes
	public FullTurnByAxes ()
	{
		this.fullTurn_X = 0.0d;
		this.fullTurn_Y = 0.0d;
		this.fullTurn_Z = 0.0d;
	}
	
	// Effort spent: 4 minutes
	public FullTurnByAxes (double xValue, double yValue, double zValue)
	{
		this.fullTurn_X = xValue;
		this.fullTurn_Y = yValue;
		this.fullTurn_Z = zValue;
	}
	
	@Override
	// Effort spent: 8 minutes
	public String toString() {
		return "{\n"
				+ "\t\"X_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Full Turn\": "+ fullTurn_X + "\n"
				+ "\t},\n"
				+ "\t\"Y_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Full Turn\": "+ fullTurn_Y + "\n"
				+ "\t},\n"
				+ "\t\"Z_Axis\":\n"
				+ "\t{\n"
				+ "\t\t\"Full Turn\": "+ fullTurn_Z + "\n"
				+ "\t}\n"
				+ "}";
	}
}
