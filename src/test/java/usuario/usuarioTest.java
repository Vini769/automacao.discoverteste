package usuario;

import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import static io.restassured.RestAssured.*;


public class usuarioTest {

    @Before
    @Test
    public void testDadoUmAdministradorQuandoSolicitarListaDeUsuariosEntaoObtenhoObtenhoResultadosDasValidacoes() {
        // Configurar o caminho comum de acesso a minha API Rest
        baseURI = "https://reqres.in";
        basePath = "/api";


        // Acessar Usuarios
        given()
                .body("{\n" +
                        "  \"data\": {\n" +
                        "    \"id\": 2,\n" +
                        "    \"email\": \"janet.weaver@reqres.in\",\n" +
                        "    \"first_name\": \"Janet\",\n" +
                        "    \"last_name\": \"Weaver\",\n" +
                        "    \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
                        "  }\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .get("/users/2")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);

        // Lista De Usuarios
        given()
                .body("{\n" +
                        "  \"page\": 2,\n" +
                        "  \"per_page\": 6,\n" +
                        "  \"total\": 12,\n" +
                        "  \"total_pages\": 2,\n" +
                        "  \"data\": [\n" +
                        "    {\n" +
                        "      \"id\": 7,\n" +
                        "      \"email\": michael.lawson@reqres.in\"\",\n" +
                        "      \"first_name\": \"Michael\",\n" +
                        "      \"last_name\": \"Lawson\",\n" +
                        "      \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}\n")
                .contentType(ContentType.JSON)
                .when()
                .get("/users?page=2")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);


            // Atualizar Usuarios
            given()
                    .body("{\n" +
                            "  \"updatedAt\": \"2023-11-27T20:34:47.281Z\"\n" +
                            "}")
                    .contentType(ContentType.JSON)
                    .when()
                    .patch("/users/2")
                    .then()
                    .log().all()
                    .assertThat()
                    .statusCode(200);



            // Erro De Register
        given()
                .body("{\n" +
                        "  \"username\": \"vinicius\",\n" +
                        "  \"email\": \"vini_769@hotmail.com\",\n" +
                        "  \"password\": \"123456789\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("/register")
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);

        }
    }

