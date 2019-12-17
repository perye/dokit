/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : dokit

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 17/12/2019 17:54:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alipay_config
-- ----------------------------
DROP TABLE IF EXISTS `alipay_config`;
CREATE TABLE `alipay_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_id` varchar(255) DEFAULT NULL COMMENT '应用ID',
  `charset` varchar(255) DEFAULT NULL COMMENT '编码',
  `format` varchar(255) DEFAULT NULL COMMENT '类型 固定格式json',
  `gateway_url` varchar(255) DEFAULT NULL COMMENT '网关地址',
  `notify_url` varchar(255) DEFAULT NULL COMMENT '异步回调',
  `private_key` text COMMENT '私钥',
  `public_key` text COMMENT '公钥',
  `return_url` varchar(255) DEFAULT NULL COMMENT '回调地址',
  `sign_type` varchar(255) DEFAULT NULL COMMENT '签名方式',
  `sys_service_provider_id` varchar(255) DEFAULT NULL COMMENT '商户号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of alipay_config
-- ----------------------------
BEGIN;
INSERT INTO `alipay_config` VALUES (1, '2016091700532697', 'utf-8', 'JSON', 'https://openapi.alipaydev.com/gateway.do', 'http://api.auauz.net/api/aliPay/notify', 'MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC5js8sInU10AJ0cAQ8UMMyXrQ+oHZEkVt5lBwsStmTJ7YikVYgbskx1YYEXTojRsWCb+SH/kDmDU4pK/u91SJ4KFCRMF2411piYuXU/jF96zKrADznYh/zAraqT6hvAIVtQAlMHN53nx16rLzZ/8jDEkaSwT7+HvHiS+7sxSojnu/3oV7BtgISoUNstmSe8WpWHOaWv19xyS+Mce9MY4BfseFhzTICUymUQdd/8hXA28/H6osUfAgsnxAKv7Wil3aJSgaJczWuflYOve0dJ3InZkhw5Cvr0atwpk8YKBQjy5CdkoHqvkOcIB+cYHXJKzOE5tqU7inSwVbHzOLQ3XbnAgMBAAECggEAVJp5eT0Ixg1eYSqFs9568WdetUNCSUchNxDBu6wxAbhUgfRUGZuJnnAll63OCTGGck+EGkFh48JjRcBpGoeoHLL88QXlZZbC/iLrea6gcDIhuvfzzOffe1RcZtDFEj9hlotg8dQj1tS0gy9pN9g4+EBH7zeu+fyv+qb2e/v1l6FkISXUjpkD7RLQr3ykjiiEw9BpeKb7j5s7Kdx1NNIzhkcQKNqlk8JrTGDNInbDM6inZfwwIO2R1DHinwdfKWkvOTODTYa2MoAvVMFT9Bec9FbLpoWp7ogv1JMV9svgrcF9XLzANZ/OQvkbe9TV9GWYvIbxN6qwQioKCWO4GPnCAQKBgQDgW5MgfhX8yjXqoaUy/d1VjI8dHeIyw8d+OBAYwaxRSlCfyQ+tieWcR2HdTzPca0T0GkWcKZm0ei5xRURgxt4DUDLXNh26HG0qObbtLJdu/AuBUuCqgOiLqJ2f1uIbrz6OZUHns+bT/jGW2Ws8+C13zTCZkZt9CaQsrp3QOGDx5wKBgQDTul39hp3ZPwGNFeZdkGoUoViOSd5Lhowd5wYMGAEXWRLlU8z+smT5v0POz9JnIbCRchIY2FAPKRdVTICzmPk2EPJFxYTcwaNbVqL6lN7J2IlXXMiit5QbiLauo55w7plwV6LQmKm9KV7JsZs5XwqF7CEovI7GevFzyD3w+uizAQKBgC3LY1eRhOlpWOIAhpjG6qOoohmeXOphvdmMlfSHq6WYFqbWwmV4rS5d/6LNpNdL6fItXqIGd8I34jzql49taCmi+A2nlR/E559j0mvM20gjGDIYeZUz5MOE8k+K6/IcrhcgofgqZ2ZED1ksHdB/E8DNWCswZl16V1FrfvjeWSNnAoGAMrBplCrIW5xz+J0Hm9rZKrs+AkK5D4fUv8vxbK/KgxZ2KaUYbNm0xv39c+PZUYuFRCz1HDGdaSPDTE6WeWjkMQd5mS6ikl9hhpqFRkyh0d0fdGToO9yLftQKOGE/q3XUEktI1XvXF0xyPwNgUCnq0QkpHyGVZPtGFxwXiDvpvgECgYA5PoB+nY8iDiRaJNko9w0hL4AeKogwf+4TbCw+KWVEn6jhuJa4LFTdSqp89PktQaoVpwv92el/AhYjWOl/jVCm122f9b7GyoelbjMNolToDwe5pF5RnSpEuDdLy9MfE8LnE3PlbE7E5BipQ3UjSebkgNboLHH/lNZA5qvEtvbfvQ==', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAut9evKRuHJ/2QNfDlLwvN/S8l9hRAgPbb0u61bm4AtzaTGsLeMtScetxTWJnVvAVpMS9luhEJjt+Sbk5TNLArsgzzwARgaTKOLMT1TvWAK5EbHyI+eSrc3s7Awe1VYGwcubRFWDm16eQLv0k7iqiw+4mweHSz/wWyvBJVgwLoQ02btVtAQErCfSJCOmt0Q/oJQjj08YNRV4EKzB19+f5A+HQVAKy72dSybTzAK+3FPtTtNen/+b5wGeat7c32dhYHnGorPkPeXLtsqqUTp1su5fMfd4lElNdZaoCI7osZxWWUo17vBCZnyeXc9fk0qwD9mK6yRAxNbrY72Xx5VqIqwIDAQAB', 'http://api.auauz.net/api/aliPay/return', 'RSA2', '2088102176044281');
COMMIT;

-- ----------------------------
-- Table structure for captcha
-- ----------------------------
DROP TABLE IF EXISTS `captcha`;
CREATE TABLE `captcha` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `type` int(10) NOT NULL COMMENT '验证码类型',
  `font_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字体名字',
  `font_style` int(10) DEFAULT NULL COMMENT '字体风格',
  `font_size` int(10) DEFAULT NULL COMMENT '字体大小',
  `width` int(10) DEFAULT NULL COMMENT '宽度',
  `height` int(10) DEFAULT NULL COMMENT '高度',
  `len` int(10) DEFAULT NULL COMMENT '位数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of captcha
-- ----------------------------
BEGIN;
INSERT INTO `captcha` VALUES (1, 1, '宋体', 1, 32, 130, 48, 4);
COMMIT;

-- ----------------------------
-- Table structure for column_config
-- ----------------------------
DROP TABLE IF EXISTS `column_config`;
CREATE TABLE `column_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(255) DEFAULT NULL,
  `column_name` varchar(255) DEFAULT NULL,
  `column_type` varchar(255) DEFAULT NULL,
  `dict_name` varchar(255) DEFAULT NULL,
  `extra` varchar(255) DEFAULT NULL,
  `form_show` bit(1) DEFAULT NULL,
  `form_type` varchar(255) DEFAULT NULL,
  `key_type` varchar(255) DEFAULT NULL,
  `list_show` bit(1) DEFAULT NULL,
  `not_null` bit(1) DEFAULT NULL,
  `query_type` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `date_annotation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of column_config
-- ----------------------------
BEGIN;
INSERT INTO `column_config` VALUES (86, 'mnt_deploy_server', 'deploy_id', 'bigint', NULL, '', b'1', NULL, 'PRI', b'1', b'1', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (87, 'mnt_deploy_server', 'server_id', 'bigint', NULL, '', b'1', NULL, 'PRI', b'1', b'1', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (96, 'log', 'id', 'bigint', NULL, 'auto_increment', b'1', NULL, 'PRI', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (97, 'log', 'create_time', 'datetime', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (98, 'log', 'description', 'varchar', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (99, 'log', 'exception_detail', 'text', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (100, 'log', 'log_type', 'varchar', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (101, 'log', 'method', 'varchar', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (102, 'log', 'params', 'text', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (103, 'log', 'request_ip', 'varchar', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (104, 'log', 'time', 'bigint', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (105, 'log', 'username', 'varchar', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (106, 'log', 'address', 'varchar', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (107, 'log', 'browser', 'varchar', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (108, 'log', 'is_delete', 'bit', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (109, 'log', 'update_time', 'datetime', NULL, '', b'1', NULL, '', b'1', b'0', NULL, NULL, NULL);
INSERT INTO `column_config` VALUES (110, 'test', 'id', 'int', NULL, 'auto_increment', b'1', 'Input', 'PRI', b'1', b'1', '=', 'id', '');
INSERT INTO `column_config` VALUES (111, 'test', 'createTime', 'datetime', NULL, '', b'1', 'Date', '', b'1', b'1', 'BetWeen', 'createTime', 'CreationTimestamp');
INSERT INTO `column_config` VALUES (112, 'test', 'username', 'varchar', NULL, '', b'1', 'Input', '', b'1', b'1', 'Like', 'username', NULL);
INSERT INTO `column_config` VALUES (131, 'captcha', 'id', 'bigint', NULL, '', b'0', NULL, 'PRI', b'0', b'1', NULL, 'id', NULL);
INSERT INTO `column_config` VALUES (132, 'captcha', 'type', 'int', 'captcha_type', '', b'1', 'Radio', '', b'1', b'1', NULL, '验证码类型', NULL);
INSERT INTO `column_config` VALUES (133, 'captcha', 'font_name', 'varchar', 'font_name', '', b'1', 'Radio', '', b'1', b'0', NULL, '字体名字', NULL);
INSERT INTO `column_config` VALUES (134, 'captcha', 'font_style', 'int', 'captcha_fontstyle', '', b'1', 'Radio', '', b'1', b'0', NULL, '字体风格', NULL);
INSERT INTO `column_config` VALUES (135, 'captcha', 'font_size', 'int', NULL, '', b'1', '', '', b'1', b'0', NULL, '字体大小', NULL);
INSERT INTO `column_config` VALUES (136, 'captcha', 'width', 'int', NULL, '', b'1', NULL, '', b'1', b'0', NULL, '宽度', NULL);
INSERT INTO `column_config` VALUES (137, 'captcha', 'height', 'int', NULL, '', b'1', NULL, '', b'1', b'0', NULL, '高度', NULL);
INSERT INTO `column_config` VALUES (138, 'captcha', 'len', 'int', NULL, '', b'1', NULL, '', b'1', b'0', NULL, '位数', NULL);
COMMIT;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `pid` bigint(20) NOT NULL COMMENT '上级部门',
  `enabled` bit(1) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of dept
-- ----------------------------
BEGIN;
INSERT INTO `dept` VALUES (1, '总部', 0, b'1', '2019-03-25 09:14:05');
INSERT INTO `dept` VALUES (2, '管理员部门', 7, b'1', '2019-03-25 09:15:32');
INSERT INTO `dept` VALUES (5, '普通人员', 7, b'1', '2019-03-25 09:20:44');
INSERT INTO `dept` VALUES (6, '测试部', 8, b'1', '2019-03-25 09:52:18');
INSERT INTO `dept` VALUES (7, '分部一', 1, b'1', '2019-03-25 11:04:50');
INSERT INTO `dept` VALUES (11, '人事部', 8, b'1', '2019-03-25 11:07:58');
INSERT INTO `dept` VALUES (12, '分部二', 1, b'1', '2019-12-17 14:57:31');
INSERT INTO `dept` VALUES (13, '测试部门', 12, b'1', '2019-12-17 14:57:50');
COMMIT;

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '字典名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of dict
-- ----------------------------
BEGIN;
INSERT INTO `dict` VALUES (1, 'user_status', '用户状态', '2019-10-27 20:31:36');
INSERT INTO `dict` VALUES (4, 'dept_status', '部门状态', '2019-10-27 20:31:36');
INSERT INTO `dict` VALUES (5, 'job_status', '岗位状态', '2019-10-27 20:31:36');
INSERT INTO `dict` VALUES (6, 'captcha_type', '验证码类型', '2019-12-17 15:41:58');
INSERT INTO `dict` VALUES (7, 'captcha_fontstyle', '验证码字体风格', '2019-12-17 17:09:23');
INSERT INTO `dict` VALUES (8, 'font_name', '字体名字', '2019-12-17 17:20:34');
COMMIT;

-- ----------------------------
-- Table structure for dict_detail
-- ----------------------------
DROP TABLE IF EXISTS `dict_detail`;
CREATE TABLE `dict_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) NOT NULL COMMENT '字典标签',
  `value` varchar(255) NOT NULL COMMENT '字典值',
  `sort` varchar(255) DEFAULT NULL COMMENT '排序',
  `dict_id` bigint(11) DEFAULT NULL COMMENT '字典id',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK5tpkputc6d9nboxojdbgnpmyb` (`dict_id`) USING BTREE,
  CONSTRAINT `FK5tpkputc6d9nboxojdbgnpmyb` FOREIGN KEY (`dict_id`) REFERENCES `dict` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of dict_detail
-- ----------------------------
BEGIN;
INSERT INTO `dict_detail` VALUES (1, '激活', 'true', '1', 1, '2019-10-27 20:31:36');
INSERT INTO `dict_detail` VALUES (2, '禁用', 'false', '2', 1, NULL);
INSERT INTO `dict_detail` VALUES (3, '启用', 'true', '1', 4, NULL);
INSERT INTO `dict_detail` VALUES (4, '停用', 'false', '2', 4, '2019-10-27 20:31:36');
INSERT INTO `dict_detail` VALUES (5, '启用', 'true', '1', 5, NULL);
INSERT INTO `dict_detail` VALUES (6, '停用', 'false', '2', 5, '2019-10-27 20:31:36');
INSERT INTO `dict_detail` VALUES (7, '纯小写字母', '5', '999', 6, '2019-12-17 15:43:00');
INSERT INTO `dict_detail` VALUES (8, '纯大写字母', '4', '999', 6, '2019-12-17 15:43:11');
INSERT INTO `dict_detail` VALUES (9, '纯字母', '3', '999', 6, '2019-12-17 15:43:19');
INSERT INTO `dict_detail` VALUES (10, '纯数字', '2', '999', 6, '2019-12-17 15:43:31');
INSERT INTO `dict_detail` VALUES (11, '数字和字母混合', '1', '999', 6, '2019-12-17 15:43:41');
INSERT INTO `dict_detail` VALUES (12, '普通', '0', '999', 7, '2019-12-17 17:13:22');
INSERT INTO `dict_detail` VALUES (13, '加粗', '1', '999', 7, '2019-12-17 17:13:46');
INSERT INTO `dict_detail` VALUES (14, '斜体', '2', '999', 7, '2019-12-17 17:13:59');
INSERT INTO `dict_detail` VALUES (15, '数字和大写字母', '6', '999', 6, '2019-12-17 17:17:27');
INSERT INTO `dict_detail` VALUES (16, '宋体', '宋体', '999', 8, '2019-12-17 17:20:49');
INSERT INTO `dict_detail` VALUES (17, '黑体', '黑体', '999', 8, '2019-12-17 17:20:58');
INSERT INTO `dict_detail` VALUES (18, 'Times New Roman', 'Times New Roman', '999', 8, '2019-12-17 17:21:13');
COMMIT;

-- ----------------------------
-- Table structure for email_config
-- ----------------------------
DROP TABLE IF EXISTS `email_config`;
CREATE TABLE `email_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `from_user` varchar(255) DEFAULT NULL COMMENT '收件人',
  `host` varchar(255) DEFAULT NULL COMMENT '邮件服务器SMTP地址',
  `pass` varchar(255) DEFAULT NULL COMMENT '密码',
  `port` varchar(255) DEFAULT NULL COMMENT '端口',
  `user` varchar(255) DEFAULT NULL COMMENT '发件者用户名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for gen_config
-- ----------------------------
DROP TABLE IF EXISTS `gen_config`;
CREATE TABLE `gen_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `table_name` varchar(255) DEFAULT NULL COMMENT '表名',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `cover` bit(1) DEFAULT NULL COMMENT '是否覆盖',
  `pack` varchar(255) DEFAULT NULL COMMENT '至于哪个包下',
  `path` varchar(255) DEFAULT NULL COMMENT '前端代码生成的路径',
  `api_path` varchar(255) DEFAULT NULL COMMENT '前端Api文件路径',
  `prefix` varchar(255) DEFAULT NULL COMMENT '表前缀',
  `api_alias` varchar(255) DEFAULT NULL COMMENT '接口名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of gen_config
-- ----------------------------
BEGIN;
INSERT INTO `gen_config` VALUES (4, 'test', 'perye', b'1', 'com.perye.dokit', '/Volumes/perye/dokit/dokit-front/src/views/gentest', '/Volumes/perye/dokit/dokit-front/src/api', NULL, 'genTest');
INSERT INTO `gen_config` VALUES (6, 'captcha', 'perye', b'1', 'com.perye.dokit', '/Volumes/perye/dokit/dokit-front/src/views/system/captcha', '/Volumes/perye/dokit/dokit-front/src/api', NULL, 'captcha');
COMMIT;

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `sort` bigint(20) NOT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKmvhj0rogastlctflsxf1d6k3i` (`dept_id`) USING BTREE,
  CONSTRAINT `FKmvhj0rogastlctflsxf1d6k3i` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of job
-- ----------------------------
BEGIN;
INSERT INTO `job` VALUES (2, 'SuperAdmin', b'1', 2, 1, '2019-03-29 14:01:30');
INSERT INTO `job` VALUES (10, 'admin', b'1', 4, 2, '2019-03-29 14:55:51');
INSERT INTO `job` VALUES (11, 'admin2', b'1', 6, 2, '2019-03-31 13:39:30');
INSERT INTO `job` VALUES (12, 'admin1', b'1', 5, 2, '2019-03-31 13:39:43');
INSERT INTO `job` VALUES (14, 'user2', b'1', 8, 5, '2019-12-17 14:58:58');
INSERT INTO `job` VALUES (15, 'user1', b'1', 7, 5, '2019-12-17 14:59:07');
INSERT INTO `job` VALUES (16, 'user3', b'1', 9, 5, '2019-12-17 14:59:27');
INSERT INTO `job` VALUES (17, 'test1', b'1', 999, 13, '2019-12-17 14:59:55');
INSERT INTO `job` VALUES (18, 'test2', b'1', 999, 13, '2019-12-17 15:00:02');
COMMIT;

-- ----------------------------
-- Table structure for local_storage
-- ----------------------------
DROP TABLE IF EXISTS `local_storage`;
CREATE TABLE `local_storage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) DEFAULT NULL COMMENT '文件真实的名称',
  `name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `suffix` varchar(255) DEFAULT NULL COMMENT '后缀',
  `path` varchar(255) DEFAULT NULL COMMENT '路径',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `size` varchar(100) DEFAULT NULL COMMENT '大小',
  `operate` varchar(255) DEFAULT NULL COMMENT '操作人',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `exception_detail` text COMMENT '异常详情',
  `log_type` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `method` varchar(255) DEFAULT NULL COMMENT '方法',
  `params` text COMMENT '参数',
  `request_ip` varchar(255) DEFAULT NULL COMMENT 'ip',
  `time` bigint(20) DEFAULT NULL COMMENT '请求耗时',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `browser` varchar(255) DEFAULT NULL COMMENT '浏览器',
  `is_delete` bit(1) DEFAULT b'0',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5556 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of log
-- ----------------------------
BEGIN;
INSERT INTO `log` VALUES (5553, '2019-12-17 17:53:47', '删除所有INFO日志', NULL, 'INFO', 'com.perye.dokit.controller.LogController.delAllByInfo()', '{ }', '10.206.103.118', 23, 'admin', '内网IP', 'Chrome', b'0', '2019-12-17 17:53:47');
INSERT INTO `log` VALUES (5554, '2019-12-17 17:53:54', '删除所有ERROR日志', NULL, 'INFO', 'com.perye.dokit.controller.LogController.delAllByError()', '{ }', '10.206.103.118', 14, 'admin', '内网IP', 'Chrome', b'0', '2019-12-17 17:53:54');
INSERT INTO `log` VALUES (5555, '2019-12-17 17:53:56', '查询在线用户', NULL, 'INFO', 'com.perye.dokit.controller.OnlineController.getAll()', '{ filter: null pageable: Page request [number: 0, size 10, sort: id: DESC] }', '10.206.103.118', 22, 'admin', '内网IP', 'Chrome', b'0', '2019-12-17 17:53:56');
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `i_frame` bit(1) DEFAULT NULL COMMENT '是否外链',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `component` varchar(255) DEFAULT NULL COMMENT '组件',
  `pid` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `sort` bigint(20) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `path` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `cache` bit(1) DEFAULT b'0' COMMENT '缓存',
  `hidden` bit(1) DEFAULT b'0' COMMENT '隐藏',
  `component_name` varchar(20) DEFAULT '-' COMMENT '组件名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKqcf9gem97gqa5qjm4d3elcqt5` (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, b'0', '系统管理', NULL, 0, 1, 'system', 'system', b'0', b'0', NULL, '2018-12-18 15:11:29', NULL, 0);
INSERT INTO `menu` VALUES (2, b'0', '用户管理', 'system/user/index', 1, 2, 'peoples', 'user', b'0', b'0', 'User', '2018-12-18 15:14:44', 'user:list', 1);
INSERT INTO `menu` VALUES (3, b'0', '角色管理', 'system/role/index', 1, 3, 'role', 'role', b'0', b'0', 'Role', '2018-12-18 15:16:07', 'roles:list', 1);
INSERT INTO `menu` VALUES (5, b'0', '菜单管理', 'system/menu/index', 1, 5, 'menu', 'menu', b'0', b'0', 'Menu', '2018-12-18 15:17:28', 'menu:list', 1);
INSERT INTO `menu` VALUES (6, b'0', '系统监控', NULL, 0, 10, 'monitor', 'monitor', b'0', b'0', NULL, '2018-12-18 15:17:48', NULL, 0);
INSERT INTO `menu` VALUES (7, b'0', '操作日志', 'monitor/log/index', 6, 11, 'log', 'logs', b'0', b'0', 'Log', '2018-12-18 15:18:26', NULL, 1);
INSERT INTO `menu` VALUES (8, b'0', '系统缓存', 'monitor/redis/index', 6, 15, 'redis', 'redis', b'0', b'0', 'Redis', '2018-12-18 15:19:01', 'redis:list', 1);
INSERT INTO `menu` VALUES (9, b'0', 'SQL监控', 'monitor/sql/index', 6, 18, 'sqlMonitor', 'druid', b'0', b'0', 'Sql', '2018-12-18 15:19:34', NULL, 1);
INSERT INTO `menu` VALUES (10, b'0', '组件管理', NULL, 0, 50, 'zujian', 'components', b'0', b'0', NULL, '2018-12-19 13:38:16', NULL, 0);
INSERT INTO `menu` VALUES (11, b'0', '图标库', 'components/icons/index', 10, 51, 'icon', 'icon', b'0', b'0', 'Icons', '2018-12-19 13:38:49', NULL, 1);
INSERT INTO `menu` VALUES (14, b'0', '邮件工具', 'tools/email/index', 36, 34, 'email', 'email', b'0', b'0', 'Email', '2018-12-27 10:13:09', NULL, 1);
INSERT INTO `menu` VALUES (15, b'0', '富文本', 'components/Editor', 10, 52, 'fwb', 'tinymce', b'0', b'0', 'Editor', '2018-12-27 11:58:25', NULL, 1);
INSERT INTO `menu` VALUES (16, b'0', '图床管理', 'tools/picture/index', 36, 35, 'image', 'pictures', b'0', b'0', 'Pictures', '2018-12-28 09:36:53', 'pictures:list', 1);
INSERT INTO `menu` VALUES (18, b'0', '存储管理', 'tools/storage/index', 36, 33, 'qiniu', 'storage', b'0', b'0', 'Storage', '2018-12-31 11:12:15', 'storage:list', 1);
INSERT INTO `menu` VALUES (19, b'0', '支付宝工具', 'tools/aliPay/index', 36, 37, 'alipay', 'aliPay', b'0', b'0', 'AliPay', '2018-12-31 14:52:38', NULL, 1);
INSERT INTO `menu` VALUES (28, b'0', '定时任务', 'system/timing/index', 36, 31, 'timing', 'timing', b'0', b'0', 'Timing', '2019-01-07 20:34:40', 'timing:list', 1);
INSERT INTO `menu` VALUES (30, b'0', '代码生成', 'generator/index', 36, 32, 'dev', 'generator', b'0', b'0', 'GeneratorIndex', '2019-01-11 15:45:55', NULL, 1);
INSERT INTO `menu` VALUES (32, b'0', '异常日志', 'monitor/log/errorLog', 6, 12, 'error', 'errorLog', b'0', b'0', 'ErrorLog', '2019-01-13 13:49:03', NULL, 1);
INSERT INTO `menu` VALUES (33, b'0', 'Markdown', 'components/MarkDown', 10, 53, 'markdown', 'markdown', b'0', b'0', 'Markdown', '2019-03-08 13:46:44', NULL, 1);
INSERT INTO `menu` VALUES (34, b'0', 'Yaml编辑器', 'components/YamlEdit', 10, 54, 'dev', 'yaml', b'0', b'0', 'YamlEdit', '2019-03-08 15:49:40', NULL, 1);
INSERT INTO `menu` VALUES (35, b'0', '部门管理', 'system/dept/index', 1, 6, 'dept', 'dept', b'0', b'0', 'Dept', '2019-03-25 09:46:00', 'dept:list', 1);
INSERT INTO `menu` VALUES (36, b'0', '系统工具', '', 0, 30, 'sys-tools', 'sys-tools', b'0', b'0', NULL, '2019-03-29 10:57:35', NULL, 0);
INSERT INTO `menu` VALUES (37, b'0', '岗位管理', 'system/job/index', 1, 7, 'Steve-Jobs', 'job', b'0', b'0', 'Job', '2019-03-29 13:51:18', 'job:list', 1);
INSERT INTO `menu` VALUES (38, b'0', '接口文档', 'tools/swagger/index', 36, 36, 'swagger', 'swagger2', b'0', b'0', 'Swagger', '2019-03-29 19:57:53', NULL, 1);
INSERT INTO `menu` VALUES (39, b'0', '字典管理', 'system/dict/index', 1, 8, 'dictionary', 'dict', b'0', b'0', 'Dict', '2019-04-10 11:49:04', 'dict:list', 1);
INSERT INTO `menu` VALUES (41, b'0', '在线用户', 'monitor/online/index', 6, 10, 'Steve-Jobs', 'online', b'0', b'0', 'OnlineUser', '2019-10-26 22:08:43', NULL, 1);
INSERT INTO `menu` VALUES (44, b'0', '用户新增', '', 2, 2, '', '', b'0', b'0', '', '2019-10-29 10:59:46', 'user:add', 2);
INSERT INTO `menu` VALUES (45, b'0', '用户编辑', '', 2, 3, '', '', b'0', b'0', '', '2019-10-29 11:00:08', 'user:edit', 2);
INSERT INTO `menu` VALUES (46, b'0', '用户删除', '', 2, 4, '', '', b'0', b'0', '', '2019-10-29 11:00:23', 'user:del', 2);
INSERT INTO `menu` VALUES (48, b'0', '角色创建', '', 3, 2, '', '', b'0', b'0', '', '2019-10-29 12:45:34', 'roles:add', 2);
INSERT INTO `menu` VALUES (49, b'0', '角色修改', '', 3, 3, '', '', b'0', b'0', '', '2019-10-29 12:46:16', 'roles:edit', 2);
INSERT INTO `menu` VALUES (50, b'0', '角色删除', '', 3, 4, '', '', b'0', b'0', '', '2019-10-29 12:46:51', 'roles:del', 2);
INSERT INTO `menu` VALUES (52, b'0', '菜单新增', '', 5, 2, '', '', b'0', b'0', '', '2019-10-29 12:55:07', 'menu:add', 2);
INSERT INTO `menu` VALUES (53, b'0', '菜单编辑', '', 5, 3, '', '', b'0', b'0', '', '2019-10-29 12:55:40', 'menu:edit', 2);
INSERT INTO `menu` VALUES (54, b'0', '菜单删除', '', 5, 4, '', '', b'0', b'0', '', '2019-10-29 12:56:00', 'menu:del', 2);
INSERT INTO `menu` VALUES (56, b'0', '部门新增', '', 35, 2, '', '', b'0', b'0', '', '2019-10-29 12:57:09', 'dept:add', 2);
INSERT INTO `menu` VALUES (57, b'0', '部门编辑', '', 35, 3, '', '', b'0', b'0', '', '2019-10-29 12:57:27', 'dept:edit', 2);
INSERT INTO `menu` VALUES (58, b'0', '部门删除', '', 35, 4, '', '', b'0', b'0', '', '2019-10-29 12:57:41', 'dept:del', 2);
INSERT INTO `menu` VALUES (60, b'0', '岗位新增', '', 37, 2, '', '', b'0', b'0', '', '2019-10-29 12:58:27', 'job:add', 2);
INSERT INTO `menu` VALUES (61, b'0', '岗位编辑', '', 37, 3, '', '', b'0', b'0', '', '2019-10-29 12:58:45', 'job:edit', 2);
INSERT INTO `menu` VALUES (62, b'0', '岗位删除', '', 37, 4, '', '', b'0', b'0', '', '2019-10-29 12:59:04', 'job:del', 2);
INSERT INTO `menu` VALUES (64, b'0', '字典新增', '', 39, 2, '', '', b'0', b'0', '', '2019-10-29 13:00:17', 'dict:add', 2);
INSERT INTO `menu` VALUES (65, b'0', '字典编辑', '', 39, 3, '', '', b'0', b'0', '', '2019-10-29 13:00:42', 'dict:edit', 2);
INSERT INTO `menu` VALUES (66, b'0', '字典删除', '', 39, 4, '', '', b'0', b'0', '', '2019-10-29 13:00:59', 'dict:del', 2);
INSERT INTO `menu` VALUES (68, b'0', '缓存删除', '', 8, 2, '', '', b'0', b'0', '', '2019-10-29 13:04:07', 'redis:del', 2);
INSERT INTO `menu` VALUES (70, b'0', '图片上传', '', 16, 2, '', '', b'0', b'0', '', '2019-10-29 13:05:34', 'pictures:add', 2);
INSERT INTO `menu` VALUES (71, b'0', '图片删除', '', 16, 3, '', '', b'0', b'0', '', '2019-10-29 13:05:52', 'pictures:del', 2);
INSERT INTO `menu` VALUES (73, b'0', '任务新增', '', 28, 2, '', '', b'0', b'0', '', '2019-10-29 13:07:28', 'timing:add', 2);
INSERT INTO `menu` VALUES (74, b'0', '任务编辑', '', 28, 3, '', '', b'0', b'0', '', '2019-10-29 13:07:41', 'timing:edit', 2);
INSERT INTO `menu` VALUES (75, b'0', '任务删除', '', 28, 4, '', '', b'0', b'0', '', '2019-10-29 13:07:54', 'timing:del', 2);
INSERT INTO `menu` VALUES (77, b'0', '上传文件', '', 18, 2, '', '', b'0', b'0', '', '2019-10-29 13:09:09', 'storage:add', 2);
INSERT INTO `menu` VALUES (78, b'0', '文件编辑', '', 18, 3, '', '', b'0', b'0', '', '2019-10-29 13:09:22', 'storage:edit', 2);
INSERT INTO `menu` VALUES (79, b'0', '文件删除', '', 18, 4, '', '', b'0', b'0', '', '2019-10-29 13:09:34', 'storage:del', 2);
INSERT INTO `menu` VALUES (80, b'0', '服务监控', 'monitor/server/index', 6, 14, 'codeConsole', 'server', b'0', b'0', 'ServerMonitor', '2019-11-07 13:06:39', 'server:list', 1);
INSERT INTO `menu` VALUES (82, b'0', '生成配置', 'generator/config', 36, 33, 'dev', 'generator/config/:tableName', b'1', b'1', 'GeneratorConfig', '2019-11-17 20:08:56', '', 1);
INSERT INTO `menu` VALUES (83, b'0', '图表库', 'components/Echarts', 10, 50, 'chart', 'echarts', b'1', b'0', 'Echarts', '2019-11-21 09:04:32', '', 1);
INSERT INTO `menu` VALUES (90, b'0', '运维管理', '', 0, 20, 'mnt', 'mnt', b'0', b'0', 'Mnt', '2019-11-09 10:31:08', NULL, 1);
INSERT INTO `menu` VALUES (92, b'0', '服务器', 'mnt/server/index', 90, 22, 'server', 'mnt/serverDeploy', b'0', b'0', 'ServerDeploy', '2019-11-10 10:29:25', 'serverDeploy:list', 1);
INSERT INTO `menu` VALUES (93, b'0', '应用管理', 'mnt/app/index', 90, 23, 'app', 'mnt/app', b'0', b'0', 'App', '2019-11-10 11:05:16', 'app:list', 1);
INSERT INTO `menu` VALUES (94, b'0', '部署管理', 'mnt/deploy/index', 90, 24, 'deploy', 'mnt/deploy', b'0', b'0', 'Deploy', '2019-11-10 15:56:55', 'deploy:list', 1);
INSERT INTO `menu` VALUES (97, b'0', '部署备份', 'mnt/deployHistory/index', 90, 25, 'backup', 'mnt/deployHistory', b'0', b'0', 'DeployHistory', '2019-11-10 16:49:44', 'deployHistory:list', 1);
INSERT INTO `menu` VALUES (98, b'0', '数据库管理', 'mnt/database/index', 90, 26, 'database', 'mnt/database', b'0', b'0', 'Database', '2019-11-10 20:40:04', 'database:list', 1);
INSERT INTO `menu` VALUES (102, b'0', '删除', '', 97, 999, '', '', b'0', b'0', '', '2019-11-17 09:32:48', 'deployHistory:del', 2);
INSERT INTO `menu` VALUES (103, b'0', '服务器新增', '', 92, 999, '', '', b'0', b'0', '', '2019-11-17 11:08:33', 'serverDeploy:add', 2);
INSERT INTO `menu` VALUES (104, b'0', '服务器编辑', '', 92, 999, '', '', b'0', b'0', '', '2019-11-17 11:08:57', 'serverDeploy:edit', 2);
INSERT INTO `menu` VALUES (105, b'0', '服务器删除', '', 92, 999, '', '', b'0', b'0', '', '2019-11-17 11:09:15', 'serverDeploy:del', 2);
INSERT INTO `menu` VALUES (106, b'0', '应用新增', '', 93, 999, '', '', b'0', b'0', '', '2019-11-17 11:10:03', 'app:add', 2);
INSERT INTO `menu` VALUES (107, b'0', '应用编辑', '', 93, 999, '', '', b'0', b'0', '', '2019-11-17 11:10:28', 'app:edit', 2);
INSERT INTO `menu` VALUES (108, b'0', '应用删除', '', 93, 999, '', '', b'0', b'0', '', '2019-11-17 11:10:55', 'app:del', 2);
INSERT INTO `menu` VALUES (109, b'0', '部署新增', '', 94, 999, '', '', b'0', b'0', '', '2019-11-17 11:11:22', 'deploy:add', 2);
INSERT INTO `menu` VALUES (110, b'0', '部署编辑', '', 94, 999, '', '', b'0', b'0', '', '2019-11-17 11:11:41', 'deploy:edit', 2);
INSERT INTO `menu` VALUES (111, b'0', '部署删除', '', 94, 999, '', '', b'0', b'0', '', '2019-11-17 11:12:01', 'deploy:del', 2);
INSERT INTO `menu` VALUES (112, b'0', '数据库新增', '', 98, 999, '', '', b'0', b'0', '', '2019-11-17 11:12:43', 'database:add', 2);
INSERT INTO `menu` VALUES (113, b'0', '数据库编辑', '', 98, 999, '', '', b'0', b'0', '', '2019-11-17 11:12:58', 'database:edit', 2);
INSERT INTO `menu` VALUES (114, b'0', '数据库删除', '', 98, 999, '', '', b'0', b'0', '', '2019-11-17 11:13:14', 'database:del', 2);
INSERT INTO `menu` VALUES (115, b'0', '测试生成', 'gentest/index', 1, 999, 'Steve-Jobs', 'genTest', b'0', b'0', NULL, '2019-11-25 18:10:29', 'test:list', 1);
INSERT INTO `menu` VALUES (116, b'0', '生成预览', 'generator/preview', 36, 999, 'java', 'generator/preview/:tableName', b'1', b'1', 'Preview', '2019-11-26 14:54:36', NULL, 1);
INSERT INTO `menu` VALUES (117, b'0', '验证码设置', 'system/captcha/index', 118, 999, 'app', 'captcha', b'0', b'0', NULL, '2019-12-17 15:38:35', 'captcha:list', 1);
INSERT INTO `menu` VALUES (118, b'0', '系统设置', NULL, 0, 999, 'bug', 'setting', b'0', b'0', NULL, '2019-12-17 17:52:05', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mnt_app
-- ----------------------------
DROP TABLE IF EXISTS `mnt_app`;
CREATE TABLE `mnt_app` (
  `id` bigint(20) NOT NULL COMMENT '应用ID',
  `name` varchar(255) DEFAULT NULL COMMENT '应用名称',
  `upload_path` varchar(255) DEFAULT NULL COMMENT '上传目录',
  `deploy_path` varchar(255) DEFAULT NULL COMMENT '部署路径',
  `backup_path` varchar(255) DEFAULT NULL COMMENT '备份路径',
  `port` int(255) DEFAULT NULL COMMENT '应用端口',
  `start_script` varchar(4000) DEFAULT NULL COMMENT '启动脚本',
  `deploy_script` varchar(4000) DEFAULT NULL COMMENT '部署脚本',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of mnt_app
-- ----------------------------
BEGIN;
INSERT INTO `mnt_app` VALUES (1, '9514-1.0.jar', '/root/upload', '/root/ops', '/root/backup', 9514, 'cd  /root/ops\nnohup java -jar 9514-1.0.jar >nohup.out 2>&1 &\n', 'mkdir -p /root/ops\nmv -f /root/upload/9514-1.0.jar /root/ops\n', '2019-11-24 20:52:59');
COMMIT;

-- ----------------------------
-- Table structure for mnt_database
-- ----------------------------
DROP TABLE IF EXISTS `mnt_database`;
CREATE TABLE `mnt_database` (
  `id` varchar(255) NOT NULL COMMENT '编号',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `jdbc_url` varchar(255) NOT NULL COMMENT 'jdbc连接',
  `user_name` varchar(255) NOT NULL COMMENT '账号',
  `pwd` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of mnt_database
-- ----------------------------
BEGIN;
INSERT INTO `mnt_database` VALUES ('39f72aa9f13b42239569f2073e07f8f2', 'test', 'jdbc:log4jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false', 'root', '123456');
COMMIT;

-- ----------------------------
-- Table structure for mnt_deploy
-- ----------------------------
DROP TABLE IF EXISTS `mnt_deploy`;
CREATE TABLE `mnt_deploy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `app_id` bigint(20) DEFAULT NULL COMMENT '应用编号',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK6sy157pseoxx4fmcqr1vnvvhy` (`app_id`) USING BTREE,
  CONSTRAINT `FK6sy157pseoxx4fmcqr1vnvvhy` FOREIGN KEY (`app_id`) REFERENCES `mnt_app` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for mnt_deploy_history
-- ----------------------------
DROP TABLE IF EXISTS `mnt_deploy_history`;
CREATE TABLE `mnt_deploy_history` (
  `id` varchar(50) NOT NULL COMMENT '编号',
  `app_name` varchar(255) NOT NULL COMMENT '应用名称',
  `deploy_date` datetime NOT NULL COMMENT '部署日期',
  `deploy_user` varchar(50) NOT NULL COMMENT '部署用户',
  `ip` varchar(20) NOT NULL COMMENT '服务器IP',
  `deploy_id` bigint(20) DEFAULT NULL COMMENT '部署编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for mnt_deploy_server
-- ----------------------------
DROP TABLE IF EXISTS `mnt_deploy_server`;
CREATE TABLE `mnt_deploy_server` (
  `deploy_id` bigint(20) NOT NULL,
  `server_id` bigint(20) NOT NULL,
  PRIMARY KEY (`deploy_id`,`server_id`),
  KEY `FKeaaha7jew9a02b3bk9ghols53` (`server_id`),
  CONSTRAINT `FK3cehr56tedph6nk3gxsmeq0pb` FOREIGN KEY (`deploy_id`) REFERENCES `mnt_deploy` (`id`),
  CONSTRAINT `FKeaaha7jew9a02b3bk9ghols53` FOREIGN KEY (`server_id`) REFERENCES `mnt_server` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for mnt_server
-- ----------------------------
DROP TABLE IF EXISTS `mnt_server`;
CREATE TABLE `mnt_server` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'IP地址',
  `account_id` varchar(255) DEFAULT NULL COMMENT '账号编号',
  `account` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of mnt_server
-- ----------------------------
BEGIN;
INSERT INTO `mnt_server` VALUES (1, NULL, 'root', '2019-12-14 23:49:02', '193.112.143.187', ' 腾讯云', 'Hgd19980211', 22);
COMMIT;

-- ----------------------------
-- Table structure for monitor_server
-- ----------------------------
DROP TABLE IF EXISTS `monitor_server`;
CREATE TABLE `monitor_server` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `ip` varchar(255) NOT NULL COMMENT 'IP地址',
  `port` int(11) DEFAULT NULL COMMENT '访问端口',
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  `cpu_rate` float DEFAULT NULL COMMENT 'CPU使用率',
  `cpu_core` int(11) DEFAULT NULL COMMENT 'CPU内核数',
  `mem_total` float DEFAULT NULL COMMENT '内存总数',
  `mem_used` float DEFAULT NULL COMMENT '内存使用量',
  `disk_total` float DEFAULT NULL COMMENT '磁盘总量',
  `disk_used` float DEFAULT NULL COMMENT '磁盘使用量',
  `swap_total` float DEFAULT NULL COMMENT '交换区总量',
  `swap_used` float DEFAULT NULL COMMENT '交换区使用量',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='服务器监控';

-- ----------------------------
-- Records of monitor_server
-- ----------------------------
BEGIN;
INSERT INTO `monitor_server` VALUES (5, 'dokit', '127.0.0.1', 8080, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '127.0.0.1');
COMMIT;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_time` datetime DEFAULT NULL COMMENT '上传日期',
  `delete_url` varchar(255) DEFAULT NULL COMMENT '删除的URL',
  `filename` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `height` varchar(255) DEFAULT NULL COMMENT '图片高度',
  `size` varchar(255) DEFAULT NULL COMMENT '图片大小',
  `url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `width` varchar(255) DEFAULT NULL COMMENT '图片宽度',
  `md5code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of picture
-- ----------------------------
BEGIN;
INSERT INTO `picture` VALUES (1, '2019-12-16 10:43:46', 'https://sm.ms/delete/k7PDLTqs4rUnuXOgY9zhMN2ebi', '22.jpg', '650', '46.30KB', 'https://i.loli.net/2019/12/16/olvzymnaWcthUSO.jpg', 'admin', '650', 'd5d5ddc90655fc5fa13aeffc310a2105');
COMMIT;

-- ----------------------------
-- Table structure for qiniu_config
-- ----------------------------
DROP TABLE IF EXISTS `qiniu_config`;
CREATE TABLE `qiniu_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `access_key` text COMMENT 'accessKey',
  `bucket` varchar(255) DEFAULT NULL COMMENT 'Bucket 识别符',
  `host` varchar(255) NOT NULL COMMENT '外链域名',
  `secret_key` text COMMENT 'secretKey',
  `type` varchar(255) DEFAULT NULL COMMENT '空间类型',
  `zone` varchar(255) DEFAULT NULL COMMENT '机房',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for qiniu_content
-- ----------------------------
DROP TABLE IF EXISTS `qiniu_content`;
CREATE TABLE `qiniu_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `bucket` varchar(255) DEFAULT NULL COMMENT 'Bucket 识别符',
  `name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `size` varchar(255) DEFAULT NULL COMMENT '文件大小',
  `type` varchar(255) DEFAULT NULL COMMENT '文件类型：私有或公开',
  `update_time` datetime DEFAULT NULL COMMENT '上传或同步的时间',
  `url` varchar(255) DEFAULT NULL COMMENT '文件url',
  `suffix` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for quartz_job
-- ----------------------------
DROP TABLE IF EXISTS `quartz_job`;
CREATE TABLE `quartz_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `bean_name` varchar(255) DEFAULT NULL COMMENT 'Spring Bean名称',
  `cron_expression` varchar(255) DEFAULT NULL COMMENT 'cron 表达式',
  `is_pause` bit(1) DEFAULT NULL COMMENT '状态：1暂停、0启用',
  `job_name` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `method_name` varchar(255) DEFAULT NULL COMMENT '方法名称',
  `params` varchar(255) DEFAULT NULL COMMENT '参数',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of quartz_job
-- ----------------------------
BEGIN;
INSERT INTO `quartz_job` VALUES (1, 'visitsTask', '0 0 0 * * ?', b'0', '更新访客记录', 'run', NULL, '每日0点创建新的访客记录', '2019-01-08 14:53:31');
INSERT INTO `quartz_job` VALUES (2, 'testTask', '0/5 * * * * ?', b'1', '测试1', 'run1', '5555', '带参测试，多参使用json', NULL);
INSERT INTO `quartz_job` VALUES (3, 'testTask', '0/5 * * * * ?', b'1', '测试', 'run', '', '不带参测试', '2019-09-26 16:44:39');
COMMIT;

-- ----------------------------
-- Table structure for quartz_log
-- ----------------------------
DROP TABLE IF EXISTS `quartz_log`;
CREATE TABLE `quartz_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `baen_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `cron_expression` varchar(255) DEFAULT NULL,
  `exception_detail` text,
  `is_success` bit(1) DEFAULT NULL,
  `job_name` varchar(255) DEFAULT NULL,
  `method_name` varchar(255) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of quartz_log
-- ----------------------------
BEGIN;
INSERT INTO `quartz_log` VALUES (6, 'visitsTask', '2019-12-08 00:00:01', '0 0 0 * * ?', NULL, b'1', '更新访客记录', 'run', NULL, 18);
INSERT INTO `quartz_log` VALUES (7, 'testTask', '2019-12-08 13:17:46', '0/5 * * * * ?', NULL, b'1', '测试', 'run', '', 1);
INSERT INTO `quartz_log` VALUES (8, 'testTask', '2019-12-08 13:17:50', '0/5 * * * * ?', NULL, b'1', '测试', 'run', '', 1);
INSERT INTO `quartz_log` VALUES (9, 'testTask', '2019-12-08 13:17:55', '0/5 * * * * ?', NULL, b'1', '测试', 'run', '', 1);
INSERT INTO `quartz_log` VALUES (10, 'testTask', '2019-12-08 13:18:00', '0/5 * * * * ?', NULL, b'1', '测试', 'run', '', 1);
INSERT INTO `quartz_log` VALUES (11, 'testTask', '2019-12-08 13:18:05', '0/5 * * * * ?', NULL, b'1', '测试', 'run', '', 1);
INSERT INTO `quartz_log` VALUES (12, 'testTask', '2019-12-08 13:18:10', '0/5 * * * * ?', NULL, b'1', '测试', 'run', '', 0);
INSERT INTO `quartz_log` VALUES (13, 'testTask', '2019-12-08 13:18:15', '0/5 * * * * ?', NULL, b'1', '测试', 'run', '', 1);
INSERT INTO `quartz_log` VALUES (14, 'testTask', '2019-12-08 14:01:16', '0/5 * * * * ?', NULL, b'1', '测试1', 'run1', '5555', 2);
INSERT INTO `quartz_log` VALUES (15, 'testTask', '2019-12-08 14:01:20', '0/5 * * * * ?', NULL, b'1', '测试1', 'run1', '5555', 1);
INSERT INTO `quartz_log` VALUES (16, 'testTask', '2019-12-08 14:01:25', '0/5 * * * * ?', NULL, b'1', '测试1', 'run1', '5555', 1);
INSERT INTO `quartz_log` VALUES (17, 'testTask', '2019-12-08 14:01:30', '0/5 * * * * ?', NULL, b'1', '测试1', 'run1', '5555', 1);
INSERT INTO `quartz_log` VALUES (18, 'testTask', '2019-12-08 14:03:15', '0/5 * * * * ?', NULL, b'1', '测试1', 'run1', '5555', 18);
INSERT INTO `quartz_log` VALUES (19, 'testTask', '2019-12-08 14:03:20', '0/5 * * * * ?', NULL, b'1', '测试1', 'run1', '5555', 0);
INSERT INTO `quartz_log` VALUES (20, 'visitsTask', '2019-12-15 00:00:00', '0 0 0 * * ?', NULL, b'1', '更新访客记录', 'run', NULL, 35);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `data_scope` varchar(255) DEFAULT NULL,
  `level` int(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, '超级管理员', '-', '全部', 1, '2018-11-23 11:04:37', 'admin');
INSERT INTO `role` VALUES (2, '普通用户', '-', '自定义', 2, '2018-11-23 13:09:06', 'common');
INSERT INTO `role` VALUES (3, '测试用户一', '测试用户一', '自定义', 3, '2019-12-17 15:03:26', 'test1');
COMMIT;

-- ----------------------------
-- Table structure for roles_depts
-- ----------------------------
DROP TABLE IF EXISTS `roles_depts`;
CREATE TABLE `roles_depts` (
  `role_id` bigint(20) NOT NULL,
  `dept_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`dept_id`) USING BTREE,
  KEY `FK7qg6itn5ajdoa9h9o78v9ksur` (`dept_id`) USING BTREE,
  CONSTRAINT `FK7qg6itn5ajdoa9h9o78v9ksur` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`),
  CONSTRAINT `FKrg1ci4cxxfbja0sb0pddju7k` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of roles_depts
-- ----------------------------
BEGIN;
INSERT INTO `roles_depts` VALUES (2, 7);
INSERT INTO `roles_depts` VALUES (3, 7);
COMMIT;

-- ----------------------------
-- Table structure for roles_menus
-- ----------------------------
DROP TABLE IF EXISTS `roles_menus`;
CREATE TABLE `roles_menus` (
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`menu_id`,`role_id`) USING BTREE,
  KEY `FKcngg2qadojhi3a651a5adkvbq` (`role_id`) USING BTREE,
  CONSTRAINT `FKo7wsmlrrxb2osfaoavp46rv2r` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  CONSTRAINT `FKtag324maketmxffly3pdyh193` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of roles_menus
-- ----------------------------
BEGIN;
INSERT INTO `roles_menus` VALUES (1, 1);
INSERT INTO `roles_menus` VALUES (2, 1);
INSERT INTO `roles_menus` VALUES (3, 1);
INSERT INTO `roles_menus` VALUES (5, 1);
INSERT INTO `roles_menus` VALUES (6, 1);
INSERT INTO `roles_menus` VALUES (7, 1);
INSERT INTO `roles_menus` VALUES (8, 1);
INSERT INTO `roles_menus` VALUES (9, 1);
INSERT INTO `roles_menus` VALUES (10, 1);
INSERT INTO `roles_menus` VALUES (11, 1);
INSERT INTO `roles_menus` VALUES (14, 1);
INSERT INTO `roles_menus` VALUES (15, 1);
INSERT INTO `roles_menus` VALUES (16, 1);
INSERT INTO `roles_menus` VALUES (18, 1);
INSERT INTO `roles_menus` VALUES (19, 1);
INSERT INTO `roles_menus` VALUES (28, 1);
INSERT INTO `roles_menus` VALUES (30, 1);
INSERT INTO `roles_menus` VALUES (32, 1);
INSERT INTO `roles_menus` VALUES (33, 1);
INSERT INTO `roles_menus` VALUES (34, 1);
INSERT INTO `roles_menus` VALUES (35, 1);
INSERT INTO `roles_menus` VALUES (36, 1);
INSERT INTO `roles_menus` VALUES (37, 1);
INSERT INTO `roles_menus` VALUES (38, 1);
INSERT INTO `roles_menus` VALUES (39, 1);
INSERT INTO `roles_menus` VALUES (41, 1);
INSERT INTO `roles_menus` VALUES (44, 1);
INSERT INTO `roles_menus` VALUES (45, 1);
INSERT INTO `roles_menus` VALUES (46, 1);
INSERT INTO `roles_menus` VALUES (48, 1);
INSERT INTO `roles_menus` VALUES (49, 1);
INSERT INTO `roles_menus` VALUES (50, 1);
INSERT INTO `roles_menus` VALUES (52, 1);
INSERT INTO `roles_menus` VALUES (53, 1);
INSERT INTO `roles_menus` VALUES (54, 1);
INSERT INTO `roles_menus` VALUES (56, 1);
INSERT INTO `roles_menus` VALUES (57, 1);
INSERT INTO `roles_menus` VALUES (58, 1);
INSERT INTO `roles_menus` VALUES (60, 1);
INSERT INTO `roles_menus` VALUES (61, 1);
INSERT INTO `roles_menus` VALUES (62, 1);
INSERT INTO `roles_menus` VALUES (64, 1);
INSERT INTO `roles_menus` VALUES (65, 1);
INSERT INTO `roles_menus` VALUES (66, 1);
INSERT INTO `roles_menus` VALUES (68, 1);
INSERT INTO `roles_menus` VALUES (70, 1);
INSERT INTO `roles_menus` VALUES (71, 1);
INSERT INTO `roles_menus` VALUES (73, 1);
INSERT INTO `roles_menus` VALUES (74, 1);
INSERT INTO `roles_menus` VALUES (75, 1);
INSERT INTO `roles_menus` VALUES (77, 1);
INSERT INTO `roles_menus` VALUES (78, 1);
INSERT INTO `roles_menus` VALUES (79, 1);
INSERT INTO `roles_menus` VALUES (80, 1);
INSERT INTO `roles_menus` VALUES (82, 1);
INSERT INTO `roles_menus` VALUES (83, 1);
INSERT INTO `roles_menus` VALUES (87, 1);
INSERT INTO `roles_menus` VALUES (90, 1);
INSERT INTO `roles_menus` VALUES (91, 1);
INSERT INTO `roles_menus` VALUES (92, 1);
INSERT INTO `roles_menus` VALUES (93, 1);
INSERT INTO `roles_menus` VALUES (94, 1);
INSERT INTO `roles_menus` VALUES (97, 1);
INSERT INTO `roles_menus` VALUES (98, 1);
INSERT INTO `roles_menus` VALUES (99, 1);
INSERT INTO `roles_menus` VALUES (100, 1);
INSERT INTO `roles_menus` VALUES (101, 1);
INSERT INTO `roles_menus` VALUES (102, 1);
INSERT INTO `roles_menus` VALUES (103, 1);
INSERT INTO `roles_menus` VALUES (104, 1);
INSERT INTO `roles_menus` VALUES (105, 1);
INSERT INTO `roles_menus` VALUES (106, 1);
INSERT INTO `roles_menus` VALUES (107, 1);
INSERT INTO `roles_menus` VALUES (108, 1);
INSERT INTO `roles_menus` VALUES (109, 1);
INSERT INTO `roles_menus` VALUES (110, 1);
INSERT INTO `roles_menus` VALUES (111, 1);
INSERT INTO `roles_menus` VALUES (112, 1);
INSERT INTO `roles_menus` VALUES (113, 1);
INSERT INTO `roles_menus` VALUES (114, 1);
INSERT INTO `roles_menus` VALUES (115, 1);
INSERT INTO `roles_menus` VALUES (116, 1);
INSERT INTO `roles_menus` VALUES (117, 1);
INSERT INTO `roles_menus` VALUES (118, 1);
INSERT INTO `roles_menus` VALUES (1, 2);
INSERT INTO `roles_menus` VALUES (2, 2);
INSERT INTO `roles_menus` VALUES (3, 2);
INSERT INTO `roles_menus` VALUES (5, 2);
INSERT INTO `roles_menus` VALUES (6, 2);
INSERT INTO `roles_menus` VALUES (8, 2);
INSERT INTO `roles_menus` VALUES (9, 2);
INSERT INTO `roles_menus` VALUES (10, 2);
INSERT INTO `roles_menus` VALUES (11, 2);
INSERT INTO `roles_menus` VALUES (14, 2);
INSERT INTO `roles_menus` VALUES (15, 2);
INSERT INTO `roles_menus` VALUES (16, 2);
INSERT INTO `roles_menus` VALUES (18, 2);
INSERT INTO `roles_menus` VALUES (19, 2);
INSERT INTO `roles_menus` VALUES (28, 2);
INSERT INTO `roles_menus` VALUES (30, 2);
INSERT INTO `roles_menus` VALUES (33, 2);
INSERT INTO `roles_menus` VALUES (34, 2);
INSERT INTO `roles_menus` VALUES (35, 2);
INSERT INTO `roles_menus` VALUES (36, 2);
INSERT INTO `roles_menus` VALUES (37, 2);
INSERT INTO `roles_menus` VALUES (38, 2);
INSERT INTO `roles_menus` VALUES (39, 2);
INSERT INTO `roles_menus` VALUES (70, 2);
INSERT INTO `roles_menus` VALUES (71, 2);
INSERT INTO `roles_menus` VALUES (77, 2);
INSERT INTO `roles_menus` VALUES (78, 2);
INSERT INTO `roles_menus` VALUES (79, 2);
INSERT INTO `roles_menus` VALUES (1, 3);
INSERT INTO `roles_menus` VALUES (2, 3);
INSERT INTO `roles_menus` VALUES (44, 3);
COMMIT;

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FKboeuhl31go7wer3bpy6so7exi` (`permission_id`),
  CONSTRAINT `FK4hrolwj4ned5i7qe8kyiaak6m` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKboeuhl31go7wer3bpy6so7exi` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `createTime` datetime DEFAULT NULL COMMENT '创建日期',
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of test
-- ----------------------------
BEGIN;
INSERT INTO `test` VALUES (1, NULL, 'perye', '2019-12-17 14:35:21');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `avatar_id` bigint(20) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `enabled` bigint(20) DEFAULT NULL COMMENT '状态：1启用、0禁用',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `dept_id` bigint(20) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `job_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `last_password_reset_time` datetime DEFAULT NULL COMMENT '最后修改密码的日期',
  `nick_name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_kpubos9gc2cvtkb0thktkbkes` (`email`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE,
  KEY `FK5rwmryny6jthaaxkogownknqp` (`dept_id`) USING BTREE,
  KEY `FKfftoc2abhot8f2wu6cl9a5iky` (`job_id`) USING BTREE,
  KEY `FKpq2dhypk2qgt68nauh2by22jb` (`avatar_id`) USING BTREE,
  CONSTRAINT `FK5rwmryny6jthaaxkogownknqp` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`),
  CONSTRAINT `FKfftoc2abhot8f2wu6cl9a5iky` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  CONSTRAINT `FKpq2dhypk2qgt68nauh2by22jb` FOREIGN KEY (`avatar_id`) REFERENCES `user_avatar` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, NULL, '11143521@qq.com', 1, '$2a$10$HhxyGZy.ulf3RvAwaHUGb.k.2i9PBpv4YbLMJWp8pES7pPhTyRCF.', 'admin', 1, '15759115111', 11, '2018-08-23 09:11:56', '2019-12-08 00:09:03', 'admin', '男');
INSERT INTO `user` VALUES (3, NULL, 'test@dokit.net', 1, '$2a$10$HhxyGZy.ulf3RvAwaHUGb.k.2i9PBpv4YbLMJWp8pES7pPhTyRCF.', 'test', 2, '17777777777', 12, '2018-12-27 20:05:26', '2019-04-01 09:15:24', NULL, NULL);
INSERT INTO `user` VALUES (6, NULL, '111435262@qq.com', 1, '$2a$10$HhxyGZy.ulf3RvAwaHUGb.k.2i9PBpv4YbLMJWp8pES7pPhTyRCF.', 'perye', 2, '15759111153', 11, '2019-12-08 11:44:38', NULL, 'perye', NULL);
INSERT INTO `user` VALUES (7, NULL, '15759115151@dokit.com', 1, '$2a$10$NtVHb8s2I4TojxEUDUqx5e/NNiutgByfLUd3xL1H.74Wf.827XRHu', 'perye_user', 5, '15759115151', 14, '2019-12-17 15:01:43', NULL, 'perye_user', '男');
COMMIT;

-- ----------------------------
-- Table structure for user_avatar
-- ----------------------------
DROP TABLE IF EXISTS `user_avatar`;
CREATE TABLE `user_avatar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE,
  KEY `FKq4eq273l04bpu4efj0jd0jb98` (`role_id`) USING BTREE,
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of users_roles
-- ----------------------------
BEGIN;
INSERT INTO `users_roles` VALUES (1, 1);
INSERT INTO `users_roles` VALUES (6, 1);
INSERT INTO `users_roles` VALUES (3, 2);
INSERT INTO `users_roles` VALUES (7, 3);
COMMIT;

-- ----------------------------
-- Table structure for verification_code
-- ----------------------------
DROP TABLE IF EXISTS `verification_code`;
CREATE TABLE `verification_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `code` varchar(255) DEFAULT NULL COMMENT '验证码',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `status` bit(1) DEFAULT NULL COMMENT '状态：1有效、0过期',
  `type` varchar(255) DEFAULT NULL COMMENT '验证码类型：email或者短信',
  `value` varchar(255) DEFAULT NULL COMMENT '接收邮箱或者手机号码',
  `scenes` varchar(255) DEFAULT NULL COMMENT '业务名称：如重置邮箱、重置密码等',
  `is_delete` bit(1) DEFAULT b'0',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of verification_code
-- ----------------------------
BEGIN;
INSERT INTO `verification_code` VALUES (1, '598339', '2019-12-07 23:58:06', b'0', 'email', '11143526@qq.com', '重置邮箱', b'0', '2019-12-08 00:03:06');
INSERT INTO `verification_code` VALUES (2, '408142', '2019-12-07 23:58:56', b'0', 'email', '1303306125@qq.com', '重置邮箱', b'0', '2019-12-08 00:03:56');
INSERT INTO `verification_code` VALUES (3, '382006', '2019-12-08 00:08:29', b'0', 'email', '11143526@qq.com', '重置邮箱', b'0', '2019-12-08 00:13:29');
COMMIT;

-- ----------------------------
-- Table structure for visits
-- ----------------------------
DROP TABLE IF EXISTS `visits`;
CREATE TABLE `visits` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `ip_counts` bigint(20) DEFAULT NULL,
  `pv_counts` bigint(20) DEFAULT NULL,
  `week_day` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_11aksgq87euk9bcyeesfs4vtp` (`date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of visits
-- ----------------------------
BEGIN;
INSERT INTO `visits` VALUES (108, '2019-12-07 20:56:37', '2019-12-07', 1, 7, '星期六');
INSERT INTO `visits` VALUES (109, '2019-12-08 00:00:01', '2019-12-08', 1, 6, '星期日');
INSERT INTO `visits` VALUES (110, '2019-12-10 08:49:01', '2019-12-10', 3, 19, '星期二');
INSERT INTO `visits` VALUES (111, '2019-12-11 00:04:57', '2019-12-11', 1, 13, '星期三');
INSERT INTO `visits` VALUES (112, '2019-12-12 09:09:07', '2019-12-12', 1, 19, '星期四');
INSERT INTO `visits` VALUES (113, '2019-12-13 09:59:26', '2019-12-13', 1, 9, '星期五');
INSERT INTO `visits` VALUES (114, '2019-12-14 15:21:41', '2019-12-14', 2, 6, '星期六');
INSERT INTO `visits` VALUES (115, '2019-12-15 00:00:00', '2019-12-15', 3, 7, '星期日');
INSERT INTO `visits` VALUES (116, '2019-12-16 10:04:22', '2019-12-16', 2, 8, '星期一');
INSERT INTO `visits` VALUES (117, '2019-12-17 08:58:45', '2019-12-17', 1, 16, '星期二');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
