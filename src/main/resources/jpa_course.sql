-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 18, 2021 at 06:29 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jpa_course`
--

-- --------------------------------------------------------

--
-- Table structure for table `address_tbl`
--

CREATE TABLE `address_tbl` (
  `id` bigint(20) NOT NULL,
  `street` varchar(256) NOT NULL,
  `barangay` varchar(256) NOT NULL,
  `city` varchar(256) NOT NULL,
  `zip_code` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `address_tbl`
--

INSERT INTO `address_tbl` (`id`, `street`, `barangay`, `city`, `zip_code`) VALUES
(14, 'sto. rosario', 'sasa', 'davao', '8000'),
(14, 'sam miguel', 'lorega', 'cebu', '6000'),
(16, 'sto. rosario', 'sasa', 'davao', '8000'),
(16, 'sam miguel', 'lorega', 'cebu', '6000'),
(17, 'sto. rosario', 'sasa', 'davao', '8000'),
(17, 'sam miguel', 'lorega', 'cebu', '6000');

-- --------------------------------------------------------

--
-- Table structure for table `instructor_tbl`
--

CREATE TABLE `instructor_tbl` (
  `instructor_id` bigint(20) NOT NULL,
  `date_saved` date DEFAULT NULL,
  `time_saved` time DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `instructor_tbl`
--

INSERT INTO `instructor_tbl` (`instructor_id`, `date_saved`, `time_saved`, `birthdate`, `email`, `firstname`, `gender`, `lastname`, `mobile_number`, `department`, `position`) VALUES
(1, NULL, NULL, '1992-01-31', NULL, 'prince', NULL, NULL, NULL, 'ite', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `student_officer_tbl`
--

CREATE TABLE `student_officer_tbl` (
  `id` bigint(20) NOT NULL,
  `type` varchar(256) NOT NULL,
  `position` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_officer_tbl`
--

INSERT INTO `student_officer_tbl` (`id`, `type`, `position`) VALUES
(16, 'vise president', 'section'),
(16, 'president', 'department'),
(17, 'section', 'vise president'),
(17, 'department', 'president');

-- --------------------------------------------------------

--
-- Table structure for table `student_subject_tbl`
--

CREATE TABLE `student_subject_tbl` (
  `id` bigint(20) NOT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_subject_tbl`
--

INSERT INTO `student_subject_tbl` (`id`, `student_id`, `subject_id`) VALUES
(6, 3, 1),
(13, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `student_tbl`
--

CREATE TABLE `student_tbl` (
  `student_id` bigint(20) NOT NULL,
  `date_saved` date DEFAULT NULL,
  `time_saved` time DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_tbl`
--

INSERT INTO `student_tbl` (`student_id`, `date_saved`, `time_saved`, `birthdate`, `email`, `firstname`, `gender`, `lastname`, `mobile_number`, `course`, `department`, `level`) VALUES
(3, '2021-09-09', '20:48:28', '1992-01-31', 'louie.nullvoid@gmail.com', 'prince', 'male', 'nalasa', '0987654321', 'bscs', 'ite', 4),
(14, '2021-09-11', '22:34:04', '1999-02-01', '', 'prince', '', 'nalasa', '', '', '', 4),
(16, '2021-09-11', '22:55:27', '1999-02-01', '', 'prince', '', 'nalasa', '', '', '', 4),
(17, '2021-09-11', '22:57:06', '1999-02-01', '', 'prince', '', 'nalasa', '', '', '', 4);

-- --------------------------------------------------------

--
-- Table structure for table `subject_tbl`
--

CREATE TABLE `subject_tbl` (
  `subject_id` bigint(20) NOT NULL,
  `subject_description` varchar(255) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL,
  `subject_unit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject_tbl`
--

INSERT INTO `subject_tbl` (`subject_id`, `subject_description`, `subject_name`, `subject_unit`) VALUES
(1, 'intro to java', 'proramming 1', 3),
(2, 'calculus', 'math 101', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address_tbl`
--
ALTER TABLE `address_tbl`
  ADD KEY `FK7keo8rllv3vty42ih9sdjisvs` (`id`);

--
-- Indexes for table `instructor_tbl`
--
ALTER TABLE `instructor_tbl`
  ADD PRIMARY KEY (`instructor_id`);

--
-- Indexes for table `student_officer_tbl`
--
ALTER TABLE `student_officer_tbl`
  ADD KEY `FKmfh3s70h2oywp23mdkh20k5fl` (`id`);

--
-- Indexes for table `student_subject_tbl`
--
ALTER TABLE `student_subject_tbl`
  ADD PRIMARY KEY (`id`),
  ADD KEY `UK_o8kk9i9kqid1nmp8t4j27q5ft` (`student_id`) USING BTREE,
  ADD KEY `UK_ayql2b6737eyrlnsg5kij57xq` (`subject_id`) USING BTREE;

--
-- Indexes for table `student_tbl`
--
ALTER TABLE `student_tbl`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `subject_tbl`
--
ALTER TABLE `subject_tbl`
  ADD PRIMARY KEY (`subject_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student_subject_tbl`
--
ALTER TABLE `student_subject_tbl`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `address_tbl`
--
ALTER TABLE `address_tbl`
  ADD CONSTRAINT `FK7keo8rllv3vty42ih9sdjisvs` FOREIGN KEY (`id`) REFERENCES `student_tbl` (`student_id`);

--
-- Constraints for table `student_officer_tbl`
--
ALTER TABLE `student_officer_tbl`
  ADD CONSTRAINT `FKmfh3s70h2oywp23mdkh20k5fl` FOREIGN KEY (`id`) REFERENCES `student_tbl` (`student_id`);

--
-- Constraints for table `student_subject_tbl`
--
ALTER TABLE `student_subject_tbl`
  ADD CONSTRAINT `FK4wpjuxywwwsgbs32mrs9l97nm` FOREIGN KEY (`student_id`) REFERENCES `student_tbl` (`student_id`),
  ADD CONSTRAINT `FKpyny0h2ptaxu5ehwk0eim5vc8` FOREIGN KEY (`subject_id`) REFERENCES `subject_tbl` (`subject_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
