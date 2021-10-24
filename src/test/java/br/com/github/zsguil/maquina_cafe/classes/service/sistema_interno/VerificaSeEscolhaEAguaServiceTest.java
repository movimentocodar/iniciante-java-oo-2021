package br.com.github.zsguil.maquina_cafe.classes.service.sistema_interno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VerificaSeEscolhaEAguaServiceTest {

	@Test
	void deveRetornarTrueCasoParametroSejaAgua_EFalseCasoContrario() {
		assertTrue(new VerificaSeEscolhaEAguaService().verificar(5));
		assertFalse(new VerificaSeEscolhaEAguaService().verificar(1));
	}
	
	@Test
	void deveLancarExceptionCasoParametroSejaAgua() {
		assertThrows(IllegalArgumentException.class, 
				() -> new VerificaSeEscolhaEAguaService().verificarELancarException(5));
	}

}
