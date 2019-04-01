-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 01-04-2019 a las 19:05:55
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
-- Base de datos: `inventario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `IdProduct` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `nameProduct` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `description` text COLLATE utf8_spanish_ci NOT NULL,
  `price` int(11) NOT NULL,
  `unitMeasurement` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`IdProduct`, `nameProduct`, `description`, `price`, `unitMeasurement`, `stock`) VALUES
('10006', 'Nylon', 'Grueso', 3000, 'Metros', 1000),
('10002', 'ñeque', 'agua mala de 250 ml', 2500, 'Cantidad', 200),
('10003', 'Cocacola', '250 ml', 1600, 'Cantidad', 250),
('10001', 'Pepsi 250 ml', '250 ml', 1200, 'Cantidad', 200),
('10004', 'Postobon Manzana 250', '250 ml', 1200, 'Cantidad', 200),
('10005', 'Pepsi 300 ml', '300 ml', 1600, 'Cantidad', 200),
('10007', 'Cocacola 350 ml', '350 ml', 1600, 'Cantidad', 200),
('10008', 'Cocacola familiar', 'Familiar', 1800, 'Cantidad', 200),
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
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `IdRol` int(1) NOT NULL,
  `Rol` varchar(15) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`IdRol`, `Rol`) VALUES
(1, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `userinventario`
--

DROP TABLE IF EXISTS `userinventario`;
CREATE TABLE `userinventario` (
  `Nick` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `Password` varchar(90) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `Primer_apellido` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Segundo_apellido` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Rol` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `userinventario`
--

INSERT INTO `userinventario` (`Nick`, `Password`, `Nombre`, `Primer_apellido`, `Segundo_apellido`, `Rol`) VALUES
('Mari', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'Maria', 'Rangel', 'Liñan', 1),
('Pola', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'Ismael', 'Polanco', 'Payares', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`IdProduct`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`IdRol`);

--
-- Indices de la tabla `userinventario`
--
ALTER TABLE `userinventario`
  ADD PRIMARY KEY (`Nick`),
  ADD KEY `Rol` (`Rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
