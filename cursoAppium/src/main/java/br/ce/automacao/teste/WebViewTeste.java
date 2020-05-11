package br.ce.automacao.teste;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.MenuPage;
import br.ce.automacao.page.WebViewPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class WebViewTeste extends BaseTeste {

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();

    @Test
    public void deveFazerLogin(){
        //acessar menu
        menu.acessarSBHibrido();

        esperar(3000);
        page.entrarContextoWeb();

        //preencher email
        page.setarEmail("hugo@hotmail.com");

        //preencher senha
        page.setarSenha("hugo");

        //clicar em  entrar
        page.clicarEntrar();

        //verificar
        Assert.assertEquals("Bem vindo, Hugo!", page.getMensagem());

    }
    @After
    public void tearDown(){
        page.sairContextoWeb();

    }
}
