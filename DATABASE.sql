CREATE TABLE Pubblicazione(
isbn SERIAL PRIMARY KEY,
numero_pagine INT NOT NULL,
anno_pubblicazione INT NOT NULL,
titolo VARCHAR(255) NOT NULL,
autore VARCHAR(50) NOT NULL,
genere VARCHAR(50) NOT NULL, 
periodicita VARCHAR(50),
CONSTRAINT chk_periodicita CHECK (periodicita IN ('SETTIMANALE','MENSILE', 'SEMESTRALE')),
tipo_pubblicazione VARCHAR(50)
);
CREATE TABLE Utente(
numero_tessera SERIAL PRIMARY KEY,
nome VARCHAR(50)NOT NULL,
cognome VARCHAR(50) NOT NULL,
data_nascita DATE NOT NULL
);

CREATE TABLE Prestito(
id SERIAL PRIMARY KEY, 
id_utente INTEGER REFERENCES Utente(numero_tessera),
id_pubblicazione INTEGER REFERENCES Pubblicazione(isbn),
data_inizio_prestito  DATE DEFAULT CURRENT_DATE,
data_restituzione DATE DEFAULT (CURRENT_DATE + INTERVAL '30 days'),
data_restituzione_effettiva DATE
)

