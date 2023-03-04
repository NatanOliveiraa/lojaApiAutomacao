package modulos.componente;
import modulos.produto.ProdutoTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Teste de API para o modeulo de componente")
public class ComponenteTest {
    ProdutoTest ponteiroProdutoTest = new ProdutoTest();
    @BeforeEach
    public void configurarApi(){

        ponteiroProdutoTest.beforEach();
    }



}
