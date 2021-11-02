# Nominas
Aplicacion web para consultar nominas de escribanos publicos de CABA.               
REQUERIMIENTO: tener instaladas y configuradas en la pc la version de java jdk 11, maven 3 y git   

# PASO 1: en la pc crear una carpeta que se llame Colegio de escribanos
![image](https://user-images.githubusercontent.com/6340170/139846899-6d7114c2-7f03-4c60-85ed-a24ced59123a.png)


# PASO 2: con git bash situarse dentre de la carpeta: C:\Colegio de escribanos
![image](https://user-images.githubusercontent.com/6340170/139832532-f689e85b-b9b4-440c-81c5-78d6be6708c9.png)


# PASO 3: bajarse el proyecto desde git con el siguiente comando:
git clone https://github.com/edumarvega/nomina.git

![image](https://user-images.githubusercontent.com/6340170/139832785-50046726-30e9-4128-823c-25212a45e688.png)
![image](https://user-images.githubusercontent.com/6340170/139832978-49521f51-5eaf-40b9-98c1-e1b020f52f33.png)


# PASO 4:Con git bash Ingresar a C:\Colegio de escribanos\nomina, pararse sobre el master con el siguiente comando:
git checkout master

![image](https://user-images.githubusercontent.com/6340170/139833398-d4afc281-8f07-4a9b-89e3-f33e182e9800.png)
![image](https://user-images.githubusercontent.com/6340170/139833520-0b5a7000-fad9-4d8e-bbde-e13d72080aa4.png)

# PASO 5: Con el interprete de comandos de windows siturarse dentro de esta carpeta 
cd C:\Colegio de escribanos\nomina

![image](https://user-images.githubusercontent.com/6340170/139833768-131f5074-ac87-47ec-b0b4-e095048c0723.png)

# PASO 6: Ejecutar el siguiente comando maven: mvn clean install

![image](https://user-images.githubusercontent.com/6340170/139834029-53c23bbd-678f-4ead-ad7b-a6230b7e29a5.png)
![image](https://user-images.githubusercontent.com/6340170/139834182-835df8fc-3bc2-42bd-b36e-066674b3c542.png)

# PASO 7: El war nomina-0.0.1-SNAPSHOT.war que se genero con el anterior comando quedo en el siguiente path:
C:\Colegio de escribanos\nomina\target con el interprete de comando situarse dentro de esa carpeta.
cd C:\Colegio de escribanos\nomina\target

![image](https://user-images.githubusercontent.com/6340170/139834504-17383fdd-dd0b-4e83-af5c-1add39238e9e.png)

# PASO 8: Levantar el war con el siguiente comando:
java -jar nomina-0.0.1-SNAPSHOT.war

![image](https://user-images.githubusercontent.com/6340170/139834691-19adc3fc-6abe-4638-a009-2c708cf9f498.png)

# PASO 9: Una vez levantado el sevidor tomcat embebido sobre el puerto 8080

![image](https://user-images.githubusercontent.com/6340170/139835124-ea1c8544-9ef3-4b99-8e6d-cd952c50a441.png)

Ingresar en cualquier navegador lo siguiente:
http://localhost:8080
Al ingresar por primera vez se mostrara un mensaje de advertencia solicitando que configure un token, (hay que generar un token en el PASO 10) que es requerido para consultar las nominas de escribanos, para ello hay que hacer click el botón Configurar token.

![image](https://user-images.githubusercontent.com/6340170/139837375-962bcf92-768d-4f5f-826e-17aa726fa0a7.png)

# PASO 10: genear un token en https://codepen.io/sergio__/pen/NZzYNb?editors=001 con estos datos:
var data = {
    "iss": "candidato-MlDG",
    "iat": now / 1000,
    "exp": (now.getTime() + 2*60000) / 1000,
    "aud": "nomina-escribanos-ws",
    "sub": "examen-tecnico",
    "role": [ "EXTERNOS" ]
}; 

var secret = "MlDGaOysFvHEUYh6qlGRXdAfqxCjwHskKewN";

![image](https://user-images.githubusercontent.com/6340170/139837701-a131230e-6bac-4045-a7b2-3e7a45b893e5.png)
![image](https://user-images.githubusercontent.com/6340170/139837782-6915c79a-1fad-4977-91df-a5e2a188ca81.png)

# PASO 11: Con ese token generado ingresarlo en el campo token y Volver a la pantalla de consulta de cuit e ingresar el siguiente cuil para la prueba 20-26157300-9:

![image](https://user-images.githubusercontent.com/6340170/139837872-139ef52d-3b5c-4ded-be9e-72689c19d7fb.png)
![image](https://user-images.githubusercontent.com/6340170/139838101-b449bb1a-3cc7-4a66-8946-0601ce5ce0be.png)









