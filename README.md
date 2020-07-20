

# Ddangn Market - Notification API Server

<img src="https://miro.medium.com/max/700/1*InTRJNvyco3ZAjYdiKYmzw.jpeg" width="150">

- This app is for study Spring Boot and MSA.
- This app is Notification API Server.
- Visit ddangn.taesunny.com

## Using this app
- Use Notification APIs
- API List

| Endpoint | Description | Secured | Roles |
|--|--|:--:|--|
| POST /api/v1/notifications | App에 Notification 발송  | YES | ADMIN |

## How to build docker image
You can `image name`, by setting application.yml's app name variable
You can set `tag`, by setting application.yml's app version variable
##### Run command below
```
./gradlew clean jar dockerBuildImage
docker images # check the created image
```

## How to run docker with the created image

##### Run command below
```
docker run -d -p 8761:8761 -it {package path:docker image name}:{set tag used when docker image build}  
docker ps # check the running docker container
```

## Contacts

Taesun Lee - superbsun@gmail.com
