# language: en
# namespace: Cases
@cases
Feature: Ügyekhez tartozó tesztek

@cases-2-1 @cases-2-2 @cases-2-6
Scenario: Jövőbeni érvényességi dátummal egy új ügy sikeresen rögzíthető
	Given Cases: a felhasználó az új ügy rögzítési felületen van
	And Cases: a felhasználó kitöltötte az összes adatot
	When Cases: a felhasználó a holnapi napot adja meg érvényességi időnek
	And Cases: a felhasználó elmenti az új ügyet
	Then Cases: a felhasználó visszatér az ügyek oldalra
	And Cases: az új ügy megjelenik az ügyek táblázatban
