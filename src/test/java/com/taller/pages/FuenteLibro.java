package com.taller.pages;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

public class FuenteLibro {
    private WebDriver driver;

    public FuenteLibro(WebDriver driver) {
        this.driver = driver;
    }

    public void completarFormularioLibro(String titulo, String primerNombre, String apellido, String ano) {
        this.ingresarTitulo(titulo);
        this.ingresarAutor(primerNombre, apellido);
        this.ingresarAno(ano);
    }

    public void ingresarTitulo(String titulo) {
        WebElement inputTitulo = driver.findElement(By.xpath("//*[@id=\":r5:-title\"]"));
        inputTitulo.sendKeys(titulo);
    }

    public void ingresarAutor(String primerNombre, String apellido) {
        WebElement agregarPersona = driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[3]/div[2]/div[5]/div/form/div[3]/fieldset/div[2]/div/div/button[1]"));
        agregarPersona.click();

        this.esperarAutores();

        WebElement primerNombreAutor = driver.findElement(By.xpath("//*[@id=\":r5:-contributors.0.given\"]"));
        primerNombreAutor.sendKeys(primerNombre);

        WebElement apellidoAutor = driver.findElement(By.xpath("//*[@id=\":r5:-contributors.0.family\"]"));
        apellidoAutor.sendKeys(apellido);
    }

    public void ingresarAno(String ano) {
        WebElement anoPublicacion = driver.findElement(By.xpath("//*[@id=\":r5:-issued.year\"]"));
        anoPublicacion.sendKeys(ano);
    }

    public void botonCitarFuente() {
        WebElement botonCitarFuente = driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[3]/div[2]/div[5]/div/form/button"));
        botonCitarFuente.click();
    }

    public void esperarAutores() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath("//*[@id=\":r5:-contributors.0.given\"]"));
            }
        }).isDisplayed();
    }
}
