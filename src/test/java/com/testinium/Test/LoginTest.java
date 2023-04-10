package com.testinium.Test;

import com.testinium.Page.FavoriPage;
import com.testinium.Page.LoginPage;
import com.testinium.Page.ProductPage;
import com.testinium.driver.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        new LoginPage().login("mehmet.akin@testinium.com", "Merhaba1234");}


    @Test
    public void favoriEkleme(){new FavoriPage().favori();}


    @Test
    public void UrünEkleme(){new ProductPage().Product();
    }






}
