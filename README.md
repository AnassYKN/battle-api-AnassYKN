# Battle API Anass Yakine

# Lancement

```
mvn clean install && mvn spring-boot:run
```
port de l'application en local : http://localhost:8084 <br/>

# Routes

GET    : /battles/         :https://battle-api-anassykn.herokuapp.com/battles/<br/>
POST   : /battles/?trainer=''&opponent='':https://battle-api-anassykn.herokuapp.com/battles/?trainer=Ash&opponent=Misty<br/>
POST   : /battles/{UUID}/{trainerName}:https://trainer-api-anassykn.herokuapp.com/trainers/Bug%20Catcher<br/>

# Déploiment

l'application est déployé sur l'adresse suivante : https://battle-api-anassykn.herokuapp.com/

# Swagger 

liste des routes est disponible sur le l'adresse suivante :https://battle-api-anassykn.herokuapp.com/swagger-ui.html#/

# PostMan

Battle-api.postman_collection.json pour testé les routes de l'api 

Battle-api-AnassYKN created by Anass Yakine
