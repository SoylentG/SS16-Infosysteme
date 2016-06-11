# Thymio - Dijkstra

### Installation
* Projekt lokal speichern (Git Plugin Eclipse, als zip oder direkt klonen)
* In Eclipse importieren
* Controller Klasse als Applet starten

### Aktuelle Funktionen

   - Schachbrett mit randomisierten Hindernissen (anpassbar)
   - Steuerung von Thymio (grafisch) mit W A S D Tasten
   - Berechnung der Kosten zu umliegenden Feldern
   - Settings Klasse, in der man ein paar Einstellungen anpassen kann (Hindernisse, Größe, Bild etc.)
   - Empfehlung, welches Feld als nächstes angefahren werden sollte:
       - Vermeidet Hindernisse
       - Keine Orientierung am Zielpunkt
   - Speichert besuchte Felder und erkennt, wenn diese erneut angefahren werden
   - Thymio kann zu bestimmten Feldern geschickt werden, funktioniert aber noch nicht wirklich, war nur ein Test

### Todo:
Fertigstellung Dijkstra
  - Speicherung der aktuell verbrauchten Kosten
  - Zurückspringen auf letzes Feld wenn kein weiteres unbesuchtes Feld angefahren werden kann
  - Einbauen des echten Thymios

Optional:
- Koordinaten auf den Feldern anzeigen lassen, oder wie beim Schach daneben

