package br.ce.automacao.teste;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.DragnDropPage;
import br.ce.automacao.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class DragnDropTeste extends BaseTeste {

    private MenuPage menu = new MenuPage();
    private DragnDropPage page = new DragnDropPage();

    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    private String[] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
    private String[] estadoFinal = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};



    @Test
    public void deveEfetuarDragnDrop(){
        //acessar o menu
        menu.clicarDragnDrop();

        //verificar o estado inicial
        esperar(1000);
        Assert.assertEquals(estadoInicial, page.obterlista());

        //arrastar "Esta" para "e arreste para"
        page.arrastar("Esta", "e arraste para");

        //verificar estado intermediario
        Assert.assertEquals(estadoIntermediario, page.obterlista());

        //arrastar "Faça um clique longo" para "é uma lista"
        page.arrastar("Faça um clique longo,", "é uma lista");

        //verificar estado final
        Assert.assertEquals(estadoFinal, page.obterlista());
     }
}
