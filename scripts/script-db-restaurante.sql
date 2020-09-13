-- Database Motor: postgresql

-- 1- Create database: restaurante

-- 2- Script to run:

DROP TABLE IF EXISTS public.detalles_facturas;
DROP TABLE IF EXISTS public.facturas;
DROP TABLE IF EXISTS public.clientes;
DROP TABLE IF EXISTS public.mesas;
DROP TABLE IF EXISTS public.camareros;
DROP TABLE IF EXISTS public.cocineros;

-- Create Table: public.clientes
CREATE TABLE public.clientes
(
    id_cliente character varying NOT NULL,
    nombre character varying NOT NULL,
    apellido1 character varying NOT NULL,
    apellido2 character varying,
    observaciones character varying,
    PRIMARY KEY (id_cliente)
);

-- Create Table: public.mesas
CREATE TABLE public.mesas
(
    id_mesa Integer NOT NULL,
    num_max_comensa Integer,
    ubicacion character varying,
    PRIMARY KEY (id_mesa)
);

-- Create Table: public.camareros
CREATE TABLE public.camareros
(
    id_camarero character varying NOT NULL,
    nombre character varying NOT NULL,
    apellido1 character varying NOT NULL,
    apellido2 character varying,
    PRIMARY KEY (id_camarero)
);

-- Create Table: public.cocineros
CREATE TABLE public.cocineros
(
    id_cocinero character varying NOT NULL,
    nombre character varying NOT NULL,
    apellido1 character varying NOT NULL,
    apellido2 character varying,
    PRIMARY KEY (id_cocinero)
);

-- Create Table: public.facturas
CREATE TABLE public.facturas
(
    id_factura Integer NOT NULL,
    fk_id_cliente character varying NOT NULL,
    fk_id_camarero character varying NOT NULL,
    fk_id_mesa Integer NOT NULL,
    fecha_factura timestamp DEFAULT current_timestamp,
    PRIMARY KEY (id_factura),
    FOREIGN KEY (fk_id_cliente) REFERENCES public.clientes (id_cliente),
    FOREIGN KEY (fk_id_camarero) REFERENCES public.camareros (id_camarero),
    FOREIGN KEY (fk_id_mesa) REFERENCES public.mesas (id_mesa)
);

-- Create Table: public.detalles_facturas
CREATE TABLE public.detalles_facturas
(
    id_detalle_factura Integer NOT NULL,
    fk_id_factura Integer NOT NULL,
    fk_id_cocinero character varying NOT NULL,
    plato character varying NOT NULL,
    importe decimal(20,2) NOT NULL,
    PRIMARY KEY (id_detalle_factura),
    FOREIGN KEY (fk_id_factura) REFERENCES public.facturas (id_factura),
    FOREIGN KEY (fk_id_cocinero) REFERENCES public.cocineros (id_cocinero)
);

-- :::::::::::::::::::::::::::::::::::::::::::::::::::::
-- :::::::::::::::::::INSERCIONES:::::::::::::::::::::::

-- CLIENTES
DELETE FROM public.clientes WHERE id_cliente='111';
DELETE FROM public.clientes WHERE id_cliente='222';
DELETE FROM public.clientes WHERE id_cliente='333';
DELETE FROM public.clientes WHERE id_cliente='444';

INSERT INTO public.clientes (id_cliente, nombre, apellido1, apellido2) VALUES 
	('111', 'Pedro', 'Galindo', 'Salcedo'),
	('222', 'Camilo', 'Solano', 'Pérez'),
	('333', 'Sandra', 'Pereira', 'Rodríguez'),
	('444', 'Ana', 'Londoño', 'Cifuente');


-- MESAS
DELETE FROM public.mesas WHERE id_mesa=1;
DELETE FROM public.mesas WHERE id_mesa=2;
DELETE FROM public.mesas WHERE id_mesa=3;

INSERT INTO public.mesas (id_mesa, num_max_comensa, ubicacion) VALUES 
	(1, 5, 'SUR'),
	(2, 5, 'NORTE'),
	(3, 6, 'NORESTE');

-- CAMAREROS
DELETE FROM public.camareros WHERE id_camarero='555';
DELETE FROM public.camareros WHERE id_camarero='666';
DELETE FROM public.camareros WHERE id_camarero='777';
DELETE FROM public.camareros WHERE id_camarero='888';
DELETE FROM public.camareros WHERE id_camarero='999';

INSERT INTO public.camareros (id_camarero, nombre, apellido1) VALUES 
	('555', 'Juan', 'Mora'),
	('666', 'Javier', 'Coronado'),
	('777', 'David', 'Largo'),
	('888', 'Diego', 'Monsalve'),
	('999', 'Jorge', 'Ruíz');

-- COCINEROS
DELETE FROM public.cocineros WHERE id_cocinero='1010';
DELETE FROM public.cocineros WHERE id_cocinero='1111';

INSERT INTO public.cocineros (id_cocinero, nombre, apellido1) VALUES 
	('1212', 'Isabel', 'Oviedo'),
	('1313', 'Carlos', 'Durango');