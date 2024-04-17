package com.taller.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Citas {
    private WebDriver driver;

    public Citas(WebDriver driver) {
        this.driver = driver;
    }

    public String obtenerCitaGenerada() {
        return driver.findElement(By.xpath("//*[@id=\"radix-:r24:-content-cite\"]/div/div[1]/div/div")).getText();
    }
}
