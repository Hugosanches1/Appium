package br.ce.automacao.teste;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.AccordionPage;
import br.ce.automacao.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTeste extends BaseTeste {
    MenuPage menuPage = new MenuPage();
    AccordionPage accordionPage = new AccordionPage();

    @Test
    public void deveInteragirAccordion(){
        //acessar o menu Accordion
        menuPage.acessarAccordion();

        //clicar na opcao 1
        accordionPage.clicarOpcao1();

        //verificar a descricao da opca1
        Assert.assertEquals("Esta é a descrição da opção 1", accordionPage.obterTextoOpcao1() );
    }
}
