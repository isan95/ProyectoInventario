-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 13-05-2019 a las 19:14:53
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
  date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  id_client varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  id_seller varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  Subtotal int(11) NOT NULL,
  IVA int(11) NOT NULL,
  Total int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla bill
--

INSERT INTO bill (id_bill, `date`, id_client, id_seller, Subtotal, IVA, Total) VALUES
(21, '2019-04-27 16:16:25', '105044548', 'MariaIsabel', 0, 0, 0),
(20, '2019-04-27 16:07:00', '105005465', 'MariaIsabel', 0, 0, 0),
(22, '2019-05-03 20:23:03', '15564652', 'MariaIsabel', 5500, 1045, 6545),
(23, '2019-05-03 20:37:06', '15564652', 'MariaIsabel', 5500, 1045, 6545),
(24, '2019-05-03 20:37:37', '15564652', 'MariaIsabel', 5500, 1045, 6545),
(25, '2019-05-03 20:43:22', '105044548', 'MariaIsabel', 5500, 1045, 6545),
(26, '2019-05-03 21:39:35', '105005465', 'MariaIsabel', 5500, 1045, 6545),
(27, '2019-05-03 21:41:02', '15564652', 'MariaIsabel', 5500, 1045, 6545),
(28, '2019-05-04 16:40:17', '105044548', 'MariaIsabel', 7100, 1349, 8449),
(29, '2019-05-04 16:48:57', '15564652', 'MariaIsabel', 5200, 988, 6188),
(30, '2019-05-04 16:59:47', '15564652', 'MariaIsabel', 5500, 1045, 6545),
(31, '2019-05-04 17:01:09', '15564652', 'MariaIsabel', 5500, 1045, 6545),
(32, '2019-05-04 17:27:13', '15564652', 'MariaIsabel', 22000, 4180, 26180),
(33, '2019-05-04 17:31:49', '15564652', 'MariaIsabel', 22000, 4180, 26180),
(34, '2019-05-04 17:33:16', '15564652', 'MariaIsabel', 22000, 4180, 26180),
(35, '2019-05-04 17:37:33', '15564652', 'MariaIsabel', 22000, 4180, 26180),
(36, '2019-05-04 17:38:26', '15564652', 'MariaIsabel', 22000, 4180, 26180),
(37, '2019-05-04 17:42:36', '15564652', 'MariaIsabel', 22000, 4180, 26180),
(38, '2019-05-04 17:43:09', '15564652', 'MariaIsabel', 5500, 1045, 6545),
(39, '2019-05-04 21:52:14', '105044548', 'MariaIsabel', 473300, 89927, 563227),
(40, '2019-05-05 13:36:25', '105044548', 'MariaIsabel', 5500, 1045, 6545),
(41, '2019-05-05 13:40:16', '105044548', 'MariaIsabel', 473300, 89927, 563227),
(42, '2019-05-05 16:00:27', '105044548', 'MariaIsabel', 473300, 89927, 563227),
(43, '2019-05-05 18:17:02', '15564652', 'MariaIsabel', 473300, 89927, 563227),
(44, '2019-05-13 13:46:42', '105044548', 'isan', 5500, 1045, 6545);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla bill_product
--

DROP TABLE IF EXISTS bill_product;
CREATE TABLE bill_product (
  id_bill bigint(20) NOT NULL,
  IdProduct varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  Cant int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla bill_product
--

INSERT INTO bill_product (id_bill, IdProduct, Cant) VALUES
(21, '10005', 0),
(21, '10004', 0),
(21, '10003', 0),
(21, '10002', 0),
(21, '10006', 0),
(20, '10006', 0),
(20, '10003', 0),
(20, '10002', 0),
(20, '10004', 0),
(26, '10006', 1),
(26, '10002', 1),
(27, '10006', 1),
(27, '10002', 1),
(28, '10006', 1),
(28, '10002', 1),
(28, '10007', 1),
(29, '10004', 3),
(29, '10005', 1),
(30, '10006', 1),
(30, '10002', 1),
(31, '10006', 1),
(31, '10002', 1),
(32, '10006', 4),
(32, '10002', 4),
(33, '10006', 4),
(33, '10002', 4),
(34, '10006', 4),
(34, '10002', 4),
(35, '10006', 4),
(35, '10002', 4),
(36, '10006', 4),
(36, '10002', 4),
(37, '10006', 4),
(37, '10002', 4),
(38, '10006', 1),
(38, '10002', 1),
(39, '10004', 1),
(39, '10005', 1),
(39, '10006', 1),
(39, '10002', 1),
(39, '10003', 1),
(39, '10007', 1),
(39, '10009', 1),
(39, '10010', 1),
(39, '10011', 1),
(39, '10012', 1),
(39, '10013', 1),
(39, '10014', 1),
(39, '10015', 1),
(39, '10016', 1),
(40, '10006', 1),
(40, '10002', 1),
(41, '10006', 1),
(41, '10002', 1),
(41, '10003', 1),
(41, '10004', 1),
(41, '10005', 1),
(41, '10007', 1),
(41, '10009', 1),
(41, '10010', 1),
(41, '10011', 1),
(41, '10012', 1),
(41, '10013', 1),
(41, '10014', 1),
(41, '10015', 1),
(41, '10016', 1),
(42, '10006', 1),
(42, '10002', 1),
(42, '10003', 1),
(42, '10004', 1),
(42, '10005', 1),
(42, '10007', 1),
(42, '10009', 1),
(42, '10010', 1),
(42, '10011', 1),
(42, '10012', 1),
(42, '10013', 1),
(42, '10014', 1),
(42, '10015', 1),
(42, '10016', 1),
(43, '10006', 1),
(43, '10002', 1),
(43, '10003', 1),
(43, '10004', 1),
(43, '10005', 1),
(43, '10007', 1),
(43, '10009', 1),
(43, '10010', 1),
(43, '10011', 1),
(43, '10012', 1),
(43, '10013', 1),
(43, '10014', 1),
(43, '10015', 1),
(43, '10016', 1),
(44, '10006', 1),
(44, '10002', 1);

--
-- Disparadores bill_product
--
DROP TRIGGER IF EXISTS `bill_product_BI`;
DELIMITER $$
CREATE TRIGGER `bill_product_BI` BEFORE INSERT ON `bill_product` FOR EACH ROW UPDATE product INNER JOIN bill_product on NEW.IdProduct = product.IdProduct SET stock = (stock - (new.Cant))
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla checkin_product
--

DROP TABLE IF EXISTS checkin_product;
CREATE TABLE checkin_product (
  id_checkin_product int(11) NOT NULL,
  provider varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  user_checkin varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  DataIn datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla checkin_product
--

INSERT INTO checkin_product (id_checkin_product, provider, user_checkin, DataIn) VALUES
(1, '1535435', '1002568', '2019-05-09 18:36:03'),
(2, '1535435', '1002568', '2019-05-09 19:08:09'),
(3, '1535435', '1002568', '2019-05-09 19:10:52'),
(4, '1535435', '1002568', '2019-05-10 22:17:20');

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
('105044548', 'Ismael', 'Polanco', '', '', 'iapolancop@gmail.com'),
('15564652', 'Fernado', 'Bolaños', '', '3689635478', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla petty_cash
--

DROP TABLE IF EXISTS petty_cash;
CREATE TABLE petty_cash (
  id_petty_cash int(11) NOT NULL,
  cash int(11) NOT NULL,
  reason text COLLATE utf8_spanish_ci NOT NULL,
  user_petty_cash varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  Data_petty_cash datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla petty_cash
--

INSERT INTO petty_cash (id_petty_cash, cash, reason, user_petty_cash, Data_petty_cash) VALUES
(1, 10000, 'Nada', '1002568', '2019-05-10 20:53:08');

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
('10006', 'Nylon', 'Grueso', 3000, 'Metros', 239),
('10002', 'ñeque', 'agua mala de 250 ml', 2500, 'Cantidad', 239),
('10003', 'Cocacola', '250 ml', 1600, 'Cantidad', 166),
('10004', 'Postobon Manzana 250', '250 ml', 1200, 'Cantidad', 66),
('10005', 'Pepsi 300 ml', '300 ml', 1600, 'Cantidad', 66),
('10007', 'Cocacola 350 ml', '350 ml', 1600, 'Cantidad', 166),
('10009', 'Pepsi Familiar', 'Familiar', 1800, 'Cantidad', 196),
('10010', 'Ron viejos de Caldas', '750 ml', 50000, 'Cantidad', 196),
('10011', 'Ron viejo de caldas', '1 Litro', 65000, 'Cantidad', 196),
('10012', 'Ron medellin', '750 ml', 55000, 'Cantidad', 196),
('10013', 'Ron medellin', '1 litro', 65000, 'Cantidad', 196),
('10014', 'Ron medellin', '1.01 Litros', 80000, 'Cantidad', 196),
('10015', 'Old parr', '750 ml', 90000, 'Cantidad', 196),
('10016', 'Black and white', '750 ml', 55000, 'Cantidad', 196);

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
-- Estructura de tabla para la tabla provider_product
--

DROP TABLE IF EXISTS provider_product;
CREATE TABLE provider_product (
  id_checkin_product int(11) NOT NULL,
  IdProduct varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  cant_provider_product int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla provider_product
--

INSERT INTO provider_product (id_checkin_product, IdProduct, cant_provider_product) VALUES
(3, '10006', 1),
(3, '10002', 1),
(4, '10006', 2),
(4, '10002', 2);

--
-- Disparadores provider_product
--
DROP TRIGGER IF EXISTS `provider_product_BI`;
DELIMITER $$
CREATE TRIGGER `provider_product_BI` BEFORE INSERT ON `provider_product` FOR EACH ROW UPDATE product SET stock = stock + NEW.cant_provider_product WHERE product.IdProduct = NEW.IdProduct
$$
DELIMITER ;

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
  Primer_apellido varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  Segundo_apellido varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  Rol int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla userinventario
--

INSERT INTO userinventario (document_user, Nick, `Password`, Nombre, Primer_apellido, Segundo_apellido, Rol) VALUES
('1002568', 'MariaIsabel', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'Maria', 'Martinez', 'De Polanco', 2),
('1050067213', 'isan', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'Ismael', 'Polanco', 'Payares', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla bill
--
ALTER TABLE bill
  ADD PRIMARY KEY (id_bill),
  ADD KEY id_client (id_client),
  ADD KEY id_seller (id_seller);

--
-- Indices de la tabla bill_product
--
ALTER TABLE bill_product
  ADD KEY id_bill (id_bill),
  ADD KEY IdProduct (IdProduct);

--
-- Indices de la tabla checkin_product
--
ALTER TABLE checkin_product
  ADD PRIMARY KEY (id_checkin_product),
  ADD KEY provider (provider),
  ADD KEY user_checkin (user_checkin);

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (Document);

--
-- Indices de la tabla petty_cash
--
ALTER TABLE petty_cash
  ADD PRIMARY KEY (id_petty_cash),
  ADD KEY user_petty_cash (user_petty_cash);

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
-- Indices de la tabla provider_product
--
ALTER TABLE provider_product
  ADD KEY IdProduct (IdProduct);

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
  MODIFY id_bill bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla checkin_product
--
ALTER TABLE checkin_product
  MODIFY id_checkin_product int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla petty_cash
--
ALTER TABLE petty_cash
  MODIFY id_petty_cash int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla type_provide
--
ALTER TABLE type_provide
  MODIFY id_type_provide int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
