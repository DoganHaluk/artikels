insert into artikels(naam, prijs, artikelgroepid)
values ('test1', 10, (select id from artikelgroepen where naam = 'groep1')),
       ('test2', 20, (select id from artikelgroepen where naam = 'groep1')),
       ('test3', 30, (select id from artikelgroepen where naam = 'groep2'));