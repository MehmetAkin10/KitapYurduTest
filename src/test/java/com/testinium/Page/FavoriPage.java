package com.testinium.Page;

import com.testinium.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FavoriPage extends Methods {
    Methods methods = new Methods();

    public void favori(){

        //Oyuncak aratırlır
        methods.sendKeys(By.id("search-input"), "Oyuncak");
        methods.clickableElement(By.cssSelector(".common-sprite.button-search"));
        methods.click(By.cssSelector(".common-sprite.button-search"));
        //7.ürüne aşağı doğru inilir
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11652625/wi:100/wh:true']"));
        methods.waitBySeconds(2);
        //4 adet ürün favorilere eklenir
        methods.click(By.xpath("//div[@id='product-table']/div[3]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.findElement(By.cssSelector("div#cookiescript_buttons>div#cookiescript_accept")).click();// pop-up kapama
        methods.click(By.xpath("//div[@id='product-table']/div[4]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[5]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[6]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);

        //Ürünlerin başarılı br şekilde eklendiğine dair kontrol sağlanır
        String favoriKontrol = methods.getText(By.cssSelector("#swal2-title"));
        Assert.assertEquals("Favorilerinize ürün eklemek için oturum açın ya da yeni hesap oluşturun!", favoriKontrol );
        System.out.println("Yazı : "+ favoriKontrol);
        methods.waitBySeconds(3);

        //Anasayfaya dönülür
        methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11682842/wh:dec2d77ad']"));
        methods.waitBySeconds(2);
    }



}
