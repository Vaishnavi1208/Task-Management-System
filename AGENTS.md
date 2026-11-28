# Repository instructions

These instructions apply to this repository, including the Quarkus service in
`src/main/task-management-system`.

## Project baseline

- Preserve Java 25 and the existing Quarkus platform version managed by the
  service's Maven BOM.
- Use the Maven wrapper in `src/main/task-management-system` for builds and
  tests. Keep dependency versions managed by the Quarkus BOM where available.
- Follow Jakarta APIs and the existing package and naming conventions.
- Avoid adding dependencies unless they are needed for the requested change.

## Application structure

- Keep REST resources focused on HTTP concerns. Put business logic in
  CDI-injected services and persistence operations in repository classes.
- Use JPA entities for persistence and DTOs at API boundaries. Do not expose
  entities directly in REST request or response bodies.
- Use constructor injection where practical; follow existing CDI conventions
  when changing established code.
- Put write transaction boundaries on service methods with `@Transactional`.
- Use PostgreSQL as the database and Hibernate ORM/JPA for persistence.
- Use Hibernate schema management based on entity mappings; do not add a
  migration tool or migration scripts unless requested. Avoid destructive
  schema actions such as drop-and-create, and call out schema changes and their
  deployment impact.

## REST and validation

- Preserve the existing unversioned route convention unless a change explicitly
  requests API versioning.
- Validate incoming data with Jakarta Bean Validation and return appropriate
  HTTP status codes.
- Keep error responses consistent and handle application exceptions centrally
  rather than duplicating response construction in resources.
- Do not leak credentials, internal exception details, or sensitive data in API
  responses or logs.

## Java style and security

- Format Java sources with Spotless and Google Java Format. Check formatting
  with `sh ./mvnw spotless:check`; apply it with `sh ./mvnw spotless:apply`,
  then review the resulting diff.
- Keep configuration externalizable. Do not hardcode or commit credentials,
  tokens, or other secrets; use environment-backed configuration.
- Keep changes focused, preserve existing behavior, and surface errors instead
  of silently swallowing them.

## Tests and verification

Run commands from `src/main/task-management-system` using `sh ./mvnw`:

- `sh ./mvnw test` for unit and Quarkus tests.
- `sh ./mvnw verify` when integration-test coverage is relevant.
- `sh ./mvnw spotless:check` for Java formatting.

Add focused tests for behavior introduced or fixed. Prefer resource or
integration tests for HTTP and persistence behavior, and unit tests for
isolated business logic.