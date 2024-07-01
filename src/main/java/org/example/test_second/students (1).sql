-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1:3306
-- 生成日期： 2024-06-29 06:01:39
-- 服务器版本： 8.0.31
-- PHP 版本： 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `school`
--

-- --------------------------------------------------------

--
-- 表的结构 `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
                                          `id` int NOT NULL AUTO_INCREMENT,
                                          `studentID` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `name` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `nickName` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `country` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `province` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `city` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `gender` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `political` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `education` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `dormitory` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `interests` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                          `birthday` date NOT NULL,
                                          `fileData` longblob NOT NULL,
                                          PRIMARY KEY (`id`),
                                          UNIQUE KEY `学号` (`studentID`)
) ENGINE=MyISAM AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 转存表中的数据 `students`
--

INSERT INTO `students` (`id`, `studentID`, `name`, `phone`, `password`, `nickName`, `country`, `province`, `city`, `gender`, `political`, `education`, `dormitory`, `interests`, `birthday`, `fileData`) VALUES
                                                                                                                                                                                                             (1, '20240001', '徐灵壹', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (2, '20240002', '胡灵贰', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (3, '20240003', '赵灵杉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (4, '20240004', '王灵诗', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (5, '20240005', '徐灵雾', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (6, '20240006', '胡灵琉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (7, '20240007', '赵灵琦', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (8, '20240008', '王灵捌', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (9, '20240009', '徐灵鸠', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (10, '20240010', '胡壹灵', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (11, '20240011', '赵壹壹', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (12, '20240012', '王壹贰', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (13, '20240013', '徐壹杉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (14, '20240014', '胡壹诗', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (15, '20240015', '赵壹雾', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (16, '20240016', '王壹琉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (17, '20240017', '徐壹琦', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (18, '20240018', '胡壹捌', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (19, '20240019', '赵壹鸠', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (20, '20240020', '王贰灵', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (21, '20240021', '徐贰壹', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (22, '20240022', '胡贰贰', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (23, '20240023', '赵贰杉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (24, '20240024', '王贰诗', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (25, '20240025', '徐贰雾', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (26, '20240026', '胡贰琉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (27, '20240027', '赵贰琦', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (28, '20240028', '王贰捌', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (29, '20240029', '徐贰鸠', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (30, '20240030', '胡杉灵', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (31, '20240031', '赵杉壹', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (32, '20240032', '王杉贰', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (33, '20240033', '徐杉杉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (34, '20240034', '胡杉诗', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (35, '20240035', '赵杉雾', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (36, '20240036', '王杉琉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (37, '20240037', '徐杉琦', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (38, '20240038', '胡杉捌', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (39, '20240039', '赵杉鸠', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (40, '20240040', '王诗灵', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (41, '20240041', '徐诗壹', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (42, '20240042', '胡诗贰', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (43, '20240043', '赵诗杉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (44, '20240044', '王诗诗', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (45, '20240045', '徐诗雾', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (46, '20240046', '胡诗琉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (47, '20240047', '赵诗琦', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (48, '20240048', '王诗捌', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (49, '20240049', '徐诗鸠', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (50, '20240050', '胡雾灵', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (51, '20240051', '赵雾壹', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (52, '20240052', '王雾贰', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (53, '20240053', '徐雾杉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (54, '20240054', '胡雾诗', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (55, '20240055', '赵雾雾', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (56, '20240056', '王雾琉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (57, '20240057', '徐雾琦', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (58, '20240058', '胡雾捌', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (59, '20240059', '赵雾鸠', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (60, '20240060', '王琉灵', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (61, '20240061', '徐琉壹', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (62, '20240062', '胡琉贰', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (63, '20240063', '赵琉杉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (64, '20240064', '王琉诗', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (65, '20240065', '徐琉雾', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (66, '20240066', '胡琉琉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (67, '20240067', '赵琉琦', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (68, '20240068', '王琉捌', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (69, '20240069', '徐琉鸠', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (70, '20240070', '胡琦灵', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (71, '20240071', '赵琦壹', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (72, '20240072', '王琦贰', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (73, '20240073', '徐琦杉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (74, '20240074', '胡琦诗', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (75, '20240075', '赵琦雾', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (76, '20240076', '王琦琉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (77, '20240077', '徐琦琦', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (78, '20240078', '胡琦捌', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (79, '20240079', '赵琦鸠', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (80, '20240080', '王捌灵', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (81, '20240081', '徐捌壹', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (82, '20240082', '胡捌贰', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (83, '20240083', '赵捌杉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (84, '20240084', '王捌诗', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (85, '20240085', '徐捌雾', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (86, '20240086', '胡捌琉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (87, '20240087', '赵捌琦', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (88, '20240088', '王捌捌', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (89, '20240089', '徐捌鸠', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (90, '20240090', '胡鸠灵', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (91, '20240091', '赵鸠壹', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (92, '20240092', '王鸠贰', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (93, '20240093', '徐鸠杉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (94, '20240094', '胡鸠诗', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (95, '20240095', '赵鸠雾', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (96, '20240096', '王鸠琉', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (97, '20240097', '徐鸠琦', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (98, '20240098', '胡鸠捌', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', ''),
                                                                                                                                                                                                             (99, '20240099', '赵鸠鸠', '', '', '', '', '', '', '', '', '', '', '', '0000-00-00', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

