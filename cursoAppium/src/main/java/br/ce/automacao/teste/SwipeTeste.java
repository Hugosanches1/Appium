package br.ce.automacao.teste;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTeste extends BaseTeste {

    private MenuPage menuPage = new MenuPage();

    @Test
    public void deveRealizarSwipe(){
        //acessar menu
        menuPage.acessarSwipe();

        //verificar texto 'a esquerda'
        Assert.assertTrue(menuPage.existeElementoPorTexto("a esquerda"));

        //swipe para a direita
        menuPage.swipeRigth();

        //verificar o texto 'E veja se'
        Assert.assertTrue(menuPage.existeElementoPorTexto("E veja se"));

        //clicar botão direita
        menuPage.clicarPorTexto("›");

        //verificar o texto 'Chegar até o fim!'
        Assert.assertTrue(menuPage.existeElementoPorTexto("Chegar até o fim!"));

        //swipe esquerda
        menuPage.swipeLeft();

        //clicar no notão da esquerda
        menuPage.clicarPorTexto("‹");

        //verificar texto 'a esquerda'
        Assert.assertTrue(menuPage.existeElementoPorTexto("a esquerda"));

    }
}
