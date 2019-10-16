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

 Date: 16/10/2019 11:35:14
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
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES (1, 'test', 'test', 10, 100, 1, NULL);
INSERT INTO `building` VALUES (2, '京华5栋', '北师大京华五栋', 9, 660, 3, NULL);

-- ----------------------------
-- Table structure for complaint_and_suggestion_sheet
-- ----------------------------
DROP TABLE IF EXISTS `complaint_and_suggestion_sheet`;
CREATE TABLE `complaint_and_suggestion_sheet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proprietorId` int(11) NULL DEFAULT NULL COMMENT '提交投诉建议单的业主Id',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单子状态',
  `submitTime` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `processingTime` datetime(0) NULL DEFAULT NULL COMMENT '处理时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_ComplaintAndSuggestionSheet`(`proprietorId`) USING BTREE,
  CONSTRAINT `fk_ComplaintAndSuggestionSheet` FOREIGN KEY (`proprietorId`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '投诉建议单 表' ROW_FORMAT = Dynamic;

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
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_house`(`buildingId`) USING BTREE,
  CONSTRAINT `fk_house` FOREIGN KEY (`buildingId`) REFERENCES `building` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES (1, 322, 41.00, '北', 3, 2);
INSERT INTO `house` VALUES (2, 323, 41.00, '北', 3, 2);
INSERT INTO `house` VALUES (3, 323, 40.50, '北', 3, 2);

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
  `fee` decimal(10, 3) NULL DEFAULT NULL COMMENT '费用',
  `isPaid` tinyint(4) NULL DEFAULT NULL COMMENT '是否已缴费',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
-- Records of property
-- ----------------------------
INSERT INTO `property` VALUES (1, '翠湖香山', '广东省珠海市香洲区', 123);
INSERT INTO `property` VALUES (2, '京师家园', '广东省珠海市香洲区金凤路18号', 519087);
INSERT INTO `property` VALUES (3, '京华苑', '广东省珠海市香洲区金凤路18号', 5555);
INSERT INTO `property` VALUES (4, '海华苑', '广东省珠海市香洲区金凤路18号', 4);
INSERT INTO `property` VALUES (5, '燕华苑', '广东省珠海市香洲区金凤路18号', 5);
INSERT INTO `property` VALUES (6, '粤华苑', '广东省珠海市香洲区金凤路18号', 6);
INSERT INTO `property` VALUES (7, '励耘楼', '广东省珠海市香洲区金凤路18号', 7);
INSERT INTO `property` VALUES (8, '丽泽楼', '广东省珠海市香洲区金凤路18号', 8);
INSERT INTO `property` VALUES (9, '123', '123', 123);
INSERT INTO `property` VALUES (10, '321', '321', 321);
INSERT INTO `property` VALUES (11, '京师家园2', '广东省珠海市香洲区金凤路18号', 5190872);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userID',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名(昵称)',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role` int(11) NULL DEFAULT NULL COMMENT '用户角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'hovees', 'hovees', '$2a$10$w79UYbBnJuLILvKaUoKUse8d/n3aMBzYw86uuP/ciy4w2E6QtWugq', 1);
INSERT INTO `user` VALUES (2, '0', '0', '$2a$10$GwuxgbQzSwJ8/vK27sduJuGAb3LZlPh9Q1vOriWGFRNyf/oCWLjdm', 0);
INSERT INTO `user` VALUES (3, '1', '1', '$2a$10$8nIM0dZ/VrKugRG3fL6f..An5Rfw7oJ5WhyqcjlA1Pyx7CU9ukJ5i', 1);
INSERT INTO `user` VALUES (4, '2', '2', '$2a$10$wyKX2d3Ix41MJ14N/oksQuAy3.IM0Gj/ZFxKiGZbit9.Yp3/5rSIi', 2);

SET FOREIGN_KEY_CHECKS = 1;
