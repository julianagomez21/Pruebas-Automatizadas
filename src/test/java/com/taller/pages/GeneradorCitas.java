package com.taller.pages;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

public class GeneradorCitas {
    private WebDriver driver;

    public GeneradorCitas(WebDriver driver) {
        this.driver = driver;
    }

    public void botonCitarManualmente() {
        WebElement botonCitarManualmente = driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[1]/div[1]/div[2]/div[2]/button"));
        botonCitarManualmente.click();
    }    

    public void ingresarBusqueda(String busqueda) {
        //this.esperarBuscador();
        WebElement campoBusqueda = driver.findElement(By.xpath(
    "//*[@id=\"top\"]/div[2]/div[1]/div[1]/div[2]/div[1]/form/div[1]/label/input"));
        campoBusqueda.sendKeys(busqueda);
    }

    public void esperarBuscador() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[3]/div[2]/div[5]/div/div[2]/div[1]/form/div[1]/label/input"));
            }
        }).isDisplayed();
    }

    public void botonBuscar() {
        WebElement botonBuscar = driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[1]/div[1]/div[2]/div[1]/form/div[3]/button"));
        botonBuscar.click();
    }

    public String obtenerResultadoBusqueda() {
        return driver.findElement(By.xpath("//*[@id=\"radix-:Raail:\"]/div/div[1]/h2")).getText();
    }
}
