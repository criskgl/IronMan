package agc.data;

 public class MinMaxAcceleration {
	double minAcceleration;
	double maxAcceleration;
		
	public double getMinAcceleration() {
		return minAcceleration;
	}
	
	public double getMaxAcceleration() {
		return maxAcceleration;
	}

	// Effort spent: 2 minutes
	public MinMaxAcceleration ()
	{
		this.minAcceleration = 0.0d;
		this.maxAcceleration = 0.0d;
	}
	
	// Effort spent: 2 minutes
	public MinMaxAcceleration (double minValue, double maxValue)
	{
		this.minAcceleration = minValue;
		this.maxAcceleration = maxValue;
	}
	
}
