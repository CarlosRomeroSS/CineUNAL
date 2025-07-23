🎬 CineUNAL

CineUNAL es un proyecto de Programación Orientada a Objetos (POO) que simula un sistema de gestión y reservas para un cine universitario. Permite administrar películas, salas, funciones, clientes y reservas, generando boletos digitales con una interfaz gráfica amigable.
✨ Características

🎞️ Gestión de películas: Agrega, consulta y administra películas disponibles.

🏟️ Gestión de salas: Configura salas con diferentes tipos y capacidades.

📅 Gestión de funciones: Programa funciones para cada película y sala.

🎟️ Reservas: Permite a los clientes seleccionar asientos y reservar entradas.

-📄 Boleto digital: Genera un boleto digital en formato texto con QR simulado.

## Estructura del Proyecto
CineApp/
├── README.md
├── src/
│   └── main/
│       └── java/
│           ├── model/
│           │   ├── Administrador.java
│           │   ├── Pelicula.java
│           │   ├── Sala.java
│           │   ├── Funcion.java
│           │   ├── Cliente.java
│           │   ├── Reserva.java
│           │   ├── BoletoDigital.java
│           │   └── enums/
│           │       ├── SalaTipo.java
│           │       └── ClienteTipo.java
│           ├── GUI/
│           │   ├── VentanaInicio.java
│           │   ├── VentanaSeleccion.java
│           │   └── VentanaReservar.java
│           └── Main.java
└── .gitignore
