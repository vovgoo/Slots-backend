CREATE TABLE IF NOT EXISTS slot (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL
);

INSERT INTO slot (image, title) VALUES
('https://i.imgur.com/59lDuen.png', 'Egypt King  2'),
('https://i.imgur.com/DSSpp13.png', 'Royal Coins 2'),
('https://i.imgur.com/iyo6ogx.png', 'Four the Win WILD'),
('https://i.imgur.com/1miPJqm.png', 'Secret Spellbook'),
('https://i.imgur.com/IyomUsx.png', 'Gates of Olympus'),
('https://i.imgur.com/5ooSyo2.png', 'Aviator'),
('https://i.imgur.com/3d4hGUy.png', 'Ultimate Hot'),
('https://i.imgur.com/0EAmjNd.png', 'Sun of Egypt 3'),
('https://i.imgur.com/BU8y85N.png', 'JetX'),
('https://i.imgur.com/ddFPSOM.png', 'Coin Strike');
