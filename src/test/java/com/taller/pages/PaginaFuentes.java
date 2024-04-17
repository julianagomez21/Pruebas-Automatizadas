package com.taller.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaFuentes {
    
    private WebDriver driver;

    public PaginaFuentes(WebDriver driver) {
        this.driver = driver;
    }

    public void escogerFuenteLibro() {
        WebElement fuente = driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[3]/div[2]/div[5]/section[1]/ol/li[3]/a"));
        fuente.click();
    }
}
