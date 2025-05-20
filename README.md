
# 😂 Dad Jokes App

A web application that displays random dad jokes. Built with Angular (Frontend) and Spring Boot (Backend), with Docker support.

---

##  Setup

###  Quick Start

> You need to have **Docker** and **Docker Compose** installed.

1. In the project root folder, run:

```bash
docker-compose up --build
````

2. After starting:

   *  **Angular App**: [http://localhost:4200](http://localhost:4200)
   *  **Spring Boot API**: [http://localhost:8080/api/jokes](http://localhost:8080/api/jokes)

---

###  Manual Start

####  Backend (Spring Boot)

```bash
cd dad-jokes-app-spring
./mvnw spring-boot:run
```

####  Frontend (Angular)

```bash
cd dad-jokes-app-angular
npm install
ng serve
```

---

##  API

### `GET /api/jokes`

Returns a random joke:

```json
{
  "id": 0,
  "text": "Why don't scientists trust atoms? Because they make up everything!"
}
```

---

### `GET /api/jokes?count=9`

Returns multiple jokes:

```json
{
  "0": "Did you hear the one about the guy with the broken hearing aid? Neither did he.",
  "1": "Why do fish live in salt water? Because pepper makes them sneeze!",
  "2": "People are making apocalypse jokes like there’s no tomorrow.",
  "3": "Did you know Albert Einstein was a real person? All this time, I thought he was just a theoretical physicist!",
  "4": "It's only a murder of crows if there's probable caws.",
  "5": "If at first you don't succeed, sky diving is not for you!",
  "6": "Did you hear that the police have a warrant out on a midget psychic ripping people off? It reads “Small medium at large.”",
  "7": "Where was the Declaration of Independence signed? At the bottom!",
  "8": "Sgt.: Commissar! Commissar! The troops are revolting! Commissar: Well, you’re pretty repulsive yourself."
}
```

---

##  Requirements

| Technology | Version    |
| ---------- | ---------- |
| Node.js    | `v22.13.1` |
| npm        | `v8.8.0`   |
| Java       | `v23.0.1`  |


