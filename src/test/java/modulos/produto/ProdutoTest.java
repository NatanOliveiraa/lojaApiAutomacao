package modulos.produto;

import dataFactory.produtoDataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import dataFactory.usuarioDataFactory.UserDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Tetes de API para o modulo de produtos")
public class ProdutoTest {
static String token;

    @BeforeEach
    public void beforEach() {
        //Configurar os dados de API Rest
        baseURI = "http://165.227.93.41";
        //port = 8080;"
        basePath = "/lojinha";

        //Extrair o token do usuario admin
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.criarUsuarioAdm())
                .when().post("/v2/login")
                .then().extract()
                .path("data.token");
        System.out.println(token);
    }

    @Test
    @DisplayName("Validar os limites Zerados dos valores dos produtos")
    public void testValidarLimiteZeradoDosValoresDosProdutos(){
        //Inserir um produto com valor 0.00 e validar a mensagem de erro

            given()
                    .contentType(ContentType.JSON)
                    .header("token", token)
                    .body(ProdutoDataFactory.criarProdutoComumComValorIgualA(0.00))
            .when()
                    .post("/v2/produtos")
            .then()
                    .assertThat()
                        .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                        .statusCode(422);
        //Validar o status code 422
    }

    @Test
    @DisplayName("Validar valores  além do limite dos produtos")
    public void testValidarValoresAlemDoLimiteDosProdutos(){

        //Inserir um produto com valor 7000.01 e validar a mensagem de erro
        //Utilizando  a classe DataFactory para otimizar o body request

        given()
            .contentType(ContentType.JSON)
                .header("token", token)
                    .body(ProdutoDataFactory.criarProdutoComumComValorIgualA(7000.01))
        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                  .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);
        //Validar o status code 422
    }

    @Test
    @DisplayName("Validar valores que estao dentro do limite")
    public void validarValorDentroDoLimite(){
        //Teste de sucesso para cadastro de um novo produto
        //Sem otimizar o body  request
        given()
                .contentType(ContentType.JSON)
                    .header("token", token)
                    .body("{\n" +
                            "  \"produtoNome\": \"Nitendo switch\",\n" +
                            "  \"produtoValor\": 1500.00,\n" +
                            "  \"produtoCores\": [\n" +
                            "    \"branco\"\n" +
                            "  ],\n" +
                            "  \"produtoUrlMock\": \"\",\n" +
                            "  \"componentes\": [\n" +
                            "    {\n" +
                            "      \"componenteNome\": \"controle\",\n" +
                            "      \"componenteQuantidade\": 2\n" +
                            "    }\n" +
                            "  ]\n" +
                            "}")
        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                .body("message", equalTo("Produto adicionado com sucesso"))
                .statusCode(201);
    }




        @Test
        @DisplayName("validar que um usuario foi adicionado com sucesso")
        public void adicionarUsuarioComSucesso(){
            given()
                    .contentType(ContentType.JSON)
                    .body(UserDataFactory.criarNovoUsuario())
                    .when()
                    .post("/v2/usuarios")
                    .then()
                    .assertThat()
                    .body("message", equalTo("Usuário adicionado com sucesso"))
                    .statusCode(201);
        }




}
