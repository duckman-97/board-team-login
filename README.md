# board-team-login
spring boot 게시판 졸업 프로젝트



DB구조

  CREATE TABLE `comment` (
    `cno` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `bno` bigint(20) NOT NULL,
    `content` varchar(3000) NOT NULL COMMENT '내용',
    `writer` varchar(20) NOT NULL COMMENT '작성자',
    PRIMARY KEY (`cno`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;




  CREATE TABLE `tb_post` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `title` varchar(100) NOT NULL COMMENT '제목',
    `content` varchar(3000) NOT NULL COMMENT '내용',
    `writer` varchar(20) NOT NULL COMMENT '작성자',
    `view_cnt` int(11) NOT NULL COMMENT '조회 수',
    `delete_yn` tinyint(1) NOT NULL COMMENT '삭제 여부',
    `created_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일시',
    `modified_date` datetime DEFAULT NULL COMMENT '최종 수정일시',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='게시글';


  CREATE TABLE `TB_USER` (
    `USER_NO` int(11) NOT NULL AUTO_INCREMENT COMMENT '사용자번호',
    `USER_ID` varchar(255) NOT NULL COMMENT '아이디',
    `USER_PW` varchar(256) DEFAULT NULL COMMENT '비밀번호',
    `USER_AUTH` varchar(255) NOT NULL COMMENT '권한',
    `APPEND_DATE` datetime DEFAULT NULL COMMENT '추가날짜',
    `UPDATE_DATE` datetime DEFAULT NULL COMMENT '수정날짜',
    PRIMARY KEY (`USER_NO`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;
