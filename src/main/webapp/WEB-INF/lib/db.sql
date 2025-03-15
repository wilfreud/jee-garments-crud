CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE garments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    category ENUM('Haut', 'Bas', 'Chaussures', 'Accessoire', 'Autre') NOT NULL,
    status ENUM('Disponible', 'Au pressing', 'Prêté', 'Nettoyage') DEFAULT 'Disponible',
    location VARCHAR(100), -- Ex: "Pressing Dupont", "Chez Paul", "Maison"
    last_action_date DATE,
    notes TEXT,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);