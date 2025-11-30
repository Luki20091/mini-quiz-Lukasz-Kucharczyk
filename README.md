# Mini Quiz – Łukasz Kucharczyk

Prosta aplikacja mobilna typu "Quiz" stworzona w środowisku Android Studio. Aplikacja pozwala użytkownikowi sprawdzić swoją wiedzę, odpowiadając na losowo wybrane pytania wielokrotnego wyboru.

## 📋 Opis funkcjonalności

Aplikacja realizuje następujące założenia:

*   **Interfejs użytkownika:** Prosty, czytelny układ wertykalny z wyśrodkowanymi elementami.
*   **Losowanie pytań:** Po rozpoczęciu quizu aplikacja losuje 5 pytań z wbudowanej bazy.
*   **System punktacji:** Punkty są zliczane na bieżąco po każdej odpowiedzi.
*   **Informacja zwrotna:** Użytkownik otrzymuje komunikat (Toast) o poprawności wybranej odpowiedzi.
*   **Podsumowanie:** Po zakończeniu quizu wyświetlany jest wynik końcowy (np. "Twój wynik: 4 / 5").
*   **Resetowanie:** Przycisk "RESETUJ QUIZ" pozwala wyzerować wynik i rozpocząć zabawę od nowa.

## 🛠️ Technologie i Wymagania Techniczne

Projekt został zrealizowany zgodnie z następującymi wytycznymi:

*   **Środowisko:** Android Studio.
*   **Język programowania:** Java.
*   **Warstwa wizualna (UI):** XML (LinearLayout).
*   **Język projektu:** Wszystkie nazwy zmiennych, metod, klas oraz teksty w interfejsie są w języku polskim.
*   **Struktura danych:** Pytania przechowywane są w kodzie jako tablica obiektów.

## 📂 Struktura plików

Główne pliki projektu to:

1.  **`MainActivity.java`**
    *   Zawiera logikę aplikacji.
    *   Obsługuje przyciski (Start, Reset, Odpowiedzi A/B/C).
    *   Zarządza losowaniem pytań i zliczaniem punktów.
    *   Aktualizuje widok (TextView) z wynikiem.

2.  **`Pytanie.java`**
    *   Klasa modelu danych.
    *   Przechowuje treść pytania, trzy warianty odpowiedzi oraz informację o poprawnej odpowiedzi.

3.  **`activity_main.xml`**
    *   Definiuje wygląd aplikacji.
    *   Zawiera elementy takie jak: Tytuł, Przyciski, Pole tekstowe pytania i Wynik.

## 🚀 Jak uruchomić projekt

1.  Pobierz pliki projektu lub sklonuj repozytorium.
2.  Otwórz **Android Studio**.
3.  Wybierz opcję **Open an Existing Project** i wskaż folder z projektem.
4.  Poczekaj na synchronizację projektu (Gradle Sync).
5.  Uruchom aplikację na emulatorze (przycisk **Run 'app'**).

## 📝 Przykładowe pytania w bazie

Aplikacja posiada wbudowaną bazę pytań, np.:
*   "Stolica Włoch to:" (Rzym, Paryż, Madryt)
*   "2 + 2 * 2 to:" (8, 6, 4)
*   "Największy ocean to:" (Atlantycki, Indyjski, Spokojny)

## Widok aplikacji

![Screenshot
1](https://raw.githubusercontent.com/Luki20091/mini-quiz-Lukasz-Kucharczyk/main/Screenshot_1.png)

![Screenshot
2](https://raw.githubusercontent.com/Luki20091/mini-quiz-Lukasz-Kucharczyk/main/Screenshot_2.png)

![Screenshot
3](https://raw.githubusercontent.com/Luki20091/mini-quiz-Lukasz-Kucharczyk/main/Screenshot_3.png)


## 👤 Autor

**Łukasz Kucharczyk**
