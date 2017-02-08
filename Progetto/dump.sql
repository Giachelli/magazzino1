-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Feb 08, 2017 alle 10:01
-- Versione del server: 5.6.33
-- Versione PHP: 7.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `OOP1617`
--
CREATE DATABASE IF NOT EXISTS `OOP1617` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `OOP1617`;

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `user` varchar(15) NOT NULL,
  `pass` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `admin`
--

INSERT INTO `admin` (`id`, `user`, `pass`) VALUES
(1, 'admin', 'admin'),
(2, 'valerio', 'valerio');

-- --------------------------------------------------------

--
-- Struttura della tabella `dipendente`
--

CREATE TABLE `dipendente` (
  `codice` int(11) NOT NULL,
  `nome` varchar(15) NOT NULL,
  `cognome` varchar(15) NOT NULL,
  `cod_fisc` varchar(16) NOT NULL,
  `indirizzo` varchar(30) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `datan` date NOT NULL,
  `mansione` enum('Cassa','Sala','Banco') NOT NULL,
  `data_assunzione` date NOT NULL,
  `data_licenziamento` date DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `id_turno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `dipendente`
--

INSERT INTO `dipendente` (`codice`, `nome`, `cognome`, `cod_fisc`, `indirizzo`, `email`, `datan`, `mansione`, `data_assunzione`, `data_licenziamento`, `telefono`, `id`, `id_turno`) VALUES
(7, 'Giacomo', 'Chelli', 'CHLGCM95B28H769H', 'Via Isonzo, 2', '', '1995-02-28', 'Sala', '2015-01-01', '2020-01-01', '', 1, 4),
(8, 'Valerio', 'Iezzi', 'ZZIVLR92H18A488X', 'Via Ovidio 2', '', '1992-06-18', 'Banco', '2017-01-01', '2018-01-01', '', 1, 1),
(9, 'Mattia', 'Luciani', 'LCNMTT94D18A488X', 'Via Virgilio, 4', '', '1994-04-18', 'Cassa', '2017-01-01', '2020-01-01', '', 1, 2),
(10, 'Riccardo', 'Genovesi', 'GNVRCC95H26A488X', 'Via Miano, 6', '', '1995-06-26', 'Sala', '2017-01-01', '2020-01-01', '', 1, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotto`
--

CREATE TABLE `prodotto` (
  `codice` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `prezzo` float NOT NULL,
  `inizio_offerta` date DEFAULT NULL,
  `fine_offerta` date DEFAULT NULL,
  `offerta` tinyint(1) DEFAULT NULL,
  `prezzo_offerta` float DEFAULT NULL,
  `qta` int(11) NOT NULL,
  `scadenza` date NOT NULL,
  `scaffale` varchar(3) DEFAULT NULL,
  `settore` varchar(40) NOT NULL,
  `reparto` varchar(25) NOT NULL,
  `img` text,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `prodotto`
--

INSERT INTO `prodotto` (`codice`, `nome`, `marca`, `prezzo`, `inizio_offerta`, `fine_offerta`, `offerta`, `prezzo_offerta`, `qta`, `scadenza`, `scaffale`, `settore`, `reparto`, `img`, `id`) VALUES
(1, 'Acqua', 'Levissima', 0.39, NULL, NULL, 0, NULL, 60, '2020-01-01', 'H2', 'Liquidi & Bevande', 'Alimentare', 'Acqua.jpg', 1),
(2, 'Pasta Pennette Rigate', 'Barilla', 0.89, '2017-01-01', '2018-01-01', 1, 0.69, 35, '2020-01-01', 'L1', 'Alimentari confezionati', 'Alimentare', 'Pasta.jpg', 1),
(3, 'Latte', 'Parmalat', 1.5, NULL, NULL, 0, NULL, 20, '2019-11-20', 'H1', 'Liquidi & Bevande', 'Alimentare', 'Latte.jpg', 1),
(4, 'Biscotti nascondini', 'Mulino Bianco', 2.69, NULL, NULL, 0, NULL, 25, '2020-01-01', 'L3', 'Alimentari confezionati', 'Alimentare', 'Biscotti.png', 1),
(5, 'Coca Cola', 'Coca Cola', 1.59, '2017-02-15', '2017-02-28', 1, 1.29, 30, '2020-01-01', 'H1', 'Liquidi & Bevande', 'Alimentare', 'cocacola.jpg', 1),
(6, 'Succo vari gusti', 'Santal', 0.99, NULL, NULL, 0, NULL, 80, '2020-01-01', NULL, 'Liquidi & Bevande', 'Magazzino', 'Succo.jpg', 1),
(7, 'Merluzzo gratinato', 'Findus', 5.49, NULL, NULL, 0, NULL, 3, '2020-01-01', NULL, 'I Freschi & Surgelati', 'Magazzino', 'Merluzzo.jpg', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `turno`
--

CREATE TABLE `turno` (
  `id_turno` int(11) NOT NULL,
  `nome_turno` varchar(20) NOT NULL,
  `lunedi` varchar(10) NOT NULL,
  `martedi` varchar(10) NOT NULL,
  `mercoledi` varchar(10) NOT NULL,
  `giovedi` varchar(10) NOT NULL,
  `venerdi` varchar(10) NOT NULL,
  `sabato` varchar(10) NOT NULL,
  `tot_ore_settimanali` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `turno`
--

INSERT INTO `turno` (`id_turno`, `nome_turno`, `lunedi`, `martedi`, `mercoledi`, `giovedi`, `venerdi`, `sabato`, `tot_ore_settimanali`, `id`) VALUES
(1, 'Turno Mattina', 'Mattina', 'Mattina', 'Mattina', 'Mattina', 'Mattina', 'Mattina', 30, 1),
(2, 'Turno Pomeriggio', 'Pomeriggio', 'Pomeriggio', 'Pomeriggio', 'Pomeriggio', 'Pomeriggio', 'Pomeriggio', 30, 1),
(4, 'Part Time', 'Riposo', 'Pomeriggio', 'Mattina', 'Pomeriggio', 'Mattina', 'Riposo', 20, 1);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `dipendente`
--
ALTER TABLE `dipendente`
  ADD PRIMARY KEY (`codice`),
  ADD KEY `id` (`id`),
  ADD KEY `id_turno` (`id_turno`);

--
-- Indici per le tabelle `prodotto`
--
ALTER TABLE `prodotto`
  ADD PRIMARY KEY (`codice`),
  ADD KEY `id` (`id`);

--
-- Indici per le tabelle `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`id_turno`),
  ADD KEY `codice` (`id`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT per la tabella `dipendente`
--
ALTER TABLE `dipendente`
  MODIFY `codice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT per la tabella `prodotto`
--
ALTER TABLE `prodotto`
  MODIFY `codice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT per la tabella `turno`
--
ALTER TABLE `turno`
  MODIFY `id_turno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `dipendente`
--
ALTER TABLE `dipendente`
  ADD CONSTRAINT `dipendente_ibfk_1` FOREIGN KEY (`id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dipendente_ibfk_2` FOREIGN KEY (`id_turno`) REFERENCES `turno` (`id_turno`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `prodotto`
--
ALTER TABLE `prodotto`
  ADD CONSTRAINT `prodotto_ibfk_1` FOREIGN KEY (`id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `turno_ibfk_1` FOREIGN KEY (`id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;