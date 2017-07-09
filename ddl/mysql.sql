drop table if exists t_sys_permission;
drop table if exists t_sys_role;
drop table if exists t_sys_role_permission;
drop table if exists t_sys_user;
drop table if exists t_sys_user_role;

create table `t_sys_permission` (
  `id` varchar(32) not null comment '主键',
  `name` varchar(255) default null comment '菜单名',
  `css_class` varchar(255) default null comment '菜单样式图标名',
  `url` varchar(255) default null comment '菜单相对URL',
  `skey` varchar(255) default null comment '菜单KEY',
  `parent_key` varchar(255) default null comment '父菜单KEY',
  `hide` int(11) default null comment '是否显示：1=有效，0=无效',
  `lev` int(11) default null comment '菜单级别，最多只能有3级',
  `sort` int(11) default null comment '菜单排序',
  primary key (`id`)
) engine=innodb default charset=utf8mb4;

create table `t_sys_role` (
  `id` varchar(32) not null comment '主键',
  `name` varchar(255) default null comment '角色名' ,
  `code` varchar(255) default null comment '角色编码' ,
  `remark` varchar(255) default null comment '备注' ,
  primary key (`id`)
) engine=innodb default charset=utf8mb4;

create table `t_sys_role_permission` (
  `id` varchar(32) not null comment '主键' ,
  `permission_id` varchar(255) default null comment '菜单表主键' ,
  `role_id` varchar(255) default null comment '角色表主键' ,
  primary key (`id`)
) engine=innodb default charset=utf8mb4;

create table `t_sys_user` (
  `id` varchar(32) not null comment '主键' ,
  `username` varchar(255) default null comment '登录账号' ,
  `password` varchar(255) default null comment '登录密码' ,
  `salt` varchar(255) default null comment 'salt' ,
  `true_name` varchar(255) default null comment '真实姓名' ,
  `email` varchar(255) default null comment '邮箱' ,
  `organize_id` varchar(255) default null comment '部门ID' ,
  `status` int(11) default null comment '状态：0=有效，1=无效' ,
  `last_login_time` datetime default null comment '上将登录时间' ,
  `create_time` datetime default null comment '创建时间' ,
  `modify_time` datetime default null comment '更新时间' ,
  primary key (`id`)
) engine=innodb default charset=utf8mb4;

create table `t_sys_user_role` (
  `id` varchar(32) not null comment '主键' ,
  `role_id` varchar(255) default null comment '角色表主键' ,
  `user_id` varchar(255) default null comment '用户表主键' ,
  primary key (`id`)
) engine=innodb default charset=utf8mb4;

drop table if exists `t_news`;
create table `t_news` (
  `id` varchar(32) not null,
  `address` varchar(255) default null,
  `create_time` datetime default null,
  `description` varchar(255) default null,
  `news_time` datetime default null,
  `title` varchar(255) default null,
  primary key (`id`)
) engine=innodb default charset=utf8mb4;

insert into t_news(id,address,create_time,description,news_time,title) values('8d797e202bd94f8b858d9b73af6b627u','测试多数据源1',now(),'测试多数据源1',now(),'测试多数据源1');



