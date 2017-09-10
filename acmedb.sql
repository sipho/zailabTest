-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 10, 2017 at 01:53 PM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `acmedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `acme_table`
--

CREATE TABLE `acme_table` (
  `ID` int(10) NOT NULL,
  `ACCOUNT_ID` varchar(15) NOT NULL,
  `BALANCE` varchar(15) NOT NULL,
  `ACCOUNT_TYPE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acme_table`
--

INSERT INTO `acme_table` (`ID`, `ACCOUNT_ID`, `BALANCE`, `ACCOUNT_TYPE`) VALUES
(2, '123', '3336', 'savings'),
(1, '34343', '3343', ''),
(3, '567', '1002', 'savings');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acme_table`
--
ALTER TABLE `acme_table`
  ADD PRIMARY KEY (`ACCOUNT_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
