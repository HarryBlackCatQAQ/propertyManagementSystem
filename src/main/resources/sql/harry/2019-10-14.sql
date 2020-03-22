/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80014
 Source Host           : localhost:3306
 Source Schema         : property_management_system

 Target Server Type    : MySQL
 Target Server Version : 80014
 File Encoding         : 65001

 Date: 14/10/2019 18:40:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '楼栋名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '楼栋地址',
  `layer` int(11) DEFAULT NULL COMMENT '楼栋层数',
  `houseHold` int(11) DEFAULT NULL COMMENT '楼栋户数',
  `uid` bigint(20) DEFAULT NULL COMMENT '楼栋编号',
  `propertyUid` bigint(20) DEFAULT NULL COMMENT '所属楼盘Uid',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '楼栋备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_buliding` (`propertyUid`) USING BTREE,
  CONSTRAINT `fk_buliding` FOREIGN KEY (`propertyUid`) REFERENCES `property` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='楼栋表';

-- ----------------------------
-- Table structure for complaint_and_suggestion_sheet
-- ----------------------------
DROP TABLE IF EXISTS `complaint_and_suggestion_sheet`;
CREATE TABLE `complaint_and_suggestion_sheet` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投诉建议单Id',
  `proprietorId` int(11) DEFAULT NULL COMMENT '单子创建用户ID',
  `state` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '单子状态',
  `submitTime` datetime DEFAULT NULL COMMENT '提交时间',
  `processingTime` datetime DEFAULT NULL COMMENT '最新处理时间',
  `userNickName` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户昵称',
  `sheetType` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '单子类型',
  `message` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '投书建议单内容(备注)',
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '主题',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_ComplaintAndSuggestionSheet` (`proprietorId`) USING BTREE,
  CONSTRAINT `fk_ComplaintAndSuggestionSheet` FOREIGN KEY (`proprietorId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='投诉建议单 表';

-- ----------------------------
-- Table structure for complaint_and_suggestion_sheet_Image
-- ----------------------------
DROP TABLE IF EXISTS `complaint_and_suggestion_sheet_Image`;
CREATE TABLE `complaint_and_suggestion_sheet_Image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sheetId` int(11) DEFAULT NULL COMMENT '投诉建议单Id',
  `path` varchar(255) DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`id`),
  KEY `fk_complaint_and_suggestion_sheet_Image` (`sheetId`),
  CONSTRAINT `fk_complaint_and_suggestion_sheet_Image` FOREIGN KEY (`sheetId`) REFERENCES `complaint_and_suggestion_sheet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for complaint_and_suggestion_sheet_timeline
-- ----------------------------
DROP TABLE IF EXISTS `complaint_and_suggestion_sheet_timeline`;
CREATE TABLE `complaint_and_suggestion_sheet_timeline` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '时间表id',
  `sheetId` int(11) DEFAULT NULL COMMENT '时间表所属单子id',
  `processingTime` datetime DEFAULT NULL COMMENT '处理时间',
  `message` varchar(255) DEFAULT NULL COMMENT '处理信息',
  `processingUserNickName` varchar(255) DEFAULT NULL COMMENT '处理人的昵称',
  PRIMARY KEY (`id`),
  KEY `fk_complaint_and_suggestion_sheet_timeline` (`sheetId`),
  CONSTRAINT `fk_complaint_and_suggestion_sheet_timeline` FOREIGN KEY (`sheetId`) REFERENCES `complaint_and_suggestion_sheet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8 COMMENT='投诉建议表的时间表';

-- ----------------------------
-- Table structure for feedback_message
-- ----------------------------
DROP TABLE IF EXISTS `feedback_message`;
CREATE TABLE `feedback_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sheetId` int(11) DEFAULT NULL COMMENT '单子的ID',
  `feedBackTime` datetime DEFAULT NULL COMMENT '回馈时间',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '反馈内容',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_feedback_message` (`sheetId`) USING BTREE,
  CONSTRAINT `fk_feedback_message` FOREIGN KEY (`sheetId`) REFERENCES `complaint_and_suggestion_sheet` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '楼盘名称',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '楼盘位置',
  `uid` bigint(20) NOT NULL COMMENT '楼盘编号',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `uid` (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='楼盘表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userID',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户账号',
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名(昵称)',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `role` int(11) DEFAULT NULL COMMENT '用户角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';

SET FOREIGN_KEY_CHECKS = 1;
