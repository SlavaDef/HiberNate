INSERT INTO client
(name)
VALUES
('Mikki Djager'),
('Denni Djager'),
('Elon Doe'),
('Fred Durst'),
('John Travolta'),
('Rembo'),
('Mike Taison'),
('Britney Spirs'),
('Diana Spencer'),
('Sidni Girl');

INSERT INTO planet
(id, name)
VALUES
('MER','MERCURY'),
('VEN','VENUS'),
('EAR','EARTH'),
('MAR','MARS'),
('JUP','JUPITER'),
('SAT','SATURN'),
('URA','URANUS'),
('NEP','NEPTUNE');

INSERT INTO ticket
(client_id,from_planet_id, to_planet_id)
VALUES
(1,'EAR','NEP'),
(2,'MER','URA'),
(3,'NEP','JUP'),
(4,'SAT','MAR'),
(5,'URA','SAT'),
(6,'EAR','MAR'),
(7,'EAR','VEN'),
(8,'MAR','VEN'),
(9,'VEN','EAR'),
(10,'MER','NEP');