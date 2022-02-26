package br.com.uniesp.test;

import br.com.uniesp.entidate.PessoaRequest;
import br.com.uniesp.entidate.PessoaResponse;
import br.com.uniesp.entidate.AtualizarPessoa;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class DesafioTestApi {

    @BeforeEach
    void configuraApi() {
        baseURI = 	"https://reqres.in/";
    }

    @Test
    void getMethid(){

        basePath = "api/users";
        given()
                .when()
                .get("/2")
                .then().contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_OK)
                .log().all();
    }

    @Test
    void postMethod(){

        basePath = "api/users";
        PessoaRequest pessoaRequest = new PessoaRequest("arlon", "QA2");
        given().log().all()
                .contentType(ContentType.JSON)
                .body(pessoaRequest)
                .when()
                .post("/")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .and()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/methodPost.json"))
                .log().all().extract().response().as(PessoaResponse.class);
    }

    @Test
    void putMethod(){

        basePath = "api/users/3";
        PessoaRequest pessoaRequest = new PessoaRequest("arlon", "QA3");
        given().log().all()
                .contentType(ContentType.JSON)
                .body(pessoaRequest)
                .when()
                .put()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/methodPut.json"))
                .log().all().extract().response().as(AtualizarPessoa.class);

    }

    @Test
    void deleteMethid(){
        given().contentType(ContentType.JSON)
                .when()
                .delete("api/users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
