-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2018 at 11:28 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `shubhmangalgreens`
--

-- --------------------------------------------------------

--
-- Table structure for table `sg_admin`
--

CREATE TABLE IF NOT EXISTS `sg_admin` (
  `userid` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sg_admin`
--

INSERT INTO `sg_admin` (`userid`, `pwd`) VALUES
('admin@shubhmangalgreens.com', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `sg_contact`
--

CREATE TABLE IF NOT EXISTS `sg_contact` (
  `address` text NOT NULL,
  `phone` varchar(20) NOT NULL,
  `fax` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `website` varchar(30) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sg_contact`
--

INSERT INTO `sg_contact` (`address`, `phone`, `fax`, `email`, `website`) VALUES
('Shubhmangal Greens,\r\nNr. ICB Island,\r\nGota, Ahmedabad.', '079-26644441', '079-26644442', 'info@shubhmangalgreens.com', 'shubhmangalgreens.com');

-- --------------------------------------------------------

--
-- Table structure for table `sg_inquiry`
--

CREATE TABLE IF NOT EXISTS `sg_inquiry` (
  `flatno` varchar(5) NOT NULL,
  `status` text NOT NULL,
  `name` char(30) NOT NULL,
  `phone` bigint(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dob` date DEFAULT NULL COMMENT 'Date of Booking',
  `address` varchar(255) NOT NULL,
  `question` longtext NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Time of Request',
  PRIMARY KEY (`email`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sg_inquiry`
--

INSERT INTO `sg_inquiry` (`flatno`, `status`, `name`, `phone`, `email`, `dob`, `address`, `question`, `time`) VALUES
('A201', 'Booked', 'ABC', 1111111111, 'a@b.c', '2016-10-01', 'ABC at ABC', 'ABCD', '2016-10-17 13:50:24'),
('A102', 'Pending\r\n', 'Mihir', 1234567891, 'abc@abvs.cjs', NULL, 'A', 'A', '2016-09-22 07:17:41'),
('A101', 'Pending', 'ABCDE', 45612378, 'abcd@abcd.ab', NULL, 'ABCDE', 'ABCDE', '2016-09-25 11:07:34'),
('B202', 'Pending', 'ABCD', 4561237891, 'abcd@abcd.abcd', NULL, 'ABCD', 'ABCD', '2016-09-25 10:59:21'),
('B301', 'Pending', 'MSH', 9876543219, 'abcd@xyz.in', NULL, 'DSAFGDJ', 'wsjdhkq', '2016-09-25 10:13:56'),
('E302', 'Pending', 'Akash', 6542187985, 'Ak@abc.com', NULL, 'Askdak', 'AKsjjdh', '2016-10-18 02:17:35'),
('C401', 'Pending', 'M', 2147483647, 'as@gn.cm', NULL, 'As', 'Assss\r\n', '2016-09-23 04:08:50'),
('A301', 'Booked', 'BCD', 1111111112, 'b@c.d', '2016-10-05', 'BCD at BCD', 'BCDE', '2016-10-17 13:50:24'),
('B101', 'Booked', 'CDE', 1111111113, 'c@d.e', '2016-10-03', 'CDE at CDE', 'CDEF', '2016-10-17 13:52:33'),
('B402', 'Booked', 'DEF', 1111111114, 'd@e.f', '2016-10-12', 'DEF at DEF', 'DEFG', '2016-10-17 13:52:33'),
('C302', 'Booked', 'EFG', 111111115, 'e@f.g', '2016-09-03', 'EFG at EFG', 'EFGH', '2016-10-17 13:53:41'),
('C101', 'Pending', 'djnw', 546842654, 'kadj@djw.kdj', NULL, 'kd', 'kwdjwqdj', '2016-09-25 11:16:00'),
('C202', 'Seen', 'kjfijfer', 3333333333, 'kdjsk@kflk.skls', NULL, 'dkfjldfij', 'fjdhkedfh', '2016-09-26 05:36:22'),
('D101', 'Seen', 'dkmewdkw', 5464, 'kjwfnq@keq.kw', NULL, 'kefm', 'dkqlwkkdm', '2016-09-25 11:14:25'),
('D202', 'Seen', 'whoqidhwdnqi', 54853213, 'pqr@prq.p', NULL, 'kdsnqowidh', 'jldwodwd', '2016-09-26 00:42:46'),
('E301', 'Seen', 'whoqidhwdnqi', 548532131654, 'pqr@prq.pqrs', NULL, 'kdsnqowidh', 'jldwodwd', '2016-09-26 00:44:02'),
('A401', 'Seen', 'scs', 1231546865, 'sas@fwe.iow', NULL, 'cas', 'ksmsoidjc omc oimcwoifj oicf\r\n', '2016-10-17 03:30:25'),
('E101', 'Seen', 'skjalsdjo', 21646516, 'sjh@sjdb.sdj', NULL, 'kdsnfow', 'knw', '2016-09-26 05:20:34'),
('E202', 'Pending', 'Sanjay', 9532149856, 'sr@arh.asj', NULL, 'Sahsg', 'Srh', '2016-10-17 13:38:35'),
('E401', 'Seen', 'mihirhindocha', 54465421, 'wjdh@wkdj.skd', NULL, 'dhwoiud', 'ldjwoid', '2016-09-25 11:09:30'),
('E102', 'Seen', 'WXYZ', 1111111119, 'WX@Y.Z', NULL, 'WXYZ', 'WXYZ', '2016-09-26 07:35:53');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
