-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2026 at 04:39 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `cardno` varchar(25) NOT NULL,
  `date` varchar(50) NOT NULL,
  `type` varchar(20) NOT NULL,
  `amount` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`cardno`, `date`, `type`, `amount`) VALUES
('505098110085023961', 'Sun Apr 05 12:46:20 IST 2026', 'Deposit', '5000'),
('505098110085023961', 'Sun Apr 05 12:50:10 IST 2026', 'Deposit', '5000'),
('505098110085023961', 'Sun Apr 05 12:50:22 IST 2026', 'Withdraw', '500'),
('505098110085023961', 'Sun Apr 05 13:16:05 IST 2026', 'Withdraw', '1000');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `formno` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `fname` varchar(200) NOT NULL,
  `dob` varchar(200) NOT NULL,
  `gender` varchar(200) NOT NULL,
  `phonenumber` varchar(200) NOT NULL,
  `city` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`formno`, `name`, `fname`, `dob`, `gender`, `phonenumber`, `city`) VALUES
('1348', ' sad', 'we', '19 Jan 2026', 'Male', '2321', 'dasdsa'),
('4895', 'dtfyg', 'dtfyg', '16 Jan 2026', 'Female', '1234567', 'ftyguh'),
('1110', 'hhjh', 'hhjil', '10 Mar 2026', 'Female', '1234567892', 'fghkkm'),
('4360', 'hhftk', 'yfuk', '11 Mar 2026', 'Female', '23467890', 'tydyj'),
('1532', 'zsdxfgch', 'srdtfyguh', '1 Mar 2026', 'Female', '12345678', 'kolkata'),
('5962', 'Tamalika Deb', 'Tapas Deb', '8 Apr 2026', 'Female', '6290099575', 'kolkata');

-- --------------------------------------------------------

--
-- Table structure for table `signupsecond`
--

CREATE TABLE `signupsecond` (
  `formno` varchar(200) NOT NULL,
  `religion` varchar(200) NOT NULL,
  `category` varchar(200) NOT NULL,
  `income` varchar(200) NOT NULL,
  `education` varchar(200) NOT NULL,
  `occupation` varchar(200) NOT NULL,
  `pan` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signupsecond`
--

INSERT INTO `signupsecond` (`formno`, `religion`, `category`, `income`, `education`, `occupation`, `pan`) VALUES
('1110', 'Hindu', 'General', '<3,00,000', '12th', 'Business', 'atp5689f'),
('1532', 'Hindu', 'General', '<5,00,000', 'Graduation', 'Business', '1234567890'),
('4360', 'Hindu', 'General', '<1,50,000', '12th', 'Business', 'sdgtg5678'),
('4895', 'Hindu', 'General', '<1,50,000', '12th', 'Business', 'fghmkgjh,hk'),
('5962', 'Hindu', 'General', '<3,00,000', 'Graduation', 'Business', '123456789');

-- --------------------------------------------------------

--
-- Table structure for table `signupthree`
--

CREATE TABLE `signupthree` (
  `formno` varchar(20) NOT NULL,
  `accounttype` varchar(200) NOT NULL,
  `cardno` varchar(25) NOT NULL,
  `pinNo` varchar(10) NOT NULL,
  `facility` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signupthree`
--

INSERT INTO `signupthree` (`formno`, `accounttype`, `cardno`, `pinNo`, `facility`) VALUES
('1110', 'savings Account', '505098110085023961', '2614', 'ATM Card'),
('1110', 'savings Account', '505098110048602041', '478', 'ATM Card'),
('1110', 'savings Account', '505098109978149218', '7740', 'ATM Card'),
('1110', 'savings Account', '505098109965937137', '888', 'ATM Card'),
('1110', 'savings Account', '505098110058960021', '4523', 'ATM Card'),
('4360', 'savings Account', '505098110056195714', '6206', 'ATM Card'),
('4360', 'savings Account', '505098109960568622', '6248', 'ATM Card'),
('1532', 'Fixed Deposite', '505098110035628157', '1096', 'ATM Card'),
('5962', 'savings Account', '505098110008366177', '4302', 'ATM CardEmail$sms');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `signupsecond`
--
ALTER TABLE `signupsecond`
  ADD UNIQUE KEY `UK_01` (`formno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
