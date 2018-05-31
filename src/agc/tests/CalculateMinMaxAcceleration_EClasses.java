package agc.tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import agc.AGCCalculator;
import agc.data.AccelerationByAxes;
import agc.exceptions.AGCException;

public class CalculateMinMaxAcceleration_EClasses {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(3, 3);
	}
	
	@Test
	/* Caso de Prueba: CP-RF1-01
	* Clase de Equivalencia o Valor Límite Asociado: CEV37 CEV39 
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Ningún error, fiichero de salida para Accel  con cálculos y sintaxis correctos.  
	*/
	public void testRF1_01() {
		AGCCalculator agcc = new AGCCalculator();
		try {
			AccelerationByAxes aba = agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RF1-01-FINAL.json", 0, 40);
			assertEquals(1, aba.getX_Axis().getMinAcceleration(), 1.0d);
			assertEquals(1, aba.getY_Axis().getMinAcceleration(), 1.0d);
			assertEquals(1, aba.getZ_Axis().getMinAcceleration(), 1.0d);
			assertEquals(1, aba.getX_Axis().getMaxAcceleration(), 1.0d);
			assertEquals(1, aba.getY_Axis().getMaxAcceleration(), 1.0d);
			assertEquals(1, aba.getZ_Axis().getMaxAcceleration(), 1.0d);
		} catch (AGCException ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	/* Caso de Prueba: CP-RF1-02
	* Clase de Equivalencia o Valor Límite Asociado: CEI15
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error semántico en Accel 
	*/
	public void testRF1_02() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RF1-02-FINAL.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: min-max accels do not match the compulsory 3 digits or more", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RF1-03
	* Clase de Equivalencia o Valor Límite Asociado:CEIV31
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error semántico en Accel.
	*/
	public void testRF1_03() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RF1-03-FINAL.json", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: min-max accel digits are not numbers", message);
	}

	@Test
/* Caso de Prueba:CP-RF1-04(Entrada) CP-S1 (Salida)
* Clase de Equivalencia o Valor Límite Asociado:CEI40
* Técnica de prueba: Clases de Equivalencia  
* Resultado Esperado: Error sintáctico en fichero de salida de Accel.
*/
	public void testRF1_04() {
		fail("not yet implemented");
	}
	
	@Test
	/* Caso de Prueba: CP-RF1-05
	* Clase de Equivalencia o Valor Límite Asociado: CEI13
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error semántico en ACCEL 
	*/
	public void testCPRF2_02() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RF1-0-FINAL.json", 0, 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Separator is not a dot in ACCEL axis", message);
	}
	
	
	@Test
	/* Caso de Prueba: CP-RF1-06
	* Clase de Equivalencia o Valor Límite Asociado:CEI18
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error sintáctico en el fichero de entrada.
	*/
	public void testCPRF1_06() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RF1-06-FINAL.json", 0, 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: ACCEL missing", message);
	}
	@Test
	/* Caso de Prueba: CP-RF1-07
	* Clase de Equivalencia o Valor Límite Asociado:CEI17
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error sintáctico en el fichero de entrada.
	*/
	public void testCPRF1_07() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RF1-07-FINAL.json", 0, 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: ACCEL axis has been repeted", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-01
	* Clase de Equivalencia o Valor Límite Asociado: CEI2 
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error de fichero no encontrado  
	*/
	public void testCPRFG_01() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: invalid path", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-02
	* Clase de Equivalencia o Valor Límite Asociado: CEV1 CEV3 CEV5 CEV7 CEV9 CEV12 CEV14 CEV16 CEV19 CEV21 CEV23 CEV25 CEV27 CEV30 
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Ningún error, Ficheros de salida 
	*/
	public void testCPRFG_02() {
		AGCCalculator agcc = new AGCCalculator();
		
		try {
			File file = new File("/PDS-P3/tests-json/CE-y-VL/CP-RFG-02.json");
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RFG-02-FINAL.json", 0, 40);
			boolean ficheroOk = file.isFile();
			
			assertEquals(ficheroOk, true);//comprueba que el fichero existe
		} catch (AGCException ex) {
			ex.printStackTrace();
		}
	}
	

	
	@Test
	/* Caso de Prueba: CP-RFG-03
	* Clase de Equivalencia o Valor Límite Asociado: CEI4
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Mensaje de error de sintaxis.  
	*/
	public void testCPRFG_03() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("", 0, 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: invalid input file syntax", message);
	}

	@Test
	/* Caso de Prueba: CP-RFG-04
	* Clase de Equivalencia o Valor Límite Asociado: CEI16
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error de formato/semántico en fecha.  
	*/
	public void testCPRFG_04() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RFG-05-FINAL.json", 0, 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: date format does not match <YYYY-MM-DD HH:mm:ss.SSS...>", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-05
	* Clase de Equivalencia o Valor Límite Asociado: CEI18
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error de formato/semántico en fecha.
	*/
	public void testCPRFG_05() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RFG-05-FINAL.json", 0, 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Time has negative values", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-06
	* Clase de Equivalencia o Valor Límite Asociado: CEI10
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Mensaje de error de formato en el fichero de entrada.  
	*/
	public void testCPRFG_06() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RFG-06-FINAL.json", 0, 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Time does not appear in an observation in the input json file", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-07
	* Clase de Equivalencia o Valor Límite Asociado: CEI11
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Mensaje de error de formato en el fichero de entrada.
	*/
	public void testCPRFG_07() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RFG-07-FINAL.json", 0, 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Time appears more than once in a singular observation", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-08
	* Clase de Equivalencia o Valor Límite Asociado: AVL6
	* Técnica de prueba: Valor Límite 
	* Resultado Esperado: Ejecución correcta
	*/
	public void testCPRFG_08() {
		AGCCalculator agcc = new AGCCalculator();
		fail("not yet implemented");
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RF2-08-FINAL.json", 0, 20);
		} catch (AGCException ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-09
	* Clase de Equivalencia o Valor Límite Asociado: AVL7
	* Técnica de prueba: Valor Límite 
	* Resultado Esperado: Error en el intervalo de tiempo entre las observaciones
	*/
	public void testCPRFG_09() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RFG-09-FINAL.json", 0, 10);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: wrong time interval, must be 20ms for each observation", message);
	}
	
	/* Caso de Prueba: CP-RFG-10
	* Clase de Equivalencia o Valor Límite Asociado: AVL4
	* Técnica de prueba: Valor Límite 
	* Resultado Esperado: Ejecución correcta
	*/
	public void testCPRFG_10() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		fail("not yet implemented");
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RFG-10-FINAL.json", 0, 10);
		} catch (AGCException ex) {
			ex.printStackTrace();
		}
	}
	
	/* Caso de Prueba: CP-RFG-11
	* Clase de Equivalencia o Valor Límite Asociado: AVL5
	* Técnica de prueba: Valor Límite 
	* Resultado Esperado: Error en el instante inicial y final.
	*/
	public void testCPRFG_11() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateMinMaxAcceleration("/PDS-P3/tests-json/CE-y-VL/CP-RFG-11-FINAL.json", 0, 10);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: initial and final instant do not follow the equation", message);
	}
	
}
