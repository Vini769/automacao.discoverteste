package stepDefinition;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import data.TestData;

import static io.restassured.RestAssured.*;


public class usuarioStep {

    TestData dados = new TestData();

   String baseURI ="https://reqres.in/api";

   Response usuarios;
   Response usuario;
   Response atualizarusuario;
   Response erroregister;


    @Dado("que seja um administrador e selecionar um usuario")
    public void que_seja_um_administrador_e_selecionar_um_usuario() {


        usuario =
        given()
                .body(TestData.bodyusuario)
                .contentType(ContentType.JSON)
                .when()
                .get(baseURI+"/users/2")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract().response();
        System.out.println("       Usuario Cadastrado: " + usuario.getBody().asString());
    }

    @Quando("solicitar lista de usuarios")
    public void solicitar_lista_de_usuarios() {

    usuarios =
        given()
                .body(TestData.bodylistausuario)
                .contentType(ContentType.JSON)
                .when()
                .get(baseURI+"/users?page=2")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                        .extract().response();
        System.out.println("      Lista usuarios: " + usuarios.getBody().asString());


        // Atualizar Usuarios
    atualizarusuario =
        given()
                .body(TestData.bodyatualizar)
                .contentType(ContentType.JSON)
                .when()
                .patch(baseURI+"/users/2")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract().response();
        System.out.println("      Atualizar usuario: " + atualizarusuario.getBody().asString());

    }

    @Então("obtenho resultado das validacoes")
    public void obtenho_resultado_das_validacoes() {

        // Erro De Register
    erroregister =
        given()
                .body(TestData.bodyerroregister)
                .contentType(ContentType.JSON)
                .when()
                .post(baseURI+"/register")
                .then()
                .log().all()
                .assertThat()
                .statusCode(400)
                        .extract().response();
        System.out.println("      Erro de registro: " + erroregister.getBody().asString());


    }

}


