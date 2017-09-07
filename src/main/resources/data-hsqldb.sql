INSERT INTO role (description) VALUES
  ('System Administrator'),
  ('Power User'),
  ('Analyst User'),
  ('Business User'),
  ('Guest');
INSERT INTO user (username, password, full_name, email, active, role_id) VALUES
  ('admin', 'pass', 'Administrator', 'admin@capitalireporting.info', TRUE, 1),
  ('gian', 'pass', 'Gianmaria Borgonovo', 'gian@capitalireporting.info', TRUE, 2),
  ('john', 'pass', 'John Brunello', 'john@capitalireporting.info', TRUE, 2),
  ('lorenzo', 'pass', 'Lorenzo Brandimarte', 'lorenzo@capitalireporting.info', TRUE, 2),
  ('michela', 'pass', 'Michela Da Ros', 'michela@capitalireporting.info', TRUE, 2),
  ('alessio', 'doctor', 'Alessio Saltarin', 'alessio@capitalireporting.info', TRUE, 2);


