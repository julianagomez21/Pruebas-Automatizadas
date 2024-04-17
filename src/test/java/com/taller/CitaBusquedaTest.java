package com.taller;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import com.taller.pages.GeneradorCitas;
import com.taller.pages.Inicio;
import com.taller.pages.PaginaPrincipal;

public class CitaBusquedaTest {

    private WebDriver driver;
    
    @Before
    public void abrirNavegador(){
        driver = new ChromeDriver();
        driver.get("https://www.scribbr.es/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    
    @BeforeClass
    public static void configuracionGeneral(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\julis\\Taller de pruebas de sw\\chromedriver-win64\\chromedriver.exe");
    }

    @After
    public void cerrarNavegador(){
        driver.quit();
    }

    @Test
    public void testGenerarCitaBusquedaInvalida()
    {
        Inicio inicio = new Inicio(driver);
        inicio.botonInicioSesion();
        inicio.ingresarEmail("jgomezgal25@gmail.com");
        inicio.ingresarContrasena("Aaasss1@");

        inicio.clickIngresar();

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal(driver);
        paginaPrincipal.esperar(Duration.ofSeconds(10));
        paginaPrincipal.botonGenerarCita();

        GeneradorCitas generadorCitas = new GeneradorCitas(driver);
        generadorCitas.ingresarBusqueda("https://www.scribbr.com/citation/generator/folders/5qPdxdAesuaLEOKg0nnZkw/lists/1hECFRgQudXsAr3GGhfLF/");
        generadorCitas.botonBuscar();
        String resultado = generadorCitas.obtenerResultadoBusqueda();
        assertEquals("No results found", resultado);
    }


}
