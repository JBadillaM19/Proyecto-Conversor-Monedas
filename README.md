# 💰 Conversor de Monedas en Tiempo Real (Java/Gson)

![Fecha](https://img.shields.io/badge/Release%20date-December2025-yellow)
![Completado](https://img.shields.io/badge/Status-Completado-brightgreen)
![Java](https://camo.githubusercontent.com/ecb63034589ecbb5e0ab00e05b247bb2e875b422b2656fa65c1954142ec5ff63/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a6176612d4544384230303f7374796c653d666c6174266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465)
![Gson](https://img.shields.io/badge/Gson-4285F4?style=for-the-badge&logo=google&logoColor=white)
![Static Badge](https://img.shields.io/badge/License-MIT-orange)


Este proyecto es una aplicación de consola desarrollada en **Java** para realizar conversiones de moneda en tiempo real, utilizando una arquitectura modular y obteniendo tasas de cambio desde una API.

---

## 🚀 1. Características Principales

* **Llamada Bajo Demanda (Eficiencia):** Solo se realiza una llamada a la API por cada conversión solicitada por el usuario.
* **Cálculo Delegado:** El valor final de la conversión es provisto directamente por la respuesta JSON de la API (`conversion_result`), simplificando la lógica interna, sin embargo en el proyecto hay una clase no usada (CalculoMoneda) en caso de que se quiera configurar para realizar los calculos de forma local.
* **Manejo de Errores Robusto:** Implementación de manejo de excepciones para fallos de conexión, interrupciones y errores reportados por la API.

---

## ⚙️ 2. Tecnologías y Librerías

| Componente | Tecnología | Propósito |
| :--- | :--- | :--- |
| **Lenguaje** | Java (JDK 17+) | Lenguaje de desarrollo principal. |
| **HTTP** | `java.net.http.HttpClient` | Módulo nativo de Java para realizar las solicitudes HTTP. |
| **JSON** | [Google Gson](https://github.com/google/gson) | Librería utilizada para mapear automáticamente las respuestas JSON a objetos Java (`ResultadoConversion`). |
| **API de Datos** | ExchangeRate-API | Fuente de datos para las tasas de cambio en tiempo real. |

---

## 📐 3. Arquitectura del Proyecto y Modularidad

El proyecto sigue el principio de **Responsabilidad Única (SRP)**.

| Clase / Componente | Responsabilidad Principal | Nota Importante |
| :--- | :--- | :--- |
| **`Principal.java`** | **Interfaz de Usuario (UI) y Orquestación:** Gestiona el menú, solicita datos y delega la llamada al servicio. | Controla el flujo completo del programa. |
| **`ConsultaApi.java`** | **Acceso a Datos (Servicio):** Construye la URL, realiza la solicitud HTTP, y mapea la respuesta JSON. | Contiene la API Key incrustada para funcionalidad inmediata. |
| **`ResultadoConversion.java`** | **Modelo de Datos (Record):** Modela la respuesta JSON. | Almacena el resultado, la tasa y el estado (`result`). |
| **`CalculadoraDeMoneda.java`** | **Lógica de Cálculo:** Métodos estáticos para conversiones. | **Clase de Respaldo (Inactiva):** Se mantiene para permitir una migración futura si los cálculos debieran realizarse localmente. |

---

## ⚠️ 4. Nota de la API Key y Desafío Práctico

Este proyecto se ha configurado para ser **fácilmente usable** sin configuración adicional:

* **Clave Pública:** La clave API necesaria para las consultas está **incrustada directamente** en la clase `ConsultaApi.java`.
* **Desafío Adicional (Práctica de Seguridad):** Si deseas llevar este proyecto al siguiente nivel de robustez, se recomienda fuertemente **externalizar la clave API** del código fuente. Esto se puede lograr utilizando variables de entorno (`System.getenv()`) o archivos de propiedades (`.properties`).

---

## 5. Conversiones Soportadas

El conversor ofrece un menú interactivo con 6 opciones de conversión, centradas en el **Dólar Estadounidense (USD)**.

| Opción | Conversión |
| :--- | :--- |
| **1** | Dólar Estadounidense (USD) ==> Colón (CRC) |
| **2** | Colón (CRC) ==> Dólar Estadounidense (USD) |
| **3** | Dólar Estadounidense (USD) ==> Real brasileño (BRL) |
| **4** | Real brasileño (BRL) ==> Dólar Estadounidense (USD) |
| **5** | Dólar Estadounidense (USD) ==> Peso mexicano (MXN) |
| **6** | Peso mexicano (MXN) ==> Dólar Estadounidense (USD) |

---

## 🛠️ 6. Configuración y Ejecución

1.  Asegúrate de tener **JDK 17+** y la librería **Gson** configurada como dependencia externa.
2.  Ejecuta la clase principal `Principal.java`.
3.  El programa se inicia inmediatamente y presenta el menú en la consola.

---

## 📝 7. Contribuciones

Este proyecto fue desarrollado como parte de un desafío de programación. Si encuentras un error o tienes sugerencias de mejora, ¡no dudes en abrir un *issue*!

## Autor ✍🏼

**JOSUÉ BADILLA MADRIGAL**
