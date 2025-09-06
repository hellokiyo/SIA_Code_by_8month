create database test;

use test;

CREATE TABLE todo (
  id INT AUTO_INCREMENT PRIMARY KEY,
  content VARCHAR(255) NOT NULL,
  completed BOOLEAN DEFAULT FALSE,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


drop table todo;
-- 샘플 데이터
INSERT INTO todo (content, completed) VALUES
('스프링 부트 연습하기', 0),
('Thymeletodoaf 템플릿 붙이기', 1);


select * from todo;