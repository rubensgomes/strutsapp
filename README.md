# strutsapp
A basic Kotlin Spring - Struts - JSP web application.

## Import Local Repo to GitHub

```shell
PROJ="strutsapp"
git init -b main
git add .
git commit -m "initial commit" -a
gh repo create --homepage "https://github.com/rubensgomes" --private "${PROJ}"
git remote add origin "https://github.com/rubensgomes/${PROJ}"
git push -u origin main
```

Then, go to the [repo](https://github.com/rubensgomes/ex-lib) and create
a `release` branch. Click on the `drop-down` to `View all branches` and click
on the `New branch` button.

## Display Java Tools Installed

```shell
./gradlew -q javaToolchains
```

## Clean, Lint, Test, Assemble, Release

### To clean local build

```shell
./gradlew --info clean
```

### To run static analysis

```shell
./gradlew :app:spotlessApply
```

### To run unit tests

```shell
./gradlew --info check
```

### To create a Spring Boot executable jar

```shell
./gradlew --info bootJar
```

### To run the Spring Boot application

```shell
./gradlew --info bootRun
```

### To create a realease (only Rubens Gomes)

```shell
./gradlew --info release
```
