package br.ce.automacao.teste;
import java.net.MalformedURLException;
import br.ce.automacao.core.BaseTeste;
import br.ce.automacao.page.FormularioPage;
import br.ce.automacao.page.MenuPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class FormularioTeste extends BaseTeste {

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();

	}
	@Test
	public void DevePreencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Hugosanches");

		Assert.assertEquals("Hugosanches", page.obterNome());
	}
	@Test
	public void DeveInteragirComCombo() throws MalformedURLException {
		page.selecionarCombo("Nintendo Switch");
		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());

	}
	@Test
	public void DeveInteragirComSwitchCheckBox() throws MalformedURLException {

		//verificar status dos elementos
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.idSwitchMarcado());

		//clicar nos elementos
		page.clicarNoCheck();
		page.clicarNoSwitch();

		//verificar estados alterados
		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.idSwitchMarcado());

	}
	@Test
	public void DeveRealizarCadastro() throws MalformedURLException {

		//preencher campos
		page.escreverNome("Hugosanches");
		page.clicarNoCheck();
		page.clicarNoSwitch();
		page.selecionarCombo("Nintendo Switch");

		//clicar em salvar
		page.salvar();

		//validar campos
		Assert.assertEquals("Nome: Hugosanches", page.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));
	}
	@Test
	public void DeveRealizarCadastroDemorado() throws MalformedURLException {
		//preencher campos
		page.escreverNome("Hugosanches");

		//clicar em salvar
		page.salvarDemorado();

		//Usar as esperas abaixo quando a espera do Driverfactory não resolver
		//esperar(4000);
		//WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]")));

		//validar campos
		Assert.assertEquals("Nome: Hugosanches", page.obterNomeCadastrado());
	}
	@Test
	public void deveAlterarData(){
		page.setarCalendario();
		Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));
	}
	@Test
	public void deveAlterarHora(){
		page.setarHora();
		Assert.assertTrue(page.existeElementoPorTexto("19:30"));
	}
	@Test
	public void deveInteragirComSeek(){
		//clicar no seekbar na posicao passada
		page.clicarSeekBar(0.05);

		//clicar em salvar
		page.salvar();
	}
}
