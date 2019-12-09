/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 08/12/2019 22:25:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `oid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pid` int(11) NOT NULL,
  `buynum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`oid`, `pid`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  INDEX `oid`(`oid`) USING BTREE,
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('3a598897-f8a6-4b6b-893d-c329402642ee', 2, 1);
INSERT INTO `orderitem` VALUES ('3b7f44ba-d20e-4a0f-b938-0ab2344054f8', 2, 1);
INSERT INTO `orderitem` VALUES ('3d4ed4c4-610c-4883-a307-31f4d79a59a9', 4, 1);
INSERT INTO `orderitem` VALUES ('403439ba-2f2b-4682-8493-361a55af6181', 1, 1);
INSERT INTO `orderitem` VALUES ('403439ba-2f2b-4682-8493-361a55af6181', 2, 1);
INSERT INTO `orderitem` VALUES ('44e3446b-3b5d-467b-8f91-2d5ed4171a28', 6, 2);
INSERT INTO `orderitem` VALUES ('4f364693-153e-4a0f-a13e-677229ef9cda', 1, 2);
INSERT INTO `orderitem` VALUES ('774164f8-cacc-4c84-b9be-2913889682b4', 1, 1);
INSERT INTO `orderitem` VALUES ('846af693-1607-4b7c-9f5e-3a0c0b348ca6', 1, 1);
INSERT INTO `orderitem` VALUES ('8f271525-da15-4f80-ac85-9ece44303e08', 3, 1);
INSERT INTO `orderitem` VALUES ('8f271525-da15-4f80-ac85-9ece44303e08', 4, 1);
INSERT INTO `orderitem` VALUES ('b9a7dc58-117f-4420-aa12-ae55d64b7da7', 11, 1);
INSERT INTO `orderitem` VALUES ('b9a7dc58-117f-4420-aa12-ae55d64b7da7', 12, 1);
INSERT INTO `orderitem` VALUES ('bc6f2232-c776-4580-aeb5-182467594e7d', 9, 1);
INSERT INTO `orderitem` VALUES ('c65b29d1-8e80-4e74-bd3f-1e6873579f3f', 13, 1);
INSERT INTO `orderitem` VALUES ('d2b8ad7e-8858-42e3-94b9-b589ba77447e', 3, 1);
INSERT INTO `orderitem` VALUES ('d40fb6de-b9e8-4ee2-8adf-868d7f9eb063', 3, 1);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `oid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `money` double NULL DEFAULT NULL,
  `receiverAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiverName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiverPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paystate` int(11) NULL DEFAULT NULL,
  `ordertime` timestamp(4) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(4),
  `uid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `oid` FOREIGN KEY (`oid`) REFERENCES `orderitem` (`oid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('3a598897-f8a6-4b6b-893d-c329402642ee', 66, '中山', '露露', '12222222', 1, '2019-12-08 17:14:53.5751', 1);
INSERT INTO `orders` VALUES ('403439ba-2f2b-4682-8493-361a55af6181', 121, '西安', '李可可', '12345678956', 1, '2019-12-08 20:29:44.7333', 1);
INSERT INTO `orders` VALUES ('4f364693-153e-4a0f-a13e-677229ef9cda', 110, '中山', '浩浩', '11233333', 1, '2019-12-08 00:40:36.8521', 1);
INSERT INTO `orders` VALUES ('846af693-1607-4b7c-9f5e-3a0c0b348ca6', 55, '中山', '丽丽', '11233333', 1, '2019-12-08 00:47:52.2598', 1);
INSERT INTO `orders` VALUES ('b9a7dc58-117f-4420-aa12-ae55d64b7da7', 110, '北京', '菲菲', '4433322222', 0, '2019-12-07 23:39:30.2560', 1);
INSERT INTO `orders` VALUES ('bc6f2232-c776-4580-aeb5-182467594e7d', 66, '北京', '火狐', '233333222', 0, '2019-12-08 00:07:49.1400', 1);
INSERT INTO `orders` VALUES ('c65b29d1-8e80-4e74-bd3f-1e6873579f3f', 44, '中山', '露露', '22221111122', 1, '2019-12-08 00:22:55.0285', 1);
INSERT INTO `orders` VALUES ('d2b8ad7e-8858-42e3-94b9-b589ba77447e', 99, '北京', '欧欧', '4433322222', 0, '2019-12-08 00:16:38.1580', 1);
INSERT INTO `orders` VALUES ('d40fb6de-b9e8-4ee2-8adf-868d7f9eb063', 99, '中山', '露露', '11233333', 1, '2019-12-08 00:14:43.6908', 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imgurl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pnum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '零基础学Java', 55.00, '计算机', 'bookcover/101.jpg', 'Java', 96);
INSERT INTO `product` VALUES (2, '零基础学PHP', 66.00, '计算机', 'bookcover/102.jpg', 'PHP', 64);
INSERT INTO `product` VALUES (3, '零基础学C语言', 99.00, '计算机', 'bookcover/103.jpg', 'C语言', 44);
INSERT INTO `product` VALUES (4, '零基础学大数据', 55.00, '计算机', 'bookcover/104.jpg', '大数据', 55);
INSERT INTO `product` VALUES (5, '零基础学MySQL', 66.00, '计算机', 'bookcover/105.jpg', 'MySQL', 88);
INSERT INTO `product` VALUES (6, '火狐', 55.00, '文学', 'bookcover/106.jpg', '火狐', 55);
INSERT INTO `product` VALUES (7, 'java1', 33.00, '计算机', 'bookcover/107.jpg', 'java', 66);
INSERT INTO `product` VALUES (8, 'c1', 55.00, '计算机', 'bookcover/code.jpg', 'c', 55);
INSERT INTO `product` VALUES (9, 'php', 66.00, '计算机', 'bookcover/euro.jpg', 'php', 55);
INSERT INTO `product` VALUES (10, 'js', 66.00, '计算机', 'bookcover/java2.jpg', 'js', 99);
INSERT INTO `product` VALUES (11, '西游记', 55.00, '文学', 'bookcover/euro.jpg', '《西游记》由吴承恩(中国)编写，语言为中文。\r\n藏道：“悟空，你看那日落西山藏火镜，月升东海现冰轮。幸而道旁有一人家，我们且借宿一宵，明日再走。”八戒道：“说得是，我老猪也有些饿了，且到人家化些斋吃，有力气，好挑行李。”行者道：“这个恋家鬼！你离了家几日，就生报怨！”八戒道：“哥啊，似不得你这喝风呵烟', 66);
INSERT INTO `product` VALUES (12, '背影', 55.00, '文学', 'bookcover/106.jpg', '《背影》由三毛(中国)编写，语言为中文。\r\n两年多以前的夏天，我回国去看望久别的父母，虽然只在家里居住了短短的两个月，可是该见的亲友却也差不多见到了。\r\n在跟随父母拜访长一辈的的父执时，总有人会忍不住说出这样的话来∶“想不到那个当', 66);
INSERT INTO `product` VALUES (13, '子夜', 44.00, '文学', 'bookcover/105.jpg', '20世纪30年代的中国，尽管民生凋敝、战乱不止，在都市化的上海却是另一番景象。这里，有纸醉金迷的生活，有明争暗斗的算计，有趋炎附势的各色人物', 55);
INSERT INTO `product` VALUES (14, '红高梁家族', 66.00, '文学', 'bookcover/102.jpg', '《红高粱家族》是莫言向中国当代文学奉献的一部影响巨大的作品，被译成近二十种文字在全世界发行。他本书中创造了他的文学王国高密东北乡', 66);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'fyu', '123456789@qq.com', '123456', '男', '13822968055', '哈哈哈');
INSERT INTO `user` VALUES (2, 'lhtyyy', '1234456@qq.com', '44444666', '男', '12345678976', 'rrrrrrrffff');
INSERT INTO `user` VALUES (3, 'lhteee', '1234567@qq.com', '123456', '女', '1234565555', '哈哈哈');
INSERT INTO `user` VALUES (4, 'lhteee', '1234567@qq.com', '123456', '女', '1234565555', '哈哈哈');
INSERT INTO `user` VALUES (5, 'ioop', '12344567@qq.com', '123456', '男', '12345678976', '突突突突突突过');
INSERT INTO `user` VALUES (6, 'lhtfyu', '1799573106@qq.com', '123456', '男', '13822968044', '越努力越幸运');
INSERT INTO `user` VALUES (7, 'oppopp', '1234567@qq.com', '123456', '女', '13822968088', '发到付大哥大哥哥风高放火');

SET FOREIGN_KEY_CHECKS = 1;
