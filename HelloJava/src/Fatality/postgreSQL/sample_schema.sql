CREATE SCHEMA s_main;

ALTER SCHEMA public RENAME TO s_public;
ALTER SCHEMA s_public RENAME TO public;