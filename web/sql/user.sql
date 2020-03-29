/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : welive

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 29/03/2020 16:34:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'chang', '123123', 'ityun', '969842624@qq.com', NULL, '男');
INSERT INTO `user` VALUES (2, 'li', '123123', 'itli', '969842624@qq.com', NULL, '男');
INSERT INTO `user` VALUES (3, NULL, NULL, 'test', '9999@qq.com', '1991-12-18', '男');
INSERT INTO `user` VALUES (4, NULL, NULL, 'test', '9999@qq.com', '1991-12-18', '男');
INSERT INTO `user` VALUES (5, NULL, NULL, 'test add', '8888@qq.com', '1992-11-11', '女');
INSERT INTO `user` VALUES (6, NULL, NULL, 'test show', '7777@qq.com', '1995-04-15', '女');

SET FOREIGN_KEY_CHECKS = 1;
