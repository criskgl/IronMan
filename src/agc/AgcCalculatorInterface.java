//hola jeje
package agc;
//Comment
import agc.exceptions.*;

import java.io.IOException;

import agc.data.*;

public interface AgcCalculatorInterface {

	AccelerationByAxes CalculateMinMaxAcceleration (String InputFile, int InitialInstant, int FinalInstant) throws AGCException;
	// AccelerationByAxes represents AGC -RF-01-S1
	// String InputFile represents AGC-RF-01-E1
	// InitialInstant represents AGC-RF-01-E2
	// FinalInstant represents AGC-RF-01-E3
	// AGCException represents AGC -RF-01-S2

	FullTurnByAxes CalculateFullTurn (String InputFile, int InitialInstant, int FinalInstant) throws AGCException;
	// AccelerationByAxes represents AGC -RF-02-S1
	// String InputFile represents AGC -RF-02-E1
	// InitialInstant represents AGC -RF-02-E2
	// FinalInstant represents AGC -RF-02-E3
	// AGCException represents AGC -RF-02-S2

	DistByAxes CalculateDist(String InputFile, int FinalInstant) throws AGCException, IOException;
	// Generated json file represents AGC -RF-03-S1
	// String InputFile represents AGC -RF-03-E1
	// FinalInstant represents AGC -RF-03-E2
	// AGCException represents AGC -RF-03-S2

	VelByAxes CalculateVel(String InputFile, int FinalInstant) throws AGCException, IOException;
	// Generated json file represents AGC -RF-04-S1
	// String InputFile represents AGC -RF-04-E1
	// FinalInstant represents AGC -RF-04-E2
	// AGCException represents AGC -RF-04-S2
}
