package com.taller.pages;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

public class PaginaPrincipal {
    
    private WebDriver driver;

    public PaginaPrincipal(WebDriver driver) {
        this.driver = driver;
    }

    public void esperar(Duration segundos) {
        Wait<WebDriver> wait = new WebDriverWait(driver, segundos);
        wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[2]/section[7]/div[1]/a"));
            }
        }).isDisplayed();
    }

    public void botonGenerarCita() {
        WebElement botonGenerarCita = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[2]/section[7]/div[1]/a"));
        botonGenerarCita.click();
    }
}
