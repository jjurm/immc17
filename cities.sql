
DROP TABLE IF EXISTS `bigcities`;

CREATE TABLE `bigcities` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `country` varchar(2) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `accent` varchar(100) DEFAULT NULL,
  `region` varchar(2) DEFAULT NULL,
  `population` int(11) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lon` double DEFAULT NULL,
  `tz_id` varchar(50) DEFAULT NULL,
  `alt` double DEFAULT NULL
) DEFAULT CHARSET=latin1;
