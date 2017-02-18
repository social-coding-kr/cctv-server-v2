CREATE TABLE `cctv`.`cctvs` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'pk',
  `name` varchar(200) NOT NULL COMMENT '이름',
  `latitude` double NOT NULL COMMENT '위도',
  `longitude` double NOT NULL COMMENT '경도',
  `address` varchar(200) DEFAULT NULL COMMENT '주소',
  `region_local_government` varchar(50) DEFAULT NULL COMMENT '광역지방자치단체',
  `basic_local_government` varchar(50) DEFAULT NULL COMMENT '기초지방자치단체',
  `non_self_government` varchar(50) DEFAULT NULL COMMENT '비자치구역',
  `type` varchar(20) NOT NULL COMMENT '타입',
  `created_by` varchar(200) NOT NULL COMMENT '생성자',
  `created_date` datetime NOT NULL COMMENT '생성 일시',
  `last_modified_by` varchar(200) NOT NULL COMMENT '마지막 수정자',
  `last_modified_date` varchar(200) NOT NULL COMMENT '마지막 수정 일시',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_cctvs_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cctv`.`official_cctvs` (
  `id` bigint(20) NOT NULL COMMENT 'pk',
  `data_source` varchar(100) DEFAULT NULL COMMENT '출처',
  `extra_properties` mediumtext COMMENT '기타',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `cctv`.`user_cctvs` (
  `id` bigint(20) NOT NULL COMMENT 'pk',
  `cctv_image` varchar(500) DEFAULT NULL COMMENT 'cctv 이미지',
  `notice_image` varchar(500) DEFAULT NULL COMMENT '안내판 이미지',
  `extra_properties` mediumtext COMMENT '기타',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;