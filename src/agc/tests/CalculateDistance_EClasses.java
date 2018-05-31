package agc.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import agc.AGCManager;
import agc.data.AccelerationByAxes;
import agc.data.DistByAxes;
import agc.data.FullTurnByAxes;
import agc.exceptions.AGCException;


import java.lang.Object;
public class CalculateDistance_EClasses {

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
	/* Caso de Prueba: CP-RFG-01
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI2 
	* TÃ©cnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error de fichero no encontrado  
	*/
	public void testCPRFG_01() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-00", 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: could not read data from input file.", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-02
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEV1 CEV3 CEV5 CEV7 CEV9 CEV12 CEV14 CEV16 CEV19 CEV21 AVL1 CEI24 CEV26 CEI29 AVL3 CEI29 CEV31 AVL5 CEV33 
	* TÃ©cnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Ningun error, Ficheros de salida
	*/
	public void testCPRFG_02() throws IOException {
		AGCManager agcc = new AGCManager();
		
		try {
			File file = new File("CP-RFG-02-FI.json");
			agcc.CalculateDist("CP-RFG-02-FINAL.json", 40);
			boolean ficheroOk = file.isFile();
			
			assertEquals(ficheroOk, true);//comprueba que el fichero existe
		} catch (AGCException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	/* Caso de Prueba: CP-RFG-03
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI4
	* TÃ©cnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Mensaje de error de sintaxis.  
	*/
	public void testCPRFG_03() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RF3-03-FINAL.json", 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: could not read data from input file.", message);
	}

	@Test
	/* Caso de Prueba: CP-RFG-04
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI16
	* TÃ©cnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error de formato/semÃ¡ntico en fecha.  
	*/
	public void testCPRFG_04() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-04-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: invalid input for Time in JSON.", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-05
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI18
	* TÃ©cnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error de formato/semÃ¡ntico en fecha.
	*/
	public void testCPRFG_05() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-05-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: invalid input for Time in JSON.", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-06
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI10
	* TÃ©cnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Mensaje de error de formato en el fichero de entrada.  
	*/
	public void testCPRFG_06() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-06-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: invalid input for Time in JSON.", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-07
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI11
	* TÃ©cnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: De las dos fechas que aparezcan se coge la segunda y si no provoca error de 50 HZ se continua sin error
	*/
	public void testCPRFG_07() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-07-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-08
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI13 CEI25 CEI30
	* TÃ©cnica de prueba: Clase de Equivalencia 
	* Resultado Esperado: Error, no se puede leer el archivo correctamente
	*/
	public void testCPRFG_08() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-08-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: could not read data from input file.", message);

	}
	
	@Test
	/* Caso de Prueba: CP-RFG-09
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI15
	* TÃ©cnica de prueba: Clase de Equivalencia 
	* Resultado Esperado: Error en precision de LONGITUD
	*/
	public void testCPRFG_09() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-09-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: less than 7 decimals for LONGITUD in JSON input data.", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-10
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI18
	* TÃ©cnica de prueba:  Clase de Equivalencia
	* Resultado Esperado: Error de formato de json...falta etiqueta de ACCEL
	*/
	public void testCPRFG_10() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-10-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: ACCEL_X in JSON input data is not a number.", message);
		
	}
	@Test
	/* Caso de Prueba: CP-RFG-11
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI17
	* TÃ©cnica de prueba: Clase de Equivalencia
	* Resultado Esperado: Se repiten campos de ACCEL para alguno de sus ejes en el fichero de entrada
	*/
	public void testCPRFG_11() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-11-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals(" ", message);
	}
	@Test
	/* Caso de Prueba: CP-RFG-12
	* Clase de Equivalencia o Valor LÃ­mite Asociado: AVL2
	* TÃ©cnica de prueba:  Valor LÃ­mite
	* Resultado Esperado: El valor de la latitud en el fichero de entrada no estaÌ� entre -90 y 90 ERROR
	*/
	public void testCPRFG_12() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-12-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: latitude value forLATITUD cannot be less than -90 or greater than 90.", message);
	}
	@Test
	/* Caso de Prueba: CP-RFG-13
	* Clase de Equivalencia o Valor LÃ­mite Asociado: AVL5
	* TÃ©cnica de prueba:  Valor LÃ­mite
	* Resultado Esperado: La duracioÌ�n concuerda con la ecuacion
	*/
	public void testCPRFG_13() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-13-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("", message);
	}
	@Test
	/* Caso de Prueba: CP-RFG-14
	* Clase de Equivalencia o Valor LÃ­mite Asociado: AVL6
	* TÃ©cnica de prueba:  Valor LÃ­mite
	* Resultado Esperado: La duracioÌ�n concuerda con la ecuacion
	*/
	public void testCPRFG_14() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-14-FINAL.json", 80);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: time frame to process exceeds experiment length.", message);
	}
	@Test
	/* Caso de Prueba: CP-RFG-15
	* Clase de Equivalencia o Valor LÃ­mite Asociado: AVL7
	* TÃ©cnica de prueba:  Valor LÃ­mite
	* Resultado Esperado: Sin Error
	*/
	public void testCPRFG_15() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-15-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("", message);
	}
	@Test
	/* Caso de Prueba: CP-RFG-16
	* Clase de Equivalencia o Valor LÃ­mite Asociado: AVL8
	* TÃ©cnica de prueba:  Valor LÃ­mite
	* Resultado Esperado: La duracioÌ�n concuerda con la ecuacion
	*/
	public void testCPRFG_16() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-16-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: time values in experiment are not consecutive with a 50Hz rate.", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-17
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI20
	* TÃ©cnica de prueba: Clase de Equivalencia
	* Resultado Esperado: Los caracteres distintos del separador no son nuÌ�meros de 0-9 para ACCEL -> No se puede leer el archivo
	*/
	public void testCPRFG_17() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-17-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: could not read data from input file.", message);
	}
	@Test
	/* Caso de Prueba: CP-RFG-18
	* Clase de Equivalencia o Valor LÃ­mite Asociado: AVL4
	* TÃ©cnica de prueba:  Valor LÃ­mite
	* Resultado Esperado: El valor de la longitud en el fichero de entrada no estaÌ� entre -180 y 180
	*/
	public void testCPRFG_18() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("CP-RFG-18-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: longitude value forLONGITUD cannot be less than -180 or greater than 180.", message);
	}
	
	/*H A S T A      A Q U I      G E N E R A L E S*/
	
	@Test
	/* Caso de Prueba: CP-RF3-01
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEV35 CEV37
	* TÃ©cnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Los calculos sobre distancia son correctas para cada eje generando un JSON acorde con el esperado como salida
	*/
	public void testCPRF3_01() throws IOException, AGCException {
		AGCManager agcc = new AGCManager();
		String message = "";
	
		DistByAxes result = agcc.CalculateDist("CP-RF3-01-FINAL.json",  20);

		assertEquals( 60.0 , result.getDist_X(), 0.001f);
		assertEquals( 0.0017 , result.getDist_Y(), 0.001f);
		assertEquals( 0.0026 , result.getDist_Z(), 0.001f);
	}
	
	@Test
	/* Caso de Prueba: CP-RF3-02
	* Clase de Equivalencia o Valor LÃ­mite Asociado: CEI18
	* TÃ©cnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Fichero de salida con sintaxis JSON incorrecta para distancia respecto a cada eje
	*/
	public void testCPRF3_02() throws IOException {
		AGCManager agcc = new AGCManager();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RF3-02-FINAL.json",  20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		
		JSONObject data = getRESTData("DIST.json");
		JSONAssert.assertEquals(
				  "{foo: 'bar', baz: 'qux'}",
				  JSONObject.fromObject("{foo: 'bar', baz: 'xyzzy'}"));
	}
	


}
