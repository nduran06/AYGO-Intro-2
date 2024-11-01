FROM openjdk:17
WORKDIR /usrapp/bin
ENV PORT=8090
COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency
CMD ["java","-cp","./classes:./dependency/*","com.docker.intro.IntroApplication"]