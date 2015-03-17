-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Mar 17, 2015 at 01:50 AM
-- Server version: 5.5.38
-- PHP Version: 5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `visualization`
--

-- --------------------------------------------------------

--
-- Table structure for table `canvases`
--

CREATE TABLE `canvases` (
`vid` int(20) NOT NULL,
  `user_id` int(20) DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `mdate` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `cdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `privilege` int(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `canvases`
--

INSERT INTO `canvases` (`vid`, `user_id`, `name`, `note`, `mdate`, `cdate`, `privilege`) VALUES
(4, 1, 'test2', NULL, '2015-02-24 19:06:03', '2015-02-24 19:06:03', NULL),
(5, 1, 'test5', NULL, '2015-02-24 22:50:50', '2015-02-24 22:50:50', NULL),
(6, 1, 'test1', NULL, '2015-02-24 22:50:58', '2015-02-24 22:50:58', NULL),
(7, 1, 'test1', NULL, '2015-02-24 22:51:26', '2015-02-24 22:51:26', NULL),
(8, 1, 'test1', NULL, '2015-02-24 22:51:26', '2015-02-24 22:51:26', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `canvas_story`
--

CREATE TABLE `canvas_story` (
  `vid` int(20) NOT NULL,
  `sid` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `charts`
--

CREATE TABLE `charts` (
`cid` int(20) NOT NULL,
  `vid` int(20) DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `left` int(4) DEFAULT NULL,
  `top` int(4) DEFAULT NULL,
  `depth` int(4) DEFAULT NULL,
  `height` int(4) DEFAULT NULL,
  `width` int(4) DEFAULT NULL,
  `datainfo` varchar(10000) CHARACTER SET utf8 DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `story`
--

CREATE TABLE `story` (
`sid` int(20) NOT NULL,
  `connInfor` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `cdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `user_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `story_chart`
--

CREATE TABLE `story_chart` (
  `cid` int(20) NOT NULL,
  `sid` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
`user_id` int(20) NOT NULL,
  `user_modification` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `user_email` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_names` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_lastlogin` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_modification`, `user_date`, `user_email`, `user_names`, `user_lastlogin`) VALUES
(1, '2015-02-24 05:00:00', '2015-02-24 05:00:00', NULL, NULL, '2015-02-24 05:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `canvases`
--
ALTER TABLE `canvases`
 ADD PRIMARY KEY (`vid`), ADD KEY `FK_s7kxi1oqy0qc7bbo18jbeyj6s` (`user_id`);

--
-- Indexes for table `canvas_story`
--
ALTER TABLE `canvas_story`
 ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `charts`
--
ALTER TABLE `charts`
 ADD PRIMARY KEY (`cid`), ADD KEY `FK_tnp5dkeevkhrntvdd6vi3ud3u` (`vid`);

--
-- Indexes for table `story`
--
ALTER TABLE `story`
 ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `story_chart`
--
ALTER TABLE `story_chart`
 ADD PRIMARY KEY (`cid`,`sid`);

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
MODIFY `vid` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `charts`
--
ALTER TABLE `charts`
MODIFY `cid` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `story`
--
ALTER TABLE `story`
MODIFY `sid` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `user_id` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `canvases`
--
ALTER TABLE `canvases`
ADD CONSTRAINT `FK_s7kxi1oqy0qc7bbo18jbeyj6s` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `charts`
--
ALTER TABLE `charts`
ADD CONSTRAINT `FK_tnp5dkeevkhrntvdd6vi3ud3u` FOREIGN KEY (`vid`) REFERENCES `canvases` (`vid`);
