package br.ce.automacao.teste;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.MenuPage;
import br.ce.automacao.page.SwipeListPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeElementTeste extends BaseTeste {

    private MenuPage menuPage = new MenuPage();
    private SwipeListPage page = new SwipeListPage();

    @Test
    public void deveResolverDesafio(){
        //Clicar no Swipe Lista
        menuPage.clicarSwipeList();

        //OP para a esquerda
        page.swipeElementRigth("Opção 1");

        //clicar em op1
        page.clicarBotaoMais();

        //verificar Op1
        Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));

        //Op4 para direita
        page.swipeElementRigth("Opção 4");

        //clicar em op4
        page.clicarPorTexto("(-)");

        //verificar Op4
        Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));

        //Op5 para esquerda
        page.swipeElementLeft("Opção 5 (-)");

        //verificar Op5
        Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));



    }
}
