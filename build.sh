docker run -it --rm --name maven -v "$(pwd)":/usr/src/app -v maven-repo:/usr/share/maven/ref -w /usr/src/app maven:3.5.4-jdk-8-alpine mvn clean install