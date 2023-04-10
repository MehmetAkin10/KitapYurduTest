package com.testinium.Page;

import com.testinium.methods.Methods;
import org.openqa.selenium.By;

public class ProductPage extends Methods {
    Methods methods = new Methods();

    public void Product(){
        //Puan kataloguna tıklanır
        methods.click(By.xpath("//a[@href='puan-katalogu']"));
        methods.waitBySeconds(2);
        //Sayfada aşağı doğru inilir
        methods.scrollWithAction(By.xpath("//div[@class='heading-links']"));
        methods.waitBySeconds(2);
        //Türk Klasiklerine tıklanır
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(3);

        //Bar'da bulunan "Yüksek Oylama" seçilir
        methods.selectByText(By.xpath("//select[@onchange='location = this.value;']"), "Yüksek Oylama");
        methods.waitBySeconds(3);

        //Tüm kitaplardan "Hobi" kısmına gidilir
        methods.click(By.xpath("//a[@class='common-sprite allCategories']"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11672055/wi:180/wh:fc1c3b811']"));
        methods.findElement(By.cssSelector("div#cookiescript_buttons>div#cookiescript_accept")).click();// pop-up kapama

        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/kategori/kitap-hobi/212.html']"));
        methods.waitBySeconds(3);

        //Rastgele bir kitap seçilir ve sepete eklenir
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11804212/wi:100/wh:true']"));
        methods.waitBySeconds(5);
        methods.random(); //Methods kısmında oluşturduğum random seçimle ürün seçilir
        methods.clickableElement(By.xpath("//a[@class='add-to-cart btn-orange btn-ripple']"));
        methods.click(By.xpath("//a[@class='add-to-cart btn-orange btn-ripple']"));
        methods.waitBySeconds(3);
    }
}
