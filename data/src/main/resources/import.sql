# # Database

## Initial data
# Nations
INSERT INTO nation (name) VALUES ('Austria-Hungary');
INSERT INTO nation (name) VALUES ('England');
INSERT INTO nation (name) VALUES ('France');
INSERT INTO nation (name) VALUES ('Germany');
INSERT INTO nation (name) VALUES ('Italy');
INSERT INTO nation (name) VALUES ('Russia');
INSERT INTO nation (name) VALUES ('Turkey');

## Zones
INSERT INTO region (name, type) VALUES ('North-Atlantic Ocean', 1);
INSERT INTO region (name, type) VALUES ('Iceland', 0);
INSERT INTO region (name, type) VALUES ('Norwegian See', 1);
INSERT INTO region (name, type, owner_id) VALUES ('Clyde', 2, 2);
INSERT INTO region (name, type, is_supply_center, core_id, owner_id) VALUES ('Edinburgh', 2, 1, 2, 2);
INSERT INTO region (name, type) VALUES ('North Sea', 1);
INSERT INTO region (name, type) VALUES ('Ireland', 0);
INSERT INTO region (name, type) VALUES ('Irish Sea', 1);
INSERT INTO region (name, type, is_supply_center, core_id, owner_id) VALUES ('Liverpool', 2, 1, 2, 2);
INSERT INTO region (name, type, owner_id) VALUES ('York', 2, 2);
INSERT INTO region (name, type, owner_id) VALUES ('Wales', 2, 2);
INSERT INTO region (name, type, is_supply_center, core_id, owner_id) VALUES ('London', 2, 1, 2, 2);
INSERT INTO region (name, type) VALUES ('Mid-Atlantic Ocean', 1);
INSERT INTO region (name, type) VALUES ('English Chanel', 1);

## Units
INSERT INTO unit (name, type, owner_id, location_id) VALUES ('Royal Navy #1', 0, 2, 5);
INSERT INTO unit (name, type, owner_id, location_id) VALUES ('Royal Marines #2', 1,  2, 9);
INSERT INTO unit (name, type, owner_id, location_id) VALUES ('Royal Navy #3', 0, 2, 12);

## Commands