# Endpoints

## **Entidades**

* ### **User**
* ### **Personaje**


---

## User

* **[POST]** Register
  * localhost:8080/user
    * body
```json
{
	"nombre": "nombre",
	"email": "email@example.com",
	"username": "nombre",
	"password": "nombre",
	"edad": 1234
}
```
> return USER

* **[GET]** Login
  * locahost:8080/user
    * params
```sh
# username, password
localhost:8080/user?username=[username]&password=[password]
```
> return JWT, ID
---
## Personaje

* **[PUT]** Crear Partida
  * localhost:8080/personaje/{id}
    * token: Bearer
    * body
```json
{
}
```
> return PARTIDA

* **[PUT]** Unirse Partida
  * localhost:8080/personaje/{id}
    * token: Bearer
    * body
```json
{
    "token": "token"
}
```
> return PARTIDA

* **[PUT]** Set Listo
  * localhost:8080/personaje/{id}
    * token: Bearer
    * body
```json
{
    "token": "token",
    "listo": true
}
```
> return PARTIDA

* **[GET]** Get Partida
  * localhost:8080/personaje/{id}
    * token: Bearer
    * params
```sh
# token
locahost:8080/personaje/{id}?token={token}
```
> return PARTIDA

* **[POST]** Iniciar Partida
  * localhost:8080/personaje/{id}/start/
    * token: Bearer
    * body
```sh
# token
locahost:8080/personaje/{id}/start/?token={token}
```
> return BOOLEAN (true == partida iniciada)
