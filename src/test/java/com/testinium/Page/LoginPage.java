package com.testinium.Page;

import com.testinium.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends Methods {
    Methods methods = new Methods();

    public void login(String username,String password){
        // Giriş yap'a tıklanır
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/login']"));
        //Çıkan popup kapatılır
        methods.findElement(By.cssSelector("div#cookiescript_buttons>div#cookiescript_accept")).click();// pop-up kapama
        methods.waitBySeconds(2);
        //methods.click(By.cssSelector("#js-popup-accept-button"));
        //Giriş için bilgiler girilir
        methods.click(By.xpath("//input[@id='login-email']"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("login-email"), username);
        methods.waitBySeconds(2);
        methods.click(By.xpath("//input[@id='login-password']"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("login-password"), password);
        methods.waitBySeconds(2);
        //Giriş yap butonuna tıklanır
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySeconds(10); //Giriş işleminde çıkma ihtimali olan doğrulama için 10sn verildi


        //Başarılı şekilde giriş yapıldığı kontrol edilir
        String basarılıGiris = methods.getText(By.cssSelector(".common-sprite"));
        Assert.assertEquals("Merhaba Mehmet Akın", basarılıGiris );
        System.out.println("Yazı : "+ basarılıGiris);
        methods.waitBySeconds(4);
    }


}
