https://github.com/Lopeez29/Alvaro-Lopez-Practica-2-POO.git

Álvaro López Díaz

# **Gestión de Electrónica**

## **Descripción del Proyecto**
Esta aplicación desarrollada en Java es una aplicación de consola desarrollada en **Java** para la gestión de una base de datos de **marcas** y **artículos electrónicos** (móviles y televisores). La aplicación implementa un **patrón Singleton** para garantizar una única instancia de la base de datos local, utilizando un `HashMap` para almacenar los datos. El usuario interactúa con la aplicación mediante un menú dinámico que proporciona opciones específicas.

---

## **Funcionalidades Principales**

### **1. Añadir Marca**
- Permite al usuario introducir los siguientes datos:
    - **Nombre de la marca**
    - **País de origen**
    - **Facturación**
- La marca se añade a la base de datos si no existe. Si ya existe, se muestra un mensaje de error.

---

### **2. Añadir Televisor**
- El usuario introduce el **nombre de la marca** a la que pertenece el televisor.
- Si la marca existe, se solicitan los siguientes datos del televisor:
    - **Nombre del televisor**
    - **Precio**
    - **Pulgadas** (tamaño de pantalla)
    - **Tipo de pantalla** (LED, QLED, OLED, QNED)
- El televisor se añade a la base de datos.

---

### **3. Añadir Móvil**
- El usuario introduce el **nombre de la marca** a la que pertenece el móvil.
- Si la marca existe, se solicitan los siguientes datos del móvil:
    - **Nombre del móvil**
    - **Precio**
    - **RAM (en GB)**
    - **Sistema Operativo** (ANDROID, IOS)
- El móvil se añade a la base de datos.

---

### **4. Buscar Marca**
- El usuario introduce el **nombre de la marca**.
- Si la marca existe, se muestran sus detalles:
    - **Nombre**
    - **País**
    - **Facturación**
- Si no existe, se muestra un mensaje de error.

---

### **5. Buscar Televisor**
- El usuario introduce el **tipo de pantalla** (LED, QLED, OLED, QNED).
- Se muestran los televisores que coincidan con ese tipo de pantalla.

---

### **6. Buscar Móvil**
- El usuario introduce el **sistema operativo** (ANDROID, IOS).
- Se muestran los móviles que coincidan con ese sistema operativo.

---

### **7. Listar Marcas**
- Se muestran todas las marcas almacenadas, ordenadas **por facturación en orden descendente**.

---

### **8. Listar Artículos**
- Se muestran todos los artículos electrónicos almacenados, ordenados por:
    - **Marca**
    - **Precio**
    - **Nombre**

---

### **9. Salir**
- Finaliza la ejecución del programa.



