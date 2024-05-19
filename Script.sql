CREATE TABLE MEDICI(
                       ID INT(2) PRIMARY KEY,
                       NUME VARCHAR(10),
                       PRENUME VARCHAR(10),
                       SPECIALIZARE VARCHAR(20),
                       EMAIL VARCHAR(20),
                       GRAD VARCHAR(20),
                       NR_TELEFON INT(10),
                       ANI_EXPERIENTA INT(2),
                       SALARIU INT(5)
);

CREATE TABLE ASISTENTI(
                          ID INT(2) PRIMARY KEY,
                          ID_MEDIC INT(2),
                          NUME VARCHAR(10),
                          PRENUME VARCHAR(10),
                          EMAIL VARCHAR(20),
                          NR_TELEFON INT(10),
                          SALARIU INT(5),
                          FOREIGN KEY(ID_MEDIC) REFERENCES MEDICI(ID)
);

CREATE TABLE FARMACISTI(
                           ID INT(2) PRIMARY KEY,
                           NUME VARCHAR(10),
                           PRENUME VARCHAR(10),
                           EMAIL VARCHAR(20),
                           NR_TELEFON INT(10),
                           ANI_EXPERIENTA INT(2),
                           SALARIU INT(5)
);
CREATE TABLE PACIENTI(
                         ID INT(2) PRIMARY KEY,
                         NUME VARCHAR(10),
                         PRENUME VARCHAR(10),
                         CNP INT(20)
);
