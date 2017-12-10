--  #### Database

--  ### Initial data
--  ## Nations
INSERT INTO nation (name) VALUES ('Austria-Hungary');
INSERT INTO nation (name) VALUES ('England');
INSERT INTO nation (name) VALUES ('France');
INSERT INTO nation (name) VALUES ('Germany');
INSERT INTO nation (name) VALUES ('Italy');
INSERT INTO nation (name) VALUES ('Russia');
INSERT INTO nation (name) VALUES ('Turkey');

-- ## Zones
-- #1
INSERT INTO region (name, type) VALUES ('North-Atlantic Ocean', 1);
-- #2
INSERT INTO region (name, type) VALUES ('Iceland', 0);
-- #3
INSERT INTO region (name, type) VALUES ('Norwegian See', 1);
-- #4
INSERT INTO region (name, type, owner_id) VALUES ('Clyde', 2, 2);
-- #5
INSERT INTO region (name, type, is_supply_center, core_id, owner_id) VALUES ('Edinburgh', 2, 1, 2, 2);
-- #6
INSERT INTO region (name, type) VALUES ('North Sea', 1);
-- #7
INSERT INTO region (name, type) VALUES ('Ireland', 0);
-- #8
INSERT INTO region (name, type) VALUES ('Irish Sea', 1);
-- #9
INSERT INTO region (name, type, is_supply_center, core_id, owner_id) VALUES ('Liverpool', 2, 1, 2, 2);
-- #10
INSERT INTO region (name, type, owner_id) VALUES ('York', 2, 2);
-- #11
INSERT INTO region (name, type, owner_id) VALUES ('Wales', 2, 2);
-- #12
INSERT INTO region (name, type, is_supply_center, core_id, owner_id) VALUES ('London', 2, 1, 2, 2);
-- #13
INSERT INTO region (name, type) VALUES ('Mid-Atlantic Ocean', 1);
-- #14
INSERT INTO region (name, type) VALUES ('English Chanel', 1);

-- # North-Atlantic Ocean
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (1, 2);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (1, 3);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (1, 4);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (1, 7);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (1, 8);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (1, 13);
-- # Iceland
-- # Norwegian Sea
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (3, 1);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (3, 4);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (3, 5);
-- # Ireland
-- # Clyde
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (4, 1);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (4, 3);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (4, 5);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (4, 9);
-- # Edinburgh
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (5, 3);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (5, 4);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (5, 6);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (4, 9);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (4, 10);
-- # North Sea
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (6, 3);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (6, 5);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (6, 10);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (6, 12);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (6, 14);
-- # Irish Sea
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (8, 1);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (8, 9);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (8, 11);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (8, 13);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (8, 14);
-- # Liverpool
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (9, 1);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (9, 4);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (9, 8);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (9, 10);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (9, 11);
-- # York
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (10, 5);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (10, 6);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (10, 9);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (10, 11);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (10, 12);
-- # Wales
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (11, 8);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (11, 9);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (11, 10);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (11, 12);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (11, 14);
-- # London
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (12, 6);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (12, 10);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (12, 11);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (12, 14);
-- # Mid-Atlantic Ocean
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (13, 1);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (13, 8);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (13, 14);
-- # English Chanel
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (14, 6);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (14, 8);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (14, 11);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (14, 12);
INSERT INTO region_adjacent (region_id, adjacent_id) VALUES (14, 13);

-- ## Units
INSERT INTO unit (name, type, owner_id, location_id) VALUES ('Royal Navy #1', 0, 2, 5);
INSERT INTO unit (name, type, owner_id, location_id) VALUES ('Royal Marines #2', 1,  2, 9);
INSERT INTO unit (name, type, owner_id, location_id) VALUES ('Royal Navy #3', 0, 2, 12);

-- ## Commands
INSERT INTO command (unit_id, type, base_id, target_id, note) VALUES (1, 0,  5,  5, 'Hold');
INSERT INTO command (unit_id, type, base_id, target_id, note) VALUES (2, 1,  9, 11, 'Move');
INSERT INTO command (unit_id, type, base_id, target_id, note) VALUES (3, 0, 12, 12, 'Hold');