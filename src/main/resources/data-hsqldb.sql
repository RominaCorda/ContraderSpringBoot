INSERT INTO user (username, password, full_name, email, active) VALUES
  ('admin', 'pass', 'Administrator', 'admin@capitalireporting.info', TRUE),
  ('gian', 'pass', 'Gianmaria Borgonovo', 'gian@capitalireporting.info', TRUE),
  ('lorenzo', 'pass', 'Lorenzo Brandimarte', 'lorenzo@capitalireporting.info', TRUE),
  ('michela', 'pass', 'Michela Da Ros', 'michela@capitalireporting.info', TRUE),
  ('alessio', 'doctor', 'Alessio Saltarin', 'alessio@capitalireporting.info', TRUE);
INSERT INTO role (description) VALUES
  ('admin'),
  ('poweruser'),
  ('editor'),
  ('normal'),
  ('guest');

