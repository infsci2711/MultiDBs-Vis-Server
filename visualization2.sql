SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS `visualization`;
USE `visualization`;

CREATE TABLE `canvases` (
`vid` int(20) NOT NULL,
  `user_id` int(20) DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `note` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `mdate` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `cdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `privilege` int(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `charts` (
`cid` int(20) NOT NULL,
  `sid` int(20) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `type` varchar(40) NOT NULL,
  `did` varchar(40) NOT NULL,
  `dname` varchar(40) NOT NULL,
  `tname` varchar(40) NOT NULL,
  `columns` varchar(200) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `story` (
`sid` int(20) NOT NULL,
  `vid` int(20) NOT NULL,
  `cdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `did` varchar(40) NOT NULL,
  `dname` varchar(40) NOT NULL,
  `tname` varchar(40) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
`user_id` int(20) NOT NULL,
  `user_names` varchar(128) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO `users` (`user_id`, `user_names`) VALUES
(1, 'user1'),
(2, 'user2');

ALTER TABLE `canvases`
 ADD PRIMARY KEY (`vid`), ADD KEY `FK_s7kxi1oqy0qc7bbo18jbeyj6s` (`user_id`);

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

CREATE USER 'dataverse'@'%' IDENTIFIED BY 'dataverse';
GRANT ALL PRIVILEGES ON *.* TO 'dataverse'@'%' WITH GRANT OPTION;

FLUSH PRIVILEGES;