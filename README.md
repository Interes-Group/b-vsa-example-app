# B-VSA LS 21/22 Example Application

[![GitHub](https://img.shields.io/github/license/interes-group/b-vsa-example-app)](http://www.opensource.org/licenses/mit-license.php)
[![Java](https://img.shields.io/badge/Java-8-red)](https://openjdk.java.net/projects/jdk/8/)
[![EclipseLink](https://img.shields.io/badge/EclipseLink-2.7.10-blue)](https://www.eclipse.org/eclipselink/)

Tento repozitár je určený pre výučbu predmetu [B-VSA](https://uim.fei.stuba.sk/predmet/b-vsa/) vyučovaný na FEI STU
Bratislava počas letného semestra 2021/2022.

Aplikácia slúži ako ukážka kompletného riešenia, ktoré pokrýva učivo predmetu.

Pre demonštráciu problematiky cvičenie využíva databázu MySQL a JPA implementáciu EclipseLink. Jednotlivé triedy
aplikácie slúžia výhradne na demonštráciu problematiky.

## Inštalácia a spustenie

Cvičenie je implementované, ako [Maven](https://maven.apache.org/) projekt
pre [Java 1.8](https://openjdk.java.net/install/). Nakoľko cvičenie demonštruje prácu s databázou je potrebné mať
nainštalovanú databázu [MySQL 5.7+](https://www.mysql.com/).

### Nastavenie projektu

Projekt je možné otvoriť v ľubovolnom modernom IDE (testované na IntelliJ Idea a Visual Studio Code), podporujúci Maven
projekt manažment.

Pre kompiláciu projektu do JAR archívu je možné použiť príkaz:

```shell
mvn clean package verify
```

<!--
Projekt obsahuje aj základnú sadu testov pre demonštráciu možností implementácie. Pred spustením testov je potrebné mať
zapnutý MySQL server s vytvorenou databázou, ktorá je uvedená v
súbore [persistence.xml](src/main/resources/META-INF/persistence.xml)
(defaultne VSA). Testy je možné spustiť príkazom:

```shell
mvn test
```
-->

### Vytvorenie databázy

Pre správne otestovanie funkcionality aplikácie je potrebné mať nainštalovanú databázy MySQL vo verzií 5.7 a vyššie. Po
spustení databázové servera je potrebné vytvoriť databázu a používateľ pre potreby aplikácie.

Názov databázy a prihlasovacie údaje používateľa musia byť totožné s uvedenými v
súbor [persistence.xml](src/main/resources/META-INF/persistence.xml). Uvedený SQL skript pracuje s defaultnými
hodnotami.

```sql
CREATE DATABASE IF NOT EXISTS VSA CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS 'vsa'@'localhost' IDENTIFIED BY 'vsa';
GRANT ALL PRIVILEGES ON VSA.* TO 'vsa'@'localhost';
FLUSH PRIVILEGES;
```

Pre vytvorenie je možné použiť aj súbor [mysql-starter.sql](mysql-starter.sql), ktorý uvedený skript obsahuje pre
jednoduchšie spustenie v MySQL databázy.
