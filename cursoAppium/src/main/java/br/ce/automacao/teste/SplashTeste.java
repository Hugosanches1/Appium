package br.ce.automacao.teste;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.core.DriverFactory;
import br.ce.automacao.page.MenuPage;
import br.ce.automacao.page.SplashPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class SplashTeste extends BaseTeste {

    MenuPage menu = new MenuPage();
    SplashPage splashPage = new SplashPage();

    @Before
    public void inicializarAppium(){
        menu.acessarSplash();
    }
    @Test
    public void deveAguardarSplashSumir(){
        //acessar o menu splash
        //menu.acessarSplash();

        //verificar que o splash está sendo exibido
        splashPage.isSplashVisivel();

        //Aguardar a saida do splash
        splashPage.aguardarSplashSumir();

        //verificar que o formulário está aparecendo
        Assert.assertTrue(splashPage.existeElementoPorTexto("Formulário"));

    }
}
