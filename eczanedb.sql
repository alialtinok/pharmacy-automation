-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 30 May 2021, 15:55:42
-- Sunucu sürümü: 8.0.18
-- PHP Sürümü: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `eczanedb`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `eczane`
--

CREATE TABLE `eczane` (
  `eczaneNo` int(11) NOT NULL,
  `eczaneAdi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `personelNo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `eczane`
--

INSERT INTO `eczane` (`eczaneNo`, `eczaneAdi`, `personelNo`) VALUES
(1, 'ALTINOK ECZANESİ', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hasta`
--

CREATE TABLE `hasta` (
  `hastaNo` int(11) NOT NULL,
  `hastaAdi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `hastaDogTarih` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `hasta`
--

INSERT INTO `hasta` (`hastaNo`, `hastaAdi`, `hastaDogTarih`) VALUES
(2, 'Muhammed Ağlar', '1991-03-03'),
(3, 'Ayşe Gitmez', '1983-01-18'),
(4, 'İlkay Aydoğdu', '2001-09-22'),
(33, 'Caner Yener', '1995-11-15'),
(45, 'Gamze Ergin', '1998-05-21'),
(52, 'Mehmet Gündüz', '1878-06-22'),
(55, 'Taner Durmaz', '1993-02-03'),
(61, 'Hasan Vasdsad', '1999-10-15');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ilacduzenle`
--

CREATE TABLE `ilacduzenle` (
  `ilacNo` int(11) NOT NULL,
  `ilacAdi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `ilacFiyati` double NOT NULL,
  `firmaNo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `ilacduzenle`
--

INSERT INTO `ilacduzenle` (`ilacNo`, `ilacAdi`, `ilacFiyati`, `firmaNo`) VALUES
(1, 'Apranax', 12, 1),
(2, 'Dynabac', 9, 2),
(3, 'Dolorex', 12, 3),
(4, 'Minoset', 8, 4),
(11, 'Majezik', 6, 1),
(12, 'Minoset Plus', 12, 1),
(14, 'Parol', 15, 1),
(15, 'Minoset', 8, 1),
(16, 'Parol', 8, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ilacfirma`
--

CREATE TABLE `ilacfirma` (
  `firmaNo` int(11) NOT NULL,
  `firmaAdi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `eczaneNo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `ilacfirma`
--

INSERT INTO `ilacfirma` (`firmaNo`, `firmaAdi`, `eczaneNo`) VALUES
(1, 'PFİZER', 1),
(2, 'BAYER', 1),
(3, 'Sandoz', 1),
(4, 'ABDİ İBRAHİMl', 1),
(13, 'ROCHEE', 1),
(17, 'GEK', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ilacsatis`
--

CREATE TABLE `ilacsatis` (
  `satisNo` int(11) NOT NULL,
  `ilacNo` int(11) NOT NULL,
  `ilacAdi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `ilacFiyati` double NOT NULL,
  `hastaNo` int(11) NOT NULL,
  `hastaAdi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `islemler`
--

CREATE TABLE `islemler` (
  `isimID` int(11) NOT NULL,
  `user` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `isimAciklama` varchar(250) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `islemTutar` double NOT NULL,
  `islemTarih` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kasa`
--

CREATE TABLE `kasa` (
  `kasaNo` int(11) NOT NULL,
  `kasaToplam` double NOT NULL,
  `eczaneNo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `kul_ad` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `sifre` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `login`
--

INSERT INTO `login` (`id`, `kul_ad`, `sifre`) VALUES
(1, 'admin', '1998'),
(2, 'Ali', '1089');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personel`
--

CREATE TABLE `personel` (
  `personelNo` int(11) NOT NULL,
  `personelAdi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `personelMaas` int(11) NOT NULL,
  `eczaneNo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `personel`
--

INSERT INTO `personel` (`personelNo`, `personelAdi`, `personelMaas`, `eczaneNo`) VALUES
(1, 'Ali Altınok', 4300, 1),
(7, 'Cihan B', 2800, NULL),
(11, 'Büşra Seçkin', 3700, NULL),
(12, 'Elif G', 5000, NULL),
(16, 'Ahmet', 3500, NULL),
(17, 'Mehmet Ş', 3600, NULL),
(22, 'Kadir F', 4100, NULL),
(23, 'Veli Hasfadsf', 3200, NULL),
(24, 'Canan K', 3700, NULL),
(25, 'Fatma L', 3500, NULL);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `eczane`
--
ALTER TABLE `eczane`
  ADD PRIMARY KEY (`eczaneNo`),
  ADD KEY `personelNo` (`personelNo`);

--
-- Tablo için indeksler `hasta`
--
ALTER TABLE `hasta`
  ADD PRIMARY KEY (`hastaNo`),
  ADD KEY `hastaAdi` (`hastaAdi`);

--
-- Tablo için indeksler `ilacduzenle`
--
ALTER TABLE `ilacduzenle`
  ADD PRIMARY KEY (`ilacNo`),
  ADD KEY `ilacFiyati` (`ilacFiyati`),
  ADD KEY `ilacAdi` (`ilacAdi`),
  ADD KEY `firmaNo` (`firmaNo`),
  ADD KEY `ilacAdi_2` (`ilacAdi`);

--
-- Tablo için indeksler `ilacfirma`
--
ALTER TABLE `ilacfirma`
  ADD PRIMARY KEY (`firmaNo`),
  ADD KEY `eczaneNo` (`eczaneNo`);

--
-- Tablo için indeksler `ilacsatis`
--
ALTER TABLE `ilacsatis`
  ADD PRIMARY KEY (`satisNo`),
  ADD KEY `ilacNo` (`ilacNo`),
  ADD KEY `ilacAdi` (`ilacAdi`,`ilacFiyati`,`hastaNo`,`hastaAdi`),
  ADD KEY `ilacFiyati` (`ilacFiyati`),
  ADD KEY `hastaNo` (`hastaNo`),
  ADD KEY `hastaAdi` (`hastaAdi`);

--
-- Tablo için indeksler `islemler`
--
ALTER TABLE `islemler`
  ADD PRIMARY KEY (`isimID`);

--
-- Tablo için indeksler `kasa`
--
ALTER TABLE `kasa`
  ADD PRIMARY KEY (`kasaNo`),
  ADD KEY `eczaneNo` (`eczaneNo`);

--
-- Tablo için indeksler `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `personel`
--
ALTER TABLE `personel`
  ADD PRIMARY KEY (`personelNo`),
  ADD KEY `eczaneNo` (`eczaneNo`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `eczane`
--
ALTER TABLE `eczane`
  MODIFY `eczaneNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `hasta`
--
ALTER TABLE `hasta`
  MODIFY `hastaNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- Tablo için AUTO_INCREMENT değeri `ilacduzenle`
--
ALTER TABLE `ilacduzenle`
  MODIFY `ilacNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Tablo için AUTO_INCREMENT değeri `ilacfirma`
--
ALTER TABLE `ilacfirma`
  MODIFY `firmaNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Tablo için AUTO_INCREMENT değeri `ilacsatis`
--
ALTER TABLE `ilacsatis`
  MODIFY `satisNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- Tablo için AUTO_INCREMENT değeri `islemler`
--
ALTER TABLE `islemler`
  MODIFY `isimID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `kasa`
--
ALTER TABLE `kasa`
  MODIFY `kasaNo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `personel`
--
ALTER TABLE `personel`
  MODIFY `personelNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `eczane`
--
ALTER TABLE `eczane`
  ADD CONSTRAINT `eczane_ibfk_1` FOREIGN KEY (`personelNo`) REFERENCES `personel` (`personelNo`);

--
-- Tablo kısıtlamaları `ilacduzenle`
--
ALTER TABLE `ilacduzenle`
  ADD CONSTRAINT `ilacduzenle_ibfk_1` FOREIGN KEY (`firmaNo`) REFERENCES `ilacfirma` (`firmaNo`);

--
-- Tablo kısıtlamaları `ilacfirma`
--
ALTER TABLE `ilacfirma`
  ADD CONSTRAINT `ilacfirma_ibfk_1` FOREIGN KEY (`eczaneNo`) REFERENCES `eczane` (`eczaneNo`);

--
-- Tablo kısıtlamaları `ilacsatis`
--
ALTER TABLE `ilacsatis`
  ADD CONSTRAINT `ilacsatis_ibfk_1` FOREIGN KEY (`ilacNo`) REFERENCES `ilacduzenle` (`ilacNo`),
  ADD CONSTRAINT `ilacsatis_ibfk_2` FOREIGN KEY (`ilacAdi`) REFERENCES `ilacduzenle` (`ilacAdi`),
  ADD CONSTRAINT `ilacsatis_ibfk_3` FOREIGN KEY (`ilacFiyati`) REFERENCES `ilacduzenle` (`ilacFiyati`),
  ADD CONSTRAINT `ilacsatis_ibfk_4` FOREIGN KEY (`hastaNo`) REFERENCES `hasta` (`hastaNo`),
  ADD CONSTRAINT `ilacsatis_ibfk_5` FOREIGN KEY (`hastaAdi`) REFERENCES `hasta` (`hastaAdi`);

--
-- Tablo kısıtlamaları `kasa`
--
ALTER TABLE `kasa`
  ADD CONSTRAINT `kasa_ibfk_1` FOREIGN KEY (`eczaneNo`) REFERENCES `eczane` (`eczaneNo`);

--
-- Tablo kısıtlamaları `personel`
--
ALTER TABLE `personel`
  ADD CONSTRAINT `personel_ibfk_1` FOREIGN KEY (`eczaneNo`) REFERENCES `eczane` (`eczaneNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
