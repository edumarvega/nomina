# Nominas
Aplicacion web para consultar nominas de escribanos publicos de CABA.               
REQUERIMIENTO: tener instaladas y configuradas en la pc la version de java jdk 11, maven 3 y git   

PASO 1: en la pc crear una carpeta que se llame Colegio de escribanos
![image](https://user-images.githubusercontent.com/6340170/139832348-11c8159f-be7d-4653-894e-3c865ed39f07.png)

PASO 2: con git bash situarse dentre de la carpeta: C:\Colegio de escribanos
![image](https://user-images.githubusercontent.com/6340170/139832532-f689e85b-b9b4-440c-81c5-78d6be6708c9.png)

PASO 3: bajarse el proyecto desde git con el siguiente comando:
git clone https://github.com/edumarvega/nomina.git
![image](https://user-images.githubusercontent.com/6340170/139832785-50046726-30e9-4128-823c-25212a45e688.png)
![image](https://user-images.githubusercontent.com/6340170/139832978-49521f51-5eaf-40b9-98c1-e1b020f52f33.png)


PASO 4:Con git bash Ingresar a C:\Colegio de escribanos\nomina, pararse sobre el master con el siguiente comando:
![image](https://user-images.githubusercontent.com/6340170/139833398-d4afc281-8f07-4a9b-89e3-f33e182e9800.png)
git checkout master
![image](https://user-images.githubusercontent.com/6340170/139833520-0b5a7000-fad9-4d8e-bbde-e13d72080aa4.png)

PASO 5: Con el interprete de comandos de windows siturarse dentro de esta carpeta 
cd C:\Colegio de escribanos\nomina
![image](https://user-images.githubusercontent.com/6340170/139833768-131f5074-ac87-47ec-b0b4-e095048c0723.png)

PASO 6: Ejecutar el siguiente comando maven: mvn clean install
![image](https://user-images.githubusercontent.com/6340170/139834029-53c23bbd-678f-4ead-ad7b-a6230b7e29a5.png)
![image](https://user-images.githubusercontent.com/6340170/139834182-835df8fc-3bc2-42bd-b36e-066674b3c542.png)

PASO 7: El war nomina-0.0.1-SNAPSHOT.war que se genero con el anterior comando quedo en el siguiente path:
C:\Colegio de escribanos\nomina\target con el interprete de comando situarse dentro de esa carpeta.
cd C:\Colegio de escribanos\nomina\target
![image](https://user-images.githubusercontent.com/6340170/139834504-17383fdd-dd0b-4e83-af5c-1add39238e9e.png)

PASO 8: Levantar el war con el siguiente comando:
java -jar nomina-0.0.1-SNAPSHOT.war
![image](https://user-images.githubusercontent.com/6340170/139834691-19adc3fc-6abe-4638-a009-2c708cf9f498.png)

PASO 9: Una vez levantado el sevidor tomcat embebido sobre el puerto 8080, ingresar en cualquier navegador lo siguiente:
http://localhost:8080
![image](https://user-images.githubusercontent.com/6340170/139835124-ea1c8544-9ef3-4b99-8e6d-cd952c50a441.png)
Al ingresar por primera vez se mostrara un mensaje de advertencia solicitando que genere el token que es requerido para consultar las nominas de escribanos, para ello hay que hacer click en el link arriba a la derecha de la pantalla que dice [Configurar token]






