-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1:3306
-- 生成日期： 2024-06-30 03:57:53
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
-- 表的结构 `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE IF NOT EXISTS `comments` (
  `uid` int NOT NULL COMMENT '帖子编码',
  `cid` int NOT NULL DEFAULT '1' COMMENT '回复id',
  `comment` varchar(60) NOT NULL,
  `favor` int NOT NULL,
  `rid` int NOT NULL COMMENT '回复人id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rcid` int NOT NULL DEFAULT '-1' COMMENT '引用的评论id',
  PRIMARY KEY (`cid`,`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 转存表中的数据 `comments`
--

INSERT INTO `comments` (`uid`, `cid`, `comment`, `favor`, `rid`, `createTime`, `rcid`) VALUES
(1, 1, '', 0, 0, '2024-06-30 11:55:22', 0),
(1, 2, '', 0, 0, '2024-06-30 11:55:22', 0),
(2, 1, '', 0, 0, '2024-06-30 11:55:46', 0),
(2, 2, '', 0, 0, '2024-06-30 11:55:46', 0);

--
-- 触发器 `comments`
--
DROP TRIGGER IF EXISTS `increase`;
DELIMITER $$
CREATE TRIGGER `increase` BEFORE INSERT ON `comments` FOR EACH ROW BEGIN  
    DECLARE max_cid INT;  
  
    SELECT MAX(cid) INTO max_cid  
    FROM comments 
    WHERE uid = NEW.uid;  
  

    IF max_cid IS NOT NULL THEN  
        SET NEW.cid = max_cid + 1;  
    END IF;  
END
$$
DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
