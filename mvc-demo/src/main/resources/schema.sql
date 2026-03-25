/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Gabriela
 * Created: 2/10/2025
 */
-- schema.sql para MySQL
DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    email VARCHAR(250) UNIQUE NOT NULL,
    position VARCHAR(250) NOT NULL,
    salary DOUBLE NOT NULL,
    id_departamento INT NULL  -- Para futura expansión
   
);