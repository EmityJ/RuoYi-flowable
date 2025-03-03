-- ----------------------------
-- 1、创建校外人员信息表
-- ----------------------------
drop table if exists sys_external_contact;
create table sys_external_contact (
    contact_id      bigint(20)      not null auto_increment    comment '联系人ID',
    name            varchar(50)      not null                   comment '姓名',
    id_card         varchar(18)      not null                   comment '身份证号',
    bank_card       varchar(20)                                 comment '银行卡号',
    bank_name       varchar(100)                                comment '开户行',
    phone           varchar(11)                                 comment '手机号',
    work_unit       varchar(200)                                comment '工作单位',
    status          char(1)         default '0'                 comment '状态（0正常 1停用）',
    del_flag        char(1)         default '0'                 comment '删除标志（0代表存在 2代表删除）',
    create_by       varchar(64)     default ''                  comment '创建者',
    create_time     datetime                                    comment '创建时间',
    update_by       varchar(64)     default ''                  comment '更新者',
    update_time     datetime                                    comment '更新时间',
    remark          varchar(500)    default null                comment '备注',
    primary key (contact_id)
) engine=innodb auto_increment=100 comment = '校外人员信息表';

-- ----------------------------
-- 2、创建唯一索引
-- ----------------------------
create unique index idx_external_contact_id_card on sys_external_contact(id_card);
create index idx_external_contact_name on sys_external_contact(name);
create index idx_external_contact_phone on sys_external_contact(phone);

-- ----------------------------
-- 3、初始化-菜单权限数据
-- ----------------------------
-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(2000, '校外信息管理', '0', '4', 'external', null, 1, 0, 'M', '0', '0', '', 'peoples', 'admin', sysdate(), '', null, '校外信息管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(2001, '校外人员信息', @parentId, '1', 'contact', 'system/external/contact/index', 1, 0, 'C', '0', '0', 'system:contact:list', 'user', 'admin', sysdate(), '', null, '校外人员信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(2002, '校外人员查询', @parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'system:contact:query', '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(2003, '校外人员新增', @parentId, '2', '#', '', 1, 0, 'F', '0', '0', 'system:contact:add', '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(2004, '校外人员修改', @parentId, '3', '#', '', 1, 0, 'F', '0', '0', 'system:contact:edit', '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(2005, '校外人员删除', @parentId, '4', '#', '', 1, 0, 'F', '0', '0', 'system:contact:remove', '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(2006, '校外人员导出', @parentId, '5', '#', '', 1, 0, 'F', '0', '0', 'system:contact:export', '#', 'admin', sysdate(), '', null, ''); 