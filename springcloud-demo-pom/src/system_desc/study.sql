/*
Navicat MySQL Data Transfer

Source Server         : study_personal
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-11-07 16:21:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data_type_standard
-- ----------------------------
DROP TABLE IF EXISTS `data_type_standard`;
CREATE TABLE `data_type_standard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `int_test` int(11) DEFAULT NULL,
  `tinyint_test` tinyint(4) DEFAULT NULL,
  `smallint_test` smallint(6) DEFAULT NULL,
  `mediumint_test` mediumint(9) DEFAULT NULL,
  `bigint_test` bigint(20) DEFAULT NULL,
  `integer_test` int(11) DEFAULT NULL,
  `float_test` float DEFAULT NULL,
  `double_test` double DEFAULT NULL,
  `char_test` char(255) DEFAULT NULL,
  `varchar_test` varchar(255) DEFAULT NULL,
  `decimal_test` decimal(10,0) DEFAULT NULL,
  `numeric_test` decimal(10,0) DEFAULT NULL,
  `year_test` year(4) DEFAULT NULL,
  `date_test` date DEFAULT NULL,
  `time_test` time DEFAULT NULL,
  `datatime_test` datetime DEFAULT NULL,
  `timestamp_test` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_id` bigint(20) DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_test_table_create_bigdecimal` (`decimal_test`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for data_type_study
-- ----------------------------
DROP TABLE IF EXISTS `data_type_study`;
CREATE TABLE `data_type_study` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表id',
  `tinyint_t_1` tinyint(4) DEFAULT NULL COMMENT '1个字节  范围(-128~127)',
  `smallint_t_2` smallint(6) DEFAULT NULL COMMENT '2个字节  范围(-32768~32767)',
  `mediumint_t_3` mediumint(9) DEFAULT NULL COMMENT '3个字节  范围(-8388608~8388607)',
  `int_t_4` int(11) DEFAULT NULL COMMENT '4个字节  范围(-2147483648~2147483647)',
  `integer_t_4` int(11) DEFAULT NULL COMMENT '4个字节  范围(-2147483648~2147483647)',
  `bigint_t_8` bigint(20) DEFAULT NULL COMMENT '8个字节  范围(+-9.22*10的18次方)',
  `float_t_4` float DEFAULT NULL COMMENT '单精度浮点型    8位精度(4字节)     m总个数，d小数位',
  `double_t_8` double DEFAULT NULL COMMENT '双精度浮点型    16位精度(8字节)    m总个数，d小数位',
  `decimal_t_M2D2` decimal(10,0) DEFAULT NULL COMMENT '浮点型在数据库中存放的是近似值，而定点类型在数据库中存放的是精确值。\r\ndecimal(m,d) 参数 m<65 是总个数，d<30 且 d<m 是小数位。',
  `date_yyyy_mm_dd_3` date DEFAULT NULL COMMENT '日期 ''2008-12-2''',
  `time_hh_mm_ss_3` time DEFAULT NULL COMMENT '时间 ''12:25:36''',
  `year_yyyy_1` year(4) DEFAULT NULL COMMENT '1901/2155',
  `datetime_yyyy_mm_dd_hh_mm_ss_8` datetime DEFAULT NULL COMMENT '日期时间 ''2008-12-2 22:06:44''',
  `timestamp_yyyymmddhhmmss_4` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '自动存储记录修改时间',
  `char_255` char(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '固定长度，最多255个字符\r\n\r\n.char(n) 若存入字符数小于n，则以空格补于其后，查询之时再将空格去掉。所以 char 类型存储的字符串末尾不能有空格，varchar 不限于此。',
  `varchar_65535` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '可变长度，最多65535个字符\r\n\r\n 2.char(n) 固定长度，char(4) 不管是存入几个字符，都将占用 4 个字节，varchar 是存入的实际字符数 +1 个字节（n<=255）或2个字节(n>255)，所以 varchar(4),存入 3 个字符将占用 4 个字节。',
  `tinyblob_255` tinyblob COMMENT '可变长度，最多255个字符',
  `tinytext_255` tinytext CHARACTER SET utf8 COLLATE utf8_bin COMMENT '可变长度，最多65535个字符',
  `blob_65535` blob COMMENT '0-65 535字节',
  `text_65535` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '0-65 535字节\r\n.varchar 可指定 n，text 不能指定，内部存储 varchar 是存入的实际字符数 +1 个字节（n<=255）或 2 个字节(n>255)，text 是实际字符数 +2 个字节。\r\ntext 类型不能有默认值。\r\n\r\nvarchar 可直接创建索引，text 创建索引要指定前多少个字符。varchar 查询速度快于 text, 在都创建索引的情况下，text 的索引似乎不起作用。',
  `mediumblob_16777215` mediumblob COMMENT '0-16 777 215字节',
  `mediumtext_16777215` mediumtext CHARACTER SET utf8 COLLATE utf8_bin COMMENT '可变长度，最多2的24次方-1个字符',
  `longblob_4294967295` longblob COMMENT '0-4 294 967 295字节',
  `longtext_4294967295` longtext CHARACTER SET utf8 COLLATE utf8_bin COMMENT '0-4 294 967 295字节,可变长度，最多2的32次方-1个字符',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for factor
-- ----------------------------
DROP TABLE IF EXISTS `factor`;
CREATE TABLE `factor` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'factor_id ',
  `model_id` bigint(11) DEFAULT NULL COMMENT '模型id',
  `factor_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'factor 名称',
  `factor_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'factor 编码',
  `create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `yn` tinyint(4) DEFAULT NULL COMMENT '是否有效  0---有效   1---无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for html_demo
-- ----------------------------
DROP TABLE IF EXISTS `html_demo`;
CREATE TABLE `html_demo` (
  `id` bigint(20) NOT NULL,
  `html_text` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `html_select` int(11) DEFAULT NULL,
  `html_checkbox` int(11) DEFAULT NULL,
  `html_radio` int(11) DEFAULT NULL,
  `html_textarea` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `html_password` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `html_status` int(4) DEFAULT NULL,
  `html_starttime` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `html_endtime` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for math
-- ----------------------------
DROP TABLE IF EXISTS `math`;
CREATE TABLE `math` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `factor_id` bigint(20) DEFAULT NULL COMMENT 'factor_id',
  `column_1` decimal(4,2) DEFAULT NULL COMMENT '第一列',
  `column_2` decimal(4,2) DEFAULT NULL COMMENT '第二列',
  `column_3` decimal(4,2) DEFAULT NULL COMMENT '第三列',
  `math_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '计算方法code',
  `math_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '计算方法名称',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for model
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `model_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '模型名',
  `model_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '模型code',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `yn` tinyint(4) DEFAULT NULL COMMENT '是否有效   0---有效   1---无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for model_des
-- ----------------------------
DROP TABLE IF EXISTS `model_des`;
CREATE TABLE `model_des` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `model_id` bigint(20) DEFAULT NULL COMMENT 'mode_id ',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '描述信息',
  `update_user` datetime DEFAULT NULL COMMENT '更新人',
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `yn` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ukey` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Procedure structure for pro3
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro3`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pro3`(INOUT var3 int)
begin
	-- 查看该过程传入的三个变量
	select var3;
	select count(*) into var3 from orders;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pro4
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro4`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pro4`(in var1 int,out var2 int,INOUT var3 int)
begin
	-- 查看该过程传入的三个变量
	select var1,var2,var3;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pro5
-- ----------------------------
DROP PROCEDURE IF EXISTS `pro5`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pro5`(in var1 int, out var2 int, inout var3 int)
begin
	-- 查看该过程传入的三个变量
	select var1, var2, var3;
	-- 修改局部变量
	set var1 = 10;
	set var2 = 20;
	set var3 = 30;
	-- 查看局部变量
	select var1, var2, var3;
	-- 查看全局变量
	select @var1, @var2, @var3;	
	-- 修改全局变量
-- 	set @var1 = 'a';
-- 	set @var2 = 'b';
-- 	set @var3 = 'c';
	-- 查看全局变量
	select @var1, @var2, @var3;		
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for addAll
-- ----------------------------
DROP FUNCTION IF EXISTS `addAll`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `addAll`(num int) RETURNS int(11)
begin
	-- 定义条件变量
	set @i = 1;
	set @res = 0;    -- 保存求和结果
	-- 循环求和
	while @i <= num do
		-- 任何变量想要修改值都必须使用 set 关键字，且 MySQL 中没有 += 或者 ++ 运算符
		INSERT INTO `study`.`my_class` (`class_name`, `class_num`, `class_des`) VALUES ('数据结构', '15', '测试课程');
    INSERT INTO `study`.`my_stu` (`name`, `age`, `class_id`) VALUES ('王五', '34', @i);
		set @res = @res + @i;
		-- 修改循环变量
		set @i = @i + 1;
	end while;
	-- 返回求和结果
	return @res;
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for addAll2
-- ----------------------------
DROP FUNCTION IF EXISTS `addAll2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `addAll2`(num int) RETURNS int(11)
begin
	-- 声明变量，包含循环变量和结果变量
	declare i int default 1;    -- 定义局部变量可以含有属性
	declare res int default 0;
	-- 循环求和
	mywhile:while i <= num do
		-- 条件判断
		if i % 10 = 0 then
			-- 修改循环变量
			set i = i + 1;
			-- 重新循环
			iterate mywhile;
		end if;
		-- 修改结果变量
		set res = res + i;
		-- 修改循环变量
		set i = i + 1;
	end while;
	-- 返回求和结果
	return res;
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for addDatas
-- ----------------------------
DROP FUNCTION IF EXISTS `addDatas`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `addDatas`(num int) RETURNS int(11)
begin
	-- 定义条件变量
	set @i = 1;
	-- 循环求和
	while @i <= num do
		-- 任何变量想要修改值都必须使用 set 关键字，且 MySQL 中没有 += 或者 ++ 运算符
		INSERT INTO `study`.`test_table_create` (`int_test`, `tinyint_test`, `smallint_test`, `mediumint_test`, `bigint_test`, `integer_test`, `float_test`, `double_test`, `char_test`, `varchar_test`, `decimal_test`, `numeric_test`, `year_test`, `date_test`, `time_test`, `datatime_test`, `timestamp_test`, `create_user`, `create_id`, `create_time`, `update_user`, `update_id`, `update_time`) VALUES ('999975', NULL, NULL, '999975', '999975', '999975', '999976', '999976', 'char999975', 'varchar999975', '90999975', NULL, '2019', '2019-08-15', '10:29:30', '2019-08-15 10:29:30', '2019-08-15 10:29:30', '胡波', '999975', '2019-08-15 18:29:30', '胡波', '999975', '2019-08-15 18:29:30');
		-- 修改循环变量
		set @i = @i + 1;
	end while;
	-- 返回求和结果
	RETURN @i;
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for showLove
-- ----------------------------
DROP FUNCTION IF EXISTS `showLove`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `showLove`() RETURNS int(11)
return 521
;;
DELIMITER ;
