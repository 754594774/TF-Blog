CREATE TABLE blog_category (
  id int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  name varchar(30) NOT NULL COMMENT '名称',
  description varchar(200) NOT NULL COMMENT '描述',
  gmt_create datetime DEFAULT NULL COMMENT '录入时间',
  gmt_modified datetime DEFAULT NULL COMMENT '更新时间'
) 

CREATE TABLE blog_article (
  id int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  category_id int(10) NOT NULL COMMENT '文章类别id',
  title varchar(30) NOT NULL COMMENT '标题',
  author varchar(15) NOT NULL COMMENT '作者',
  content text NOT NULL COMMENT '正文',
  gmt_create datetime DEFAULT NULL COMMENT '录入时间',
  gmt_modified datetime DEFAULT NULL COMMENT '更新时间',
  sort_no int(10) COMMENT '显示顺序',
  is_stick tinyint(1) unsigned zerofill NOT NULL COMMENT '是否置顶',
  is_draft tinyint(1) unsigned zerofill NOT NULL COMMENT '是否草稿',
  is_deleted tinyint(1) unsigned zerofill NOT NULL COMMENT '是否删除',
  foreign key(category_id) references blog_category(id)
) 

