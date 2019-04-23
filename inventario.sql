-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 23-04-2019 a las 15:57:59
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: inventario
--
CREATE DATABASE IF NOT EXISTS inventario DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE inventario;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla bill
--

DROP TABLE IF EXISTS bill;
CREATE TABLE bill (
  id_bill bigint(20) NOT NULL,
  date date NOT NULL,
  id_client varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  id_seller varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

DROP TABLE IF EXISTS client;
CREATE TABLE `client` (
  Document varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  name_client varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  first_lastName_client varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  last_lastName_cliente varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  phone_client varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  email_client varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (Document, name_client, first_lastName_client, last_lastName_cliente, phone_client, email_client) VALUES
('105005465', 'kdjbvg', 'kljnbvkdjfh', 'jnb', '302152654', 'kjdsvbsdkj@fdskjvb.com'),
('1230651453', 'Eso', 'Polanco', '', '', ''),
('105044548', 'Ismael', 'Polanco', '', '', 'iapolancop@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla product
--

DROP TABLE IF EXISTS product;
CREATE TABLE product (
  IdProduct varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  nameProduct varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  description text COLLATE utf8_spanish_ci NOT NULL,
  price int(11) NOT NULL,
  unitMeasurement varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  stock int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla product
--

INSERT INTO product (IdProduct, nameProduct, description, price, unitMeasurement, stock) VALUES
('10006', 'Nylon', 'Grueso', 3000, 'Metros', 1000),
('10002', 'ñeque', 'agua mala de 250 ml', 2500, 'Cantidad', 200),
('10003', 'Cocacola', '250 ml', 1600, 'Cantidad', 250),
('10004', 'Postobon Manzana 250', '250 ml', 1200, 'Cantidad', 200),
('10005', 'Pepsi 300 ml', '300 ml', 1600, 'Cantidad', 200),
('10007', 'Cocacola 350 ml', '350 ml', 1600, 'Cantidad', 200),
('10009', 'Pepsi Familiar', 'Familiar', 1800, 'Cantidad', 200),
('10010', 'Ron viejos de Caldas', '750 ml', 50000, 'Cantidad', 200),
('10011', 'Ron viejo de caldas', '1 Litro', 65000, 'Cantidad', 200),
('10012', 'Ron medellin', '750 ml', 55000, 'Cantidad', 200),
('10013', 'Ron medellin', '1 litro', 65000, 'Cantidad', 200),
('10014', 'Ron medellin', '1.01 Litros', 80000, 'Cantidad', 200),
('10015', 'Old parr', '750 ml', 90000, 'Cantidad', 200),
('10016', 'Black and white', '750 ml', 55000, 'Cantidad', 200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla provider
--

DROP TABLE IF EXISTS provider;
CREATE TABLE provider (
  NIT_CC varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  business_name varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  phone varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  adress varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  e_mail varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  Type int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla provider
--

INSERT INTO provider (NIT_CC, business_name, phone, adress, e_mail, `Type`) VALUES
('1535435', 'Claudio Gutierrez', '2546589', 'K 85 #89-58', 'cluadio@gmail.com', 2),
('2313651', 'Raul Reyes', '3112564879', 'K 89 #56-89', 'raureyes@gmail.com', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla rol
--

DROP TABLE IF EXISTS rol;
CREATE TABLE rol (
  IdRol int(1) NOT NULL,
  Rol varchar(15) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla rol
--

INSERT INTO rol (IdRol, Rol) VALUES
(1, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla type_provide
--

DROP TABLE IF EXISTS type_provide;
CREATE TABLE type_provide (
  id_type_provide int(1) NOT NULL,
  nameType_provide varchar(8) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla type_provide
--

INSERT INTO type_provide (id_type_provide, nameType_provide) VALUES
(1, 'Juridica'),
(2, 'Natural');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla userinventario
--

DROP TABLE IF EXISTS userinventario;
CREATE TABLE userinventario (
  document_user varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  Nick varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  Password varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  Nombre varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  Primer apellido varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  Segundo apellido varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  Rol int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla bill
--
ALTER TABLE bill
  ADD PRIMARY KEY (id_bill);

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (Document);

--
-- Indices de la tabla product
--
ALTER TABLE product
  ADD PRIMARY KEY (IdProduct);

--
-- Indices de la tabla provider
--
ALTER TABLE provider
  ADD PRIMARY KEY (NIT_CC),
  ADD KEY Type (Type);

--
-- Indices de la tabla rol
--
ALTER TABLE rol
  ADD PRIMARY KEY (IdRol);

--
-- Indices de la tabla type_provide
--
ALTER TABLE type_provide
  ADD PRIMARY KEY (id_type_provide);

--
-- Indices de la tabla userinventario
--
ALTER TABLE userinventario
  ADD PRIMARY KEY (document_user),
  ADD UNIQUE KEY Nick (Nick),
  ADD KEY Rol (Rol);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla bill
--
ALTER TABLE bill
  MODIFY id_bill bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla type_provide
--
ALTER TABLE type_provide
  MODIFY id_type_provide int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
