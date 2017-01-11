-- phpMyAdmin SQL Dump
-- version 4.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Dic 27, 2016 alle 13:42
-- Versione del server: 5.5.34
-- PHP Version: 5.5.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `OOP1617`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
`id` int(11) NOT NULL,
  `user` varchar(15) NOT NULL,
  `pass` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  `scaffale` varchar(2) DEFAULT NULL,
  `settore` enum('Frutta e Verdura','Bancone alimentare','Macelleria','Pescheria','Frigoriferi','Congelatori','Dolciario','Panificio','Bevande','Pasta','Condimenti','Cancelleria','Per la casa','Igene','Detersivi') DEFAULT NULL,
  `reparto` enum('Alimentare','Utility','Magazzino','') NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struttura della tabella `turno`
--

CREATE TABLE `turno` (
`id_turno` int(11) NOT NULL,
  `data_inizio` datetime NOT NULL,
  `data_fine` datetime NOT NULL,
  `tot_ore_settimanali` int(11) NOT NULL,
  `tot_ore_giornaliere` int(11) NOT NULL,
  `codice` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dipendente`
--
ALTER TABLE `dipendente`
 ADD PRIMARY KEY (`codice`), ADD KEY `id` (`id`);

--
-- Indexes for table `prodotto`
--
ALTER TABLE `prodotto`
 ADD PRIMARY KEY (`codice`), ADD KEY `id` (`id`);

--
-- Indexes for table `turno`
--
ALTER TABLE `turno`
 ADD PRIMARY KEY (`id_turno`), ADD KEY `codice` (`codice`,`id`), ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `dipendente`
--
ALTER TABLE `dipendente`
MODIFY `codice` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `prodotto`
--
ALTER TABLE `prodotto`
MODIFY `codice` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `turno`
--
ALTER TABLE `turno`
MODIFY `id_turno` int(11) NOT NULL AUTO_INCREMENT;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `dipendente`
--
ALTER TABLE `dipendente`
ADD CONSTRAINT `dipendente_ibfk_1` FOREIGN KEY (`id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `prodotto`
--
ALTER TABLE `prodotto`
ADD CONSTRAINT `prodotto_ibfk_1` FOREIGN KEY (`id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `turno`
--
ALTER TABLE `turno`
ADD CONSTRAINT `turno_ibfk_2` FOREIGN KEY (`id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `turno_ibfk_1` FOREIGN KEY (`codice`) REFERENCES `dipendente` (`codice`) ON DELETE CASCADE ON UPDATE CASCADE;
