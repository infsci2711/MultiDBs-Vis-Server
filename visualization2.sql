-- phpMyAdmin SQL Dump
-- version 4.4.1.1
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: Apr 18, 2015 at 11:57 AM
-- Server version: 5.5.42
-- PHP Version: 5.6.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `visualization2`
--
CREATE DATABASE IF NOT EXISTS `visualization2` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `visualization2`;

-- --------------------------------------------------------

--
-- Table structure for table `canvases`
--

CREATE TABLE IF NOT EXISTS `canvases` (
  `vid` int(20) NOT NULL,
  `user_id` int(20) DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `mdate` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `cdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `privilege` int(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `canvases`
--

INSERT INTO `canvases` (`vid`, `user_id`, `name`, `note`, `mdate`, `cdate`, `privilege`) VALUES
(11, 1, 'test2', NULL, '2015-04-12 21:56:09', '2015-04-12 21:56:09', NULL),
(12, 2, 'test3', NULL, '2015-04-13 16:57:09', '2015-04-13 16:57:09', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `charts`
--

CREATE TABLE IF NOT EXISTS `charts` (
  `cid` int(20) NOT NULL,
  `sid` int(20) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `type` varchar(40) NOT NULL,
  `did` varchar(40) NOT NULL,
  `dname` varchar(40) NOT NULL,
  `tname` varchar(40) NOT NULL,
  `columns` varchar(200) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `charts`
--

INSERT INTO `charts` (`cid`, `sid`, `name`, `type`, `did`, `dname`, `tname`, `columns`) VALUES
(1, 2, NULL, 'pie', '1', 'city', 'Pittsburgh', 'population');

-- --------------------------------------------------------

--
-- Table structure for table `story`
--

CREATE TABLE IF NOT EXISTS `story` (
  `sid` int(20) NOT NULL,
  `vid` int(20) NOT NULL,
  `cdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `did` varchar(40) NOT NULL,
  `dname` varchar(40) NOT NULL,
  `tname` varchar(40) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `story`
--

INSERT INTO `story` (`sid`, `vid`, `cdate`, `did`, `dname`, `tname`) VALUES
(2, 11, '0000-00-00 00:00:00', '1', 'city', 'Pittsburgh');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(20) NOT NULL,
  `user_names` varchar(128) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_names`) VALUES
(1, 'user1'),
(2, 'user2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `canvases`
--
ALTER TABLE `canvases`
  ADD PRIMARY KEY (`vid`),
  ADD KEY `FK_s7kxi1oqy0qc7bbo18jbeyj6s` (`user_id`);

--
-- Indexes for table `charts`
--
ALTER TABLE `charts`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `story`
--
ALTER TABLE `story`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `canvases`
--
ALTER TABLE `canvases`
  MODIFY `vid` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `charts`
--
ALTER TABLE `charts`
  MODIFY `cid` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `story`
--
ALTER TABLE `story`
  MODIFY `sid` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;