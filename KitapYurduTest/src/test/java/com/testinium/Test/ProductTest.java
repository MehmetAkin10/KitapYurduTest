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
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:4856384/wi:100/wh:true']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[3]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[4]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[5]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[6]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);

        String basarılıGiris = methods.getText(By.xpath("//h2[@class='swal2-title ky-swal-title-single']"));
        Assert.assertEquals("Ürün başarılı bir şekilde", basarılıGiris );
        System.out.println("Yazı : "+ basarılıGiris);
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
