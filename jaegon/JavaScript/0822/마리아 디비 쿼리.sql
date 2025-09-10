SELECT id, NAME, age, mobile
FROM test.person
;

INSERT INTO test.person(name, age, mobile)
VALUES
('물고기2',22,'010-2000-2000')
;

INSERT INTO test.person(name, age, mobile)
VALUES
('물고기2',22,'010-2000-2000')
;

DELETE FROM test.person #레코드 삭제
WHERE id = 2
;