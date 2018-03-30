CREATE TABLE ps_konfiguracija (
  ID int(11) NOT NULL AUTO_INCREMENT,
  NazivVar varchar(255) DEFAULT NULL,
  VrednostVar varchar(255) DEFAULT NULL,
  Opis varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE ps_kupac (
  ID int(11) NOT NULL AUTO_INCREMENT,
  Naziv varchar(50) DEFAULT NULL,
  JMBG varchar(14) DEFAULT NULL,
  MB varchar(10) DEFAULT NULL,
  PIB varchar(10) DEFAULT NULL,
  Kontakt_osoba varchar(50) DEFAULT NULL,
  Adresa varchar(255) DEFAULT NULL,
  Telefon varchar(20) DEFAULT NULL,
  Email varchar(50) DEFAULT NULL,
  Tip_kupca varchar(2) DEFAULT NULL,
  PRIMARY KEY (ID),
  INDEX FK_ps_kupac_ps_tip_kupca_ID (Tip_kupca)
);

CREATE TABLE ps_snabdevac (
  ID int(11) NOT NULL AUTO_INCREMENT,
  Naziv varchar(255) DEFAULT NULL,
  MB varchar(255) DEFAULT NULL,
  Mesto varchar(255) DEFAULT NULL,
  Adresa varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE ps_status (
  ID int(11) NOT NULL AUTO_INCREMENT,
  naziv varchar(25) DEFAULT NULL,
  opis varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE ps_status_grupe_zahteva (
  ID int(11) NOT NULL AUTO_INCREMENT,
  naziv_statusa_gz varchar(25) DEFAULT NULL,
  opis varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE ps_tehnicki_centar (
  ID int(11) NOT NULL AUTO_INCREMENT,
  Naziv_tc varchar(50) DEFAULT NULL,
  Adresa_sedista varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID)
);
CREATE TABLE ps_tip_dokumenta (
  ID int(11) NOT NULL AUTO_INCREMENT,
  Naziv_tipa varchar(30) DEFAULT NULL,
  Opis varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  firstName varchar(255) DEFAULT NULL,
  lastName varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX UK_user_username (username)
);

CREATE TABLE ps_grupa_zahteva (
  ID int(11) NOT NULL AUTO_INCREMENT,
  mesec varchar(10) DEFAULT NULL,
  godina varchar(4) DEFAULT NULL,
  status_gz_fk int(11) DEFAULT 1 COMMENT '1 - u toku, 2- zavrseno',
  PRIMARY KEY (ID),  
  CONSTRAINT FK_ps_grupa_zahteva_ps_status_grupe_zahteva_ID FOREIGN KEY (status_gz_fk)
  REFERENCES ps_status_grupe_zahteva (ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE user_roles (
  ID int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  roles varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID),
  INDEX user (user_id),
  CONSTRAINT roles_fk_1 FOREIGN KEY (user_id)
  REFERENCES proba.user (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ps_promena_snabdevaca (
  ID int(11) NOT NULL AUTO_INCREMENT,
  snabdevac_fk int(11) DEFAULT NULL,
  kupac_fk int(11) DEFAULT NULL,
  datum_prijema date DEFAULT NULL,
  datum_odobrenja date DEFAULT NULL,
  datum_prigovora date DEFAULT NULL,
  broj_ugovora varchar(255) DEFAULT NULL,
  ugovor_od date DEFAULT NULL,
  ugovor_do date DEFAULT NULL,
  status_fk int(11) DEFAULT NULL,
  otkazni_rok varchar(255) DEFAULT NULL,
  neodredjeno_vreme tinyint(1) DEFAULT 0,
  grupa_zahteva_fk int(11) DEFAULT NULL,
  datum_potpisivanja_ugovora date DEFAULT NULL COMMENT 'OD - odlazak ili DO - dolazak',
  tip_promene varchar(2) DEFAULT NULL,
  datum_kreiranja date DEFAULT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_ps_promena_snabdevaca_ps_grupa_zahteva_ID FOREIGN KEY (grupa_zahteva_fk)
  REFERENCES ps_grupa_zahteva (ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_ps_promena_snabdevaca_ps_kupac_ID FOREIGN KEY (kupac_fk)
  REFERENCES ps_kupac (ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_ps_promena_snabdevaca_ps_snabdevac_ID FOREIGN KEY (snabdevac_fk)
  REFERENCES ps_snabdevac (ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_ps_promena_snabdevaca_ps_status_ID FOREIGN KEY (status_fk)
  REFERENCES ps_status (ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE ps_dokument (
  ID int(11) NOT NULL AUTO_INCREMENT,
  Tip_dokumenta_fk int(11) DEFAULT NULL,
  Datum_upisa datetime DEFAULT NULL,
  Naziv varchar(100) DEFAULT NULL,
  Putanja varchar(255) DEFAULT NULL,
  promena_snabdevaca_fk int(11) DEFAULT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_ps_dokument_ps_promena_snabdevaca_ID FOREIGN KEY (promena_snabdevaca_fk)
  REFERENCES ps_promena_snabdevaca (ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_ps_dokumenta_ps_tip_dokumenta_ID FOREIGN KEY (Tip_dokumenta_fk)
  REFERENCES ps_tip_dokumenta (ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE ps_merno_mesto (
  ID int(11) NOT NULL AUTO_INCREMENT,
  Ed_broj varchar(255) DEFAULT NULL,
  Tc_fk int(11) DEFAULT NULL,
  Planirana_energija decimal(13, 2) DEFAULT NULL,
  Odobrena_snaga decimal(13, 2) DEFAULT NULL,
  Ostvarena_energija decimal(13, 2) DEFAULT NULL,
  promena_snabdevaca_fk int(11) DEFAULT NULL,
  Adresa_mm varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT FK_ps_merna_mesta_ps_tehnicki_centri_ID FOREIGN KEY (Tc_fk)
  REFERENCES ps_tehnicki_centar (ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_ps_merno_mesto_ps_promena_snabdevaca_ID FOREIGN KEY (promena_snabdevaca_fk)
  REFERENCES ps_promena_snabdevaca (ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);