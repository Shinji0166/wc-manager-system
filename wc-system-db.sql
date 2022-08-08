/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 03/08/2022 09:23:40
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
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='地域表';

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
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备名称',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备编码',
  `index_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备机器码',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用 2在线 3离线)',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='设备信息';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='坑位设备关联表';

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
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '坑位名称',
  `number` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '坑位序号',
  `toilet_id` bigint DEFAULT NULL COMMENT '关联公厕ID',
  `status` tinyint DEFAULT NULL COMMENT '状态(0-正常 1-删除)',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='坑位信息';

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
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '附件名',
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '附件地址',
  `data_source` tinyint DEFAULT NULL COMMENT '附件类型',
  `status` tinyint DEFAULT NULL COMMENT '状态',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1554187828970258433 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='附件表';

-- ----------------------------
-- Records of sys_appendix
-- ----------------------------
BEGIN;
INSERT INTO `sys_appendix` VALUES (1554015681547206656, 'WX20210929-032216@2x.png1879537723649431015.png', 'https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wc-system-images/WX20210929-032216@2x.png1879537723649431015.png', 0, 0, 'system::admin', '系统管理员', '2022-08-01 16:06:25', NULL, NULL);
INSERT INTO `sys_appendix` VALUES (1554036190628413440, 'WX20210929-032216@2x.png6954051153692970201.png', 'https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wc-system-images/WX20210929-032216@2x.png6954051153692970201.png', 0, 0, NULL, '系统管理员', '2022-08-01 17:27:55', NULL, NULL);
INSERT INTO `sys_appendix` VALUES (1554036351383502848, 'WX20211021-205613@2x.png8627856665949284479.png', 'https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wc-system-images/WX20211021-205613@2x.png8627856665949284479.png', 0, 0, NULL, '系统管理员', '2022-08-01 17:28:33', NULL, NULL);
INSERT INTO `sys_appendix` VALUES (1554036387513237504, 'WX20210929-032216@2x.png415915921289135866.png', 'https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wc-system-images/WX20210929-032216@2x.png415915921289135866.png', 0, 0, NULL, '系统管理员', '2022-08-01 17:28:42', NULL, NULL);
INSERT INTO `sys_appendix` VALUES (1554036410212810752, 'WX20210929-032216@2x.png7647640890898200260.png', 'https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wc-system-images/WX20210929-032216@2x.png7647640890898200260.png', 0, 0, NULL, '系统管理员', '2022-08-01 17:28:47', NULL, NULL);
INSERT INTO `sys_appendix` VALUES (1554036439916871680, 'WX20210929-032216@2x.png1002413021512542556.png', 'https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wc-system-images/WX20210929-032216@2x.png1002413021512542556.png', 0, 0, NULL, '系统管理员', '2022-08-01 17:28:55', NULL, NULL);
INSERT INTO `sys_appendix` VALUES (1554036475320991744, 'WX20211021-205613@2x.png5455360556956276032.png', 'https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wc-system-images/WX20211021-205613@2x.png5455360556956276032.png', 0, 0, NULL, '系统管理员', '2022-08-01 17:29:03', NULL, NULL);
INSERT INTO `sys_appendix` VALUES (1554036511085821952, 'WX20211021-205613@2x.png7266394266413965628.png', 'https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wc-system-images/WX20211021-205613@2x.png7266394266413965628.png', 0, 0, NULL, '系统管理员', '2022-08-01 17:29:12', NULL, NULL);
INSERT INTO `sys_appendix` VALUES (1554187828970258432, 'WX20210929-032216@2x.png6761477141593906081.png', 'https://aliyun-images-service.oss-cn-hangzhou.aliyuncs.com/wc-system-images/WX20210929-032216@2x.png6761477141593906081.png', 0, 0, 'system::code', '系统管理员', '2022-08-02 03:30:28', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '部门名称',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '部门编码',
  `parent_id` bigint DEFAULT NULL COMMENT '父级ID',
  `is_del` tinyint DEFAULT NULL COMMENT '是否删除(0是 1否)',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='部门表';

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
  `dict_label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典标签',
  `dict_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典值',
  `dict_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典类型',
  `status` tinyint DEFAULT NULL COMMENT '状态(0启用 1禁用)',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1549578394105151489 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_data` VALUES (1545728510541299712, '男', '0', 'sex', 0, NULL, '系统', '2022-07-09 19:16:10', '系统', '2022-07-18 10:14:25');
INSERT INTO `sys_dict_data` VALUES (1545728539196784640, '女', '1', 'sex', 0, NULL, '系统', '2022-07-09 19:16:17', '系统', NULL);
INSERT INTO `sys_dict_data` VALUES (1545728590136606720, '启用', '0', 'status', 0, NULL, '系统', '2022-07-09 19:16:29', '系统', '2022-07-11 15:33:38');
INSERT INTO `sys_dict_data` VALUES (1545728652409438208, '删除', '1', 'status', 1, NULL, '系统', '2022-07-09 19:16:44', '系统', '2022-07-11 15:33:56');
INSERT INTO `sys_dict_data` VALUES (1545728685997424640, '禁用', '2', 'status', 0, NULL, '系统', '2022-07-09 19:16:52', '系统', NULL);
INSERT INTO `sys_dict_data` VALUES (1546693568339509248, '管理员账号', '1', 'accout_type', 0, NULL, '系统', '2022-07-12 11:10:58', '系统', NULL);
INSERT INTO `sys_dict_data` VALUES (1546693600484655104, '普通账号', '2', 'accout_type', 0, NULL, '系统', '2022-07-12 11:11:05', '系统', NULL);
INSERT INTO `sys_dict_data` VALUES (1547319508602060800, '目录', '0', 'res_type', 0, NULL, '系统', '2022-07-14 04:38:13', '系统', NULL);
INSERT INTO `sys_dict_data` VALUES (1547319529959456768, '菜单', '1', 'res_type', 0, NULL, '系统', '2022-07-14 04:38:18', '系统', NULL);
INSERT INTO `sys_dict_data` VALUES (1547319548334702592, '按钮', '2', 'res_type', 0, NULL, '系统', '2022-07-14 04:38:23', '系统', '2022-07-20 09:59:53');
INSERT INTO `sys_dict_data` VALUES (1548853724561145856, '测试', '1', 'sex', 1, NULL, '系统', '2022-07-18 10:14:39', '系统', NULL);
INSERT INTO `sys_dict_data` VALUES (1549578394105151488, '内嵌页面', '3', 'res_type', 0, NULL, '系统', '2022-07-20 10:14:14', '系统', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_number` bigint DEFAULT NULL COMMENT '字典序号',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典名称',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典类型名称',
  `classify` tinyint DEFAULT NULL COMMENT '字典分类(0系统字典 1模块字典 2公共字典)',
  `pid` bigint DEFAULT NULL COMMENT '父级ID',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `status` tinyint DEFAULT NULL COMMENT '状态(0正常 1删除 2禁用)',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1547319438871756801 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_type` VALUES (1545728011037442048, 1, '性别', 'sex', NULL, NULL, '系统用户性别字典', 0, NULL, '系统', '2022-07-09 19:14:11', '2022-07-18 09:14:36', '系统');
INSERT INTO `sys_dict_type` VALUES (1545728137487319040, 2, '状态', 'status', NULL, NULL, '系统数据状态', 0, NULL, '系统', '2022-07-09 19:14:41', NULL, '系统');
INSERT INTO `sys_dict_type` VALUES (1546693462567550976, 3, '账号类型', 'accout_type', NULL, NULL, '账号类型', 0, NULL, '系统', '2022-07-12 11:10:32', NULL, '系统');
INSERT INTO `sys_dict_type` VALUES (1547319438871756800, 4, '菜单类型', 'res_type', NULL, NULL, '菜单资源类型', 0, NULL, '系统', '2022-07-14 04:37:57', '2022-07-19 19:46:36', '系统');
COMMIT;

-- ----------------------------
-- Table structure for sys_interface_call
-- ----------------------------
DROP TABLE IF EXISTS `sys_interface_call`;
CREATE TABLE `sys_interface_call` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `interface_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '接口名称',
  `declaring_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '声明名称',
  `method_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '方法名称',
  `request_mode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求方式',
  `request_ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求IP',
  `interface_call_count` bigint DEFAULT NULL COMMENT '接口调用次数',
  `interface_call_success_count` bigint DEFAULT NULL COMMENT '接口调用成功数',
  `interface_call_fail_count` bigint DEFAULT NULL COMMENT '接口调用失败数',
  `interface_call_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '接口单次回调时间',
  `interface_call_total_time` bigint DEFAULT NULL COMMENT '接口回调总时长',
  `interface_call_min_time` bigint DEFAULT NULL COMMENT '接口调用最小时长',
  `interface_call_avg_time` bigint DEFAULT NULL COMMENT '接口调用平均时长',
  `interface_call_max_time` bigint DEFAULT NULL COMMENT '接口调用最大时长',
  `interface_request_time` datetime DEFAULT NULL COMMENT '接口调用请求时间',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `status` tinyint DEFAULT NULL COMMENT '状态(0正常 1删除)',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1554633150397808641 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='接口调用表';

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
  `browser_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '浏览器名称',
  `browser_version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '浏览器版本',
  `operator_system` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作系统',
  `request_ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求IP',
  `result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '响应结果',
  `failure_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '失败原因',
  `status` tinyint DEFAULT NULL COMMENT '状态(0正常 1删除)',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登录用户',
  `create_time` datetime DEFAULT NULL COMMENT '登录时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1554633540812013569 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='登录日志';

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
  `operator_module` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作模块',
  `operator_function` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作功能',
  `operator_action` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '执行动作',
  `request_ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求IP',
  `request_mode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求模式',
  `failure_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '失败原因',
  `status` tinyint DEFAULT NULL COMMENT '状态(0入库正常)',
  `result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '响应结果',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求用户',
  `create_time` datetime DEFAULT NULL COMMENT '请求时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1554633531274166273 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='系统操作日志';

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
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资源名称',
  `res_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资源路径',
  `permission` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限标识',
  `res_type` tinyint DEFAULT NULL COMMENT '资源类型(0目录 1菜单 2按钮)',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '资源图标',
  `pid` bigint DEFAULT NULL COMMENT '父级ID',
  `status` tinyint DEFAULT NULL COMMENT '状态（0-正常,1-删除)',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1549582696391507969 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_res
-- ----------------------------
BEGIN;
INSERT INTO `sys_res` VALUES (1547705944102797312, 1, '系统管理', NULL, 'system::manager', 0, 'el-icon-setting', 0, 0, NULL, '系统管理员', '2022-07-15 06:13:47', '系统管理员', '2022-07-24 00:41:07');
INSERT INTO `sys_res` VALUES (1547707689218473984, 3, '系统监控', NULL, 'system:monitor', 0, 'el-icon-more-outline', 0, 0, NULL, '系统管理员', '2022-07-15 06:20:43', '系统管理员', '2022-07-19 18:00:41');
INSERT INTO `sys_res` VALUES (1547707998762303488, 1, '操作日志', '/operatorLog', 'system:operator:log', 1, NULL, 1547707689218473984, 0, NULL, '系统管理员', '2022-07-15 06:21:57', '系统管理员', '2022-07-19 15:56:47');
INSERT INTO `sys_res` VALUES (1548334732557811712, 1, '用户管理', '/userInfo', 'system:user:manager', 1, NULL, 1547705944102797312, 0, NULL, '系统管理员', '2022-07-16 23:52:22', '系统管理员', '2022-07-19 17:35:08');
INSERT INTO `sys_res` VALUES (1548337689479217153, NULL, '用户查询', '', 'system:user:query', 2, '', 1548334732557811712, 0, NULL, '系统管理员', '2022-07-17 00:04:07', '系统管理员', '2022-07-19 10:42:27');
INSERT INTO `sys_res` VALUES (1548337830504300544, NULL, '用户新增', NULL, 'system:user:add', 2, NULL, 1548334732557811712, 0, NULL, '系统管理员', '2022-07-17 00:04:40', '系统管理员', '2022-07-17 07:18:54');
INSERT INTO `sys_res` VALUES (1548338081055244288, NULL, '用户编辑', NULL, 'system:user:edit', 2, NULL, 1548334732557811712, 0, NULL, '系统管理员', '2022-07-17 00:05:40', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548341007605694464, NULL, '用户删除', NULL, 'system:user:delete', 2, NULL, 1548334732557811712, 0, NULL, '系统管理员', '2022-07-17 00:17:18', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548342106597228544, 2, '角色管理', '/roleInfo', 'system:role:manager', 1, NULL, 1547705944102797312, 0, NULL, '系统管理员', '2022-07-17 00:21:40', '系统管理员', '2022-07-19 17:30:32');
INSERT INTO `sys_res` VALUES (1548342202961362944, NULL, '角色查询', NULL, 'system:role:query', 2, NULL, 1548342106597228544, 0, NULL, '系统管理员', '2022-07-17 00:22:03', '系统管理员', '2022-07-19 10:45:22');
INSERT INTO `sys_res` VALUES (1548342291989659648, NULL, '角色新增', NULL, 'system:role:add', 2, NULL, 1548342106597228544, 0, NULL, '系统管理员', '2022-07-17 00:22:24', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548342492854878208, NULL, '角色编辑', NULL, 'system:role:edit', 2, NULL, 1548342106597228544, 0, NULL, '系统管理员', '2022-07-17 00:23:12', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548342588178825217, NULL, '角色删除', NULL, 'system:role:delete', 2, NULL, 1548342106597228544, 0, NULL, '系统管理员', '2022-07-17 00:23:34', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548342877149593600, 3, '菜单管理', '/meunInfo', 'system:res:manager', 1, NULL, 1547705944102797312, 0, NULL, '系统管理员', '2022-07-17 00:24:43', '系统管理员', '2022-07-21 11:56:24');
INSERT INTO `sys_res` VALUES (1548342979884875776, NULL, '菜单查询', '', 'system:res:query', 2, NULL, 1548342877149593600, 0, NULL, '系统管理员', '2022-07-17 00:25:08', '系统管理员', '2022-07-21 11:55:19');
INSERT INTO `sys_res` VALUES (1548343212098322432, NULL, '菜单新增', NULL, 'system:res:add', 2, NULL, 1548342877149593600, 0, NULL, '系统管理员', '2022-07-17 00:26:03', '系统管理员', '2022-07-21 11:55:11');
INSERT INTO `sys_res` VALUES (1548343571273351168, NULL, '菜单编辑', NULL, 'system:res:edit', 2, NULL, 1548342877149593600, 0, NULL, '系统管理员', '2022-07-17 00:27:29', '系统管理员', '2022-07-21 11:55:24');
INSERT INTO `sys_res` VALUES (1548347725588856832, 1, '地区管理', '/regionInfo', 'system:region:manager', 1, NULL, 1549332755526057984, 0, NULL, '系统管理员', '2022-07-17 00:43:59', '系统管理员', '2022-07-19 19:36:21');
INSERT INTO `sys_res` VALUES (1548347930350583808, NULL, '地区查询', NULL, 'system:region:query', 2, NULL, 1548347725588856832, 0, NULL, '系统管理员', '2022-07-17 00:44:48', '系统管理员', '2022-07-19 10:46:15');
INSERT INTO `sys_res` VALUES (1548348105353723904, NULL, '地区新增', NULL, 'system:region:add', 2, NULL, 1548347725588856832, 0, NULL, '系统管理员', '2022-07-17 00:45:30', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548348616052178944, NULL, '地区编辑', NULL, 'system:region:edit', 2, NULL, 1548347725588856832, 0, NULL, '系统管理员', '2022-07-17 00:47:32', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1548405427232964608, NULL, '地区删除', NULL, 'system:region:delete', 2, NULL, 1548347725588856832, 0, NULL, '系统管理员', '2022-07-17 04:33:16', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1549301396833173504, 2, '登录日志', '/loginLog', 'system:login:log', 1, NULL, 1547707689218473984, 0, NULL, '系统管理员', '2022-07-19 15:53:32', '系统管理员', '2022-07-19 15:57:35');
INSERT INTO `sys_res` VALUES (1549330797398458368, 3, '在线用户', '/onlineUser', 'system:online:user', 1, NULL, 1547707689218473984, 0, NULL, '系统管理员', '2022-07-19 17:50:22', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1549331353349259264, 3, '公厕管理', '/toiletInfo', 'system:toilet:manager', 1, NULL, 1549332755526057984, 0, NULL, '系统管理员', '2022-07-19 17:52:34', '系统管理员', '2022-07-19 19:36:30');
INSERT INTO `sys_res` VALUES (1549332574973853696, 4, '坑位管理', '/positionInfo', 'system:position:manager', 1, NULL, 1549332755526057984, 0, NULL, '系统管理员', '2022-07-19 17:57:26', '系统管理员', '2022-07-19 19:36:38');
INSERT INTO `sys_res` VALUES (1549332755526057984, 2, '业务管理', NULL, 'system::service', 0, 'el-icon-s-promotion', 0, 0, NULL, '系统管理员', '2022-07-19 17:58:09', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1549357366699491328, 2, '设备管理', '/deviceInfo', 'system:device:manager', 1, NULL, 1549332755526057984, 0, NULL, '系统管理员', '2022-07-19 19:35:57', '系统管理员', '2022-07-19 19:36:55');
INSERT INTO `sys_res` VALUES (1549357874663260160, 4, '接口调用信息', '/interfaceCall', 'system:interface:call', 1, NULL, 1547707689218473984, 0, NULL, '系统管理员', '2022-07-19 19:37:58', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1549358102590128128, 4, '字典管理', '/dictType', 'system:dict:type', 1, NULL, 1547705944102797312, 0, NULL, '系统管理员', '2022-07-19 19:38:52', '系统管理员', NULL);
INSERT INTO `sys_res` VALUES (1549358829232324608, 1, '字典数据', '/dictData', 'system:dict:data', 3, NULL, 1549358102590128128, 0, NULL, '系统管理员', '2022-07-19 19:41:45', '系统管理员', '2022-07-20 10:20:44');
INSERT INTO `sys_res` VALUES (1549568023474601984, NULL, '在线用户查询', NULL, 'system:online:user:query', 2, NULL, 1549330797398458368, 0, NULL, '系统管理员', '2022-07-20 09:33:01', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549568767154061312, NULL, '在线用户踢出', NULL, 'system:online:user:kickout', 2, NULL, 1549330797398458368, 0, NULL, '系统管理员', '2022-07-20 09:35:58', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549570944593428480, NULL, '菜单删除', NULL, 'system:res:delete', 2, NULL, 1548342877149593600, 0, NULL, '系统管理员', '2022-07-20 09:44:37', '系统管理员', '2022-07-21 11:55:30');
INSERT INTO `sys_res` VALUES (1549571972600561664, NULL, '字典查询', NULL, 'system:dict:query', 2, NULL, 1549358102590128128, 0, NULL, '系统管理员', '2022-07-20 09:48:43', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549572057254199296, NULL, '字典新增', NULL, 'system:dict:add', 2, NULL, 1549358102590128128, 0, NULL, '系统管理员', '2022-07-20 09:49:03', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549572126959337472, NULL, '字典编辑', NULL, 'system:dict:edit', 2, NULL, 1549358102590128128, 0, NULL, '系统管理员', '2022-07-20 09:49:19', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549572201009774593, NULL, '字典删除', NULL, 'system:dict:delete', 2, NULL, 1549358102590128128, 0, NULL, '系统管理员', '2022-07-20 09:49:37', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549574464377847808, NULL, '操作日志查询', NULL, 'system:operator:log:query', 2, NULL, 1547707998762303488, 0, NULL, '系统管理员', '2022-07-20 09:58:37', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549574565036949505, NULL, '登录日志查询', NULL, 'system:login:log:query', 2, NULL, 1549301396833173504, 0, NULL, '系统管理员', '2022-07-20 09:59:01', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549574666736238593, NULL, '接口调用信查询', NULL, 'system:interface:call:query', 2, NULL, 1549357874663260160, 0, NULL, '系统管理员', '2022-07-20 09:59:25', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549580506746716160, NULL, '公厕查询', NULL, 'system:toilet:query', 2, NULL, 1549331353349259264, 0, NULL, '系统管理员', '2022-07-20 10:22:37', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549580629648211969, NULL, '公厕新增', NULL, 'system:toilet:add', 2, NULL, 1549331353349259264, 0, NULL, '系统管理员', '2022-07-20 10:23:07', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549580705288290304, NULL, '公厕编辑', NULL, 'system:toilet:edit', 2, NULL, 1549331353349259264, 0, NULL, '系统管理员', '2022-07-20 10:23:25', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549580773156323328, NULL, '公厕删除', NULL, 'system:toilet:delete', 2, NULL, 1549331353349259264, 0, NULL, '系统管理员', '2022-07-20 10:23:41', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549581428918976513, NULL, '坑位查询', NULL, 'system:position:query', 2, NULL, 1549332574973853696, 0, NULL, '系统管理员', '2022-07-20 10:26:17', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549581532111437824, NULL, '坑位新增', NULL, 'system:position:add', 2, NULL, 1549332574973853696, 0, NULL, '系统管理员', '2022-07-20 10:26:42', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549581684050100224, NULL, '坑位编辑', NULL, 'system:position:edit', 2, NULL, 1549332574973853696, 0, NULL, '系统管理员', '2022-07-20 10:27:18', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549581745710563328, NULL, '坑位删除', NULL, 'system:position:delete', 2, NULL, 1549332574973853696, 0, NULL, '系统管理员', '2022-07-20 10:27:33', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549582396360359937, NULL, '设备查询', NULL, 'system:device:query', 2, NULL, 1549357366699491328, 0, NULL, '系统管理员', '2022-07-20 10:30:08', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549582458914209793, NULL, '设备新增', NULL, 'system:device:add', 2, NULL, 1549357366699491328, 0, NULL, '系统管理员', '2022-07-20 10:30:23', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549582518355886080, NULL, '设备编辑', NULL, 'system:device:edit', 2, NULL, 1549357366699491328, 0, NULL, '系统管理员', '2022-07-20 10:30:37', NULL, NULL);
INSERT INTO `sys_res` VALUES (1549582696391507968, NULL, '设备删除', NULL, 'system:device:delete', 2, NULL, 1549357366699491328, 0, NULL, '系统管理员', '2022-07-20 10:31:19', NULL, NULL);
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
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1554021311284641793 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1554018909026385920, '省级管理员', 'MinistryRole', '省级管理员角色', 0, 'system::admin', '系统管理员', '2022-08-01 16:19:15', '系统管理员', '2022-08-01 17:18:12');
INSERT INTO `sys_role` VALUES (1554020541000712192, '市级管理员', 'CityRole', '市级管理员角色', 0, 'hainan::code', 'HaiNan', '2022-08-01 16:25:44', '系统管理员', '2022-08-01 17:16:44');
INSERT INTO `sys_role` VALUES (1554021311284641792, '区级管理员', 'RegionRole', '区级管理员角色', 0, 'hn:haikou::code', 'HaiKou', '2022-08-01 16:28:48', '系统管理员', '2022-08-01 17:17:40');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_res
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_res`;
CREATE TABLE `sys_role_res` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `res_id` bigint DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1554033765964091394 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='角色权限关联表';

-- ----------------------------
-- Records of sys_role_res
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_res` VALUES (1554033375986094082, 1554020541000712192, 1547705944102797312);
INSERT INTO `sys_role_res` VALUES (1554033376367775745, 1554020541000712192, 1548334732557811712);
INSERT INTO `sys_role_res` VALUES (1554033376749457410, 1554020541000712192, 1548337689479217153);
INSERT INTO `sys_role_res` VALUES (1554033377122750465, 1554020541000712192, 1548337830504300544);
INSERT INTO `sys_role_res` VALUES (1554033377512820738, 1554020541000712192, 1548338081055244288);
INSERT INTO `sys_role_res` VALUES (1554033377902891010, 1554020541000712192, 1548341007605694464);
INSERT INTO `sys_role_res` VALUES (1554033378292961282, 1554020541000712192, 1548342106597228544);
INSERT INTO `sys_role_res` VALUES (1554033378674642946, 1554020541000712192, 1548342202961362944);
INSERT INTO `sys_role_res` VALUES (1554033379039547394, 1554020541000712192, 1548342291989659648);
INSERT INTO `sys_role_res` VALUES (1554033379421229058, 1554020541000712192, 1548342492854878208);
INSERT INTO `sys_role_res` VALUES (1554033379815493634, 1554020541000712192, 1548342588178825217);
INSERT INTO `sys_role_res` VALUES (1554033380184592385, 1554020541000712192, 1547707689218473984);
INSERT INTO `sys_role_res` VALUES (1554033380570468353, 1554020541000712192, 1547707998762303488);
INSERT INTO `sys_role_res` VALUES (1554033380952150017, 1554020541000712192, 1549574464377847808);
INSERT INTO `sys_role_res` VALUES (1554033381321248770, 1554020541000712192, 1549301396833173504);
INSERT INTO `sys_role_res` VALUES (1554033381757456385, 1554020541000712192, 1549574565036949505);
INSERT INTO `sys_role_res` VALUES (1554033382151720961, 1554020541000712192, 1549330797398458368);
INSERT INTO `sys_role_res` VALUES (1554033382537596929, 1554020541000712192, 1549568023474601984);
INSERT INTO `sys_role_res` VALUES (1554033382910889985, 1554020541000712192, 1549568767154061312);
INSERT INTO `sys_role_res` VALUES (1554033383317737473, 1554020541000712192, 1549357874663260160);
INSERT INTO `sys_role_res` VALUES (1554033384500531201, 1554020541000712192, 1549574666736238593);
INSERT INTO `sys_role_res` VALUES (1554033384878018561, 1554020541000712192, 1549332755526057984);
INSERT INTO `sys_role_res` VALUES (1554033385263894529, 1554020541000712192, 1548347725588856832);
INSERT INTO `sys_role_res` VALUES (1554033385637187585, 1554020541000712192, 1548347930350583808);
INSERT INTO `sys_role_res` VALUES (1554033386014674946, 1554020541000712192, 1548348105353723904);
INSERT INTO `sys_role_res` VALUES (1554033386396356609, 1554020541000712192, 1548348616052178944);
INSERT INTO `sys_role_res` VALUES (1554033386807398401, 1554020541000712192, 1548405427232964608);
INSERT INTO `sys_role_res` VALUES (1554033387247800322, 1554020541000712192, 1549331353349259264);
INSERT INTO `sys_role_res` VALUES (1554033387625287681, 1554020541000712192, 1549580506746716160);
INSERT INTO `sys_role_res` VALUES (1554033388006969345, 1554020541000712192, 1549580629648211969);
INSERT INTO `sys_role_res` VALUES (1554033388434788353, 1554020541000712192, 1549580705288290304);
INSERT INTO `sys_role_res` VALUES (1554033388833247234, 1554020541000712192, 1549580773156323328);
INSERT INTO `sys_role_res` VALUES (1554033389256871937, 1554020541000712192, 1549332574973853696);
INSERT INTO `sys_role_res` VALUES (1554033389634359297, 1554020541000712192, 1549581428918976513);
INSERT INTO `sys_role_res` VALUES (1554033390020235265, 1554020541000712192, 1549581532111437824);
INSERT INTO `sys_role_res` VALUES (1554033390427082753, 1554020541000712192, 1549581684050100224);
INSERT INTO `sys_role_res` VALUES (1554033390884261889, 1554020541000712192, 1549581745710563328);
INSERT INTO `sys_role_res` VALUES (1554033391253360642, 1554020541000712192, 1549357366699491328);
INSERT INTO `sys_role_res` VALUES (1554033391656013826, 1554020541000712192, 1549582396360359937);
INSERT INTO `sys_role_res` VALUES (1554033392041889794, 1554020541000712192, 1549582458914209793);
INSERT INTO `sys_role_res` VALUES (1554033392461320193, 1554020541000712192, 1549582518355886080);
INSERT INTO `sys_role_res` VALUES (1554033392834613250, 1554020541000712192, 1549582696391507968);
INSERT INTO `sys_role_res` VALUES (1554033610246361089, 1554021311284641792, 1547705944102797312);
INSERT INTO `sys_role_res` VALUES (1554033610649014274, 1554021311284641792, 1548334732557811712);
INSERT INTO `sys_role_res` VALUES (1554033611047473154, 1554021311284641792, 1548337689479217153);
INSERT INTO `sys_role_res` VALUES (1554033611437543426, 1554021311284641792, 1548337830504300544);
INSERT INTO `sys_role_res` VALUES (1554033611815030786, 1554021311284641792, 1548338081055244288);
INSERT INTO `sys_role_res` VALUES (1554033612196712449, 1554021311284641792, 1548341007605694464);
INSERT INTO `sys_role_res` VALUES (1554033612595171329, 1554021311284641792, 1548342106597228544);
INSERT INTO `sys_role_res` VALUES (1554033612972658689, 1554021311284641792, 1548342202961362944);
INSERT INTO `sys_role_res` VALUES (1554033614138675202, 1554021311284641792, 1548342291989659648);
INSERT INTO `sys_role_res` VALUES (1554033614524551170, 1554021311284641792, 1548342492854878208);
INSERT INTO `sys_role_res` VALUES (1554033614935592961, 1554021311284641792, 1548342588178825217);
INSERT INTO `sys_role_res` VALUES (1554033615308886018, 1554021311284641792, 1547707998762303488);
INSERT INTO `sys_role_res` VALUES (1554033615690567682, 1554021311284641792, 1549574464377847808);
INSERT INTO `sys_role_res` VALUES (1554033616055472130, 1554021311284641792, 1549568023474601984);
INSERT INTO `sys_role_res` VALUES (1554033616462319618, 1554021311284641792, 1549357874663260160);
INSERT INTO `sys_role_res` VALUES (1554033616839806977, 1554021311284641792, 1549574666736238593);
INSERT INTO `sys_role_res` VALUES (1554033617217294337, 1554021311284641792, 1549332755526057984);
INSERT INTO `sys_role_res` VALUES (1554033617590587393, 1554021311284641792, 1548347725588856832);
INSERT INTO `sys_role_res` VALUES (1554033617976463361, 1554021311284641792, 1548347930350583808);
INSERT INTO `sys_role_res` VALUES (1554033618353950722, 1554021311284641792, 1548348105353723904);
INSERT INTO `sys_role_res` VALUES (1554033618739826689, 1554021311284641792, 1548348616052178944);
INSERT INTO `sys_role_res` VALUES (1554033619121508354, 1554021311284641792, 1548405427232964608);
INSERT INTO `sys_role_res` VALUES (1554033619498995713, 1554021311284641792, 1549331353349259264);
INSERT INTO `sys_role_res` VALUES (1554033620698566657, 1554021311284641792, 1549580506746716160);
INSERT INTO `sys_role_res` VALUES (1554033621076054018, 1554021311284641792, 1549580629648211969);
INSERT INTO `sys_role_res` VALUES (1554033621445152770, 1554021311284641792, 1549580705288290304);
INSERT INTO `sys_role_res` VALUES (1554033621826834434, 1554021311284641792, 1549580773156323328);
INSERT INTO `sys_role_res` VALUES (1554033622187544577, 1554021311284641792, 1549332574973853696);
INSERT INTO `sys_role_res` VALUES (1554033622556643330, 1554021311284641792, 1549581428918976513);
INSERT INTO `sys_role_res` VALUES (1554033622929936385, 1554021311284641792, 1549581532111437824);
INSERT INTO `sys_role_res` VALUES (1554033623336783874, 1554021311284641792, 1549581684050100224);
INSERT INTO `sys_role_res` VALUES (1554033623710076929, 1554021311284641792, 1549581745710563328);
INSERT INTO `sys_role_res` VALUES (1554033624083369985, 1554021311284641792, 1549357366699491328);
INSERT INTO `sys_role_res` VALUES (1554033624452468738, 1554021311284641792, 1549582396360359937);
INSERT INTO `sys_role_res` VALUES (1554033624834150402, 1554021311284641792, 1549582458914209793);
INSERT INTO `sys_role_res` VALUES (1554033625211637761, 1554021311284641792, 1549582518355886080);
INSERT INTO `sys_role_res` VALUES (1554033625580736514, 1554021311284641792, 1549582696391507968);
INSERT INTO `sys_role_res` VALUES (1554033747639177218, 1554018909026385920, 1547705944102797312);
INSERT INTO `sys_role_res` VALUES (1554033748004081665, 1554018909026385920, 1548334732557811712);
INSERT INTO `sys_role_res` VALUES (1554033748394151937, 1554018909026385920, 1548337689479217153);
INSERT INTO `sys_role_res` VALUES (1554033748771639298, 1554018909026385920, 1548337830504300544);
INSERT INTO `sys_role_res` VALUES (1554033749199458306, 1554018909026385920, 1548338081055244288);
INSERT INTO `sys_role_res` VALUES (1554033749614694402, 1554018909026385920, 1548341007605694464);
INSERT INTO `sys_role_res` VALUES (1554033749983793153, 1554018909026385920, 1548342106597228544);
INSERT INTO `sys_role_res` VALUES (1554033750365474817, 1554018909026385920, 1548342202961362944);
INSERT INTO `sys_role_res` VALUES (1554033750734573569, 1554018909026385920, 1548342291989659648);
INSERT INTO `sys_role_res` VALUES (1554033751120449538, 1554018909026385920, 1548342492854878208);
INSERT INTO `sys_role_res` VALUES (1554033751514714114, 1554018909026385920, 1548342588178825217);
INSERT INTO `sys_role_res` VALUES (1554033751908978690, 1554018909026385920, 1547707689218473984);
INSERT INTO `sys_role_res` VALUES (1554033752332603394, 1554018909026385920, 1547707998762303488);
INSERT INTO `sys_role_res` VALUES (1554033752731062273, 1554018909026385920, 1549574464377847808);
INSERT INTO `sys_role_res` VALUES (1554033753091772418, 1554018909026385920, 1549301396833173504);
INSERT INTO `sys_role_res` VALUES (1554033753477648386, 1554018909026385920, 1549574565036949505);
INSERT INTO `sys_role_res` VALUES (1554033753855135746, 1554018909026385920, 1549330797398458368);
INSERT INTO `sys_role_res` VALUES (1554033754220040193, 1554018909026385920, 1549568023474601984);
INSERT INTO `sys_role_res` VALUES (1554033754601721857, 1554018909026385920, 1549568767154061312);
INSERT INTO `sys_role_res` VALUES (1554033754979209218, 1554018909026385920, 1549357874663260160);
INSERT INTO `sys_role_res` VALUES (1554033755453165569, 1554018909026385920, 1549574666736238593);
INSERT INTO `sys_role_res` VALUES (1554033755818070018, 1554018909026385920, 1549332755526057984);
INSERT INTO `sys_role_res` VALUES (1554033756195557378, 1554018909026385920, 1548347725588856832);
INSERT INTO `sys_role_res` VALUES (1554033757374156802, 1554018909026385920, 1548347930350583808);
INSERT INTO `sys_role_res` VALUES (1554033757793587201, 1554018909026385920, 1548348105353723904);
INSERT INTO `sys_role_res` VALUES (1554033758150103041, 1554018909026385920, 1548348616052178944);
INSERT INTO `sys_role_res` VALUES (1554033758535979009, 1554018909026385920, 1548405427232964608);
INSERT INTO `sys_role_res` VALUES (1554033759701995521, 1554018909026385920, 1549331353349259264);
INSERT INTO `sys_role_res` VALUES (1554033760113037313, 1554018909026385920, 1549580506746716160);
INSERT INTO `sys_role_res` VALUES (1554033760482136065, 1554018909026385920, 1549580629648211969);
INSERT INTO `sys_role_res` VALUES (1554033761643958274, 1554018909026385920, 1549580705288290304);
INSERT INTO `sys_role_res` VALUES (1554033762113720321, 1554018909026385920, 1549580773156323328);
INSERT INTO `sys_role_res` VALUES (1554033762499596290, 1554018909026385920, 1549332574973853696);
INSERT INTO `sys_role_res` VALUES (1554033762872889345, 1554018909026385920, 1549581428918976513);
INSERT INTO `sys_role_res` VALUES (1554033763250376706, 1554018909026385920, 1549581532111437824);
INSERT INTO `sys_role_res` VALUES (1554033763627864066, 1554018909026385920, 1549581684050100224);
INSERT INTO `sys_role_res` VALUES (1554033764017934338, 1554018909026385920, 1549581745710563328);
INSERT INTO `sys_role_res` VALUES (1554033764416393217, 1554018909026385920, 1549357366699491328);
INSERT INTO `sys_role_res` VALUES (1554033764789686273, 1554018909026385920, 1549582396360359937);
INSERT INTO `sys_role_res` VALUES (1554033765162979330, 1554018909026385920, 1549582458914209793);
INSERT INTO `sys_role_res` VALUES (1554033765569826818, 1554018909026385920, 1549582518355886080);
INSERT INTO `sys_role_res` VALUES (1554033765964091393, 1554018909026385920, 1549582696391507968);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL,
  `user_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `pass_word` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `cell_phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号码',
  `mail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮件',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `status` tinyint DEFAULT NULL COMMENT '状态（0-正常，1-删除，2-禁用)',
  `account_type` tinyint DEFAULT NULL COMMENT '账户类型 1管理员账号 2普通账号',
  `sex` tinyint DEFAULT NULL COMMENT '性别：0男 1女',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `sign` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户签名',
  `ancestor_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '祖级ID',
  `picture_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1550874673959534592, 'admin', '系统管理员', 'E10ADC3949BA59ABBE56E057F20F883E', '13222222222', NULL, NULL, 0, 1, 0, NULL, NULL, NULL, '1554187828970258432', 'system::code', '系统管理员', '2022-07-24 00:05:11', '系统管理员', '2022-08-02 03:30:32');
INSERT INTO `sys_user` VALUES (1554018467705913344, 'HaiNan', '海南省管理员', 'E10ADC3949BA59ABBE56E057F20F883E', '13659630007', NULL, NULL, 0, 1, 0, NULL, NULL, '1550874673959534592,', '1554036351383502848', 'hainan::code', '系统管理员', '2022-08-01 16:17:30', '系统管理员', '2022-08-02 03:29:46');
INSERT INTO `sys_user` VALUES (1554018574048296960, 'JiangXi', '江西省管理员', 'E10ADC3949BA59ABBE56E057F20F883E', '13659630007', NULL, NULL, 0, 1, 0, NULL, NULL, '1550874673959534592,', NULL, 'jiangxi::code', '系统管理员', '2022-08-01 16:17:55', '系统管理员', '2022-08-02 03:30:15');
INSERT INTO `sys_user` VALUES (1554020092700917760, 'HaiKou', '海口市管理员', 'E10ADC3949BA59ABBE56E057F20F883E', '13659630007', NULL, NULL, 0, 1, 0, NULL, NULL, '1554018467705913344,1550874673959534592,', '1554036410212810752', 'hn:haikou::code', 'HaiNan', '2022-08-01 16:23:57', 'HaiNan', '2022-08-02 03:15:35');
INSERT INTO `sys_user` VALUES (1554021502083530752, 'LongHua', '龙华区管理员', 'E10ADC3949BA59ABBE56E057F20F883E', '13659630007', NULL, NULL, 0, 1, 0, NULL, NULL, '1554020092700917760,1554018467705913344,1550874673959534592,', '1554036439916871680', 'hn:hk:longhua::code', 'HaiKou', '2022-08-01 16:29:33', 'HaiNan', '2022-08-02 03:15:48');
INSERT INTO `sys_user` VALUES (1554034667051679744, 'lhservice1', '龙华区业务员一', 'E10ADC3949BA59ABBE56E057F20F883E', '13659630007', NULL, NULL, 0, 2, 0, NULL, NULL, '1554021502083530752,1554020092700917760,1554018467705913344,1550874673959534592,', '1554036475320991744', 'hn:hk:longhua::code', 'LongHua', '2022-08-01 17:21:52', '系统管理员', '2022-08-01 17:29:04');
INSERT INTO `sys_user` VALUES (1554035651396108288, 'MeiLan', '美兰区管理员', 'E10ADC3949BA59ABBE56E057F20F883E', '13659630007', NULL, NULL, 0, 1, 0, NULL, NULL, '1554020092700917760,1554018467705913344,1550874673959534592,', '1554036511085821952', 'hn:hk:meilan::code', 'HaiKou', '2022-08-01 17:25:47', 'HaiNan', '2022-08-02 03:15:59');
INSERT INTO `sys_user` VALUES (1554183478201942016, 'HaiDian', '海甸区管理员', 'E10ADC3949BA59ABBE56E057F20F883E', '13223443321', NULL, NULL, 0, 1, 0, NULL, NULL, '1554018467705913344,1550874673959534592,', NULL, 'hn:hk:haidian::code', 'HaiNan', '2022-08-02 03:13:11', NULL, NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=1554183478627454979 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1554018468074995714, 1554018467705913344, 1554018909026385920);
INSERT INTO `sys_user_role` VALUES (1554018574429962242, 1554018574048296960, 1554018909026385920);
INSERT INTO `sys_user_role` VALUES (1554020093078388737, 1554020092700917760, 1554020541000712192);
INSERT INTO `sys_user_role` VALUES (1554021502473584642, 1554021502083530752, 1554021311284641792);
INSERT INTO `sys_user_role` VALUES (1554034667454238721, 1554034667051679744, 1554021311284641792);
INSERT INTO `sys_user_role` VALUES (1554035651786084354, 1554035651396108288, 1554021311284641792);
INSERT INTO `sys_user_role` VALUES (1554036323541618690, 1550874673959534592, 1554018909026385920);
INSERT INTO `sys_user_role` VALUES (1554183478627454978, 1554183478201942016, 1554021311284641792);
COMMIT;

-- ----------------------------
-- Table structure for toilet_info
-- ----------------------------
DROP TABLE IF EXISTS `toilet_info`;
CREATE TABLE `toilet_info` (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公厕名称',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公厕编码',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '位置(wkt)',
  `status` tinyint DEFAULT NULL COMMENT '状态(0正常 1删除)',
  `type` tinyint DEFAULT NULL COMMENT '是否为公厕(0是 1否)',
  `tenant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '多租户代码',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='公厕信息';

-- ----------------------------
-- Records of toilet_info
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
