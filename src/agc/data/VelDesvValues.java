package agc.data;

 public class VelDesvValues {
	double speedValue;
	double DesvValue;
	// Effort spent: 1 minutes
	public double getspeedValue() {
		return speedValue;
	}
	// Effort spent: 1 minutes
	public double getDesvValue() {
		return DesvValue;
	}

	// Effort spent: 2 minutes
	public VelDesvValues ()
	{
		this.speedValue = 0.0d;
		this.DesvValue = 0.0d;
	}
	
	// Effort spent: 2 minutes
	public VelDesvValues (double speedVal, double desvVal)
	{
		this.speedValue = speedVal;
		this.DesvValue = desvVal;
	}
	
}
