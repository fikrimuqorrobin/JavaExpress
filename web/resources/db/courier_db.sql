-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2018 at 04:01 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `courier_db`
--
CREATE DATABASE IF NOT EXISTS `courier_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `courier_db`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
`id_admin` int(1) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` text NOT NULL,
  `nama_lengkap` varchar(200) NOT NULL,
  `level` int(1) NOT NULL,
  `created_by` int(10) NOT NULL,
  `updated_by` int(10) NOT NULL,
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`, `nama_lengkap`, `level`, `created_by`, `updated_by`, `created_time`, `updated_time`, `status`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'ADMIN', 1, 1, 1, '2017-12-28 11:23:30', '2017-12-28 11:23:30', 1),
(2, 'fikri', '5d4864249b21de08642aa6ff4178b346', 'Fikri', 2, 1, 1, '2017-12-29 14:14:10', '2017-12-29 14:14:10', 1),
(3, 'naufal', 'a7ef174d3ed272acd2b72913a7ef9d40', 'Naufal Eka', 2, 1, 1, '2017-12-30 15:49:59', '2017-12-30 15:49:59', 1),
(4, 'dian', 'f97de4a9986d216a6e0fea62b0450da9', 'Dian Setyadi', 2, 1, 1, '2017-12-30 15:50:16', '2017-12-30 15:50:16', 1),
(5, 'agas', '215b401f60fafd39ce86a7109ac71ed0', 'Gangzar Agas', 2, 1, 1, '2017-12-30 15:50:39', '2017-12-30 15:50:39', 1),
(6, 'bima', '7fcba392d4dcca33791a44cd892b2112', 'Bima Sebayang', 2, 1, 1, '2017-12-30 15:50:50', '2017-12-30 15:50:50', 1),
(7, 'naufal', 'a7ef174d3ed272acd2b72913a7ef9d40', 'Naufal', 2, 1, 1, '2018-01-01 21:15:50', '2018-01-01 21:15:50', 1);

-- --------------------------------------------------------

--
-- Table structure for table `kota`
--

DROP TABLE IF EXISTS `kota`;
CREATE TABLE IF NOT EXISTS `kota` (
`kode_kota` int(10) NOT NULL,
  `nama_kota` varchar(100) NOT NULL,
  `kode_provinsi` int(10) NOT NULL,
  `created_by` int(10) NOT NULL,
  `updated_by` int(10) NOT NULL,
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kota`
--

INSERT INTO `kota` (`kode_kota`, `nama_kota`, `kode_provinsi`, `created_by`, `updated_by`, `created_time`, `updated_time`, `status`) VALUES
(3, 'Tangerang Selatan', 1, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(4, 'Jakarta Barat', 2, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(5, 'Jakarta Selatan', 2, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(6, 'Jakarta Timur', 2, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(7, 'Jakarta Pusat', 2, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(8, 'Jakarta Utara', 2, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(9, 'Bandung', 3, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(10, 'Bekasi', 3, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(11, 'Cirebon', 3, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(12, 'Semarang', 4, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(13, 'Surabaya', 5, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(14, 'Madiun', 5, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(15, 'Salatiga', 4, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(18, 'Bogor', 3, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(20, 'Depok', 3, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(21, 'Sukabumi', 3, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(22, 'Banjar', 3, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(23, 'Cimahi', 3, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(24, 'Tasikmalaya', 3, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(25, 'Magelang', 4, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(26, 'Pekalongan', 4, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(27, 'Surakarta', 4, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(28, 'Tegal', 4, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(29, 'Cilegon', 1, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(30, 'Serang', 1, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(31, 'Tangerang', 1, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(32, 'Yogyakarta', 6, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(33, 'Batu', 5, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(34, 'Blitar', 5, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(35, 'Kediri', 5, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(36, 'Malang', 5, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(37, 'Mojokerto', 5, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(38, 'Pasuruan', 5, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1),
(39, 'Probolinggo', 5, 1, 1, '2017-12-28 15:04:01', '2017-12-28 15:04:02', 1);

-- --------------------------------------------------------

--
-- Table structure for table `level_admin`
--

DROP TABLE IF EXISTS `level_admin`;
CREATE TABLE IF NOT EXISTS `level_admin` (
`id_level` int(1) NOT NULL,
  `level` varchar(50) NOT NULL,
  `created_by` int(10) NOT NULL,
  `updated_by` int(10) NOT NULL,
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `level_admin`
--

INSERT INTO `level_admin` (`id_level`, `level`, `created_by`, `updated_by`, `created_time`, `updated_time`, `status`) VALUES
(1, 'Master', 1, 1, '2017-12-28 13:33:22', '2017-12-28 13:33:22', 1),
(2, 'Staff', 1, 1, '2017-12-28 13:33:24', '2017-12-28 13:33:24', 1);

-- --------------------------------------------------------

--
-- Table structure for table `pengiriman`
--

DROP TABLE IF EXISTS `pengiriman`;
CREATE TABLE IF NOT EXISTS `pengiriman` (
`id_pengiriman` int(100) NOT NULL,
  `nama_pengirim` varchar(200) NOT NULL,
  `telepon_pengirim` varchar(13) NOT NULL,
  `kota_pengirim` int(10) NOT NULL,
  `alamat_pengirim` text NOT NULL,
  `nama_penerima` varchar(200) NOT NULL,
  `telepon_penerima` varchar(13) NOT NULL,
  `kota_penerima` int(10) NOT NULL,
  `alamat_penerima` text NOT NULL,
  `tipe_paket` varchar(50) NOT NULL,
  `nama_paket` varchar(200) NOT NULL,
  `berat_barang` int(10) NOT NULL,
  `asuransi` char(1) DEFAULT NULL,
  `harga_barang` decimal(10,2) DEFAULT NULL,
  `jenis_layanan` varchar(50) NOT NULL,
  `tarif` int(10) NOT NULL,
  `total_tarif` decimal(10,2) NOT NULL,
  `no_resi` varchar(100) NOT NULL,
  `created_by` int(10) NOT NULL,
  `updated_by` int(10) NOT NULL,
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengiriman`
--

INSERT INTO `pengiriman` (`id_pengiriman`, `nama_pengirim`, `telepon_pengirim`, `kota_pengirim`, `alamat_pengirim`, `nama_penerima`, `telepon_penerima`, `kota_penerima`, `alamat_penerima`, `tipe_paket`, `nama_paket`, `berat_barang`, `asuransi`, `harga_barang`, `jenis_layanan`, `tarif`, `total_tarif`, `no_resi`, `created_by`, `updated_by`, `created_time`, `updated_time`, `status`) VALUES
(8, 'coba', 'coba', 4, 'coba', 'coba', 'coba', 3, 'coba', 'coba', 'coba', 2, 'T', '10000.00', 'ons', 8, '64000.00', '3apajaboleh4', 1, 1, '2017-12-29 16:52:56', '2017-12-29 16:52:58', 1),
(10, 'Bima Satrya Sebayang', '087768339292', 12, 'Jln. Calon Mantu yang Nggak Jadi', 'Bapak Muhajidin', '08120100203', 6, 'Jln. Mertua Tak Sampai', 'Dokumen', 'Mobil Mewah Tapi Bo''ong', 3, 'T', '12000.00', 'reguler', 5, '10350.00', '6apajaboleh12', 1, 1, '2017-12-29 17:13:07', '2017-12-29 17:13:08', 1),
(12, 'Bima Satrya Sebayang', '087768339292', 10, 'Jln. Calon Mantu yang Nggak Jadi', 'Bapak Muhajidin', '08120100203', 5, 'Jln. Mertua Tak Sampai', 'Dokumen', 'Mobil Mewah Tapi Bo''ong', 3, 'T', '12000.00', 'reguler', 1, '13500.00', '5apajaboleh10', 1, 1, '2017-12-29 17:14:12', '2017-12-29 17:14:14', 1);

-- --------------------------------------------------------

--
-- Table structure for table `provinsi`
--

DROP TABLE IF EXISTS `provinsi`;
CREATE TABLE IF NOT EXISTS `provinsi` (
`kode_provinsi` int(10) NOT NULL,
  `nama_provinsi` varchar(100) NOT NULL,
  `created_by` int(10) NOT NULL,
  `updated_by` int(10) NOT NULL,
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `provinsi`
--

INSERT INTO `provinsi` (`kode_provinsi`, `nama_provinsi`, `created_by`, `updated_by`, `created_time`, `updated_time`, `status`) VALUES
(1, 'Banten', 1, 1, '2017-12-28 15:01:36', '2017-12-28 15:01:37', 1),
(2, 'DKI Jakarta', 1, 1, '2017-12-28 15:01:36', '2017-12-28 15:01:37', 1),
(3, 'Jawa Barat', 1, 1, '2017-12-28 15:01:36', '2017-12-28 15:01:37', 1),
(4, 'Jawa Tengah', 1, 1, '2017-12-28 15:01:36', '2017-12-28 15:01:37', 1),
(5, 'Jawa Timur', 1, 1, '2017-12-28 15:01:36', '2017-12-28 15:01:37', 1),
(6, 'DI Yogyakarta', 1, 1, '2017-12-28 15:01:36', '2017-12-28 15:01:37', 1);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE IF NOT EXISTS `status` (
`id_status` int(1) NOT NULL,
  `status` varchar(100) NOT NULL,
  `created_by` int(10) NOT NULL,
  `updated_by` int(10) NOT NULL,
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id_status`, `status`, `created_by`, `updated_by`, `created_time`, `updated_time`) VALUES
(1, 'Aktif', 1, 1, '2017-12-28 13:33:22', '2017-12-28 13:33:22'),
(2, 'Tidak Aktif', 1, 1, '2017-12-28 13:33:23', '2017-12-28 13:33:23');

-- --------------------------------------------------------

--
-- Table structure for table `tarif`
--

DROP TABLE IF EXISTS `tarif`;
CREATE TABLE IF NOT EXISTS `tarif` (
`id_tarif` int(10) NOT NULL,
  `kota_asal` int(10) NOT NULL,
  `kota_tujuan` int(10) NOT NULL,
  `reguler` decimal(10,2) NOT NULL,
  `kilat` decimal(10,2) NOT NULL,
  `ons` decimal(10,2) NOT NULL,
  `sds` decimal(10,2) NOT NULL,
  `hds` decimal(10,2) NOT NULL,
  `created_by` int(10) NOT NULL,
  `updated_by` int(10) NOT NULL,
  `created_time` datetime NOT NULL,
  `updated_time` datetime NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tarif`
--

INSERT INTO `tarif` (`id_tarif`, `kota_asal`, `kota_tujuan`, `reguler`, `kilat`, `ons`, `sds`, `hds`, `created_by`, `updated_by`, `created_time`, `updated_time`, `status`) VALUES
(1, 5, 10, '4500.00', '12000.00', '23500.00', '46700.00', '78900.00', 1, 1, '2017-12-29 09:11:40', '2017-12-29 09:11:40', 1),
(2, 9, 27, '6000.00', '19300.00', '34500.00', '45500.00', '79800.00', 1, 1, '2017-12-29 09:13:09', '2017-12-29 09:13:09', 1),
(3, 29, 30, '9000.00', '23400.00', '38900.00', '56000.00', '890000.00', 1, 1, '2017-12-29 09:21:15', '2017-12-29 09:21:15', 1),
(4, 5, 21, '6790.00', '12450.00', '32900.00', '65770.00', '89800.00', 1, 1, '2017-12-29 12:45:27', '2017-12-29 12:45:27', 1),
(5, 6, 12, '3450.00', '9900.00', '23990.00', '45000.00', '123000.00', 1, 1, '2017-12-29 13:39:15', '2017-12-29 13:39:15', 1),
(6, 4, 9, '10000.00', '12500.00', '15000.00', '17500.00', '20000.00', 1, 1, '2017-12-29 14:40:29', '2017-12-29 14:40:29', 1),
(7, 9, 4, '10000.00', '12500.00', '15000.00', '17500.00', '20000.00', 1, 1, '2017-12-29 00:00:00', '2017-12-29 00:00:00', 1),
(8, 3, 4, '3210.00', '11200.00', '32000.00', '67700.00', '109000.00', 1, 1, '2017-12-29 15:58:40', '2017-12-29 15:58:40', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tracking`
--

DROP TABLE IF EXISTS `tracking`;
CREATE TABLE IF NOT EXISTS `tracking` (
`id_tracking` int(100) NOT NULL,
  `kode_pengiriman` int(100) NOT NULL,
  `status_pengiriman` varchar(50) NOT NULL,
  `created_by` int(10) NOT NULL,
  `updated_by` int(10) NOT NULL,
  `created_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`id_admin`), ADD KEY `level` (`level`), ADD KEY `created_by` (`created_by`,`updated_by`,`status`), ADD KEY `status` (`status`), ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `kota`
--
ALTER TABLE `kota`
 ADD PRIMARY KEY (`kode_kota`), ADD KEY `kode_provinsi` (`kode_provinsi`), ADD KEY `created_by` (`created_by`,`updated_by`), ADD KEY `created_by_2` (`created_by`), ADD KEY `update_by` (`updated_by`), ADD KEY `status` (`status`);

--
-- Indexes for table `level_admin`
--
ALTER TABLE `level_admin`
 ADD PRIMARY KEY (`id_level`), ADD KEY `created_by` (`created_by`,`updated_by`,`status`), ADD KEY `status` (`status`), ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `pengiriman`
--
ALTER TABLE `pengiriman`
 ADD PRIMARY KEY (`id_pengiriman`), ADD UNIQUE KEY `no_resi` (`no_resi`), ADD KEY `kota_pengirim` (`kota_pengirim`,`kota_penerima`,`tarif`), ADD KEY `created_by` (`created_by`,`updated_by`,`status`), ADD KEY `kota_penerima` (`kota_penerima`), ADD KEY `tarif` (`tarif`), ADD KEY `status` (`status`), ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `provinsi`
--
ALTER TABLE `provinsi`
 ADD PRIMARY KEY (`kode_provinsi`), ADD KEY `created_by` (`created_by`,`updated_by`), ADD KEY `created_by_2` (`created_by`), ADD KEY `update_by` (`updated_by`), ADD KEY `status` (`status`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
 ADD PRIMARY KEY (`id_status`), ADD KEY `created_by` (`created_by`,`updated_by`), ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `tarif`
--
ALTER TABLE `tarif`
 ADD PRIMARY KEY (`id_tarif`), ADD KEY `kota_asal` (`kota_asal`), ADD KEY `kota_tujuan` (`kota_tujuan`), ADD KEY `created_by` (`created_by`,`updated_by`,`status`), ADD KEY `status` (`status`), ADD KEY `updated_by` (`updated_by`);

--
-- Indexes for table `tracking`
--
ALTER TABLE `tracking`
 ADD PRIMARY KEY (`id_tracking`), ADD KEY `kode_pengiriman` (`kode_pengiriman`), ADD KEY `created_by` (`created_by`,`updated_by`), ADD KEY `status` (`status`), ADD KEY `updated_by` (`updated_by`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
MODIFY `id_admin` int(1) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `kota`
--
ALTER TABLE `kota`
MODIFY `kode_kota` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `level_admin`
--
ALTER TABLE `level_admin`
MODIFY `id_level` int(1) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pengiriman`
--
ALTER TABLE `pengiriman`
MODIFY `id_pengiriman` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `provinsi`
--
ALTER TABLE `provinsi`
MODIFY `kode_provinsi` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
MODIFY `id_status` int(1) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tarif`
--
ALTER TABLE `tarif`
MODIFY `id_tarif` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tracking`
--
ALTER TABLE `tracking`
MODIFY `id_tracking` int(100) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`level`) REFERENCES `level_admin` (`id_level`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `admin_ibfk_2` FOREIGN KEY (`status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `admin_ibfk_3` FOREIGN KEY (`created_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `admin_ibfk_4` FOREIGN KEY (`updated_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `kota`
--
ALTER TABLE `kota`
ADD CONSTRAINT `kota_ibfk_1` FOREIGN KEY (`kode_provinsi`) REFERENCES `provinsi` (`kode_provinsi`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `kota_ibfk_2` FOREIGN KEY (`status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `kota_ibfk_3` FOREIGN KEY (`created_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `kota_ibfk_4` FOREIGN KEY (`updated_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `level_admin`
--
ALTER TABLE `level_admin`
ADD CONSTRAINT `level_admin_ibfk_1` FOREIGN KEY (`status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `level_admin_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `level_admin_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `pengiriman`
--
ALTER TABLE `pengiriman`
ADD CONSTRAINT `pengiriman_ibfk_1` FOREIGN KEY (`kota_pengirim`) REFERENCES `kota` (`kode_kota`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `pengiriman_ibfk_2` FOREIGN KEY (`kota_penerima`) REFERENCES `kota` (`kode_kota`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `pengiriman_ibfk_3` FOREIGN KEY (`tarif`) REFERENCES `tarif` (`id_tarif`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `pengiriman_ibfk_4` FOREIGN KEY (`status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `pengiriman_ibfk_5` FOREIGN KEY (`created_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `pengiriman_ibfk_6` FOREIGN KEY (`updated_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `provinsi`
--
ALTER TABLE `provinsi`
ADD CONSTRAINT `provinsi_ibfk_1` FOREIGN KEY (`status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `provinsi_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `provinsi_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `status`
--
ALTER TABLE `status`
ADD CONSTRAINT `status_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `status_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `tarif`
--
ALTER TABLE `tarif`
ADD CONSTRAINT `tarif_ibfk_1` FOREIGN KEY (`status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `tarif_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `tarif_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `tarif_ibfk_4` FOREIGN KEY (`kota_asal`) REFERENCES `kota` (`kode_kota`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `tarif_ibfk_5` FOREIGN KEY (`kota_tujuan`) REFERENCES `kota` (`kode_kota`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `tracking`
--
ALTER TABLE `tracking`
ADD CONSTRAINT `tracking_ibfk_1` FOREIGN KEY (`kode_pengiriman`) REFERENCES `pengiriman` (`id_pengiriman`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `tracking_ibfk_2` FOREIGN KEY (`status`) REFERENCES `status` (`id_status`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `tracking_ibfk_3` FOREIGN KEY (`created_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `tracking_ibfk_4` FOREIGN KEY (`updated_by`) REFERENCES `admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
