package br.ce.automacao.teste;

import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.MenuPage;
import br.ce.automacao.seuBarriga.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SBTeste extends BaseTeste {

    private MenuPage menu = new MenuPage();
    private SBLoginPage page = new SBLoginPage();
    private SBMenuPage menuPage = new SBMenuPage();
    private SBContasPage contasPage = new SBContasPage();
    private SBMovimentacaoPage movPage = new SBMovimentacaoPage();
    private SBHomePage homePage = new SBHomePage();
    private SBResumoPage resumoPage = new SBResumoPage();

    @Before
    public void setup(){
        //clicar no seu barriga nativo
        menu.acessarSBNativo();

        //informar nome
        page.setarNome("hugo@hotmail.com");

        //informar senha
        page.setarSenha("hugo");

        //clicar em entrar
        page.entrar();

    }
    @Test
    public void deveInserirContaComsucesso(){
        //clicar em contas
        menuPage.clicarContas();

        //informar o nomme
        contasPage.setarNomeConta("Hugo");

        //clicar em salvar
        contasPage.salvar();

        //verificar mensagem de "Conta adicionada com sucesso"
        Assert.assertTrue(contasPage.existeElementoPorTexto("Conta adicionada com sucesso"));
    }
    @Test
    public void deveexcluirConta(){
        //entrar em contas
        menuPage.clicarContas();

        //clique longo na conta
        contasPage.selecionarConta("Hugo");

        //excluir
        contasPage.excluir();

        //verificar mensagem
        Assert.assertTrue(contasPage.existeElementoPorTexto("Conta excluida com sucesso"));
    }
    @Test
    public void deveValidarInclusaoMovimentacao(){
        //acessar movimentaçoes
        menuPage.acessarMovimentacoes();

        //validar desc
        movPage.salvar();
        Assert.assertTrue(movPage.existeElementoPorTexto("Descrição é um campo obrigatório"));

        //validar inte
        movPage.setDescricao("Descriçao");
        movPage.salvar();
        Assert.assertTrue(movPage.existeElementoPorTexto("Interessado é um campo obrigatório"));

        //validar valor
        movPage.setInteressado("Intere");
        movPage.salvar();
        Assert.assertTrue(movPage.existeElementoPorTexto("Valor é um campo obrigatório"));

        //valor conta
        movPage.setValor("123");
        movPage.salvar();
        Assert.assertTrue(movPage.existeElementoPorTexto("Conta é um campo obrigatório"));

        //inserir sucesso
        movPage.setConta("Hugo");
        movPage.salvar();
        Assert.assertTrue(movPage.existeElementoPorTexto("Movimentação cadastrada com sucesso"));

    }
    @Test
    public void deveAtualizarSaldoExcluiMovimentacao(){
        //verificar saldo "Conta para saldo = 534.00"
        Assert.assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));

        //ir para resumo
        menuPage.acessarResumo();

        //excluir movimentação
        esperar(1000);
        resumoPage.excluirMovimentacao("Movimentacao 3, calculo saldo");


        //validar a mensagem "Movimentação removida com sucesso"
        Assert.assertTrue(resumoPage.existeElementoPorTexto("Movimentação removida com sucesso!"));

        //volta home
        menuPage.acessarHome();

        //atualziar saldo
        esperar(1000);
        homePage.scroll(0.2,0.9);

        //verificar saldo = -1000.00
        Assert.assertEquals("-1000.00", homePage.obterSaldoConta("Conta para saldo"));;
    }
}
