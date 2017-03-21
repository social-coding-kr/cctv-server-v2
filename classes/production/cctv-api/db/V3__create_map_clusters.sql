CREATE TABLE `map_clusters` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `cluster_id` varchar(200) NOT NULL COMMENT '클러스터링 id',
  `cluster_name` varchar(200) NOT NULL COMMENT '클러스터 이름',
  `description` varchar(200) DEFAULT NULL COMMENT '설명',
  `display_latitude` double DEFAULT NULL COMMENT '표시 위도',
  `display_longitude` double DEFAULT NULL COMMENT '표시 경도',
  `created_by` varchar(200) NOT NULL COMMENT '생성자',
  `created_date` datetime NOT NULL COMMENT '생성 일시',
  `last_modified_by` varchar(200) NOT NULL COMMENT '마지막 수정자',
  `last_modified_date` datetime NOT NULL COMMENT '마지막 수정 일시',
  PRIMARY KEY (`id`),
  UNIQUE KEY `map_clusters_uk01` (`cluster_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;