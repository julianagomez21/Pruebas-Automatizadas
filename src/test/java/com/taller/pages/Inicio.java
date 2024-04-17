package com.taller.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inicio {
    
    private WebDriver driver;

    public Inicio(WebDriver driver) {
        this.driver = driver;
    }

    public void botonInicioSesion(){
        WebElement botonInicioSesion = driver.findElement(By.linkText("Iniciar sesión"));
        botonInicioSesion.click();
    }

    public void ingresarEmail(String email){
        WebElement campoEmail = driver.findElement(By.id("loginEmailInput"));
        campoEmail.sendKeys(email);
    }

    public void ingresarContrasena(String contrasena){
        WebElement campoContrasena = driver.findElement(By.id("loginPasswordInput"));
        campoContrasena.sendKeys(contrasena);
    }

    public void clickIngresar(){
        WebElement botonIniciarSesion = driver.findElement(By.cssSelector(".base-button-primary[data-v-a824f124]"));
        botonIniciarSesion.click();
    }
}
