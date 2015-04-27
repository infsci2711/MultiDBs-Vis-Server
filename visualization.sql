CREATE DATABASE IF NOT EXISTS `visualization`;
USE `visualization`;

-- --------------------------------------------------------

--
-- Table structure for table `canvases`
--

CREATE TABLE IF NOT EXISTS `canvases` (
  `vid` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `note` longtext,
  `mdate` datetime NOT NULL,
  `cdate` datetime NOT NULL,
  `privilege` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `charts`
--

CREATE TABLE IF NOT EXISTS `charts` (
  `cid` int(11) NOT NULL,
  `vid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `left` int(11) DEFAULT NULL,
  `top` int(11) DEFAULT NULL,
  `depth` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `datainfo` longtext,
  `note` longtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `chart_has_story`
--

CREATE TABLE IF NOT EXISTS `chart_has_story` (
  `cid` int(20) NOT NULL,
  `sid` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `story`
--

CREATE TABLE IF NOT EXISTS `story` (
  `sid` int(20) NOT NULL,
  `connInfor` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `cdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `mdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL,
  `user_modification` datetime NOT NULL,
  `user_date` datetime NOT NULL,
  `user_email` varchar(128) DEFAULT NULL,
  `user_names` varchar(128) DEFAULT NULL,
  `user_lastlogin` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  ADD PRIMARY KEY (`cid`),
  ADD KEY `FK_tnp5dkeevkhrntvdd6vi3ud3u` (`vid`);

--
-- Indexes for table `chart_has_story`
--
ALTER TABLE `chart_has_story`
  ADD PRIMARY KEY (`cid`,`sid`);

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
  MODIFY `vid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `charts`
--
ALTER TABLE `charts`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `story`
--
ALTER TABLE `story`
  MODIFY `sid` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
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
