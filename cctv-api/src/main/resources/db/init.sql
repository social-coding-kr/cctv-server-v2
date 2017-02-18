CREATE DATABASE IF NOT EXISTS inbox_campaign DEFAULT CHARACTER SET utf8 ;

CREATE USER 'cctv'@'localhost' IDENTIFIED BY 'cctv!@#';

INSERT INTO db (HOST,Db,USER,Select_priv,Insert_priv,Update_priv,Delete_priv,Create_priv,Drop_priv,Index_priv, Alter_priv) VALUES('localhost','cctv','cctv','Y','Y','Y','Y','Y','Y','Y','Y');

FLUSH PRIVILEGES;