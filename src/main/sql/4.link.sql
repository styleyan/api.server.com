-- 友链表
CREATE TABLE `blog_link`(
   `id` int(10) unsigned AUTO_INCREMENT,
   `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   `website_name` varchar(20) unique NOT NULL COMMENT '友链名称',
   `website_url` varchar(120) NOT NULL COMMENT '链接地址',
   `state` int(1) NOT NULL DEFAULT 1 COMMENT '是否显示, 1:显示, 0: 不显示',
   `desc` varchar(240) NOT NULL COMMENT '友链描述',
   `https` int NOT NULL DEFAULT 1 COMMENT '是否是https: 0: 否, 1: 是',
   primary key (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='友链表';


