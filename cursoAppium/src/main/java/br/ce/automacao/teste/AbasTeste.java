package br.ce.automacao.teste;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.AbasPage;
import br.ce.automacao.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbasTeste extends BaseTeste {

    MenuPage menuPage = new MenuPage();
    AbasPage abasPage = new AbasPage();

    @Test
    public void deveInteragirComAbas(){
        //Acessar o menu com abas
        menuPage.acessarAbas();

        //Deve verificar o conteudo da aba 1
        Assert.assertTrue(abasPage.isAba1());

        //clicar na segunda aba da página
        abasPage.clicarAba2();

        //verificar o texto da segund aaba
        Assert.assertTrue(abasPage.isAba2());

        //voltar para a primeira aba da pagina
       // abasPage.acessarAba1();
    }
}
