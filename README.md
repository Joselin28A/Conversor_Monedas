# **Conversor de Monedas**

Este es un programa en Java que permite realizar conversiones entre diferentes monedas utilizando la API de **ExchangeRate-API**. El programa es interactivo, presenta un menú para seleccionar opciones de conversión y registra un historial de las conversiones realizadas en un archivo JSON.

## **Características**

- Conversión entre las siguientes monedas:
  - **Dólar (USD)** y **Peso Argentino (ARS)**
  - **Dólar (USD)** y **Real Brasileño (BRL)**
  - **Dólar (USD)** y **Peso Colombiano (COP)**
- Interfaz interactiva para el usuario.
- Historial de conversiones almacenado en un archivo `conversion_history.json`.
- Conexión con la API de **ExchangeRate-API** para obtener las tasas de cambio actualizadas.
- Uso de estructuras modernas de Java como `records`, `HttpClient`, y JSON con `Gson`.

---

## **Requisitos previos**

- **Java 17 o superior**
- Conexión a internet (para acceder a la API)
- Una clave de API válida de [ExchangeRate-API](https://www.exchangerate-api.com/)

---

## **Configuración**

1. Clona este repositorio o copia los archivos en tu proyecto local.
2. Asegúrate de tener **Gson** como dependencia. 
3. Reemplaza `YOUR_API_KEY` en la clase `ExchangeRateAPI` con tu clave de API personal obtenida desde [ExchangeRate-API](https://www.exchangerate-api.com/).

---

## **Ejecución**

1. Compila y ejecuta el programa en tu IDE favorito o desde la línea de comandos:
   ```bash
   javac Main.java
   java Main
   ```

2. Sigue las instrucciones en pantalla para realizar una conversión.

3. Puedes salir del programa seleccionando la opción "7" en el menú principal.

---

## **Estructura del proyecto**

- **Main.java**: Clase principal que gestiona la interacción con el usuario y controla el flujo del programa.
- **ExchangeRateAPI.java**: Clase para la conexión con la API de ExchangeRate-API y obtención de tasas de cambio.
- **ConversionResult.java**: Record que estructura los datos de cada conversión realizada.
- **ConversionHistory.java**: Clase que registra el historial de conversiones en un archivo JSON.

---

## **Historial**

El historial de conversiones se guarda en un archivo `conversion_history.json`. Ejemplo de entrada en el archivo:

```json
[
  {
    "fromCurrency": "USD",
    "toCurrency": "ARS",
    "amount": 100.0,
    "result": 35000.0,    
  }
]
```

---

## **Opciones de conversión**

El programa ofrece las siguientes opciones de conversión:

| Opción | Conversión                     |
|--------|--------------------------------|
| 1      | Dólar (USD) a Peso Argentino (ARS) |
| 2      | Peso Argentino (ARS) a Dólar (USD) |
| 3      | Dólar (USD) a Real Brasileño (BRL) |
| 4      | Real Brasileño (BRL) a Dólar (USD) |
| 5      | Dólar (USD) a Peso Colombiano (COP) |
| 6      | Peso Colombiano (COP) a Dólar (USD) |
| 7      | Salir                         |

---

## **Tecnologías utilizadas**

- **Java 17**
- **ExchangeRate-API** (para tasas de cambio)
- **Gson** (para manejar JSON)
- **HttpClient** (para las solicitudes HTTP)

---

