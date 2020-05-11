package br.ce.automacao.teste;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.AlertPage;
import br.ce.automacao.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlertaTeste extends BaseTeste {

    MenuPage menu = new MenuPage();
    AlertPage alertpage = new AlertPage();

    @Before
    public void inicializarApium(){
        //Acessar menu de alertas
        menu.acessarAlertas();
    }
    @Test
    public void deveInteragirComAlert(){

        //clicar no alerta com confirmação
        alertpage.clicarAlertConfimracao();

        //verificar o texto do alerta
        Assert.assertEquals("Info", alertpage.obterTituloAlert());
        Assert.assertEquals("Confirma a operação?", alertpage.obterMensagemAlerta());

        //confirmar INFO alerta
        alertpage.clicarEmConfirmacaoAlerta();

        //verificar o texto do alerta
        Assert.assertEquals("Confirmado", alertpage.obterTextoAlertaConfirmado());

        //Clicar no sair no ultimo alerta apresentado
        alertpage.clicarEmSairAlert();
    }
    @Test
    public void deveClicarForaAlerta(){
        alertpage.clicarAlertaSimples();
        esperar(1000);
        alertpage.clicarForaCaixa();
        Assert.assertFalse(alertpage.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }
}
