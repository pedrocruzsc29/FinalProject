📚 Sistema de Gestión de Biblioteca
<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-En%20Desarrollo-yellow?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

**Proyecto Integrador - Estructuras de Datos 2025**  
*Ingeniería Informática - Universidad Nacional de Jujuy*

</div>
📋 Descripción del Proyecto
Sistema integral de gestión bibliotecaria desarrollado en Java que implementa múltiples estructuras de datos para optimizar las operaciones diarias de una biblioteca. El proyecto integra arreglos, árboles binarios de búsqueda, pilas, colas y listas enlazadas para proporcionar un manejo eficiente de libros, usuarios y operaciones.
🎯 Características Principales

📖 Gestión Completa de Libros

Registro con validación de códigos únicos
Búsqueda rápida por código mediante árbol binario (O(log n))
Búsqueda por autor usando subcadenas
Control de disponibilidad en tiempo real


👥 Administración de Usuarios

Registro con número de usuario único
Seguimiento de préstamos activos por usuario
Consultas personalizadas según actividad


🔄 Sistema de Operaciones

Préstamos y devoluciones con validación completa
Historial de acciones con funcionalidad "deshacer" (pila)
⏳ Cola de Espera Inteligente

Gestión FIFO para libros no disponibles
Sistema justo de asignación de recursos
Notificaciones de disponibilidad


🔍 Consultas Avanzadas

Listado completo del catálogo
Búsqueda de libros por autor (coincidencia parcial)
Usuarios con mayor cantidad de préstamos
Cálculo del valor total de libros en circulación
🛠️ Métodos Implementados
📚 Gestión de Libros
java// Operaciones principales
✅ registrarLibro()              // Agregar libro al sistema (arreglo + árbol)
✅ buscarLibroPorCodigo()        // Búsqueda eficiente usando árbol binario
✅ listarTodosLosLibros()        // Mostrar catálogo completo
✅ buscarLibrosPorAutor()        // Búsqueda por subcadena → Lista enlazada
✅ calcularMontoLibrosPrestados() // Suma del precio de libros en préstamo
👤 Gestión de Usuarios
java// Operaciones principales
✅ registrarUsuario()            // Agregar usuario al sistema
✅ buscarUsuarioPorNumero()      // Localizar usuario específico
✅ listarTodosLosUsuarios()      // Mostrar todos los usuarios registrados
✅ listarUsuariosConMasLibros()  // Usuarios con ≥ X préstamos → Lista enlazada
🔄 Operaciones de Préstamo
java// Transacciones
✅ realizarPrestamo()            // Préstamo con validación y registro en pila
✅ realizarDevolucion()          // Devolución con actualización de estado
✅ deshacerUltimaOperacion()     // Reversión usando pila de acciones
✅ atenderPendiente()            // Procesar usuario de cola de espera
📊 Consultas y Reportes
// Análisis del sistema
✅ mostrarCatalogo()             // Vista detallada de todos los libros
✅ mostrarUsuarios()             // Vista detallada de todos los usuarios
✅ generarReportePrestamos()     // Estadísticas de préstamos activos
✅ consultarColaPendientes()     // Estado de la cola de espera
```

---

## 💻 Tecnologías Utilizadas

- **Lenguaje:** Java SE 17+
- **Estructuras:** Implementaciones nativas (sin ArrayList/HashMap)
- **Paradigma:** Programación Orientada a Objetos
- **Validaciones:** Manejo robusto de excepciones
- **Interfaz:** Menú interactivo por consola con colores ANSI

---

## 📦 Estructura del Proyecto
```
biblioteca-sistema/
│
├── src/
│   ├── modelo/
│   │   ├── Libro.java
│   │   ├── Usuario.java
│   │   └── Operacion.java
│   │
│   ├── estructura/
│   │   ├── ArbolBinario.java
│   │   ├── Pila.java
│   │   ├── Cola.java
│   │   └── ListaEnlazada.java
│   │
│   ├── servicio/
│   │   ├── GestionLibros.java
│   │   ├── GestionUsuarios.java
│   │   └── GestionOperaciones.java
│   │
│   ├── utilidad/
│   │   └── Validaciones.java
│   │
│   └── Main.java
│
└── README.md

🚀 Cómo Ejecutar
bash# Clonar el repositorio
git clone https://github.com/tu-usuario/sistema-biblioteca.git

# Navegar al directorio
cd sistema-biblioteca/src

# Compilar
javac Main.java

# Ejecutar
java Main


👥 Equipo de Desarrollo

Integrante 1 - Jorge Yamil Cazon
Integrante 2 - Pedro Cruz
Integrante 3 - Leonardo Carrillo

📝 Requisitos del Sistema

✅ JDK 17 o superior
✅ Terminal con soporte ANSI (para colores)
✅ 50 MB de espacio en disco

🎓 Contexto Académico
Este proyecto fue desarrollado como parte del Proyecto Integrador de la materia Estructuras de Datos del 2do Cuatrimestre 2025, correspondiente a las carreras de Ingeniería Informática y Licenciatura en Sistemas de la Facultad de Ingeniería - Universidad Nacional de Jujuy.
Objetivo: Aplicar e integrar conocimientos sobre estructuras de datos fundamentales (arreglos, pilas, colas, listas enlazadas y árboles) en un caso de estudio real.

📄 Licencia
Este proyecto está bajo la Licencia MIT - ver el archivo LICENSE para más detalles.

<div align="center">
Hecho con ❤️ y ☕ por estudiantes de Ingeniería Informática
⭐ Si te gustó el proyecto, dale una estrella en GitHub!
</div>
