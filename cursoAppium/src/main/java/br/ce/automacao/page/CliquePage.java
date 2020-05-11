package br.ce.automacao.page;

import br.ce.automacao.core.BasePage;
import br.ce.automacao.core.DriverFactory;
import org.openqa.selenium.By;

public class CliquePage extends BasePage {
    public void cliqueLongo(){
        clicarLongoPorTexto("Clique Longo");
    }
    public void cliqueDuplo(){
        clicarPorTexto("Clique duplo");
        clicarPorTexto("Clique duplo");
    }
    public String obtertextoCampo(){
        //X path entre parentese retorna pesquisa todos os niveis e pega a 3 ocorrencia
        return obtertexto(By.xpath("(//android.widget.TextView)[3]"));
    }

}
