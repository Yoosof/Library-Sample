-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 02, 2017 at 03:44 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `design_pattern_library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `name`, `author`, `publisher`, `quantity`) VALUES
(4, 'the gambler', 'dastayoski', 'amirkabir', 5),
(6, 'the gambler3', 'dastayoski', 'amirkabir', 5);

-- --------------------------------------------------------

--
-- Table structure for table `requestbook`
--

CREATE TABLE `requestbook` (
  `id` int(10) NOT NULL,
  `book_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `issued_date` date DEFAULT NULL,
  `borrowed_date` date DEFAULT NULL,
  `returned_date` date DEFAULT NULL,
  `has_debt` int(10) NOT NULL DEFAULT '0',
  `has_borrowed` int(10) NOT NULL DEFAULT '0',
  `has_returned` int(10) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `requestbook`
--

INSERT INTO `requestbook` (`id`, `book_id`, `user_id`, `issued_date`, `borrowed_date`, `returned_date`, `has_debt`, `has_borrowed`, `has_returned`) VALUES
(8, 4, 7, '2017-01-01', '2017-01-15', '2017-02-02', 1, 1, 1),
(9, 4, 9, '2017-02-01', NULL, NULL, 0, 0, 0),
(12, 4, 11, '2017-02-02', '2017-02-02', '2017-02-02', 0, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `is_admin` int(10) UNSIGNED NOT NULL DEFAULT '0',
  `national_code` int(10) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile_number` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `password`, `is_admin`, `national_code`, `email`, `mobile_number`, `address`, `username`) VALUES
(1, 'Prabhakar', 'ppp', 0, 0, NULL, NULL, NULL, 'a'),
(4, 'sumedh', 'sumesh', 0, 1, NULL, NULL, NULL, 'b'),
(6, 'abhi', 'abhi', 0, 2, NULL, NULL, NULL, 'c'),
(7, 'yoosof', 'hello', 0, 15, 'mash@gmail.com', '44645635', 'tehran, azadi', 'yoosof'),
(9, 'yoosof2', 'hello', 1, 16, 'mash@gmail.com', '44645635', 'tehran, azadi', 'yoosof2'),
(11, 'arman', 'hello', 0, 345435, 'arman@gmail', '5345345', 'semnan', 'arman');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `requestbook`
--
ALTER TABLE `requestbook`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `national_code` (`national_code`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `requestbook`
--
ALTER TABLE `requestbook`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
