# Igra Pogadjanja

Projekat "Igra Pogadjanja" predstavlja jednostavnu igru u kojoj korisnici biraju brojeve i ulažu opklade, a zatim server izvlači dobitne brojeve i dodeljuje nagrade na osnovu broja pogodjenih brojeva. Ova igra se izvodi uz pomoć komunikacije između klijenta i servera, omogućavajući korisnicima da igraju i osvajaju nagrade.

## Funkcionalnosti

- Korisnici mogu uneti svoje opklade u dinarima.
- Korisnici biraju 6 brojeva iz raspona od 1 do 46.
- Server izvlači 20 dobitnih brojeva.
- Server dodeljuje nagrade na osnovu broja pogodjenih brojeva.

## Tehnički Detalji

Projekat se zasniva na Java programiranju i koristi komunikaciju između klijenta i servera preko Sockets. Ključni komponente projekta uključuju:

- `Server`: Java aplikacija koja služi kao server i komunicira sa svim klijentima. Izvlači dobitne brojeve i dodeljuje nagrade.

- `Klijent`: Java aplikacija koja predstavlja klijentsku stranu igre. Omogućava korisnicima unos opklada i biranje brojeva.

- `Korisnik`: Klasa koja predstavlja korisnika i sadrži informacije o opkladama, brojevima i nagradama.

- `Igra`: Klasa koja se koristi za izvlačenje dobitnih brojeva.

- `Nagrada`: Klasa koja upravlja dodelom nagrada korisnicima na osnovu broja pogodjenih brojeva.

## Upustvo za Pokretanje

1. Pokrenite `Server` aplikaciju na odabranom portu.

2. Pokrenite jednu ili više instanci `Klijent` aplikacije i povežite se na server koristeći odgovarajuću adresu i port.

3. Sledite uputstva na ekranu za unos opklada i biranje brojeva.

4. Nakon izvlačenja dobitnih brojeva, server će dodeliti nagrade korisnicima.


## Licenca

Ova aplikacija je dostupna pod MIT Licencom. Svi korisnici su dobrodošli da koriste, modifikuju i distribuiraju ovaj softver u skladu sa uslovima MIT licence.
