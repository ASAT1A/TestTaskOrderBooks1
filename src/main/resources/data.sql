INSERT INTO book_entity (name, author, isbn) VALUES
('Мастер и Маргарита', 'Михаил Булгаков', '1234567890123'),
('Преступление и наказание', 'Федор Достоевский', '1234567890124'),
('Война и мир', 'Лев Толстой', '1234567890125'),
('1984', 'Джордж Оруэлл', '1234567890126'),
('Убить пересмешника', 'Харпер Ли', '1234567890127'),
('Гордость и предубеждение', 'Джейн Остин', '1234567890128'),
('Тёмные начала', 'Филип Пулман', '1234567890129'),
('Автостопом по галактике', 'Дуглас Адамс', '1234567890130'),
('Гарри Поттер и Философский камень', 'Джоан Роулинг', '1234567890131'),
('Маленький принц', 'Антуан де Сент-Экзюпери', '1234567890132'),
('Анна Каренина', 'Лев Толстой', '1234567890133'),
('Сто лет одиночества', 'Габриэль Маркес', '1234567890134'),
('Властелин Колец', 'Джон Толкин', '1234567890135'),
('Унесенные ветром', 'Маргарет Митчелл', '1234567890136'),
('Над пропастью во ржи', 'Джером Сэлинджер', '1234567890137');

INSERT INTO client_entity (name, birthdate) VALUES
('Иванов Александр', '1990-05-15'),
('Петрова Мария', '1985-12-03'),
('Сидоров Дмитрий', '1995-08-22'),
('Кузнецова Елена', '1992-03-10'),
('Николаев Андрей', '1988-11-28'),
('Орлова Ольга', '1993-07-17'),
('Федоров Сергей', '1991-01-05'),
('Алексеева Ирина', '1987-09-14'),
('Дмитриев Павел', '1994-06-30'),
('Соколова Наталья', '1990-02-19');

INSERT INTO loan_entity (loan_date, book_id, client_id)
SELECT
    CURRENT_DATE AS loan_date,
    b.id AS book_id,
    c.id AS client_id
FROM
    (SELECT id FROM book_entity ORDER BY id LIMIT 15) b,
    (SELECT id FROM client_entity ORDER BY id LIMIT 10) c
WHERE
    (c.id = (SELECT id FROM client_entity ORDER BY id LIMIT 1) AND b.id IN (SELECT id FROM book_entity ORDER BY id LIMIT 3))
    OR
    (c.id = (SELECT id FROM client_entity ORDER BY id OFFSET 1 LIMIT 1) AND b.id IN (SELECT id FROM book_entity ORDER BY id OFFSET 3 LIMIT 2))
    OR
    (c.id = (SELECT id FROM client_entity ORDER BY id OFFSET 2 LIMIT 1) AND b.id IN (SELECT id FROM book_entity ORDER BY id OFFSET 5 LIMIT 1))
    OR
    (c.id = (SELECT id FROM client_entity ORDER BY id OFFSET 3 LIMIT 1) AND b.id IN (SELECT id FROM book_entity ORDER BY id OFFSET 6 LIMIT 2))
    OR
    (c.id = (SELECT id FROM client_entity ORDER BY id OFFSET 4 LIMIT 1) AND b.id IN (SELECT id FROM book_entity ORDER BY id OFFSET 8 LIMIT 1))
    OR
    FALSE;