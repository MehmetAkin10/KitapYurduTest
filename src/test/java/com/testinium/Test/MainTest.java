package com.testinium.Test;

import com.testinium.driver.BaseTest;
import com.testinium.methods.Methods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class MainTest extends BaseTest {

    @Test
    public void mainTest() throws Exception {
        Methods methods = new Methods();

        //Üyelik oluşturma,Giriş yapma,Random Ürün seçme ve Başarısız kart ödemesi sonrasında hesaptan cıkış yapma adımlarını takip eden bir test senaryosu.






        // Giriş yap'a tıklanır
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/login']"));
        //Çıkan popup kapatılır
        methods.findElement(By.cssSelector("div#cookiescript_buttons>div#cookiescript_accept")).click();// pop-up kapama
        //methods.waitBySeconds(2);
        //methods.click(By.cssSelector("#js-popup-accept-button"));
        //Giriş için bilgiler girilir
        methods.clickableElement(By.xpath("//input[@id='login-email']")).click();
        methods.sendKeys(By.id("login-email"), "mehmet.akin@testinium.com");
        methods.clickableElement(By.xpath("//input[@id='login-password']")).click();
        methods.sendKeys(By.id("login-password"), "Merhaba1234");
        //Giriş yap butonuna tıklanır
        methods.clickableElement(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn")).click();
        methods.waitBySeconds(5); //Giriş işleminde çıkma ihtimali olan doğrulama için 10sn verildi


        //Başarılı şekilde giriş yapıldığı kontrol edilir
        String basarılıGiris = methods.getText(By.cssSelector(".common-sprite"));
        Assert.assertEquals("Merhaba Mehmet Akın", basarılıGiris );
        System.out.println("Yazı : "+ basarılıGiris);

        //Oyuncak aratırlır
        methods.findElement(By.id("search-input"));
        methods.sendKeys(By.id("search-input"), "Oyuncak");
        methods.clickableElement(By.cssSelector(".common-sprite.button-search")).click();
        //methods.click(By.cssSelector(".common-sprite.button-search"));
        //7.ürüne aşağı doğru inilir
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11652625/wi:100/wh:true']"));
        //methods.waitBySeconds(2);
        //4 adet ürün favorilere eklenir
        methods.clickableElement(By.xpath("//div[@id='product-table']/div[3]//i[@class='fa fa-heart']")).click();
        //methods.waitBySeconds(2);
        methods.clickableElement(By.xpath("//div[@id='product-table']/div[4]//i[@class='fa fa-heart']")).click();
        //methods.waitBySeconds(2);
        methods.clickableElement(By.xpath("//div[@id='product-table']/div[5]//i[@class='fa fa-heart']")).click();
        //methods.waitBySeconds(2);
        methods.clickableElement(By.xpath("//div[@id='product-table']/div[6]//i[@class='fa fa-heart']")).click();
        //methods.waitBySeconds(2);

        //Ürünlerin başarılı br şekilde eklendiğine dair kontrol sağlanır
        String favoriKontrol = methods.getText(By.xpath("//h2[@class='swal2-title ky-swal-title-single']"));
        Assert.assertEquals("Ürün başarılı bir şekilde favorilerinize eklendi!", favoriKontrol );
        System.out.println("Yazı : "+ favoriKontrol);
        //methods.waitBySeconds(3);

        //Anasayfaya dönülür
        methods.clickableElement(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11682842/wh:dec2d77ad']")).click();
        //methods.waitBySeconds(2);
        //Puan kataloguna tıklanır
        methods.clickableElement(By.xpath("//a[@href='puan-katalogu']")).click();
        methods.waitBySeconds(2);
        //Sayfada aşağı doğru inilir
        methods.scrollWithAction(By.xpath("//div[@class='heading-links']"));
        //methods.waitBySeconds(2);
        //Türk Klasiklerine tıklanır
        methods.clickableElement(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']")).click();
        methods.waitBySeconds(3);

        //Bar'da bulunan "Yüksek Oylama" seçilir
        methods.selectByText(By.xpath("//select[@onchange='location = this.value;']"), "Yüksek Oylama");
        methods.waitBySeconds(3);



        //Tüm kitaplardan "Hobi" kısmına gidilir
        methods.click(By.xpath("//a[@class='common-sprite allCategories']"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11672055/wi:180/wh:fc1c3b811']"));
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/kategori/kitap-hobi/212.html']"));
        methods.waitBySeconds(3);

        //Rastgele bir kitap seçilir ve sepete eklenir
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11804212/wi:100/wh:true']"));
        methods.waitBySeconds(5);
        methods.random(); //Methods kısmında oluşturduğum random seçimle ürün seçilir
        methods.clickableElement(By.xpath("//a[@class='add-to-cart btn-orange btn-ripple']"));
        methods.click(By.xpath("//a[@class='add-to-cart btn-orange btn-ripple']"));
        methods.waitBySeconds(3);



        //Listelerimden favorilerime gidilir
        methods.click(By.xpath("//a[.=\"Listelerim\"]"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        methods.waitBySeconds(3);

        // 3.favori ürün favorilerden çıkarılır
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11832435/wi:100/wh:true']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-639887']/div[11]//i[@class='fa fa-heart-o']"));
        methods.waitBySeconds(2);

        //Sepetime gidilir
        methods.click(By.xpath("//span[@id='cart-items']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=checkout/cart']"));
        methods.waitBySeconds(2);

        //Ürün adedi arttırılır ve güncellenir
        methods.click(By.xpath("//input[@style='width:22px']"));
        methods.waitBySeconds(2);
        methods.findElement(By.xpath("//input[@style='width:22px']")).clear();
        methods.waitBySeconds(3);
        methods.sendKeys(By.name("quantity"), "2");
        methods.waitBySeconds(3);
        methods.click(By.xpath("//i[@onclick='cartProductUpdate($(this).parent())']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//input[@class='cart-select']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=checkout/delivery']"));
        methods.waitBySeconds(3);

        //Yeni adres kayıdı açılır
        methods.clickableElement(By.xpath("//div[@class='d-flex justify-content-between align-items-center mt-6px fs-14 fw-bold mb-10px']//a[2]"));
        methods.click(By.xpath("//div[@class='d-flex justify-content-between align-items-center mt-6px fs-14 fw-bold mb-10px']//a[2]"));
        methods.waitBySeconds(2);

        //Adres bilgileri girilir
        methods.click(By.cssSelector("#address-firstname-companyname"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("address-firstname-companyname"), "Mehmet");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#address-lastname-title"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("address-lastname-title"), "Akın");
        methods.waitBySeconds(2);
        methods.selectByText(By.cssSelector("#address-zone-id"), "Balıkesir");
        methods.waitBySeconds(2);
        methods.selectByText(By.cssSelector("#address-county-id"), "AYVALIK");
        methods.waitBySeconds(2);
        methods.click(By.xpath("//input[@style=' width: 340px;']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[.='NAMIK KEMAL MAH']"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#address-address-text"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("address-address-text"), "Kardelen Sitesi No:5 Ayvalık/Balıkesir");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#address-postcode"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("address-postcode"), "10500");
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.xpath("//input[@class='btn-address-save']"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#address-mobile-telephone"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("address-mobile-telephone"), "5063702865");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#address-telephone"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("address-telephone"), "");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#address-tax-id"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("address-tax-id"), "30586126450");
        methods.waitBySeconds(2);


        methods.click(By.xpath("//input[@class='btn-address-save']"));
        methods.waitBySeconds(2);

        //Devam et butonuna tıklanır
        methods.click(By.cssSelector("#continue-button"));
        //Devam et butonuna tıklanır
        //methods.click(By.cssSelector("#button-checkout-continue"));
        methods.waitBySeconds(1);

        //Kart bilgileri girilir
        methods.findElement(By.xpath("//img[@src='https://cdn.kitapyurdu.com/default/img/cvv.svg']"));
        methods.scrollWithAction(By.xpath("//img[@src='https://cdn.kitapyurdu.com/default/img/cvv.svg']"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#credit_card_name"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit_card_name"), "MEHMET AKIN");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#credit_card_number"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit_card_number"), "1234567890121234");
        //methods.waitBySeconds(2);
        //methods.click(By.cssSelector("#credit_card_number_2"));
        //methods.waitBySeconds(2);
        //methods.sendKeys(By.id("credit_card_number_2"), "5678");
        //methods.waitBySeconds(2);
        //methods.click(By.cssSelector("#credit_card_number_3"));
        //methods.waitBySeconds(2);
        //methods.sendKeys(By.id("credit_card_number_3"), "9012");
        //methods.waitBySeconds(2);
        //methods.click(By.cssSelector("#credit_card_number_4"));
        //methods.waitBySeconds(2);
        //methods.sendKeys(By.id("credit_card_number_4"), "3456");
        methods.waitBySeconds(2);
        methods.findElement(By.cssSelector("#credit_card_expires"));
        methods.sendKeys(By.cssSelector("#credit_card_expires"), "0411");
        methods.waitBySeconds(2);
        //methods.selectByText(By.cssSelector("#credit-card-expire-date-year"), "2025");
        //methods.waitBySeconds(2);
        //methods.click(By.cssSelector("#credit_card_security_code"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit_card_security_code"), "840");
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.xpath("//div[@id='check-masterpass']//img[@src='https://cdn.kitapyurdu.com/default/img/masterpass-logo.svg']"));
/*
        methods.clickableElement(By.xpath("//input[@id='3d_secure']"));
        methods.click(By.xpath("//input[@id='3d_secure']"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#masterpass_save"));
        methods.waitBySeconds(2);

 */
        //Butona tıklanır
        methods.click(By.cssSelector("#continue-button"));
        methods.waitBySeconds(2);

        //Kart numarası geçersiz kontrolü yapılır
        String basarısızKart = methods.getText(By.xpath("//h2[@id='swal2-title']"));
        Assert.assertEquals("Kart numarası geçersiz. Kontrol ediniz!", basarısızKart);
        System.out.println("Yazı : "+ basarısızKart);
        methods.waitBySeconds(3);
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11773983/wh:44cf01be4']"));
        methods.waitBySeconds(2);

        //Anasayfaya dönülür
        methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11773983/wh:44cf01be4']"));
        methods.waitBySeconds(3);
        //Mouse hareket ettirilerek çıkış işlemi gerçekleştirilir
        methods.MouseMove(By.xpath("//a[.='Merhaba Mehmet Akın']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[.='Çıkış']"));
        methods.waitBySeconds(5);



















    }

    /*

        @Test
        public void valueTest(){
            Methods methods = new Methods();
            methods.sendKeys(By.id("common-sprite"),"Merhaba ");
            String value = methods.getValue(By.id("common-sprite"));
            System.out.println("Alınan text : " + value);
            Assert.assertEquals("Merhaba ",value);
            methods.waitBySeconds(5);

        }

     */





}
