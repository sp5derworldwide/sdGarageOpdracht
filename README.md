checklist/stappenplan
1. definieer functionaliteit (welke methods, wat zijn je gebruikers etc.)
klant, administratief medewerker, kassa medewerker, backoffice medewerker, monteur, (auto?)
administratief medewerker: voegt de klant en de auto toe aan het systeem wanneer de klant
en/of de auto voor het eerst voor het eerst bij de garage komen.
kassa medewerker: bon genereren, de bon bevat keuring + bedrag vd handelingen + bedrag onderdelen
+ bedrag. bij alle bedragen moet het BTW tarief nog berekend worden voordat de bedragen
op de bon getoond worden. wanneer er is betaald wordt de status op betaald gezet.
backoffice medewerker: onderdelen toevoegen (naam, prijs, voorraad) aan het systeem
voorraden aanpassen en reparatiehandelingen (naam, prijs) toevoegen aan het systeem.
alle prijzen in het systeem zijn INCLUSIEF BTW.
2. use case diagram (type UML diagram, ff software voor opzoeken)
3. (user stories nog voor de klasse diagram) -> klasse diagram maken (modellen)
4. functioneel ontwerp (functionele requirements komen in de use case diagrammen)
5. technisch ontwerp (niet functionele reqs komen hierin EVT.)
6. bedenken welke endpoints ik wil (get, put, post, delete)
7. modellen programmeren
8. services programmeren
9. controllers programmeren
10. security implementeren
11. tests maken/schrijven/testen

**elke keer dat je iets afmaakt, testen, als soort rode draad

IN VOLGORDE BIJ WIJZIGINGEN
- git add . 
- git commit -m "*message*"
- git push