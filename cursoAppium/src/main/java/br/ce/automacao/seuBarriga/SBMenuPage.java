package br.ce.automacao.seuBarriga;

import br.ce.automacao.core.BasePage;

public class SBMenuPage extends BasePage {
    public void clicarContas(){
        clicarPorTexto("CONTAS");
    }
    public void acessarMovimentacoes(){
        clicarPorTexto("MOV...");
    }
    public void acessarResumo(){
        clicarPorTexto("RESUMO");
    }
    public void acessarHome(){
        clicarPorTexto("HOME");
    }
}
