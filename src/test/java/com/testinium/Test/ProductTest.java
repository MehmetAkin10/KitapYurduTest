package com.testinium.Test;

import com.testinium.driver.BaseTest;
import com.testinium.methods.Methods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ProductTest extends BaseTest {

    @Test
    public void productTest() {
        Methods methods = new Methods();
        methods.sendKeys(By.id("search-input"), "Oyuncak");
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11652625/wi:100/wh:true']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[3]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        String UyarıKontrol = methods.getText(By.xpath("//h2[@id='swal2-title']"));
        Assert.assertEquals("Favorilerinize ürün eklemek için oturum açın ya da yeni hesap oluşturun!", UyarıKontrol);
        System.out.println("Yazı : "+UyarıKontrol);
        //h2[@id='swal2-title']

        methods.click(By.cssSelector("div>#cookiescript_accept"));

        methods.clickableElement(By.xpath("//div[@id='product-639887']/div[2]//i[@class='fa fa-shopping-cart']"));

        methods.click(By.xpath("//div[@id='product-639887']/div[2]//i[@class='fa fa-shopping-cart']"));


        String favoriKontrol = methods.getText(By.xpath("//h2[@id='swal2-title']"));
        Assert.assertEquals("Son Oyuncak Mağarası sepetinize eklendi!", favoriKontrol );
        System.out.println("Yazı : "+ favoriKontrol);
        methods.waitBySeconds(3);







/*
        methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11652626/wi:100/wh:true']"));
        methods.scrollWithAction(By.xpath("//i[@class='sprite__product icon__shopping-list icon--dimension-addlist icon--opacitiy-4']"));
        methods.waitBySeconds(4);
*/

        //div[@id='product-table']/div[4]//i[@class='fa fa-heart']






        //a[@onclick="addToFavorites(639887);"]

        //methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:4856384/wi:100/wh:true']"));

    }
}
