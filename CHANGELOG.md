
# Change Log
Sve bitne promene su zabeležene u ovom dokumentu. 
 
## [1.1] - 2023-22-10
  * commit ee374cf: **Dodate nove funkcionalnosti klijenta i servera > main**

Implementirana komunikacija servera i klijenta. 

### Novo

- Sistem nagrade
- Tok programa podeljen u server i klijent
 
### Izmenjeno

- Izmenjen glavni tok programa i od njega je integrisan novi tok koji se deli na server i klijent. Klijent zahteva unos opklade i 6 brojeva od korisnika i povezuje se nakon toga na server. Server prihvata novu konekciju, kreira po svakoj konekciji novu igru i vraća rezultat igre (Izvučeni brojevi) klijentu. Klijent prima nazad taj rezultat, obrađuje ga preko svojih klasa i na osnovu toga dodeljuje nagradu i ispisuje rezultate.

### Klase
Server >  Server.java, Igra.java 
Klijent > Klijent.java, Korisnik.java, Nagrada.java

 
### Popravljeno
 
- Greška prilikom ispisivanja rezultata klijentu (Klijent nije dobijao ispis svojih brojeva na kraju igre)
 

## [1.0] - 2023-22-10
  
Projekat napravljen sa svim osnovnim funkcijama i bez mogućnosti komunikacije servera i klijenta. 
