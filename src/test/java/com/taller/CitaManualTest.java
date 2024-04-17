package com.taller;

import static org.junit.Assert.assertEquals;


import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.taller.pages.Citas;
import com.taller.pages.FuenteLibro;
import com.taller.pages.Inicio;
import com.taller.pages.PaginaFuentes;
import com.taller.pages.PaginaPrincipal;

public class CitaManualTest 
{
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
    public void testGenerarCitaManualmente()
    {
        Inicio inicio = new Inicio(driver);
        inicio.botonInicioSesion();
        inicio.ingresarEmail("jgomezgal25@gmail.com");
        inicio.ingresarContrasena("Aaasss1@");

        inicio.clickIngresar();

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal(driver);
        paginaPrincipal.esperar(Duration.ofSeconds(10));
        paginaPrincipal.botonGenerarCita();
        paginaPrincipal.botonCitarManualmente();

        PaginaFuentes paginaFuentes = new PaginaFuentes(driver);
        paginaFuentes.escogerFuenteLibro();

        FuenteLibro fuenteLibro = new FuenteLibro(driver);
        fuenteLibro.completarFormularioLibro("Pruebas de Software y JUnit", "Daniel", "Bolaños", "2007");
        fuenteLibro.botonCitarFuente();

        Citas citas = new Citas(driver);

        String citaGenerada = citas.obtenerCitaGenerada();
        assertEquals("Bolaños, D. (2007). Pruebas de Software y JUnit.", citaGenerada);
    }
}
