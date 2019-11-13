SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for birthday
-- ----------------------------
DROP TABLE IF EXISTS `birthday`;
CREATE TABLE `birthday`
(
    `id`            int(11)                                                      NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
    `birthday`      int(11)                                                      NULL DEFAULT NULL COMMENT '生日，格式为yyyyMMdd转int,农历为负数',
    `remind_config` int(11)                                                   NULL DEFAULT NULL COMMENT '提前提醒配置 秒数',
    `next_birthday` date                                                         NULL DEFAULT NULL COMMENT '下一次生日对应时间',
    `remind_time`   datetime                                                     NULL DEFAULT NULL COMMENT '下一次提醒时间',
    `user_id`       int(11)                                                      NULL DEFAULT NULL COMMENT '所属用户id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '生日提醒表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`              int(11)                                                NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`            varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
    `password`        varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加密后的密码',
    `salt`            varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加密使用的盐',
    `email`           varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
    `phone_number`    varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
    `status`          int(2)                                                 NOT NULL DEFAULT 1 COMMENT '状态，-1：逻辑删除，0：禁用，1：启用',
    `last_login_time` datetime                                               NULL     DEFAULT NULL COMMENT '最后一次登录时间',
    `create_time`     datetime                                               NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
    `update_time`     datetime                                               NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最近修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `name` (`name`) USING BTREE,
    UNIQUE INDEX `email` (`email`) USING BTREE,
    UNIQUE INDEX `phone_number` (`phone_number`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户表'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
