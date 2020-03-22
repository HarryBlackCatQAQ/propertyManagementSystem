/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : property_management_system

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 21/03/2020 22:59:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '楼栋名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '楼栋地址',
  `layer` int(11) NULL DEFAULT NULL COMMENT '楼栋层数',
  `houseHold` int(11) NULL DEFAULT NULL COMMENT '楼栋户数',
  `propertyId` int(11) NULL DEFAULT NULL COMMENT '所属楼盘Iid',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '楼栋备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_building`(`propertyId`) USING BTREE,
  CONSTRAINT `fk_building` FOREIGN KEY (`propertyId`) REFERENCES `property` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '楼栋表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for complaint_and_suggestion_sheet
-- ----------------------------
DROP TABLE IF EXISTS `complaint_and_suggestion_sheet`;
CREATE TABLE `complaint_and_suggestion_sheet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投诉建议单Id',
  `proprietorId` int(11) NULL DEFAULT NULL COMMENT '单子创建用户ID',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单子状态',
  `submitTime` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `processingTime` datetime(0) NULL DEFAULT NULL COMMENT '最新处理时间',
  `userNickName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `sheetType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单子类型',
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '投书建议单内容(备注)',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主题',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_ComplaintAndSuggestionSheet`(`proprietorId`) USING BTREE,
  CONSTRAINT `fk_ComplaintAndSuggestionSheet` FOREIGN KEY (`proprietorId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '投诉建议单 表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for complaint_and_suggestion_sheet_image
-- ----------------------------
DROP TABLE IF EXISTS `complaint_and_suggestion_sheet_image`;
CREATE TABLE `complaint_and_suggestion_sheet_image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sheetId` int(11) NULL DEFAULT NULL COMMENT '投诉建议单Id',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_complaint_and_suggestion_sheet_Image`(`sheetId`) USING BTREE,
  CONSTRAINT `fk_complaint_and_suggestion_sheet_Image` FOREIGN KEY (`sheetId`) REFERENCES `complaint_and_suggestion_sheet` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for complaint_and_suggestion_sheet_timeline
-- ----------------------------
DROP TABLE IF EXISTS `complaint_and_suggestion_sheet_timeline`;
CREATE TABLE `complaint_and_suggestion_sheet_timeline`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '时间表id',
  `sheetId` int(11) NULL DEFAULT NULL COMMENT '时间表所属单子id',
  `processingTime` datetime(0) NULL DEFAULT NULL COMMENT '处理时间',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理信息',
  `processingUserNickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理人的昵称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_complaint_and_suggestion_sheet_timeline`(`sheetId`) USING BTREE,
  CONSTRAINT `fk_complaint_and_suggestion_sheet_timeline` FOREIGN KEY (`sheetId`) REFERENCES `complaint_and_suggestion_sheet` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '投诉建议表的时间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for equipment_purchase
-- ----------------------------
DROP TABLE IF EXISTS `equipment_purchase`;
CREATE TABLE `equipment_purchase`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `applicantId` int(11) NULL DEFAULT NULL COMMENT '申请人id',
  `reviewerId` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `amount` int(11) NULL DEFAULT NULL COMMENT '数量',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `reviewTime` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `completeTime` datetime(0) NULL DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `applicantId`(`applicantId`) USING BTREE,
  INDEX `auditorId`(`reviewerId`) USING BTREE,
  CONSTRAINT `applicantId` FOREIGN KEY (`applicantId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auditorId` FOREIGN KEY (`reviewerId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for feedback_message
-- ----------------------------
DROP TABLE IF EXISTS `feedback_message`;
CREATE TABLE `feedback_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sheetId` int(11) NULL DEFAULT NULL COMMENT '单子的ID',
  `feedBackTime` datetime(0) NULL DEFAULT NULL COMMENT '回馈时间',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_feedback_message`(`sheetId`) USING BTREE,
  CONSTRAINT `fk_feedback_message` FOREIGN KEY (`sheetId`) REFERENCES `complaint_and_suggestion_sheet` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NULL DEFAULT NULL COMMENT '房屋门牌',
  `area` decimal(10, 2) NULL DEFAULT NULL COMMENT '房屋面积',
  `direction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '房屋朝向',
  `floor` int(11) NULL DEFAULT NULL COMMENT '房屋楼层',
  `buildingId` int(11) NULL DEFAULT NULL COMMENT '所属楼栋Id',
  `userId` int(11) NULL DEFAULT NULL COMMENT '用户Id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_house`(`buildingId`) USING BTREE,
  CONSTRAINT `fk_house` FOREIGN KEY (`buildingId`) REFERENCES `building` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for house_fee_publish_record
-- ----------------------------
DROP TABLE IF EXISTS `house_fee_publish_record`;
CREATE TABLE `house_fee_publish_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `paymentName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '费用名字',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '费用价格(元/平方米)',
  `publishTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `publisherId` int(11) NOT NULL COMMENT '发布人id',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `publisherId`(`publisherId`) USING BTREE,
  CONSTRAINT `publisherId` FOREIGN KEY (`publisherId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for house_fee_record
-- ----------------------------
DROP TABLE IF EXISTS `house_fee_record`;
CREATE TABLE `house_fee_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `propertyId` int(11) NULL DEFAULT NULL COMMENT '所属楼盘Id',
  `buildingId` int(11) NULL DEFAULT NULL COMMENT '所属楼栋Id',
  `houseId` int(11) NULL DEFAULT NULL COMMENT '房屋ID',
  `year` int(11) NULL DEFAULT NULL COMMENT '年份',
  `month` int(11) NULL DEFAULT NULL COMMENT '月份',
  `fee` decimal(10, 2) NULL DEFAULT NULL COMMENT '费用',
  `isPaid` tinyint(4) NULL DEFAULT 0 COMMENT '是否已缴费',
  `outTradeNo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付单号',
  `payType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付方式',
  `payTime` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for log_file
-- ----------------------------
DROP TABLE IF EXISTS `log_file`;
CREATE TABLE `log_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `level` int(255) NULL DEFAULT NULL COMMENT '文件目录深度',
  `fileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名字',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `isDir` int(11) NULL DEFAULT NULL COMMENT '是否为文件夹',
  `preLevelName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上一级名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '楼盘名称',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '楼盘位置',
  `uid` bigint(20) NOT NULL COMMENT '楼盘编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '楼盘表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userID',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名(昵称)',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `emailAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `role` int(11) NULL DEFAULT NULL COMMENT '用户角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
