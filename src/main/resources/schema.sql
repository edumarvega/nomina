DROP TABLE IF EXISTS CONFIGURACION;  
CREATE TABLE CONFIGURACION (  
	ID INT AUTO_INCREMENT  PRIMARY KEY,  
	URL VARCHAR(256) NOT NULL,  
	TOKEN VARCHAR(500) NULL
 ); 