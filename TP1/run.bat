rem java -jar C:\webservices\resttp1\target\rest-0.0.1-SNAPSHOT.jar

rem pour configurer démarrer Tomcat au port 9090
rem java -jar C:\webservices\resttp1\target\rest-0.0.1-SNAPSHOT.jar --server.port=5555

rem pour lancer l'application avec un fichier de configuration externe.
rem java -jar -Dspring.config.location=C:\webservices\application-prod.properties C:\webservices\resttp1\target\rest-0.0.1-SNAPSHOT.jar


rem Spring Boot Active Profile (flag : --spring.profiles.active):

rem pour lancer l'application avec le profile prod
rem java -jar C:\webservices\resttp1\target\rest-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod

rem pour lancer l'application avec le profile dev
java -jar "C:\Users\toshiba satellite\Desktop\TP1-0.0.1-SNAPSHOT.jar" --spring.profiles.active=prod
java -jar "C:\Users\toshiba satellite\Desktop\TP1-0.0.1-SNAPSHOT.jar" --spring.profiles.active=dev
java -jar "C:\Users\toshiba satellite\Desktop\TP1-0.0.1-SNAPSHOT.jar" --spring.profiles.active=integration