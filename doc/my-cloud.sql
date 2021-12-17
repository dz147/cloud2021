/*
 Navicat Premium Data Transfer

 Source Server         : parent-dev
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : my-cloud

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 17/12/2021 16:11:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `serial` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES (31, '尚硅谷111');
INSERT INTO `payment` VALUES (32, 'atguigu002');
INSERT INTO `payment` VALUES (34, 'atguigu002');
INSERT INTO `payment` VALUES (35, 'atguigu002');

SET FOREIGN_KEY_CHECKS = 1;
