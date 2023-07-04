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
('EAR1','NEPTYN'),
('VEN6','JPITER'),
('MAR22','VENERA'),
('NEP4','MARS'),
('JPIT4','EARTH');

INSERT INTO ticket
(client_id,from_planet_id, to_planet_id)
VALUES
(1,'EAR1','JPIT4'),
(2,'VEN6','JPIT4'),
(3,'EAR1','VEN6'),
(4,'VEN6','EAR1'),
(5,'JPIT4','NEP4'),
(6,'EAR1','MAR22'),
(7,'EAR1','VEN6'),
(8,'JPIT4','EAR1'),
(9,'EAR1','MAR22'),
(10,'MAR22','EAR1');