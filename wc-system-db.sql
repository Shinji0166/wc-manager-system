/*
 Navicat Premium Data Transfer
 
 Source Server Type    : MySQL
 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 29/07/2022 15:34:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for country_region
-- ----------------------------
DROP TABLE IF EXISTS `country_region`;
CREATE TABLE `country_region` (
  `id` bigint NOT NULL COMMENT '主键',
  `province_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '省份名称',
  `city_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '城市名称',
  `region_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地区名称',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地理位置',
  `status` tinyint DEFAULT NULL COMMENT '状态(0正常 1删除)',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='地域表';

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
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备名称',
  `code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备编码',
  `index_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备机器码',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用 2在线 3离线)',
  `create_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1545727834536935425 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='设备信息';

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
  PRIMARY KEY (`id`) USING BTREE
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
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '坑位名称',
  `number` varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '坑位序号',
  `toilet_id` bigint DEFAULT NULL COMMENT '关联公厕ID',
  `status` tinyint DEFAULT NULL COMMENT '状态(0-正常 1-删除)',
  `create_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='坑位信息';

-- ----------------------------
-- Records of pit_position_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_appendix
-- ----------------------------
DROP TABLE IF EXISTS `sys_appendix`;
CREATE TABLE `sys_appendix` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '附件名',
  `url` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '附件地址',
  `data_source` tinyint DEFAULT NULL COMMENT '附件类型',
  `status` tinyint DEFAULT NULL COMMENT '状态',
  `create_by` varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='附件表';

-- ----------------------------
-- Records of sys_appendix
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '部门名称',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '部门编码',
  `parent_id` bigint DEFAULT NULL COMMENT '父级ID',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
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
  `dict_label` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典标签',
  `dict_value` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典值',
  `dict_type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典类型',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用)',
  `create_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1549578394105151489 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_data` VALUES (1545728510541299712, '男', '0', 'sex', 0, 'wudskq', '2022-07-09 19:16:10', '测试用户1', '2022-07-18 10:14:25');
INSERT INTO `sys_dict_data` VALUES (1545728539196784640, '女', '1', 'sex', 0, 'wudskq', '2022-07-09 19:16:17', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (1545728590136606720, '启用', '0', 'status', 0, 'wudskq', '2022-07-09 19:16:29', 'null', '2022-07-11 15:33:38');
INSERT INTO `sys_dict_data` VALUES (1545728652409438208, '删除', '1', 'status', 1, 'wudskq', '2022-07-09 19:16:44', 'null', '2022-07-11 15:33:56');
INSERT INTO `sys_dict_data` VALUES (1545728685997424640, '禁用', '2', 'status', 0, 'wudskq', '2022-07-09 19:16:52', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (1546693568339509248, '管理员账号', '1', 'accout_type', 0, '测试用户1', '2022-07-12 11:10:58', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (1546693600484655104, '普通账号', '2', 'accout_type', 0, '测试用户1', '2022-07-12 11:11:05', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (1547319508602060800, '目录', '0', 'res_type', 0, '测试用户1', '2022-07-14 04:38:13', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (1547319529959456768, '菜单', '1', 'res_type', 0, '测试用户1', '2022-07-14 04:38:18', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (1547319548334702592, '按钮', '2', 'res_type', 0, '测试用户1', '2022-07-14 04:38:23', '系统管理员', '2022-07-20 09:59:53');
INSERT INTO `sys_dict_data` VALUES (1548853724561145856, '测试', '1', 'sex', 1, '测试用户1', '2022-07-18 10:14:39', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (1549578394105151488, '内嵌页面', '3', 'res_type', 0, '系统管理员', '2022-07-20 10:14:14', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_number` bigint DEFAULT NULL COMMENT '字典序号',
  `label` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典名称',
  `type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典类型名称',
  `classify` tinyint DEFAULT NULL COMMENT '字典分类(0系统字典 1模块字典 2公共字典)',
  `pid` bigint DEFAULT NULL COMMENT '父级ID',
  `remark` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `status` tinyint DEFAULT NULL COMMENT '状态(0正常 1删除 2禁用)',
  `create_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1547319438871756801 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_type` VALUES (1545728011037442048, 1, '性别', 'sex', NULL, NULL, '系统用户性别字典', 0, 'wudskq', '2022-07-09 19:14:11', '2022-07-18 09:14:36', '测试用户1');
INSERT INTO `sys_dict_type` VALUES (1545728137487319040, 2, '状态', 'status', NULL, NULL, '系统数据状态', 0, 'wudskq', '2022-07-09 19:14:41', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (1546693462567550976, 3, '账号类型', 'accout_type', NULL, NULL, '账号类型', 0, '测试用户1', '2022-07-12 11:10:32', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (1547319438871756800, 4, '菜单类型', 'res_type', NULL, NULL, '菜单资源类型', 0, '测试用户1', '2022-07-14 04:37:57', '2022-07-19 19:46:36', '系统管理员');
COMMIT;

-- ----------------------------
-- Table structure for sys_interface_call
-- ----------------------------
DROP TABLE IF EXISTS `sys_interface_call`;
CREATE TABLE `sys_interface_call` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `interface_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '接口名称',
  `declaring_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '声明名称',
  `method_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '方法名称',
  `request_mode` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求方式',
  `request_ip` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求IP',
  `interface_call_count` bigint DEFAULT NULL COMMENT '接口调用次数',
  `interface_call_success_count` bigint DEFAULT NULL COMMENT '接口调用成功数',
  `interface_call_fail_count` bigint DEFAULT NULL COMMENT '接口调用失败数',
  `interface_call_time` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '接口单次回调时间',
  `interface_call_total_time` bigint DEFAULT NULL COMMENT '接口回调总时长',
  `interface_call_min_time` bigint DEFAULT NULL COMMENT '接口调用最小时长',
  `interface_call_avg_time` bigint DEFAULT NULL COMMENT '接口调用平均时长',
  `interface_call_max_time` bigint DEFAULT NULL COMMENT '接口调用最大时长',
  `interface_request_time` datetime DEFAULT NULL COMMENT '接口调用请求时间',
  `status` tinyint DEFAULT NULL COMMENT '状态(0正常 1删除)',
  `create_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='接口调用表';

-- ----------------------------
-- Records of sys_interface_call
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_login_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_info`;
CREATE TABLE `sys_login_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `browser_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '浏览器名称',
  `browser_version` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '浏览器版本',
  `operator_system` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作系统',
  `result` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '响应结果',
  `failure_reason` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '失败原因',
  `status` tinyint DEFAULT NULL COMMENT '状态(0正常 1删除)',
  `create_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登录用户',
  `create_time` datetime DEFAULT NULL COMMENT '登录时间',
  `update_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='登录日志';

-- ----------------------------
-- Records of sys_login_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_operator_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operator_log`;
CREATE TABLE `sys_operator_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `operator_module` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作模块',
  `operator_function` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作功能',
  `operator_action` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '执行动作',
  `request_mode` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求模式',
  `failure_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '失败原因',
  `result` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '响应结果',
  `create_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求用户',
  `create_time` datetime DEFAULT NULL COMMENT '请求时间',
  `update_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` tinyint DEFAULT NULL COMMENT '状态(0正常 1删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志';

-- ----------------------------
-- Records of sys_operator_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_res
-- ----------------------------
DROP TABLE IF EXISTS `sys_res`;
CREATE TABLE `sys_res` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_number` tinyint DEFAULT NULL COMMENT '序号',
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资源名称',
  `res_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资源路径',
  `permission` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限标识',
  `res_type` tinyint DEFAULT NULL COMMENT '资源类型(0目录 1菜单 2按钮)',
  `icon` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资源图标',
  `pid` bigint DEFAULT NULL COMMENT '父级ID',
  `status` tinyint DEFAULT NULL COMMENT '状态（0-正常,1-删除,2-禁用)',
  `create_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1550007302256459777 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_res
-- ----------------------------
BEGIN;
INSERT INTO `sys_res` VALUES (1547705944102797312, 1, '系统管理', NULL, 'system::manager', 0, 'el-icon-setting', 0, 0, '系统管理员', '2022-07-15 06:13:47', '系统管理员', '2022-07-24 00:41:07');
INSERT INTO `sys_res` VALUES (1547707689218473984, 3, '系统监控', NULL, 'system:monitor', 0, 'el-icon-more-outline', 0, 0, '系统管理员', '2022-07-15 06:20:43', '系统管理员', '2022-07-19 18:00:41');
INSERT INTO `sys_res` VALUES (1547707998762303488, 1, '操作日志', '/operatorLog', 'system:operator:log', 1, NULL, 1547707689218473984, 0, '系统管理员', '2022-07-15 06:21:57', '系统管理员', '2022-07-19 15:56:47');
INSERT INTO `sys_res` VALUES (1548334732557811712, 1, '用户管理', '/userInfo', 'system:user:manager', 1, NULL, 1547705944102797312, 0, '系统管理员', '2022-07-16 23:52:22', '系统管理员', '2022-07-19 17:35:08');
INSERT INTO `sys_res` VALUES (1548337689479217153, NULL, '用户查询', '', 'system:user:query', 2, '', 1548334732557811712, 0, '系统管理员', '2022-07-17 00:04:07', '系统管理员', '2022-07-19 10:42:27');
INSERT INTO `sys_res` VALUES (1548337830504300544, NULL, '用户新增', NULL, 'system:user:add', 2, NULL, 1548334732557811712, 0, '系统管理员', '2022-07-17 00:04:40', '系统管理员', '2022-07-17 07:18:54');
INSERT INTO `sys_res` VALUES (1548338081055244288, NULL, '用户编辑', NULL, 'system:user:edit', 2, NULL, 1548334732557811712, 0, '系统管理员', '2022-07-17 00:05:40', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548341007605694464, NULL, '用户删除', NULL, 'system:user:delete', 2, NULL, 1548334732557811712, 0, '系统管理员', '2022-07-17 00:17:18', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548342106597228544, 2, '角色管理', '/roleInfo', 'system:role:manager', 1, NULL, 1547705944102797312, 0, '系统管理员', '2022-07-17 00:21:40', '系统管理员', '2022-07-19 17:30:32');
INSERT INTO `sys_res` VALUES (1548342202961362944, NULL, '角色查询', NULL, 'system:role:query', 2, NULL, 1548342106597228544, 0, '系统管理员', '2022-07-17 00:22:03', '系统管理员', '2022-07-19 10:45:22');
INSERT INTO `sys_res` VALUES (1548342291989659648, NULL, '角色新增', NULL, 'system:role:add', 2, NULL, 1548342106597228544, 0, '系统管理员', '2022-07-17 00:22:24', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548342492854878208, NULL, '角色编辑', NULL, 'system:role:edit', 2, NULL, 1548342106597228544, 0, '系统管理员', '2022-07-17 00:23:12', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548342588178825217, NULL, '角色删除', NULL, 'system:role:delete', 2, NULL, 1548342106597228544, 0, '系统管理员', '2022-07-17 00:23:34', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548342877149593600, 3, '菜单管理', '/meunInfo', 'system:res:manager', 1, NULL, 1547705944102797312, 0, '系统管理员', '2022-07-17 00:24:43', '系统管理员', '2022-07-21 11:56:24');
INSERT INTO `sys_res` VALUES (1548342979884875776, NULL, '菜单查询', '', 'system:res:query', 2, NULL, 1548342877149593600, 0, '系统管理员', '2022-07-17 00:25:08', '系统管理员', '2022-07-21 11:55:19');
INSERT INTO `sys_res` VALUES (1548343212098322432, NULL, '菜单新增', NULL, 'system:res:add', 2, NULL, 1548342877149593600, 0, '系统管理员', '2022-07-17 00:26:03', '系统管理员', '2022-07-21 11:55:11');
INSERT INTO `sys_res` VALUES (1548343571273351168, NULL, '菜单编辑', NULL, 'system:res:edit', 2, NULL, 1548342877149593600, 0, '系统管理员', '2022-07-17 00:27:29', '系统管理员', '2022-07-21 11:55:24');
INSERT INTO `sys_res` VALUES (1548347725588856832, 1, '地区管理', '/regionInfo', 'system:region:manager', 1, NULL, 1549332755526057984, 0, '系统管理员', '2022-07-17 00:43:59', '系统管理员', '2022-07-19 19:36:21');
INSERT INTO `sys_res` VALUES (1548347930350583808, NULL, '地区查询', NULL, 'system:region:query', 2, NULL, 1548347725588856832, 0, '系统管理员', '2022-07-17 00:44:48', '系统管理员', '2022-07-19 10:46:15');
INSERT INTO `sys_res` VALUES (1548348105353723904, NULL, '地区新增', NULL, 'system:region:add', 2, NULL, 1548347725588856832, 0, '系统管理员', '2022-07-17 00:45:30', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548348616052178944, NULL, '地区编辑', NULL, 'system:region:edit', 2, NULL, 1548347725588856832, 0, '系统管理员', '2022-07-17 00:47:32', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548405427232964608, NULL, '地区删除', NULL, 'system:region:delete', 2, NULL, 1548347725588856832, 0, '系统管理员', '2022-07-17 04:33:16', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1549301396833173504, 2, '登录日志', '/loginLog', 'system:login:log', 1, NULL, 1547707689218473984, 0, '系统管理员', '2022-07-19 15:53:32', '系统管理员', '2022-07-19 15:57:35');
INSERT INTO `sys_res` VALUES (1549330797398458368, 3, '在线用户', '/onlineUser', 'system:online:user', 1, NULL, 1547707689218473984, 0, '系统管理员', '2022-07-19 17:50:22', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1549331353349259264, 3, '公厕管理', '/toiletInfo', 'system:toilet:manager', 1, NULL, 1549332755526057984, 0, '系统管理员', '2022-07-19 17:52:34', '系统管理员', '2022-07-19 19:36:30');
INSERT INTO `sys_res` VALUES (1549332574973853696, 4, '坑位管理', '/positionInfo', 'system:position:manager', 1, NULL, 1549332755526057984, 0, '系统管理员', '2022-07-19 17:57:26', '系统管理员', '2022-07-19 19:36:38');
INSERT INTO `sys_res` VALUES (1549332755526057984, 2, '业务管理', NULL, NULL, 0, 'el-icon-s-promotion', 0, 0, '系统管理员', '2022-07-19 17:58:09', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1549357366699491328, 2, '设备管理', '/deviceInfo', 'system:device:manager', 1, NULL, 1549332755526057984, 0, '系统管理员', '2022-07-19 19:35:57', '系统管理员', '2022-07-19 19:36:55');
INSERT INTO `sys_res` VALUES (1549357874663260160, 4, '接口调用信息', '/interfaceCall', 'system:interface:call', 1, NULL, 1547707689218473984, 0, '系统管理员', '2022-07-19 19:37:58', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1549358102590128128, 4, '字典管理', '/dictType', 'system:dict:type', 1, NULL, 1547705944102797312, 0, '系统管理员', '2022-07-19 19:38:52', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1549358829232324608, 1, '字典数据', '/dictData', 'system:dict:data', 3, NULL, 1549358102590128128, 0, '系统管理员', '2022-07-19 19:41:45', '系统管理员', '2022-07-20 10:20:44');
INSERT INTO `sys_res` VALUES (1549568023474601984, NULL, '在线用户查询', NULL, 'system:online:user:query', 2, NULL, 1549330797398458368, 0, '系统管理员', '2022-07-20 09:33:01', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549568767154061312, NULL, '在线用户踢出', NULL, 'system:online:user:kickout', 2, NULL, 1549330797398458368, 0, '系统管理员', '2022-07-20 09:35:58', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549570944593428480, NULL, '菜单删除', NULL, 'system:res:delete', 2, NULL, 1548342877149593600, 0, '系统管理员', '2022-07-20 09:44:37', '系统管理员', '2022-07-21 11:55:30');
INSERT INTO `sys_res` VALUES (1549571972600561664, NULL, '字典查询', NULL, 'system:dict:query', 2, NULL, 1549358102590128128, 0, '系统管理员', '2022-07-20 09:48:43', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549572057254199296, NULL, '字典新增', NULL, 'system:dict:add', 2, NULL, 1549358102590128128, 0, '系统管理员', '2022-07-20 09:49:03', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549572126959337472, NULL, '字典编辑', NULL, 'system:dict:edit', 2, NULL, 1549358102590128128, 0, '系统管理员', '2022-07-20 09:49:19', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549572201009774593, NULL, '字典删除', NULL, 'system:dict:delete', 2, NULL, 1549358102590128128, 0, '系统管理员', '2022-07-20 09:49:37', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549574464377847808, NULL, '操作日志查询', NULL, 'system:operator:log:query', 2, NULL, 1547707998762303488, 0, '系统管理员', '2022-07-20 09:58:37', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549574565036949505, NULL, '登录日志查询', NULL, 'system:login:log:query', 2, NULL, 1549301396833173504, 0, '系统管理员', '2022-07-20 09:59:01', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549574666736238593, NULL, '接口调用信查询', NULL, 'system:interface:call:query', 2, NULL, 1549357874663260160, 0, '系统管理员', '2022-07-20 09:59:25', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549580506746716160, NULL, '公厕查询', NULL, 'system:toilet:query', 2, NULL, 1549331353349259264, 0, '系统管理员', '2022-07-20 10:22:37', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549580629648211969, NULL, '公厕新增', NULL, 'system:toilet:add', 2, NULL, 1549331353349259264, 0, '系统管理员', '2022-07-20 10:23:07', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549580705288290304, NULL, '公厕编辑', NULL, 'system:toilet:edit', 2, NULL, 1549331353349259264, 0, '系统管理员', '2022-07-20 10:23:25', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549580773156323328, NULL, '公厕删除', NULL, 'system:toilet:delete', 2, NULL, 1549331353349259264, 0, '系统管理员', '2022-07-20 10:23:41', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549581428918976513, NULL, '坑位查询', NULL, 'system:position:query', 2, NULL, 1549332574973853696, 0, '系统管理员', '2022-07-20 10:26:17', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549581532111437824, NULL, '坑位新增', NULL, 'system:position:add', 2, NULL, 1549332574973853696, 0, '系统管理员', '2022-07-20 10:26:42', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549581684050100224, NULL, '坑位编辑', NULL, 'system:position:edit', 2, NULL, 1549332574973853696, 0, '系统管理员', '2022-07-20 10:27:18', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549581745710563328, NULL, '坑位删除', NULL, 'system:position:delete', 2, NULL, 1549332574973853696, 0, '系统管理员', '2022-07-20 10:27:33', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549582396360359937, NULL, '设备查询', NULL, 'system:device:query', 2, NULL, 1549357366699491328, 0, '系统管理员', '2022-07-20 10:30:08', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549582458914209793, NULL, '设备新增', NULL, 'system:device:add', 2, NULL, 1549357366699491328, 0, '系统管理员', '2022-07-20 10:30:23', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549582518355886080, NULL, '设备编辑', NULL, 'system:device:edit', 2, NULL, 1549357366699491328, 0, '系统管理员', '2022-07-20 10:30:37', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549582696391507968, NULL, '设备删除', NULL, 'system:device:delete', 2, NULL, 1549357366699491328, 0, '系统管理员', '2022-07-20 10:31:19', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色代码',
  `role_explain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色描述',
  `status` tinyint DEFAULT NULL COMMENT '状态（0-正常,1-删除)',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1547788281654149121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1547306694281920512, '测试角色1', 'test_role', '测试角色权限关联', 0, '测试用户1', '2022-07-14 03:47:18', '系统管理员', '2022-07-25 15:09:14');
INSERT INTO `sys_role` VALUES (1547788281654149120, '1221112', '212112212', NULL, 1, '测试用户1', '2022-07-15 11:40:58', '测试用户1', '2022-07-15 11:44:31');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_res
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_res`;
CREATE TABLE `sys_role_res` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `res_id` bigint DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1551464580901793794 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色权限关联表';

-- ----------------------------
-- Records of sys_role_res
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_res` VALUES (1551464575713439745, 1547306694281920512, 1547705944102797312);
INSERT INTO `sys_role_res` VALUES (1551464576082538497, 1547306694281920512, 1548334732557811712);
INSERT INTO `sys_role_res` VALUES (1551464576455831553, 1547306694281920512, 1548337689479217153);
INSERT INTO `sys_role_res` VALUES (1551464576824930305, 1547306694281920512, 1548337830504300544);
INSERT INTO `sys_role_res` VALUES (1551464577194029058, 1547306694281920512, 1548338081055244288);
INSERT INTO `sys_role_res` VALUES (1551464577567322113, 1547306694281920512, 1548341007605694464);
INSERT INTO `sys_role_res` VALUES (1551464577936420865, 1547306694281920512, 1547707689218473984);
INSERT INTO `sys_role_res` VALUES (1551464578305519617, 1547306694281920512, 1547707998762303488);
INSERT INTO `sys_role_res` VALUES (1551464578678812673, 1547306694281920512, 1549574464377847808);
INSERT INTO `sys_role_res` VALUES (1551464579047911426, 1547306694281920512, 1549301396833173504);
INSERT INTO `sys_role_res` VALUES (1551464579421204482, 1547306694281920512, 1549574565036949505);
INSERT INTO `sys_role_res` VALUES (1551464579790303233, 1547306694281920512, 1549330797398458368);
INSERT INTO `sys_role_res` VALUES (1551464580159401986, 1547306694281920512, 1549568023474601984);
INSERT INTO `sys_role_res` VALUES (1551464580528500737, 1547306694281920512, 1549357874663260160);
INSERT INTO `sys_role_res` VALUES (1551464580901793793, 1547306694281920512, 1549574666736238593);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `pass_word` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `cell_phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号码',
  `mail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮件',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `status` tinyint DEFAULT NULL COMMENT '状态（0-正常，1-删除，2-禁用)',
  `account_type` tinyint DEFAULT NULL COMMENT '账户类型 1系统账号 2客户账号',
  `invite_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邀请码',
  `sex` tinyint DEFAULT NULL COMMENT '性别：0男 1女',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `sign` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户签名',
  `picture_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `create_by` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1550874673959534592', 'admin', '系统管理员', 'E10ADC3949BA59ABBE56E057F20F883E', '13222222222', NULL, NULL, 0, 1, NULL, 0, NULL, NULL, '1551371290240221184', '系统管理员', '2022-07-24 00:05:11', '系统管理员', '2022-07-27 16:27:30');
INSERT INTO `sys_user` VALUES ('1551390731329994752', 'admin2', 'admin', '96E79218965EB72C92A549DD5A330112', 'admin', NULL, NULL, 1, 1, NULL, 0, NULL, NULL, NULL, '系统管理员', '2022-07-25 10:15:48', 'admin', '2022-07-25 11:30:27');
INSERT INTO `sys_user` VALUES ('1551408947393593344', 'test-user', '测试普通权限用户', 'E10ADC3949BA59ABBE56E057F20F883E', 'admin', NULL, NULL, 0, 2, NULL, 0, NULL, NULL, '1551464191351717888', 'admin', '2022-07-25 11:28:12', '系统管理员', '2022-07-25 15:07:48');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1551408947750060035 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1549468867321991170, 1545726672605675520, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1549944057558491137, 1549944057155944448, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1549945044213981185, 1549945043844988928, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550842175571324930, 1550842174936055808, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550842177844637698, 1550842176823492608, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550842178314399745, 1550842177855291392, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550842703407706114, 1550842702931820544, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550852446975275010, 1550852445536649216, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550854169919778817, 1550854168686755840, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550855436515688449, 1550855435278483456, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550855437451018241, 1550855437023313920, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550855946102759425, 1550855944689287168, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550856354460176385, 1550856353289994240, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550856376442523650, 1550856374223765504, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550857068127109122, 1550857066921459712, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550857242907942913, 1550857241874268160, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550865572303044610, 1550865571829121024, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550865701584076801, 1550865700757831680, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550865941963833346, 1550865941439578112, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550865942555230210, 1550865941749956608, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550866019118055425, 1550866017209679872, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550866865641869314, 1550866865025318912, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550867083716317185, 1550867083309481984, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550867271197511682, 1550867270706790400, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550867790238445569, 1550867789017907201, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550867790238445570, 1550867789017907200, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550868236684230658, 1550868236147490816, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550868408524865537, 1550868407782604800, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550868543581454337, 1550868543107629056, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550868729665945601, 1550868729213091840, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550868947354517505, 1550868946947801088, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550874534616236033, 1550874534129827840, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550874674416582658, 1550874673959534592, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1550880563768885250, 1550880563349553152, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1551390731757690881, 1551390731329994752, 1547306694281920512);
INSERT INTO `sys_user_role` VALUES (1551408947750060034, 1551408947393593344, 1547306694281920512);
COMMIT;

-- ----------------------------
-- Table structure for toilet_info
-- ----------------------------
DROP TABLE IF EXISTS `toilet_info`;
CREATE TABLE `toilet_info` (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公厕名称',
  `code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公厕编码',
  `location` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '位置(wkt)',
  `status` tinyint DEFAULT NULL COMMENT '状态(0正常 1删除)',
  `type` tinyint DEFAULT NULL COMMENT '是否为公厕(0是 1否)',
  `create_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公厕信息';

-- ----------------------------
-- Records of toilet_info
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
