package com.java.steps;

import com.java.api.produtoapi.Model.Produto;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class StepDefinitions {

    private Response response;
    private final String BASE_URL = "https://dummyjson.com";

    @Quando("eu envio um POST para {string} com os dados do produto {string}")
    public void criarProduto(String endpoint, String produto) throws InterruptedException {
        switch (produto){
           case "Serum":
                Produto serum = Produto.criarSerumPadrao();

                    response = given()
                        .relaxedHTTPSValidation()
                        .contentType(ContentType.JSON)
                        .body(serum)
                        .when()
                        .post(BASE_URL+endpoint);

                Thread.sleep(3000);
                break;

           case "Cucumber":
                Produto cucumber = Produto.criarCucumberPadrao();

                    response = given()
                        .relaxedHTTPSValidation()
                        .contentType(ContentType.JSON)
                        .body(cucumber)
                        .when()
                        .post(BASE_URL+endpoint);

                Thread.sleep(3000);
                break;

           case "Mascara Lash":
                Produto mascaraLash = Produto.criarMascaraLashPadrao();

                    response = given()
                        .relaxedHTTPSValidation()
                        .contentType(ContentType.JSON)
                        .body(mascaraLash)
                        .when()
                        .post(BASE_URL+endpoint);

                Thread.sleep(3000);
                break;

           default:
                System.out.println("N/A");

        }
    }

    @Entao("o status code da resposta deve ser {int}")
    public void validarStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Entao("o corpo da resposta deve conter o {string} como {string}")
    public void validarCorpoResposta(String chave, String valor) {
        response.then().body(chave, is(valor));
    }

    @Dado("que existe um produto cadastrado com ID {int}")
    public void verificarProdutoExistente(int id) {

    }

    @Quando("eu envio um GET para {string} com ID {int}")
    public void enviarGetProduto(String endpoint,int id) {
        response = given()
                .relaxedHTTPSValidation()
                .when()
            .get(BASE_URL + endpoint + id);
        System.out.println(BASE_URL+endpoint+id);
    }

    @E("o titulo do produto retornado deve ser {string}")
    public void validarTituloRetornado(String titulo) {
        response.then().body("title", is(titulo));
    }

    @E("a marca do produto deve ser {string}")
    public void validarMarcaRetornada(String marca) {
        response.then().body("brand", is(marca));
    }

    @E("a categoria do produto deve ser {string}")
    public void validarCatRetornada(String categoria) {
        response.then().body("category", is(categoria));
    }
}