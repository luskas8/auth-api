INSERT INTO roles (role_id, name)
VALUES 
    (1, 'admin'),
    (2, 'basic')
ON CONFLICT (role_id) DO NOTHING;
