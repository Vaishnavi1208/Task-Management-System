package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class TaskResourceTest {
  @Test
  void testDatabaseConnection() {
    given()
        .when()
        .get("/db")
        .then()
        .statusCode(200)
        .body(is("Connected to PostgreSQL: PostgreSQL"));
  }
}
