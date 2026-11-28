package org.acme;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.acme.task.Task;
import org.acme.users.User;
import org.junit.jupiter.api.Test;

@QuarkusTest
class TaskEntityTest {

  @Inject EntityManager entityManager;

  @Test
  void rejectsNullStatus() {
    assertThrows(NullPointerException.class, () -> new Task().setStatus(null));
  }

  @Test
  @TestTransaction
  void initializesCreatedAtOnPersistAndLeavesUpdatedAtToService() {
    User creator = new User("timestamp-test", "unused");
    entityManager.persist(creator);

    Task task = new Task();
    task.setTitle("Timestamp test");
    task.setCreator(creator);
    entityManager.persist(task);
    entityManager.flush();

    assertNotNull(task.getCreatedAt());
    assertNull(task.getUpdatedAt());
  }
}
