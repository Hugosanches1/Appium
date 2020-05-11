package br.ce.automacao.teste;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.CliquePage;
import br.ce.automacao.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CliqueTeste extends BaseTeste {
    MenuPage menu = new MenuPage();
    CliquePage page = new CliquePage();

    @Before
    public void inicializaAppium(){
        //clicar em cliques
        menu.acessarCliques();
    }

    @Test
    public void deveRealizarCliqueLongo(){
        //deve clicar longo em clique longo
        page.cliqueLongo();

        //obter otexto apresentado
        Assert.assertEquals("Clique Longo", page.obtertextoCampo());
    }
    @Test
    public void deveRealizarCliqueDuplo(){
        //dar um duplo clique em Clique Duplo
        page.cliqueDuplo();

        //verificar o texto apresentado
        Assert.assertEquals("Duplo Clique", page.obtertextoCampo());

    }
}
