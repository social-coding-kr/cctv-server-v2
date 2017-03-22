USE cctv;

CREATE TABLE `cctvs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `name` varchar(200) NOT NULL COMMENT '이름',
  `latitude` double NOT NULL COMMENT '위도',
  `longitude` double NOT NULL COMMENT '경도',
  `cluster_id` varchar(200) DEFAULT NULL COMMENT '클러스터링 id',
  `address` varchar(200) DEFAULT NULL COMMENT '주소',
  `province` varchar(50) DEFAULT NULL COMMENT '광역지방자치단체',
  `district` varchar(50) DEFAULT NULL COMMENT '기초지방자치단체',
  `village` varchar(50) DEFAULT NULL COMMENT '비자치구역',
  `type` varchar(20) NOT NULL COMMENT '타입',
  `created_by` varchar(200) NOT NULL COMMENT '생성자',
  `created_date` datetime NOT NULL COMMENT '생성 일시',
  `last_modified_by` varchar(200) NOT NULL COMMENT '마지막 수정자',
  `last_modified_date` datetime NOT NULL COMMENT '마지막 수정 일시',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cctvs_uk01` (`name`)
  KEY `cctvs_idx01` (`cluster_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cctv`.`official_cctvs` (
  `id` bigint(20) NOT NULL COMMENT 'pk',
  `data_source` varchar(100) DEFAULT NULL COMMENT '출처',
  `extra_properties` mediumtext COMMENT '기타',
  `created_by` varchar(200) NOT NULL COMMENT '생성자',
  `created_date` datetime NOT NULL COMMENT '생성 일시',
  `last_modified_by` varchar(200) NOT NULL COMMENT '마지막 수정자',
  `last_modified_date` datetime NOT NULL COMMENT '마지막 수정 일시',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cctv`.`user_cctvs` (
  `id` bigint(20) NOT NULL COMMENT 'pk',
  `cctv_image` varchar(500) DEFAULT NULL COMMENT 'cctv 이미지',
  `notice_image` varchar(500) DEFAULT NULL COMMENT '안내판 이미지',
  `extra_properties` mediumtext COMMENT '기타',
  `register_by` varchar(200) NULL COMMENT '등록자',
  `created_by` varchar(200) NOT NULL COMMENT '생성자',
  `created_date` datetime NOT NULL COMMENT '생성 일시',
  `last_modified_by` varchar(200) NOT NULL COMMENT '마지막 수정자',
  `last_modified_date` datetime NOT NULL COMMENT '마지막 수정 일시',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;