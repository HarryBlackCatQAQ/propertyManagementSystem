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

 Date: 07/10/2019 17:41:32
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
  `uid` bigint(20) NULL DEFAULT NULL COMMENT '楼栋编号',
  `propertyUid` bigint(20) NOT NULL COMMENT '所属楼盘Uid',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_buliding`(`propertyUid`) USING BTREE,
  CONSTRAINT `fk_buliding` FOREIGN KEY (`propertyUid`) REFERENCES `property` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '楼栋表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES (1, 'test', NULL, NULL, NULL, 1, 6666);

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
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '楼盘名称',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '楼盘位置',
  `uid` bigint(20) NOT NULL COMMENT '楼盘编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '楼盘表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of property
-- ----------------------------
INSERT INTO `property` VALUES (1, NULL, NULL, 1234);
INSERT INTO `property` VALUES (2, '京师家园', '广东省珠海市香洲区金凤路18号', 519087);
INSERT INTO `property` VALUES (3, '京华苑', '广东省珠海市香洲区金凤路18号', 6666);

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'hovees', 'hovees', '$2a$10$w79UYbBnJuLILvKaUoKUse8d/n3aMBzYw86uuP/ciy4w2E6QtWugq', 0);

SET FOREIGN_KEY_CHECKS = 1;
