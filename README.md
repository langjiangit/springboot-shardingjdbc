# springboot-shardingjdbc

# 创建数据库
-- 两个库 demo_ds_0、demo_ds_1, 包含两个表：t_order_0、t_order_1

-- 建库SQL如下：
DROP SCHEMA IF EXISTS demo_ds_0;
DROP SCHEMA IF EXISTS demo_ds_1;
CREATE SCHEMA IF NOT EXISTS demo_ds_0 CHARACTER   SET   'utf8' COLLATE   'utf8_general_ci';
CREATE SCHEMA IF NOT EXISTS demo_ds_1 CHARACTER   SET   'utf8' COLLATE   'utf8_general_ci';

-- 建表SQL如下(分别在两个库中执行)：
CREATE TABLE IF NOT EXISTS t_order_0 (order_id BIGINT AUTO_INCREMENT COMMENT '主键', user_id INT NOT NULL  COMMENT '用户id', status VARCHAR(50)  COMMENT '状态', PRIMARY KEY (order_id));  
CREATE TABLE IF NOT EXISTS t_order_1 (order_id BIGINT AUTO_INCREMENT COMMENT '主键', user_id INT NOT NULL  COMMENT '用户id', status VARCHAR(50)  COMMENT '状态', PRIMARY KEY (order_id));  