<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java - Kolekcje

### Zadania.

Stwórz projekt `Homework_04`. Rozwiązania zadań powinny znajdować się w tym projekcie.

#### Zadanie 1

W projekcie stwórz servlet `Servlet_01_1` oraz `Servlet_01_2`. Następnie:
1. Na pierwszej stronie (`Servlet_01_1`) stwórz formularz z elementem `select` oraz opcjami wyboru zgodnymi z kluczami poniższej mapy:
   ```java
   Map<String, String> lang = new  HashMap<>();
   lang.put("en", "Hello");
   lang.put("pl", "Cześć");
   lang.put("de", "Ehre");
   lang.put("es", "Hola");
   lang.put("fr", "Bienvenue");
   ```
2. Strona ma przesyłać dane za pomocą `POST` do drugiej strony (`Servlet_01_2`), która ma ustawić ciasteczko `language` na wartość wybraną przez użytkownika.
3. Po ponownym wejściu na pierwszą powinna być wyświetlana informacja powitalna w wybranym przez użytkownika języku.
4. Gdy ciasteczko nie istnieje, wiadomość powitalna powinna być wyświetlana w języku polskim.

Hint: Odpowiednie dane przekaż i przetwórz w pliku widoku.

#### Zadanie 2

Zapoznaj się z wzorcem DAO - [Wikipedia] [dao-wiki].

Jest to wzorzec podobny do znanego już nam ActiveRecords z tą różnicą, że wszystkie metody związane z operacjami na obiekcie są wydzielone do oddzielnej klasy np. ProductDao.

Klasy DAO powinny implementować przynajmniej zestaw operacji CRUD.

Skrót ten oznacza:
- Create  
- Read
- Update
- Delete


W projekcie stwórz servlet, a w nim servlet `Servlet_02` z obsługą metod `doGet` i `doPost`. Celem zadania jest stworzenie formularza do zamawiania biletu lotniczego. W tym celu:
1. Stwórz klasę `Airport` z następującymi polami:
    * Nazwa `name`.
    * Kod `code`.
    * Strefa czasową `timezone`.
2. Stwórz klasę `AirportDao` - a w niej metodę o sygnaturze `List <Airport> getList()`- metoda wczyta z pliku `airports.txt` dane w postaci CSV, utworzy na ich podstawie obiekty klasy `Airport`, które następnie doda do ArrayListy.
3. Stwórz, w pliku jsp, formularz, który przesyła dane metodą `POST`. Formularz powinien zawierać:  
  * Lotnisko wylotu - pole `select` (dane pobrane przez dao).
  * Lotnisko przylotu - pole `select`(dane pobrane przez dao).
  * Czas startu - pole `datetime-local` (będzie to czas wylotu w czasie lokalnym lotniska).
  * Długość lotu w godzinach - pole `number` `min="0"`, `step="1"`.
  * Cenę lotu - pole `number` `min="0"`, `step="0.01"`.
4. Dodaj obsługę tego formularza w metodzie `doPost`. Obsługa powinna polegać tylko na wyświetleniu przesłanych danych. 

Hint: Pamiętaj żeby dane z DAO pobierać tylko raz!. Każdy odczyt z pliku (a potem z bazy danych) może długo trwać. 

#### Zadanie 3

Celem zadania jest obsługa i przetworzenie danych pobranych z formularza, który zrobiliśmy w poprzednim zadaniu. W tym celu zmodyfikuj metodę `doPost` servletu z poprzedniego pytania w następujący sposób:
1. Sprawdź czy użytkownik nie wybrał takiego samego lotniska wylotu i przylotu.
2. Sprawdź czy data i czas lotu zostały podane.
3. Sprawdź czy cena lotu jest większa od `0`.
4. Pobierz strefę czasową lotniska wylotu i zapisz ją do zmiennej.
5. Pobierz strefę czasową lotniska przylotu i zapisz ją do zmiennej.
6. Stwórz obiekt z datą lotniska wylotu w jego strefie czasowej i zapisz  czas  do zmiennej 
7. Dodaj do daty czas lotu i zmień strefę czasową na lotnisko przylotu i zapisz  czas  do zmiennej.
8. Stwórz klasę `Flight` z następującymi polami:
    * Lotnisko wylotu `departure`.
    * Lotnisko przylotu `arrival`.
    * Czas przylotu `arrivalTime`
    * Cena lotu `price`

11. Utwórz obiekt klasy z odpowiednimi danymi.

Hint: Żeby poprawnie pracować z strefami czasowymi skorzystaj z [ZonedDateTime][zone-date-time] lub joda-time.
Tutaj znajdziesz przykłady: [przykład1][date-example1] , [przykład2][date-example2]


#### Zadanie 4 
Celem zadania jest wyświetlenie danych przetworzonych w poprzednim zadaniu.  W tym celu:
1. Przekaż do widoku utworzony uprzednio obiekt klasy `Flight`.
2. Stwórz w html tabelę zawierającą dane (wygląd tabeli nie ma znaczenia):  
   * lotnisko wylotu z czasem wylotu i kodem lotniska
   * lotnisko przylotu z czasem przylotu i kodem lotniska
   * czas lotu
   * cenę lotu
   
#### Zadanie 5   
1. Umieść na stronie dostępnej pod adresem **/** dowolny tekst, możesz skorzystać z generatora: [lorem-ipsum].
2. Umieść na stronie formularz z możliwością zapisu użytkownika na newsletter.
Formularz musi mieć następujące pola:
  * email (Adres email),
  * name (Imię i nazwisko).
3. Formularz powinien wyświetlać się dla użytkownika raz na 24 godziny - wykorzystaj w tym celu ciasteczka.
4. Napisz obsługę formularza - dane zapisz do bazy.
5. Zapytania tworzące tabele w bazie danych umieść w pliku `query.sql`.
 
 
#### Zadanie 6 

Celem zadania jest udostępnienie funkcjonalności księgi gości.

1. Utwórz servlet wyświetlający listę wpisów z księgi gości. Ma być dostępny pod adresem **/guest-book**
2. Wyświetlane mają być wpisy w kolejności od najnowszego do najstarszego.
3. Informacje o wpisach mają być pobierane z bazy danych.
4. Zapytania tworzące tabele w bazie danych umieść w pliku `query.sql`.
5. Dane dostępowe do bazy danych umieść w parametrach inicjalizacji dla całej aplikacji.
6. Na stronie nad wpisami umieść formularz umożliwiający dodawanie nowego wpisu (nazwa oraz opis). 

<!-- Links -->
[zone-date-time]:https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html 
[date-example1]:https://www.mkyong.com/java/java-convert-date-and-time-between-timezone/
[date-example2]:https://dzone.com/articles/deeper-look-java-8-date-and
[dao-wiki]:https://pl.wikipedia.org/wiki/Data_Access_Object
[lorem-ipsum]:http://pl.lipsum.com/
