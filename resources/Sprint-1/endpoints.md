# Endpoints

### **Entidades**
* User
* Personaje
* Carta
* Baraja

---
### **Peticiones**
Las distintas peticiones se realizan de la siguiente manera

* **GET**
  * ip:puerto/entidad/{id}
* **POST**
  * ip:puerto/entidad/
    * body: Objeto de la entidad
* **PUT**
  * ip:puerto/entidad/{id}
    * body: Objeto de la entidad
* **DELETE**
  * ip:puerto/entidad/{id}

---
### **Ejemplos**

* **POST USER**

**localhost:8080/user/**
```json 
  {
	"nombre": "ruben",
	"email": "rudahee@gmail.com",
	"nick": "rudahee",
	"pass": "contraseñainsegura",
	"fechaCreacion": null,
	"edad": 24,
	"personaje": null
}
```

* **GET CARTA**

**localhost:8080/carta/123**

* **PUT PERSONAJE**

**localhost:8080/personaje/321**
```json
{
	"nickname": "rudaheeModificado",
	"vida": 8,
	"daño": 8,
	"energia": 2,
	"vivo": false
}
```
* **DELETE BARAJA**

**localhost:8080/baraja/14**