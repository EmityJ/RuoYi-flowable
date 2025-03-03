-- 创建项目表
drop table if exists sys_project;
create table sys_project (
  project_id           bigint(20)      not null auto_increment    comment '项目ID',
  project_code         varchar(64)     not null                   comment '项目编码',
  project_name         varchar(100)    not null                   comment '项目名称',
  amount              decimal(10, 2)                              comment '项目金额',
  leader              varchar(64)                                 comment '项目负责人',
  status              char(1)         default '0'                 comment '项目状态（0正常 1停用）',
  del_flag            char(1)         default '0'                 comment '删除标志（0代表存在 2代表删除）',
  create_by           varchar(64)     default ''                  comment '创建者',
  create_time         datetime                                    comment '创建时间',
  update_by           varchar(64)     default ''                  comment '更新者',
  update_time         datetime                                    comment '更新时间',
  remark             varchar(500)    default null               comment '备注',
  primary key (project_id)
) engine=innodb auto_increment=100 comment = '项目信息表';

-- 初始化菜单数据
INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES('项目管理', '0', '4', 'project', null, 1, 0, 'M', '0', '0', '', 'build', 'admin', sysdate(), '', null, '项目管理目录');

-- 菜单 SQL
INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES('项目管理', '3', '1', 'project', 'system/project/index', 1, 0, 'C', '0', '0', 'system:project:list', 'project', 'admin', sysdate(), '', null, '项目管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES('项目查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:project:query',        '#', 'admin', sysdate(), '', null, '');

INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES('项目新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:project:add',          '#', 'admin', sysdate(), '', null, '');

INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES('项目修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:project:edit',         '#', 'admin', sysdate(), '', null, '');

INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES('项目删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:project:remove',       '#', 'admin', sysdate(), '', null, '');

INSERT INTO sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES('项目导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:project:export',       '#', 'admin', sysdate(), '', null, ''); 