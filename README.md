# strutsapp
A basic Kotlin Spring - Struts - JSP web application.

- Requires Java LTS 21 or greater.

## Display Java Tools Installed

```shell
./gradlew -q javaToolchains
```

## Clean, Lint, Test, Assemble, Release

```shell
./gradlew --info clean
```

```shell
./gradlew :app:spotlessApply
```

```shell
./gradlew --info check
```

```shell
./gradlew --info assemble
```

```shell
# To create a Spring Boot executable war
./gradlew --info bootWar
```

```shell
# only Rubens can push new releases
./gradlew --info release
```

### To run the Spring Boot webapp from IntelliJ

ATTENTION: You must select the Gradle task:
- `strutsapp > Tasks > application > bootRun`

### To run the Spring Boot webapp from the CLI

```shell
./gradlew --info bootRun
```

### To render the `Hello StrutsApp!` page

```http request
http://localhost:8080/index.do
```

