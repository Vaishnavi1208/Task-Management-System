package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import javax.sql.DataSource;
import java.sql.Connection;

@Path("/db")
public class TaskResource {

   @Inject
    DataSource dataSource;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testConnection() {

        try (Connection connection = dataSource.getConnection()) {

            return "Connected to PostgreSQL: "
                    + connection.getMetaData().getDatabaseProductName();

        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
