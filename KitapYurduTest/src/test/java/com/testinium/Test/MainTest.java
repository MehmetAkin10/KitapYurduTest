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

        //Üyelik oluşturma,Griş yapma,Ürün eklme ve Başarısız kart ödemesi sonrasında hesaptan cıkış yapma adımlarını takip eden bir test senaryosu.



        // Giriş yap'a tıklanır
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/login']"));
        //Çıkan popup kapatılır
        methods.click(By.cssSelector("#js-popup-accept-button")); // pop-up kapama
        methods.waitBySeconds(2);
        //Giriş için bilgiler girilir
        methods.click(By.xpath("//input[@id='login-email']"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("login-email"), "mehmet.akin@testinium.com");
        methods.waitBySeconds(2);
        methods.click(By.xpath("//input[@id='login-password']"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("login-password"), "Merhaba1234");
        methods.waitBySeconds(2);
        //Giriş yap butonuna tıklanır
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySeconds(2);

        //Başarılı şekilde giriş yapıldığı kontrol edilir
        String basarılıGiris = methods.getText(By.cssSelector(".common-sprite"));
        Assert.assertEquals("Merhaba Mehmet Akın", basarılıGiris );
        System.out.println("Yazı : "+ basarılıGiris);
        methods.waitBySeconds(4);

        //Oyuncak aratırlır
        methods.sendKeys(By.id("search-input"), "Oyuncak");
        methods.click(By.cssSelector(".common-sprite.button-search"));
        //7.ürüne aşağı doğru inilir
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:4856384/wi:100/wh:true']"));
        methods.waitBySeconds(2);
        //4 adet ürün favorilere eklenir
        methods.click(By.xpath("//div[@id='product-table']/div[3]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[4]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[5]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@id='product-table']/div[6]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(2);

        //Ürünlerin başarılı br şekilde eklendiğine dair kontrol sağlanır
        String favoriKontrol = methods.getText(By.xpath("//h2[@class='swal2-title ky-swal-title-single']"));
        Assert.assertEquals("Ürün başarılı bir şekilde favorilerinize eklendi!", favoriKontrol );
        System.out.println("Yazı : "+ favoriKontrol);
        methods.waitBySeconds(3);

        //Anasayfaya dönülür
        methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11682842/wh:dec2d77ad']"));
        methods.waitBySeconds(2);
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
        methods.click(By.xpath("//span[.=\"Tüm Kitaplar\"]"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[.='Hobi']"));
        methods.waitBySeconds(3);

        //Rastgele bir kitap seçilir ve sepete eklenir
        methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11534498/wi:100/wh:true']"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.xpath("//a[@href='https://www.kitapyurdu.com/yazar/sumeyye-eroglu/199990.html']"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//a[@class='add-to-cart btn-orange btn-ripple']"));
        methods.waitBySeconds(3);

        //Listelerimden favorilerime gidilir
        methods.click(By.xpath("//a[.=\"Listelerim\"]"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        methods.waitBySeconds(2);

        // 3.favori ürün favorilerden çıkarılır
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11652625/wi:100/wh:true']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@class='product-list']/div[3]//i[@class='fa fa-heart-o']"));
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
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=checkout/checkout']"));
        methods.waitBySeconds(3);

        //Yeni adres kayıdı açılır
        methods.click(By.xpath(" //a[@href='#tab-shipping-new-adress']"));
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
        methods.scrollWithAction(By.xpath("//label[@for='use-payment-address']"));
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

        //Devam et butonuna tıklanır
        methods.click(By.cssSelector("#button-checkout-continue"));
        methods.waitBySeconds(2);
        //Devam et butonuna tıklanır
        methods.click(By.cssSelector("#button-checkout-continue"));
        methods.waitBySeconds(2);

        //Kart bilgileri girilir
        methods.scrollWithAction(By.cssSelector(".ui-selectmenu-text"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#credit-card-owner"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit-card-owner"), "MEHMET AKIN");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#credit_card_number_1"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit_card_number_1"), "1234");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#credit_card_number_2"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit_card_number_2"), "5678");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#credit_card_number_3"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit_card_number_3"), "9012");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#credit_card_number_4"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit_card_number_4"), "3456");
        methods.waitBySeconds(2);
        methods.selectByText(By.cssSelector("#credit-card-expire-date-month"), "04");
        methods.waitBySeconds(2);
        methods.selectByText(By.cssSelector("#credit-card-expire-date-year"), "2025");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#credit-card-security-code"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit-card-security-code"), "840");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#credit-card-is-3ds-label"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#register-credit-card-label"));
        methods.waitBySeconds(2);
        //Butona tıklanır
        methods.click(By.cssSelector("#button-checkout-continue"));
        methods.waitBySeconds(2);

        //Kart numarası geçersiz kontrolü yapılır
        String basarısızKart = methods.getText(By.xpath("//span[@class='error']"));
        Assert.assertEquals("Kart numarası geçersiz. Kontrol ediniz!", basarısızKart);
        System.out.println("Yazı : "+ basarısızKart);
        methods.waitBySeconds(3);
        methods.scrollWithAction(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11596679/wh:57b377137']"));
        methods.waitBySeconds(2);

        //Anasayfaya dönülür
        methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11596679/wh:57b377137']"));
        methods.waitBySeconds(3);
        //Mouse hareket ettirilerek çıkış işlemi gerçekleştirilir
        methods.MouseMove(By.xpath("//a[.='Merhaba Mehmet Akın']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[.='Çıkış']"));
        methods.waitBySeconds(4);












































































//a[.='Listelerim']



        //li[@class='has-open-menu selected']/span[@class='mn-strong common-sprite']










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
