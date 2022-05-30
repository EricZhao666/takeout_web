/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : takeout_web

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 30/05/2022 15:59:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收藏ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `good_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`(4)) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('1653491441311899', '3', '1653486921074346');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布者ID',
  `good_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品ID',
  `content` varchar(16383) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '评论发布时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1653491305413759', '3', '1653489149871405', '去年的东西还来卖？', '2022-05-25 23:08:25');

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  `good_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型',
  `seller_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卖家ID',
  `buyer_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家ID',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易状态',
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片URL',
  `create_time` datetime NULL DEFAULT NULL COMMENT '上架时间（创造时间）',
  `update_time` datetime NULL DEFAULT NULL COMMENT '交易时间（更新时间）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES ('1653486921074346', '奥特曼风筝，橙色95新', 50.00, '玩具', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534869210743461.jpg', '2022-05-14 22:22:32', '2022-05-14 22:22:32');
INSERT INTO `good` VALUES ('1653488889628480', '全新vans', 299.00, '鞋子', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534888896284801.jpg', '2022-05-14 22:22:32', '2022-05-14 22:22:32');
INSERT INTO `good` VALUES ('1653489137681870', '计院限定口罩', 666.00, '生活用品', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534891376818701.jpg', '2022-05-14 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653489149871405', '去年的台历', 30.00, '生活用品', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534891498714051.jpg', '2022-05-14 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653489174755630', '菌宝同款-阿尔飞斯小包包中号', 50.00, '生活用品', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534891747556301.jpg', '2022-05-14 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653489548953841', '试轴器', 54.00, '电子垃圾', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534895489538411.jpg', '2022-05-14 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653489580703924', '佳能eos500n移动胶片单反，搭配小痰盂镜头，爽快送一卷胶片', 654.00, '电子垃圾', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534895807039241.jpg', '2022-05-14 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653489655820937', '刘西蒙同款外套', 4949.00, '生活用品', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534896558209371.jpg 4934d114v1.qicp.vip/image/16534896558209372.jpg', '2022-05-14 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653489930985988', '三个本子', 6.00, '学习用品', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534899309859881.jpg', '2022-05-14 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653490019757910', '耳机', 50.00, '电子垃圾', '2', '', '上架中', '4934d114v1.qicp.vip/image/16534900197579101.jpg', '2022-05-25 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653490057140722', '佳能300定镜头', 865.00, '电子垃圾', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534900571407221.jpg', '2022-05-25 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653490309782265', '一些饰品，价格私聊', 20.00, '饰品', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534903097822651.jpg', '2022-05-25 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653490456816334', '皮鞋一个', 220.00, '生活用品', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534904568163341.jpg', '2022-05-25 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653490550862736', '书', 20.00, '书籍', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534905508627361.jpg', '2022-05-25 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('1653490771271852', '网易云音乐会员一/网易云vip一年网易云黑胶会员一年\r\n到账360天+\r\n下单联系客服', 42.00, '虚拟物品', '2', NULL, '上架中', '4934d114v1.qicp.vip/image/16534907712718521.jpg', '2022-05-25 22:22:32', '2022-05-25 22:22:32');
INSERT INTO `good` VALUES ('9546873265986157', '佳能rf1845镜头', 8350.00, '光学镜头', '2', '', '上架中', '4934d114v1.qicp.vip/image/95468732659861571.jpg', '2022-05-14 22:22:32', '2022-05-14 22:22:32');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `good_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES ('1653730763907264', '3', '1653486921074346', '2022-05-28 17:39:24');
INSERT INTO `history` VALUES ('1653730779832890', '3', '1653486921074346', '2022-05-28 17:39:40');
INSERT INTO `history` VALUES ('1653744479247717', '2', '1653489137681870', '2022-05-28 21:27:59');

-- ----------------------------
-- Table structure for order_form
-- ----------------------------
DROP TABLE IF EXISTS `order_form`;
CREATE TABLE `order_form`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  `good_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品ID',
  `good_descrip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型',
  `seller_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卖家ID',
  `buyer_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家ID',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易状态',
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片URL',
  `create_time` datetime NULL DEFAULT NULL COMMENT '上架时间（创造时间）',
  `update_time` datetime NULL DEFAULT NULL COMMENT '交易时间（更新时间）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order_form
-- ----------------------------
INSERT INTO `order_form` VALUES ('1652538151528848', '1652538151528848', '123', 123.20, '123', '2', '3', '交易关闭', NULL, '2022-05-14 22:22:32', '2022-05-14 22:22:32');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `fail` int NULL DEFAULT NULL COMMENT '审核失败次数',
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '$2a$10$NvNIMb7YMFKOxpTzvrrrJuoiFfRGeJdrW7K60NRnitoOZSApucIBa', 'admin', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891462967218', 'Jeacson_sonic', '$2a$10$WytQc8T0EggkL8m217rrz.HRGpD7RyPgAiimebdv4GMqUaLsQ/Fzq', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891516823907', 'ttt', '$2a$10$tztgp4z6yRK1z4cH7L5KauDqDsTOZQjU0b3TOnjp1CV37QL78Dxpm', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891521206926', 'ttk', '$2a$10$BCVhYtUgo38Z9FkSMMkXo.35vGSCxS084DIVCVKF5qZzP35ugutI6', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891526781696', 'zhaoRRR', '$2a$10$G/.vv26L2mE6AuytZ.jd4ej74rT4XfzIArFEKKTOQV0HntpGsKoDW', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891529739387', 'zhaoRR', '$2a$10$t0j09eeLqMAzFi7UBn.1lel6wO8QBlQaRBQ3eMy2MXugQv2WcYpbq', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891531792576', 'zhao', '$2a$10$BRWBFukqhghsc1nt.//lM.pPGTbxJSaW6e3ADWPK8t9fI1M/Bl3xm', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891534104137', 'zha', '$2a$10$JWu5eRY5W41nXVMDOCje6eLOQN90NBgrp1ocDWvtVAJmYOpkO8R12', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891536879715', 'zhaq', '$2a$10$TZNPbceRvm0wWoQzJD6xHe5q0BjVE.39A9HHohwicYO0AI94Sb1Om', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891540152752', 'zde', '$2a$10$CxZMfTqLUqD5z9joS2i6B.F6KfFXczDMyLA1fZmF5O4p8uDVmyyyq', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891545422415', 'zrt', '$2a$10$jgS7VJeMFU5Qzt.OP8y6yOPccmyRvAjIdg/Lx0CkhMIQQnolnrgvS', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891550332399', 'rty', '$2a$10$2l2Yf/9wlT7YKtswrSZ2vubB3D6Ogmlig1q0n5I4MJS.vLy6EXorS', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891555478774', 'iuo', '$2a$10$LnKAouw.7FkAiGWw7emjZ.cXlRMUIW/j0BS5ef/0qMsYJ9z.5/CY.', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891561579634', 'hty', '$2a$10$2pnG0WmMyvD41GYVyCW6QOoz82exHeC6SD/isLIr04/8CwNMapcJ2', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('1653891565207209', 'sas', '$2a$10$bBJCWi8uU4CwwPkcTpWM7.T0joAH4QqfoU7Lg/rAPkom0BB9n9e/C', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('2', '卖家', '$2a$10$tBRMg2PxPvtG5riXViuO2eZvFIAEEt1azdcYkyn2L8JF10743qoF2', 'user', '', 0, NULL);
INSERT INTO `user` VALUES ('3', '买家', '$2a$10$HuZYXKEPzQls77UoLzAjg.478rejKqkQciFa5T6ET/EVPrwjRW6.G', 'user', '', 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
