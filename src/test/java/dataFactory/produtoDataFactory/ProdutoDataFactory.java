package dataFactory.produtoDataFactory;

import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {
    public static ProdutoPojo criarProdutoComumComValorIgualA(double valor){
        ProdutoPojo produto = new ProdutoPojo();
        produto.setProdutoNome("PlayStation");
        produto.setProdutoValor(0.00);


        //Criei o objeto ArrayList e populei com as cores
        List<String> cores = new ArrayList<>();
        cores.add("Preto");
        cores.add("Branco");
        //setei a cor que eu quero atribuir
        produto.setProdutoCores(cores);
        produto.setProdutoUrlMock("");

        List<ComponentePojo>componentes = new ArrayList<>();

        ComponentePojo componente = new ComponentePojo();
        componente.setComponenteNome("Controle");
        componente.setComponenteQuantidade(2);
        componentes.add(componente);

        ComponentePojo segundoComponente = new ComponentePojo();
        segundoComponente.setComponenteNome("Jogos");
        segundoComponente.setComponenteQuantidade(2);
        componentes.add(segundoComponente);

        produto.setComponentes(componentes);
        System.out.println(produto);

        return produto;
    }

}
