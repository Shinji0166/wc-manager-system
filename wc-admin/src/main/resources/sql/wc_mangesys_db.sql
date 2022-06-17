/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云RDS
 Source Server Type    : MySQL
 Source Server Version : 80025
 Date: 15/06/2022 01:46:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for country_region
-- ----------------------------
DROP TABLE IF EXISTS `country_region`;
CREATE TABLE `country_region` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `province_name` tinyint DEFAULT NULL COMMENT '省份名称(取自字典值)',
  `city_name` tinyint DEFAULT NULL COMMENT '城市名称(取自字典值)',
  `region_name` tinyint DEFAULT NULL COMMENT '地区名称(取自字典值)',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用)',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `is_logout` tinyint DEFAULT NULL COMMENT '是否注销(0是 1否)',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='地域表';

-- ----------------------------
-- Records of country_region
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for device_info
-- ----------------------------
DROP TABLE IF EXISTS `device_info`;
CREATE TABLE `device_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `code` varchar(255) DEFAULT NULL COMMENT '设备编码',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用)',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `is_logout` tinyint DEFAULT NULL COMMENT '是否注销(0是 1否)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='设备信息';

-- ----------------------------
-- Records of device_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pit_position_device
-- ----------------------------
DROP TABLE IF EXISTS `pit_position_device`;
CREATE TABLE `pit_position_device` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pit_position_id` bigint DEFAULT NULL COMMENT '坑位ID',
  `device_id` bigint DEFAULT NULL COMMENT '设备ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='坑位设备关联表';

-- ----------------------------
-- Records of pit_position_device
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pit_position_info
-- ----------------------------
DROP TABLE IF EXISTS `pit_position_info`;
CREATE TABLE `pit_position_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '坑位名称',
  `toilet_id` bigint DEFAULT NULL COMMENT '关联公厕ID',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用)',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='坑位信息';

-- ----------------------------
-- Records of pit_position_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `code` varchar(255) DEFAULT NULL COMMENT '部门编码',
  `parent_id` bigint DEFAULT NULL COMMENT '父级ID',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_label` varchar(255) DEFAULT NULL COMMENT '字典标签',
  `dict_value` varchar(255) DEFAULT NULL COMMENT '字典值',
  `dict_type` varchar(255) DEFAULT NULL COMMENT '字典类型',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用)',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `lable` varchar(255) DEFAULT NULL COMMENT '字典名称',
  `type` varchar(255) DEFAULT NULL COMMENT '字典类型名称',
  `classify` varchar(255) DEFAULT NULL COMMENT '字典分类',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用)',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_login_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_info`;
CREATE TABLE `sys_login_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '登录用户ID',
  `status` tinyint DEFAULT NULL COMMENT '登录状态',
  `create_by` varchar(255) DEFAULT NULL COMMENT '登录用户',
  `create_time` datetime DEFAULT NULL COMMENT '登录时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='登录日志';

-- ----------------------------
-- Records of sys_login_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_meun
-- ----------------------------
DROP TABLE IF EXISTS `sys_meun`;
CREATE TABLE `sys_meun` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编码',
  `auth_flag` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用)',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `is_logout` tinyint DEFAULT NULL COMMENT '是否注销(0是 1否)',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_meun
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_operator_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operator_log`;
CREATE TABLE `sys_operator_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `req_api` varchar(255) DEFAULT NULL COMMENT '请求api接口',
  `req_parement` varchar(255) DEFAULT NULL COMMENT '请求参数',
  `status` tinyint DEFAULT NULL COMMENT '操作状态',
  `create_by` varchar(255) DEFAULT NULL COMMENT '请求用户',
  `create_time` datetime DEFAULT NULL COMMENT '请求时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统操作日志';

-- ----------------------------
-- Records of sys_operator_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用)',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `is_logout` tinyint DEFAULT NULL COMMENT '是否注销(0是 1否)',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role_meun
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_meun`;
CREATE TABLE `sys_role_meun` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `meun_id` bigint DEFAULT NULL COMMENT '菜单/权限ID',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限关联表';

-- ----------------------------
-- Records of sys_role_meun
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `pass_word` varchar(255) DEFAULT NULL COMMENT '密码',
  `avater` varchar(255) DEFAULT NULL COMMENT '头像',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用)',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `is_admin` tinyint DEFAULT NULL COMMENT '是否管理员(0是 1否)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for toilet_info
-- ----------------------------
DROP TABLE IF EXISTS `toilet_info`;
CREATE TABLE `toilet_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '公厕名称',
  `code` varchar(255) DEFAULT NULL COMMENT '公厕编码',
  `location` varchar(255) DEFAULT NULL COMMENT '位置(wkt)',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用)',
  `is_common` tinyint DEFAULT NULL COMMENT '是否为公厕(0是 1否)',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `is_logout` tinyint DEFAULT NULL COMMENT '是否注销(0是 1否)',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='公厕信息';

-- ----------------------------
-- Records of toilet_info
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
