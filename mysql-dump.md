# studiapp

-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 07. Nov 2018 um 18:08
-- Server-Version: 10.1.16-MariaDB
-- PHP-Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `studiapp`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `tbl_vorlesungsverschiebungen`
--

CREATE TABLE `tbl_vorlesungsverschiebungen` (
  `id` bigint(20) NOT NULL,
  `fach` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `prof` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `terminnew` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `terminold` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Daten für Tabelle `tbl_vorlesungsverschiebungen`
--

INSERT INTO `tbl_vorlesungsverschiebungen` (`id`, `fach`, `prof`, `terminnew`, `terminold`) VALUES
(1, 'pms', 'schneeburger', 'montag', 'dienstag'),
(2, 'matte', 'grabsteiner', 'dienstag', 'montag');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `tbl_vorlesungsverschiebungen`
--
ALTER TABLE `tbl_vorlesungsverschiebungen`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
